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
		
		Stream<String>fromFruits=fruits.stream(); //a stream from the list of fruits
		
		fromFruits.forEach((str)->System.out.println(str + " tree")); //print off each item in fruits + "tree"
		
		//fromFruits.forEach(System.out::println); //double colon operator for printing items
		
		//CANT perform a second terminal operation on a stream, as stream is now finished +++++++++++++++++++++++++++
		//fromFruits.forEach(System.out::println); //falls over as stream is finished.
		
		fromFruits=fruits.stream(); //REDEFINE the stream 
		
		//THEN you use another terminal operator:
		fromFruits.forEach(System.out::println); //double colon operator for printing items
		
		//==================parallel stream:
		
		/*
		 * Parallel Streams utilises multiple CPU course if your machine has them. 
		 * If they are not parallel streams, then they are said to be sequential (one after another)
		 */
		
		Stream<String>fromFruitParallel=fruits.parallelStream();
		
		fromFruitParallel.forEach((str)->System.out.println("johhny " + str + "seed"));
		
		
		//-----------------------------------------
		
		fromFruits=fruits.stream(); //redefine the stream 
	}
	
	
	static void ex2() {
		
		System.out.println("\nex2()");
		
		//=========================produce random numbers between 1 & 100
		
		System.out.println("random number between 1 & 100: " + (int)(Math.random()*100));
		System.out.println("generate()");
		
		/*
		 * You can produce an infinite stream very easily. You cant create an infinate list. 
		 * Generate takes a supplier, which takes no params and returns an object of type T
		 * in this case it will return an Integer.
		 */
		
		//GENERATE:  +++++++++++++++++++++++++++++
		Stream<Integer>randoms=Stream.generate(()->{
			System.out.print("\nrandom number: ");
			return (int)(Math.random()*100); //taking in nothing and producing a random number (1-100)
	
		});
		
		//TERMINAL operation called on stream, which runs the stream. This produces an infinite amount of integers.
		//randoms.forEach(System.out::print);
		
		//LIMIT +++++++++++++++++++++++++++++
		
		/*
		 * limit is an INTERMEDIATE operation that doesn't run until the stream hits a terminal operation. 
		 */
		randoms.limit(10).forEach(System.out::print);
		
		
		//EXAMPLE:
		
		Stream<Animal>randAnimal=Stream.generate(()->{
			int num = (int)(Math.random()*100);
			return new Animal(num, "bob");
		});
		
		System.out.println();
		//randAnimal.forEach(System.out::println);
		
		randAnimal.limit(4).forEach(System.out::println);
		
	}

}
