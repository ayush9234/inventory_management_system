package com.dms.testcontroller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.dms.controller.ProductController;
import com.dms.model.Product;
import com.dms.service.IProductService;

/**
 * The Class TestProductController.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProductController {

	/** The product service. */
	@MockBean
	private IProductService productService;
	
	/** The product controller. */
	@Autowired
	private ProductController productController;
	
	/** The list. */
	private List<Product> list = new ArrayList<>();
	
	/** The product. */
	Product product = new Product(1,"SIM Card", "active",100.0,new Date(),new Date());

	/** The product id. */
	private int productId = 1;
	
	/**
	 * Test get product by id.
	 */
	@Test
	public void testGetProductById() {
		when(productService.getProductById(productId)).thenReturn(product);
		assertEquals(new ResponseEntity<>(product,HttpStatus.OK),productController.getProductByID(productId));
	}
	
	/**
	 * Test get products.
	 */
	@Test
	public void testGetProducts() {
		list.add(product);
		when(productService.getProducts()).thenReturn(list);
		assertEquals(new ResponseEntity<>(list,HttpStatus.OK),productController.getProducts());
	}
	
	/**
	 * Test update product.
	 */
	@Test
	public void testUpdateProduct() {
		when(productService.updateProduct(product)).thenReturn(true);
		assertEquals(new ResponseEntity<>(product,HttpStatus.OK),productController.updateProduct(product));
	}
}
