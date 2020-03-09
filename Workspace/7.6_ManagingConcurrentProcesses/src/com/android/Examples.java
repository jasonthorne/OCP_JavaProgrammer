package com.android;

import java.math.BigInteger;
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
		
		/*
		 * This cyclicBarrier takes the amount of threads to track, and a Runnable object.
		 * Here, this one only prints out "pen cleaned".
		 * The Runnable object runs once all 4 threads have completed the task (in this case when all the pens have been cleaned.
		 */
		CyclicBarrier c2 = new CyclicBarrier(4, ()->System.out.println("pen cleaned")); 
		
		Set<Farmer>farmers = Stream.generate(()->new Farmer()).limit(4).collect(Collectors.toSet());
		ExecutorService service = Executors.newFixedThreadPool(4);
		for(Farmer f:farmers) {
			service.submit(()->f.performTasks(c1, c2));
		}
		if(!service.isShutdown()) {
			service.shutdown();
		}
		
		//====================
		//StableBoys class:
		
		//create 4 stable boys:
		Set<StableBoy>stableBoys = Stream.generate(()->new StableBoy()).limit(4).collect(Collectors.toSet());
		service = Executors.newFixedThreadPool(4);
		
		//2 cyclicBarriers:
		CyclicBarrier cStable1 = new CyclicBarrier(4, ()->System.out.println("stable boys have cleaned the pen"));
		CyclicBarrier cStable2 = new CyclicBarrier(4, ()->System.out.println("stable boys have cleaned up the horse manure"));
		
		/*
		 * This has a CyclicBarrier between the horse being removed and the stables being cleaned,
		 * and another between the stables being cleaned and the horse being added to the stables again.
		 */
		for(StableBoy s: stableBoys) {
			service.submit(()->s.performTasks(cStable1, cStable2));
		}
		if(!service.isShutdown()) {
			service.shutdown();
		}
		
		/*
		 * If you are using a threadPool, make sure that the number of available threads is at least as large as CyclicBarrier. 
		 * If your thread pool is 2 and your CyclicBarrier is 4, then it would result in a hang as the barrier would never get to 4.
		 * 
		 * Cyclic barrier CAN be less than the pool though. 
		 */
		
	}
	
	static void recursive() {
		System.out.println("recursive method called");
		
		/*
		 * A method calling itself is a recursive method. However a recursive method has ot have a means of coming to a conclusion. 
		 * If not, the method will be called multiple times until a stack overflow error. 
		 * A BASE CASE is an external counter which causes our method to exit after the counter reaches a certain number. +++++++++++++++++++++++++
		 */
		recursive();
	}
	
	
	static void ex3() {
		
		System.out.println("\nex3");
		
		//+++++++++++++++++++RECURSION:
		recursive();
	}
	
	
	static long binomial(Integer num) { //passed as Integer inorder to call the toString()
		
		String strNum = num.toString();
		BigInteger bigNum = new BigInteger(strNum);
		
		if(num<=1) { //if num equals 1, return 1.
			/*
			 * this is the base case, so we keep decrementing num by 1 until 1 becomes 1
			 * at which point the binomial method will no longer call itself
			 */
			return 1;
		}
		else {
			return num*binomial(num-1); //5 * 4 * 3 * 2 * 1
		}

	}
	
	static int biNomialCount = 0;
	
	static BigInteger binomial2(int num) {
		
		biNomialCount++;
		String strNum = ""+num;
		BigInteger bigInt = new BigInteger(strNum);
		
		if(num<=1) { //base case
			return new BigInteger("1");
		}else {
			BigInteger bigInt2 = binomial2(num-1);
			return bigInt2.multiply(bigInt);
		}
	}
	
	
	static void ex4() {
		
		System.out.println("\nex4");
		
		//++++++++++++++++++BINOMIAL:
		
		/*
		 * This used recursion which is a method calling itself
		 * and keeps calling itself until it gets to a base case and then exits the method. 
		 * If a base case is never reached then your program can never finish.
		 * So this will result in a stack overflow error.
		 * Binomial numbers get very large very quickly.
		 * i.e binomial 20 is 2.43 Quintillion, which is 2 and 18 places before a decinal point.
		 *
		 *This is a warning as you can quite easily attempt to do tasks in programming that would take more time to do than the entire lifetime of the universe to complete.
		 */
		
		System.out.println(binomial(5)); //calling regular binomial method
		
		//---------
		/*
		 * calling binomial method that uses the BigInteger data type. 
		 * Which cant use ordinary mmathematical operators such as + * etc..
		 * so you use their own methods such as multiply() and add()
		 */
		
		System.out.println(binomial2(984));
		System.out.println("number is: " + binomial2(984).toString().length() + " digits long");
		System.out.println("binomial2 method was called: " + biNomialCount + " times");
		
	}
	
	
	
	
	
	
	
	
	
	

}
