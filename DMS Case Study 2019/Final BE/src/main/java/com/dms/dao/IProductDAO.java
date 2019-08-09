package com.dms.dao;

import java.util.List;

import com.dms.exception.BADRequestException;
import com.dms.model.Product;

/**
 * The Interface IProductDAO.
 */
public interface IProductDAO {

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
	 * Product exists.
	 *
	 * @param name the name
	 * @return true, if successful
	 */
	boolean productExists(String name);

	/**
	 * Disable product.
	 *
	 * @param product the product
	 * @return true, if successful
	 */
	boolean updateProduct(Product product);
}
