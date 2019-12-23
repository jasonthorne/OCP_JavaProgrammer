package com.android;

public class Animal implements Behaviour{
//abstract method in Behaviour interface
	@Override
	public void sad() {
		System.out.println("Animal sad");
		
	}
//abstract method in Behaviour interface
	@Override
	public void mad() {
		System.out.println("Animal mad");
		
	}
	/*
	 * this method can take a Animal, a Human or a Dog, as all of these
	 * classes implement the Behaviour interface OR it could be an
	 * anonymous class implementation of the Behaviour interface. IT
	 * CANNOT BE A LAMBDA, as lambdas only work with functional intefaces
	 * (only one abstract method) and Behaviour has 2 abstract methods
	 */
	static void takeAny(Behaviour behave) {
		/*
		 * different types of objects, will have different implemenation
		 * of these methods, so you will have different outcomes 
		 * thats polymorphism
		 */
		behave.sad();
		behave.mad();
	}

}//end of Animal class

class Human implements Behaviour{
//abstract method in Behaviour interface
	@Override
	public void sad() {
		System.out.println("Human  sad method");
		
	}
//abstract method in Behaviour interface
	@Override
	public void mad() {
		System.out.println("Human mad method");
		
	}
	
	public void talk() {
		System.out.println("human talking");
	}
	public String name;
	
	public String toString() {
		return name;
	}
	
}

class Dog extends Animal{
	void bark() {
		System.out.println("Dog barking");
	}
	/*
	 * this is overriding the mad() method in the Animal, and it 
	 * also has a sad() method as the Dog class extends the Animal
	 * class
	 */
	@Override
	public void mad() {
		System.out.println("Dog mad method");
	}
}
