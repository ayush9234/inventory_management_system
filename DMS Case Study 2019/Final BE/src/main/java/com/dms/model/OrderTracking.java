package com.dms.model;

import java.util.Date;

/**
 * The Class OrderTracking.
 */
public class OrderTracking {

	/** The transaction id. */
	private String transactionId;
	
	/** The transaction status. */
	private String transactionStatus;
	
	/** The updation time. */
	private Date updationTime;

	/**
	 * Gets the transaction status.
	 *
	 * @return the transaction status
	 */
	public String getTransactionStatus() {
		return transactionStatus;
	}

	/**
	 * Sets the transaction status.
	 *
	 * @param transactionStatus the new transaction status
	 */
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	/**
	 * Gets the updation time.
	 *
	 * @return the updation time
	 */
	public Date getUpdationTime() {
		return updationTime;
	}

	/**
	 * Sets the updation time.
	 *
	 * @param updationTime the new updation time
	 */
	public void setUpdationTime(Date updationTime) {
		this.updationTime = updationTime;
	}

	/**
	 * Gets the transaction id.
	 *
	 * @return the transaction id
	 */
	public String getTransactionId() {
		return transactionId;
	}

	
	/**
	 * Sets the transaction id.
	 *
	 * @param transactionId the new transaction id
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * Instantiates a new order tracking.
	 *
	 * @param transactionId the transaction id
	 * @param transactionStatus the transaction status
	 * @param updationTime the updation time
	 */
	public OrderTracking(String transactionId, String transactionStatus, Date updationTime) {
		super();
		this.transactionId = transactionId;
		this.transactionStatus = transactionStatus;
		this.updationTime = updationTime;
	}

	/**
	 * Instantiates a new order tracking.
	 */
	public OrderTracking() {}
	
}
