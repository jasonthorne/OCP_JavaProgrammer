package com.android;

import java.util.function.Predicate;

public class Animal {
	
	/*
	 * This is a class which has the name of the species and 2 boolean values hope and swim.
	 * If the animal can hop, then the hop boolean value will be true, otherwise it will be false.
	 * 
	 * If the animal can swim, then the swim boolean valuw will be true. Otherwise it will be false. 
	 */
	
	private boolean hop; //can the animal hop, true or false
	private boolean swim; //can the animal swim, true or false
	private String name; //name of the species of Animal
	
	
	//Animal constructor
	Animal(String name, boolean hop, boolean swim){
		this.name = name;
		this.hop=hop;
		this.swim=swim;
	}
	
	/*
	 * this will return true or false, and will print out "can hop" if the animal can hop, and "cannot hop" if it can't.
	 */
	public boolean canHop() {
		if(hop)
			System.out.println(name+" can hop.");
		else
			System.out.println(name+" cannot hop.");
		return hop;
	}
	
	public boolean canSwim() {
		if(swim)
			System.out.println(name+" can swim.");
		else
			System.out.println(name+" cannot swim.");
		return swim;
	}
	
	
	/*
	 * This takes as params an Animal object and a predicate that itself takes in an Animal and returns true or false.
	 */
	
	/*
	 * ]This method takes an Animal which will be a fish or a rabbit, and a predicate which will be the implementation of the boolean test(Object obj)
	 * method of the built in function interface called Predicate.
	 * The test method can take in any object, however here we have said that the object test takes in will be an Animal.
	 * The body of the predicate will retur ntrue or false, which will be an Anima lobject calling the canHop() or canSwim() method.
	 */
	public static void print(Animal animal, Predicate<Animal>trait) {
		trait.test(animal); //calling the trait method thats being passed and passing it the animal that's also being passed. Its implementation is in the 'print' method call.
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
