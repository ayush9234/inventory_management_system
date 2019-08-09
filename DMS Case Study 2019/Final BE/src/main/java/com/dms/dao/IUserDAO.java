package com.dms.dao;

import java.util.List;

import com.dms.dto.PasswordUpdateDTO;
import com.dms.dto.UserInfoDTO;
import com.dms.model.User;

/**
 * The Interface IUserDAO.
 */
public interface IUserDAO {

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	List<User> getUsers();

	/**
	 * Gets the user by id.
	 *
	 * @param userId the user id
	 * @return the user by id
	 */
	User getUserById(int userId);

	/**
	 * Creates the user.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	boolean createUser(User user);

	/**
	 * Update user.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	boolean updateUser(User user);

	/**
	 * Delete user.
	 *
	 * @param userId the user id
	 * @return true, if successful
	 */
	boolean deleteUser(int userId);

	/**
	 * Login.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	UserInfoDTO login(User user);

	/**
	 * Map retailer .
	 *
	 * @param user the user
	 */
	void mapRetailer(User user);

	/**
	 * Gets the all retailer.
	 *
	 * @param userId the user id
	 * @return the all retailer
	 */
	List<User> getAllRetailer(int userId);

	/**
	 * Gets the distributer .
	 *
	 * @return the distributer
	 */
	List<User> getDistributer();

	/**
	 * Gets the email id.
	 *
	 * @param userId the user id
	 * @return the email id
	 */
	String getEmailId(int userId);

	/**
	 * Update password.
	 *
	 * @param passwordUpdateDto the password update dto
	 * @return true, if successful
	 */
	boolean changePassword(PasswordUpdateDTO passwordUpdateDto);

}