package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
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
		System.out.println();
		//=============================================================================================================
		//EXAMPLE:
		
		Stream<Animal>randAnimal=Stream.generate(()->{
			int num = (int)(Math.random()*100);
			return new Animal(num, "bob");
		});
		
		System.out.println();
		//randAnimal.forEach(System.out::println); //infinite loop
		
		randAnimal.limit(4).forEach(System.out::println);
		
		//supplier obj:
		Supplier<Animal>supAnimal=()->{
			int num = (int)(Math.random()*100);
			return new Animal(num, "bob");
		};
		
		randAnimal=Stream.generate(supAnimal); //passing supplier into stream
		System.out.println("");
		randAnimal.limit(4).forEach(System.out::println);
		
		
		//----------------
		
		randAnimal=Stream.generate(supAnimal); //reset stream
		
		List<Animal>animalList=new ArrayList<Animal>();
		randAnimal.limit(10).forEach((a1)->animalList.add(a1));
	
		
	}
	
	
	static void ex3() {
		
		System.out.println("\nex3()");
		
		//============================================ITERATE +++++++++++++++++++++++++++++++++++++++++++++
		
		/*
		 * Iterate can be used fro creating streams. 
		 * Iterate for streams takes 2 params; A seed (which will be a starting value), and a unary operator 
		 * (a unirary operatoe takes an aobject and returns an object the same type)
		 * 
		 * In this case we have a starting seed of the number 1, and add 2 to the number each time, which produces an infinate stream of odd numbers. 
		 * starting at 1 -> 1+2=3, 3+2=5 etc..
		 */
		
		//Starting at number 1, take in n and return n+2.
		Stream<Integer>oddNumbers=Stream.iterate(1, (n)->n+2);
		//This will print out an infinite number of odd numbers:
		//oddNumbers.forEach(System.out::println);
		
		
		oddNumbers.limit(25).forEach(System.out::println); //print 25 odd numbers
		
		//Produce 25 even numbers: ====================================
		
		Stream<Integer>evenNumbers=Stream.iterate(2, (n)->{
			Integer number=(int)(Math.random()*1000);
			/*
			 * using modulus to determine if the number is even
			 */
			
			/*
			 * one method:
			if(number%2==0)
				return number;
			else
				return number+1;
			*/
			
			//another method:
			
			//if the number %2 is 0, the number is even, and return it
			//else the number is odd, so add 1 to the number and return that.
			return number%2==0?number:number+1;
			
			
		});
		
		//print 25 even numbers:
		System.out.println("");
		//evenNumbers.limit(25).forEach(System.out::println); 
		
		//filter:
		//evenNumbers.filter((n)->n%10==0).forEach(System.out::println); 
		
		
		
		//--------------+++++++++++++++++++++++++++++++++++++++++++++++++
		
		List<String>people=new ArrayList<>(Arrays.asList("bill", "ben", "bob", "cuthbert"));
		//filter out the objects that are greater than 4 in length:
		people.stream().filter(s->s.length()>3).forEach(System.out::println);
		
	}

}
