package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Authority;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.AuthorityService;


@Controller
@RequestMapping("/employees")
public class AuthorityController {

	private AuthorityService authorityService;
	

	public AuthorityController (AuthorityService theAuthorityService) {
		authorityService = theAuthorityService;
	}


	// add mapping for "/list" for authority
	@GetMapping("/data")
	public String listAuthorities(Model theModel) {
		
		// get employees from db
		List<Authority> theAuthorities = authorityService.findAll();
		
		// add to the spring model
		theModel.addAttribute("employees", theAuthorities);
		
		return "/employees/systems";
	}
	
	

	@GetMapping("/showFormToAddRole")
	public String showFormToAddRole(Model theModel) {
		
		// create model attribute to bind form data
		Authority theAuthority = new Authority();
		
		theModel.addAttribute("Role", theAuthority);
		
		return "employees/Role-form";
	}
	
	@PostMapping("/saveRole")
	public String saveRole(@ModelAttribute("Role") Authority theAuthority) {
		
		// save the employee
		authorityService.save(theAuthority);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/data";
	}
	
	@GetMapping("/showRoleForUpdate")
	public String showRoleForUpdate(@RequestParam("roleId") int theId,
									Model theModel) {
		
		// get the employee from the service
		Authority theAuthority = authorityService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("Role", theAuthority);
		
		// send over to our form
		return "/employees/Role-form";			
	}
}


















