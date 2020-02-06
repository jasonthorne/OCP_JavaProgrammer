package com.android;

public class Shop implements AutoCloseable {

	@Override
	public void close() throws IllegalStateException { //IllegalStateException is a RUNTIME exception, sp doesnt need to a catch
		System.out.println("shop closing");
		
		throw new IllegalStateException("shop will not close"); //throw this runtime exception (causing a need for a try block anyway)
	}

}


