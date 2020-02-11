package com.android;

public class Cat {
	
	Cat(){
		System.out.println("Cat constructor called");
		
		Examples.statService.execute(()->System.out.println("print out cat executor"));
		
		/*
		 * If you shut down the thread here, you would not be able to add any more tasks to this thread as it's now closed!! 
		 * So would get exceptions anywhere you tried to add more tasks.
		 */
		//Examples.statService.isShutdown(); 
	}

}
