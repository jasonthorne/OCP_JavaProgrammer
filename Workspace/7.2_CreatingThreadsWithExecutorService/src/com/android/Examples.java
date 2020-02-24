package com.android;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
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
			
			//-------------
			//send system thread to sleep to ensure print out below is ran last
			try {
				Thread.sleep(100);
			}catch(Exception e) {
				System.out.println(e);
			}
			
			
			System.out.println("I should be last because of sleep");
			//--------------
			
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
	
	//+++++++++++++OTHER EXS ARE IN HIS CODE!! (grrr...)+++++++++++++++++++++
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	
	static void ex10() {
		
		System.out.println("ex10");
		
		//===========================USING SUBMIT TO SLEEP THREADS=====================
		
		/*
		 * This submit uses a callable.
		 * A callable returns an object and throws Exception. Which means you can have a thrwad.sleep command inside this service.
		 */
		
		ExecutorService service1 = Executors.newSingleThreadExecutor();
		ExecutorService service2 = Executors.newSingleThreadExecutor();
		
		
		LocalTime now = LocalTime.now();
		
		try {
			
			service1.submit(()->{
				System.out.println("b4 first thread: " + now);
				
				/*
				 * If your submit returns ANYTHING (even null)
				 * then this is a submit with a callable whic throws an interupted exception.
				 */
				
				Stream.generate(()->Math.random()*100)
				.limit(20)
				.collect(Collectors.toList());
				System.out.println("after first thread: " + now);
				return null;
				
			});
			
			/*
			 * As long as your thread is inside a try/catch you can use Thread.sleep in a submit with a callable,
			 * as callable throws Interrupted exception. 
			 * Which means that it looks for an enclosing try/catch with any exception of the method that contans these threads could THROWS excpetion. 
			 */
			
			//++++++++++++++++
			/*
			 * Submit returns a future Object
			 * The submit with Runnable always this sort of future object: 
			 * Future<?>futObj
			 * The submit with a Callable returns a future object of a PARTICULAR type.
			 * i.e here the type is INteger, which means the returned type will be an Integer.
			 * 
			 */
			//+++++++++++++++
			
			Future<Integer>futInt=service2.submit(()->{
				
				
				/*
				 * nearly always bettwer to put your own thread to sleep instead of the system thread. 
				 * Makes sense to put your thread to sleep at the atart, before the work is done, as at the end the work is already done.
				 */
				
				
				
				Thread.sleep(100);
				Optional<Integer>optInt=Stream.generate(()->(int)Math.random()*100)
					.limit(20)
					.max((i1,i2)->i1-i2);
				return optInt.get();
			});
			
			
			
		}catch(Exception e) {
			System.out.println("exception is: " + e);
		}
		finally {
			if(!service1.isShutdown()) {
				service1.shutdown();
			}
		}
			
	}
	
	static int count=0;
	
	static void ex11() {
		
		System.out.println("ex11");
		
		//==================================SHEDULING: ++++++++++++++++++++++++++++++++++++
		
		
		/*
		 * Scheduling certain tasks to run at certain times
		 */
		
		/*
		 * This is the object we use to control tasks that will run at some point in the future. 
		 */
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		
		
			
		try {
			
			//to see the sheduler in action, we need ot know what time it starts at:
			System.out.println("time is: " + LocalTime.now());
			
			//tasks for scheduler:
			
			Runnable task1=()->{
				System.out.println("\ntime of first task is: " + LocalTime.now());
				System.out.println("runnable task count is: " + (++count));
			};
			
			Callable<String> task2=()->{
				System.out.println("\ntime of second task is: " + LocalTime.now());
				String str="horse " + + (++count);
				System.out.println("callable task count is: " + count);
				return str;
			};
			
			//--------------------
			//scheduled method of the schduledExecutorService class: //+++++++++++++++++++++++++++++
			int time = 5;
			
			//We run this FIRST task 5 seconds in the future:
			Future<?>result1=service.schedule(task1, time, TimeUnit.SECONDS); //(task to be ran, how long until it fires, timeunit to use)
			
			
			//=================
			
			//we run this SECOND task 7 seconds in the future:
			Future<String>result2 = service.schedule(task2, time+2, TimeUnit.SECONDS);
			
		}catch(Exception e) {
			System.out.println("exception is: " + e);
			
		}finally {
			if(!service.isShutdown()) {
				service.shutdown();
			}
		}
			
	}
	
	
	
	static void ex12() {
		
		System.out.println("ex12");
		
		//==================================SHEDULING WITH LOOP: ++++++++++++++++++++++++++++++++++++
		
		count = 0;
		
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		
		try {
			
			for(int i=0;i<5;i++) {
				service.schedule(
						()->{
							System.out.println("count is: " + (++count) + ". time is: " + LocalTime.now());
							
							if(count>4) {
								System.out.println("all tasks complete");
							}
							
							/*
							 * Each time a task has nearly finished, we put in a sleep for 2 secs, so the previous task is given time to finish. 
							 */
							/////Thread.sleep(2000);
							return null; //this make this a CALLABLE +++++++++++++++++++++
							
						}, 2, TimeUnit.SECONDS); //this will run all of the tasks 2 seconds ahead of the time it would have run if they were normal tasks in a normal string. 
						
			}
			
		}catch(Exception e) {
			System.out.println("exception: " + e);
		}finally {
			if(!service.isShutdown()) {
				service.shutdown();
			}
		}
	
	}
	
	

	static void ex13() {
		
		System.out.println("ex13");
		
		//==================================SHEDULING AT FIXED RATE: ++++++++++++++++++++++++++++++++++++
		
		//++++++++++++++++++++++++makes a task run over and over, at fixed intervals,  until a fixed time is met.
		
		
		count = 0;
		
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		
		Runnable task1=()->{
			System.out.println("Runnable task 1 " + (++count) + ". Time is: " + LocalTime.now());
		};
		
		/*
		 * This is going to complete TASKS. 
		 * The first taks will have a 5 sec lead in time.
		 * Every task after the first task will have a 2 sec delay. 
		 * 
		 * Make sure all of your tasks would complete in 2 secs, as each new task does NOT wait until 2 secs.
		 * 
		 * THIS CAN ONLY TAKE A RUNNABLE +++++++++++++++++++++++++++++++++++
		 */
		
		service.scheduleAtFixedRate(task1, 5, 2, TimeUnit.SECONDS); //first task to be run, initial delay for 1st task, 2 delay for all other firings of THIS task, time unit to use
		
		System.out.println("time at start is: " + LocalTime.now());
		
		try {
			TimeUnit.SECONDS.sleep(15);  //This is the entire time period the tasks have to use up. 
			
			//----------
			//this will run before the 5 second wait to run for the one above it.
			service.submit(()->System.out.println("second task"));
			//---------
			
			
		}catch(Exception e) {
			System.out.println("exception: " + e);
		}finally {
			
			/*
			 * If you want a thread to run continuously, you just dont shutdown the scheduled thread until you close the app
			 * comment this out to see.
			 */
			if(!service.isShutdown()) {
				service.shutdown();
				System.out.println("service is shutdown at: " + LocalTime.now());
			}
		}
	}
	
	
	
	static void ex14() {
		
		System.out.println("ex14");
		
		//==================================SHEDULING WITH FIXED DELAY: ++++++++++++++++++++++++++++++++++++
		
		//Any schedualed task will wait until a task that is fired before it is finished before launching it's next task. 
		
		System.out.println("before any tasks, time is: " + LocalTime.now());
		
		
		//REMEMBER: THese can ONLY TAKE RUNNABLES:
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
	
		//our task:
		Runnable task1 = ()->{
			System.out.println("before set creation, time is: " + LocalTime.now());
			Set<Double>doubleSet=Stream.generate(()->Math.random()).limit(10_000_000).collect(Collectors.toSet());
			System.out.println("after set creation, time is: " + LocalTime.now());
		};
		
	
		//no initial delay before first firing, then launch each new thread after 2 secs.
		
		/*
		 * Each of these tasks will ony start after the previous task has been finished
		 *  and will give a 2 second delay after the previous task has been finished
		 *  The very first task in this service will start immediately after the previous task.
		 *  
		 *  without a TimeUnit.SECONDS sleep, this will continue infinitely. 
		 */
		service.scheduleWithFixedDelay(task1, 0, 2, TimeUnit.SECONDS);
		
		/* ++++++++++++++++++++++++++++++++++++++++++++++++++
		 * The isuue with these is that if exceptions are generated during any of these tasks, 
		 * i.e: this produces 50 tasks and task 25 produces an interrupted exception.
		 * this will be a supressed exception. 
		 */
		
		try {
			TimeUnit.SECONDS.sleep(18);
		}catch(Exception e) {
			System.out.println("exception: " + e);
			
			/*
			 * e not only contains the primary exception, but also an array of suppressed exceptions, if they exist. ++++++++++++++++++++++++++++++
			 */
			System.out.println(e.getSuppressed());
			Arrays.asList(e.getSuppressed() //array of throwables
					).stream().forEach(System.out::println);  //adding suppressed exceptions to list and printing them off
			
		}finally {
			
			/*
			 * If you want a thread to run continuously, you just dont shutdown the scheduled thread until you close the app
			 * comment this out to see.
			 */
			if(!service.isShutdown()) {
				service.shutdown();
				System.out.println("service is shutdown at: " + LocalTime.now());
			}
		}
		
	
	}
	
	
	
	static void ex15() { //++++++++++++++++++++POOLS OF THREADS: +++++++++++++++++++++++++++++
		
		System.out.println("ex15");
		
		//==================================INCREASING CONCURRENCY WITH POOLS: ++++++++++++++++++++++++++++++++++++
		
		/*
		 * A thread pool is a group of pre-instantiated reusable threads that can be used to perform any set of arbitary tests. 
		 * 
		 * 3 types:
		 * 
		 * + newCachedThreadPool() - for multiple single threads
		 * + newFixedThreadPool(int numOfThreads) - for multiple single threads (give the amount of threads you want to use)
		 * + newScheduledThreadPool(int numOfThreads) - a thread pool that allows scheduling. (goes every 2 secs etc)
		 * 
		 * Whereas a single thread executor will usually (but not always ) wait until a thread is read to execute a task,
		 * a pooled thread can execute the next task at the same time (concurrently).
		 * 
		 */
		
		ExecutorService service1 = Executors.newCachedThreadPool();
		count=0;
		
		/*
		 * This is used for any application that may have short lived asynchronous tasks (at the same time).
		 * 
		 * This will create a pool of threads of an unbounded size, and will v=create threads as needed.
		 */
		
		try {
			
			//task 1
			//this submit takes a callable, which has to return something, even null
			service1.submit(()->{
				System.out.println("time in 1st submit is: " + LocalTime.now()); //all threads start at the same time
				System.out.println("runable task 1");
			
				int i=0;
				for(i=0;i<5_000;i++) {
					i=i+i;
				}
				System.out.println("i is: " + i);
				System.out.println(++count);
				return null;
			});
			
			//task 2
			//this submit takes a runnable 
			service1.submit(()->{
				System.out.println("time in 2nd submit is: " + LocalTime.now());
				System.out.println("runable task 2");
				System.out.println(++count);
			});
			
			//task3
			//this execute ALWAYS takes a Runnable
			service1.execute(()->{
				System.out.println("time in 3rd submit is: " + LocalTime.now());
				System.out.println("runnable  task 3");
				System.out.println(++count);
			});
			
			
			//================sleep system thread to allow other threads to finish first
			Thread.sleep(1000);
			System.out.println("amount of threads is: " + Thread.activeCount()); //++++++++++++++++++++
			
			//================
			
		}catch(Exception e) {
			System.out.println("exception: " + e);
		}
		finally{
			
			if(!service1.isShutdown()) {
				service1.shutdown();
				System.out.println("service is shutdown at: " + LocalTime.now());
			}
			
		}
		
		
		
	}
	
	
	
	static void ex16() { 
		
		System.out.println("ex16");
	
		//===========================================NEW FIXED THREAD POOL
		
		/*
		 * Takes a number of threads and allocates them all upon creation
		 * 
		 * As long as the number of t\sks is less than the number of threads, then all tasks will be executed concurrently. 
		 * If there are more tasks available, then the the task will be put in a queue.
		 * 
		 * i.e we have a fixedThreadPool of 10 threads and have 15 tasks. 
		 * The first 10 tasks will be assigned to the 210 threads, and 5 will be queued.
		 */
		
		//create an executor service with a fixed max amount of tasks to be running simultaneously 
		ExecutorService service = Executors.newFixedThreadPool(4);
		
		
		try {
			
			service.execute(()->System.out.println("runnable service 1. Time is: " + LocalTime.now())); //run 1st task
			service.submit(()->System.out.println("submit runnable time is: " + LocalTime.now())); //run 2nd task
			service.submit(()->{
				System.out.println("callable submit time is: " + LocalTime.now()); //run 3rd task
				return null;
			});
			service.submit(new Dog()); //run 4th task
			
			//----------a 5th task: +++++++++++++++++++++++++++++++++++
			service.submit(new Employee()); //run a 5th task - This one HAS TO WAIT until one of the 4 threads becomes available. (so it can NEVER be first) +++++++++++++++
			
			//----------
			Thread.sleep(100);
			System.out.println("amount of threads in use: " + Thread.activeCount());
			//----------
		}
		catch(Exception e) {
			System.out.println("exception: " + e);
		}
		finally {
			
			if(!service.isShutdown()) {
				service.shutdown();
				System.out.println("service is shutdown at: " + LocalTime.now());
			}
			
			//-----------------------
			System.out.println("amount of available processors: " + Runtime.getRuntime().availableProcessors());
			
			int threadPool = Runtime.getRuntime().availableProcessors();
			service = Executors.newFixedThreadPool(threadPool/2); //create a thread pool uing only half the available processors.
			//-----------------------
		}
		
		
		
	
	}
	
	

	static void ex17() { 
		
		System.out.println("ex17");
	
		//===========================================NEW SCHEDULED THREAD POOL
		
		/*
		 * This is the same as new fixed thread pool, except it returns an instance of ScheduleExecutorService, which means you can schedule tasks.
		 * 
		 * (returns future objects)
		 * 
		 * Like singleSchduledThreads these can ONLY take Runnables
		 */
		
		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
		
		count = 0;
		
		Runnable task1 = ()->System.out.println("task 1, number is: " + ++count + ". time is: " + LocalTime.now());
		
		//this runs infinately: +++++++++
		service.scheduleAtFixedRate(task1, 3, 2, TimeUnit.SECONDS); //starts after 3 secs, fire a new one every 2 secs
		
		//-------------
		Runnable task2 = ()->System.out.println("task 2, number is: " + ++count + ". time is: " + LocalTime.now());
		service.scheduleWithFixedDelay(task2, 3, 2, TimeUnit.SECONDS); //starts after 3 secs, fire a new one every 2 secs //these will fire AFTER the 
		//-------------------------
		
		/*
		 * This will result in more than 20 tasks being accomplished by the above service,
		 *  however only 10 threads plus the stystem thread will be used to accomplish these tasks.
		 */
		
		try {
			TimeUnit.SECONDS.sleep(19);
		}
		catch(Exception e) {
			System.out.println("exception: " + e);
		}
		finally {
			
			System.out.println("amount of threads in use: " + Thread.activeCount());
			if(!service.isShutdown()) {
				service.shutdown();
			}
			
		}
		
	}
	
	
	
	static void ex18() { 
		
		System.out.println("ex18");
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		int cpuCount=Runtime.getRuntime().availableProcessors();
		
		System.out.println(Runtime.getRuntime().totalMemory());
		System.out.println(Runtime.getRuntime().freeMemory());
		
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
