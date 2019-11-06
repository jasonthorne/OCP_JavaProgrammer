package com.android;

public class Main {
	
	/*
	 * Annotating Overriden methods
	 * 
	 * A way to indicate explicitly in the code that a method is being overriden is using the @Override annotation.
	 * YOU DO NOT HAVE TO USE THIS
	 * The @Override annotation checks if a method is:
	 *  + Implementing a method from an interface
	 *  + Overriding a superclass method of the current sub class
	 *  + Overriding a method declared in the object class, such as hascode, equals or toString
	 */

	public static void main(String[] args) {
		

	}

}


class Animal{
	
	//method that will be overriden in the Cat class
	void drink() {
		System.out.println("I am an Animal drinking");
	}
	
	//method that will be overloaded:
	void reproduce() {
		System.out.println("I am an Animal reproducing");
	}
	
	void eat() {
		System.out.println("I am an Animal eating");
	}
	
}


class Cat extends Animal{
	
	/*
	 * I am telling the compiler explicity that I am overriding the drink method from the base Animal class. 
	 * If we do not correctly override the drink method (I.E we overload it instead), the code will NOT COMPILE.
	 * 
	 */
	
	
	@Override
	void drink() {
		System.out.println("I am a Cat drinking");
	}
	
	int reproduce(int num) { //return type DOESNT MATTER when OVERLOADING (just param list)
		return 1;
	}
	
	
	/*
	 * 
	 * This method isn't either overridden or overloaded, so wont work.
	 * Its not overriden as it has a different return type.
	 * Its not overloaded as it has the same param list. 
	 * 
	int eat() {
		return 1;
	}
	*/

}


interface Behaviour{
	void sad();
	void mad();
	void happy();
}


class Dog implements Behaviour{
	
	/*
	 * When you are implementing the Behaviour interface, you are overriding all of the abstract methods contained within the Behaviour Interface.
	 * Removing the @Override annotation will not cause an error as the annotation is only a check to ensure that the method is overridden.
	 */

	@Override
	public void sad() {
	
	}

	@Override
	public void mad() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void happy() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}


class Cow{
	
	/*
	 * Here we are overriding one of the methods from the Object superclass, the toString method.
	 * The override annotation checks that it's enforcing overriding
	 */
	
	@Override
	public String toString() {
		return "Overriding the toString method of the Object class";
	}
}








