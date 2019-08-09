package com.dms.testdao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dms.dao.IProductDAO;
import com.dms.model.Product;

/**
 * The Class TestProductDAOImpl.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProductDAOImpl {
	
	/** The product DAO. */
	@Autowired
	private IProductDAO productDAO;
	
	/** The product. */
	private Product product = new Product(1, "SIM Card", "active", 10, new Date(), new Date());
	
	/**
	 * Test add product.
	 */
	@Test
	public void testAddProduct() {
		assertEquals(true, productDAO.addProduct(product));
	}

	/**
	 * Test update product.
	 */
	@Test
	public void testUpdateProduct() {
		assertEquals(true, productDAO.updateProduct(product));
	}

}
