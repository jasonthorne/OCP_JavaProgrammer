package com.android;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Set;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
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
		 * (you cant create a IntStream for instance from a list of Integers, as lists only contain objects not primitives).
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
		//AVERAGE: //NEEDS A getAsDouble to return a double +++++++++++++will return an optionalDouble otherwise!! 
		
		//AVERAGE WILL ALWAYS RETURN AN OPTIONAL DOUBLE +++++++++++++(so needs getDouble())
		
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
		
		//-------------------------
		
		//this time it has a value:
		
		optD=DoubleStream.of(dArray).average();
		
		//these will work as this time optD is valid
		System.out.println("optD is: " + optD.orElse(0.0)); //if you use this, your calculations will continue using 0.0 as value
		System.out.println("optD is: " + optD.orElseGet(()->Double.NaN)); //if you use this, no calculations will be performed +++++++++++++++++++++++++++BETTER OPTION!! 
		
		
		//================================================================================
		
		//stream of doubles:
		
		/*
		 * streams that use primitives can also use iterate and generate. And just like in other streams, can produce infinite streams. 
		 */
		
		//this would produce an infinite amount of primitive doubles:
		DoubleStream randomDs = DoubleStream.generate(()->Math.random());
		
		randomDs.limit(5).forEach(System.out::println); //cteate 5 random doubles from stream
		
		//------------------
		
		/*
		 * You can also use iterate
		 * iterate takes sa seed and a unary operator
		 * seed will be an double and the unary operator will take a double and return an int.
		 */
		
		///---------
		System.out.println("\nfractions:");
		
		DoubleStream fractions = DoubleStream.iterate(0.5, d->d/2).limit(4);
		
		System.out.println(fractions.peek(System.out::println).sum());
		
		
		//----------
		System.out.println("\nmultiples:");
		
		double dNum = 2;
		DoubleStream.iterate(dNum, d->d*2).limit(10).forEach(System.out::println);
		
		
		//========================
		//15 random doubles
		
		
		DoubleStream.generate(()->Math.random()).limit(15).forEach(System.out::println);
		
		System.out.println("generating 5 random numbers between the numbers 3 & 30 (not including 3 & 30)");
		
		IntStream.generate(()->{
			int num = (int)(Math.random()*100);
			while(num<4 || num>31)
				num=(int)(Math.random()*100);
			return num;
		}).distinct().limit(5).forEach(System.out::println);
		
		
		
		//=============================
		
		//Range:
		
		/*
		 * range takes an int which is the number we start from and will be included, and takes a second int, the number we go up to but do not include.
		 */
		System.out.println("using range to print 4-29");
		IntStream.range(4, 30).peek(System.out::println).sum(); 
		
		
		//-------
		//Range closed:
		
		/*
		 * the opposite to range - BOTH the start and end are included
		 */
		
		System.out.println("\nusing rangeClosed to print 4-30:");
		IntStream.rangeClosed(4, 30).peek(System.out::println).sum();
		
		//================================================================
		
		//change a stream to a primitive stream:
		
		Stream<String>strStream=Stream.of("penguin", "seal", "whale", "dog", "fish", "shark");
		
		//get the length of each string (by using mapToInt to turn to an int stream) then .average closes the stream and .getAsDouble returns the result as an optional double.
		System.out.println(strStream.peek(System.out::println).mapToInt(x->x.length()).peek(System.out::println).average().getAsDouble());
		
		
		//==========================
		
		
		//generate a  list of 15 random numbers:
		List<Integer>numbers = Stream.generate(()->(int)(Math.random()*100))
				.distinct()
				.filter(x -> x%2 ==0) //makes all numbers even
				.limit(15)
				.collect(Collectors.toList());
		
		/*
		 * You CANT creat an intStream from a collection object (list, set or a qeue),
		 * however you can first create a stream from a collection object, 
		 * then use one of the mappers to create your intStream, doubleStream or longStream.
		 * In this case we take our numbers list of Integers and create a stream, then we use MAPTOINT to create an intStream from this stream.
		 * Then we can use all of the methods of the intStream class. 
		 */
		
		numbers.stream().mapToInt(x ->x).peek(System.out::println).sum();
		
		System.out.println(numbers);
		
		//=====================================================================
		//CONVERTING FROM INTSTREAM TO STREAM OF INTEGERS - mapToObj()	++++++++++++++++++++++++++++++++++++++
		
		//produce odd numbers between 3 & 20:
		IntStream ranges = IntStream.rangeClosed(3, 20).filter(x -> x%2 ==1);
		
		//converting from intSTream to Stream of Integers
		//take in the ints from the intStream and change them to Integer:
		ranges.mapToObj(x -> x) //this produces a sytream of Integers
		.peek(System.out::println)
		.collect(Collectors.toList()); //add integers to list
		
		
	}
	
	
	
	static void ex3() {
		
		//===========================USING OPTIONALS WITH PRIMITIVE STREAMS+++++++++++++++++++++++++
		
		System.out.println("\nex3()");
		
		/*
		 * This is an optional for Objects. We have to give the optional a type. If we dont it will be an optional of type object:
		 */
		Optional<Double>optDouble = Optional.of(3.45);
		
	
		/*
		 * this is an optional of type object:
		 * If you dont supply a type, your optional will be of type object. 
		 */
		Optional optNoType = Optional.of(3.45);
		
		
		System.out.println(optDouble);
		System.out.println(optDouble.get()); //to GET the value of the optional
		
		optDouble = Optional.empty(); //empty the optional of it's value
		
		//System.out.println(optDouble); //gives an exception as a result of having no value++++++++++++
		
		System.out.println(optDouble.orElse(0.0)); //if it doesnt have a number, give it a number
		
		System.out.println(optDouble.orElseGet(()-> Double.NaN)); //mark it as NaN if no value ++++++++++
		
		
		//------------------------------------------------------
		
		//OPTIONALDOUBLE:
		
		//produces a stream of numbers divisible by 15 and between 10 & 100:
		IntStream stream = IntStream.rangeClosed(10, 100).filter(n->n%15==0);
		
		/*
		 * average returns an optionalDouble. 
		 * THis is a DIFFERENT data type to optional of type Double (Optional<Double> - which is for wrapper double objects). 
		 * OptionalDouble is for primitive doubles.
		 */
		
		//OptionalDouble:
		//average is a terminal operation which closes the stream.
		OptionalDouble optDbl = stream.peek(System.out::println).average();
		
		 //The stream is closed, but you can call of the methods of the OptionalDouble class on the variable optDbl:
		
		System.out.println(optDbl);
		System.out.println(optDbl.getAsDouble());
		System.out.println(optDbl.orElse(Double.NaN));
		
		
		//------------------------------------------------------
		
		//OptionalLong:
		
		LongStream longs = LongStream.rangeClosed(1,30).filter(l -> l%3==0);
		
		OptionalLong optLong = longs.max(); //this is a terminal operation, so you cant perform any more operations on this stream (lie example below). 
		
		//longs.min(); //generates an illegalStateException
	
		System.out.println(optLong);
		System.out.println(optLong.getAsLong());
		System.out.println(optLong.orElse(333));
		System.out.println(optLong.orElseGet(()->(long)Math.random()));
		
		/*
		 * Just like an ordinary stream, a LongStream, IntStream or DoubleStream can produce infinite streams ++++++++++++++++++++++++++++++++++
		 */
		
		System.out.println(Math.PI);
		
		DoubleStream doubles = DoubleStream.generate(()->Math.PI);
		
		/*
		 * This will produce an infinite stream of the number: 3.141592653589793
		 */
		doubles.forEach(System.out::println);


	}
	
	
	
	static void ex4() {
		
		//===========================SUMMARY STATISTICS+++++++++++++++++++++++++
		
		System.out.println("\nex4()");
		
		//10 multiples of 85:
		IntStream ints = IntStream.rangeClosed(1,1000).filter(i->i%85==0).limit(10);
		
		//getting the max of our range: (BUT THIS IS A TERMINAL OPERATION, so it closes the stream, so you can do no more operations (Terminal or intermediate) on this stream)
		System.out.println(ints.max().getAsInt());
		
		//System.out.println(ints.max().getAsInt()); //cant be done as stream was closed.
		
		/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * We can use SUMMARY STATISTICS to perform max, min, average, sum & getCount, and these are NOT methods of the stream class, but a seperate class entirely.
		 * 
		 * IntSummaryStatistics for IntStream
		 * DoubleSummaryStatistics for DoubleStream
		 * LongSummaryStatistics for LongStream
		 */
		
		//reset ints Stream:
		ints = IntStream.rangeClosed(1,1000).filter(i->i%85==0).limit(10);
		
		//create a seperate IntSummaryStatistics obj:
		
		IntSummaryStatistics statInts = ints.summaryStatistics(); //.summaryStatistics() is itself a terminal opperation, so no more opperations can be used on the intsStream.
		
		
		System.out.println("count of ints is: " + statInts.getCount());
		System.out.println("max of ints is: " + statInts.getMax());
		System.out.println("min of ints is: " + statInts.getMin());
		System.out.println("average of ints is: " + statInts.getAverage());
		System.out.println("sum of ints is: " + statInts.getSum());
		System.out.println("class of objects in the stream: " + statInts.getClass());
		
		//--------------------------
		//other types of summaryStatistics:
		
		//DoubleSummaryStatistics obj holding 15 random numbers limited to 15. 
		DoubleSummaryStatistics statDoubles = DoubleStream.generate(()->Math.random()).limit(15).summaryStatistics();
		
		System.out.println("\ncount of doubles is: " + statDoubles.getCount());
		System.out.println("max of doubles is: " + statDoubles.getMax());
		System.out.println("min of doubles is: " + statDoubles.getMin());
		System.out.println("average of doubles is: " + statDoubles.getAverage());
		System.out.println("sum of doubles is: " + statDoubles.getSum());
		System.out.println("class of objects in the stream: " + statDoubles.getClass());
		
		LongSummaryStatistics statLong;
		
	}
	
	
	static void ex5() {
		
		//===========================BOOLEAN SUPPLIER FUNCTIONAL INTERFACE++++++++++++++++++++++++
		
		System.out.println("\nex5()");
		
		//BOOLEAN SUPPLIER:
		
		//A supplier takes in nothing, and returns an object.
		
		/*
		 * A Boolean supplier is a functionl interface that is a specialist SUPPLIER that takes in no params and returns a primitive boolean. 
		 * The method inside the functional interface is getAsBoolean.
		 */
		
		BooleanSupplier b1 = ()->true;
		BooleanSupplier b2 = ()->false;
		
		BooleanSupplier b3 = ()->(int)(Math.random()*10)>5;
		
		BooleanSupplier b4 = ()->{
			boolean bool = (int)(Math.random()*10)>5;
			if(bool)
				System.out.println("number greater than 5");
			else
				System.out.println("number less than 5");
			return bool;
		};
		
		
		//System.out.println(b1); //this just prints off the address
		System.out.println(b4.getAsBoolean()); //this will run the code inside b4
		System.out.println(b1.getAsBoolean());

		
	}
	
	
	
	static void ex6() {
		
		//===========================FUNCTIONAL INTERFACES FOR DOUBLE INT & LONG ++++++++++++++++++++++++
		
		System.out.println("\nex6()");
		
		/*
		 * will do examples for primitive doubles and the exact same applies to int and long. 
		 * Except rthe name will begin with "int" or "long". ie:
		 *  doubleConsume is a consumer for a primitive double
		 *  intConsume is a consumer for a primitive int
		 *  longConsume is a consumer for a primitive long
		 */
		
		//SUPPLIERS - takes nothing and returns an object:
		
		
		Supplier<Double> sup = ()->Math.random();
		
		/*
		 * You do not have to specify a type as double supplier is returning a primitive double no matter what. 
		 * Also types<> can ONLY BE objects and a primitive double is NOT an object.
		 * These are suppliers for primitives:
		 */
		
		DoubleSupplier doubleSup = ()->Math.random();
		
		//The method for the doubleSupplier is "getAsDouble()"
		//getAsDouble is the abstract method - double getAsDouble()
		System.out.println(doubleSup.getAsDouble());
		
		//intSupplier example:
		IntSupplier intSup = ()->(int)(Math.random()*100);
		System.out.println(intSup.getAsInt());
		
		
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		//CONSUMER: - Takes in an object and returns void.
		
		/*
		DoubleConsumer takes in a primitive double and returns void.
		intConsumer takes in a primitive int and returns void.
		longConsumer takes in a primitive long and returns void.
		
		The method is "accept"
		
		void accept(double d)
		
		No generics needed as the DoubleConsumer always returns a primitive double
		*/
		
		DoubleConsumer doubleConsumer = (d)->System.out.println("number is: " + d);
		doubleConsumer = System.out::println;
		
		doubleConsumer.accept(3.45);
		//---------------------------
		
		int localInt = 78;
		int changeInt = 45;
		changeInt = 78;
		String name = "yo";
		
		/*
		 * The only variable you CANT access inside a functional interface is a local variable that is not effectively final:
		 */
		IntConsumer intConsumer = (i)->{
			System.out.println("age inside variable is:" + weight); //can acces weight as its static 
			System.out.println("localInt is a a local effectively final variable:" + localInt); //can acces weight as its static 
			//System.out.println("cant access local variables that are not effectively final:" + changeInt); //cant acess weight as its NOT effectively final
		};
		
		intConsumer.accept(56);
		
		
		

		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		//PREDICATE: - Takes in an object and returns a boolean primitive.
		
		/*
		 * DoublePredicate takes a primitive double and returns a boolean
		 * IntPredicate takes a primitive int and returns a boolean
		 * LongPredicate takes a primitive long and returns a boolean
		 * 
		 * Relatively simple functional interface that teats a long, int and double
		 * 
		 * We do not have to define a generic type as this will always take a primitive double, and always return a boolean.
		 */
		
		
		DoublePredicate doublePred = (d)->d>0.5;
		double dNum = Math.random();

		System.out.println(doublePred.test(dNum));
		
		
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		//FUNCTION: - Takes in an object and returns a boolean primitive.
		
		/*
		 * function takes an object and returns an object. Can be the same type or different.
		 * DoubleFunction takes a Double and returns an object.
		 * LongFunction takes a Long and returns an object.
		 * IntFunction takes an Int and returns an object.
		 * 
		 * uses apply:
		 * 
		 */
		
		//Takes in a double and returns an Integer (Determined by generic type +++++++++)
		DoubleFunction<Integer>doubleFunc = d->(int)(d*2);
		
		//Takes an int and returns a String
		IntFunction<String>intFunc = i->i+"";
		
		//takes in a double of type d, and returns a stringBuilder obj with a d string inside it
		DoubleFunction<StringBuilder>doubleFunct2 = d -> new StringBuilder(d+"");
		
		System.out.println(doubleFunct2.apply(2.34).getClass().getSimpleName());
		
		
		
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		//UNARY OPERATOR: - Primitive equivalent of unary operator for primitive ints, primitive doubles and primitive longs.  
		
		/*
		 * Ordinary unary operator takes in an object and returns an object of the same type. 
		 * 
		 * DoubleUnaryOperator takes in a Double and returns a Double.
		 * LongUnaryOperator takes a Long and returns a Long.
		 * IntUnaryOperator takes an Int and returns an Int.
		 */
		
		DoubleUnaryOperator doubleUn = (d)->d*2;
		System.out.println(doubleUn.applyAsDouble(4.5));
		
		IntUnaryOperator intUn = (i -> i*10);
		System.out.println(intUn.applyAsInt(123));
		
		
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		//BINARY OPERATOR: - Primitive equivillent of binary operator for primitive ints, primitive doubles and primitive longs.  
		
		/*
		 * Ordinary binary operator takes in2 objects of the same type and returns 1 object of the same type.  
		 * 
		 * DoubleBinaryOperator takes in 2 Doubles and returns a Double.
		 * LongBinaryOperator takes 2 Longs and returns a Long.
		 * IntBinaryOperator takes 2 Ints and returns an Int.
		 */
		
		DoubleBinaryOperator doubleBinar = (d1, d2)->d1*d2;
		System.out.println(doubleBinar.applyAsDouble(4.5, 3.3));
		
		
		IntBinaryOperator intBinar = (i1, i2)->i1*i2;
		System.out.println(intBinar.applyAsInt(3, 3));
		
		
		/* //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * There is no bifunction equivalent for doubles, ints and longs.
		 * 
		 * There is no biPredicate equivalent for double,s ints and longs.
		 * 
		 * * There is no biconsumer equivalent for doubles, ints and longs.
		 */
		
		
		/*
		 * There are:
		 * Supplier, 
		 * Consumer,
		 * Predicate,
		 * Function
		 * Binary
		 */
		
		
	}
	
	int age = 34;
	static int weight = 5;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
