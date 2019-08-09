package com.dms.service;

import java.util.List;
import com.dms.dto.TransactionDTO;
import com.dms.model.TransactionDetails;

/**
 * The Interface ITransactionDetailsService.
 */
public interface ITransactionDetailsService {

	/**
	 * Gets the transaction details.
	 *
	 * @param transactionId the transaction id
	 * @return the transaction details
	 */
	List<TransactionDetails> getTransactionDetails(String transactionId);

	/**
	 * Adds the transaction details.
	 *
	 * @param details the details
	 */
	void addTransactionDetails(TransactionDTO details);
}
