package com.android;

public abstract class Animal {
	
	//Any class that extends the Animal class HAS TO override this method:
	public abstract void feed();
	
	//concrete method:
	public static void feedAnimal(Animal myAnimal) {
		
		
		/*this will always be a subclass of Animal, as only subclasses of the Animal class have a concrete feed method, and the Animal class is abstract.
		 * You will ALWAYS be using an overriden feed method, this is virtual method invocation. 
		 */
		myAnimal.feed(); 
	}
}

class Cow extends Animal{

	@Override
	public void feed() {
		System.out.println("Cow is about to feed");
		addHay();
	}
	
	private void addHay() {
		System.out.println("adding hay for the cow to eat");
	}
	
}


class Bird extends Animal{

	@Override
	public void feed() {
		System.out.println("Bird is about to feed");
		addSeed();
	}
	
	private void addSeed() {
		System.out.println("adding seed for the bird to eat");
	}
	
}


class Fish extends Animal{

	@Override
	public void feed() {
		System.out.println("Fish is about to feed");
		addFishFood();
	}
	
	private void addFishFood() {
		System.out.println("adding fishfood for the Fish to eat");
	}
	
}









