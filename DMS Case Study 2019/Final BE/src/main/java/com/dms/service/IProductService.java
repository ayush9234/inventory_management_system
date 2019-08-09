package com.dms.service;

import java.util.List;

import com.dms.exception.BADRequestException;
import com.dms.model.Product;

/**
 * The Interface IProductService.
 */
public interface IProductService {

	/**
	 * Gets the products.
	 *
	 * @return the products
	 */
	List<Product> getProducts();

	/**
	 * Gets the product by id.
	 *
	 * @param productId the product id
	 * @return the product by id
	 * @throws BADRequestException the BAD request
	 */
	Product getProductById(int productId) throws BADRequestException;

	/**
	 * Adds the product.
	 *
	 * @param product the product
	 * @return true, if successful
	 */
	boolean addProduct(Product product);

	/**
	 * Update product.
	 *
	 * @param product the product
	 * @return true, if successful
	 * @throws BADRequestException the BAD request
	 */
	boolean updateProduct(Product product) throws BADRequestException;
}
