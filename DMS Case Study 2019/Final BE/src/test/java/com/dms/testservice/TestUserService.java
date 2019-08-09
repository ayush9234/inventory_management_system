package com.dms.testservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dms.dao.IUserDAO;
import com.dms.dto.PasswordUpdateDTO;
import com.dms.dto.UserInfoDTO;
import com.dms.model.User;
import com.dms.service.IUserService;

/**
 * The Class TestUserService.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserService {

	@Autowired
	private IUserService userService;

	@MockBean
	private IUserDAO userDAO;

	private List<User> list = new ArrayList<>();

	private int id = 10;

	private User user = new User(id, "Akshay", "$2a$10$QqkhicB0X3E4mGtmUlC0GuCmgubz5I4Pcm9eBmP5Nv9b1W3AXPgI2",
			"harsh1234567.patidar99@gmail.com", "1478 MAHALAXMI PARISAR", "84588245789", "active", 3, "MP",
			LocalDateTime.now(), LocalDateTime.now());

	private UserInfoDTO userInfo = new UserInfoDTO(10, "Akshay", 3, true);

	private UserInfoDTO userInfoF = new UserInfoDTO(10, "Akshay", 3, false);

	private PasswordUpdateDTO pswd = new PasswordUpdateDTO(id,
			"$2a$10$QqkhicB0X3E4mGtmUlC0GuCmgubz5I4Pcm9eBmP5Nv9b1W3AXPgI2", "000000");
	
	@Test
	public void testGetUsers() {
		list.add(user);
		when(userDAO.getUsers()).thenReturn(list);
		assertEquals(list,userService.getUsers());
	}
	
	@Test
	public void testGetUserById() {
		when(userDAO.getUserById(id)).thenReturn(user);
		assertEquals(user,userService.getUserById(id));
	}
	
	@Test 
	public void testCreateUser() {
		when(userDAO.createUser(user)).thenReturn(true);
		assertEquals(true,userService.createUser(user));
	}
	
	@Test
	public void testLogin() {
		when(userDAO.login(user)).thenReturn(userInfo);
		assertEquals(userInfo,userService.login(user));
	}
	
	@Test
	public void testGetAllRetailer() {
		list.add(user);
		when(userDAO.getAllRetailer(id)).thenReturn(list);
		assertEquals(list,userService.getAllRetailer(id));
	}
	
	@Test
	public void testGetDistributer() {
		list.add(user);
		when(userDAO.getDistributer()).thenReturn(list);
		assertEquals(list,userService.getDistributer());
	}
	
	@Test
	public void testChangePassword() {
		when(userDAO.changePassword(pswd)).thenReturn(true);
		assertEquals(true,userService.changePassword(pswd));
	}
}
