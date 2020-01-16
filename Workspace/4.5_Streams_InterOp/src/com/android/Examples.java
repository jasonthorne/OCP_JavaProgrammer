package com.android;

import java.time.LocalDate;
import java.util.ArrayList;
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
			 * We have overriden the equals method of the Cat class, so those cats with the same age & weight will be said to be the same. 
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
			
			//6 random numbers from 
			List<Integer>lotto = Stream.generate(()->(int)(Math.random()*100)+1).filter(i->i<48).distinct().limit(6).collect(Collectors.toList()); 
			System.out.println("The lotto numbers are: " + lotto);
			
	}
	

}
