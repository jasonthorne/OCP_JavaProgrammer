package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Examples {
	
	static void ex1() {
			
		//==========================EXAMPLES WITHOUT STREAMS=======================

		System.out.println("\nex1()");
		
		/*
		 * Take a list of names and pick out only those names with 4 letters in it. 
		 * and then pick out the top 2, when the list is sorted in alphabetical order:
		 */
		
		System.out.println("using lists and loops:");
		
		List<String>names=Arrays.asList("bob", "stewart", "jenkins", "huberty", "purple-monkey-dishwasher");
		
		//we need a new list that's going to hold our final liat of strings:
		List<String>filtered=new ArrayList<String>();
		
		//we use this loop to populate our filtered arrayList with names 7 characters long.
		for(String name: names) {
			if(name.length()==7) {
				filtered.add(name);
			}
		}
		
		//filtered now contains: "stewart", "jenkins", "huberty", but isn't sorted. So we use 
		
		Collections.sort(filtered);
		System.out.println("filtered is now: " + filtered);
		
		if(filtered.size()>2) {
			System.out.println("size of filtered list is: " + filtered.size());
			
			int size=filtered.size()-1;
			
			/*
			 * start at size of list index and work down until it gets to index 1.
			 */
			for(int i=size; i>1; i--) {
				filtered.remove(i);
			}
		}
		
		System.out.println("our final list is:" + filtered);
		
		
		
		
		//---------------------FILTERED VERSION OF ABOVE:
		
		names.stream()
		.filter(s -> s.length()==7)
		.sorted()
		.limit(2)
		.forEach(System.out::println);
		
		//save above to a new array:
		List<String>list = names.stream()
				.filter(s -> s.length()==7)
				.sorted()
				.limit(2)
				.collect(Collectors.toList());
		
		
		System.out.println("our final list is:" + list);
		
	}
	
	
	static int count = 0;
	
	
	static void ex2() {
		
		//============================ORDER OF STREAM OPERATIONS+++++++++++++++++++++++++
		
		System.out.println("\nex2()");
		
		/*
		 * The order of stream operations DOES MATTER as can be shown in this example:
		 */
		
	
		//SORT THEN LIMIT:
		
		/*
		 * You CANT sort an infinite streram
		 * You need to limit it FIRST then sort()
		 */
		
		/*
		Stream.generate(()->{ //generate will produce an infinate amount of streams unless limited
			count++;
			if(count%2>0)
				return "eddie";
			return "ethna";
		})
		.sorted() //this is attempting to sort an infinite list, so this will continue forever
		.limit(4).forEach(System.out::println);
		*/
		
		Stream.generate(()->{ //generate will produce an infinite amount of streams unless limited
			count++;
			if(count%2>0)
				return "eddie";
			return "ethna";
		})
		.limit(4) //this limits our otherwise infinite stream to 4 
		.sorted().forEach(System.out::println); //THEN we sort it, then add a terminal operator
		
		
		
		//---------------------------------------
		
		Stream.iterate(1, x->x+1) //This creates an infinite stream of numbers. Starts at 1 and increments by 1.
		.limit(5) //limits the stream to 5 numbers, which will be: 1,2,3,4,5
		.filter(x->x%2==1) //allows only odd numbers
		.forEach(System.out::println); //prints 1.3.5
		
		//-------
		
		Stream.iterate(1, x->x+1) //This creates an infinite stream of numbers. Starts at 1 and increments by 1.
		.limit(5) //limits the stream to 5 numbers, which will be: 1,2,3,4,5
		.peek(System.out::println)
		.filter(x->x%2==1) //allows only odd numbers
		.peek((x)->System.out.println("peek is now: " + x )) //peek AFTER the filter only gives a 1,3 & 5
		.forEach((x)->System.out.println("number is now: " + x )); //prints 1.3.5
		
	}
	
	
	

	static void ex3() {
		
		//============================PRIBTING A STREAM+++++++++++++++++++++++++
		
		System.out.println("\nex3()");
	
		List<String>names=Arrays.asList("bob", "stewart", "ben", "huberty", "frank");
		
		//--------------------
		System.out.println();
		//method 1 of printing a stream: forEach()
		names.parallelStream().forEach(System.out::println);
		
		//--------------------
		System.out.println();
		//method 2 of printing a stream: Converting to a Collection object
		System.out.println(names.stream().collect(Collectors.toList())); //takes a list, converts to a stream, then prints as a list (can be stored in a list as well)
		
		//--------------------
		System.out.println();
		//method 3 of printing a stream: Using Peek
		names.stream().peek((System.out::println)).count(); //terminal operation need for stream to fire
		
		//--------------------
		System.out.println();
		//method 4 of printing a stream: 
		
		names.stream()
		.limit(4) //this produces a stream of the first 4 elements 
		.sorted() //this sorts those elements
		.forEach(System.out::println); //print sorted elements
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		

}
