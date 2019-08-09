package com.dms.model;

import java.time.LocalDateTime;

/**
 * The Class Inventory.
 */
public class Inventory {

	/** The user id. */
	private int userId;

	/** The product id. */
	private int productId;

	/** The product name. */
	private String productName;

	/** The product quantity. */
	private int productQuantity;

	/** The monetary value. */
	private double monetaryValue;

	/** The creation time. */
	private LocalDateTime creationTime;

	/** The updation time. */
	private LocalDateTime updationTime;

	/**
	 * Gets the user id.
	 *
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
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
	 * Gets the product quantity.
	 *
	 * @return the product_quantity
	 */
	public int getProductQuantity() {
		return productQuantity;
	}

	/**
	 * Sets the product quantity.
	 *
	 * @param productQuantity the productQuantity to set
	 */
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	/**
	 * Gets the monetary value.
	 *
	 * @return the monetaryValue
	 */
	public double getMonetaryValue() {
		return monetaryValue;
	}

	/**
	 * Sets the monetary value.
	 *
	 * @param d the monetaryValue to set
	 */
	public void setMonetaryValue(double d) {
		this.monetaryValue = d;
	}

	/**
	 * Gets the creation time.
	 *
	 * @return the creationTime
	 */
	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	/**
	 * Sets the creation time.
	 *
	 * @param creationTime the creationTime to set
	 */

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * Gets the updation time.
	 *
	 * @return the updationTime
	 */
	public LocalDateTime getUpdationTime() {
		return updationTime;
	}

	/**
	 * Sets the updation time.
	 *
	 * @param updationTime the updationTime to set
	 */
	public void setUpdationTime(LocalDateTime updationTime) {
		this.updationTime = updationTime;
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
	 * Instantiates a new inventory.
	 *
	 * @param userId the user id
	 * @param productId the product id
	 * @param productName the product name
	 * @param productQuantity the product quantity
	 * @param monetaryValue the monetary value
	 * @param creationTime the creation time
	 * @param updationTime the updation time
	 */
	public Inventory(int userId, int productId, String productName, int productQuantity, double monetaryValue,
			LocalDateTime creationTime, LocalDateTime updationTime) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.monetaryValue = monetaryValue;
		this.creationTime = creationTime;
		this.updationTime = updationTime;
	}

	/**
	 * Instantiates a new inventory.
	 */
	public Inventory() {
		super();
	}

	
}
