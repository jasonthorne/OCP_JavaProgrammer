package com.android;

import java.time.LocalDate;
/*
 * this is using a inner static class HumanBuilder class to create a Human object, the advantage of this is that you can make your
 * Human Constructor private and this can be accessed inside the inner static class
 */
public class Human {
	private  int age;
	private  String name;
	private  double weight;
	/*
	 * we add these after we first create our file, all we have to do is then have setter for each one of these variables
	 * in the inner static HumanBuilder class
	 */
	private double height;
	private LocalDate dob;
	/*
	 *we can choose to use this constructor or not
	 */
	private Human(int age,String name,double weight) {
		this.age=age;
		this.name=name;
		this.weight=weight;
	}
	//we will use this constructor instead
	private Human() {
		
	}
	
	public String toString() {
		return "age is "+age+" date of birth is "+dob;
	}
	
	static class HumanBuilder{
		/*
		 * this is the variable that will be returned by the build method, so each of these getters will be giving a value to 
		 * each of this Human's variables
		 */
		private Human myHuman=new Human();
	//age of human
		public HumanBuilder setAge(int age) {
			myHuman.age=age;
			return this;//returns HumanBuilder object
		}
		public HumanBuilder setName(String name) {
			myHuman.name=name;
			return this;
		}
		public HumanBuilder setWeight(double weight) {
			myHuman.weight=weight;
			return this;
		}
		
		public HumanBuilder setHeight(double height) {
			myHuman.height=height;
			return this;
		}
		
		public HumanBuilder setDob(LocalDate dob) {
			myHuman.dob=dob;
			return this;
		}
		public Human build() {
			/*
			 * rather than call the constructor that creates a human we just pass the myHuman back to the calling method and will
			 * only have the required variables that you want
			 */
			return myHuman;
		}
	}

}
