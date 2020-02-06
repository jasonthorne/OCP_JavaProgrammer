package com.android;

public class Pub implements AutoCloseable{

	
	/*
	 * this is the method that will run when we put a Pub in a try with resources.
	 * We overrid the close method of the AutoClosable interface. 
	 * When you are overriding, you can choose to throw the same exception or a subclass of exception or no exception.
	 * Here we override the close method of the Autoclosable interface with a close method that throws no exception
	 */
	@Override
	public void close() {
		System.out.println("closing our pub");
		
	}
	
	void takeMoney() {
		System.out.println("takeMoney");
	}
	
	void serveBeer() {
		System.out.println("serveBeer");
	}

}
