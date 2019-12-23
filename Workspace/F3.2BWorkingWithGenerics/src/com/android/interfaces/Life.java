package com.android.interfaces;

@FunctionalInterface
public interface Life {
	
	void grow();
	/*
	 * does not matter how many  default or static methods are contained within a 
	 * functional interface, all that matters is that you have only ONE abstract
	 * method
	 */
	default void defMethod() {
		
	}
	
	default void defMethod2() {
		
	}
	
	static void statMethod() {
		
	}
	
	static void statMethod2() {
		
	}

}
