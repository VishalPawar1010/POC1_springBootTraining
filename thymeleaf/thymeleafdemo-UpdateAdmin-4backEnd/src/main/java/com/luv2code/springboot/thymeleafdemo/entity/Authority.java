package com.luv2code.springboot.thymeleafdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authority {

	// define fields

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "username")
	private String username;

	@Column(name = "authority")
	private String authority;

	// define constructors

	public Authority() {

	}

	public Authority(String username, String authority) {
		this.username = username;
		this.authority = authority;

	}

	// define getter/setter




	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	// define tostring

	@Override
	public String toString() {
		return "Authority [username=" + username + ", authority=" + authority + "]";

	}
	
		
}
