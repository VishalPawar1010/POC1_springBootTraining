package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	public CricketCoach() {
		System.out.println("CricketCoach : Inside no-arg constructor !! ");
	}
	

	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach : Inside setter method for email id");

		this.emailAddress = emailAddress;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		System.out.println("CricketCoach : Inside setter method for team");

		this.team = team;
	}


	// setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach : Inside setter method"
				+ " !! ");

		this.fortuneService = fortuneService;
	}



	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "practice fast bowling for 15 minuts ! !!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();

	}

	public static void main(String[] args) {

	}

}
