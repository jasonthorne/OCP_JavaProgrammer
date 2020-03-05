package com.android;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Examples {
	
	static void ex1() {
		
		System.out.println("\nex1");
		
		//-----------------------
		//Zookeepers:
		
		/*
		 * 4 zoo keepers (which will actually be 4 threads),
		 * which each do 3 different tasks for the lion pen:
		 * 
		 * removeAnimals()
		 * cleanPen()
		 * addAnimals()
		 * 
		 * All zoo workers can join in each of the tasks. 
		 * But we don't want them to start a new task until the previous task has been completed.
		 */
		
		ZooKeeper zed = new ZooKeeper();
		
		ExecutorService service = Executors.newFixedThreadPool(4); //pool of 4 threads
		
		for(int i=0;i<4;i++) {
			service.submit(()->zed.performTasks());
		}
		
		
		
	}

}
