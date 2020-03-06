package com.android;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

public class Farmer {
	
	static int counter = 0;
	
	private void removeAnimals() {
		System.out.println("removing animals " + counter);
	}
	
	private void cleanPen() {
		System.out.println("cleaning pen " + counter);
	}
	
	private void addAnimals() {
		System.out.println("adding animals " + counter);
	}
	
	public void performTasks(CyclicBarrier c1) {
		counter++;
		
		
		try {
			removeAnimals(); //all 4 threads call this method
			
			c1.await(); //only when ALL 4 threads have finished removeAnimals() AND called c1.await(), will cleanPen be called on any thread.
			
			cleanPen();
			
			c1.await();
			
			addAnimals();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
