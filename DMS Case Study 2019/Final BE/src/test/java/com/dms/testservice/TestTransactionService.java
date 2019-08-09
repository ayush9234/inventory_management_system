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

import com.dms.dao.ITransactionDAO;
import com.dms.dto.TransactionDTO;
import com.dms.model.Transaction;
import com.dms.service.ITransactionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTransactionService {
	
	@Autowired
	private ITransactionService transactionService;
	
	@MockBean
	private ITransactionDAO transactionDAO;
	
	/** The list. */
	private List<Transaction> list = new ArrayList<>();
	
	/** The qty. */
	private List<Map<String,String>> qty = new ArrayList<>();
	
	/** The transaction. */
	Transaction transaction = new Transaction("0114739d-9e7b-463f-ada1-bff31a308808",9,10,100.0,new Date(),"Ajay","Ayush");
	
	/** The transaction id. */
	private String transactionId = "0114739d-9e7b-463f-ada1-bff31a308808";
	
	/** The id. */
	private int id = 10; 
	
	/** The place orders. */
	private Map<String, String> placeOrders = new HashMap<String,String>();
	
	/** The transaction DTO. */
	private TransactionDTO transactionDTO = new TransactionDTO("0114739d-9e7b-463f-ada1-bff31a308808",9,10,100.0,new Date(),"Ajay", 1, "SIM Card", 50, 50.0,"Ayush","active", new Date(), qty);
	
	@Test
	public void testGetAllTransaction() {
		list.add(transaction);
		when(transactionDAO.getAllTransaction()).thenReturn(list);
		assertEquals(list,transactionService.getAllTransaction());
	}
	
	@Test
	public void testGetTransactionBySellerId() {
		list.add(transaction);
		when(transactionDAO.getTransactionBySellerId(id)).thenReturn(list);
		assertEquals(list,transactionService.getTransactionBySellerId(id));
	}
	
	@Test
	public void testGetTransactionByBuyerId() {
		list.add(transaction);
		when(transactionDAO.getTransactionByBuyerId(id)).thenReturn(list);
		assertEquals(list,transactionService.getTransactionByBuyerId(id));
	}
	
	@Test
	public void testAddTransaction() {
		when(transactionDAO.addTransaction(transactionDTO)).thenReturn(true);
		assertEquals(true,transactionService.addTransaction(transactionDTO));
	}
	
	
	@Test
	public void testAllTransactionOfUser() {
		list.add(transaction);
		when(transactionDAO.allTransactionOfUser(id)).thenReturn(list);
		assertEquals(list,transactionService.allTransactionOfUser(id));
	}
}
