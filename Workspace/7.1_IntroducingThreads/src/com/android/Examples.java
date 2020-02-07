package com.android;

public class Examples {
	
	static void ex1() { 
		
		System.out.println("\nex1:");
		
		//======================================RUNNABLE
		
		/*
		 * Any class that wishes to use threads, has to implement the "Runnable" interface:
		 * @FunctionalInterface public interface Runnable{
		 * void run();
		 */
		
		//create 3 threads:
		Runnable r1=()->System.out.println("R1 runnable lambda");
		
		Runnable r2=()->{
			System.out.println("R2 runnable lambda");
		};
		
		Runnable r3=()->{
			System.out.println("R3 runnable lambda");
			return;
		};
		
		
		//run threads:
		r1.run();
		r2.run();
		r3.run();
		
	}
	
	
	
	
	static void ex2() { 
		
		System.out.println("\nex2:");
		
		//======================================CREATING THREAD
		
		/*
		 * ONLY a class that implements runnable, can be included as an arg in creating a thread.
		 * PrintData implements runnable, so this can be included. 
		 */
		
		Thread t1 = new Thread(new PrintData());
		
		System.out.println("first thread");
		t1.start(); //this causes the run method in printData to run
		
		
		
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
