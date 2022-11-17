package com.luv2code.springsecurity.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@GetMapping("/")
	public String showHome() {
		return "home";
	}

}
