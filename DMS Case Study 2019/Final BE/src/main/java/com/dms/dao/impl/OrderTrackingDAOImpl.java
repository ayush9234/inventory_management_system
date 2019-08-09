package com.dms.dao.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.dms.constant.Constant;
import com.dms.constant.Query;
import com.dms.dao.IOrderTrackingDAO;
import com.dms.dao.IUserDAO;
import com.dms.dto.TransactionDTO;
import com.dms.exception.BADRequestException;
import com.dms.model.OrderTracking;
import com.dms.service.impl.EmailService;

/**
 * The Class OrderTrackingDAOImpl.
 */
@Repository
public class OrderTrackingDAOImpl implements IOrderTrackingDAO {

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EmailService emailService;
	@Autowired
	private IUserDAO userDao;
	
	/**
	 * Gets the all orders.
	 *
	 * @param id the id
	 * @return the all orders
	 */
	@Override
	public List<TransactionDTO> getAllOrders(int id) {
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.GET_ALL_ORDERS, "Pending", id);
		List<TransactionDTO> list = new ArrayList<>();
		while (srs.next()) {
			TransactionDTO order = new TransactionDTO();
			order.setTransactionId(srs.getString(Constant.TRANSACTION_ID));
			order.setBuyerName(srs.getString(Constant.BUYER_NAME));
			order.setCreationTime(srs.getTimestamp(Constant.CREATION_TIME));
			order.setUpdationTime(srs.getTimestamp(Constant.UPDATION_TIME));
			order.setTotalPrice(srs.getDouble(Constant.TOTAL_PRICE));
			list.add(order);
		}
		return list;
	}

	/**
	 * Adds the order.
	 *
	 * @param order the order
	 * @return true, if successful
	 */
	@Override
	public boolean addOrder(TransactionDTO order) {
		String transactionId = UUID.randomUUID().toString();
		order.setTransactionId(transactionId);
		String email = userDao.getEmailId(order.getBuyerId());
		emailService.sendMail(email,Constant.SUBJECT,Constant.BUYER_BODY+ transactionId);
		email =userDao.getEmailId(order.getSellerId());
		emailService.sendMail(email, "your have a new order", "this is mail to share transactionId of new order you got. /n Your transactionId is " + transactionId);
		return jdbcTemplate.update(Query.ADD_ORDER, order.getTransactionId(), order.getTransactionStatus(),
				LocalDateTime.now()) > 0;
	}

	/**
	 * Accept order.
	 *
	 * @param order the order
	 */
	@Override
	public void acceptOrder(TransactionDTO order) {
        SqlRowSet srs1 = jdbcTemplate.queryForRowSet(Query.GET_SELLER_ID, order.getBuyerId());
        if (srs1.next())
            order.setSellerId(srs1.getInt(Constant.DISTRIBUTER_ID));
        else
            order.setSellerId(1);
		jdbcTemplate.update(Query.ACCEPT_ORDER, "Accepted", LocalDateTime.now(), order.getTransactionId());
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.TRANSACTIONDETAIL_JOIN_TRANSACTION, order.getTransactionId());
		while (srs.next()) {
			SqlRowSet qty = jdbcTemplate.queryForRowSet(Query.GET_QUANTITY, srs.getString(Constant.PRODUCT_NAME),srs.getInt(Constant.SELLER_ID));
			if(qty.next() && qty.getInt(Constant.PRODUCT_QUANTITY) < srs.getInt(Constant.QUANTITY)) 
				throw new BADRequestException("Inventory is low");
			jdbcTemplate.update(Query.UPDATE_BUYER_INVENTORY, srs.getInt(Constant.QUANTITY), LocalDateTime.now(),
					srs.getString(Constant.PRODUCT_NAME), srs.getInt(Constant.BUYER_ID));
			jdbcTemplate.update(Query.UPDATE_SELLER_INVENTORY, srs.getInt(Constant.QUANTITY), LocalDateTime.now(),
					srs.getString(Constant.PRODUCT_NAME), srs.getInt(Constant.SELLER_ID));
		}
		String email = userDao.getEmailId(order.getBuyerId());
		emailService.sendMail(email,Constant.SUBJECT,Constant.ORDER_ACCEPTED);
	}
 
	/**
	 * Get list of pending status .
	 *
	 * @return the list by pending status
	 * @throws BADRequestException the BAD request
	 */
	@Override
	public List<OrderTracking> getListByPendingStatus() throws BADRequestException {
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.PENDING_ORDERS_LIST, "Pending");
		List<OrderTracking> list = new ArrayList<>();
		while (srs.next()) {
			OrderTracking order = new OrderTracking();
			order.setTransactionId(srs.getString(Constant.TRANSACTION_ID));
			order.setTransactionStatus(srs.getString(Constant.TRANSACTION_STATUS));
			order.setUpdationTime(srs.getDate(Constant.UPDATION_TIME));
			list.add(order);
		}
		return list;
	}
	
	/**
	 * Reject order.
	 *
	 * @param order the order
	 */
	@Override
	public boolean rejectOrder(TransactionDTO order) {
		if(jdbcTemplate.update(Query.ACCEPT_ORDER, "Rejected", LocalDateTime.now(), order.getTransactionId())>0)
			return true;
		return false;
	}
	
	@Override
	public List<TransactionDTO> pendingOrders(int userId) {
		List<TransactionDTO> list = new ArrayList<>();
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.PENDING_ORDERS_FOR_ID,userId);
		while(srs.next()) {
			TransactionDTO order = new TransactionDTO();
			order.setTransactionId(srs.getString(Constant.TRANSACTION_ID));
			order.setBuyerName(srs.getString(Constant.BUYER_NAME));
			order.setSellerName(srs.getString(Constant.SELLER_NAME));
			order.setCreationTime(srs.getTimestamp(Constant.CREATION_TIME));
			order.setTransactionStatus(srs.getString(Constant.TRANSACTION_STATUS));
			order.setUpdationTime(srs.getTimestamp(Constant.UPDATION_TIME));
			list.add(order);
		}
		return list;
	} 
}
