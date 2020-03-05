package com.android;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collector;
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
		
		/*
		 * The forEach ordered is a terminal operation that only allows 1 thread to access the stream at a time, so it becomes in effect a single threaded stream.
		 * This leads to a loss of performance you may have gained by using the parallel stream operation.
		 */
		
		list.parallelStream().sorted().peek((i)->System.out.print("Thread count is: " + Thread.activeCount())).forEachOrdered((i)->System.out.print(i + ","));
		
	}
	
	
	
	static void ex3() {
		
		System.out.println("\nex3");
	
		//Single VS parallel stream:================================understanding performance improvements 
		
		/*
		 * We are processing 500_000_00 numbers. We will do this processing using a single threaded stream, 
		 * and we will also do the same with a multi-threaded stream (parallel stream)
		 */
		
		//List<Long>list=Stream.generate(()->((long)(Math.random()*100)+1)).limit(600_000_000).parallel()
		
		List<Long>list=Stream.generate(()->((long)(Math.random()*100)+1)).limit(600).collect(Collectors.toList()); //original limit: .limit(600_000_000)
		
		System.out.println("time b4 stream: " + LocalTime.now());
		
		//single threaded stream: 
		
		list.stream().forEach((n)->{
			n++;
		});
		
		System.out.println("after stream: " + LocalTime.now());
		
		//-------
		//multi-threaded stream: 
		
		/*
		 * This stream is 7 times faster because its a parallel stream. and you have multiple threads operating on the steam at the same time.
		 */
		
		System.out.println("time b4 parallel: " + LocalTime.now()); 
		
		list.parallelStream().forEach((n)->{
			n++;
		});
		
		System.out.println("after parallel: " + LocalTime.now());
		
		//---------------
		
		System.out.println("time b4: " + LocalTime.now());
		
		
		
	}
	
	
	
	static void ex4() {
		
		System.out.println("\nex4");
	
		//Understanding performance improvements 2:================================
		
		Examples ex1 = new Examples();
		
		List<Integer>data=Stream.iterate(0, i->i+1).limit(4000).collect(Collectors.toList());
		
		System.out.println(data.size()); //400
		
		System.out.println(data); //0 - 3999
		
		long start = System.currentTimeMillis(); //amount of time since the first millisecond on 01-01-1970
		
		/*
		 * The only difference with this is this method uses a parallel stream, and the time taken to do this work is approximately 5 seconds. 
		 * As we have 4 threads in operation, it seems that all the threads are being used by parallel stream.
		 */
		
		ex1.processAllData(data); //send array of 4000 numbers into the method
		double finish = System.currentTimeMillis()-start;
		
		System.out.println("This has taken: " + finish + " millis");
		System.out.println("This has taken: " + finish/1000 + " seconds");
		
		System.out.println("amount of threads in operation: " + Thread.activeCount()); //1 thread in operation
	
	}
	
	
	static void ex5() {
		
		System.out.println("\nex5");
		
		//Understanding performance improvements 2:================================
		
		Examples ex1 = new Examples();
		
		List<Integer>data=Stream.iterate(0, i->i+1).limit(4000).collect(Collectors.toList());
		
		System.out.println(data.size()); //400
		
		System.out.println(data); //0 - 3999
		
		long start = System.currentTimeMillis(); //amount of time since the first millisecond on 01-01-1970
		
		ex1.processAllDataPar(data); //send array of 4000 numbers into the method
		double finish = System.currentTimeMillis()-start;
		
		System.out.println("This has taken: " + finish + " millis");
		System.out.println("This has taken: " + finish/1000 + " seconds");
		
		System.out.println("amount of threads in operation: " + Thread.activeCount()); //4 threads in operation
	
	
	}
	
	
	
	/*
	 * We will send our list to this method which contains our numbers:
	 */
	public void processAllData(List<Integer>data) {
		
		/*
		 * For each number, the thread that is dealing with the number will sleep for 5 millisecs. 
		 * As this is a single threaded stream, a stream will sleep, then perform the operation,
		 * and will do this 400 times as we have 4000 numbers.
		 * 
		 * This takes approximately 22 seconds. 
		 */
		
		System.out.println(data.stream().map((i)->processRecord(i)).count());
		
	}
	
	public int processRecord(int input) {
		
		try {
			/*
			 * each thread will sleep for 5 millis, so if single threaded, it goes sleep > process number > sleep all one after the other. 
			 * However if its multi-threaded, you have 4 threads, so 4 threads go to sleep at the same time, wake up at the same time, and process 16 numbers at the same time. 
			 * Then goes to next 16 numbers. 
			 * So in the time it takes 1 thread to process one number, a multi threaded application could have 16 numbers processed. 
			 */
			Thread.sleep(5); //put thread to sleep for 5 millisecs
		}
		catch(Exception e) { System.out.println("uh oh!"); }
		
		return input -1;
	}
	
	
	//PARALLEL stream: 
	public void processAllDataPar(List<Integer>data) {
		
		/*
		 * This takes approximately 5 seconds.
		 * The more CPUs you have, the better the performance. 
		 * SCALING is the property.
		 * as we add more resources the results gradually improve.
		 * Improvements in performance using parallel streams are often only noticeable when using streams with large amounts of elements 
		 * or when processing complex tasks. 
		 * For small streams the improvements are often limited as there are some overhead costs to allocating and setting up parallel processing.
		 */
		
		System.out.println(data.parallelStream().map((i)->processRecord(i)).count());
		
	}
	
	
	
	static void ex6() {
		
		System.out.println("\nex6");
		
		//Understanding independent operations:================================
		
		/*
		 * The results of ani ndependent operation of stream should not impact the results of another element of the stream. 
		 */
		
		List<String>animals = new ArrayList<>(Arrays.asList("Baboon", "Chimpanzee", "Anteater", "Giraffe", "Elephant"));
		
		/*
		 * You are not guarenteed any order when using parallel streams, so all strings could be acted upon at the same time. 
		 * Each of these strings are totally independent of each other. They are not dependent on each other.  
		 */
		
		animals.parallelStream().map(s->s.toUpperCase()).forEach(System.out::println);
		
		System.out.println("Thread amount is: " + Thread.activeCount());
		
		//===================
		System.out.println();
		//second print:
		
		/*
		 * As these are parallel streams, you have no order, so you oculd have uppercase printing before lowrcase and vise versa,
		 * in no particular order.
		 */
		
		
		animals.parallelStream()
		.map((s)->{
			System.out.println(s); //print the lowercase versions
			return s.toUpperCase();
		})
		.forEach(System.out::println); //print the uppercase version
		
	
	}
	
	
	static List<Integer>intList=new ArrayList<>();
	
	static void ex7() {
		
		System.out.println("\nex7");
		
		//Understanding independent operations:================================
		
		/*
		 * We wish to avoid STATEFUL LAMBDA EXPRESSION
		 * This is where one of the results in your stream depends on the result of another element in the stream. 
		 * 
		 * A STATELESS LAMBDA EXPRESION is where a result doesn NOT depend on any state that may change uring execurtion of a pipeline.
		 */
		
		
		
		//NON recommended weay: 
		
		Stream.iterate(1, i->i*2).limit(12).forEach((i)->{
			intList.add(i);
		});
		
		System.out.println(intList);
		
		//--------
		//recommended way: 
		
		intList=Stream.iterate(1, i->i*2).limit(12).collect(Collectors.toList());
		
		System.out.println(intList);
		
		//-------
		
		intList.clear();
		
		Stream.iterate(1, i->i*2).limit(12).parallel().forEach((i)->{
			intList.add(i);
		});
		
		System.out.println(intList); //order is unpredicatable as parallel changes the stream to be a parallel stream.
		
		
		//-------
		
		//Using Collects.toList() guarantees correct order when collecting with a parallel stream:
		
		intList.clear();
		
		intList = Stream.iterate(1, i->i*2).limit(12).parallel().collect(Collectors.toList());
		
		System.out.println(intList); 
		
		
		//=========
		
		/*
		 * This is a threadsafe arraylist so you effectively lose the benefits of parallel streams, when you use this collection object.
		 */
		
		
		//using synchronized list with parallel streams: ========================
		
		//AVOIDING STATEFUL LAMBDA EXPRESSIONS ++++++++++++++++++++++++++++++++++++++++++++
		
		
		List<Integer>data=Collections.synchronizedList(new ArrayList<>());
		
		List<Integer>numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		
		/*
		 * With a parallel stream and a synchronized list you are guaranteed that all the numbers will be entered, but NOT the order. 
		 */
		
		/*
		 * The values entered in the data synchreonized list depend on what value i is at a position in the numbers list. ie:
		 * 1st element is 1, 2nd is 2 etc..
		 * What number is entered into data list is dependent on the state of the numbers list. 
		 * As its a parallel stream you can never know for sure which of the 6 numbers it will be. As all numbers process at the same time. 
		 * REMOVE statefull operations when using parallel streams and also if possible for serial streams.
		 */
		
		numbers.parallelStream().map((i)->{
			
			/*
			 *whats added below depends on what element is being targeted. BUT the same element could be being targeted by multiple threads
			 * If more than 1 thread is trying to add an element to the data list then ONLY ONE will be picked, and the other will be lost.
			 */
				data.add(i); //STATEFULL LAMBDA EXPRESSION 
				return i;
			}).forEachOrdered(i->System.out.print(i + ", " ));
		
		
		System.out.println();
		System.out.println(data);
		
		
		
		//using a NON synchronized list with parallel streams: ========================
		
		
		List<Integer>data2 = new ArrayList<>();
		
		/*
		 * We are using a NON synchronized collection type arraylist. Results CAN be lost.
		 * As we can see forEachOrdered() always produces 6 numbers. However the issue is with the stateful lambda expression data.add(i)
		 * AS when using an arraylist, the JVM manages a primitive array of the same size as the elements are added to the arraylist in the background is increased in size,
		 * but if the elements are added to the same position at the same time, only one will be added and other lost.
		 * 
		 */
		
		numbers.parallelStream().map((i)->{
			data2.add(i); //STATEFULL LAMBDA EXPRESSION - this might add any amount of numbers. The key her is that it's not predictable how many numbers will be added at any time.
			return i;
		}).forEachOrdered(i->System.out.print(i + ", " ));
		
		System.out.println();
		System.out.println(data2);
		
	}
	
	
	
	static void ex8() {
		
		System.out.println("\nex8");
		
		//Reductions with parallel streams:================================
		
		/*
		 * Reductions are combining contents of a stream into a single object. 
		 * However parallel reductions can be different. to what you expect the with serial streams.
		 * 
		 */
		
		List<Integer>numbers = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
		
		
		//this returns an OPTIONAL of type Integer: Optional<Integer>optInt; so we need to use the get() method of the optional class to get the value
		//if there are any numbers in this stream it will get the first number in the stream.
		System.out.println(numbers.stream().findAny().get());
		
		/*
		 * In theory as this is a parallel stream, any number can be returned: 
		 */
		System.out.println(numbers.parallelStream().findAny().get());
		
		/*
		 * In theory as this is a parallel stream, any number can be returned: 
		 */
		System.out.println(numbers.parallelStream().findFirst().get());
		
		
		/*
		 * Any stream operation that is based on a parallel stream such as findFirst(), limit(), skip() etc
		 * do operate and produce the same results as would be produced from  srial stream. 
		 * These operations may perform more slowly as you are forcing something that is implementing parallel processing to behave in a single threaded manner.
		 */
		
		//using skip:
		numbers.parallelStream().skip(2).forEach(System.out::println);
		
		
		//using limit:
		numbers.parallelStream().limit(3).forEach(System.out::println);
		
		
		
		//===============================
		
		//unordered Streams:
		
		List<Integer>data=Stream.iterate(1, i -> i+1).limit(4000).collect(Collectors.toList());
	
		Examples ex1 = new Examples();
		long start = System.currentTimeMillis();
		
		ex1.processAllData3(data);
		double finish = System.currentTimeMillis() - start;
		System.out.println("task completed in: " + finish + " millis");
		
		System.out.println("task completed in: " + finish/1000 + " seconds");
		
		
	}
	
	public void processAllData3(List<Integer>data) {
		
		//unordered makes the stream ALYWAYS act as a parallel stream (regardless of things like skip() being used within it)
		data.parallelStream().unordered().map(a->processRecord3(a)).count(); 
		
		//ORDERED version: (slower)
		//data.parallelStream().unordered().map(a->processRecord3(a)).count(); 
		
	}
	
	public int processRecord3(int input) {
		try {
			Thread.sleep(10);
		}catch(InterruptedException e) {
			
		}return input -1;
	}
	
	
	
	static void ex9() {
		
		System.out.println("\nex9");
		
		//REDUCE WITH PARALLEL STREAMS================================
		
		/*
		 * reduce is a stream terminal operation that reduces our stream of objects to ANY object we want. 
		 * (take in a group of animals, and return a farm object)
		 * With parallel streams we have really only two effective overloaded methods.
		 */
		
		/**
		 * Reduce() combines a Stream into a single object.
		 * IDENTITY - What you start with (could be the number to start the calculation, or the object you want all of the
		 * elements of the stream to produce.  (i.e a zoo object could be produced from a stream of Animals, so the identity would be a Zoo object)
		 * ACCUMULATOR - What you want to do with pairs of elements in the stream. In this case its a stream of Integers
		 * and we want to add the numbers in pairs. Takes a BiFunction which takes 2 args and returns one object.
		 * COMBINER - This is what we wish to do with all of the items produced by the accumulator.
		 * The accumulator produces numbers that are the product of two of the numbers added up (i.e: 1+0,2+3,4+5,+6)
		 * Here we wish to add up all of the products (1+5+9+6) = 21.
		 */
		
		List<Integer>numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		
		System.out.println("max is: " + numbers.parallelStream().max((a,b)->a-b)); //find max from list
		
		//---
		
		//Note that the last 2 args are BIFUNCTIONS +++++
		int sum = numbers.parallelStream()
				.reduce(0, //IDENTITY - the starting point for our reduction (if we wanted to add animals to our zoo, this would be 'new Zoo()')
						(a, b)->a+b, //ACCUMULATOR - this has to be ASSOCIATIVE and stateless, otherwise You will not get the right answer. 
						(c,d)->c+d); //COMBINER takes the results from the accumulator and does something to these elements. in this case, adds them up.
		
		System.out.println("sum of list: " + sum);
		
		//------
		//Serial stream reduce subtraction:
		
		/*
		 * Accumulator has to be a STATELESS lambda expression and has to be ASSCOCIATIVE.
		 */
	
		sum = numbers.stream().reduce(0, (a,b)->a-b, (c,d)->c-d); //minusing all elements  (starting at 0)
		System.out.println("sum of list using single (therefore, ordered) stream: " + sum); //gives RIGHT answer (-21)
		
		
		sum = numbers.parallelStream().reduce(0, 
				(a,b)->a-b, 
				(c,d)->c-d); //minusing all elements  (starting at 0)
		System.out.println("sum of list using parallel (therefore targeted in ANY order) streams: " + sum);  //gives WRONG answer (3)
		
		List<String>test = new ArrayList<String>();
		test.add("w");
		test.add("o");
		test.add("l");
		test.add("f");
		
		System.out.println(test.parallelStream().reduce("", (c, s1)-> c+s1, (s2,s3)->s2+s3));
		
		
		System.out.println(Arrays.asList('w', 'o', 'l', 'f').parallelStream().reduce("", (c, s1)-> c+s1, (s2,s3)->s2+s3));
		
		System.out.println(Arrays.asList(3, 2, 1, 4).parallelStream().reduce(0, (c, s1)-> c+s1, (s2,s3)->s2+s3));
		
		//======================
		
		System.out.println(test.stream().reduce("x", (a,b)->a+b));
		
		System.out.println(test.parallelStream().reduce("x", (a,b)->a+b)); //WONT WORK WITH PARALLEL STREAMS (xwxoxlxf) ++++++++
		
		System.out.println(test.parallelStream().reduce("", (a,b)->a+b, (c,d)->c+d)); //WONT WORK WITH PARALLEL STREAMS (xwxoxlxf) ++++++++
		
	}
	
	
	static void ex10() {
		
		System.out.println("\nex10");
		
		//COMBINING RESULT WITH COLLECT================================
		
		/*
		 * It is advisable to use he three arg collect method when using with parallel stream.
		 * By having the .parallel stream operation, this makes this a parallel stream
		 */
		
		Stream<String>stream=Stream.of("w", "o", "l", "f").parallel();
		
		//-----
		/*
		 * Collect takes 3 args:
		 * + Supplier - the object you will save the stream values to.
		 * in this case a thread safe treeSet
		 * + Accumulator - BiFunction  - takes 2 args and does something with these elements.
		 * in this case takes a set and a string and adds the string to the set.
		 * +Combiner - for combining all the strings to one set. 
		 * 
		 */
		
		
		/*
		 * This organises letters in alphabetical order.#So this becomes: f,l,o,w
		 */
		
		/*
		 * This is recommended mwthod for use with parallel streams.
		 * As this is specifically designed for parallel streams. +++++++++++++++++++++
		 */
		SortedSet<String> set = stream.collect(
				()->new ConcurrentSkipListSet<>(), 
				(sortedSet, str)->sortedSet.add(str), 
				(sortedSet,str)->sortedSet.addAll(str));
		
		System.out.println(set);
	
	}
	
	
	static void ex11() {
		
		System.out.println("\nex11");
		
		//USING THE 1 ARG COLLECT METHOD:================================
		
		List<String>list = new ArrayList<String>(Arrays.asList("w", "o", "l", "f"));
		
		HashSet<String>set1 = list.parallelStream().collect(Collectors.toCollection(()->new HashSet<>())); //HashSet DOESNT organise
		
		TreeSet<String>set2 = list.parallelStream().collect(Collectors.toCollection(()->new TreeSet<>())); //treeSet organises alphabetically
		
		System.out.println(set1); //[Unknown order!]
		System.out.println(set2); //[f, l, o, w]
		
		
		//-------------
		
		List<String>list2 = list.parallelStream().collect(Collectors.toList());
		System.out.println(list2);
		
	}
	
	static void ex12() {
		
		System.out.println("\nex12");
		
		List<String>animals = new ArrayList<>(Arrays.asList("lions", "tigers", "lepords", "wolves", "sharks"));
		System.out.println("list of animals: " + animals);
		
		/*
		 * ConcurrentMap is a THREAD SAFE map.
		 * Takes a Function, which will be the key,
		 * Takes a Function which will be A value.
		 * and a binary operator, which takes 2 args and returns one object, this is the final acumulated value of all elements that are requal to k.length() 
		 */
		
		ConcurrentMap<Integer, String>map = animals
				.parallelStream()
				.collect(Collectors.toConcurrentMap(k->k.length(), v->v, (v1, v2)->v1+ "," + v2));
		
		System.out.println(map);
		
		//-------------
		
		
		
		
		
	
	}
	
	
}
