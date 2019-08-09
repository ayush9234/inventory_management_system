package com.dms.testservice;

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
import org.springframework.test.context.junit4.SpringRunner;

import com.dms.dao.IProductDAO;
import com.dms.model.Product;
import com.dms.service.IProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProductService {
	
	@Autowired
	private IProductService productService;
	
	@MockBean
	private IProductDAO productDAO;
	
	private List<Product> list = new ArrayList<>();
	
	Product product = new Product(1,"SIM Card", "active",100.0,new Date(),new Date());

	private int productId = 1;
	
	@Test
	public void testGetProducts() {
		list.add(product);
		when(productDAO.getProducts()).thenReturn(list);
		assertEquals(list,productService.getProducts());
	}
	
	@Test
	public void testGetProductById() {
		when(productService.getProductById(productId)).thenReturn(product);
		assertEquals(product,productDAO.getProductById(productId));
	}

	@Test
	public void testAddProductPositive() {
		when(productDAO.addProduct(product)).thenReturn(true);
		assertEquals(true,productService.addProduct(product));
	}
}
