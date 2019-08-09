package com.dms.testcontroller;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.dms.controller.TransactionController;
import com.dms.dto.TransactionDTO;
import com.dms.model.Transaction;
import com.dms.service.ITransactionService;

/**
 * The Class TestTransactionController.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTransactionController {

	/** The transaction controller. */
	@Autowired
	private TransactionController transactionController;
	
	/** The transaction service. */
	@MockBean
	private ITransactionService transactionService;
	
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

	
	/**
	 * Test get all transaction.
	 */
	@Test
	public void testGetAllTransaction() {
		list.add(transaction);
		when(transactionService.getAllTransaction()).thenReturn(list);
		assertEquals(new ResponseEntity<>(list,HttpStatus.OK),transactionController.getAllTransaction());
	}
	
	/**
	 * Test get transaction by seller id.
	 */
	@Test
	public void testGetTransactionBySellerId() {
		list.add(transaction);
		when(transactionService.getTransactionBySellerId(id)).thenReturn(list);
		assertEquals(new ResponseEntity<>(list,HttpStatus.OK),transactionController.getTransactionBySellerId(id));
	}
	
	@Test
	public void testAllTransactionOfUser() {
		list.add(transaction);
		when(transactionService.allTransactionOfUser(id)).thenReturn(list);
		assertEquals(new ResponseEntity<>(list,HttpStatus.OK),transactionController.allTransactionOfUser(id));
	}
	
	
	/**
	 * Test get transaction by buyer id.
	 */
	@Test
	public void testGetTransactionByBuyerId() {
		list.add(transaction);
		when(transactionService.getTransactionByBuyerId(id)).thenReturn(list);
		assertEquals(new ResponseEntity<>(list,HttpStatus.OK),transactionController.getTransactionByBuyerId(id));
	}
	
	/**
	 * Test add transaction.
	 */
	@Test
	public void testAddTransaction() {
		placeOrders.put("1", "10");
		qty.add(placeOrders);
		when(transactionService.addTransaction(transactionDTO)).thenReturn(true);	
	}
	
	/**
	 * Test sell product.
	 */
	@Test
	public void testSellProduct() {
		when(transactionService.sellItem(transactionDTO)).thenReturn(true);
		assertEquals(new ResponseEntity<>(HttpStatus.CREATED),transactionController.sellItem(transactionDTO));
	}
}
