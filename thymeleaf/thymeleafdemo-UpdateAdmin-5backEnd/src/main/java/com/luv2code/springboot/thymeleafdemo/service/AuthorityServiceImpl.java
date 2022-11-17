package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.thymeleafdemo.dao.AuthorityRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Authority;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;

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
	public Authority findById(int theId) {
		Optional<Authority> result = authorityRepository.findById(theId);

		Authority theAuthority = null;

		if (result.isPresent()) {
			theAuthority = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find Role id - " + theId);
		}

		return theAuthority;
	}

	@Override
	public void save(Authority theAuthority) {
		authorityRepository.save(theAuthority);

	}

	@Override
	public List<Authority> searchBy(String theName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

}
