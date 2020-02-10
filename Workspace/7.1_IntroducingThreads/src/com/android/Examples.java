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
		
		//this is a user defined thread:
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
	
	static void ex4() { 
		
		
		//======================================ALL TASKS IN USER DEFINED THREADS:
		
		//this statement is running on the system thread
		System.out.println("\nex4:");
		
		//this is a user defined thread:
		new Thread(()->{
			for(int i=0;i<500_000;i++) {
				counter++;
			}
		}).start();
		
		
		//another user defined thread:
		new Thread(()->{
			
			int wCounter = 0;
			
			while(counter<500_000) {
				System.out.println("not reached yet");
				wCounter++;
			}
			
			System.out.println("while loop has executed: " + wCounter + " times");
			
		}).start();
		
		
	}
	
	
	static void ex5() throws InterruptedException{ 
		
		
		//======================================THREADS WITH SLEEP:
		
		//this statement is running on the system thread
		System.out.println("\nex5:");
		
		//this is a user defined thread:
		new Thread(()->{
			for(int i=0;i<500_000;i++) {
				counter++;
			}
		}).start();
		
		int wCounter = 0;
		
		/*
		 * This while loop is part of the system thread, so while loop is a task on the system thread
		 * So it will start while the user defined thread is still running, 
		 * so our for loop above and our while loop here are running at the same time.
		 * The while loop will keep executing untill the for loop increments counter to be above 500_000.
		 * So this while loop also cant guarantee how many times the ahile loop will execute. 
		 */
		
		
		//this is on the system thread:
		while(counter<500_000) {
			System.out.println("not reached yet");
			wCounter++;
			
			/*
			 * thread.sleep puts the system thread to sleep for x millisecs.
			 * It's considered bad coding practice NOT to put in some sort of delay.
			 * After the first iteration of this loop, this thread (the system thread) will go to sleep for 100 milis, 
			 * so will not access any other thread for 100 millisecs.
			 */
			Thread.sleep(1);
		}
		System.out.println("reached");
		System.out.println("while loop has executed: " + wCounter + " times");
		
	}
	
	
	
	static void ex6() throws InterruptedException{ 
		
		
		
		
		//this statement is running on the system thread
		System.out.println("\nex6:");
		
		//this is a user defined thread:
		new Thread(()->{
			for(int i=0;i<500_000;i++) {
				counter++;
			}
		}).start();
		
		
		//another user defined thread:
		new Thread(()->{
			
			int wCounter = 0;
			
			while(counter<500_000) {
				
				try {
					System.out.println("not reached yet");
					wCounter++;
					/*
					 * sleep below could throw an interrupted exception so has to be put in a try/catch or thrown
					 */
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("while loop has executed: " + wCounter + " times");
			
		}).start();
		
		
	}
	
	static int counter1 = 0;
	static int counter2 = 0;
	static int counter3 = 0;
	
	
	static void ex7(){ 
		
		
		//======================================THREE THREADS ACCESSING VARIABLES IN EACH THREAD:
		
	
		System.out.println("\nex7:");
	
		//make thread 1:
		Thread t1 = new Thread(()->{
			System.out.println("t1 started");
			for(int i=0; i<1_000_000;i++) {
				counter1++;
			}
			System.out.println("in thread1, access counter2: " + counter2);
			System.out.println("in thread1, access counter3: " + counter3);
		});
		
		//make thread 2:
		Thread t2 = new Thread(()->{
			counter2 = 2_000_000;
			System.out.println("t2 started");
			for(int i=2_000_000; i<3_000_000;i++) {
				counter2++;
			}
			counter1=2_000_000;
		});
		
		//make thread 3:
		Thread t3 = new Thread(()->{
			counter3 = 4_000_000;
			System.out.println("t3 started");
			for(int i=4_000_000; i<5_000_000;i++) {
				counter3++;
			}
		});
		
		
		//start threads:
		t1.start();
		t2.start();
		t3.start();
		
		/*
		 * The three threads each have a loop that could be all operating at the same time. 
		 */
		System.out.println("Before system thread sleep");
		
		System.out.println("counter1 is: " + counter1);
		System.out.println("counter2 is: " + counter2); 
		System.out.println("counter3 is: " + counter3);
		
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("after sleep");
		
		System.out.println("counter1 is: " + counter1);
		System.out.println("counter2 is: " + counter2); 
		System.out.println("counter3 is: " + counter3);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
		
}
