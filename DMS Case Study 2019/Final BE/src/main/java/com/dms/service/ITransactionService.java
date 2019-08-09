package com.dms.service;

import java.util.List;

import com.dms.dto.TransactionDTO;
import com.dms.model.Transaction;

/**
 * The Interface ITransactionService.
 */
public interface ITransactionService {
	
	/**
	 * Gets the all transaction.
	 *
	 * @return the all transaction
	 */
	List<Transaction> getAllTransaction();

	/**
	 * Gets the transaction by seller id.
	 *
	 * @param sellerId the seller id
	 * @return the transaction by seller id
	 */
	List<Transaction> getTransactionBySellerId(int sellerId);

	/**
	 * Gets the transaction by buyer id.
	 *
	 * @param buyerId the buyer id
	 * @return the transaction by buyer id
	 */
	List<Transaction> getTransactionByBuyerId(int buyerId);

	/**
	 * Adds the transaction.
	 *
	 * @param transaction the transaction
	 * @return true, if successful
	 */
	boolean addTransaction(TransactionDTO transaction);

    /** Sell item.
     *
     * @param order
     *            the order
     * @return true, if successful */
    boolean sellItem(TransactionDTO order);
    
    /**
     * All transaction of user.
     *
     * @param userId the user id
     * @return the list
     */
    List<TransactionDTO> allTransactionOfUser(int userId);
}