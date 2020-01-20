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
		

	}
		
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
