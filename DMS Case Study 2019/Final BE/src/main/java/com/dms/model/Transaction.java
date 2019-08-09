package com.dms.model;

import java.util.Date;

/**
 * The Class Transaction.
 */

public class Transaction {

	/** The transaction id. */
	private String transactionId;

	/** The buyer id. */
	private int buyerId;

	/** The seller id. */
	private int sellerId;

	/** The total price. */
	private double totalPrice;

	/** The creation time. */
	private Date creationTime;

	/** The buyer name. */
	private String buyerName;

	/** The seller name. */
	private String sellerName;

	/**
	 * Gets the buyer name.
	 *
	 * @return the buyer name
	 */
	public String getBuyerName() {
		return buyerName;
	}

	/**
	 * Sets the buyer name.
	 *
	 * @param buyerName the new buyer name
	 */
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	/**
	 * Gets the seller name.
	 *
	 * @return the seller name
	 */
	public String getSellerName() {
		return sellerName;
	}

	/**
	 * Sets the seller name.
	 *
	 * @param sellerName the new seller name
	 */
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	/**
	 * Sets the creation time.
	 *
	 * @param creationTime the new creation time
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * Gets the buyer id.
	 *
	 * @return the buyer id
	 */
	public int getBuyerId() {
		return buyerId;
	}

	/**
	 * Sets the buyer id.
	 *
	 * @param buyerId the new buyer id
	 */
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	/**
	 * Gets the seller id.
	 *
	 * @return the seller id
	 */
	public int getSellerId() {
		return sellerId;
	}

	/**
	 * Sets the seller id.
	 *
	 * @param sellerId the new seller id
	 */
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	/**
	 * Gets the total price.
	 *
	 * @return the total price
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Sets the total price.
	 *
	 * @param totalPrice the new total price
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * Gets the creation time.
	 *
	 * @return the creation time
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * Creation.
	 *
	 * @param date the date
	 */
	public void creation(Date date) {
		this.creationTime = date;
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
	 * Instantiates a new transaction.
	 *
	 * @param transactionId the transaction id
	 * @param buyerId the buyer id
	 * @param sellerId the seller id
	 * @param totalPrice the total price
	 * @param creationTime the creation time
	 * @param buyerName the buyer name
	 * @param sellerName the seller name
	 */
	public Transaction(String transactionId, int buyerId, int sellerId, double totalPrice, Date creationTime,
			String buyerName, String sellerName) {
		super();
		this.transactionId = transactionId;
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.totalPrice = totalPrice;
		this.creationTime = creationTime;
		this.buyerName = buyerName;
		this.sellerName = sellerName;
	}
	
	/**
	 * Instantiates a new transaction.
	 */
	public Transaction() {}
}
