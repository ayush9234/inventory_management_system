package com.dms.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dms.dao.IProductDAO;
import com.dms.model.Product;
import com.dms.service.IProductService;

/**
 * The Class ProductServiceImpl.
 * 
 * 
 */
@Service
public class ProductServiceImpl implements IProductService{

	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(ProductServiceImpl.class);

	/** The product DAO. */
	@Autowired
	private IProductDAO productDAO;

	/**
	 * Gets the products.
	 *
	 * @return the products
	 */
	@Override
	public List<Product> getProducts() {
		LOG.info("Getting all products ");

		return productDAO.getProducts();
	}

	/**
	 * Adds the product.
	 *
	 * @param product the product
	 * @return true, if successful
	 */
	@Override
	public boolean addProduct(Product product) {
		if(productDAO.productExists(product.getProductName()))
			return false;
		else {
			productDAO.addProduct(product);
			LOG.info("Product added");
			return true;
		}		
	}

	/**
	 * Gets the product by id.
	 *
	 * @param productId the product id
	 * @return the product by id
	 * @throws ProductException the product exception
	 */
	@Override
	public Product getProductById(int productId){
		LOG.info("inside getProduct by id ");
		return productDAO.getProductById(productId);
	}
	
	/**
	 * Update product.
	 *
	 * @param product the product
	 * @return true, if successful
	 * @throws ProductException the product exception
	 */
	@Transactional
	@Override
	public boolean updateProduct(Product product) {
		productDAO.getProductById(product.getProductId());
		productDAO.updateProduct(product);
		LOG.info("inside updateProduct ");
		return true;
	}
}
