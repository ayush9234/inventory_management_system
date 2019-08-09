package com.dms.service;

import java.util.List;

import com.dms.dto.TransactionDTO;

/**
 * The Interface IOrderTrackingService.
 */
public interface IOrderTrackingService {
	
	/**
	 * Gets the all orders.
	 *
	 * @param id the id
	 * @return the all orders
	 */
	List<TransactionDTO> getAllOrders(int id);
	
	/**
	 * Adds the order.
	 *
	 * @param order the order
	 */
	void addOrder(TransactionDTO order);

	/**
	 * Accept order.
	 *
	 * @param order the order
	 */
	void acceptOrder(TransactionDTO order);
	
	/**
	 * Reject order.
	 *
	 * @param order the order
	 * @return true, if successful
	 */
	boolean rejectOrder(TransactionDTO order);

	/**
	 * Pending orders.
	 *
	 * @param userId the user id
	 * @return the list
	 */
	List<TransactionDTO> pendingOrders(int userId);
}
