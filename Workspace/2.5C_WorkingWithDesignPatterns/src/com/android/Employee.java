package com.android;

import java.time.LocalDate;

//IMMUTABLE BUILDER ++++++++++++++++++++++++++++++++++++++

public final class Employee {
	
	/*
	 * With a MUTABLE (cannot change) class, each time we add a new variable, we have to add this to ur constructor,
	 * and also a getter for this to our builder class.
	 * And also make sure we are calling the right constructor in the builder class.
	 */
	
	private final String name;
	private final LocalDate startDate;
	
	//this enum is not private so it can be accessed outside this class
	enum Title{
		MANAGER, SUPERVISOR, GENERAL;
	}
	private final Title role;
	private final double wages;
	private final boolean gender;
	//private final Human boss;
	//private final Animal pet;
	static int empCount=0;
	
	//any new variable has to bee added in here:
	//constructor is private, so cant create a Employee from anywhere other than within this class. ++++++++++++
	private Employee(String name, LocalDate startDate, Title role, double wages, boolean gender) { 
		super();
		empCount++;
		System.out.println("Employee: " + empCount + " created");
		this.name = name;
		this.startDate = startDate;
		this.role = role;
		this.wages = wages;
		this.gender = gender;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", startDate=" + startDate + ", role=" + role + ", wages=" + wages
				+ ", gender=" + gender + "]";
	}




	//==========================================BUILDER:===================================
	static class EmployeeBuilder{
		
		/*has to have the same var types as the Employee class: 
		 * As these aren't final, this will allow the Employee (which is final) to have default values.
		 */
		
		
		//THe steers below ONLY GIVE VALUES TO THESE VARS. (not an instantiated object like for a mutable class builder)
		private String name; //default is null
		private LocalDate startDate; //default is null
		private Title role; //default is null
		private double wages; //default is 0.0
		private boolean gender; //default is false
		
		//-------------
		
		//setters for all of our variables:
		public EmployeeBuilder setName(String name) {
			this.name = name;
			return this;
		}
		public EmployeeBuilder setStartDate(LocalDate startDate) {
			this.startDate = startDate;
			return this;
		}
		public EmployeeBuilder setRole(Title role) {
			this.role = role;
			return this;
		}
		public EmployeeBuilder setWages(double wages) {
			this.wages = wages;
			return this;
		}
		public EmployeeBuilder setGender(boolean gender) {
			this.gender = gender;
			return this;
		}
		

		//-------------
		//return a newly constructed Employee object.
		public Employee build() {
			return new Employee(name, startDate, role, wages, gender);
		}
		
		
	}//end of Builder
	

}
