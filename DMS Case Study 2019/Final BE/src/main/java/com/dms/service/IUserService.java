package com.dms.service;

import java.util.List;

import com.dms.dto.PasswordUpdateDTO;
import com.dms.dto.UserInfoDTO;
import com.dms.model.User;


/**
 * The Interface IUserService.
 */
public interface IUserService {

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
	User getUserById(Integer userId);

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
	boolean deleteUser(Integer userId);

	/**
	 * Login.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	UserInfoDTO login(User user);

	/**
	 * Map retailar.
	 *
	 * @param user the user
	 */
	void mapRetailer(User user);

	/**
	 * Gets the all retailar.
	 *
	 * @param userId the user id
	 * @return the all retailar
	 */
	List<User> getAllRetailer(int userId);

	/**
	 * Gets the disributer.
	 *
	 * @return the disributer
	 */
	List<User> getDistributer();
	
	/**
	 * Change password.
	 *
	 * @param passwordUpdateDto the password update dto
	 * @return true, if successful
	 */
	boolean changePassword(PasswordUpdateDTO passwordUpdateDto);

}