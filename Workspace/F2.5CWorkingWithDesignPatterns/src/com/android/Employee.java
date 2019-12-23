package com.android;

import java.time.LocalDate;

public final class Employee {
	@Override
	public String toString() {
		return "Employee [name=" + name + ", startDate=" + startDate + ", role=" + role + ", wages=" + wages
				+ ", gender=" + gender + "]";
	}
	/*
	 * with an IMMUTABLE (cannot change) class each time we add a new variable, we have to 
	 * add this to our constructor and also add a getter for this to our Builder class
	 * and also make sure we are calling the right constructor in the Builder class
	 */
	private final String name;
	private final LocalDate startDate;
	/*
	 * this enum is not private as i want to access this outside of the Employee, but you
	 * could make it private
	 */
	enum Title{
		MANAGER,SUPERVISOR,GENERAL
	}
	private final Title role;
	private final double wages;
	private final boolean gender;
	//will show how many Employees are created
	static int empCount=0;
//	private final Human boss;
//	private final Animal pet;
	//any new variables HAS TO be added in here
	private Employee(String name, LocalDate startDate, Title role, double wages, boolean gender) {
		super();
		//keeps a count of the amount of employees called
		empCount++;
		System.out.println("Employee "+empCount+" created");
		this.name = name;
		this.startDate = startDate;
		this.role = role;
		this.wages = wages;
		this.gender = gender;
	}
	//nested static class to create Employee objects
	static class EmployeeBuilder{
		/*
		 * have to have the same variables types as the Employee class, as these are NOT final
		 * this will allow our Employee, which is Final, to have default values
		 */
		private String name;//default null
		private LocalDate startDate;//default null
		private Title role;//default null
		private double wages;//default 0.0
		private boolean gender;//default false
		//setters for all of our variables
		public EmployeeBuilder setName(String name) {
			this.name=name;
			return this;
		}
		//setter for start date
		public EmployeeBuilder setStartDate(LocalDate startDate) {
			
			this.startDate=startDate;
			return this;
		}
		//setter for role
		public EmployeeBuilder setRole(Title role) {
			this.role=role;
			return this;
		}
		//setter for wages
		public EmployeeBuilder setWages(double wages) {
			this.wages=wages;
			return this;
		}
		//setter for gender
		public EmployeeBuilder setGender(boolean gender) {
			this.gender=gender;
			return this;
		}
		/*
		 * any new variables, put setter for here
		 */
		
		public Employee build() {
			/*
			 * this is using hte private constructor in the Employee class that takes a
			 * String,LocalDate,Role enum, double, boolean
			 */
			return new Employee(name, startDate, role, wages, gender);
		}
	}
	

}
