package com.android;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * List of TERMINAL OPERATIONS 
 * toArray()
			collect()
			count()
			reduce()
			forEach()
			forEachOrdered()
			min()
			max()
			anyMatch()
			allMatch()
			noneMatch()
			findAny()
			findFirst()
			terminal operations CANNOT be chained
 * @author noelf
 *
 */

public class Examples {
	
	static void ex1() {
		System.out.println("ex1 creating streams");
		/*
		 * we will use this array to create a Stream of Integers, you can only 
		 * create Streams from arrays that contain only OBJECTS
		 */
		Integer[]values= {4,5,6};
		//can't be an array of ints
		int[]nums= {10,20,30};
		System.out.println("creating empty stream");
		Stream<String>empty=Stream.empty();
		System.out.println("creating stream of one element");
		Stream<Integer>singleElement=Stream.of(3);
		System.out.println(singleElement);
		System.out.println("creating a strem from an array");
		Stream<Integer>fromArray=Stream.of(values);
		//this is also creating a stream with the values 100,200,300
		Stream<Integer>fromArray2=Stream.of(100,200,300);
		System.out.println(fromArray);
		System.out.println("Foreach");
		/*
		 * Foreach is a Terminal operations that takes a consumer object
		 * consumer takes a object and returns nothing
		 * forEach here takes a consumer of type Integer, as fromArray is a stream
		 * with type Integer
		 */
		List<Integer>intList=new ArrayList<>();
		fromArray.forEach(
				(a1)->{
					System.out.println("number is "+a1);
					a1=a1*2;
					System.out.println("double our number is "+a1);
					intList.add(a1);
				}
				);
		
		System.out.println("first number in values is still "+values[0]);
		System.out.println(intList);
		
		List<String>fruits=Arrays.asList("apple","orange","banana","pineapple");
		/*
		 * this creates a stream from the List of strings called fruits
		 */
		/*Stream<String>fromFruits=*/
		System.out.println("uppercase text");
	//	List<String>listFruits=new ArrayList<String>();
		fruits.stream().limit(3).forEach(a->{
			a=a.toUpperCase();
			System.out.println(a);
			//listFruits.add(a);
		});
		Stream<String>fromFruits=fruits.stream();
		System.out.println(fromFruits);
		
		
		//fromFruits.forEach((str)->System.out.println(str+" tree"));
		fromFruits.forEach(System.out::println);
		/*
		 * this will not compile as forEach is a TERMINAL OPERATION, and once you
		 * perform a Terminal operation on a stream, you can no longer use it with
		 * any other opeartion
		 * this will generate an IllegalStateException, which is a runtimeexception
		 */
	//	fromFruits.forEach((str)->System.out.println(str));
		/*
		 * you have to redefine the stream if you want to use it again
		 */
		fromFruits=fruits.stream();
		fromFruits.forEach((str)->System.out.println(str+ " tree"));
		/*
		 * Parallel Streams utilises multiple CPU course if your  machine has them.
		 * ,if they are not parallel streams then they are said to be sequential (
		 * one after another)
		 */
		Stream<String>fromFruitPar=fruits.parallelStream();
		System.out.println(fromFruitPar);
		fromFruitPar.forEach((str)->System.out.println("johnny "+str+"seed"));
		/*
		 * creating a new stream<String> from fruits list of Strings
		 */
		fromFruits=fruits.stream();	
	}
	
	static void ex2() {
		System.out.println("ex2");
		System.out.println("produce random numbers between 1 and 100");
		//(int)(Math.random()*100)
		System.out.println("random number is "+(int)(Math.random()*100));
		System.out.println("generate()");
		/*
		 * you can produce an infiinte stream very easily, can't create an infinite list
		 * generate takes a supplier, which takes no parameters and returns an object
		 * of type T, in this case it will return an Integer
		 * generate produces an infinite amount of objects, in this case an infinite
		 * amount of Integers between the numbers 0 and 100
		 * however this code does NOT run until a terminal operation is called
		 * on the stream
		 * generate takes a supplier object
		 */
		Stream<Integer>randoms=Stream.generate(
				()->{
					System.out.println("****randoms generated****");
					return (int)(Math.random()*100);
				}
				);
		System.out.println("test print");
		//randoms.forEach((s)->System.out.println(s));;
		/*
		 * this causes our randoms code to run and produces an infinite amount of
		 * Integers
		 */
	//	randoms.forEach(System.out::println);
		System.out.println("limit()");
		/*
		 * limit is a intermediate operation that does not run until the stream hits
		 * a terminal operation
		 */
		randoms.limit(5).forEach(System.out::println);;
		
		Stream<Animal>ranAnimal=Stream.generate(
				()->{
					int num=(int)(Math.random()*100);
					return new Animal(num,"andy");
				}
				);

		//will be used to create our stream of Animals
		Supplier<Animal>supAnimal=()->{
			int num=(int)(Math.random()*100);
			return new Animal(num,"andy");
		};
		/*
		 * this code will only run if a terminal operation runs on this the
		 * stream ranAnimal. if we do not include a limit() on this stream, then
		 * you will get an infinite amount of Animals
		 */
		ranAnimal=Stream.generate(supAnimal);
		System.out.println("Animals not created");
		/*
		 * as generate() produces an infinite stream of objects, unless we limit()
		 * generate this will produce an infinite print out
		 */
		//ranAnimal.forEach(System.out::println);
		ranAnimal=ranAnimal.limit(3);
		System.out.println("animals still not created");
		/*
		 * once your run a terminal operation on a Stream, the stream is closed
		 * and can't be operated on again by any operation
		 */
		ranAnimal.forEach(System.out::println);
		//ranAnimal.limit(3).forEach(System.out::println);
		System.out.println("animals have been created");
		/*
		 * this will generate an IllegalStateException, as this stream is 
		 * already closed
		 */
	//	ranAnimal.limit(2);
		/*
		 * this will produce three Animals
		 */
				Stream.
				generate(supAnimal)
				.limit(3)
				.forEach(
						(a)->System.out.println(a)
						);
		
		
	}
	
	static void ex3() {
		System.out.println("***ex3");
		System.out.println("iterate()");
		/*
		 * also used for creating streams
		 * iterate for streams takes two parameters, a seed which will be a starting
		 * value and a unary operator (unary operater takes a object and returns 
		 * an object of the same type)
		 * in this case we have a starting seed of the number 1 and add 2 to the 
		 * number each time, which produces an infinite stream of odd numbers,
		 * starting at 1-> 1+2=3,3+2=5, etc
		 * iterate() just like generate(), if not limited, will produce an infinite amount
		 * of objects, in this case numbers
		 */
		Stream<Integer>oddNumbers=Stream.iterate(1, n->n+2).limit(60);
		/*
		 * this will produce an infinite stream of odd numbers
		 */
		//oddNumbers.forEach(System.out::println);
		oddNumbers.limit(25).forEach(System.out::println);
		/*
		 * the above stream is  now closed so we cannot perform any more operations
		 * on it, if we try we get the runtimeException IllegalStateException
		 */
		//oddNumbers.limit(10);
		System.out.println("produce 25 random even numbers");
		Stream<Integer>evenNumbers=Stream.iterate(2, 
				(n)->{
					Integer number=(int)(Math.random()*1000);
					/*
					 * if the number modulus 2 is 0 then the number is even
					 * and return that number
					 * if the number modulus 2 is 1 the number is odd and we add
					 * 1 to the number to make it even
					 * (i.e 333 is odd, add one, becomes 334, which is even
					 * 
					 */			
					return number%2==0?number:number+1;
			/*		if(number%2==0)
						return number;
					else
						return number+1;*/
				}
				);
		//this will produce an infinite amount of even numbers
		//evenNumbers.forEach(System.out::println);
		//evenNumbers.limit(25).forEach(System.out::println);
	//	evenNumbers.filter((n)->n%10==0).forEach(System.out::println);;
		
		List<String>people=new ArrayList<>(Arrays.asList("noel","mary","shelly","colm"));
		/*
		 * filter takes a predicate and only objects that meet the crieria of the 
		 * predicate, will be produced, in this case only strings that have a 
		 * name length greater than four in the list of people will be created, which
		 * is the string "shelly"
		 */
		 people.stream().filter(s->s.length()>4).limit(4).forEach(System.out::println);
		 
	}
	
	static void ex4() {
		Supplier<Animal>supAnimal=()->{
			int num=(int)(Math.random()*100);
			return new Animal(num,"andy");
		};
		/*
		 * each intermediate operation on a stream, creates a new stream and 
		 * effectively closes the stream it is operating on
		 */
		Stream<Animal>ranAnimal=Stream.generate(supAnimal);//creates stream A
		/*#
		 * this effectively closes the stream ranAnimal and creates a new Stream
		 * that we cannot access after this line of code as we have not assigned
		 * this stream to anything
		 * as there is no terminal operation, the code does not instantiate. 
		 * streams uses lazy instantation and will only execute at a Terminal operation
		 */
		ranAnimal.limit(20);//creates Stream B, effectively closes Stream A
		/*
		 * this generates a IllegalStateException as we have already operated on this
		 * stream which effectively closes teh stream
		 */
		ranAnimal.filter(a->a.age>20);
		/*
		 * this also produces a IllegalStateException as this stream has already been
		 * operated on and is effectively closed
		 */
	//	ranAnimal.forEach(System.out::println);
		/*
		 * this produces a new Stream A which is assinged to ranAnimal
		 */
		Stream.generate(supAnimal)
				.filter(a->a.age>20).
				limit(5).
				forEach(System.out::println);;
		/*
		 * this produces a new Stream B from from Stream A and effectively closes 
		 * Stream A
		 */
		ranAnimal=ranAnimal.filter(a->a.age>20);
		/*
		 * this produces a new Stream C from strem B and effectively closes Stream
		 * B
		 */
		ranAnimal=ranAnimal.limit(5);
		System.out.println("print out five Animals");
		/*
		 * executes stream C, which causes all our stream code to run and closes 
		 * stream C
		 */
		ranAnimal.forEach(System.out::println);
		
		Stream.generate(supAnimal).
		filter(
				a->a.age>20
				).
		limit(5).
		forEach(System.out::println);
		System.out.println("another five Animals");
		ranAnimal=Stream.generate(supAnimal).
				filter(
						a->a.age>20
						).
				limit(5);
		ranAnimal.forEach(System.out::println);
		System.out.println("creating 7 Animals");
		/*
		 * you can't assign this to anything as the final method call is what determines
		 * what the line of code as a whole returns. ForEach returns VOID, so this
		 * CANNOT BE assigned to any variable
		 */
		/*ranAnimal=*/
		List<Animal>animals=new ArrayList<>();
		animals.clear();
		/*
		 * this is generating 7 animals and then adding each Animal to ArrayList
		 * of Animals
		 */
		Stream.generate(supAnimal).
		filter(
				a->a.age>20
				).
		limit(7).
		forEach(
				(a)->{
					System.out.println(a);
					animals.add(a);
				}
				);
		System.out.println("animals is "+animals);
		
	}
	
	static void ex5() {
		System.out.println("*****Reductions");
		/*
		 * Reductions are special type of Terminal operation where all objects created
		 * by the stream are combined into a single value
		 */
		System.out.println("Count");
		/*
		 * counts the amount of objects in a stream, and it returns a long
		 */
		System.out.println("count is a reduction");
		Stream<Integer>numStream=Stream.generate(()->(int)(Math.random()*100))
				.limit(15);
		System.out.println("amount of objects created ");
		/*
		 * Terminal operation, executes the code and closes the stream
		 */
		System.out.println(numStream.count());
		numStream=Stream.generate(()->(int)(Math.random()*100));
		System.out.println("count on a infinite stream");
		/*
		 * this leads to a infinite hang, where your program will keep counting
		 * to infinity and never return a result
		 */
	//	System.out.println(numStream.count());
		
		/*
		 * this generates 20 random numbers and then filters out those 20 numbers to
		 * only number greater than 50. The numbers are NOT created at this point
		 * its only at the teriminal operation are these numbers created
		 */
		numStream=Stream.generate(()->(int)(Math.random()*100)).
				limit(20).
				filter(i->i>50);
				
		//numbers created here and closes the last stream
		System.out.println(numStream.count());
		/*
		 * count() returns a long, which can only be assigend to a long or a 
		 * compatible data type (Long wrapper or a double, as long can fit inside
		 * a double)
		 */
		long lNum=Stream.generate(()->(int)(Math.random()*100)).
				limit(20).
				filter(i->i>50).
				count();
		double dnum=lNum;
		
		System.out.println("min and max");
		numStream=Stream.of(234,56,11,2,6,99);
		/*
		 * Min method signature looks like this
		 * has to optional as if dealing with an infinite stream then there is no
		 * max or min and you can also produce empty streams by
		 * going Stream.empty();
		 * Optional<T>min(<? super T>comparator)
		 * this produces an infinite stream of Integers so there is no max or min
		 */
	//	Stream.iterate(2, n->n+2).forEach(System.out::println);
		/*
		 * min and max both take a Comparator which is a object that implements
		 * the Comparator interface, and the comparator interface only has one
		 * method <T>long compare(T t,T t2)

		 * here we take in two ints 
		 * n1 and n2
		 * and use the compareTo() method of the Integer class that takes an Integer 
		 * in this case and compares it with the Integer calling the method.
		 * The integer class implements the Comparable interface, and compareTo() isa
		 * method of the Comparable interface
		 */
		Comparator<Integer>compInt=(n1,n2)->n1.compareTo(n2);
		//both max and min takes the same comparator
		Optional<Integer>mini=numStream.min(compInt);
		System.out.println("minumum number is "+mini.get());
		numStream=Stream.of(234,56,11,2,6,99);
		mini=numStream.min((n1,n2)->n1-n2);
		System.out.println("minimum number is "+mini.get());
		System.out.println(mini.get());
		Optional<Integer>maxi=Stream.of(234,56,11,2,6,99).max((n1,n2)->n1.compareTo(n2));
		System.out.println("maxi is "+maxi.get());
		maxi=Stream.of(234,56,11,2,6,99).max((n1,n2)->n1-n2);
		System.out.println("maxi is "+maxi.get());
		
		Stream<Integer>noNum=Stream.empty();
		Optional<Integer>optNo=noNum.max((n1,n2)->n1-n2);
		System.out.println("optNo.get is ");
		//System.out.println(optNo.get());
		System.out.println("ifPresent");
		/*
		 * if optNo has a value, do something
		 * ifPresent takes a consumer object and returns void
		 */
		optNo.ifPresent(
				(n1)->{
					System.out.println(n1);
				}
		
				);
		/*
		 * returns a boolean, true if the optional has a value
		 * false if the optional has no value
		 */
		if(optNo.isPresent())
			System.out.println(optNo.get());
		else
			System.out.println("no value");
		/*
		 * if optNo has no value, which an optional can have, return 0
		 * orelseGEt takes a supplier object
		 * if the optional has no value it uses the supplier object to create a 
		 * object for it
		 * in this case if optNo has no value, it will assign the value "0" to 
		 * optNo
		 */
		System.out.println(optNo.orElseGet(()->0));
	/*
	 * this supplier object will be used to create Animals all called andy with
	 * random ages between 0 and 100
	 */
		Supplier<Animal>supAnimal=()->{
			int num=(int)(Math.random()*100);
			return new Animal(num,"andy");
		};
		
		List<Animal>zoo=new ArrayList<Animal>();
		/*
		 * this produces 10 Animals that are added to our list of Animals called
		 * Zoo
		 */
		Stream.generate(supAnimal).
		limit(5).
		forEach(
				(a)->{
					zoo.add(a);
					System.out.println(a);
				}
				);
		
		System.out.println("animal with max age is ");
		//this will get the Oldest animal, to get the value of an optional, use get()
		System.out.println(zoo.stream().max((a1,a2)->a1.age-a2.age).get());
		/*
		 * can't compareTo with Animal as Animal has NOT implemented the Comparable
		 * interface
		 */
		System.out.println(zoo.stream().min((a1,a2)->a1.age-a2.age).get());
		;
		Rat r1=new Rat(12,"zed",2.3);
		Rat r2=new Rat(12,"zed",2.3);
		Rat r3=new Rat(7,"adam",1.2);
		Rat r4=new Rat(5,"Carol",2.56);
		List<Rat>ratList=new ArrayList<>(Arrays.asList(r1,r2,r3,r4));
		System.out.println("minimum rat");
		//this gets the Optional of type Rat
		System.out.println(ratList.stream().min((rat1,rat2)->rat1.compareTo(rat2)));
		System.out.println("maximum rat");
		//this gets the actual Rat
		System.out.println(ratList.stream().
				max((rat1,rat2)->rat1.compareTo(rat2)).get());
		/*
		 * sets remove ducplicates
		 */
		Set<String>strSet=new HashSet<>();
		//only one apple added to this list
		strSet.addAll(Arrays.asList("orange","apple","banana","apple","pineapple"));
		;
		System.out.println(strSet);
		System.out.println(strSet.stream().min((s1,s2)->s1.compareTo(s2)).get());
		//both r1 and r2 rat have same name, age and weight, so can be said to be
		//equal, using the equals and hashcode method of the Rat class, so only
		//one Rat called zed will be added
		Set<Rat>ratSet=new HashSet<>();
		ratSet.addAll(ratList);
		System.out.println(ratSet.stream().max((s1,s2)->s1.compareTo(s2)).get());
		System.out.println(ratSet.size());
		
	}
	
	static void ex6() {
		System.out.println("**ex6");
		System.out.println("findAny()");
		/*
		 * findAny will display if there is any element in a sttream
		 * it does not take any variables, but it returns an optional
		 * it is a terminal operation, but it is NOT a reduction as it does not
		 * reduce the stream to a single value and returns an Optional
		 */
		Stream<String>apes=Stream.of("monkey","gorilla","oran Utang");
		//this will return the string "monkey"
		apes.findAny().ifPresent(System.out::println);
		apes=Stream.empty();
		//this will return nothing as the stream 
		apes.findAny().ifPresent(System.out::println);
		apes=Stream.empty();
		//orElseGEt will return a string, not matter what
		//if there is no string in the apes stream, then this will return the string 
		//"chimp
		System.out.println(apes.findAny().orElseGet(()->{
			System.out.println("no monkey so return chimp");
			return "chimp";
		}));
		apes=Stream.of("monkey","gorilla","oran Utang");
		/*
		 * this will return "monkey" as there is values in this stream so findAny will
		 * return the first string it finds, which is "monkey"
		 */
		System.out.println(apes.findAny().orElseGet(()->{
			System.out.println("no monkey so return chimp");
			return "chimp";
		}));
		
		apes=Stream.of("monkey","gorilla","oran Utang");
		/*
		 * this will check if your stream is empty or not
		 */
		System.out.println(apes.findAny().isPresent());//true
		apes=Stream.empty();
		System.out.println(apes.findAny().isPresent());//false
		System.out.println("creating a randon series of infinite numbers");
		Stream<Integer>infiniteNums=Stream.generate(()->(int)(Math.random()*100));
		System.out.println(infiniteNums.findAny().get());
		
		System.out.println("****findFirst");
		/*
		 * returns a optional, has to optional as this may be an empty string
		 * and as far as i can see it's the same as findAny
		 */
		ArrayList<Animal>listAnimal=new ArrayList<Animal>();
		Stream.generate(()->new Animal()).
		limit(5).
		forEach((a)->{
			System.out.println("animal "+a+" is added to the arraylist");
			listAnimal.add(a);
		});
		System.out.println(listAnimal);
		System.out.println(listAnimal.stream().
				findFirst().
				orElseGet(null));	
	}
	
	static void ex7() {
		System.out.println("terminal operations anyMatch(),allMatch(),noneMatch()");
		/*
		 * anyMatch
		 * if any items in a stream matches what this predicate is look for, this 
		 * will return true (i.e looking for any Dog with the name of "spot")
		 * boolean anyMatch(Predicate<? super T> predicate)
		 * allMatch
		 * if ALL items in stream matches what this predicate is looking for, this
		 * will return true (i.e are all dogs in the stream called "spot"
		 * boolean allMatch(Predicate<? super T>predicate)
		 * noneMatch
		 * if no items in a stream matches what this preidcate is looking for, this
		 * will return true (i.e is there no dog called "spot" in this stream
		 * boolean noneMatch(Predicate<? super T>predicate)
		 */
		List<String>list=new ArrayList<>();
		list.addAll(Arrays.asList("monkey","2","chimp"));
		Stream<String>infinite=Stream.generate(()->"chimp");
		Stream<String>streams=Stream.of("monkey","2","chimp");
		
		Predicate<String>pred=x->Character.isLetter(x.charAt(0));
		/*
		 * this checks the strings "monkey" "2" and "chimp" to see do they all beging
		 * with a character, they don't so this will return false
		 */
		System.out.println(list.stream().allMatch(pred));//false
		/*
		 * this checks the strings "monkey" "2" and "chimp" to seee do they all 
		 * NOT begin with a character, both "monkey" and "chimp" DO begin with a 
		 * character, so this also returns false
		 */
		System.out.println(streams.noneMatch(pred));//false and streams is now closed
		/*
		 * this checks the strings "monkey" "2" and "chimp" to see do ANY of the strings
		 * begin with a Character, both "monkey" and "chimp" do, so this will return
		 * true
		 */
		System.out.println(list.stream().anyMatch(pred));//true
		System.out.println("you can use anyMatch with an infinite stream");
		System.out.println(infinite.anyMatch(pred));//true
		infinite=Stream.generate(()->"chimp");
		/*
		 * can't answer this question as this would go on for infinity, so we have
		 * to kill the process for our code to continue
		 */
		//System.out.println(infinite.allMatch(pred));
		System.out.println(infinite.noneMatch(pred));//true
		
	//	pred=x->Character.isDigit(x.charAt(0));
		/*
		 * this will produce infinite amount strings that contain the int "2"
		 * whihc when tested against our predicate that checks to see if the first
		 * character is a letter, will return false. and if anyMatch, or NoneMach()
		 * can return false from a infinite stream, then this will contine on 
		 * forever (infinite processing)
		 */
		infinite=Stream.generate(()->"2");
		
		//System.out.println(infinite.anyMatch(pred));
	//	System.out.println(infinite.noneMatch(pred));
		/*
		 * this could be useful in GUI
		 */
		pred=x->Character.isDigit(x.charAt(0));
	}
	
	static void ex8() {
		System.out.println("***ex8");
		System.out.println("toArray()");
		
		Object[]nameArray=Stream.of("mary","kate","pat").toArray();
		
	}
	
	static void ex9() {
		System.out.println("**ex9");
		System.out.println("forEach()");
		/*
		 * forEach takes a Consumer, consumer takes a object and returns void
		 */
		Stream<String>animalStream=Stream.of("monkey","gorilla","bonobo");
		List<String>animals=new ArrayList<String>();
		animalStream.forEach(s->animals.add(s));
		animalStream=Stream.of("monkey","gorilla","bonobo");
		animalStream.forEach(animals::add);
		System.out.println("animals is "+animals);
		
		animals.stream().forEach((s)->{
			System.out.println("animal is "+s);
			System.out.println("animal lives in "+s+" house");
			/*
			 * this leads to the runtimeException 
			 * ConcurrentModificationException as you can't access
			 * a collection object by name directly inside a stream
			 */
			//animals.add(s);
			return;
		});
		/*
		 * you can call a forEach on a infinite stream and it will keep going
		 * forever
		 */
	//	Stream.generate(Animal::new).forEach((a)->System.out.println(a));
		/**
		 * FOREACH IS NOT A LOOP IN JAVA, there are forEach loops in other programming
		 * languagees
		 */
		System.out.println("forEachOrdered");
		/*
		 * this is for parallelStreams
		 * parallelStreams are much faster, if the machine your running your application
		 * on has multiple cores.
		 * you can call a forEachOrdered on a non parallel stream but it operates 
		 * exactly the same as on a parallel stream
		 */
		System.out.println("not sorted");
		
		animals.parallelStream().forEach((s)->System.out.println("not in order "+s));
		System.out.println("sorted");
		/*
		 * up to the forEachOrdered this is a parallel Stream with all the speed
		 * advantages, and from the forEachOrdered it is now a non parallel stream
		 */
		animals.parallelStream().forEachOrdered(s->System.out.println("in order "+s));
	}
	
	static void ex10() {
		System.out.println("***ex10");
		System.out.println("reduce");
		/*
		 * three overloaded methods
		 * FIRST OVERLOADED REDUCE
		 * this returns a object of type T and takes as two parameters,
		 * first paraemeter is an object of type T, and a binary operator and the
		 * binary operator takes two object of the same type T and returns one
		 * object of type T
		 * <T>  t reduce(T identity,BinaryOperator<T>accumulator)
		 * Stream<Integer>intStream=Stream.generate().
		 * limit(10).reduce(0,(n1,n2)->n1+n2);
		 */
		/*
		 * this is concatenating all the strings in the array to one string, the string 
		 * result
		 */
		System.out.println("concatnating strings with loops and arrays");
		String[]array=new String[] {"who's "," afraid "," of "," virginia", " wolf "};
		String result="";
		for(String s:array)
			result=result+s;
		System.out.println(result);
		/*
		 * the reduce takes two arguements
		 * takes a object of type T, in this case a String as first argument
		 * which is the starting point
		 * and a binaryOperator of Type T, again in this case a string, so this
		 * binary operator takes two strings and returns 1 string
		 */
		System.out.println("concatenating with Streams");
		String myString=Stream.of(array).
				/*
				 * we start with a space and end up with one string that is 
				 * " who's afraid of virginai wolf"
				 */
						reduce(" ",(s1,s2)->s1+s2);
		System.out.println(myString);
		/*
		 * SECOND OVERLOADED REDUCE
		 * Optional<T> reduce(BinaryOperator<T>Accumulator)
		 * this returns a Optional object of type T annd takes only ONE parameter, which
		 * is a BinaryOperator, takes in two object of type T and returns one object
		 * type T
		 * 
		 */
		Optional<Integer>optInt=Stream.iterate(1, n->n*10).
				limit(5).
				/*
				 * peek takes a consumer object and returns a new stream
				 * and is used for debugging (checking your code is producing the
				 * right output
				 */
				peek(System.out::println).
				reduce((n1,n2)->n1+n2);
		System.out.println(optInt.orElseGet(()->0));
		
		List<Integer>intList=new ArrayList<Integer>();
		/*
		 * this is creating 10 random numbers and adding those random numbers
		 * to the already created intList list of Integers
		 */
		System.out.println("generate 10 random numbers ");
		Stream.generate(()->(int)(Math.random()*100))
							.limit(10).
							peek(System.out::println).
							forEach((i)->{
								intList.add(i);
								}
							);
		System.out.println("treeset of ints");
		TreeSet<Integer>tInt=new TreeSet<>();
		Stream.generate(()->(int)(Math.random()*100))
				.limit(5).
				peek(System.out::println).
				forEach(
						(i)->tInt.add(i)
						);
		System.out.println("treeSet of ints is "+tInt);
		/*
		 * it's taking the treeset of random numbers and adding them all up
		 * if you want sum to be a definate value, you have to use the 
		 * reduce method that takes a Integer and a BinaryOperator<Integer>
		 */
		int sum=tInt.stream().reduce(0,(a,b)->a+b);
		System.out.println("our numbers are "+tInt);
		System.out.println("sum of which is "+sum);
		/*
		 * if you use this method, it produces an optional, so you have use
		 * orElseGet or use get in combination with a if statement or ternary operator
		 */
		Optional<Integer>optSum=tInt.stream().reduce((a,b)->a+b);
		System.out.println(optSum.orElseGet(()->0));
		/*
		 * only objects whose class implements the comparable interface can
		 * be inserted into a treeset and objects are then organised in treeset
		 * as deemed by the compareTo method, see Rat class
		 */
	//	TreeSet<Rat>ratSet=new TreeSet<>();
		/*
		 * animal does not implement Comparable, so you can't add a Animla to this
		 * set, however one of the subclasses of Animal may implement comparable
		 * so we can add subclasses to this treeSet. Badget extends Animal and
		 * implements comparable so it can be added to treeSet of Animals
		 */
	//	TreeSet<Animal>animalSet=new TreeSet<>();
	//	ratSet.add(new Rat());
		//this will give a classCastException
		//animalSet.add(new Animal());
		//this will compile fine as  badger extends Animal and implements Comparable
	//	animalSet.add(new Badger());
		List<Integer>numbers=new ArrayList<Integer>();
		Stream.
		generate(()->(int)(Math.random()*100)).
		limit(10).
		forEach(numbers::add);
		//this will multiply all the numbers in a stream
		BinaryOperator<Integer>biOp=(a,b)->a*b;
		
		Optional<Integer>total=numbers.stream().
				peek(System.out::println).
				reduce(biOp);
		System.out.println("total is "+total.get());
		//sum=0;
		sum=numbers.stream().
				peek(System.out::println).
				reduce(1,biOp);
		System.out.println("sum is again "+sum);
		/*
		 * this third overloaded reduce method is for parallelStreams, but it will
		 * work also on streams, but you don't get the savings on time if you use
		 * this with ordinary streams
		 * <U> U reduce(U indenty,
		 * 				BiFunction<U,? super T,U>,
		 * 				BinaryOperator<U>accumulator)
		 */
		sum=numbers.parallelStream().reduce(1, biOp,biOp);
		System.out.println("sum produced by parallel stream is "+sum);
		
		
	}
	
	static void ex11() {
		System.out.println("ex11***");
		System.out.println("Collect");
		/*
		 * collect is something called a "mutable reduction", it's working on the
		 * same object so it's more efficient as you are using the same mutable object
		 * there are two overloaded Collect method, that do the same thing
		 * <R> R  collect(Supplier<R> supplier,
		 * 					BiConsumer<R,? superT>,
		 * 					BiConsumer<R,R> combiner)
		 */
		StringBuilder sb=new StringBuilder("one");
		
		Stream<String>stream=Stream.of("who's "+"afraid "+"of "+" virginia"+" wolf");
		StringBuilder word=stream.collect(
				/*
				 * this is a supplier object, which sets the type R to be
				 * a stringBuidler obejct
				 */
									()->new StringBuilder(), 
									/*
									 * so a here is a StringBuilder and b is whatever
									 * type the Stream is, which is a String
									 */
									(a,b)->{
										System.out.println("a before is "+a);
										a.append(b);
										System.out.println("a is "+a);
									}
									/*
									 * this is merging two stringBuilder objects
									 * not too sure why
									 */
									, (b,c)->b.append(c));
		System.out.println(word);
		
		List<String>list2=Arrays.asList("w","o","l","f");
		/*
		 * this creates a Treeset, which orders our strings in alphabetical order
		 */
		TreeSet<String>set2=list2.stream().
				/*
				 * first arguements creates a TreeSet
				 */
									collect(()->new TreeSet<>(),
											/*
											 * that means that t is a TreeSet
											 * and S is whatever the type of stream it
											 * its, it's a stream of Strings
											 */
											(t,s)->t.add(s),
											(t1,t2)->t1.addAll(t2));
		System.out.println(set2);
		
		set2=list2.stream().collect(TreeSet::new,TreeSet::add,TreeSet::addAll);
		/*
		 * <R,A> R collect(Collector<? super T, A,R> collector)
		 */
	//	Stream<Integer>stream2=Stream.generate(()->(int)(Math.random()*100)).limit(5);
		Set<Integer>set3=Stream.generate(()->(int)(Math.random()*100))
								.limit(5)
								.collect(Collectors.toSet());
		/*
		 * this creates a TreeSet which will be populatled by the 5 random numbers
		 * and assigns this treeSEt to the variable set4
		 */
		TreeSet<Integer>set4=Stream.generate(()->(int)(Math.random()*100))
							.limit(5).
							peek(System.out::println)
							/*
							 * this creates a treeSEt of Integers and adds each 
							 * of the above numbers of the stream to the TreeSet
							 */
							.collect(Collectors.toCollection(()->new TreeSet()));
		System.out.println(set4);
		
		set4=Stream.generate(()->(int)(Math.random()*100))
				.limit(5).
				peek(System.out::println)
				/*
				 * this creates a treeSEt of Integers and adds each 
				 * of the above numbers of the stream to the TreeSet
				 * this does the EXACT same as the above
				 */
				.collect(Collectors.toCollection(TreeSet::new));
		
		List<Integer>myListStream=Stream.generate(()->(int)(Math.random()*100))
		.limit(5).
		peek(System.out::println)
		/*
		 * this creates a treeSEt of Integers and adds each 
		 * of the above numbers of the stream to the TreeSet
		 * this does the EXACT same as the above
		 */
		.collect(Collectors.toCollection(ArrayList::new));
		
		LinkedHashSet<Integer>lhsInt=Stream.generate(()->(int)(Math.random()*100))
				.limit(5).
				peek(System.out::println)
				/*
				 * this creates a treeSEt of Integers and adds each 
				 * of the above numbers of the stream to the TreeSet
				 * this does the EXACT same as the above
				 */
				.collect(Collectors.toCollection(LinkedHashSet::new));
		
		List<Integer>numbers=new ArrayList<>();
		Stream.generate(()->(int)(Math.random()*100))
		.limit(5).
		peek(System.out::println).forEach(numbers::add);
		
		
	}

}
