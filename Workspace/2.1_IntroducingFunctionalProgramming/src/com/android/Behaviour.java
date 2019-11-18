package com.android;


/*
 * 
 * Lambdas can only be created from functional Interfaces. 
 * 
 * this annotation marks your interface as being a functional interface. 
 * Similar to @Override, you dont have to put in this annotation, but it is useful to remember that your code may be modified by other software devs in the future.
 * So this prevents other coders from changing this functionalInterface to an ordinary interface. 
 * 
 * I.E you have a load of code that uses a lot of lambdas, to implement this interface. Another developer comes along and adds ONE abstract method to this interface, it will break all of your code.
 */

@FunctionalInterface
public interface Behaviour {

	void sad();
	
	//void happy(); //this breaks this functional interface, as you can only have ONE abstract method in an interface.
	
}
