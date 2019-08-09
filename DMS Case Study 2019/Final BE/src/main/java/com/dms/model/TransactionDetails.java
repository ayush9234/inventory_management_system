package com.dms.model;

/**
 * The Class TransactionDetails.
 */
public class TransactionDetails {
	
	/** The transaction id. */
	private String transactionId;
	
	/** The product id. */
	private int productId;
	
	/** The quantity. */
	private int quantity;
	
	/** The cost. */
	private double cost;
	
	/** The product name. */
	private String productName;
	
	/**
	 * Gets the product id.
	 *
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}
	
	/**
	 * Sets the product id.
	 *
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Sets the quantity.
	 *
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * Sets the cost.
	 *
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
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
	 * Gets the product name.
	 *
	 * @return the product name
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Sets the product name.
	 *
	 * @param productName the new product name
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Instantiates a new transaction details.
	 *
	 * @param transactionId the transaction id
	 * @param productId the product id
	 * @param quantity the quantity
	 * @param cost the cost
	 * @param productName the product name
	 */
	public TransactionDetails(String transactionId, int productId, int quantity, double cost, String productName) {
		super();
		this.transactionId = transactionId;
		this.productId = productId;
		this.quantity = quantity;
		this.cost = cost;
		this.productName = productName;
	}	
	
	/**
	 * Instantiates a new transaction details.
	 */
	public TransactionDetails() {}
}
