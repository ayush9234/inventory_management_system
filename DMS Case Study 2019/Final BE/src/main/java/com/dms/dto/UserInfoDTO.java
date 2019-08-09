package com.dms.dto;

/**
 * The Class UserInfoDTO.
 */
public class UserInfoDTO {
	
	/** The user id. */
	private int userId;
	
	/** The user name. */
	private String userName;
	
	/** The role type. */
	private Integer roleType;
	
	/** The result. */
	private boolean result = false;

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
	 * Gets the user name.
	 *
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the role type.
	 *
	 * @return the roleType
	 */
	public Integer getRoleType() {
		return roleType;
	}

	/**
	 * Sets the role type.
	 *
	 * @param roleType the roleType to set
	 */
	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	/**
	 * Checks if is result.
	 *
	 * @return the result
	 */
	public boolean isResult() {
		return result;
	}

	/**
	 * Sets the result.
	 *
	 * @param result the result to set
	 */
	public void setResult(boolean result) {
		this.result = result;
	}

	/**
	 * Instantiates a new user info DTO.
	 *
	 * @param userId the user id
	 * @param userName the user name
	 * @param roleType the role type
	 * @param result the result
	 */
	public UserInfoDTO(int userId, String userName, Integer roleType, boolean result) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.roleType = roleType;
		this.result = result;
	}

	/**
	 * Instantiates a new user info DTO.
	 */
	public UserInfoDTO() {}
}
