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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
