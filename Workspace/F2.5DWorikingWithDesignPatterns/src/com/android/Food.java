package com.android;
/*
 * file contains the objects that will be created with our factory pattern
 */
public abstract class Food {
	//amount of food each animal takes
	private int quantity;
	//constructor for food object
	public Food(int quantity) {
		this.quantity=quantity;
	}
	//gets the quantity of food for the Animal
	public int getQuantity() {
		return quantity;
	}
	/*
	 * each type of Food is consumed in a different way, every class that extends Food
	 * has to have it's own consumes() method
	 */
	public abstract void consumes();
}
//for feeding Goats and Zebras
class Hay extends Food{

	public Hay(int quantity) {
		super(quantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void consumes() {
		System.out.println("animal is eating "+getQuantity()+" amount of hay");
		
	}	
}
//for feeding rabbits
class Vegetable extends Food{

	public Vegetable(int quantity) {
		super(quantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void consumes() {
		System.out.println("animal is eating "+getQuantity()+" vegetables");
		
	}
	
}

//for feeding polar bears
class Fish extends Food{

	public Fish(int quantity) {
		super(quantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void consumes() {
		System.out.println("animal is eating "+getQuantity()+" Fish");
		
	}	
}

//for feeding lions
class Meat extends Food{

	public Meat(int quantity) {
		super(quantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void consumes() {
		System.out.println("animal is eating "+getQuantity()+" meat");
		
	}
	
}
