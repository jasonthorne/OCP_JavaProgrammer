package com.android;

/*
 * This file contains the objects that will be created with the factory pattern. +++++++++++++++++++++
 */

public abstract class Food {

	private int quantity; //how much of each food the animal takes
	
	
	//constructor for food
	public Food (int quantity){
		this.quantity = quantity;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	/*
	 * each type of food is consumed in a different way
	 */
	public abstract void consumes(); //every class that extends Food (this class) will have its own consume method.
	
}

//for feeding Goats and Zebras
class Hay extends Food{

	//constructor
	public Hay(int quantity) {
		super(quantity);
		
	}

	@Override
	public void consumes() {
	System.out.println("Animal is eating: " + getQuantity() + " amount of hay.");
		
	}
}

//for feeding Rabbits:
class Vegetable extends Food{

	public Vegetable(int quantity) {
		super(quantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void consumes() {
		System.out.println("Animal is eating: " + getQuantity() + " amount of Vegetables.");
		
	}
	
}


//for feeding PolarBears and Penguins:
class Fish extends Food{

	public Fish(int quantity) {
		super(quantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void consumes() {
		System.out.println("Animal is eating: " + getQuantity() + " amount of Fish.");
		
	}
	
}


//for feeding Lions
class Meat extends Food{

	public Meat(int quantity) {
		super(quantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void consumes() {
		System.out.println("Animal is eating: " + getQuantity() + " amount of Meat.");
		
	}
	
}




