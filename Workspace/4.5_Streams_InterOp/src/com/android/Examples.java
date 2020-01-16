package com.android;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
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
		
		//--------------------------------------
		/*
		 * This is creating random dates between 1 and 100 days from today's date. 
		 */
		int num =(int)(Math.random()*100);
		TreeSet<LocalDate>dateStream=Stream.generate(()->LocalDate.now().plusDays((int)(Math.random()*100))).limit(5)
				//save days no more than 20 days in the future to a new treeSet:
				.peek(System.out::println).filter(d->d.isBefore(LocalDate.now().plusDays(20))).collect(Collectors.toCollection(TreeSet::new)); //stick them in  treeSet
		System.out.println("dateSteam is: " + dateStream);

	}
	
	/*
	static int random() {
		return (int)(Math.random()*100);
	}*/
	
	
	static void ex2() {
			
		//===========================DISTINCT=======================

			System.out.println("\nex2()");
			
			/*
			 * Is an intermidiate operation and returns a stream without duplicate values. It uses the equals method to determine what values are equal.
			 * 
			 */
			
			Stream<String>disStr=Stream.of("duck", "duck", "duck", "goose");
			
			//This creates an arrayList of distinct strings:
			List<String>listStr=disStr.distinct().collect(Collectors.toCollection(ArrayList::new));
			
			System.out.println(listStr);
			
			//---------------
			
			
			/*
			 * We have overridden the equals method of the Cat class, so those cats with the same age & weight will be said to be the same. 
			 */
			
			Cat cat1 = new Cat(1, 2);
			Cat cat2 = new Cat(3, 4);
			Cat cat3 = new Cat(3, 4);
			Cat cat4 = cat1;
			
			/*
			 * ONLY two cats are produced as both Cat2 and cat3 have the same age & weight and cat 4 is the same Cat as cat1.
			 */
			Stream.of(cat1,cat2,cat3,cat4).distinct().forEach(System.out::println);
			
			//--------------
			
			//Stream.generate(()->(int)(Math.random()*100)).distinct().forEach(System.out::println);
			
			/*
			 * This will produce 100 random random numbers between 0 - 100 (but not include 100), 
			 * we have said it will be distinct, so this means we will get all possible numbers. 
			 * We then save them in a treeSet, which will organise them in ascending numeric order. 
			*/
			
			List<Integer>test = Stream.generate(()->(int)(Math.random()*100)).distinct().limit(100).sorted().collect(Collectors.toCollection(ArrayList::new));
			System.out.println(test);
			
			//------------------------
			
			//6 random numbers from a pool of numbers 1-47 inclusive
			List<Integer>lotto = Stream.generate(()->(int)(Math.random()*100)+1).filter(i->i<48).distinct().limit(6).collect(Collectors.toList()); 
			System.out.println("The lotto numbers are: " + lotto);
			
	}
	
	
	static void ex3() {
		
		//===========================SKIP=======================

		System.out.println("\nex3()");
		
		/*
		 * This is an intermediate operation that returns a stream and takes an int.
		 * and simply skips that amount of items. 
		 * eg: you have a stream of 10 items, and you go: myStream.skip(5). This will skip the first 5 objects.
		 */
		
		//this is an infinite stream that begins at 2 and increments by 2, so will print out all even numbers. 
		Stream<Integer>intStream = Stream.iterate(2, n->n+2);
		
		//skips first 4 results, then prints out the next 4.
		intStream.skip(4).limit(4).forEach(System.out::println);
		
		//the other way around, it skips the first 4 that it's been limited to, so prints nothing. +++++++++++++++++
		intStream = Stream.iterate(2, n->n+2);
		intStream.limit(4).skip(4).forEach(System.out::println);
		
		
		//------------------
		
		//LIMIT WITH SKIPPING: 
		System.out.println("\nlimit with skipping:");
		intStream = Stream.iterate(2, n->n+2);
		
		//skips first 15, then takes the next 10 numbers and uses only the numbers that are divisible by 10
		intStream.skip(15).limit(10).filter(i->i%10==0).forEach(System.out::println);
		
		//LIMIT AND SKIP SKIP 10 NUMBERS: 
		System.out.println("\nlimit and skip 10 numbers:");
		intStream = Stream.iterate(2, n->n+2);
		
		//skips first 15, then uses only the numbers that are divisible by 10, then limit them to 10 numbers:
		intStream.skip(15).filter(i->i%10==0).limit(10).forEach(System.out::println);
			
	}
	
	
	
	static void ex4() {
		
		//===========================MAP=======================

		System.out.println("\nex4()");
		
		/*
		 * Map translates a stream of a certain type into a stream of another type. (take in a stream of cats output a stream of dogs)
		 * 
		 *returns a Stream of type R. takes a function (which takes an obj of type T and returns an obj of type R)
		 * <R> Stream<R> map(Function<T,R>mapper)
		 * 
		 * i.e we are taking in a stream of Strings and returning a stream of Integers.
		 * R would be the Integer, T would be a String
		 * 		
		 */
		
		List<String>apes=new ArrayList<>();
		apes.addAll(Arrays.asList("monkey", "gorilla", "bonobo", "marmot"));
		
		/*
		 * below takes in a string ("monkey", "gorilla" etc) and returns the length of each string which is an integer. 
		 * So this map method takes in a stream of strings and returns a stream of integers.
		 */
		
		List<Integer>apeInt= apes.stream().map(x->x.length()).collect(Collectors.toList());
		
		System.out.println("apeInt: " + apeInt);
		
		//-------------------------------
		
		/*
		 * This takes in a stream of strings (x) and returns a stream of integers, which will be the hashcode method of each string in the stream. 
		 */
		apeInt=apes.parallelStream().map(x->x.hashCode()).collect(Collectors.toList());
		
		System.out.println("apeInt: " + apeInt);
		
		//-------------------------------
		
		
		apes.stream().map(x->x.concat(" the ape")).forEach(System.out::println);
		
		//-----------------------------
		
		
		//dogs into cats:
		
		Dog dog1 = new Dog(3, 10);
		Dog dog2 = new Dog(3, 10);
		Dog dog3 = new Dog(1,5);
		
		Stream<Dog>dogStream=Stream.of(dog1,dog2,dog3); //stream of dog objs
		
		//This takes a stream of Dogs and produces a stream of cats. The method makeCat in dog creates a cat with the same age and name as the Dog.
		//after the map method you now have a stream of Cats, so every method after map() is now operating on a stream of Cats. 
		
		
		List<Cat>catList=dogStream.map(d->d.makeCat()).distinct().collect(Collectors.toList());
		
		System.out.println(catList);
		
		//-----------
		
		//takes a stream of integers and returns a stream of integers. 
		Stream.generate(()->(int)(Math.random()*1000)+1).map((x)->x.doubleValue()).limit(5).forEach(System.out::println);
		
		
	}
	
	
	
	
	
	static void ex5() {
		
		//===========================FLAT MAP=======================

		System.out.println("\nex5()");
		
		/*
		 * flattening in computing usually means changing from complex to basic. 
		 * Flatmap is usually used to take a number of collection objects or streams and flaten them to one collection object or one steam. 
		 * 
		 * eg: 3 lists of Integers flattened to become one list of Integers. OR 3 TreeSets of Strings flattened to become one TreeSet of Strings.
		 */
		
		List<String>zero=Arrays.asList();
		List<String>one=Arrays.asList("bonobo");
		List<String>two=Arrays.asList("mummy gorilla", "baby gorilla", "boomer", "king kong");
		
		//normally only way to print 3 lists together:
		System.out.println(zero + " "  + one + " " + two);
		
		//very easy to create a stream from a single list:
		two.parallelStream().forEach(System.out::println);
		
		//this produces NOT a stream of strings, but a stream of LISTS of strings, so any operation on this stream after this point is operating on a stream of lists. 
		Stream.of(zero,one,two).collect(Collectors.toList());
		
		/*
		 * What flatmap does is puts all the strings into one stream of strings. So it flattens out the lists of strings.
		 */
		
		// s is a list of strings, and it produces a stream of strings , made from all of the string lists passed into it
		Stream.of(zero,one,two).flatMap(l->l.stream()).peek((s)->System.out.println("ape is "+ s)).filter(s->s.startsWith("b")).forEach(System.out::println);
		
		//----------------
		
		Stream
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
