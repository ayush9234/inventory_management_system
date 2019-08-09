package com.dms.testcontroller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.dms.controller.UserController;
import com.dms.dto.PasswordUpdateDTO;
import com.dms.dto.UserInfoDTO;
import com.dms.model.User;
import com.dms.service.IUserService;

/**
 * The Class TestUserController.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserController {
	
	@Autowired
	private UserController userController;
	
	@MockBean
	private IUserService userService;
	
	private List<User> list = new ArrayList<>();
	
	private int id = 10;
	
	private User user = new User(id,"Akshay","$2a$10$QqkhicB0X3E4mGtmUlC0GuCmgubz5I4Pcm9eBmP5Nv9b1W3AXPgI2","harsh1234567.patidar99@gmail.com","1478 MAHALAXMI PARISAR","84588245789","active",3,"MP",LocalDateTime.now(),LocalDateTime.now());
	
	private UserInfoDTO userInfo = new UserInfoDTO(10,"Akshay",3,true);
	
	private UserInfoDTO userInfoF = new UserInfoDTO(10,"Akshay",3,false);
	
	private PasswordUpdateDTO pswd = new PasswordUpdateDTO(id,"$2a$10$QqkhicB0X3E4mGtmUlC0GuCmgubz5I4Pcm9eBmP5Nv9b1W3AXPgI2","000000");

	
	@Test
	public void testGetUserById() {
		when(userService.getUserById(id)).thenReturn(user);
		assertEquals(new ResponseEntity<>(user,HttpStatus.OK),userController.getUserById(id));
	}
	
	@Test
	public void testGetUsers() {
		list.add(user);
		when(userService.getUsers()).thenReturn(list);
		assertEquals(new ResponseEntity<>(list,HttpStatus.OK),userController.getUsers());
	}
	
	@Test
	public void testCreateUser() {
		when(userService.createUser(user)).thenReturn(true);
		assertEquals(new ResponseEntity<>(HttpStatus.CREATED),userController.createUser(user));
	}
	
	@Test
	public void testUpdateUserPositive() {
		when(userService.updateUser(user)).thenReturn(true);
		assertEquals(new ResponseEntity<>(HttpStatus.ACCEPTED),userController.updateUser(id, user));
	}
	
	@Test
	public void testLoginTrue() {
		when(userService.login(user)).thenReturn(userInfo);
		assertEquals(new ResponseEntity<>(userInfo,HttpStatus.ACCEPTED),userController.login(user));
	}
	
	@Test
	public void testLoginFalse() {
		when(userService.login(user)).thenReturn(userInfoF);
		assertEquals(new ResponseEntity<>(userInfoF,HttpStatus.CONFLICT),userController.login(user));
	}
	
	@Test
	public void testGetAllRetailer() {
		list.add(user);
		when(userService.getAllRetailer(2)).thenReturn(list);
		assertEquals(new ResponseEntity<>(list,HttpStatus.OK),userController.getAllRetailer(2));
	}
	
	@Test
	public void testGetDistributer() {
		list.add(user);
		when(userService.getDistributer()).thenReturn(list);
		assertEquals(new ResponseEntity<>(list,HttpStatus.OK),userController.getDistributer());
	}
	
	@Test
	public void testDeleteUser() {
		when(userService.deleteUser(id)).thenReturn(true);
		assertEquals(new ResponseEntity<>(HttpStatus.OK),userController.deleteUser(id));
	}
	
	@Test
	public void changePassword() {
		when(userService.changePassword(pswd)).thenReturn(true);
		assertEquals(new ResponseEntity<>(HttpStatus.OK),userController.updatePassword(pswd));
	}
}
