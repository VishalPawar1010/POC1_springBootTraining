package com.luv2code.springdemo;

public class BaseballCoach implements Coach{
	
	
	// Define a private field for dependency
	private FortuneService fortuneService;
	
	// Define a constructor for dependency Injection
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minuts on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// use my fortuneService to get fortune
		
		return fortuneService.getFortune();
	}

}
