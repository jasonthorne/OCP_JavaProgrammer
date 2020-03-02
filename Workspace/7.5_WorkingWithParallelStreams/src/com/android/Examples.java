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
		
		
		list.stream().forEach((n)->System.out.print(n+ " ")); //print in the ORDER they are in the list, using stream
		
		System.out.println();
		
		
		//prints the numbers in the list HOWEVER there is NO ORDER, so this could be a lot faster than using a regular stream.
		list.parallelStream().forEach((n)->System.out.print(n + " ")); 
		
		System.out.println();
		
		//this changes the stream back to an ordered stream:
		list.parallelStream() //this allows more than one thread to act upon this stream at the same time
		.filter((n)->n>50) //this is still a parallell stream
		.forEachOrdered((n)->System.out.print(n + " ")); //this is now a single threaded stream
		
		
		//===========================
		
		
		
	}

}
