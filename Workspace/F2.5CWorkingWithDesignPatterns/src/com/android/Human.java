package com.android;

import java.time.LocalDate;

/*
 * we are going to use a inner static nested class to create a Human object, this advantage
 * of this is that you can make your Human constructor private and this can be accessed inside
 * the inner static class
 */
public class Human {//Human is a MUTABLE class
	//these are the three variables our class starts off with
	private int age;
	private String name;
	private double weight;
	/*
	 * we add these variables at a later date, so all we need to add in is setters in the
	 * HumanBuilder class for both of these variables.
	 */
	private double height;
	private LocalDate dob;
	static int humanCounter=0;
	/*
	 * we can choose to use the this constructor or not as this is a MUTABLE class
	 * if it was IMMUTABLE, we would HAVE TO use this constructor
	 */
	private Human(int age,String name,double weight) {
		this.age=age;
		this.name=name;
		this.weight=weight;
		humanCounter++;
	}
	//we will use this constructor instead
	private Human() {
		System.out.println("Human no args constructor called");
		humanCounter++;
	}
	//this is our overriden toString method
	@Override
	public String toString() {
		return "age is "+age+" name is "+name+" weight is "+weight+" height is "+height+" "
				+ "date of birth is "+dob;
	}
	/*
	 * this is a nested class of the Human class (inner static classes are also called 
	 * nested classes)
	 */
	static class HumanBuilder{
		/*
		 * this is a Builder for the Human class, Human class is MUTABLE, which means the first
		 * thing we do is create a private instance of the Human class
		 * this will be the object that will be returned by the final method, build() and we
		 * will have setters for all of the variables of the Human class
		 */
		private Human myHuman=new Human();
		static int statInt=0;
		int id;
		//setter for age of Human
		public HumanBuilder setAge( int age) {
			/*
			 * id is a instance variable of hte HumanBuilder class, and we are inside a 
			 * instance method so we CAN access the variable id
			 */
			id=3;
			//we can also access statics of the HumanBuilder class in an instance method
			statInt++;
			//this int age is a LOCAL variable
			/*
			 * if i pass in a minus number, this will give age a new value of 1
			 */
			if(age<=0)
				age=1;
			/*
			 * cannot access age directly as this is a static nested class, so we first create
			 * a Human object, then we access the age of that Human
			 */
			myHuman.age=age;
			return this;
		}
		//setter for name of Human
		public HumanBuilder setName(String name) {
			/*
			 * if i pass in a null string, this will assign the value "joan Doe" to the 
			 * name of the Human myHuman
			 */
			if(name==null)
				name="joan doe";
			myHuman.name=name;
			return this;
		}
		//setter for weight of Human
		public HumanBuilder setWeight(double weight) {
			/*
			 * if weight is a minus or 0 then will assign the value 0.1 to the weight of 
			 * the Human myHumaan
			 */
			if(weight<=0)
				weight=0.1;
			myHuman.weight=weight;
			return this;
		}
		
		public HumanBuilder setHeight(double height) {
			// I don't want a zero or minus height, so if minus or zero sent to method
			//will change to 1.0
			if(height<=0)
				height=1.0;
			myHuman.height=height;
			return this;
		}
		
		public HumanBuilder setDob(LocalDate dob) {
			myHuman.dob=dob;
			return this;
		}
		
		static void statMethod() {
			//id=9;
		}
		
		public Human build() {
			/*
			 * this is a static variable of the outer Human class, which we can access
			 * directly. As nested static classes can access all static variables of the 
			 * outer class directly, the outer class here is Human, so we can access all
			 * of the static variables and methods of the Human class
			 * humanCounter is a static variable of the Human class, so we can access it
			 * directly here
			 */
			System.out.println("amount of Humans created is "+humanCounter);
			/*
			 * there is no LOCAL variable age
			 * there is no instance variable of the HumanBuilder() class called age
			 * it next looks in the outer class for a STATIC variable called age, there is
			 * NO static variable in the outer Human  class called age, there is only an 
			 * instance variable called age, which this static class has no access too
			 */
			//System.out.println(age);
			return myHuman;
		}
		
	}//end of nested HumanBuilder class
	
}//end of Human class
