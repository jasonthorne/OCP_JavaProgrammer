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
		
		//create 3 Runnables:
		Runnable r1=()->System.out.println("R1 runnable lambda");
		
		Runnable r2=()->{
			System.out.println("R2 runnable lambda");
		};
		
		Runnable r3=()->{
			System.out.println("R3 runnable lambda");
			return;
		};
		
		
		//run Runnables:
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
		
		Thread t1 = new Thread(new PrintData()); //task to accomplish is passed into thread as arg ++++++++++++++++++++++++
		
		
		
		System.out.println("first thread");
		t1.start(); //this causes the run method in printData to run //PRINTS 0 - 9 (using static counter)
		
		//---------------second thread:
		
		//create a new thread with a printData task, and then start that thread:
		new Thread(new PrintData()).start(); ///PRINTS 10 - 19 (using static counter)
		
		
		//------------------
		//This is a lambda implementation of the runnable interface. 
		Runnable r1=()->System.out.println("R1 runnable lambda"); //task to be performed in run method of Runnable
		Thread t2 = new Thread(r1); //create new thread, passing in task
		t2.start(); //call the start method of the thread which executes the run method
		//---------------------
		
		//==============================Java 7 way of using threads: ++++++++++++++++++++++
		
		/*
		 * Rather than extend the thread class like below, you should implement the Runnable interface 
		 */
		
		new MyThreads().start();
		
		MyThreads myT = new MyThreads();
		myT.start();
		
		
		
	}
		
	static int counter = 0;
		
	static void ex3() { 
		
		
		//======================================THREADS WITHOUT SLEEP:
		
		//this statement is running on the system thread
		System.out.println("\nex3:");
		
		//this is a user defined thread
		new Thread(()->{
			for(int i=0;i<500_000;i++) {
				counter++;
			}
		}).start();
		
		int wCounter = 0;
		
		/*
		 * This wghile loop is part of the system thread, so while loop is a task on the system thread
		 * So it will start while the user defined thread is still running, 
		 * so our for loop above and our while loop here are running at the same time.
		 * The while loop will keep executing untill the for loop increments counter to be above 500_000.
		 * So this while loop also cant guarantee how many times the ahile loop will execute. 
		 */
		
		
		//this is on the system thread:
		while(counter<500_000) {
			System.out.println("not reached yet");
			wCounter++;
		}
		System.out.println("reached");
		System.out.println("while loop has executed: " + wCounter + " times");
		
		
		
	}
		
		
		
		
		
		
		
		
		
}
