package com.android;

import java.util.function.Predicate;

/*
 * this is a class which has the name of the species and two boolean values
 * hop and swim
 * if the animal can hop, then the hop boolean value will be true, otherwise it will
 * be false
 * if the Animam can swim, then the swim boolean value will be true, othersiw it will 
 * be false
 */
public class Animal {
	//can the Animal hop, true if it can, false if not
	public boolean hop;
	//can the animal swim or not, true if can, false if not
	public boolean swim;
	//name of the species of Animal
	String name;
	
	//Animal constructor
	Animal(String name,boolean hop,boolean swim){
		this.name=name;
		this.swim=swim;
		this.hop=hop;
	}
	/*
	 * this will be used as part of the predicate as this returns a boolean (we could alos just 
	 * use the "hop" variable as this is a boolean, this method is just to print out if the Animal can
	 * hop or not
	 */
	public boolean canHop() {
		if(hop) {
			System.out.println(name+" can hop");
		}
		else
			System.out.println(name+" cannot hop");
		return hop;
	}
	
	public boolean canSwim() {
		if(swim) {
			System.out.println(name+" can swim");
		}
		else
			System.out.println(name+" cannot swim");
		return swim;
	}
	
	/*
	 * this method takes an Animal, which will be a fish or a rabbit, and a predicate expression, which will be 
	 * a implmentation of the boolean test(object obj) of the built in function interface called Predicate. 
	 * the test method takes in any object and returns a boolean (true/false), in our case it will be a fish or a
	 * rabbit Animal object both calling the canHop() and canSwim() method
	 */
	public static void print(Animal animal,Predicate<Animal>trait) {
		trait.test(animal);
	}
	

}
