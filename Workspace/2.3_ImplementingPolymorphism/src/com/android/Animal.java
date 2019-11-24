package com.android;

public class Animal implements Behaviour {

	//abstract method in Behaviour Interface:
	@Override
	public void sad() {
		System.out.println("Animal sad");
	}

	//abstract method in Behaviour Interface:
	@Override
	public void mad() {
		System.out.println("Animal mad");
	}
	
	//This method can take an animal, human or dog as ALL of these classes implement Behaviour interface. 
	//OR it could be an anonymous class implementation of the Behaviour interface.
	//It cannot be a lambda, as lambdas only work with functional interfaces (one abstract method only)
	static void takeAny(Behaviour behave) {
		
		/*
		 * Different types of objects will have different implementation of these methods, so you will have different outcomes. 
		 * That's polymorphism, baby!
		 */
		behave.sad();
		behave.mad();
	}
		

}

class Human implements Behaviour{

	//abstract method in Behaviour Interface:
	@Override
	public void sad() {
		System.out.println("Human sad");
		
	}

	//abstract method in Behaviour Interface:
	@Override
	public void mad() {
		System.out.println("Human mad");
		
	}
	
	public String name;
	
	public String toString() {
		return name;
	}
	
	public void talk() {
		System.out.println("Human talking");
	}
	
}





class Dog extends Animal{
	
	void bark() {
		System.out.println("Dog barking");
	}
	
	
	//overriding the mad method of the Animal class. And it also has a sad method as the Dog class extends the Animal class.
	@Override
	public void mad() {
		System.out.println("Dog mad method");
	}
	
	
	
}//end of Animal class