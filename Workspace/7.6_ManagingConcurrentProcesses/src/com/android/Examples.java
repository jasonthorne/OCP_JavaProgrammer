package com.android;

import java.util.Set;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		
		//set of 4 zookeepers that will each be run on a single thread:
		Set<ZooKeeper>zooKeepers = Stream.generate(()->new ZooKeeper()).limit(4).collect(Collectors.toSet());
		ExecutorService service = Executors.newFixedThreadPool(4); //pool of 4 threads
		
		//for each zookeeper thread in zookeeprs: run the performTasks() method.
		
		/*
		 * This leads to some zoo keeps cleaning the pen, while other zookeeprs are still removing animals, 
		 * and some other zookeepers have already progressed to adding lions, while some zookeepers are still removing lions,
		 * or cleaning the pen. Nightmare! 
		 * 
		 * If this were a single thread then the results WOULD be in the correct order.
		 */
		for(ZooKeeper z: zooKeepers) {
			service.submit(()->z.performTasks());
		}if(!service.isShutdown()) {
			service.shutdown();
		}
		

		
	}
	
	
	static void ex2() {
		
		//+++++++++++++++++++CYCLIC BARRIER:
		
		/*
		 * CyclicBarrier has a number of constructors. 
		 * one takes an int which is the amount of threads we want our application to wait on to complete, 
		 * while we these threads complete a task or subtask.
		 * i.e. we have 4 threads (1 for each farmer) inside the performTask method.
		 * The 4 threads will not progress onto CleaningPen untill they have all completed removeAnimals();
		 */
		CyclicBarrier c1 = new CyclicBarrier(4);
		
		Set<Farmer>farmers = Stream.generate(()->new Farmer()).limit(4).collect(Collectors.toSet());
		ExecutorService service = Executors.newFixedThreadPool(4);
		for(Farmer f:farmers) {
			service.submit(()->f.performTasks());
		}
	}

}
