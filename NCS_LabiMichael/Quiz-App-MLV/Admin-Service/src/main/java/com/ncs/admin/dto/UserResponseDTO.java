package com.ncs.admin.dto;

public class UserResponseDTO {

	private int userId;
	private String username;
	private String role;
	private String email;
	
	
	
	
	public UserResponseDTO() {
		super();
		
	}
	public UserResponseDTO(int userId, String username, String role, String email) {
		super();
		this.userId = userId;
		this.username = username;
		this.role = role;
		this.email = email;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserResponseDTO [userId=" + userId + ", username=" + username + ", role=" + role + ", email=" + email
				+ "]";
	}
	
}
