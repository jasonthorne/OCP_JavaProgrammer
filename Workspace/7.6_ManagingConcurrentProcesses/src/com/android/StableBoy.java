package com.android;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class StableBoy {
	
	AtomicInteger counter = new AtomicInteger(0);
	
	private void removeAnimals() {
		System.out.println("removing animals "); 
	}
	
	private void cleanPen() {
		System.out.println("cleaning pen "); 
	}
	
	private void addAnimals() {
		System.out.println("adding animals "); 
	}
	
	public void performTasks(CyclicBarrier c1, CyclicBarrier c2) {
		
		counter.addAndGet(1); //increment atomic counter
	
		try {
			removeAnimals(); //all 4 threads call this method
			
			c1.await(); //only when ALL 4 threads have finished removeAnimals() AND called c1.await(), will cleanPen be called on any thread.
			cleanPen();
			c2.await(); 
			addAnimals();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
