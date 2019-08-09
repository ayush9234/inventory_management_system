 package com.dms.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dms.constant.Constant;
import com.dms.dto.TransactionDTO;
import com.dms.model.Transaction;
import com.dms.service.ITransactionService;

/**
 * The Class TransactionController.
 */
@CrossOrigin(origins = Constant.URL)
@RequestMapping("/transaction")
@RestController
public class TransactionController {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(TransactionController.class);

	/** The transaction service. */
	@Autowired
	private ITransactionService transactionService;

	/**
	 * Gets the all transaction.
	 *
	 * @return the all transaction
	 */
	@GetMapping
	public ResponseEntity<List<Transaction>> getAllTransaction() {
		LOG.info("inside  getAllTransaction");
		List<Transaction> list = transactionService.getAllTransaction();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	/**
	 * Gets the transaction by seller id.
	 *
	 * @param id the id
	 * @return the transaction by seller id
	 */
	@GetMapping("/seller")
	public ResponseEntity<List<Transaction>> getTransactionBySellerId(@RequestParam("id") Integer id) {
		LOG.info("inside getTransactionBySellerId  ");
		List<Transaction> list = transactionService.getTransactionBySellerId(id);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	/**
	 * Adds the transaction.
	 *
	 * @param transaction the transaction
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<Void> addTransaction(@RequestBody TransactionDTO transaction) {
		LOG.info("inside addTransaction ");
		transactionService.addTransaction(transaction);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/**
	 * Gets the transaction by buyer id.
	 *
	 * @param id the id
	 * @return the transaction by buyer id
	 */
	@GetMapping("/buyer/{id}")
	public ResponseEntity<List<Transaction>> getTransactionByBuyerId(@PathVariable("id") Integer id) {
		LOG.info("inside getTransactionByBuyerId  ");
		List<Transaction> list = transactionService.getTransactionByBuyerId(id);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

    /**
     * Sell item.
     *
     * @param transactionDTO the transaction DTO
     * @return the response entity
     */
    @PostMapping("/sell")
    public ResponseEntity<Void> sellItem(@RequestBody TransactionDTO transactionDTO) {
        LOG.info("inside addOrder");
        transactionService.sellItem(transactionDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    /**
     * All transaction of user.
     *
     * @param userId the user id
     * @return the response entity
     */
    @GetMapping("/user")
    public ResponseEntity<List<TransactionDTO>> allTransactionOfUser(@RequestParam("id") int userId){
    	LOG.info("inside allTransactionOfUser");
    	List<TransactionDTO> list = transactionService.allTransactionOfUser(userId);
    	return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
}
