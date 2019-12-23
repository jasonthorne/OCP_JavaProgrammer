package com.android;
/*lambdas can only created from Functional interfaces (only be created from
 * interfaces with ONE abstract method)
 * this annotation marks your interface as being a functional interface, 
 * similar to @Overrid you don't have to put in this annotation, but it is
 * useful to remember that your code may be modified by other software 
 * developers in the future. So this prevents other coderss from changing
 * this functionalInterface to an ordinary interface. i.e you have a load
 * of code that uses a lot of lambdas, to implment this interface. another
 * software developer comes along, and adds another abstract method to this
 * interface, and it breaks ALL of your lambdas.
 */
@FunctionalInterface
public interface Behaviour {

	void sad();
	/*
	 * if you attempt to put in another abstract method, and you have the 
	 * @FunctionalInterface annotation, you wil get an error and your code 
	 * will not compile
	 */
	//void happy();//comment in this to see an error
	/*
	 * you can have as many default methods as you want in an 
	 * functional interface
	 */
	default void happy() 
	{
		
	}
	/*
	 * you can have as many static methods as you want in an functional 
	 * interface
	 */
	static void bad() 
	{
		
	}
}
