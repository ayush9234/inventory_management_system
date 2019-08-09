package com.dms.util;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.dms.constant.Constant;
import com.dms.dao.IOrderTrackingDAO;
import com.dms.dao.ITransactionDAO;
import com.dms.dao.IUserDAO;
import com.dms.exception.BADRequestException;
import com.dms.model.OrderTracking;
import com.dms.service.impl.EmailService;

/**
 * The Class Scheduler.
 */
@Service
public class Scheduler {
	
	private static final Logger LOG = Logger.getLogger(Scheduler.class);
	
	/** The order tracking DAO impl . */
	@Autowired
	private IOrderTrackingDAO orderTrackingDAO;
	
	/** The user dao. */
	@Autowired
	private IUserDAO userDao;
	
	/** The transaction DAO impl . */
	@Autowired
	private ITransactionDAO transactionDAO;
	
	/** The email service. */
	@Autowired
	private EmailService emailService;

	/**
	 * Check receiver.
	 *
	 * @return the string
	 * @throws BADRequestException the BAD request
	 */
	@Scheduled(fixedRate = Constant.HOURLY)
	public String checkReceiver() {
		List<OrderTracking> receiverInfo = orderTrackingDAO.getListByPendingStatus();
		for (OrderTracking ot : receiverInfo) {
			int userId = 0;
			userId = transactionDAO.getBuyerIdByTransactionId(ot.getTransactionId());
			String email = userDao.getEmailId(userId);
			try {
				emailService.sendMail(email, Constant.SUBJECT, Constant.BODY);
			} catch (BADRequestException e) {
				LOG.error("No sender found");
			}
		}
		return null;
	}
}
