package com.android;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
		
		IntStream intStream = IntStream.of(23,45,67);
		//you can call methods on this stream:
		System.out.println(intStream.max().getAsInt()); //.max is a terminal operation, so list needs redefined again. 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
