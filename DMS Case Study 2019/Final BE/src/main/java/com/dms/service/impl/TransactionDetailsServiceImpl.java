package com.dms.service.impl;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dms.dao.ITransactionDetailsDAO;
import com.dms.dto.TransactionDTO;
import com.dms.model.TransactionDetails;
import com.dms.service.ITransactionDetailsService;

/**
 * The Class TransactionDetailsServiceImpl.
 */
@Service
public class TransactionDetailsServiceImpl implements ITransactionDetailsService {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(TransactionDetailsServiceImpl.class);

	/** The transaction details DAO. */
	@Autowired
	private ITransactionDetailsDAO transactionDetailsDAO;

	/**
	 * Gets the transaction details.
	 *
	 * @param transactionId the transaction id
	 * @return the transaction details
	 */
	@Override
	public List<TransactionDetails> getTransactionDetails(String transactionId) {
		LOG.info("inside getTransactionDetails ");
		return transactionDetailsDAO.getTransactionDetails(transactionId);
	}

	/**
	 * Adds the transaction details.
	 *
	 * @param detail the detail
	 */
	@Override
	public void addTransactionDetails(TransactionDTO detail) {
		LOG.info("inside addTransactionDetails ");
		List<Map<String, String>> p = detail.getPlaceOrders();
		for(int i=0; i<p.size(); i++) {
			TransactionDetails td = new TransactionDetails();
			td.setTransactionId(detail.getTransactionId());
			td.setProductName(detail.getPlaceOrders().get(i).get("productName"));
			td.setQuantity(Integer.parseInt(detail.getPlaceOrders().get(i).get("quantity")));
			transactionDetailsDAO.addDetails(td);
		}
	}
}
