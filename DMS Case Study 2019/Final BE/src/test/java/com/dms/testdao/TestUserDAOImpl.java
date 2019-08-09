package com.dms.testdao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dms.dao.IUserDAO;
import com.dms.dto.PasswordUpdateDTO;
import com.dms.dto.UserInfoDTO;
import com.dms.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserDAOImpl {
	@Autowired
	IUserDAO userDAO;

	User user = new User(1, "akshay", "000000", "akshay.mahajan@gmail.com", "adderss", "8871838785", "active", 1, "",
			LocalDateTime.now(), LocalDateTime.now());

	ArrayList<User> userlist = new ArrayList<User>();
	
	int userId = 1;

	@Test
	public void testUpdateUser() {
		assertEquals(true, userDAO.updateUser(user));
	}

	@Test
	public void testDeleteUser() {
		assertEquals(true, userDAO.deleteUser(userId));
	}


}
