package com.android;

public class Main {
	
	
	/**
	 * 
	 *The Factory pattern is also refereed to as the Factory Method Pattern.
	 *
	 *How do we create objects in which the precise type of object is not known until runtime.
	 *Some method is needed in selecting which subclass to use.  
	 *(I.E subclass of Animal is lion and goat and determine at runtime that we will be creating a meat object to feed the lion).
	 *
	 *This is a creational pattern that uses a Factory class to produce instances of objects based on a set of imput parameters.
	 *Often implemented by using static methods, so do not need an instance of the factory class.
	 *Also considered good practice to postfix a word "Factory" to the end of the class name. IE "FoodFactory". 
	 */

	public static void main(String[] args) {
		
		/*
		 * This calls the first type of FoodFactory method, 
		 * which is a method that takes a String
		 *  and returns a certain foodtype dependent on what the string is:
		 */
		
		//This will create a fish Food object:
		Food food1 = FoodFactory.getFood("PolarBear");
		
		//this will call the fish's consumes() method:
		food1.consumes();
		
		//This will create a vegetable food object:
		Food food2 = FoodFactory.getFood("Rabbit");
		
		//this will call the Rabbit's consumes() method:
		food2.consumes();
		
		
		//==============================
		//passing an OBJECT into the OVERLOADED getFood method
		System.out.println("\npassing an OBJECT into the OVERLOADED getFood method:");
		food1=FoodFactory.getFood(new Goat());
		food1.consumes();
		
		
		//=============================
		
		
		

	}

}
