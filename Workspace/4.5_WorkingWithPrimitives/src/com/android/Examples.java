package com.android;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.android.Widget.Colour;

public class Examples {
	
	
	static void ex1() {
		
		//===========================+++++++++++++++++++++++++
		
		System.out.println("\nex1()");
		
		/*
		 * Streams only work with objects. They do not work with primitives. (you have a stream of Integers, not ints)
		 * HOWEVER, you can use Stream with primitives. As just like in lists, sets, queues:
		 * when you add an int for instance to a srtream of Integers, thart int is autoboxed into an Integer.
		 */
		
		Stream<Integer>stream = Stream.of(23, 45, 67); ///ints are added to the stream, and are autoboxed into Integers in the process 
		
		List<Integer>intList = Arrays.asList(56,999,67); //same process as above
		
		//reduce is a terminal operation (that returns a sum)
		Integer sum = stream.reduce(0, (s,n)->s+n);
		
		System.out.println("sum is: " + sum);
		
		//================================================PRIMITIVE STREAMS:
		
		/*
		 * There are particular streams that can deal with primitives
		 * For primitive ints there is:
		 * IntStream
		 *  
		 * For primitive doubles there is:
		 * DoubleStream
		 *  
		 * For primitive longs there is:
		 * LongStream
		 */
		
		stream = Stream.of(23, 45, 67);
		//System.out.println(stream.max(comparator));
		
		//stream of 3 primitive numbers:
		IntStream intStream = IntStream.of(23,45,67);
		
		//--------------------------------------------------
		//you can call methods on this stream:
		System.out.println(intStream.max()); //this will give an optionalInt, so you need to add "getAsInt()" to retrieve:
		
		intStream = IntStream.of(23,45,67); //intStream needed redefining asmax is a terminal operator, so closes the stream.
		
		System.out.println(intStream.max().getAsInt()); //.max is a TERMINAL operation (so list needs redefined again) that closes the stream and returns an Optional int.
		
		/*
		 * An Optional int is an int that may or may not have a value. 
		 */
		
		Optional<Integer>optInteger; //An optional INTEGER. different from an optional int.
		
		
		//-----------------------------------------------
		//Widgets example. See Widget class.
		
		Widget w1 = new Widget(Colour.BLACK, 10);
		Widget w2 = new Widget(Colour.RED, 5);
		Widget w3 = new Widget(Colour.WHITE, 15);
		Widget w4 = new Widget(Colour.RED, 25);
		
		/*
		 * you CANT directly create an int stream from a list, HOWEVER you can create an intStream fom a stream.
		 * So you can first create a Stream from a list, then use "mapToInt()" to create an intStream.
		 */
		
		List<Widget>widgets=Arrays.asList(w1,w2,w3,w4);
		
		int sum2 = widgets.stream()
                .filter(w -> w.getColour() == Colour.RED)
                .mapToInt(w -> w.getWeight()) //this produces a primitive stream of ints (an intStream)
                .sum(); 

		System.out.println("sum2 is: " + sum2);
		
		/*
		 * mapToInt returns an IntStream which we can then apply all of the methods of the intStream class to it. 
		 * This takes in an Object and returns an int. 
		 */
		
		//---------with normal stream, not converting to intStream:
		
		Integer sum3 = widgets.stream()
				.filter(w->w.getColour() == Colour.RED)
				.map(w->w.getWeight()) //////////////take in one object type and returns another based on declared type (Integer in this case)
				.reduce(0, (s,n)->s+n);
		
		System.out.println("sum3 is: " + sum3);
		
		
		//=======================
		
		//returns 1*2, 2*2...
		Stream<Integer>streamI=Stream.iterate(1, x->x*2).limit(10);
		
		//this is taking in our stream of 10 integers, printing them out, then converting them to a stream of ints, and calling the sum() of the intStrream class on them. 
		System.out.println(streamI.peek(System.out::println).mapToInt(x->x).sum());
		
		
		///=======================
		//All Stream methods are available to intStream: ++++++++++++++++++++++++++++++++++++++++++++++
		
		//using iterate with intStream
		System.out.println(IntStream.iterate(0, x->x+10).peek(System.out::println).limit(10).sum());
		
		
		//===================================
		
		intStream = IntStream.iterate(0, x->x+10).limit(10);
		
		/*
		 * WONT WORK as all collections are a group of OBJECTS , and intStream is a stream of ints NOT Integers. 
		 */
		//List<Integer>nums=intStream.collect(Collectors.toList());
		
		
		
		//================================
		//MAX:
		
		intStream = IntStream.generate(()->(int)(Math.random()*100)+1).limit(10);
	
		System.out.println("max");
		//max retuirns an optional int (which is not a number)
		System.out.println(intStream.peek(System.out::println).max()); //print off all the numbers, then print off the max
		
		
		intStream = IntStream.generate(()->(int)(Math.random()*100)+1).limit(10); //redefine stream
		
		System.out.println("second max:");
		System.out.println(intStream.peek(System.out::println).max().getAsInt()); //getAsInt returns our number
		
		//-------------------
		//SUM:
		
		intStream = IntStream.generate(()->(int)(Math.random()*100)+1).limit(10); //redefine stream
	
		System.out.println(intStream.peek(System.out::println).sum()); 
		
		//---------------------
		//MIN:
			
		intStream = IntStream.generate(()->(int)(Math.random()*100)+1).limit(10); //redefine stream
		
		System.out.println(intStream.peek(System.out::println).min().getAsInt()); //getAsInt returns our number
		
		
		//---------------------
		//AVERAGE:
		
		//This returns an optional DOUBLE, so you need getAsDouble()
			
		intStream = IntStream.generate(()->(int)(Math.random()*100)+1).limit(10); //redefine stream
		
		System.out.println(intStream.peek(System.out::println).average().getAsDouble()); //getAsDouble returns our number (an optional DOUBLE) ++++++++++++++++++
		
		
		///============================================
		//Different option types as per their streams:
		
		OptionalInt optI = IntStream.generate(()->(int)(Math.random()*100)+1).limit(10).max(); //.max() returns an int.
		OptionalDouble optDbl = IntStream.generate(()->(int)(Math.random()*100)+1).limit(10).average(); //average returns a DOUBLE ++++++++++
		OptionalLong optlong;
		
		
		//----------------
		
		//This is getting the average of an empty string:
		optDbl = IntStream.empty().average();
		System.out.println(optDbl);
		
		//gets the max of an empty stream:
		optI = IntStream.empty().max();
		System.out.println(optI);
		
		//gets the min of an empty stream:
		optI = IntStream.empty().min();
		System.out.println(optI);
		
	}
	
	
	
	static void ex2() {
		
		//===========================+++++++++++++++++++++++++
		
		System.out.println("\nex2()");
		
		/*
		 * as already stated there are 3 primitive stream types:
		 * 
		 * IntStream uaed for: int, short, byte and char
		 * LongStream used for the primitive type: long
		 * DoubleStream used for the primitive types: doubles and floats. 
		 */
		
		//creating an empty stream:
		DoubleStream empty = DoubleStream.empty();
		
		/*
		 * As these types of streams can only take primitives, 
		 * (you cant create a IntStream for instance from a liat of Integers, as lists only contain objects not primitives).
		 * However you can create a stream from an array of primitive vars.
		 */
		
		double[]dArray= {3.45,6.78,3.2,102,456};
		
		List<Double>dList=Arrays.asList(3.0,455.4,7.5,78.5,3.2,102.35);
		
	
		//You can create a stream of primitive doubles from an array of primitive doubles:
		DoubleStream dStream = DoubleStream.of(dArray);
		
		//But you CANT create a stream of double primitives from a list of wrapper Doubles:
		//dStream=DoubleStream.of(dList); //WONT COMPILE
		
		//----------
		
		//SUM: - returns a double
		System.out.println("sum of doubles is: " + dStream.sum()); //will return a double
		
		
		//---------
		//AVERAGE: //NEEDS A getAsDouble to return a double ++++++++++++++++++++++++++++++++++++++++++++++++++++++will return an optionalDouble otherwise!! 
		
		dStream = DoubleStream.of(dArray); //reset stream
		
		System.out.println("avg of doubles is: " + dStream.average()); //will return an OptionalDouble
		
		//reserting the stream within the sysout:
		System.out.println("avg of doubles is: " + DoubleStream.of(dArray).average().getAsDouble()); //will return a double
		
		
		//==========================
		
		//System.out.println(DoubleStream.empty().average().getAsDouble()); //will fallover as an empty Stream can use a get method
		
		//workaround:
		OptionalDouble optD = DoubleStream.of(dArray).average();
		optD=DoubleStream.empty().average();
		System.out.println(optD);
		
		//better workaround: ++++++++++++++++++
		//use orElse
		
		System.out.println("optD is: " + optD.orElse(0.0)); //if you use this, your calculations will continue using 0.0 as value
		System.out.println("optD is: " + optD.orElseGet(()->Double.NaN)); //if you use this, no calculations will be performed +++++++++++++++++++++++++++BETTER OPTION!! 
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
