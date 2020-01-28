package com.android;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
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
		
		
		//=======================================COLLECTORS.COUNTING:
		
		/*
		 * Note that you dont know how many numbers are created when you do this: 
		 */
		
		Stream.generate(()->(int)(Math.random()*100))
				.limit(50) //max amount will be 50
				.filter(n->n%4==0)
				.peek(System.out::println)
				.collect(Collectors.counting()).longValue(); //.longValue() converts this to a long. 
		
		//store the count of the amount of objects created: 
		long lAmount = Stream.generate(()->(int)(Math.random()*100))
		.limit(50) //max amount will be 50
		.filter(n->n%4==0)
		.peek(System.out::println)
		.collect(Collectors.counting()).longValue();  
		
		System.out.println("lAmount: " + lAmount);
		
		
		//=======================================COLLECTORS.JOINING:
		
		//Collectors.joining is only for strings:
		
		List<String>animals=Arrays.asList("dog", "cat", "mouse", "cow", "sheep", "pig");
		
		//this would need redefining each time :( so we use the list above  
		Stream<String>strStream=Stream.of("dog ", "cat ", "mouse ", "cow ", "sheep ", "pig ");
		
		//--------------------------------------
		/*
		 * First joining() method tsakes no arguements
		 * and returns a String that is a string containing all the strings in the stream
		 */
		
		//joins all of the strings in the arraylist to be one string: 
		String joined = animals.parallelStream().collect(Collectors.joining());
		System.out.println("joined string is: " + joined);
		
		//-----------------------------------
		/*
		 * 2nd joining(),method takes one arg, a string and a delimeter
		 */
		
		/*
		 * Each of our strings is going to be seperated by a comma and a space: 
		 */
		 joined = animals.parallelStream().collect(Collectors.joining(", "));
		 System.out.println("joined string with delimeter is: " + joined);
		 
		//-----------------------------------
		 
		 /*
		  * 3rd overloaded joining() method takes 3 argumemnts:
		  * a delimeter (inbetween the string), a prefix (start of string) and a suffix (end of the string)
		  */
		 
		 joined = animals.parallelStream().collect(Collectors.joining(", ", "our list of animals is: ", ". Which are all native to Ireland"));
		 
		 System.out.println(joined);
		 

	
	}
	
	
	
	static void ex5() {
		
		//===========================MORE COLLECTOR.METHODS we should know
		
		System.out.println("\nex5()");
		
		//----------------------------------
		
		//10 dogs with random ages, which are less than 20
		List<Dog>dogList=Stream.generate(()->new Dog(generateRandom(), "spot"))
				.filter(d->d.age<20)
				.limit(10)
				.collect(Collectors.toList());
		
		System.out.println("doglist:" + dogList);
		
		
		//------------------------
		
		//10 dogs with ages less than 20 and weights greater than 1 and less than 30:
		List<Dog>dogList2=Stream.generate(()->new Dog(generateRandom(), "rex", Math.random()*100))
				.filter(d->d.age<20)//.distinct() 
				.filter(d->d.weight>1)//.distinct()
				.filter(d->d.weight<30)//.distinct()
				.limit(10)
				.collect(Collectors.toList());
		
		
		System.out.println("dogList2:" + dogList2);
		System.out.println(Dog.dogCounter + " dogs created to give a list of 10 dogs");
		
		
		//==========================COMPARATORS FOR DOGS:
		
		Comparator<Dog>dogAgeComp=(d1,d2)->d1.age-d2.age; //comparator for ages of dogs
		
		//Comparator returns either a -int, a 0 int or a + int, so the compareTo method of the double wrapper class is used ++++++++++++++++++++++++++++
		Comparator<Dog>dogWeightComp=(d1,d2)->d1.weight.compareTo(d2.weight); //comparator for weights of dogs
		
		//============MAX BY:
		
		/*
		 * MaxBY returns an optional of type Dog:
		 * Optional<Dog>
		 * and takes a comparator for what attribute of the dog we are trying to find a max for (ie oldest dog or heaviest dog)
		 */
		
		//oldest dog:
		Optional<Dog>dogOptAge=dogList.stream().collect(Collectors.maxBy(dogAgeComp)); //returns an optional 
		System.out.println("oldest dog is: " + dogOptAge.get());
		
		//heaviest dog:
		Optional<Dog>dogOptWeight=dogList2.stream().collect(Collectors.maxBy(dogWeightComp)); //returns an optional 
		System.out.println("heaviest dog is: " + dogOptWeight.get());
		
		
		//============MIN BY:
		
		/*
		 * min by operates exactly the same way as max by
		 */
		
		//youngest dog:
		Optional<Dog>dogOptAge2=dogList.stream().collect(Collectors.minBy(dogAgeComp)); //returns an optional 
		System.out.println("youngest dog is: " + dogOptAge2.get());
		
		//lightest dog:
		Optional<Dog>dogOptWeight2=dogList2.stream().collect(Collectors.minBy(dogWeightComp)); //returns an optional 
		System.out.println("lightest dog is: " + dogOptWeight2.get());

	}
	
	
	static int generateRandom() {
		return (int)(Math.random()*100+1);
	}
	
	
	static void ex6() {
		
		//===========================SUMMARISING DOUBLE, INT & LONG
		
		System.out.println("\nex6()");
		
		List<String>animals=Arrays.asList("dog", "cat", "mouse", "sheep", "pig");
		
		//Separate obj that stores info about the stream:
		//animals is a list of strings, s is a string
		DoubleSummaryStatistics statStr = animals.stream().collect(Collectors.summarizingDouble(s->s.length()));
		
		System.out.println("average length of strings is: " + statStr.getAverage());
		System.out.println("total ammount of chars in our strings is: " + statStr.getCount());
		System.out.println("string with most chars is: " + statStr.getMax());
		System.out.println("string with least chars is: " + statStr.getMin());
		System.out.println("total amount of chars is: " + statStr.getSum());
		
		//same things work for int and long +++++++
		
		
		//===========================SUMMING DOUBLE, SUMMING INT & SUMMING LONG:
		
		//example beforehand:
		//This produces 5 dogs with random ages between 1 & 100, nd randpm weights between 1.0 & 10.0
		List<Dog>dogList = Stream.generate(()->new Dog(generateRandom(), "spot", Math.random()*10))
				.limit(5)
				.collect(Collectors.toList());
		
		System.out.println(dogList);
		
		//summing double:
		//This will return the total weight of all the dogs:
		//summingDouble takes a toDoubleFunction
		double dogWeight = dogList.stream().collect(Collectors.summingDouble(d->d.weight));
		
		
		//summing int:
		//returns the total of all ages of dogs:
		int dogAge = dogList.stream().collect(Collectors.summingInt(d->d.age));	
		
		
		//===========================ADDING TO COLLECTIONS:
		//REMEMBER to LIMIT the stream ++++++++++++++++++++ 
		
		//======TOLIST():
		//Returns a list of whatever type we state our list to be in the generic
		//this will multiply each number produced by a factor of 10:
		List<Integer>intList = Stream.iterate(1, n->n*10).limit(10).collect(Collectors.toList());
		
		System.out.println(intList);
		

		//======TOSET():
		
		List<String>animals2=Arrays.asList("dog", "cat", "pig", "pig", "sheep", "cow");
		
		//this returns a set based on the list of animals above.
		Set<String>animalSet=animals2.stream().collect(Collectors.toSet());
		
		System.out.println(animalSet);
		
		
		//======TOCOLLECTION():
		
		/*
		 * allows us to save our stream to any particular type of collection object
		 * (any type of set, queue or list, NOT MAPS)
		 */
		
		
		TreeSet<Integer>treeInt=Stream.generate(()->generateRandom())
				.distinct() //have to put in distinct if you want exactly 7 numbers each time (as rand numbers could be duplicates)
				.limit(7)
				.collect(Collectors.toCollection(()->new TreeSet<Integer>())); //takes in a supplier object, and this object has to provide a collection obj of some type
		
		System.out.println(treeInt);
		
		
		treeInt.clear();
		
		//Shortened version of above:
		treeInt= Stream.generate(()->generateRandom()).distinct()
				.limit(7)
				.collect(Collectors.toCollection(TreeSet::new)); //automatically creates a treeSet of INTEGERS. otherwise you need to remember the INTEGER generic on the above example. 
				
		
		
		//---------------------
		
		//this list contains: [dog, cat, mouse, sheep, pig]
		System.out.println(animals);
		
		LinkedList<String>linkedStr = animals.stream().collect(Collectors.toCollection(LinkedList::new));
		
		System.out.println(linkedStr);
				
	}
	
	
	
	static void ex7() {
		
		//=======================================COLLECTING STREAMS INTO MAPS:  ++++++++++++++++++++++++++++++:
		
		//---------------TOMap()
		
		//map of integers & strings:
		//if you put in a duplicate key, the value for that key is overwritten
		Map<Integer, String>myMap = new HashMap<Integer, String>();
		
		myMap.put(333, "jay");
		myMap.put(111, "dan");
		myMap.put(444, "sam");
		myMap.put(555, "laura");
		myMap.put(333, "yo"); //value is overwritten as key is there already
		myMap.putIfAbsent(333, "dawg"); //key is there so this wont be put in
		
		System.out.println("myMap: " + myMap);
		
		
		//You CANT use Collectors.toCollection with maps as they're not part of the collection interface
		//so you need to use the below: +++++++++++++++++++
		
		
		List<String>animals = Arrays.asList("dog", "cat", "mouse", "cow", "sheep", "pig", "ox", "elephant");
		
		/*
		 * This map will take as it's key: a string in the above list, and as it's value: the length of the string. 
		 * 
		 * ToMap takes in 2 function methods. First function takes in a string and returns a string. this will be our key. 
		 * 2nd function 
		 * 
		 * 's' is a string, because its declared to be in the first generic & is being mae from a stream of strings ++++++++++++
		 */
		
		Map<String, Integer>strMap = animals.stream().collect(Collectors.toMap(s->s, s->s.length())); 
		
		System.out.println("strMap: " + strMap);
		
		//--------------------------------
		
		//create a treeMap and dump in strMap (to have strMap be ordered)
		TreeMap<String, Integer>tMap = new TreeMap<String, Integer>(strMap);
		//tMap.putAll(strMap);
		
		System.out.println("tMap: " + tMap);
		
		
		//------------------------
		//List<String>animals = Arrays.asList("dog", "cat", "mouse", "cow", "sheep", "pig");
		
		/*
		 * create a map of animals, using its index in the list as the key.
		 */
		Map<Integer, String>intMap=Stream.iterate(0, n->n+1)
				.limit(animals.size())
				/*
				 * the value CAN be generated from the key, as here you get elements from a list
				 * by using the key in the get statement, but you dont HAVE TO generate a value based on a key. 
				 */
				.collect(Collectors.toMap(n->n, n->animals.get(n)));
		
		System.out.println("intMap: " + intMap);
		
		
		
		//==================================================TO MAP FUNCTIONS:
		
		
		List<String>animals2 = Arrays.asList("dog", "cat", "mouse", "cow", "sheep", "pig", "pig");
		
		//first overloaded toMap:
		/*
		 * strMap takes a String and an Integer:
		 * 
		 * This below stream has duplicate values. So thee values are what the map will use as the keys. 
		 * A map cannot have duplicate keys. (if we use put, the keys would be input and the original values overriden).
		 * If we try and add duplicates to a map using a stream though, we get an illegal state exception.
		 */
		strMap = animals2.stream()
				.distinct() //this prevents exception as the duplicate key isnt allowed. ++++++++++++++
				.collect(Collectors.toMap(s->s, s->s.length()));
		
		
		System.out.println("strMap: " + strMap);
		
		
		/*
		 * This creates a map wih a unique key generated from the static int counter that increments by one each time.
		 * As the key is unique we dont have to use "distinct()" here as the values in the stream are not used to generate the keys.
		 */
		Map<Integer, String>integerMap=animals2.stream()
				.collect(Collectors.toMap(s->++count, s->s)); //taking a string (but not doing anything with it)
		
		
		System.out.println("integerMap: " + integerMap);
		
		//--------------------------------------------
		//2nd overloaded toMap:
		
		/*
		 * The overloaded toMap() method takes a function, function and a BinaryOperator 
		 * First arg creates the key, second creates the val, 3rd arg is what happens when you have 2 keys that are the same. 
		 */
		
		//intMap<Integer, String>
		//animals = Arrays.asList("dog", "cat", "mouse", "cow", "sheep", "pig");
		
		intMap.clear();
		intMap = animals.stream().collect(Collectors.toMap(k->k.length(),  //take in string from current pos in list and return it's length as key.
														v->v, //take in string from current pos in list and use that as value
														(s1, s2)-> s1+", " + s2)); //if 2 keys are the same (same length), concatenate the two strings to create a new value for them
		
		
		System.out.println("intMap++: " + intMap); //prints: intMap: {3=dog, cat, cow, pig, 5=mouse, sheep}
		
		
		//--------------------------------------------DO THIS WITH A LOOP! :P ++++++++++++++++++++++++++++++
		
		/*
		 * this sorts the map by key:
		 */
		//3nd overloaded toMap:
		
		TreeMap<Integer, String>treeMap=animals.stream()
				.collect(Collectors.toMap(k->k.length(), 
						v->v, 
						(s1, s2)-> s1+", " + s2, 
						//()->new TreeMap<Integer, String>())); //longer version of below
						TreeMap::new));
		
		System.out.println("treeMap: " + treeMap); 
		
	}
	
	
	static int count=0;
	
	
	static void ex8() {
		
		//=================================================GROUPING BY() ++++++++++++++++++++++++++++++++++++++++++++
		
		System.out.println("\nex8:");
		
		List<String>animals=Arrays.asList("dog", "cat", "mouse", "cow", "sheep", "pig", "elephant", "antelope");
		
		
		/*
		 * grouping by returns a group of lists (collection objects) that are grouped in whatever format we want. 
		 * Here we are going to return lists of strings and the first list will contain all the strings with 3 characters in it. 
		 * 
		 * Second list will be the list with 5 characters
		 * 
		 * This produces a map of Integers and lists of strings. 
		 * Key 3 will be the lsit that contains: dog, cat, cow, pig
		 * 
		 * key 5 will be the list that contains: mouse, sheep.
		 * 
		 * key 8 will be the list that contains elephant and Antelope
		 * 
		 */
		
		//-----------------------------FIRST overloaded groupingBy method:
		/*
		 * This groupBy returns a HashMap that is going to have as a key any object type and as its value, a liat of any object type. 
		 */
		
		
		Map<Integer, List<String>>tMapList = animals.stream().collect(Collectors.groupingBy(s->s.length()));
		
		System.out.println(tMapList); //this prints out: {3=[dog, cat, cow, pig], 5=[mouse, sheep], 8=[elephant, antelope]}
		
		//get lists:
		System.out.println(tMapList.get(3));
		System.out.println(tMapList.get(5));
		System.out.println(tMapList.get(8));
		
		//get an element from the list:
		System.out.println("this gets the dog: " + tMapList.get(3).get(0));
		
		System.out.println("this gets the dog: " + tMapList.get(8).get(tMapList.get(8).size()-1));
		
		
		//-----------------SET OF KEYS;
		
		//returns a set of all the keys:
		System.out.println(tMapList.keySet());
		
		//--
		
		Map<Integer, Double>myMap=Stream.iterate(1, n->n+10)
				.limit(10)
				.collect(Collectors.toMap(k->k, v->Math.random()*v));
		

		System.out.println(myMap);
		
		/*
		 * myMap<Integer, Double> 
		 * has an Integer key and a Double value. To get all the values of a map we use .Values()
		 * which returns a collection object containing all the values.
		 * In this case this returns a collection of doubles.
		 */
		
		List<Double>dList=myMap.values()
				.stream() //when you have a stream, you can create a list
				.collect(Collectors.toList()); //here we have a list
		
		System.out.println("list of double values is: " + dList);
		System.out.println("list of Integr key is: " + myMap.keySet() //grab keys
														.stream() //stream of integers
														.collect(Collectors.toCollection(TreeSet::new))); //put all the integers into a treeSet
		
		
		//-------------------
		
		tMapList.clear();
		tMapList = animals.stream().collect(Collectors.groupingBy(s->s.length()));
		
		System.out.println(tMapList.keySet());
		System.out.println(tMapList.keySet().parallelStream().collect(Collectors.toCollection(TreeSet::new)));
		
		System.out.println(tMapList.values().stream().collect(Collectors.toList()));
		List<List<String>>listList=tMapList.values().stream().collect(Collectors.toList());
		
		/*
		 * This gets the first list in our list of strings and then gets the first string in that list, which is a dog:
		 */
		
		System.out.println(listList.get(0).get(0));
		
		//------------using FLATMAP:
		
		Set<String>values=tMapList.values() //produce a collection of a list of strings
				.stream() //a stream of lists of strings
				.flatMap(l->l.stream()) //this produces just a stream of list of Strings from our stream of lists of strings
				.collect(Collectors.toSet());
				
		System.out.println("our set of values is now: " + values);
		
		
		
		//---------------------------------------SECOND overloaded groupingBy method:
		
		
		/*
		 * This groupingby  is when we want to return a partuicular type of collection. 
		 * As the groupingBy that only takes one arguement can only return a map of lists as values, the key can be any type you want.
		 */
		
		/*
		 * This will not work as this groupingBy generates a list of strings not a set of strings. 
		 */
		/*
		Map<Integer, Set<String>>tMapSet= animals.stream()
				.collect(Collectors.groupingBy(s->s.length()));
		*/
		
		
		/*
		 * This groupingBy takes 2 params:
		 * 1st is a function which creates our key and groups all of the values according to key,
		 * in this case all strings with length 3 will be one group, of length 5 will be another group. of length 8 will be another group. 
		 * 
		 * 2nd arg: is called a DOWNSTREAM COLLECTOR which determines what type of collection you want it to be.
		 */
		Map<Integer, Set<String>>tMapSet= animals.stream()
				.collect(Collectors.groupingBy(s->s.length(), Collectors.toSet())); 
		
		
		
		//---------------------------------------THIRD overloaded groupingBy method:
		
		
		/*
		 * This takes 3 args.
		 * 1st arg is a function that specifies key & grouping. 
		 * 2nd is the specific type of map we want this to be. (a supplier that takes a map)
		 * 3rd: specific type of collection you want these values to be in your collection.
		 */
		
		/*
		 * This creates a treeMap of TreeSets  of Strings, that have Integers as the keys.
		 */
		TreeMap<Integer, TreeSet<String>>tTreeMapTree=animals
												.stream()
												.collect(Collectors.groupingBy
														(s->s.length(), //same as s->s.length()s
														TreeMap::new, //same as ()->new TreeMap<Integer, TreeSet<String>>()
														Collectors.toCollection(TreeSet::new))); //same as ()->new TreeSet<String>()
	
		
		System.out.println("tTreeMapTree: " + tTreeMapTree);
		
		
		
	
		//==============================================Partitioning: +++++++++++++++++++++++++++++++++++
		
		/*
		 * Partitioning is a special type of grouping, and with this there are only 2 possible groups: true or false. 
		 * 
		 * PartitionBy() takes a predicate
			true - those strings longer than 4 characters long
			false - those with string 4 or less
		 *
		 *The key is alwaya a boolean
		 *The value is always a collection of objects
		 */
		
		Map<Boolean, List<String>>partMap = animals.stream()
											.collect(Collectors.partitioningBy(s -> s.length()>=4)); //partition by all strings that have 4 or more characters
		
		
		System.out.println(partMap);
		
		/*
		 * Below takes a predicate and downstream collector (which is just the collection type we want our map to contain)
		 */
		Map<Boolean, Set<String>>partMapSet=animals.stream()
													.collect(Collectors.partitioningBy(s->s.length()>=4, Collectors.toSet()));
		
		
		Map<Integer, Long>longIntMap = animals.parallelStream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
		System.out.println(longIntMap);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
