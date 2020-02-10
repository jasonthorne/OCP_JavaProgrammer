package com.android;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.*;

public class Examples {
	
	static void ex1() {
		
		System.out.println("ex1");
		
		//=====================================EXECUTOR SERVICE
		
		/*
		 * Executor service is an Interface that creates and manages threads for any developer. 
		 * You first obtain an instance of the new ExecutorService interface and then you send tasks to be processed.
		 * An executor service can take many tasks, which will always be something that implements the runnable interface. 
		 * 
		 * You use the executor factory class to create instances of ExecutorService
		 */
		
		System.out.println("single thread execution");
		
		//we create these objects OUTSIDE of the try/catch,
		//so we will then be able to access these objects outside the try block
		//as we will be closing them in the finally block.
		
		//this is the object we use to manage A thread.
		ExecutorService service1 = null;
		
		//this is an object we use to manage ANOTHER thread
		ExecutorService service2 = null;
		
		
		try {
			/*
			 * you have to say what type of executor you want.
			 * Below is an executor for a single thread.
			 * if you want an executor for multiple threads, you would use "newFixedThreadPool"
			 */
			service1 = Executors.newSingleThreadExecutor();
			service2 = Executors.newSingleThreadExecutor();
			
			/*
			 * .execute() creates a thread and takes an overridden run method from Runnable interface
			 */
			
			service1.execute(()->System.out.println("using our first executor service")); //first task ran
			
			service1.execute(()->new Dog()); //second task ran
			
			service2.execute(()->System.out.println("service2 executed"));
			
			service1.execute(()->{ //3rd task ran 
				Stream.iterate(0, i->i+1).limit(10).forEach((i)->System.out.println("i is: " + i));
			});
			
		}finally {
			service1.shutdown();
			service2.shutdown();
		}
		
		
		
		
		
	}

}
