package com.android;
/*
 * this annotation marks your interface as being a functional interface, similar to @override
 * you don't have to put in this annotation , but it is useful as remember your code may be 
 * modified by other software developers in the future, so this prevents other coders from 
 * changing this functional interface to a ordinary interface i.e another software developer could
 * put in another abstract method, which means this interface would not longer function for
 * lambda expressions
 * if this is NOT A functional interface, this would result in a compiler error
 */
@FunctionalInterface
public interface Behaviour {
	void sad();
	/*
	 * can have as  many defaults and statics as you want in the interface
	 */
	default void mad() {
		
	}
	static void bad() {
		
	}

}
