package com.dms.dto;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * The Class TransactionDTO.
 */
public class TransactionDTO {

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

	/** The product id. */
	private int productId;

	/** The product name. */
	private String productName;

	/** The quantity. */
	private int quantity;

	/** The cost. */
	private double cost;

	/** The seller name. */
	private String sellerName;

	/** The transaction status. */
	private String transactionStatus;

	/** The updation time. */
	private Date updationTime;

	/** The place orders. */
	private List<Map<String, String>> placeOrders;

	/**
	 * Gets the place orders.
	 *
	 * @return the place orders
	 */
	public List<Map<String, String>> getPlaceOrders() {
		return placeOrders;
	}

	/**
	 * Sets the place orders.
	 *
	 * @param placeOrders the place orders
	 */
	public void setPlaceOrders(List<Map<String, String>> placeOrders) {
		this.placeOrders = placeOrders;
	}

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
	 * Gets the buyer id.
	 *
	 * @return the buyer id
	 */
	public int getBuyerId() {
		return buyerId;
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
	 * Sets the buyer id.
	 *
	 * @param buyerId the new buyer id
	 */
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
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
	 * Sets the creation time.
	 *
	 * @param creationTime the new creation time
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

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
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "TransactionDTO [transactionId=" + transactionId + ", buyerId=" + buyerId + ", sellerId=" + sellerId
				+ ", totalPrice=" + totalPrice + ", creationTime=" + creationTime + ", buyerName=" + buyerName
				+ ", productId=" + productId + ", quantity=" + quantity + ", cost=" + cost + ", sellerName="
				+ sellerName + ", transactionStatus=" + transactionStatus + ", updationTime=" + updationTime
				+ ", details=" + placeOrders + "]";
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
	 * Instantiates a new transaction DTO.
	 *
	 * @param transactionId the transaction id
	 * @param buyerId the buyer id
	 * @param sellerId the seller id
	 * @param totalPrice the total price
	 * @param creationTime the creation time
	 * @param buyerName the buyer name
	 * @param productId the product id
	 * @param productName the product name
	 * @param quantity the quantity
	 * @param cost the cost
	 * @param sellerName the seller name
	 * @param transactionStatus the transaction status
	 * @param updationTime the updation time
	 * @param placeOrders the place orders
	 */
	public TransactionDTO(String transactionId, int buyerId, int sellerId, double totalPrice, Date creationTime,
			String buyerName, int productId, String productName, int quantity, double cost, String sellerName,
			String transactionStatus, Date updationTime, List<Map<String, String>> placeOrders) {
		super();
		this.transactionId = transactionId;
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.totalPrice = totalPrice;
		this.creationTime = creationTime;
		this.buyerName = buyerName;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.cost = cost;
		this.sellerName = sellerName;
		this.transactionStatus = transactionStatus;
		this.updationTime = updationTime;
		this.placeOrders = placeOrders;
	}
	
	/**
	 * Instantiates a new transaction DTO.
	 */
	public TransactionDTO() {}
	
	
}
