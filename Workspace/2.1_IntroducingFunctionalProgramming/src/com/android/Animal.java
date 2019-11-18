package com.android;

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
			System.out.println(name+ "can hop.");
		else
			System.out.println(name+ "cannot hop.");
		return hop;
	}
	
	public boolean canSwin() {
		if(swim)
			System.out.println(name+ "can swim.");
		else
			System.out.println(name+ "cannot swim.");
		return swim;
	}
	

}
