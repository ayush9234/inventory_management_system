package com.dms.model;

import java.util.Date;

/**
 * The Class Product.
 */
public class Product {

	/** The product id. */
	private int productId;

	/** The product name. */
	private String productName;

	/** The product status. */
	private String productStatus;
	
	/** The product cost. */
	private double productCost;
	
	/** The creation time. */
	private Date creationTime;
	
	/** The updation time. */
	private Date updationTime;
	
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
	 * Gets the product name.
	 *
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	
	/**
	 * Sets the product name.
	 *
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	/**
	 * Gets the product status.
	 *
	 * @return the productStatus
	 */
	public String getProductStatus() {
		return productStatus;
	}
	
	/**
	 * Sets the product status.
	 *
	 * @param productStatus the productStatus to set
	 */
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	
	/**
	 * Gets the product cost.
	 *
	 * @return the productCost
	 */
	public double getProductCost() {
		return productCost;
	}
	
	/**
	 * Sets the product cost.
	 *
	 * @param productCost the productCost to set
	 */
	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}
	
	/**
	 * Gets the creation time.
	 *
	 * @return the creationTime
	 */
	public Date getCreationTime() {
		return creationTime;
	}
	
	/**
	 * Sets the creation time.
	 *
	 * @param creationTime the creationTime to set
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	
	/**
	 * Gets the updation time.
	 *
	 * @return the updationTime
	 */
	public Date getUpdationTime() {
		return updationTime;
	}
	
	/**
	 * Sets the updation time.
	 *
	 * @param updationTime the updationTime to set
	 */
	public void setUpdationTime(Date updationTime) {
		this.updationTime = updationTime;
	}

	/**
	 * Instantiates a new product.
	 *
	 * @param productId the product id
	 * @param productName the product name
	 * @param productStatus the product status
	 * @param productCost the product cost
	 * @param creationTime the creation time
	 * @param updationTime the updation time
	 */
	public Product(int productId, String productName, String productStatus, double productCost, Date creationTime,
			Date updationTime) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productStatus = productStatus;
		this.productCost = productCost;
		this.creationTime = creationTime;
		this.updationTime = updationTime;
	}


	/**
	 * Instantiates a new product.
	 */
	public Product() {}
}
