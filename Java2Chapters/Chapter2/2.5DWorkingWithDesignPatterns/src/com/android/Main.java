package com.android;

public class Main {
/**
 * The factory pattern is also referred to as the "Factory method pattern"
 * How do we create objects in which the precise type of object is not known until runtime.
 * Some method of selecting which sub class to use (i.e subclass of Animal is Cat and Dog and determine at runtime that we
 * will be creating and using a Dog)
 * This is a creational pattern that uses a Factory class to produce instances of objects based on a set of input parameters.
 * often implemented by using static methods, so do not need an instance of the factory class. 
 * Also considered good practice to postfix the the word factory to the end of a class name .ie AnimalFactory
 * @param args
 */
	public static void main(String[] args) {
		System.out.println("*****THE FACTORY PATTERN");	
		/*
		 * different type of food will be produced dependant on the type of Animal sent to the method
		 * first overloaded FoodFactory method takes a string
		 * second overloaded FoodFactory method takes a Animal object
		 * Third overloaded FoodFactory method takes a AnimalType enum
		 */
		final Food food=FoodFactory.getFood("PolarBear");
		food.consumes();
		/*
		 * only at runTime does it know that a zebra is sent to the method
		 * we implement the factory design pattern
		 */
		final Food food2=FoodFactory.getFood(new Zebra());
		food2.consumes();
		
		Food food3=FoodFactory.getFood(AnimalType.GOAT);
		food3.consumes();
		/*
		 * sending a null results in a compliation error as this could take the any of the getFood() methods,
		 * the one that takes a string can take a null
		 * the one that takes a Animal object can take a null
		 * and enums are also objects so also the method that takes a enum type can take a null
		 */
	//	Food food4=FoodFactory.getFood(null)
		
	

	}
	
	

}
