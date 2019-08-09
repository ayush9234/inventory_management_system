package com.dms.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dms.dao.IUserDAO;
import com.dms.dto.PasswordUpdateDTO;
import com.dms.dto.UserInfoDTO;
import com.dms.model.User;
import com.dms.service.IUserService;

/**
 * The Class UserService.
 */

@Service
public class UserServiceImpl implements IUserService {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(UserServiceImpl.class);

	/** The Constant RETAILER. */
	private static final int RETAILER = 3;

	/** The user dao. */
	@Autowired
	private IUserDAO userDao;

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	/**
	 * Gets the user by id.
	 *
	 * @param userId the user id
	 * @return the user by id
	 */
	@Override
	public User getUserById(Integer userId) {
		return userDao.getUserById(userId);
	}

	/**
	 * Creates the user.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	@Override
	public boolean createUser(User user) {
		userDao.createUser(user);
		if (user.getRoleType() == RETAILER)
			userDao.mapRetailer(user);
		return true;
	}

	/**
	 * Update user.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	@Override
	@Transactional
	public boolean updateUser(User user) {
		userDao.getUserById(user.getUserId());
		userDao.updateUser(user);
		return true;
	}

	/**
	 * Delete user.
	 *
	 * @param userId the user id
	 * @return true, if successful
	 */
	@Override
	@Transactional
	public boolean deleteUser(Integer userId) {
		userDao.getUserById(userId);
		userDao.deleteUser(userId);
		return true;
	}

	/**
	 * Login.
	 *
	 * @param user the user
	 * @return the user info DTO
	 */
	@Override
	public UserInfoDTO login(User user) {
		LOG.info("Successfully logged in");
		return userDao.login(user);
	}

	/**
	 * Map retailer.
	 *
	 * @param user the user
	 */
	@Override
	public void mapRetailer(User user) {
		userDao.mapRetailer(user);
		LOG.info("Successfully mapped");
	}

	/**
	 * Gets the all retailer.
	 *
	 * @param userId the user id
	 * @return the all retailer
	 */
	@Override
	public List<User> getAllRetailer(int userId) {
		LOG.info("Getting Retailer List");
		return userDao.getAllRetailer(userId);
	}

	/**
	 * Gets the distributer.
	 *
	 * @return the distributer
	 */
	@Override
	public List<User> getDistributer() {
		LOG.info("Getting Distributer List");
		return userDao.getDistributer();
	}

	/**
	 * Change password.
	 *
	 * @param passwordUpdateDto the password update dto
	 * @return true, if successful
	 */
	@Override
	public boolean changePassword(PasswordUpdateDTO passwordUpdateDto) {
		return userDao.changePassword(passwordUpdateDto);
	}
}