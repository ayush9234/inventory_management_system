package com.dms.service;

import java.util.List;
import com.dms.model.Inventory;

/**
 * The Interface IInventoryService.
 */
public interface IInventoryService {

	/**
	 * Gets the all inventory.
	 *
	 * @return the all inventory
	 */
	List<Inventory> getAllInventory();

	/**
	 * Gets the inventory by id.
	 *
	 * @param userId the user id
	 * @return the inventory by id
	 */
	List<Inventory> getInventoryById(int userId);

	/**
	 * Adds the inventory.
	 *
	 * @param userId the user id
	 */
	void addInventory(int userId);

}
