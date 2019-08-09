package com.dms.testcontroller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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

import com.dms.controller.TransactionDetailsController;
import com.dms.model.TransactionDetails;
import com.dms.service.ITransactionDetailsService;

/**
 * The Class TestTransactionDetailsController.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTransactionDetailsController {
	@Autowired
	private TransactionDetailsController transactionDetailsController;
	
	@MockBean
	private ITransactionDetailsService transactionDetailsService;
	
	private List<TransactionDetails> details = new ArrayList<>();
	
	private TransactionDetails transactionDetails = new TransactionDetails("0114739d-9e7b-463f-ada1-bff31a308808", 1, 10, 100.0, "SIM Card");
	
	private String transactionId = "0114739d-9e7b-463f-ada1-bff31a308808";
	
	@Test
	public void getAllTransaction() {
		details.add(transactionDetails);
		when(transactionDetailsService.getTransactionDetails(transactionId)).thenReturn(details);
		assertEquals(new ResponseEntity<>(details,HttpStatus.OK),transactionDetailsController.getAllTransaction(transactionId));
	}
}
