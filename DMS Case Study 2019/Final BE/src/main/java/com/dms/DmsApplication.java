package com.dms;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * The Class DmsApplication.
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class DmsApplication {
	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(DmsApplication.class);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		LOG.info("inside main");
		SpringApplication.run(DmsApplication.class, args);
	}
}
