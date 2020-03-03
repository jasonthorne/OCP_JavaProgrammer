package com.android;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Examples {
	
	static void ex1() {
		
		System.out.println("\nex1");
		
		//Synchronized versions of non-concurrent collections================================
		
		List<Integer>list = Stream.generate(()->(int)(Math.random()*100)+1).limit(40).collect(Collectors.toList());
		
		System.out.println(list); //print list
		
		//EVERYTHING in this stream is done one after another:
		list.stream().forEach((n)->System.out.print(n+ " ")); //print in the ORDER they are in the list, using stream
		
		System.out.println();
		System.out.println("amount of threads: " + Thread.activeCount()); //amount of threads: 1 (uses just the system thread). 
		
		//prints the numbers in the list HOWEVER there is NO ORDER, as x threads can access this at a single time.
		list.parallelStream().forEach((n)->System.out.print(n + " "));  //this is a multi-threaded stream.
		
		System.out.println();
		
		//this changes the stream back to an ordered stream:
		list.parallelStream() //this allows more than one thread to act upon this stream at the same time using the max amount of threads on your system.
		.filter((n)->n>50) //this is still a parallel stream
		.forEachOrdered((n)->System.out.print(n + " ")); //this is now a SINGLE threaded stream (not multi-threaded)
		
		System.out.println();
		System.out.println("amount of threads: " + Thread.activeCount()); //amount of threads: 4
		
		//===========================
		
	}
	
	
	static void ex2() {
		
		System.out.println("\nex2");
	
		//Sorted Streams================================
		
		
		//15 random numbers:
		List<Integer>list = Stream.generate(()->(int)(Math.random()*100)+1).limit(15).collect(Collectors.toList());
		
		//sort the random numbers of the list:
		list.stream().sorted().forEach((i)->System.out.print(i + ","));
		
		
		System.out.println();
		
		/*
		 * This is an example of certain stream operations (when used with parallel streams) not working the same as with ordinary single threaded streams.
		 */
		list.parallelStream().sorted().forEach((i)->System.out.print(i + ","));
		
		System.out.println();
		
		
		list.parallelStream().sorted().forEachOrdered((i)->System.out.print(i + ","));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
