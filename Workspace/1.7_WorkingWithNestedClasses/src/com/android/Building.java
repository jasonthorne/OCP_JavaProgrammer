package com.android;

class Employee{
	int age;
	String name;
	
	Employee(){
		System.out.println("Employee created withno args constructor");
	}
	
	Employee(int age, String name){
		this.age = age;
		this.name = name;
		System.out.println("employee created with constructor in string");
	}
	
	void earnMoney() {
		System.out.println("Employee earing money");
	}
	
	void doWork() {
		System.out.println("Employee working");
	}
	
}

public class Building {
	
	Employee eddie;
	int size=400;
	
	Building(){
		
		/*
		 * An anonymous inner class is a way to redefine a class where we can overrride methods or even declare new methods and variables
		 */
		
		eddie = new Employee() {
			
			/*
			 * This is an anonymous class implementation eddie the employee object.
			 * Which allows us to tailor the object to be specific to Eddie.
			 */
			
			@Override
			void earnMoney() {
				
			}
		};
		
	}

}
