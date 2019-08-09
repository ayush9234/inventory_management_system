package com.dms.util;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

/**
 * The Class PasswordEncoder.
 */
@Component
public class PasswordEncoder {
	
	/**
	 * Hash password.
	 *
	 * @param plainTextPassword the plain text password
	 * @return the string
	 */
	public String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
}
