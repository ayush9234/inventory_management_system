package com.dms.dao;

import java.util.List;

import org.hibernate.TransactionException;

import com.dms.dto.TransactionDTO;
import com.dms.model.Transaction;

/**
 * The Interface ITransactionDAO.
 */
public interface ITransactionDAO {
	
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
	
	/**
	 * Gets the name.
	 *
	 * @param id the id
	 * @return the name
	 */
	String getName(int id);

	/**
	 * Gets the buyer id by transaction id.
	 *
	 * @param transactionId the transaction id
	 * @return the buyer id by transaction id
	 * @throws TransactionException the transaction exception
	 */
	int getBuyerIdByTransactionId(String transactionId) throws TransactionException;

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
