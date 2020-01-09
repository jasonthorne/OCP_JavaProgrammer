package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Examples {
	
	static void ex1() {
		
		System.out.println("\nex1()");
		
		//CREATING STREAMS ++++++++++++++++++++
		
		//we will use this array OF INTEGERS (has to be an object) to create a stream of Integers:
		Integer[]values= {4,5,6}; 
		
		//create an empty stream:
		Stream<String>empty = Stream.empty();
		
		//create a stream of one element:
		Stream<Integer>singleElement = Stream.of(3);
		
		//creating a stream from an array:
		Stream<Integer>fromArray = Stream.of(values);
		
		//this is also creating a stream with the values 100,200,300:
		Stream<Integer>fromArray2 = Stream.of(100,200,300);
		
		//=============terminal operation:
		
		//for each()
		/*
		 * forEach is a terminal operator that takes a consumer object. 
		 * A consumer takes an object and returns nothing.
		 */
		List<Integer>intList=new ArrayList<>();
		
		fromArray.forEach( (a1)->{ //a1 is an Int. it is a temporary var that gets assigned the value of each int in fromArray
			System.out.println("number is: " + a1);
			a1 = a1*2;
			System.out.println("double our number is: " + a1);
			intList.add(a1);
		});
		
		System.out.println("first number in values is still: " + values[0]);
		
		//======================================================stream from a list:

		//create stream from list:
		List<String>fruits=Arrays.asList("apple", "orange", "banana", "pineapple");
		
		Stream<String>fromFruits=fruits.parallelStream(); //a stream from the list of fruits
		
		fromFruits.forEach((str)->System.out.println(str + " tree")); //print off each item in fruits + "tree"
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
