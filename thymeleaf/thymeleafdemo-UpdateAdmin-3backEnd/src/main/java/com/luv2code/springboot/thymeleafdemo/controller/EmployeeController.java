package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/users")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	//  Updating authorization by admin
	
	@GetMapping("/showUpdatePosition")
	public String showUpdatePosition(Model theModel) {
		
		// create model attribute to bind form data
		Employee theAdmin = new Employee();
		
		theModel.addAttribute("users", theAdmin);
		
		return "/users/systems";
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// get employees from db
		List<Employee> theEmployees = employeeService.findAll();
		
		// add to the spring model
		theModel.addAttribute("users", theEmployees);
		
		return "/users/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("users", theEmployee);
		
		return "/users/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("usersId") int theId,
									Model theModel) {
		
		// get the employee from the service
		Employee theEmployee = employeeService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("users", theEmployee);
		
		// send over to our form
		return "/users/employee-form";			
	}
	
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("users") Employee theEmployee) {
		
		// save the employee
		employeeService.save(theEmployee);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/users/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("usersId") int theId) {
		
		// delete the employee
		employeeService.deleteById(theId);
		
		// redirect to /employees/list
		return "redirect:/users/list";
		
	}
	
	@GetMapping("/search")
	public String delete(@RequestParam("usersName") String theName,
						 Model theModel) {
		
		// delete the employee
		List<Employee> theEmployees = employeeService.searchBy(theName);
		
		// add to the spring model
		theModel.addAttribute("users", theEmployees);
		
		// send to /employees/list
		return "/users/list-employees";
		
	}
	
	
	
}


















