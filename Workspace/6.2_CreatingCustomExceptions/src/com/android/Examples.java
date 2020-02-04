package com.android;

public class Examples {
	

	static void ex1() {
		
		System.out.println("\nex1:");
		
		
		try {
			throw new CannotSwimException();
		}catch(Exception e) {
			System.out.println("exception " + e + " caught");
		}
		
		
		try {
			throw new CannotSwimException(new Exception());
			
			/*
			 * This produces:
			 * 
			 * exception com.android.CannotSwimException
			 * 
			 * and java.lang.Exception is the exception that was sent to 
			 */
		}catch(Exception e){
			System.out.println("exception " + e + " caught");
		}
		
		
		try {
			//calls the ocnstructor in the CannotSwimException class that takes a string
			throw new CannotSwimException("her is my message for the 3rd try block");
			
		}catch(Exception e) {
			System.out.println("message is: " + e.getMessage());
		} 
		
		
	}	
	
	
	
	static void ex2() {
		
		System.out.println("\nex2:");
		Animal Dog = new Animal();
		Person percy = new Person();
		
		try {
			percy.swim();
		} catch (CannotSwimException e) {
			System.out.println("Rescure our percy!");
		}
		
	}

}
