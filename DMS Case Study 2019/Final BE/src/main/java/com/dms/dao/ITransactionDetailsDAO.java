package com.dms.dao;

import java.util.List;
import com.dms.model.TransactionDetails;

/**
 * The Interface ITransactionDetailsDAO.
 */
public interface ITransactionDetailsDAO {

	/**
	 * Gets the transaction details.
	 *
	 * @param transactionId the transaction id
	 * @return the transaction details
	 */
	List<TransactionDetails> getTransactionDetails(String transactionId);

	/**
	 * Adds the details.
	 *
	 * @param details the details
	 * @return true, if successful
	 */
	boolean addDetails(TransactionDetails details);

	/**
	 * Gets the cost.
	 *
	 * @param product the product
	 * @return the cost
	 */
	double getCost(String product);

}
