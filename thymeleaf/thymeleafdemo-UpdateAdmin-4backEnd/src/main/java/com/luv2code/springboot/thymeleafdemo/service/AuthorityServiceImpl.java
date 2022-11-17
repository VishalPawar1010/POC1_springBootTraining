package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.thymeleafdemo.dao.AuthorityRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Authority;


@Service
public class AuthorityServiceImpl implements AuthorityService {
	
	private AuthorityRepository authorityRepository;
	
	@Autowired
	public AuthorityServiceImpl(AuthorityRepository theAuthorityRepository) {
		authorityRepository = theAuthorityRepository;
	}

	@Override
	public List<Authority> findAll() {
		return authorityRepository.findAll();
	}

	@Override
	public Authority findById(int theString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Authority theAuthority) {
		authorityRepository.save(theAuthority);
		
	}

	@Override
	public void deleteByString(int theString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Authority> searchBy(String theName) {
		// TODO Auto-generated method stub
		return null;
	}

}
