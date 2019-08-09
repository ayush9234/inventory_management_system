package com.dms.util;

import java.util.Random;

/**
 * The Class PasswordGenerator.
 */
public class PasswordGenerator {
	
	/**
	 * Gets the new password.
	 *
	 * @return the new password
	 */
	public String getNewPassword() {

		final int PASSWORDLENGTH = 10;
		final String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder stringBuilder = new StringBuilder();
		Random random = new Random();
		while (stringBuilder.length() < PASSWORDLENGTH ) {
			int index =  (int) (random.nextFloat() * SALTCHARS.length());
			stringBuilder.append(SALTCHARS.charAt(index));
		}
		return stringBuilder.toString();
	}
}
