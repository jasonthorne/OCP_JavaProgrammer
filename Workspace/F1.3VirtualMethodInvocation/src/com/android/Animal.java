package com.android;

public abstract class Animal {
/*
 * any class that extends the Animal HAS to override this 
 * feed method
 */
	public abstract void feed();
/*	void feed() {
		System.out.println("animal feeding");
	}*/
	
	public static void feedAnimal(Animal myAnimal) {
		/*
		 * this will always be a subclass of Animal, as only subclasses
		 * of the Animal class have a concrete feed method, and the
		 * Animal class is abstract. It will always be a Cow, a Fish
		 * or a Bird that is calling this method. You will ALWAYS be
		 * using a Overridden feed method, this is virtual method
		 * invocation
		 */
		myAnimal.feed();
	}
}

class Cow extends Animal{

	@Override
	public void feed() {
		System.out.println("cow is about to feed");
		addHay();
		
	}
	private void addHay() {
		System.out.println("adding hay for the cow to eat");
	}
}

class Bird extends Animal{

	@Override
	public void feed() {
		System.out.println("bird is about to eat");
		addSeed();
		
	}
	
	private void addSeed() {
		System.out.println("adding birdseed for the bird to eat");
	}
}

class Fish extends Animal{

	@Override
	public void feed() {
		System.out.println("fish is about to eat");
		addFishFood();
		
	}
	private void addFishFood() {
		System.out.println("adding fishFood for fish to eat");
	}
}