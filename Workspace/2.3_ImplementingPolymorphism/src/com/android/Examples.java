package com.android;

public class Examples {
	
	static void ex1() {
		
		/*
		 * This polymorphic method takes any object with a Behaviour reference. 
		 * This can be an object of a class that implements the interface or an anommymous inner class. 
		 */
		System.out.println("animal calling takeAny");
		Animal.takeAny(new Animal());
		
		System.out.println("Anonymus inner class sent to takeAny:");
		Animal.takeAny(new Behaviour() {

			//we are overriding the sad and mad methods of the behaviour interface, inside this anonymous inner class
			@Override
			public void sad() {
				System.out.println("anonymous sad method");
			}

			@Override
			public void mad() {
				System.out.println("anonymous mad method");
			}
			
		});//end of takeAny()
		
		
		//==========================
		
		Mammal.takeMovement(new Mammal(), 45);
		
	}

}
