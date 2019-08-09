package com.dms.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dms.constant.Constant;
import com.dms.dto.TransactionDTO;
import com.dms.service.IOrderTrackingService;

/**
 * The Class OrderTrackingController.
 */
@CrossOrigin(origins = Constant.URL)
@RequestMapping("/ordertracking")
@RestController
public class OrderTrackingController {
	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(OrderTrackingController.class);

	/** The order tracking service. */
	@Autowired
	private IOrderTrackingService orderTrackingService;

	/**
	 * Gets the all transaction.
	 *
	 * @param id the id
	 * @return the all transaction
	 */
	@GetMapping
	public ResponseEntity<List<TransactionDTO>> getAllTransaction(@RequestParam("id") Integer id) {
		LOG.info("inside getAllTransaction");
		List<TransactionDTO> list = orderTrackingService.getAllOrders(id);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
  
	/**
	 * Adds the order.
	 *
	 * @param transactionDTO the transaction DTO
	 * @return the response entity
	 */
	@PostMapping(consumes = "application/JSON")
	public ResponseEntity<Void> addOrder(@RequestBody TransactionDTO transactionDTO) {
		LOG.info("inside addOrder");
		orderTrackingService.addOrder(transactionDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/**
	 * Accept order.
	 *
	 * @param order the order
	 * @return the response entity
	 */
	@PostMapping("/accept")
	public ResponseEntity<Void> acceptOrder(@RequestBody TransactionDTO order) {
		LOG.info("inside acceptOrder");
		orderTrackingService.acceptOrder(order);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	/**
	 * Reject order.
	 *
	 * @param order the order
	 * @return the response entity
	 */
	@PostMapping("/reject")
	public ResponseEntity<Void> rejectOrder(@RequestBody TransactionDTO order) {
		LOG.info("inside rejectOrder");
		orderTrackingService.rejectOrder(order);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	/**
	 * Pending orders.
	 *
	 * @param userId the user id
	 * @return the response entity
	 */
	@GetMapping("/pending")
	public ResponseEntity<List<TransactionDTO>> pendingOrders(@RequestParam("id") int userId){
		LOG.debug("inside pendingOrders");
		List<TransactionDTO> list = orderTrackingService.pendingOrders(userId);
		return new ResponseEntity<>(list, HttpStatus.FOUND);
	}

}
