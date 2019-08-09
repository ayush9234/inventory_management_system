package com.dms.testservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dms.dao.IOrderTrackingDAO;
import com.dms.dto.TransactionDTO;
import com.dms.model.OrderTracking;
import com.dms.service.IOrderTrackingService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOrderTrackingService {
	@Autowired
	private IOrderTrackingService orderTrackingService;
	
	@MockBean
	private IOrderTrackingDAO orderTrackingDAO;
	
	private List<TransactionDTO> list = new ArrayList<>();
	
	private int id = 10;

	/** The qty. */
	private List<Map<String,String>> qty = new ArrayList<>();
	
	/** The place orders. */
	private Map<String, String> placeOrders = new HashMap<String,String>();
	
	/** The transaction DTO. */
	private TransactionDTO transactionDTO = new TransactionDTO("0114739d-9e7b-463f-ada1-bff31a308808",9,10,100.0,new Date(),"Ajay", 1, "SIM Card", 50, 50.0,"Ayush","active", new Date(), qty);

	@Test
	public void testGetAllOrders() {
		list.add(transactionDTO);
		when(orderTrackingDAO.getAllOrders(id)).thenReturn(list);
		assertEquals(list,orderTrackingService.getAllOrders(id));
	}
}
