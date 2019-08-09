package com.dms.constant;

/**
 * The Class Query.
 */
public final class Query {

	/** The Constant ALL_FROM_USER_TABLE. */
	public static final String ALL_FROM_USER_TABLE = "SELECT * FROM user_table";
	
	/** The Constant INSERT_INTO_USER_TABLE. */
	public static final String INSERT_INTO_USER_TABLE = "INSERT INTO user_table (user_name,password, email,personal_address,contact_no,status,role_type,area,creation_time,updation_time) VALUES (?,?,?,?,?,?,?,?,?,?)";
	
	/** The Constant UPDATE_USER. */
	public static final String UPDATE_USER = "UPDATE user_table SET user_name=?,personal_address=?,contact_no=?,status=?,updation_time=? WHERE user_id=?";
	
	/** The Constant DELETE_USER. */
	public static final String DELETE_USER = "UPDATE user_table SET status=? WHERE user_id=?";
	
	/** The Constant GET_USERBY_ID. */
	public static final String GET_USERBY_ID = "SELECT * FROM user_table WHERE user_id=?";
	
	/** The Constant LOGIN. */
	public static final String LOGIN = "select * from user_table where email = ?";
	
	/** The Constant RETAILER_MAPPING. */
	public static final String RETAILER_MAPPING = "insert into role_mapping values (?,?)";
	
	/** The Constant GET_DISTRIBUTER_BY_AREA. */
	public static final String GET_DISTRIBUTER_BY_AREA = "select user_id from user_table where area=? and role_type = ?";
	
	/** The Constant USER_ID_BY_EMAIL. */
	public static final String USER_ID_BY_EMAIL = "select user_id from user_table where email = ?";
	
	/** The Constant GET_ALL_RETAILER_OF_DISTRIBUTER. */
	public static final String GET_ALL_RETAILER_OF_DISTRIBUTER = "SELECT retailer_id FROM role_mapping where distributer_id = ?";
	
	/** The Constant ALL_DISTRIBUTER. */
	public static final String ALL_DISTRIBUTER = "SELECT * FROM user_table where role_type = 2";
	
	/** The Constant ALL_FROM_INVENNTORY. */
	public static final String ALL_FROM_INVENNTORY = "select * from inventory_table";
	
	/** The Constant ADD_INVENTORY. */
	public static final String ADD_INVENTORY = "insert into inventory_table values(?,?,?,?,?,?,?)";
	
	/** The Constant INVENTORY_BY_ID. */
	public static final String INVENTORY_BY_ID = "select * from inventory_table where user_id = ?";
	
	/** The Constant ALL_PRODUCTID. */
	public static final String ALL_PRODUCTID = "select product_id,product_name from product";
	
	/** The Constant UPDATE_INVENTORY. */
	public static final String UPDATE_INVENTORY = "update inventory_table set product_quantity = ? , updation_time = ?,monetary_value = ? where user_id = ? and product_id = ?";
	
	/** The Constant GET_PRODUCT_COST. */
	public static final String GET_PRODUCT_COST = "Select product_cost from product_table where product_id =?";
	
	/** The Constant GET_USER_INVENTORY. */
	public static final String GET_USER_INVENTORY = "Select product_quantity from inventory_table where user_id = ? and product_id = ?";
	
	/** The Constant CHANGE_PASSWORD. */
	public static final String CHANGE_PASSWORD = "UPDATE user_table SET password= ? WHERE user_id= ?";
	
	/** The Constant RETAILER_DETAIL. */
	public static final String RETAILER_DETAIL =  "SELECT * FROM user_table WHERE user_id=?";
	
	/** The Constant TRANSACTION_DETAIL. */
	public static final String TRANSACTION_DETAIL = "select * from transaction_details where transaction_id = ?";
	
	/** The Constant ADD_TRANSACTION_DETAIL. */
	public static final String ADD_TRANSACTION_DETAIL = "insert into transaction_details (transaction_id, product_name, quantity, cost) values (?,?,?,?)";

	/** The Constant COST_OF_PRODUCT. */
	public static final String COST_OF_PRODUCT = "select product_cost from product where product_name = ?";
	
	/** The Constant ALL_TRANSACTION. */
	public static final String ALL_TRANSACTION = "select * from transaction ORDER BY creation_time DESC";
	
	/** The Constant SELLER_TRANSACTION. */
	public static final String SELLER_TRANSACTION = "select * from transaction where seller_id = ? ORDER BY creation_time DESC";
	
	/** The Constant BUYER_TRANSACTION. */
	public static final String BUYER_TRANSACTION = "select * from transaction where buyer_id = ? ORDER BY creation_time DESC";
	
	/** The Constant ADD_TRANSACTION. */
	public static final String ADD_TRANSACTION = "insert into transaction (transaction_id, buyer_id, seller_id ,buyer_name, seller_name, total_price, creation_time) values(?,?,?,?,?,?,?)";

	/** The Constant TRANSACTION_BY_ID. */
	public static final String TRANSACTION_BY_ID = "select * from transaction where transaction_id = ?";
	
	/** The Constant BUYER_BY_TRANSACTION_ID. */
	public static final String BUYER_BY_TRANSACTION_ID =  "select * from transaction where transaction_id = ?";
	
	/** The Constant GET_USER_NAME. */
	public static final String GET_USER_NAME = "select user_name from user_table where user_id = ? ";
	
	/** The Constant GET_ALL_PRODUCTS. */
	public static final String GET_ALL_PRODUCTS = "select * from product";
	
	/** The Constant PRODUCT_BY_ID. */
	public static final String PRODUCT_BY_ID = "select * from product where product_id=?";
	
	/** The Constant ADD_PRODUCT. */
	public static final String ADD_PRODUCT = "INSERT INTO product (product_name, product_status, product_cost, creation_time, updation_time) VALUES (?,?,?,?,?)";
	
	/** The Constant PRODUCT_EXIST. */
	public static final String PRODUCT_EXIST = "select product_name from product where product_name=?";
	
	/** The Constant UPDATE_PRODUCT. */
	public static final String UPDATE_PRODUCT = "UPDATE product SET product_name = ?, product_status = ?, product_cost = ?, updation_time = ? where product_id = ?";

	/** The Constant GET_ALL_ORDERS. */
	public static final String GET_ALL_ORDERS = "select * from order_tracking natural JOIN transaction where transaction_status=? AND seller_id=?";
	
	/** The Constant ADD_ORDER. */
	public static final String ADD_ORDER = "insert into order_tracking (transaction_id, transaction_status, updation_time) values(?,?,?)";
	
	/** The Constant ACCEPT_ORDER. */
	public static final String ACCEPT_ORDER = "UPDATE order_tracking set transaction_status = ?,updation_time = ? where transaction_id = ?";
	
	/** The Constant TRANSACTIONDETAIL_JOIN_TRANSACTION. */
	public static final String TRANSACTIONDETAIL_JOIN_TRANSACTION = "select * from transaction_details natural join transaction where transaction_id = ?";
	
	/** The Constant UPDATE_BUYER_INVENTORY. */
	public static final String UPDATE_BUYER_INVENTORY = "UPDATE inventory_table set product_quantity = product_quantity + ?,updation_time = ? where product_name = ? and user_id = ?";

	/** The Constant UPDATE_SELLER_INVENTORY. */
	public static final String UPDATE_SELLER_INVENTORY = "UPDATE inventory_table set product_quantity = product_quantity - ?,updation_time = ? where product_name = ? and user_id = ?";
	
	/** The Constant PENDING_ORDERS_LIST. */
	public static final String PENDING_ORDERS_LIST = "select * from order_tracking where transaction_status=?";
	
    /** The Constant GET_SELLER_ID. */
    public static final String GET_SELLER_ID = "select distributer_id from role_mapping where retailer_id = ?";

    /** The Constant GET_QUANTITY. */
    public static final String GET_QUANTITY = "select product_quantity from inventory_table where product_name = ? and user_id = ?";

    /** The Constant PENDING_ORDERS_FOR_ID. */
    public static final String PENDING_ORDERS_FOR_ID = "select * from transaction NATURAL JOIN order_tracking where transaction_status = 'pending' AND buyer_id = ? ORDER BY updation_time";

    /** The Constant ALL_TRANSACTION_OF_USER. */
    public static final String ALL_TRANSACTION_OF_USER = "select * from transaction NATURAL JOIN order_tracking where seller_id = ? OR buyer_id = ? ORDER BY updation_time DESC";

}
