package com.dms.testcontroller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dms.controller.OrderTrackingController;
import com.dms.dto.TransactionDTO;
import com.dms.model.OrderTracking;
import com.dms.service.IOrderTrackingService;

/**
 * The Class TestOrderTrackingController.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOrderTrackingController {
	private String transactionId = "";
	
	LocalDateTime now = LocalDateTime.now();
	
	private List<TransactionDTO> list = new ArrayList<>();
	
	@Autowired
	private OrderTrackingController orderTrackingController;
	
	@MockBean
	private IOrderTrackingService orderTrackingService;
	
	private TransactionDTO transactionDTO = new TransactionDTO();
	
	@Test
	public void testGetAllTransaction() {
		list.add(transactionDTO);
	}

}
