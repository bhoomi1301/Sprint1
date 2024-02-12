package com.spring.tatms.model;

import com.spring.tatms.entity.ApplicationUser;

public class LoginResponseDTO {

	private ApplicationUser user; 
	private String jwt;
	
	public LoginResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginResponseDTO(ApplicationUser user, String jwt) {
		super();
		this.user = user;
		this.jwt = jwt;
	}

	public ApplicationUser getUser() {
		return this.user; 
	}

	public void setUser(ApplicationUser user) {
		this.user = user;
	}

	public String getJwt() {
		return this.jwt; 
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	
}
