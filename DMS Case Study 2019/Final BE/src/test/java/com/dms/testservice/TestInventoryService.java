package com.dms.testservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.dms.dao.IInventoryDAO;
import com.dms.model.Inventory;
import com.dms.service.IInventoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestInventoryService {
	
	@Autowired
	private IInventoryService inventoryService;
	
	@MockBean
	private IInventoryDAO inventoryDAO;
	
	private List<Inventory> list = new ArrayList<>();
	
	private LocalDateTime now = LocalDateTime.now();
	
	private Inventory inventory = new Inventory(10,1,"SIM Card", 100, 500.0,now,now);
	
	private int userId = 10;
	
	@Test
	public void testGetAllInventory() {
		list.add(inventory);
		when(inventoryDAO.getAllInventory()).thenReturn(list);
		assertEquals(list,inventoryService.getAllInventory());
	}
	
	@Test
	public void testGetInventoryById() {
		list.add(inventory);
		when(inventoryDAO.getInventoryById(userId)).thenReturn(list);
		assertEquals(list,inventoryService.getInventoryById(userId));
	}
}
