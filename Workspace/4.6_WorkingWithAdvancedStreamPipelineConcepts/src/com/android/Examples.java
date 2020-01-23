package com.android;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Examples {
	
	
	static void ex1() {
		
		//===========================LAZY INSTATIATION
		
		System.out.println("\nex1()");
		
		Dog spot = new Dog(2, "spot");
		
		//-------
		
		Human myHuman = new Human(24, "Jo", 2);
		myHuman.makeShoes();
		
	}
	
	
	
	static void ex2() {
		
		/*
		 * Optional functional programming is mainly concerned with filter, map & flatMap: 
		 * 
		 */
		//===========================OPTIONALS - You can use stream-like programming for optionals.
		
		System.out.println("\nex2()");
		
		Optional<Integer>optInt=Optional.of(123);
		
		//check if an optional is present:
		if(optInt.isPresent())
			System.out.println(optInt.get());
			
		/*
		 * We are attempting to check if a number is 3 characters long.		
		 */
		
		if(optInt.isPresent()) {
			Integer num = optInt.get();
			
			String string = "" + num;
			
			if(string.length()==3)
				System.out.println(string+ " is three digits long");
			else
				System.out.println(string+ " is not three digits long");
			
		}//if
		
		
		//----------------------------
		System.out.println("using functional programming with Optional<T>.( Optionals for objects)");
		
		
		//optInt = Optional.empty(); //++++++++evn if the optional is empty, below will still work (as in not fallover :P).
		
		optInt.map(n->""+n) //change optional of type Integer to optional of type String ++++++++++++++++++++++++++++
		.filter((s)->s.length()==3)
		.ifPresent(s->{
			System.out.println("number in string format is: " + s);
			System.out.println("s is a: " + s.getClass().getSimpleName());
		});
		
		//-------------------------------
		
		List<Integer>nums=Stream.generate(()->(int)(Math.random()*100))
				.distinct()
				.limit(5)
				.peek(System.out::println)
				.collect(Collectors.toList());
		
		
		Optional<Integer>optMax = nums.stream().max((n1,n2)->n1-n2);
		
		System.out.println(optMax); //prints out the optional
		
		System.out.println(optMax.orElse(0)); //prints out the actual int or 0
		
		System.out.println(optMax.orElseGet(()->(int)(Math.random()*100))); //prints out the actual int or a random int.
		
		
		//-------------------------------
		
		String str = "123456";
		Optional<String>optStr=Optional.of(str); //this contains the string "123456"
		Optional<Integer>result = optStr.map(s->s.length()); //this contains the number 6
		
		System.out.println(optStr); //this is Optional<String>
		System.out.println(result); //this is Optional<Integer>
		
		System.out.println(optStr.get()); //getting the string from the optional
		System.out.println(result.get()); //getting the int from the optional
		
		result = optStr.map(String::length);
		
		//--------------------------------
		
		str="Hello there";
		result = calculator(str);
		System.out.println("result is: " + result.get());
		
		//------
		
		optStr = Optional.of("good golly miss molly");
		
		//--------These DONT WORK:
		/*
		result=optStr.map(s->calculator(s));
		result=optStr.map(Examples::calculator);
		*/
		
		/*
		 * If you want to convert from one optional type to another, 
		 * i.e here from an optional string to optional Integer, you should use a flatMap instead of a map.
		 */
		result=optStr.flatMap(s->calculator(s)); //flatmap changes our optional s intoa string s +++++++++
		result=optStr.flatMap(Examples::calculator); 
		
	}
	
	/*
	 * This takes in a string and returns an Optional integer which is the amount of characters in the string sent to this method. 
	 */
	static Optional<Integer>calculator(String str){
		Optional<String>optStr=Optional.of(str);
		//Converts from an optional string to an optional integer:
		return optStr.map(String::length);
	}
	
	
	
	static void ex3() {
		
		
		//===========================COLLECTIONS & FUNCTIONAL PROGRAMMING using collect
		
		System.out.println("\nex3()");
		
		List<String>namesList = Arrays.asList("dog", "cat", "mouse", "cow", "sheep", "pig");
		
		//stream of 15 odd numbers:
		Stream<Integer>intStream=Stream.iterate(1, n->n+3)
				.filter(n->n%2==1)
				.limit(15);
		
		//stream of 15 even numbers:
		Stream<Double>doubleStream=Stream.iterate(2.0, n->n+5)
				.filter(n->n%2==0)
				.limit(15);
		
		Stream<String>strStream=namesList.stream();
		
		//uncomment to see run:
		//System.out.println(intStream.collect(Collectors.toList())); //turn our stream of 15 odd numbers into a list
		
		//uncomment to see run:
		//System.out.println(doubleStream.collect(Collectors.toList())); //turn our stream of 15 odd numbers into a list
		
		//---------------------display streams as a treeset:
		
		
		TreeSet<Integer>treeInts=intStream.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(treeInts);
		
		
		//========================================
		
		/*
		 * These (toX) functions take in objects and return primitives
		 * 
		 * averagingDouble (toDoubleFunction f)
		 * averagingInt (toIntFunction f)
		 * averagingLong (toLongFunction f)
		 */
		
		//toDoubleFunction:
		//ALWAYS returns a Double (this one takes a string, and returns a double)
		ToDoubleFunction<String>toDouStr=s->s.length();
		
		//toIntFunction:
		//ALWAYS returns an int. (this one takes a string and returns an int)
		ToIntFunction<String>toIntStr=s->s.length();
		
		
		//------------------
		
		//this is using the toDouble function of averagingDouble to return the average length of the strings in the collected list. 
		double result=namesList.stream().collect(Collectors.averagingDouble(s->s.length()));
		System.out.println(result);
		
		
		//-----------------
		//make 10 dogs equal to these filters, and add to list:
		List<Dog>dogList = Stream.generate(()->new Dog((int)(Math.random()*100), "spot"))
				//.limit(50) 
				.filter(d->d.age>1)
				.filter(d->d.age<15)
				.limit(10)
				//.peek(System.out::println)
				.collect(Collectors.toList());
		
		
		System.out.println(dogList);
		
		//store average age of doglist:
		double averageAge = dogList.stream().collect(Collectors.averagingInt(d->d.age)); 
		
		//--------------------------------
		/*
		 * This is generating our dogs, then getting the average age of the dogs all on the fly.
		 * The dogs created are not assigned to anything so as soon as the work is done, they are liable for garbage collection and cant be accessed.
		 */
		
		double averageAge2 = Stream.generate(()->new Dog((int)(Math.random()*100), "spot"))
		.filter(d->d.age>1)
		.filter(d->d.age<15)
		.limit(10)
		.peek(System.out::println) //this peek is jut showing us that 10 dogs are being produced
		.collect(Collectors.averagingInt(d->d.age));
		
		
		System.out.println("average age of dogs is: " + averageAge2);
		
		//------------------------------
		
		ToIntFunction<Dog>dogToInt=d->d.age;
		

		
	}
	
	
	static void ex4() {
		
		
		//===========================COLLECTIONS & FUNCTIONAL PROGRAMMING using collect (continued)
		
		System.out.println("\nex4()");
		
		
		//COLLECTORS.COUNTING:
		
		/*
		 * Note that you dont know how many numbers are created when you do this: 
		 */
		
		Stream.generate(()->(int)(Math.random()*100))
				.limit(50) //max amount will be 50
				.filter(n->n%4==0)
				.peek(System.out::println)
				.collect(Collectors.counting());
		
	
	}
	
	
	
}
