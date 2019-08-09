package com.dms.service.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dms.dao.IInventoryDAO;
import com.dms.model.Inventory;
import com.dms.service.IInventoryService;

/**
 * The Class InventoryServicesImpl.
 */
@Service
public class InventoryServicesImpl implements IInventoryService {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(InventoryServicesImpl.class);

	/** The inventory dao impl. */
	@Autowired
	private IInventoryDAO inventoryDAO;

	/**
	 * Gets the all inventory.
	 *
	 * @return the all inventory
	 */
	@Override
	public List<Inventory> getAllInventory() {
		LOG.info("getting all Inventory details");
		return inventoryDAO.getAllInventory();
	}

	/**
	 * Gets the inventory by id.
	 *
	 * @param userId the user id
	 * @return the inventory by id
	 */
	@Override
	public List<Inventory> getInventoryById(int userId) {
		LOG.info("getting Inventory details by id");
		return inventoryDAO.getInventoryById(userId);
	}

	/**
	 * Adds the inventory.
	 *
	 * @param userId the user id
	 */
	@Override
	public void addInventory(int userId) {
		LOG.info("inside addInventory");
		inventoryDAO.addInventory(userId);
	}
}
