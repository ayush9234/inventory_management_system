package com.dms.dao.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.dms.constant.Constant;
import com.dms.constant.Query;
import com.dms.dao.IProductDAO;
import com.dms.exception.BADRequestException;
import com.dms.model.Product;

/**
 * The Class ProductDAOImpl.
 */
@Repository
public class ProductDAOImpl implements IProductDAO {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(ProductDAOImpl.class);

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Gets the products.
	 *
	 * @return the products
	 */
	@Override
	public List<Product> getProducts() {
		LOG.info("inside getProducts()");
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.GET_ALL_PRODUCTS);
		List<Product> list = new ArrayList<>();
		while (srs.next()) {
			Product product = new Product();
			product.setProductId(srs.getInt(Constant.PRODUCT_ID));
			product.setProductName(srs.getString(Constant.PRODUCT_NAME));
			product.setProductStatus(srs.getString(Constant.PRODUCT_STATUS));
			product.setProductCost(srs.getDouble(Constant.PRODUCT_COST));
			product.setCreationTime(srs.getDate(Constant.CREATION_TIME));
			product.setUpdationTime(srs.getDate(Constant.UPDATION_TIME));
			list.add(product);
		}
		return list;
	}

	/**
	 * Gets the product by id.
	 *
	 * @param productId the product id
	 * @return the product by id
	 * @throws BADRequestException the BAD request
	 */
	@Override
	public Product getProductById(int productId) {
		LOG.info("inside getProductById()");
		Product product = new Product();
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.PRODUCT_BY_ID, productId);
		if (srs.next()) {
			product.setProductId(srs.getInt(Constant.PRODUCT_ID));
			product.setProductName(srs.getString(Constant.PRODUCT_NAME));
			product.setProductCost(srs.getDouble(Constant.PRODUCT_COST));
			product.setProductStatus(srs.getString(Constant.PRODUCT_STATUS));
		}
		return product;
	}

	/**
	 * Adds the product.
	 *
	 * @param product the product
	 * @return true, if successful
	 */
	@Override
	public boolean addProduct(Product product) {
		LocalDateTime now = LocalDateTime.now();
		return jdbcTemplate.update(Query.ADD_PRODUCT, product.getProductName(), product.getProductStatus(),
				product.getProductCost(), now, now) > 0;
	}

	/**
	 * Product exists.
	 *
	 * @param name the name
	 * @return true, if successful
	 */
	@Override
	public boolean productExists(String name) {
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.PRODUCT_EXIST, name);
		int count = 0;
		if (srs.next()) {
			count++;
		}
		return count > 0 ? true : false;
	}

	/**
	 * Update product.
	 *
	 * @param product the product
	 * @return true, if successful
	 */
	@Override
	public boolean updateProduct(Product product) {
		LocalDateTime now = LocalDateTime.now();
		return jdbcTemplate.update(Query.UPDATE_PRODUCT, product.getProductName(), product.getProductStatus(),
				product.getProductCost(), now, product.getProductId()) > 0;
	}
}
