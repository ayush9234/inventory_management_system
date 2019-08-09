package com.dms.exception;

/**
 * The Class BADRequestException.
 */
public class BADRequestException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new BAD request.
	 *
	 * @param message the message
	 */
	public BADRequestException(String message) {
		super(message);
	}
}
