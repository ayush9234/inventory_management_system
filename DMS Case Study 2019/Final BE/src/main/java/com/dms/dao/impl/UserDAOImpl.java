package com.dms.dao.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.dms.constant.Constant;
import com.dms.constant.Query;
import com.dms.dao.IInventoryDAO;
import com.dms.dao.IUserDAO;
import com.dms.dto.PasswordUpdateDTO;
import com.dms.dto.UserInfoDTO;
import com.dms.exception.BADRequestException;
import com.dms.model.User;
import com.dms.service.impl.EmailService;
import com.dms.util.PasswordEncoder;
import com.dms.util.PasswordGenerator;

/**
 * The Class UserDao.
 */
@Repository
public class UserDAOImpl implements IUserDAO {

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/** The inventory dao impl. */
	@Autowired
	private IInventoryDAO inventoryDAO;

	/** The email service. */
	@Autowired
	private EmailService emailService;

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(UserDAOImpl.class);

	/** The password encoder. */
	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	@Override
	public List<User> getUsers() {
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.ALL_FROM_USER_TABLE);
		List<User> list = new ArrayList<>();
		while (srs.next()) {
			User user = new User();
			user.setUserId(srs.getInt(Constant.USER_ID));
			user.setUserName(srs.getString(Constant.USER_NAME));
			user.setEmail(srs.getString(Constant.EMAIL));
			user.setPersonalAddress(srs.getString(Constant.PERSONAL_ADDRESS));
			user.setContactno(srs.getString(Constant.CONTACT_NO));
			user.setUserStatus(srs.getString(Constant.STATUS));
			user.setRoleType(srs.getInt(Constant.ROLE_TYPE));
			user.setArea(srs.getString(Constant.AREA));
			user.setCreationTime(srs.getTimestamp(Constant.CREATION_TIME).toLocalDateTime());
			user.setUpdationTime(srs.getTimestamp(Constant.UPDATION_TIME).toLocalDateTime());
			list.add(user);
		}
		LOG.info("Getting user list");
		return list;
	}

	/**
	 * Creates the user.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	@Override
	@Transactional
	public boolean createUser(User user) {
		try {
			PasswordGenerator passwordGenerator = new PasswordGenerator();
			user.setPassword(passwordGenerator.getNewPassword());
			user.setCreationTime(LocalDateTime.now());
			user.setUpdationTime(LocalDateTime.now());
			user.setUserStatus("active");
			jdbcTemplate.update(Query.INSERT_INTO_USER_TABLE, user.getUserName(),
					passwordEncoder.hashPassword(user.getPassword()), user.getEmail(), user.getPersonalAddress(),
					user.getContactno(), user.getUserStatus(), user.getRoleType(), user.getArea(),
					user.getCreationTime(), user.getUpdationTime());
			LOG.info("user created");
			SqlRowSet srs1 = jdbcTemplate.queryForRowSet(Query.USER_ID_BY_EMAIL, user.getEmail());
			while (srs1.next()) {
				inventoryDAO.addInventory(srs1.getInt(Constant.USER_ID));
			}
			LOG.info("Inventory added");
			emailService.sendMail(user.getEmail(), "Welcome to DIMS", "Your login credentials will be Id : "+user.getEmail()+ " Password : " + user.getPassword());
			return true;
		} catch (Exception e) {
			LOG.warn("Exception occurs");
			throw new BADRequestException("User already exists");
		}
	}

	/**
	 * Update user.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	@Override
	public boolean updateUser(User user) {
		user.setUpdationTime(LocalDateTime.now());
		jdbcTemplate.update(Query.UPDATE_USER, user.getUserName(),
				user.getPersonalAddress(), user.getContactno(), user.getUserStatus(), user.getUpdationTime(),
				user.getUserId());
		LOG.info("user updated");
		return true;
	}

	/**
	 * Delete user.
	 *
	 * @param userId the user id
	 * @return true, if successful
	 */
	@Override
	public boolean deleteUser(int userId) {
		jdbcTemplate.update(Query.DELETE_USER, "inactive", userId);
		LOG.info("user deleted");
		return true;
	}

	/**
	 * Gets the user by id.
	 *
	 * @param userId the user id
	 * @return the user by id
	 */
	@Override
	public User getUserById(int userId) {
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.GET_USERBY_ID, userId);
		User user = new User();
		while (srs.next()) {
			user.setUserId(srs.getInt(Constant.USER_ID));
			user.setUserName(srs.getString(Constant.USER_NAME));
			user.setEmail(srs.getString(Constant.EMAIL));
			user.setPersonalAddress(srs.getString(Constant.PERSONAL_ADDRESS));
			user.setContactno(srs.getString(Constant.CONTACT_NO));
			user.setUserStatus(srs.getString(Constant.STATUS));
			user.setArea(srs.getString(Constant.AREA));
		}
		if (user.getUserId() == null) {
			LOG.warn("Exception occurs");
			throw new BADRequestException("User does not exists");
		}
		LOG.info("Getting User Details");
		return user;
	}

	/**
	 * Map retailer.
	 *
	 * @param user the user
	 */
	@Transactional
	@Override
	public void mapRetailer(User user) {
		SqlRowSet srs1 = jdbcTemplate.queryForRowSet(Query.USER_ID_BY_EMAIL, user.getEmail());
		while (srs1.next()) {
			user.setUserId(srs1.getInt(Constant.USER_ID));
		}
		int distributerId = 0;
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.GET_DISTRIBUTER_BY_AREA, user.getArea(), 2);
		while (srs.next()) {
			distributerId = srs.getInt(Constant.USER_ID);
		}
		if (distributerId == 0) {
			LOG.warn("Distributer Unavailable");
			throw new BADRequestException("Distributer for your area is not available");
		}
		jdbcTemplate.update(Query.RETAILER_MAPPING, user.getUserId(), distributerId);
	}

	/**
	 * Gets the all retailer.
	 *
	 * @param userId the user id
	 * @return the all retailer
	 */
	@Transactional
	@Override
	public List<User> getAllRetailer(int userId) {
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.GET_ALL_RETAILER_OF_DISTRIBUTER, userId);
		List<User> list = new ArrayList<>();
		while (srs.next()) {
			SqlRowSet srs1 = jdbcTemplate.queryForRowSet(Query.RETAILER_DETAIL, srs.getInt(Constant.RETAILER_ID));
			while (srs1.next()) {
				User user = new User();
                user.setUserName(srs1.getString(Constant.USER_NAME));
                user.setEmail(srs1.getString(Constant.EMAIL));
                user.setPersonalAddress(srs1.getString(Constant.PERSONAL_ADDRESS));
                user.setContactno(srs1.getString(Constant.CONTACT_NO));
                user.setUserStatus(srs1.getString(Constant.STATUS));
                user.setArea(srs1.getString(Constant.AREA));
				list.add(user);
			}
		}
		return list;
	}

	/**
	 * Gets the email id.
	 *
	 * @param userId the user id
	 * @return the email id
	 */
	@Override
	public String getEmailId(int userId) {
		String email = null;
		SqlRowSet srs = this.jdbcTemplate.queryForRowSet(Query.GET_USERBY_ID, userId);
		while (srs.next())
			email = srs.getString(Constant.EMAIL);
		return email;
	}

	/**
	 * Gets the distributer.
	 *
	 * @return the distributer
	 */
	@Override
	public List<User> getDistributer() {
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.ALL_DISTRIBUTER);
		List<User> list = new ArrayList<>();
		while (srs.next()) {
			User user = new User();
			user.setUserId(srs.getInt(Constant.USER_ID));
			user.setUserName(srs.getString(Constant.USER_NAME));
			user.setEmail(srs.getString(Constant.EMAIL));
			user.setPersonalAddress(srs.getString(Constant.PERSONAL_ADDRESS));
			user.setContactno(srs.getString(Constant.CONTACT_NO));
			user.setUserStatus(srs.getString(Constant.STATUS));
			user.setRoleType(srs.getInt(Constant.ROLE_TYPE));
			user.setArea(srs.getString(Constant.AREA));
			user.setCreationTime(LocalDateTime.now());
			user.setUpdationTime(LocalDateTime.now());
			list.add(user);
		}
		return list;
	}

	/**
	 * Login.
	 *
	 * @param user the user
	 * @return the user info DTO
	 */
	@Override
	public UserInfoDTO login(User user) {
		String pwd = null;
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.LOGIN, user.getEmail());
		while (srs.next()) {
			pwd = srs.getString(Constant.PASSWORD);
			if (BCrypt.checkpw(user.getPassword(), pwd)) {
				userInfoDTO.setUserId(srs.getInt(Constant.USER_ID));
				userInfoDTO.setUserName(srs.getString(Constant.USER_NAME));
				userInfoDTO.setRoleType(srs.getInt(Constant.ROLE_TYPE));
				userInfoDTO.setResult(true);
			}
		}
		return userInfoDTO;
	}

	/**
	 * Change password.
	 *
	 * @param passwordUpdateDto the password update dto
	 * @return true, if successful
	 */
	@Override
	public boolean changePassword(PasswordUpdateDTO passwordUpdateDto) {
		String pwd = null;
		SqlRowSet srs = jdbcTemplate.queryForRowSet(Query.GET_USERBY_ID, passwordUpdateDto.getUserId());
		while (srs.next()) {
			pwd = srs.getString("password");
			if (BCrypt.checkpw(passwordUpdateDto.getOldPassword(), pwd)) {
				jdbcTemplate.update(Query.CHANGE_PASSWORD, passwordEncoder.hashPassword(passwordUpdateDto.getNewPassword()),
						passwordUpdateDto.getUserId());
				return true;
			}
		}
		return false;
	}
}