package com.android;

import java.util.function.Predicate;

public class Animal {
	/*
	 * this is a class which has the name of the species and two boolean
	 * values hop and swim
	 * if the Animal can hop, then the hop boolean value will be true,
	 * otherwise it will be false
	 * if the Animal can swim, then the swim boolean value will be true,
	 * otherwise it will be false
	 */
	private boolean hop;//can the Animal hop, true or false
	private boolean swim;//can the Animal swim, true or false
	private String name;//name of species of Animal
	
	//Animal constructor
	Animal(String name,boolean hop,boolean swim){
		this.name=name;
		this.swim=swim;
		this.hop=hop;
	}
	/*
	 * this will return true or false and will print out, "can hop" if the
	 * animal can hop, and print out "cannot hop" if the Animal cannot hop
	 */
	public boolean canHop() {
		if(hop)
			System.out.println(name+" can hop");
		else
			System.out.println(name+" cannot hop");
		return hop;
	}
	
	public boolean canSwim() {
		if(swim)
			System.out.println(name+" can swim");
		else
			System.out.println(name+" cannot swim");
		return swim;
	}
	/*
	 * this takes as parameters a Animal object and a predicate that itslef
	 * takes in an Animal and returns true or false
	 * This method takes an Animal, which will be a fish or a rabbit, and 
	 * a predicate, whihc will be the implmenation of the boolean test(Object obj)
	 * method of the built in functional interface called predicate. 
	 * the test method can take in any object, however here we have said that the
	 * object test takes in, will be a Animal.
	 * the body of the predicate will return true or false, which will be 
	 * an Animal object calling the canHop() or canSwim() method
	 */
	public static void print(Animal animal,Predicate<Animal>trait) {
		trait.test(animal);
	}
	

}
