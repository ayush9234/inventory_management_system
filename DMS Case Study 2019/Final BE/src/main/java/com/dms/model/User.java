package com.dms.model;

import java.time.LocalDateTime;

/**
 * The Class User.
 */
public class User{

	
	/** The user id. */
	private Integer userId;

	/** The user name. */
	private String userName;
	
	/** The password. */
	private String password;
	
	/** The email. */
	private String email;
	
	/** The personal anddress. */
	private String personalAddress;
	
	/** The contactno. */
	private String contactno;
	
	/** The user status. */
	private String userStatus;
	
	/** The role type. */
	private Integer roleType;
	
	/** The area. */
	private String area;
	
	/** The creation time. */
	private LocalDateTime creationTime;
	
	/** The updation time. */
	private LocalDateTime updationTime;

	/**
	 * Gets the user id.
	 *
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the userIame
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user iame.
	 *
	 * @param userIame the userIame to set
	 */
	public void setUserName(String userIame) {
		this.userName = userIame;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the personal anddress.
	 *
	 * @return the personalAnddress
	 */
	public String getPersonalAddress() {
		return personalAddress;
	}

	/**
	 * Sets the personal address.
	 *
	 * @param personalAddress the personalAddress to set
	 */
	public void setPersonalAddress(String personalAddress) {
		this.personalAddress = personalAddress;
	}

	/**
	 * Gets the contactno.
	 *
	 * @return the contactno
	 */
	public String getContactno() {
		return contactno;
	}

	/**
	 * Sets the contactno.
	 *
	 * @param contactno the contactno to set
	 */
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	/**
	 * Gets the user status.
	 *
	 * @return the userStatus
	 */
	public String getUserStatus() {
		return userStatus;
	}

	/**
	 * Sets the user status.
	 *
	 * @param userStatus the userStatus to set
	 */
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
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
	 * Gets the area.
	 *
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * Sets the area.
	 *
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * Gets the creation time.
	 *
	 * @return the creationTime
	 */
	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	/**
	 * Sets the creation time.
	 *
	 * @param creationTime the creationTime to set
	 */
	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * Gets the updation time.
	 *
	 * @return the updationTime
	 */
	public LocalDateTime getUpdationTime() {
		return updationTime;
	}

	/**
	 * Sets the updation time.
	 *
	 * @param updationTime the updationTime to set
	 */
	public void setUpdationTime(LocalDateTime updationTime) {
		this.updationTime = updationTime;
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param userId the user id
	 * @param userName the user name
	 * @param password the password
	 * @param email the email
	 * @param personalAddress the personal address
	 * @param contactno the contactno
	 * @param userStatus the user status
	 * @param roleType the role type
	 * @param area the area
	 * @param creationTime the creation time
	 * @param updationTime the updation time
	 */
	public User(Integer userId, String userName, String password, String email, String personalAddress,
			String contactno, String userStatus, Integer roleType, String area, LocalDateTime creationTime,
			LocalDateTime updationTime) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.personalAddress = personalAddress;
		this.contactno = contactno;
		this.userStatus = userStatus;
		this.roleType = roleType;
		this.area = area;
		this.creationTime = creationTime;
		this.updationTime = updationTime;
	}
	
	/**
	 * Instantiates a new user.
	 */
	public User() {}
}
