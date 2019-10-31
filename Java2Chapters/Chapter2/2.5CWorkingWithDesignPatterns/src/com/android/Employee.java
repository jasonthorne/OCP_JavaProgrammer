package com.android;

import java.time.LocalDate;

public class Employee {
	/*
	 * with an immutable class each time we add a new variable we have to add this variable to our constructor
	 * and also add it to our builder class
	 * so each new variable has to be added here
	 */
	private final String  name;
	private final LocalDate startDate;
	enum Title{
		MANAGER,SUPERVISOR,GENERAL
	};
	private final Title role;
	private final double wages;
	private final boolean gender;
	private final Human boss;
	private final Animal pet;
	//and new variable has to be added here
	private Employee(String name, LocalDate startDate,Title role, double wages, boolean gender, Human boss, Animal pet) {
		super();
		this.name = name;
		this.role=role;
		this.startDate = startDate;
		this.wages = wages;
		this.gender = gender;
		this.boss = boss;
		this.pet = pet;
	}
	
	static class EmployeeBuilder{
		private String name;
		private LocalDate startDate;
		private Title role;
		private double wages;
		private boolean gender;
		private Human boss;
		private Animal pet;
		//new variable has to be added here and a setter for that variable
		public EmployeeBuilder setName(String name) {
			this.name=name;
			return this;
		}
		
		public EmployeeBuilder setStartDate(LocalDate startDate) {
			this.startDate=startDate;
			return this;
		}
		
		public EmployeeBuilder setWages(double wages) {
			this.wages=wages;
			return this;
		}
		
		public EmployeeBuilder setGender(boolean gender) {
			this.gender=gender;
			return this;
		}
		
		public EmployeeBuilder setBoss(Human boss) {
			this.boss=boss;
			return this;
		}
		
		public EmployeeBuilder setPet(Animal pet) {
			this.pet=pet;
			return this;
		}
		
		public EmployeeBuilder setRole(Title role) {
			this.role=role;
			return this;
		}
		//new setter for new variable here
		
		public Employee build() {
			//new variable has to be added here
			return new Employee(name,startDate,role,wages,gender,boss,pet);
		}
	}
	
	
	
	
	

}
