package com.android;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Examples {
	
	/*
	 * common intermediate operations
	 * These DO NOT run the code. THe code doesn't run until it hits a TERMINAL operation. 
	 * 
	 * filter() //ONLY have these in your list
	 * map()
	 * flatMap()
	 * distinct() //remove duplicates
	 * sorted()
	 * peek()
	 * limit()
	 * skip() //DONT have these in your list 
	 */

	static void ex1() {
		
		System.out.println("\nex1()");
		
		//===========================FILTER=======================
		
		/*
		 * returns a stream with elements that match a given expression.
		 * Takes as an argumenet, a predicate. 
		 * 
		 * Stream<T> filter(Predicate<? super T> predicate)
		 * 
		 */
		
		List<String>apeList=new ArrayList<String>();
		
		Stream<String>apes=Stream.of("monkey", "gorilla", "bonobo", "marmot");
		
		apes.filter(str->str.startsWith("m")).forEach((str)->{
			System.out.println(str);
			apeList.add(str);
		});
		
		//-----another example:
		
		//apeList.clear();
		apes=Stream.of("monkey", "gorilla", "bonobo", "marmot"); //reset stream
		
		//create a band new arraylist and assign it the filtered values:
		List<String>newList = apes.filter(str->str.startsWith("m")).collect(Collectors.toCollection(ArrayList::new));
		
		
		
	}

}
