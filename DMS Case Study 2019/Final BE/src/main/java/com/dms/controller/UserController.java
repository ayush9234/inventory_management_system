package com.dms.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dms.constant.Constant;
import com.dms.dto.PasswordUpdateDTO;
import com.dms.dto.UserInfoDTO;
import com.dms.model.User;
import com.dms.service.IUserService;

/**
 * The Class UserController.
 */
@RequestMapping("/user")
@RestController
@CrossOrigin(origins = Constant.URL)
public class UserController {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(UserController.class);

	/** The user service. */
	@Autowired
	private IUserService userService;

	/**
	 * Gets the user by id.
	 *
	 * @param id the id
	 * @return the user by id
	 */
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
		LOG.info("inside getUserById");

		User user = userService.getUserById((id));
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	@GetMapping("/all")
	public ResponseEntity<List<User>> getUsers() {
		LOG.info("inside getUser ");
		List<User> list = userService.getUsers();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

	/**
	 * Creates the distributer.
	 *
	 * @param user the user
	 * @return the response entity
	 */
	@PostMapping("/adduser")
	public ResponseEntity<Void> createUser(@RequestBody User user) {
		LOG.info("inside createUser");
		boolean flag = userService.createUser(user);
		if (!flag) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/**
	 * Update user.
	 *
	 * @param userId the user id
	 * @param user   the user
	 * @return the response entity
	 */
	@PutMapping("/{userId}")
	public ResponseEntity<Void> updateUser(@PathVariable("userId") int userId, @RequestBody User user) {
		LOG.info("inside getUser  ");
		user.setUserId(userId);
		boolean flag = userService.updateUser(user);
		if (!flag) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	/**
	 * Login.
	 *
	 * @param user the user
	 * @return the response entity
	 */
	@PostMapping("/login")
	public ResponseEntity<UserInfoDTO> login(@RequestBody User user) {
		LOG.info("inside login ");

		UserInfoDTO userInfoDTO = userService.login(user);
		
		if (userInfoDTO.isResult())
			return new ResponseEntity<>(userInfoDTO, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>(userInfoDTO, HttpStatus.CONFLICT);
	}

	/**
	 * Gets the all retailar.GET .
	 *
	 * @param userId the user id
	 * @return the all retailer
	 */
	@GetMapping("/retailers")
	public ResponseEntity<List<User>> getAllRetailer(@RequestParam("id") int userId) {
		LOG.info("inside getAllRetailer ");
		List<User> list = userService.getAllRetailer(userId);
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

	/**
	 * Gets the distributer.
	 *
	 * @return the distributer
	 */
	@GetMapping("/distributor")
	public ResponseEntity<List<User>> getDistributer() {
		LOG.info("inside getDistributer");
		List<User> list = userService.getDistributer();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

	/**
	 * Delete user.
	 *
	 * @param userId the user id
	 * @return the response entity
	 */
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") int userId) {
		LOG.info("inside deleteUser ");
		boolean flag = userService.deleteUser(userId);
		if (flag)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.CONFLICT);

	}

	/**
	 * Update user.
	 *
	 * @param passwordUpdateDto the password update dto
	 * @return the response entity
	 */
	@PostMapping("/updatepassword")
	public ResponseEntity<Void> updatePassword(@RequestBody PasswordUpdateDTO passwordUpdateDto) {
		if (userService.changePassword(passwordUpdateDto))
			return new ResponseEntity<>(HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.CONFLICT);

	}

} 