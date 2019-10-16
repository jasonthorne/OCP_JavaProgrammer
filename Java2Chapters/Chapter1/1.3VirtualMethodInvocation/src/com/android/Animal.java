package com.android;

public abstract class Animal {
	
	public abstract void feed();
	
	public static void feedAnimal(Animal animal) {
		/*
		 * this will always call a subclass of Animals feed method, as you HAVE to send a object that extends
		 * this class, you can't have a abstract object type, which is what Animal is
		 * so this will ALWAYS call a overriden feed() method, which is what virtual method invocation is
		 */
		animal.feed();
	}

}

class Cow extends Animal{

	@Override
	public void feed() {
		System.out.println("cow is about to feed");
		addHay();
		
	}
	private void addHay() {
		System.out.println("adding hay for cow to eat");
	}
}

class Bird extends Animal{

	@Override
	public void feed() {
		System.out.println("bird is about to feed");
		addSeed();
		
	}
	
	private void addSeed() {
		System.out.println("adding birdseed for bird to eat");
	}
}

class Fish extends Animal{

	@Override
	public void feed() {
		System.out.println("fish is about to eat");
		addFishFood();
		
	}
	private void addFishFood() {
		System.out.println("adding fishfood for fish to eat");
	}
	
}
