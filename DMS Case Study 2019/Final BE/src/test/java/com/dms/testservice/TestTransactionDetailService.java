package com.dms.testservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dms.dao.ITransactionDetailsDAO;
import com.dms.model.TransactionDetails;
import com.dms.service.ITransactionDetailsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTransactionDetailService {

	@Autowired
	private ITransactionDetailsService transactionDetailsService;

	@MockBean
	private ITransactionDetailsDAO transactionDetailsDAO;

	private List<TransactionDetails> details = new ArrayList<>();

	private TransactionDetails transactionDetails = new TransactionDetails("0114739d-9e7b-463f-ada1-bff31a308808", 1,
			10, 100.0, "SIM Card");

	private String transactionId = "0114739d-9e7b-463f-ada1-bff31a308808";
	
	@Test
	public void testGetTransactionDetails() {
		details.add(transactionDetails);
		when(transactionDetailsDAO.getTransactionDetails(transactionId)).thenReturn(details);
		assertEquals(details,transactionDetailsService.getTransactionDetails(transactionId));
	}
	
}
