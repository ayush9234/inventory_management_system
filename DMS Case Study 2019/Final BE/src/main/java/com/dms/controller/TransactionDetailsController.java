package com.dms.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dms.constant.Constant;
import com.dms.model.TransactionDetails;
import com.dms.service.ITransactionDetailsService;

/**
 * The Class TransactionDetailsController.
 */
@CrossOrigin(origins = Constant.URL)
@RequestMapping("/transactiondetails")
@RestController
public class TransactionDetailsController {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(TransactionDetailsController.class);

	/** The transaction details service. */
	@Autowired
	private ITransactionDetailsService transactionDetailsService;

	/**
	 * Gets the all transaction.
	 *
	 * @param id the id
	 * @return the all transaction
	 */
	@GetMapping
	public ResponseEntity<List<TransactionDetails>> getAllTransaction(@RequestParam("transactionId") String id) {
		LOG.info("inside getAllTransaction ");

		List<TransactionDetails> list = transactionDetailsService.getTransactionDetails(id);
		return new ResponseEntity<List<TransactionDetails>>(list, HttpStatus.OK);
	}

}
