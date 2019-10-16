package com.android;
/**
 * Annotating Overriden methods
 * @author noelf
 * a way to indicate explicitly in the code that method is being overridden 
 * When using @Override this checks if a method is :
 * Implementing a method from an interface
 * Overriding a superclass method of the current sub class
 * Overriden a method declared in object, such as hashcode, equals or toString
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Animal{
	//method to be overriden in the Cat class
	void drink() {
		System.out.println("I am a Animal drinking");
	}
	//method that will be OVERLOADED rather than overriden
	void reproduce() {
		System.out.println("I am a animal reproducing");
	}
}

class Cat extends Animal{
	/*
	 * I am telling the compiler explicitly that i am overriding the drink method from the base Animal class
	 * , if i do not overload the method after the "@Override" the code will NOT compile
	 * @see com.android.Animal#drink()
	 */
	@Override
	void drink() {
		System.out.println("I am a cat drinking");
	}
	/*
	 * this is a OVERLOADED reproduce method, it has a different parameter list from the void reproduce() method
	 * in the Animal class
	 * if we put in the "@Override" annotation we will get a compiler error as this method is not overriding but
	 * overloading
	 * uncomment @Override to see compiler error
	 */
	//@Override
	void reproduce(int num) {
		
	}
}

interface Behaviour{
	void sad();
	
}

class Dog implements Behaviour{
/*
 * when you are implementing the Behaviour interface you are overriding all of the abstract methods contained
 * withing the interface
 * removing the @Override annotation will not cause an error, as the method is overriding the sad() method. 
 * and the @Override annotation is only a check to ensure that a method is overriding
 */
	@Override
	public void sad() {
		// TODO Auto-generated method stub
		
	}
	
}

class Cow {
	/*
	 * here we are overriding one of the methods from the Object superclass, the 
	 * public String toString() method
	 * again it would not be an error to have no @Override annotation as this is merely a check to ensure that
	 * the method correctly overrides the toString method
	 */
	@Override
	public String toString() {
		return "overriding the toString method of the Object class";
	}
}
