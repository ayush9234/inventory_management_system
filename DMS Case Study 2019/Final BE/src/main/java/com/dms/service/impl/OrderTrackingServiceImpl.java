package com.dms.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dms.dao.IOrderTrackingDAO;
import com.dms.dto.TransactionDTO;
import com.dms.service.IOrderTrackingService;
import com.dms.service.ITransactionDetailsService;
import com.dms.service.ITransactionService;

/**
 * The Class OrderTrackingServiceImpl.
 */
@Service
public class OrderTrackingServiceImpl implements IOrderTrackingService {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(OrderTrackingServiceImpl.class);

	/** The order tracking DAO. */
	@Autowired
	private IOrderTrackingDAO orderTrackingDAO;

	/** The transaction DAO. */
	@Autowired
	private ITransactionService transactionService;

	/** The transaction details DAO. */
	@Autowired
	private ITransactionDetailsService transactionDetailsService;

	/**
	 * Gets the all orders.
	 *
	 * @param id the id
	 * @return the all orders
	 */
	@Override
	public List<TransactionDTO> getAllOrders(int id) {
		LOG.info("inside getAllOrders");
		return orderTrackingDAO.getAllOrders( id);
	}

	/**
	 * Adds the order.
	 *
	 * @param order the order
	 */
	@Transactional
	@Override
	public void addOrder(TransactionDTO order) {
		LOG.info(order);
		LOG.info("inside addOrder");
		order.setTransactionStatus("Pending");
		orderTrackingDAO.addOrder(order);
		transactionService.addTransaction(order);
		transactionDetailsService.addTransactionDetails(order);
	}
	
	/**
	 * Accept order.
	 *
	 * @param order the order
	 */
	@Override
	public void acceptOrder(TransactionDTO order) {
		LOG.info("inside accept order");
		orderTrackingDAO.acceptOrder(order);
	}

	@Override
	public boolean rejectOrder(TransactionDTO order) {
		return orderTrackingDAO.rejectOrder(order);
	}
	
	@Override
	public List<TransactionDTO> pendingOrders(int userId) {
		LOG.debug("inside pendingOrders");
		return orderTrackingDAO.pendingOrders(userId);
	}
}
