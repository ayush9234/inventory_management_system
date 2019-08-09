package com.dms.dto;

/**
 * The Class PasswordUpdateDto.
 */
public class PasswordUpdateDTO {

	/** The user id. */
	private int userId;

	/** The old password. */
	private String oldPassword;

	/** The new password. */
	private String newPassword;

	/**
	 * Gets the user id.
	 *
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Gets the old password.
	 *
	 * @return the oldPassword
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * Sets the old password.
	 *
	 * @param oldPassword the oldPassword to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * Gets the new password.
	 *
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * Sets the new password.
	 *
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * Instantiates a new password update DTO.
	 *
	 * @param userId the user id
	 * @param oldPassword the old password
	 * @param newPassword the new password
	 */
	public PasswordUpdateDTO(int userId, String oldPassword, String newPassword) {
		super();
		this.userId = userId;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

	/**
	 * Instantiates a new password update DTO.
	 */
	public PasswordUpdateDTO() {}
}
