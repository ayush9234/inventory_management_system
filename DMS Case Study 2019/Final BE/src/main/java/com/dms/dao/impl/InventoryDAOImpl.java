package com.dms.dao.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dms.constant.Constant;
import com.dms.constant.Query;
import com.dms.dao.IInventoryDAO;
import com.dms.model.Inventory;

/**
 * The Class InventoryDAOImpl.
 */
@Repository
public class InventoryDAOImpl implements IInventoryDAO {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(InventoryDAOImpl.class);

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Gets the all inventory.
	 *
	 * @return the all inventory
	 */
	@Override
	public List<Inventory> getAllInventory() {
		LOG.info("inside getAllInventory");
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.ALL_FROM_INVENNTORY);
		ArrayList<Inventory> inventoryList = new ArrayList<>();
		while (srs.next()) {
			Inventory i = new Inventory();
			i.setUserId(srs.getInt(Constant.USER_ID));
			i.setProductId(srs.getInt(Constant.PRODUCT_ID));
			i.setProductQuantity(srs.getInt(Constant.PRODUCT_QUANTITY));
			i.setMonetaryValue(srs.getDouble(Constant.MONETARY_VALUE));
			i.setProductName(srs.getString(Constant.PRODUCT_NAME));
			i.setCreationTime(srs.getTimestamp(Constant.CREATION_TIME).toLocalDateTime());
			i.setUpdationTime(srs.getTimestamp(Constant.UPDATION_TIME).toLocalDateTime());
			inventoryList.add(i);
		}
 
		return inventoryList;
	}

	/**
	 * Gets the inventory by id.
	 *
	 * @param userId the user id
	 * @return the inventory by id
	 */
	@Override
	public List<Inventory> getInventoryById(int userId) {
		LOG.info("inside getInventoryById");
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.INVENTORY_BY_ID,userId);
		ArrayList<Inventory> inventoryList = new ArrayList<>();
		while (srs.next()) {
			Inventory i = new Inventory();
			i.setUserId(srs.getInt(Constant.USER_ID));
			i.setProductId(srs.getInt(Constant.PRODUCT_ID));
			i.setProductQuantity(srs.getInt(Constant.PRODUCT_QUANTITY));
			i.setMonetaryValue(srs.getDouble(Constant.MONETARY_VALUE));
			i.setProductName(srs.getString(Constant.PRODUCT_NAME));
			i.setCreationTime(srs.getTimestamp(Constant.CREATION_TIME).toLocalDateTime());
			i.setUpdationTime(srs.getTimestamp(Constant.UPDATION_TIME).toLocalDateTime());
			inventoryList.add(i);
		}
		return inventoryList;
	}

	/**
	 * Adds the inventory.
	 *
	 * @param userId the user id
	 */
	@Transactional
	@Override
	public boolean addInventory(int userId) {
		LOG.info("inside addInventory");
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.ALL_PRODUCTID);
		while (srs.next()) {
			jdbcTemplate.update(Query.ADD_INVENTORY, userId, srs.getInt(Constant.PRODUCT_ID), 0, 0, LocalDateTime.now(),
					LocalDateTime.now(),srs.getString(Constant.PRODUCT_NAME));
		}
		return true;
	}
}
