package com.dms.service.impl;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dms.dao.IOrderTrackingDAO;
import com.dms.dao.ITransactionDAO;
import com.dms.dto.TransactionDTO;
import com.dms.model.Transaction;
import com.dms.service.ITransactionDetailsService;
import com.dms.service.ITransactionService;

/**
 * The Class TransactionServiceImpl.
 */
@Service
public class TransactionServiceImpl implements ITransactionService {
	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(TransactionServiceImpl.class);


	/** The transaction DAO. */
	@Autowired
    private ITransactionDAO transactionDAO;

    @Autowired
    private ITransactionDetailsService transactionDetailsService;

    @Autowired
    private IOrderTrackingDAO orderTrackingDAO;

    @Autowired
    private ITransactionService transactionService;

	/**
	 * Gets the all transaction.
	 *
	 * @return the all transaction
	 */
	@Override
	public List<Transaction> getAllTransaction() {
		LOG.info("inside getAllTransaction ");

		return transactionDAO.getAllTransaction();
	}

	/**
	 * Gets the transaction by seller id.
	 *
	 * @param sellerId the seller id
	 * @return the transaction by seller id
	 */
	@Override
	public List<Transaction> getTransactionBySellerId(int sellerId) {
		LOG.info("inside getTransactionBySellerId ");

		return transactionDAO.getTransactionBySellerId(sellerId);
	}

	/**
	 * Gets the transaction by buyer id.
	 *
	 * @param buyerId the buyer id
	 * @return the transaction by buyer id
	 */
	@Override
	public List<Transaction> getTransactionByBuyerId(int buyerId) {
		LOG.info("inside getTransactionByBuyerId ");
		return transactionDAO.getTransactionByBuyerId(buyerId);
	}

	/**
	 * Adds the transaction.
	 *
	 * @param transaction the transaction
	 */
	@Override
	public boolean addTransaction(TransactionDTO transaction) {
		double temp = transaction.getTotalPrice() + transaction.getCost();
		transaction.setTotalPrice(temp);
		LOG.info("inside addTransaction");
		transactionDAO.addTransaction(transaction);
		return true;
	}

    /** Sell item.
     *
     * @param order
     *            the order
     * @return true, if successful */
    @Transactional
    @Override
    public boolean sellItem(TransactionDTO order) {
    	LOG.info("inside sellItem");
        String transactionId = UUID.randomUUID().toString();
        order.setTransactionId(transactionId);
        order.setTransactionStatus("accepted");
        orderTrackingDAO.addOrder(order);
        transactionService.addTransaction(order);
        transactionDetailsService.addTransactionDetails(order);
        transactionDAO.sellItem(order);
        return true;
    }
    
    /**
	 * Gets the transaction by user id.
	 *
	 * @param userId the user Id
	 * @return the transaction by user id
	 */
    public List<TransactionDTO> allTransactionOfUser(int userId){
    	LOG.info("inside allTransactionOfUser");
    	return transactionDAO.allTransactionOfUser(userId);
    }
}
