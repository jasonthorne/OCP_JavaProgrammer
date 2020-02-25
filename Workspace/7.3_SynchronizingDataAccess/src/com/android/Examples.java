package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

import com.android.Human.Nationality;

public class Examples {
	static int count = 0;
	static void ex1() { 
		
		System.out.println("ex1");
		
		List<Human>humans=new ArrayList<>();
		
		//this creates a human of every nationality and adds them to our existing Humans list:
		Arrays.asList(Nationality.values()).stream().forEach((nationality)->{
			humans.add(new Human((int)(Math.random()*100), (Math.random()*100), (Math.random()*100), nationality));
		});
			
		System.out.println(humans);
		
		
		//------------------------------
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		/*
		for(Human myHuman:humans) {
			myHuman.age = myHuman.age*2;
		}
		*/
		count = 0;
		
		/*
		Runnable task1 = ()->{
			human.get(count).setAge()
		}*/
		
		
		System.out.println(humans);
		
		
		/*
		 * If you have 2 threads accessing the same bloc of code or variable at the same you can have a race condition.
		 *As both threads are CHANGING some aspect of the same vartiable or code, so you can have no idea what the end rwesult is. 
		 *
		 */
		
	}
	
	static AtomicInteger atomCount = new AtomicInteger(0); //a static atomic integer
	
	static void ex2() { 
		
		System.out.println("ex2");
		
		//=====================ATOMIC CLASSES +++++++++++++++++++++++++++++++
		
		/*
		 * Atomic classes and their instances can only be accessed by one thread at one time.
		 * i.e an int age can be accessed by many threads at the same time.
		 * An automic Integer age can only be accessed by one thread at a time.
		 * 
		 */
		
		AtomicBoolean atomBool; //a boolean value that can only be accessed by one thread at a time
		
		AtomicInteger atomInt = new AtomicInteger(200); //can assign a value directly to an atomic var, you haveto use the new keyword.
		
		AtomicIntegerArray atomArray = new AtomicIntegerArray(5); //an array of integers, and the array itself can only be accessed by one thread at a time.
		
		AtomicLong atomicLong = new AtomicLong(6);
		
		AtomicLongArray atomArrayLong = new AtomicLongArray(10); //an array of 10 longs, and the array itself can only be accessed by one thread at a time.
		
		AtomicReference atomDog = new AtomicReference(new Dog()); //this is an obj that can only be accessed by one thread at a time.
		
		/*
		 * There is no atomic double, however you can do something like this:
		 */
		
		AtomicReference atomDouble = new AtomicReference(new Double(3.33));
		
		/*
		 * If you want to make an object thread safe, you can use one of the atomic classes +++++++++++++
		
			ALL objects and ALL primitives are NOT thread safe
		 */
		
		
		System.out.println(atomInt); //this is NOT a primitive int or Integer wrapper.
		
		//System.out.println(atomInt + atomInt); ------wont compile
		//System.out.println(atomInt++); ------wont compile
		
		//you HAVE to use the methods of athe atomic classes to do any calculations on atomic variables:
		
		//use GET() to get the numeric value of the atomic int
		System.out.println(atomInt.get() + atomInt.get()); 
		
		//atomicInt = 45; //doesnt work!!
		
		atomInt.set(3); //works! woohoo :P
		
		System.out.println("value is now: " + atomInt.get());
		
		//--------------
		//get and set (sets the new value and returns the old value)
		
		System.out.println(atomInt.getAndSet(333));
		
		//----------
		//increment and get - same as pre increment (++x)
		System.out.println(atomInt.incrementAndGet());
		
		
		//----------
		//get and increment  - same as post increment (x++)
		System.out.println(atomInt.getAndIncrement());
		
		//----------
		//'decrement and get' and 'get and decrement' are as expected:
		System.out.println(atomInt.decrementAndGet());
		System.out.println(atomInt.getAndDecrement());
		
		//===========================================================atomic vars in action:
		
		//ourthread pool is set to size 20, so no more than 20 threads operating at the same time.
		ExecutorService service = Executors.newFixedThreadPool(20);
		
		//------------------------

		atomCount.set(0);
		
		
		/* ++++++++++++++++++++++++++++++++++++
		 * This is acessing the atomicInteger atomCount and incrementing each time the incrementAtom method is called, so this is an Atomic variable,
		 * ionly one thread can access this at any one time, you cant get unexpected outcomes like repeating numbers. 
		 */
		for(int i=0;i<10;i++) {
			service.submit(()->incrementAtom());
		}
		
		
		//-------------------------------------------
		
		//This is the same thing as above, but will cause errors as this is NOT thread safe:
		
		try {
			for(int i=0;i<10;i++) {
				service.submit(()->incrementCount());
			}
			
		}catch(Exception e) {
			
		}finally {
			
			System.out.println("amount of threads is: " + Thread.activeCount());
			//check if service is shut down:
			if(!service.isShutdown()) {
				service.shutdown();
			}
			
		}

		
	}
	
	
	static void incrementCount() {
		System.out.println(++count);
	}
	
	static void incrementAtom() {
		System.out.println(atomCount.incrementAndGet());
	}
	
	
	static void ex3() { 
		
		System.out.println("ex3");
		
		//=====================SYNCHRONIZATION +++++++++++++++++++++++++++++++
		/*
		 * making a block of code thread safe, so only one thread ayt a time can enter a particular block of code
		 * There are 2 basic types:
		 * 
		 * + synchronization of a block of code using Monitor object.
		 * 
		 * + synchronization of a method.
		 */
		
		//====================
		//Using a local object to mark code as being synchronized:
		
		Dog spot = new Dog();
		
		{
			System.out.println("this code is not synchronized and many threads could be accessing this var at the same time:");
			int age = 45; //age is local to these brackets
		}
		
		
		/*
		 * This block of code is synchronized and only one thread at a time can access this code.
		 * this is synchronizing with a local object. If we change spot inside the synchronized block then the code is no longer synchronized.
		 */
		synchronized(spot) {
			//if we change the dog object spot, then this code is no longer synchronized
			spot.dogCount++;
		}
		
		//------------
		
		ExecutorService service = Executors.newFixedThreadPool(15);
		count = 0;
		/*
		 * it is preferable to use a private final object as the object that marks a block of code as synchronized.
		 * As it's final and private, this MONITOR OBJECT cannot be accessed outside of the class, and also cannot be changed.
		 * 
		 * If you could change this object, that owuld mean that as soon as you change the object, youe block of code is no longer synchronized.
		 */
		System.out.println("Using obj_Lock to synchronize code:");
		//instead of using atomic numbers, we are synchronizing this block of code
		synchronized(OBJ_LOCK) {
			
			/*
			 * This block of coce is synchronized, so only one thread at a time can access this block.
			 */
			
			for(int i=0;i<10;i++) {
				service.submit(()->incrementCount());
			}
			service.shutdown();
		}
		
		//----------
		/*
		 * This is using the examples class to synchronize this block of code. 
		 */
		synchronized(Examples.class) {
			
			service = Executors.newFixedThreadPool(15); //threads created inside here are NOT synchronized (so this doesnt work) ++++++++++++++++
			count = 0;
			
			for(int i=0;i<10;i++) {
				service.submit(()->incrementCount());
			}
			service.shutdown();
			
		}
		
	
	}
	
	private static final Object OBJ_LOCK = new Object();
	Integer num = 0;
	static Double dbl = 0.0;
	void useSync() {
		
		/*
		 * As long as it's not a static method, you can use the keyword "this" to mark a block of code as being synchronized.
		 * If we create an object of the examples class and then use that object to call this method.
		 * This is the object that will synchronize this block of code.
		 */
		
		synchronized(this) {
			
		}
		
		synchronized(num) {
			
		}
		
		synchronized(dbl) {
			
		}
		
		
		
	}
	
	
	static void ex4() { 
		
		System.out.println("ex4");
		
		//=====================SYNCHRONIZED METHODS +++++++++++++++++++++++++++++++
		count = 0;
		
		Examples ex1 = new Examples();
		ExecutorService service = Executors.newFixedThreadPool(25);
		
		try {
			for(int i=0;i<10;i++) {
				
				/*
				 * As the method statSyncCount is synchronized, 
				 * this will only allow one thread ata time to enter the method, s
				 * o no duplicate numbers are produced, and will always end up at 10
				 */
				//service.submit(()->statSyncCount()); //this gets as far as 10
				//service.submit(()->ex1.statSyncCount()); //this gets as far as 20
				
				//---------- no synchronized way which causes problems:
				service.submit(()->incrementCount());
				service.submit(()->incrementCount());
				//----------
			}
		}finally {
			service.shutdown();
		}
		
	
	}
	
	//NON static synchronized
	private synchronized void syncCount() {
		System.out.println(++count);
	}
	
	//static synchronized
	static synchronized void statSyncCount() {
		System.out.println(++count);
	}
	
	
	
	static void ex5() { 
		
		System.out.println("ex5");
		
		//=====================COST OF SYNCHRONIZATION +++++++++++++++++++++++++++++++
		
		/*
		 * Synchronization can be useful, 
		 * but is costly in that it is taking a multi threaded program and synchronizartion 
		 * is about getting your program to behave like a single threaded application. 
		 * Synchronization is about protecting data integrity at the cost of performance. 
		 */
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
}
