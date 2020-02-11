package com.android;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
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
			
			//-------------------------------------------
			
			//IS DONE:
			
			service.submit(new Dog()); //add a Dog as a second task to service
			
	
			//returns boolean, true if completed, false if not.
			/*
			 * Returns true if this task completed.
			 * Completion may be due to normal termination, an exception, or cancellation
			 *  -- in all of these cases, this method will return true.
			 */
			
			
			System.out.println("isDone");
			
			
			System.out.println(mySubmit.isDone()); //returns true as a NEW task was given, which CANCELS the previous
			
			//-----------------------------------
			
			//IS CANCELLED:
			
			/*
			 * is cancelled returns true if the task was completed and not cancelled before completion.
			 * returns false if the task was cancelled before completion.
			 */
			
			System.out.println("wasfirst task cancelled before completion? " + mySubmit.isCancelled());
			
			//This is how we cancel a particular task associated with this future object.
			System.out.println(mySubmit.cancel(true));
			
			
			
			
			
		}finally {
			
			if(!service.isShutdown()) {
				service.shutdown();
			}
			
		}
		
	
		
	}
	
	static int number = 10;
	static int sum = 2;
	
	static void ex4() {
		
		System.out.println("ex4");
		
		//=====================================INTRODUCING CALLABLE:
		
		ExecutorService service = Executors.newSingleThreadExecutor(); 
		
		/*
		 * If your future object has a particular type (not a ? or just object)
		 * then you cant use the submit method that takes a runnable object,
		 * as a runnable object returns void, and this object below for instance needs an INteger. 
		 */
		//Future<Integer>futInt = service.submit(()->System.out.println("returns nothing"));
		
		/*
		 * So we use the overloaded submit() method that implements the CALLABLE interface. 
		 * The callable interface is simillar to the runnable interface except that the call(0 returns a value
		 * and also can throw an exception.
		 * 
		 * Looks like this: 
		 * 
		 * @DFunctionalInterface public interface Callable<V>{
		 * v call() throws Exception;
		 */
		
		int num1 = 12, num2=44;
		int total = 0;
		
		Callable<Integer>sumCall=()->num1+num1;
		
		try {
			
			Future<Integer>result1 = service.submit(sumCall); //first task
			Future<Integer>result2 = service.submit(()->num1*num1); //second task
			Future<Integer>result3 = service.submit(()->num2-num1); //third task
			Future<Integer>result4 = service.submit(()->num2/num1); //forth task
			
			/*
			 * If you want to get the value of a future object 
			 * (in this case they're all Integers)
			 * you use the .get() method
			 * 
			 */
			System.out.println(result1.get());
			System.out.println(result2.get());
			System.out.println(result3.get());
			System.out.println(result4.get());
			
			total = result1.get()+result2.get()+result3.get()+result4.get();
			System.out.println(total);
			
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			
			if(!service.isShutdown()) {
				service.shutdown();
			}
			
		}
		
		
		//------------------------
		total = 0; //reset total
		service = Executors.newSingleThreadExecutor(); //create new thread
		
		try {
			
			//task 1:
			Future<Integer>result1 = service.submit(()->{
				return sum=number+sum; //return number 12, assign 12 to sum
			}); 
			
			//task 2:
			Future<Integer>result2 = service.submit(()->{
				return sum=sum*sum; //12 * 12
			});
			
			/*
			 * This takes 2 tasks.
			 * The 1st produces the number 12, which is used by the 2nd to be multiplied by itself.
			 */
			total=result1.get()+result2.get();
			
		}catch(Exception e) {
			
		}finally {
			if(!service.isShutdown()) {
				service.shutdown();
			}
		}
	
	}
	
	
	static void ex5() {
		
		System.out.println("ex5");
		
		//=====================================TIME LENGTHS FOR GETS:
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		
		try {
			Future<?>mySubmit=service.submit(()->{ //submit with a runnable +++++++++++++++++++
				System.out.println("runnig submit");
				//List<Integer>numbers = Stream.iterate(0, i->i+1).limit(1_000_000_000).collect(Collectors.toList());
				
				Stream.iterate(0, i->i+1).limit(100000).collect(Collectors.toList());
			});
			
			//mySubmit.get();
			/* 
			 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			the max amount of time ALLOWED for this is 10 miilisecs
			If its NOT completed within that time, it will throw an exception.
			*/
			mySubmit.get(10, TimeUnit.MILLISECONDS); //++++++++++++++++++++++++++++++
			System.out.println("list created");
			
			
			//--------------------
			
			Future<Integer> mySubmit2 = service.submit(()->2+2); //submit with a callable +++++++++++++
			System.out.println(mySubmit2.get());
		}
		catch(Exception e) {
			System.out.println("exception caught: " + e);
		}
		finally {
			if(!service.isShutdown()) {
				service.shutdown();
			}
		}
	
	}
	
	/*
	static void ex6() {
		
		System.out.println("ex6");
		
		//=====================================SUBMIT WITH SLEEP:
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		
		try {
			service.submit(()->{
				Thread.sleep(1000);
			});
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			if(!service.isShutdown()) {
				service.shutdown();
			}
		}
	
	}
	*/
	
	
	static void ex7() {
		
		System.out.println("ex7");
		
		//=====================================SUBMIT WITH SLEEP:
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		try {
			
			//submit using Runnable:
			service.submit(()->System.out.println("calling first submit")); //first task
			
			//execute can ONLY use Runnable:
			service.execute(()->System.out.println("calling first execute on same thread")); //second task
			
			//Submit using Callable with type Integer:
			Future<Integer>futInt=service.submit(()->2+2); //third task
			System.out.println(futInt.get());
			
			if(!service.isShutdown()) {
				service.awaitTermination(10, TimeUnit.SECONDS);
			}
			
		}
		catch(Exception e) {
			System.out.println(e); //this is for futInt.get() as it COULD cause an exception +++++
		}
		finally {
			if(!service.isShutdown()) {
				service.shutdown();
			}
		}
		
		
		
		
		
		
	}

}
