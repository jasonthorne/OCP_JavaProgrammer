package com.android;

class Employee{
	
	//vars:
	int age;
	String name;
	
	//constructors:
	Employee(){
		System.out.println("Employee created with no args constructor");
	}
	
	Employee(int age, String name){
		this.age = age;
		this.name = name;
		System.out.println("employee created with constructor in string");
	}
	
	//methods:
	void earnMoney() {
		System.out.println("Employee earing money");
	}
	
	void doWork() {
		System.out.println("Employee working");
	}
	
}


//building is a top level class:
public class Building {
	
	Employee eddie;
	int size=400;
	
	Building(){
		System.out.println("Building constructor called");
		
		/*
		 * An anonymous inner class is a way to redefine a class where we can overrride methods or even declare new methods and variables
		 */
		
		eddie = new Employee() {
			
			/*
			 * This is an anonymous class implementation eddie the employee object.
			 * Which allows us to tailor the object to be specific to Eddie.
			 */
			
			/*You cant have a constructor inside an anonymous inner class
			However you can have initialisers*/
			{
				System.out.println("You cant have a constructor inside an anonymous inner class. However you can have initialisers");
			}
			
			/*
			 * variables and methods first created inside an anonymous inner class are only avaliable inside the anonymous inner class.
			 */
			int newVar = 90; //only available inside the curly brackets
			
			/*
			 * You can override methods in an anonomous inner class.
			 * Here we are overriding the earnMoney method from the employee class.
			 */
			@Override
			void earnMoney() {
				
				System.out.println("This is eddie's own earnMoney() method");
				System.out.println("new var is: " + newVar);
				payTax();
				doWork();
			}
			
			void payTax() {
				System.out.println("eddie paying tax");
			}
			
			
		};//end of anonymous inner class
		
		//System.out.println(eddie.newVar); //no longer exists so cant be referenced.
		//eddie.payTax();  //no longer exists so can't be referenced.
		eddie.earnMoney(); //referenced outside of the anonymous inner class, so still exists.
		eddie.doWork(); //from the Employee class and not overridden.
		
	}//end of Building constructor

}
