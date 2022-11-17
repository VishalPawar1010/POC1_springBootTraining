package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Authority;


public interface AuthorityService {

	public List<Authority> findAll();
	
	public Authority findById(int theString);
	
	public void save(Authority theAuthority);
	
	public void deleteByString(int theString);

	public List<Authority> searchBy(String theName);
	
}
