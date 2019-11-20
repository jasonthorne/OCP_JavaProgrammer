package com.android;

public class Examples {
	
	static void ex1() {
		
		
		try {
			//valid args will print out what we want
			Human harry = new Human("Harry", 5);
			System.out.println("Our human is created.");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		try {
			//invalid string
			Human helen = new Human(null, 24);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			//invalid string
			Human harriet = new Human(" ", 24);
			System.out.println("human with spaces created");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			//invalid string
			Human bob = new Human("", 24);
			System.out.println("human with no length string created");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			//invalid age
			Human bill = new Human("ben", -1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			//invalid sting and age. only gets to invalid sting message 
			Human bob = new Human("", -1);
		}catch(Exception e) {
			System.out.println(e.getMessage()); //second error message isnt shown
		}
		
		
	}//ex1
	
	
	static void ex2() {
		
		System.out.println("IS-A relationship");
		/*
		 * see Employee file for all of these classes. 
		 * The object eddie is an employee
		 * The accountant andy is a Employee and a Accountant and an object
		 * The astronougt annie is a Astronought and a Employeeand an object
		 * ,and when a class implements an interface, it is also said to be a "IS-A" relationship.
		 * So Astronnaut IS-A Movement();
		 */
		Employee eddie = new Employee();
		Accountant Andy = new Accountant();
		Astronaut annie = new Astronaut();
		
		annie.fly();
		annie.walk();
	}
	
	
	static void ex3() {
		
		System.out.println("HAS-A relationship");
		
		/*
		 * A fish HAS scales
		 * A bird has feathers
		 * An objkect has a particular property or value
		 * If a superclass has a public or protected attribute thne the subclass also has this attribute.
		 */
	}
	

}
