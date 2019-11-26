package com.android;

import java.time.LocalDate;

//MUTABLE BUILDER ++++++++++++++++++++++++++++++++++++++++++++++++++

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
	
	
	//========================WE ADDD THESE VARS AT A LATER DATE:=======================
	//so all we need ot add in is setters in the humanBuilder class for both these vars
	private double height;
	private LocalDate dob;
	//=================================================================================
	
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
	//constructor is private, so a Human cant be created anywhere toher than in ths iclass ++++++++++++++
	private Human() {
		System.out.println("Human no args constructor called"); 
	}
	
	//overriden toString method
	@Override
	public String toString() {
		return "age is: " + age + ".name is: " + name + ".weight is: " + weight + ".height is: " + height + ".dob is: " + dob;
	}
	
	
	//==================Builder class: You can now ONLY make a Huamn through this Builder class. ++++++++++++
	static class HumanBuilder{ //Being a static this can ONLY access statics directly +++++++++++++
		
		/*
		 * This is a builder for the Human class
		 * Human is MUTABLE so the first thing we do is create sn insteance of the Human class.
		 * 
		 * This is the object that will be returned by the final method build(), +++++++++++++++++++++++++++++++++++++
		 * and we will have setters for all of the variables of the Human class.
		 */
		private Human myHuman = new Human(); //MUTABLE classes need an instance of this class
		
		//setter for age:
		public HumanBuilder setAge(int age) {
			//this age is a local var:
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
		
		public HumanBuilder setHeight(double height) {
			if(height<=0)
					height=1.0;
			myHuman.height=height;
			return this;
		}
		
		public HumanBuilder setDob(LocalDate dob) {
			myHuman.dob=dob;
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
