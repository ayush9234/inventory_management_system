package com.dms.testcontroller;

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

import com.dms.controller.InventoryController;
import com.dms.model.Inventory;
import com.dms.service.IInventoryService;

/**
 * The Class TestInventoryController.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestInventoryController {
	
	/** The user id. */
	private int userId = 10;
	
	/** The now. */
	private LocalDateTime now = LocalDateTime.now();
	
	/** The inventory. */
	private Inventory inventory = new Inventory(10,1,"SIM Card", 100, 500.0,now,now);

	/** The inventory service. */
	@MockBean
	private IInventoryService inventoryService;
	
	/** The inventory controller. */
	@Autowired
	private InventoryController inventoryController;
	
	/** The list. */
	private List<Inventory> list = new ArrayList<>();
	
	/**
	 * Test get all inventory.
	 */
	@Test
	public void testGetAllInventory() {
		list.add(inventory);
		when(inventoryService.getAllInventory()).thenReturn(list);
		assertEquals(new ResponseEntity<>(list, HttpStatus.OK),inventoryController.getAllInventory());
		
	}
	
	/**
	 * Test get inventory by id.
	 */
	@Test
	public void testGetInventoryById() {
		list.add(inventory);
		when(inventoryService.getInventoryById(userId)).thenReturn(list);
		assertEquals(new ResponseEntity<>(list,HttpStatus.OK),inventoryController.getInventoryByID(userId));
	} 
	
}
