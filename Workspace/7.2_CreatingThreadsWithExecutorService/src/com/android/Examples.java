package com.android;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
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
			 * Below is an executor for a SINGLE thread.
			 * if you want an executor for multiple threads, you would use "newFixedThreadPool"
			 * 
			 * newSingleThreadExecutor() is the simplest executor service you can create. 
			 * This will result in a single thread, so all tasks in this thread will run concurrently.
			 * You can add as many tasks as you want to this thread.
			 * a task is an object that implements the runnable interface, which returns nothing, takes no variables.
			 */
			service1 = Executors.newSingleThreadExecutor(); //creates ONE thread
			service2 = Executors.newSingleThreadExecutor();  //creates ONE thread
			
			/*
			 * .execute() creates a thread and takes an object that implements the runnable Runnable interface (so overrides it's run method)
			 * Execute is considered a "fire and forget" method, as once it's submitted, the results are not directly available to the calling thread.
			 */
			
			service1.execute(()->System.out.println("using our first executor service")); //1st task ran in 1st thread
			
			service1.execute(()->new Dog()); //2nd task ran in 1st thread
			
			service2.execute(()->System.out.println("service2 executed")); //first task ran in 2nd thread
			
			service1.execute(()->{ //3rd task ran in 1st thread
				Stream.iterate(0, i->i+1).limit(10).forEach((i)->System.out.println("i is: " + i));
			});
			
		}finally {
			
			/*
			 * If we dont have a shutdown the service will keep running indefinitely.
			 * Which you may want if there is some thread that contains tasks that need to be constantly operating in the background.
			 */
			
			//check if service is shut down:
			if(!service1.isShutdown()) {
				service1.shutdown();
			}
		
			service2.shutdown();
		}
		
		/*
		 * ExecutorService does NOT implement AutoClosable, so you cannot use try with rsources with the ExecutorService.
		 */
		
		System.out.println("serive is shutdown? " + service1.isShutdown());
		
	}
	
	//++++++++++++++++++++++++++++++++
	public static ExecutorService statService = null; //an object to manage threads, that can be accessed anywhere 
	ExecutorService oService = null;
	
	static void ex2() {
		
		System.out.println("ex2");
		
		//=====================================STATIC EXECUTOR SERVICE (shown above)
		
		statService = Executors.newSingleThreadExecutor();
		
		try {
			
			statService.execute(()->System.out.println("accessing static service")); //run a task from statService here ++++++++++
			
			Cat myCat = new Cat(); //runs another task from statService in it's constructor ++++++++++
			
		}finally {
			if(!statService.isShutdown()) {
				statService.shutdown();
				System.out.println("is statService shut down? " + statService.isShutdown());
			}
		}
			
		
		//-----------------------------------
		/*
		 * Below will generate a rejected Execution Exception as this service has already been shutdown and its thread closed.
		 */
		try {
			statService.execute(()->System.out.println("next task on this thread")); 
		}catch(Exception e) {
			System.out.println(e);
		}
		
		//create a new Thread that executor service will manage:
		statService=Executors.newSingleThreadExecutor();
		statService.execute(()->System.out.println("first task on this NEW thread")); //first task
		statService.execute(()->System.out.println("second task on this new thread")); //second task
		
		//------
		
		Cat myCat = new Cat(); //third task (fired in constructor)
		
		statService.execute(new Dog()); //forth task run, with a Dog passed in as arg (as it implements Runnable)
		//statService.shutdown();
		
		shutDownThreadExe();

	}
	
	
	static void shutDownThreadExe() {
		if(statService!=null) {
			statService.shutdown();
		}
	}
	
	
	static void ex3() {
		
		System.out.println("ex3");
		
		//=====================================SUBMIT:
		
		ExecutorService service = Executors.newSingleThreadExecutor(); 
		
		/*
		 * submit() is like execute in that it adds tasks to a thread, 
		 * but unlike execute it returns something called a "FUTURE OBJECT" instead of void.
		 * A future object can hold information about whether a task is completed or not.
		 * Can be also used with scheduling (tasks that will happen at some point in the future at regular intervials).
		 * You SHOULD USE submit wherever possible over execute. +++++++++++++++++++++++
		 */
		
		
		
		try {
			
			Future<?>mySubmit;
			mySubmit = service.submit(()->System.out.println("running submit")); //add a task to a future object
			
			///////service.submit(new Dog());
			
			
			//returns boolean, true if completed, false if not.
			System.out.println("isDone");
			System.out.println(mySubmit.isDone());
		
			
		}finally {
			
			
			if(!service.isShutdown()) {
				service.shutdown();
			}
			
		}
		
	
		
	}

}
