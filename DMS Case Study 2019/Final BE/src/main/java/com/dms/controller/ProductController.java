package com.dms.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dms.constant.Constant;
import com.dms.exception.BADRequestException;
import com.dms.model.Product;
import com.dms.service.IProductService;

/**
 * The Class ProductController.
 */
@CrossOrigin(origins = Constant.URL)
@RestController
@RequestMapping("/product")

public class ProductController {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(ProductController.class);

	/** The product service. */
	@Autowired
	private IProductService productService;

	/**
	 * Gets the user by ID.
	 *
	 * @param productId the product id
	 * @return the user by ID
	 * @throws BADRequestException the BAD request
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductByID(@PathVariable("id") int productId) throws BADRequestException {
		LOG.info("inside getUserByID ");
		Product product = productService.getProductById(productId);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	/**
	 * Gets the products.
	 *
	 * @return the products
	 */
	@GetMapping
	public ResponseEntity<List<Product>> getProducts() {
		LOG.info("inside getProducts ");
		List<Product> list = productService.getProducts();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	/**
	 * Creates the product.
	 *
	 * @param product the product
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<Void> createProduct(@RequestBody Product product) {
		LOG.info("inside createProduct ");
		boolean flag = productService.addProduct(product);
		if (!flag) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	} 

	/**
	 * Update product.
	 *
	 * @param product the product
	 * @return the response entity
	 * @throws BADRequestException the BAD request
	 */
	@PutMapping
	public ResponseEntity<Product> updateProduct(@RequestBody Product product)  {
		LOG.info("inside updateProduct");
		productService.updateProduct(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
}
