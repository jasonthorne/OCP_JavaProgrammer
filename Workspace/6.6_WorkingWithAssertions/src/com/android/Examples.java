package com.android;



public class Examples {
	
	/*
	  Below does nothing if assertions are turned off. 
	 It produces an exception if assertionsd are turned on.
	 */
	//assert false;
	
	static void ex1() { 
		
		System.out.println("\nex1:");
		
		//======================================CONTROL FLOW INVARIANT:
		
		Seasons mySeason = Seasons.SPRING;
		
		/*
		 * if we use this line of code instead of the one above, we will get an assertion error,
		 * with the message "Premises is closed in winter".
		 * However if we have assertions turned off, this will fail silently.
		 * This means it fails but you will not be notified about it.
		 */
		
		//Seasons mySeason = Seasons.WINTER; 
		
		switch(mySeason) {
		case SPRING:
			System.out.println("We open in spring at 10 O'clock");
			break;
		case SUMMER:
			System.out.println("We open in summer at 8 O'clock");
			break;
		case AUTUMN:
			System.out.println("We open in autumn at 11 O'clock");
			break;
		default:
			assert false: "Premises closed in winter";
			
			
		}
		
	}
	
	
	
	static void ex2() { 
		
		System.out.println("\nex2:");
		
		//====================================CLASS INVARANTS:
		
		/*
		 * this is about checking the state of an object. ie: weight, age, height etc.. 
		 */
		
		int age = -12; //dont want :P
		
		//uncomment this to see it work ++++++++++++++
		//assert age >0: "age has to be more than 0";	 //will produce an assertion error if age is isn't >0
		
		/*
		 * Use assertions for checking invalid arguements. (it is better to use an IllegalArguementException)
		 */
		
		//--------------------------------------
		
		class Rectangle {
			
			int width;
			int height;
			
			/*
			 * A rectangle HAS TO have a width & height > 0
			 */
			
			public Rectangle(int width, int height) {
				this.width = width;
				this.height = height;
				
				/*
				 * isValid will return false if either the height of width is isnt >0.
				 * so the assertion below will generate an assertion error, and print out "not a valid rectangle" 
				 * Assertions do not allow you to fix a situation.
				 */
				assert isValid(): "not a valid rectangle. Both width & height have to be greater than 0";
				System.out.println("rectangle created");
				
				/*
				 * this is  BETTER than assertions because it protects your code against live issues.
				if(isValid())
					System.out.println("rectangle created");
				else
					throw new IllegalArgumentException();
				*/
			}
			
			private boolean isValid() {
				return (width>0 && height>0); //return whether both these are true or false
			}
		}
		
		
		Rectangle one = new Rectangle(5, 12);
		
		
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

enum Seasons{
	SPRING,SUMMER,AUTUMN,WINTER;
}

