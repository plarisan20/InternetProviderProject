package com.javastack.spring.internetprovider.models;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

// No @Entity or @Table annotations- because we are not saving it to the DB
public class LoginUser {
	
	@NotEmpty(message="Please enter your Username")
	@Size(min=3, max=30, message="Username must be more than 3 characters")
	private String userName;
	
	@NotEmpty(message="Password is required!")
	@Size(min=8, max=60, message="Password must be between 8 and 60 characters")
	@Column(columnDefinition="TEXT")
	private String password;
	
	public LoginUser() {}


	public LoginUser(
			@NotEmpty(message = "Please enter your Username") @Size(min = 3, max = 30, message = "Username must be more than 3 characters") String userName,
			@NotEmpty(message = "Password is required!") @Size(min = 8, max = 60, message = "Password must be between 8 and 60 characters") String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
