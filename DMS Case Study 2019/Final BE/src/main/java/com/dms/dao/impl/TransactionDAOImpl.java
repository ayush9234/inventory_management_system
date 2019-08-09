package com.dms.dao.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.dms.constant.Constant;
import com.dms.constant.Query;
import com.dms.dao.ITransactionDAO;
import com.dms.dto.TransactionDTO;
import com.dms.exception.BADRequestException;
import com.dms.model.Transaction;

/**
 * The Class TransactionDAOImpl.
 */
@Repository
public class TransactionDAOImpl implements ITransactionDAO {

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Gets the all transaction.
	 *
	 * @return the all transaction
	 */
	@Override
	public List<Transaction> getAllTransaction() {
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.ALL_TRANSACTION);
		List<Transaction> list = new ArrayList<>();
		while (srs.next()) {
			Transaction transaction = new Transaction();
			transaction.setTransactionId(srs.getString(Constant.TRANSACTION_ID));
			transaction.setBuyerName(srs.getString(Constant.BUYER_NAME));
			transaction.setSellerName(srs.getString(Constant.SELLER_NAME));
			transaction.setTotalPrice(srs.getDouble(Constant.TOTAL_PRICE));
			transaction.setCreationTime(srs.getTimestamp(Constant.CREATION_TIME));
			list.add(transaction);
		}
		return list;
	}  

	/**
	 * Gets the transaction by seller id.
	 *
	 * @param sellerId the seller id
	 * @return the transaction by seller id
	 */
	@Override
	public List<Transaction> getTransactionBySellerId(int sellerId) {
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.SELLER_TRANSACTION, sellerId);
		List<Transaction> list = new ArrayList<>();
		while (srs.next()) {
			Transaction transaction = new Transaction();
			transaction.setTransactionId(srs.getString(Constant.TRANSACTION_ID));
			transaction.setBuyerName(srs.getString(Constant.BUYER_NAME));
			transaction.setSellerName(srs.getString(Constant.SELLER_NAME));
			transaction.setTotalPrice(srs.getDouble(Constant.TOTAL_PRICE));
			transaction.setCreationTime(srs.getDate(Constant.CREATION_TIME));
			list.add(transaction);
		}
		return list;
	}

	/**
	 * Gets the transaction by buyer id.
	 *
	 * @param buyerId the buyer id
	 * @return the transaction by buyer id
	 */
	@Override
	public List<Transaction> getTransactionByBuyerId(int buyerId) {
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.BUYER_TRANSACTION, buyerId);
		List<Transaction> list = new ArrayList<>();
		while (srs.next()) {
			Transaction transaction = new Transaction();
			transaction.setTransactionId(srs.getString(Constant.TRANSACTION_ID));
			transaction.setBuyerName(srs.getString(Constant.BUYER_NAME));
			transaction.setSellerName(srs.getString(Constant.SELLER_NAME));
			transaction.setTotalPrice(srs.getDouble(Constant.TOTAL_PRICE));
			transaction.setCreationTime(srs.getDate(Constant.CREATION_TIME));
			list.add(transaction);
		}
		return list;
	}

	/**
	 * Adds the transaction.
	 *
	 * @param transaction the transaction
	 * @return true, if successful
	 */
	@Override
	public boolean addTransaction(TransactionDTO transaction) {
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.GET_SELLER_ID, transaction.getBuyerId());
		if (srs.next())
			transaction.setSellerId(srs.getInt(Constant.DISTRIBUTER_ID));
		else
			transaction.setSellerId(1);
		transaction.setBuyerName(getName(transaction.getBuyerId()));
		transaction.setSellerName(getName(transaction.getSellerId()));
		return jdbcTemplate.update(Query.ADD_TRANSACTION, transaction.getTransactionId(), transaction.getBuyerId(),
				transaction.getSellerId(), transaction.getBuyerName(), transaction.getSellerName(),
				transaction.getTotalPrice(), LocalDateTime.now()) > 0;
	}

	/**
	 * Gets the buyer id by transaction id.
	 *
	 * @param transactionId the transaction id
	 * @return the buyer id by transaction id
	 * @throws TransactionException the transaction exception
	 */
	@Override
	public int getBuyerIdByTransactionId(String transactionId)  {
		int buyerId = 0;
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.BUYER_BY_TRANSACTION_ID, transactionId);
		if (srs.next()) 
			buyerId = srs.getInt("buyer_id");
		return buyerId;
	}

	/**
	 * Gets the name.
	 *
	 * @param id the id
	 * @return the name
	 */
	@Override
	public String getName(int id) {
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.GET_USER_NAME, id);
		if (srs.next())
			return srs.getString("user_name");
		else
			return "fail";
	}

	/**
	 * Sell item.
	 *
	 * @param order the order
	 * @return true, if successful
	 */
	@Override
	public boolean sellItem(TransactionDTO order) {
		order.setSellerId(order.getBuyerId());
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.TRANSACTIONDETAIL_JOIN_TRANSACTION, order.getTransactionId());

		while (srs.next()) {
			SqlRowSet qty = jdbcTemplate.queryForRowSet(Query.GET_QUANTITY, srs.getString(Constant.PRODUCT_NAME),
					srs.getInt(Constant.BUYER_ID));
			if (qty.next() && qty.getInt(Constant.PRODUCT_QUANTITY) < srs.getInt(Constant.QUANTITY))
				throw new BADRequestException("Your inventory is less than requested");
			jdbcTemplate.update(Query.UPDATE_SELLER_INVENTORY, srs.getInt(Constant.QUANTITY), LocalDateTime.now(),
					srs.getString(Constant.PRODUCT_NAME), srs.getInt(Constant.BUYER_ID));
		}
		return true;
	}
	
	@Override
	public List<TransactionDTO> allTransactionOfUser(int userId) {
		List<TransactionDTO> list = new ArrayList<>();
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.ALL_TRANSACTION_OF_USER,userId,userId);
		while(srs.next()) {
			TransactionDTO transaction = new TransactionDTO();
			transaction.setTransactionId(srs.getString(Constant.TRANSACTION_ID));
			transaction.setBuyerName(srs.getString(Constant.BUYER_NAME));
			transaction.setSellerName(srs.getString(Constant.SELLER_NAME));
			transaction.setTotalPrice(srs.getDouble(Constant.TOTAL_PRICE));
			transaction.setTransactionStatus(srs.getString(Constant.TRANSACTION_STATUS));
			transaction.setCreationTime(srs.getTimestamp(Constant.CREATION_TIME));
			list.add(transaction);
		}
		return list;
	}
}
