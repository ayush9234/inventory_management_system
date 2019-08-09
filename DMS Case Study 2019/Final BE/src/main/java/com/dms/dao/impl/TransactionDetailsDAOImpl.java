package com.dms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.dms.constant.Constant;
import com.dms.constant.Query;
import com.dms.dao.ITransactionDetailsDAO;
import com.dms.model.TransactionDetails;

/**
 * * The Class TransactionDetailsDAOImpl.
 */
@Repository
public class TransactionDetailsDAOImpl implements ITransactionDetailsDAO {

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Gets the transaction details.
	 *
	 * @param transactionId the transaction id
	 * @return the transaction details
	 */
	@Override
	public List<TransactionDetails> getTransactionDetails(String transactionId) {
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.TRANSACTION_DETAIL, transactionId);
		List<TransactionDetails> list = new ArrayList<>();
		while (srs.next()) {
			TransactionDetails transactionDetails = new TransactionDetails();
			transactionDetails.setTransactionId(srs.getString(Constant.TRANSACTION_ID));
			transactionDetails.setProductName(srs.getString(Constant.PRODUCT_NAME));
			transactionDetails.setQuantity(srs.getInt(Constant.QUANTITY));
			transactionDetails.setCost(srs.getDouble(Constant.COST));
			list.add(transactionDetails);
		}
		return list;
	}

	/**
	 * Adds the details.
	 *
	 * @param details the details
	 * @return true, if successful
	 */
	@Override
	public boolean addDetails(TransactionDetails details) {
		details.setCost(getCost(details.getProductName()));
		return jdbcTemplate.update(Query.ADD_TRANSACTION_DETAIL, details.getTransactionId(), details.getProductName(), details.getQuantity(),
				details.getCost()) > 0;
	}

	/**
	 * Gets the cost.
	 *
	 * @param product the product
	 * @return the cost
	 */
	@Override
	public double getCost(String product) {
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.COST_OF_PRODUCT, product);
		if (srs.next())
            return srs.getDouble(Constant.PRODUCT_COST);
		else
			return 0;
	}
}
