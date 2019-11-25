package com.android;

//Builder class in an inner static nested class.

/*
 * The advantage of this is you can make your human constructor private, 
 * and this can be accessed inside the inner static class.
 */

public class Human { //Human is a MUTABLE class. 
	
	//These 3 vars are the vars the class starts off with:
	private int age;
	private String name;
	private double weight;
	
	/*
	 * We can CHOOSE to use this constructor or not, as this is a MUTABLE class.
	 * If it was IMMUTABLE, we would HAVE TO use this constructor.
	 */
	private Human(int age, String name, double weight) {
		this.age=age;
		this.name=name;
		this.weight=weight;
	}
	
	//We will use this class instead:
	private Human() {
		System.out.println("Human no args constructor called");
	}
	
	//overriden toString method
	@Override
	public String toString() {
		return "age is: " + age + " name is: " + name + " weight is: " + weight;
	}
	
	
	//==================Builder class:
	static class HumanBuilder{
		
		/*
		 * This is a builder for the Human class
		 * Human is MUTABLE so the first thing we do is create sn insteance of the Human class.
		 * 
		 * This is the object that will be returned by thre final method build(), +++++++++++++++++++++++++++++++++++++
		 * and we will have setters for all of the variables of the Human class.
		 */
		private Human myHuman = new Human();
		
		//setter for age:
		public HumanBuilder setAge(int age) {
			//this int age is a local var:
			if(age<0) {
				age=0;
			}
			myHuman.age = age;
			return this;
		}
		
		//setter for name:
		public HumanBuilder setName(String name) {
			myHuman.name = name;
			return this;
		}
		
		//setter for name:
		public HumanBuilder setWeight(Double weight) {
			myHuman.weight = weight;
			return this;
		}
		
		public Human build() { //return the myHuman object
			
			//add safety code here (eg add john doe, if name wasn't added.
			
			//Below doesnt work as you're trying to access a non static var within a static class: +++++++++++++++++
			/*
			if(age<0) {
				age=0;
			}
			*/
			
			if(myHuman.age<0) {
				myHuman.age=0;
			}
			
			return myHuman;
		}
		
		
		
		
	}//humanBuilder
	
	

}
