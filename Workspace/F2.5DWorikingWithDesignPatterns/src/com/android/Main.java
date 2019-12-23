package com.android;

import java.util.Arrays;

public class Main {
/**
 * the Factory pattern is also referred to as the "Factory Method Pattern"
 * how do we create objects in which the precise type of object is not known until runtime.
 * some method of is needed in selecting which sub class to use (i.e subclass of Animal is
 * Lion and Goat and determine at runtime that we will be creating a meat object to feed
 * to the Lion)
 * this is a creational pattern that uses a Factory class to produce instances of objects
 * based on a set of input parameters.
 * Often implemented by using static methods, so do not need an instance of the Factory
 * class.
 * Also considered good practice to postfix the word "Factory" to the end of the Class name
 * i.e FoodFactory
 * @param args
 */
	public static void main(String[] args) {
		/*
		 * this calls the first type of FoodFactory method, which is a method that takes a
		 * String and returns a certain food type, depending on what the string is
		 */
		//this will create a Fish Food object
		Food food=FoodFactory.getFood("PolarBear");
		//this will call the Fish consumes() method
		food.consumes();
		//this will create a Vegetable food object
		Food food2=FoodFactory.getFood("Rabbit");
		//this will call the Vegetable consumers() method
		food2.consumes();
		/*
		 * the issue with a factory method that takes a string is that you can send it 
		 * any string you want
		 */
		food2=FoodFactory.getFood("Coal");
		food2=FoodFactory.getFood("rabbit");
		
		System.out.println("calling second overloaded FoodFactory method that takes an Animal");
		//this will create a hay food object
		food=FoodFactory.getFood(new Goat());
		//this will call the consumes method for Hay
		food.consumes();
		//this creates a Meat food object
		food=FoodFactory.getFood(new Lion());
		//this will call the consumes method for a meat
		food.consumes();
		/*
		 * this overloaded method CAN ONLY take Animals and the sub classes of Animals
		 */
		StringBuilder sb1=new StringBuilder("hello there");
		//will not compile
		///FoodFactory.getFood(sb1);
		System.out.println("calling third overloaded method that takes a AnimalType enum");
		food=FoodFactory.getFood(AnimalType.GOAT);//create Hay food object
		food.consumes();//calls consumes method for Hay food object
		food=FoodFactory.getFood(AnimalType.POLARBEAR);//creates Fish food object
		food.consumes();//calls consumes method for the Fish food object
		

	}

}
