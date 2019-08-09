package com.dms.dao;

import java.util.List;

import com.dms.dto.TransactionDTO;
import com.dms.exception.BADRequestException;
import com.dms.model.OrderTracking;

/**
 * The Interface IOrderTrackingDAO.
 */
public interface IOrderTrackingDAO {

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
	 * @return true, if successful
	 */
	boolean addOrder(TransactionDTO order);

	/**
	 * Accept order.
	 *
	 * @param order the order
	 */
	void acceptOrder(TransactionDTO order);

	/**
	 * Gets the list by pending status.
	 *
	 * @return the list by pending status
	 * @throws BADRequestException the BAD request
	 */
	List<OrderTracking> getListByPendingStatus() throws BADRequestException;

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
