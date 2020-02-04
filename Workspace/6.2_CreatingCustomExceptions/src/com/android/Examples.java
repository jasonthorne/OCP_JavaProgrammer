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
		}catch(Exception e){
			System.out.println("exception " + e + " caught");
		}
		
		
		
		
		
	}	

}
