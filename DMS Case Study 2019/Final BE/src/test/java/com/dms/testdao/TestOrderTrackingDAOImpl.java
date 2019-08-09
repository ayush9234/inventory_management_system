package com.dms.testdao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dms.dao.IOrderTrackingDAO;
import com.dms.dto.TransactionDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOrderTrackingDAOImpl {
	@Autowired
	IOrderTrackingDAO orderTrackingDao;
	TransactionDTO tDTO = new TransactionDTO("adbhchbsyibcabsa", 5, 2, 500, null, "harsh", 1, "SIM Card", 20, 500,
			"akshay", "pending", null, null);
	List<TransactionDTO> list = new ArrayList<TransactionDTO>();
	int id = 1;

	@Test
	public void testAddOrder() {
		assertEquals(true, orderTrackingDao.addOrder(tDTO));
	}
}
