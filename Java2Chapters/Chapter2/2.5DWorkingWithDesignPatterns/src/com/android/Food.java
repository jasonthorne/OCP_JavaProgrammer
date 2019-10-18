package com.android;

public abstract class Food {
	private int quantity;
	
	public Food(int quantity) {
		this.quantity=quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public abstract void consumes();

}
/*
 * for feeding Zebras and Goats
 */
class Hay extends Food{

	public Hay(int quantity) {
		super(quantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void consumes() {
		System.out.println("hay eating "+getQuantity());
		
	}
	
}
/*
 * for feeding rabbits
 */
class Vegetables extends Food{

	public Vegetables(int quantity) {
		super(quantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void consumes() {
		System.out.println("Vegetables eating "+getQuantity());
		
	}
	
}
/*
 * for feeding polar bears
 */
class Fish extends Food{

	public Fish(int quantity) {
		super(quantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void consumes() {
		System.out.println("fish eaten "+getQuantity());
		
	}
	
}
/*
 * Lions eat this food
 */
class Meat extends Food{

	public Meat(int quantity) {
		super(quantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void consumes() {
		System.out.println("meat eaten "+getQuantity());
		
	}
	
}
