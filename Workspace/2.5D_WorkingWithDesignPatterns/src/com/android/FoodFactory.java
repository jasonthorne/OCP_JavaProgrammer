package com.android;

public class FoodFactory {
	
	/*
	 * Eaqch one of these static methods return a food object. 
	 * What type of food is dependent on what Animal is sent to this method.
	 * This is determined HERE at runtime via a case statement. 
	 */
	
	/*this switch statement is THE FACTORY (which is a method that produces objects).
	 * Different objects will be produced and the type of object is dependent on the string sent to this method at runtime.
	*/
	public static Food getFood(String animalName) {
		System.out.println("using a string to determine food type");
		
		switch(animalName) {
			case "Zebra":
				return new Hay(100); //NO BREAK needed, as this exits the METHOD (not just switch :P) with a Hay obj
			case "Rabbit":
				return new Vegetable(5);
			case "Goat":
				return new Hay(70);
			case "PolarBear":
				return new Fish(25);
			case "Lion":
				return new Meat(34);
				
			/*
			 * The issue with using strings is that they are case sensitive and spelling sensitive. 
			 * i.e for Zebra, it has to be the exact same spelling and case.
			 * Also this can take literally any string.
			 */
		}
		
		//throw new UnsupportedOperationException("Unsupported animal:" + animalName);
		return null;
	}

}
