package com.dms.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dms.constant.Constant;
import com.dms.model.Inventory;
import com.dms.service.IInventoryService;

/**
 * The Class InventoryController.
 */
@Controller
@CrossOrigin(origins = Constant.URL)
@RequestMapping("/inventory")
public class InventoryController {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(InventoryController.class);

	/** The inventory services impl. */
	@Autowired
	private IInventoryService inventoryServices;

	/**
	 * Gets the all inventory.
	 *
	 * @return the all inventory
	 */
	@GetMapping
	public ResponseEntity<List<Inventory>> getAllInventory() {
		LOG.info("inside getAllInventory to get all inventory of all user");
		List<Inventory> list = inventoryServices.getAllInventory();
		return new ResponseEntity<List<Inventory>>(list, HttpStatus.OK);
	}

	/**
	 * Gets the inventory by ID.
	 *
	 * @param userId the user id
	 * @return the inventory by ID
	 */
	@GetMapping("/{userId}")
	public ResponseEntity<List<Inventory>> getInventoryByID(@PathVariable("userId") int userId) {
		LOG.info("inside getInventoryByID");
		List<Inventory> list = inventoryServices.getInventoryById(userId);
		return new ResponseEntity<List<Inventory>>(list, HttpStatus.OK);
	}

	/**
	 * Adds the inventory.
	 *
	 * @param userId the user id
	 */
	@GetMapping("/add/{userId}")
	public void addInventory(@PathVariable("userId") int userId) {
		LOG.info("inside addInventory");
		inventoryServices.addInventory(userId);
	}

}
