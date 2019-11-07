package com.android;

public class Main {
/**
 * Annotating Overriden methods
 * A way to indicate explicitly in the code that a method is being
 * overriden is using the @Override annotation.
 * you do not HAVE TO USE THIS, if you use this and your method is
 * not overriding, it will cause a compilation error
 * the @Override annotation checks is a a method is:
 * Implementing a method from an interface
 * Overriding a superclass method of the current sub class
 * overriding a method declared in the object class, such as 
 * hashcode, equals or toString
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Animal{
	//method that will be overridden in the Cat class
	void drink() {
		System.out.println("I am a Animal drinking");
	}
	//method that will be OVERLOADED rather 
	void reproduce() {
		System.out.println("I am a Animal reproducing");
	}
	
	void eat() {
		System.out.println("I am a Animal eating");
	}
}

class Cat extends Animal{
	/*
	 * I am telling the compiler explicitly that i am overriding the 
	 * drink method from the base Animal class. If we do not correctly
	 * override the drink method (i.e we overload it instead) the code
	 * will NOT COMPILE
	 */
	@Override
	void drink() {
		System.out.println("I am a cat drinking");
	}
	/*
	 * this is a overloaded reproduce method, it has a different
	 * parameter list from the reproduce method in the Animal class.
	 * if we put in the @Override annotation we will get a compilation
	 * errors as this method is overloading and NOT overriding
	 * uncomment @Override to see error
	 */
	//@Override
	int reproduce(int num) {
		
		return 1;
	}
	/*
	 * we have a void eat(){} in the super Animal class, so if we have
	 * a eat() method in the Cat class it has to be either overriden
	 * or overloaded, this method is neither. It's not overriden as it
	 * has a different return type, int
	 * it's not overloaded as it has the same parameter list
	 */
/*	int eat() {
		return 1;
	}*/
}

interface Behaviour{
	void sad();
	void mad();
	void happy();
}

class Dog implements Behaviour{
/*
 * when you are implemening the Behaviour interface you are overriding
 * all of the abstract methods contained within the Behaviour Interface.
 * Removing the @Override annotation will not cause an error as the
 * @Override annotation is only a check to ensure that the method is
 * overriding
 */
	@Override
	public void sad() {
		// TODO Auto-generated method stub
		
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
	 * here we are overriding one of the methods from the Object
	 * superclass, the 
	 * public String toString() method
	 * again it's not an oerror to have not @Overriden annotation as 
	 * this is merely a check that enforces overriding
	 */
	@Override
	public String toString() {
		return "overriding the toString method of the Object class";
	}
}
