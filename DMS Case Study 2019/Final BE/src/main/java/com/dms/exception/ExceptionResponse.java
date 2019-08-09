package com.dms.exception;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * The Class ExceptionResponse.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ExceptionResponse {

	/** The error message. */
	private String errorMessage;

	/** The requested URI. */
	private String requestedURI;

	/**
	 * Gets the error message.
	 *
	 * @return the errorMessage
	 */

	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Instantiates a new exception response.
	 *
	 * @param timestamp    the timestamp
	 * @param errorMessage the error message
	 * @param requestedURI the requested URI
	 * @param status       the status
	 */
	public ExceptionResponse(Date timestamp, String errorMessage, String requestedURI, int status) {
		super();
		this.errorMessage = errorMessage;
		this.requestedURI = requestedURI;
	}

	/**
	 * Sets the error message.
	 *
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Gets the requested URI.
	 *
	 * @return the requestedURI
	 */
	public String getRequestedURI() {
		return requestedURI;
	}

	/**
	 * Caller URI.
	 *
	 * @param requestedURI the requestedURI to set
	 */
	public void callerURI(String requestedURI) {
		this.requestedURI = requestedURI;
	}

}
