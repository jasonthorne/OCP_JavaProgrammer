package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
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
		//++++++++++++++++++++++++++++++++++++++++++++++GENERATE +++++++++++++++++++++++++++++++++++++++++++++++++++++
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
		 * limit is an INTERMEDIATE operation that doesn't run until the stream hits a TERMINAL operation. 
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
	
	
	static void ex4() {
		
		//++++++++++++++++++++++++++++++EFFECTIVELY CLOSED +++++++++++++++++++++++++++++++++++++++
		
		/*
		 * Each intermediate operation on a stream creates a new stream and effectively closes the stream it is operating on.
		 */
		
		
		System.out.println("\nex4()");
		
		//supplier object:
		Supplier<Animal>supAnimal=()->{
			int num = (int)(Math.random()*100);
			return new Animal(num, "Andy"); //generate an Animal with a random age between 1 and 100
		};
		
		//create stream from supplier object:
		Stream<Animal>randAnimal=Stream.generate(supAnimal); //////produces stream A
		
		//limit to 20
		randAnimal.limit(20); //////produces stream B (which EFFECTIVELY CLOSES stream A)
		
		//filter those 20 where age > 20
		//randAnimal.filter(a->a.age>20); //falls over because stream A is effectively closed (as it's already been operated on)
		
	
		///randAnimal.forEach(System.out::println); //falls over as well as stream A is effectively closed
		
		
		//---------------------
		
		
		
		//redefine randAnimal
		randAnimal=Stream.generate(supAnimal); //////produces stream A (assigned to randAnimal) 
		randAnimal= randAnimal.filter(a->a.age>20); ///produces stream B (assigned to randAnimal) 
		randAnimal= randAnimal.limit(5);  ///produces stream c (assigned to randAnimal) 
		System.out.println("print 5 animals:");
		
		randAnimal.forEach(System.out::println); //this is calling stream C
		System.out.println();
		
		//shorthand of above:
		Stream.generate(supAnimal).filter(a->a.age>20).limit(5).forEach(System.out::println); 
		
		
		//-------------
		
		/*
		 * You cant assign the below code to anything as the final method call is what determines what the line of code as a whole returns.
		 * forEach returns VOID, so this CANNOT BE assigned to any variable.
		 */
		
		Stream.generate(supAnimal).filter(a->a.age>20).limit(5).forEach(System.out::println);
		
		//answer to above problem: 
		List<Animal>animals = new ArrayList<Animal>(); //list for storing animals from stream
		
		Stream.generate(supAnimal).filter(a->a.age>20).limit(5).forEach((a->{
			System.out.println(a);
			animals.add(a); //add amimal to list
		}));
		
	}
	
	
	static void ex5() {
		
		//++++++++++++++++++++++++++++++OTHER TERMINAL OPERATIONS +++++++++++++++++++++++++++++++++++++++
		
		System.out.println("\nex5()");
		
		
		//=====================================COUNT
		
		/*
		 * Reductions are a special type of terminal operation where all the objects created by the stream are combined into a single value
		 */
		
		//COUNT - counts the amount of objects in a stream and it returns a long. 
		//count is a REDUCTION
		//count is a TERMINAL OPERATION
		
		Stream<Integer>numStream=Stream.generate(()->(int)(Math.random()*100)).limit(15);
		System.out.println("amount of objects created: " + numStream.count());
		
		/*
		 * Terminal operation executes the code and closes the stream
		 */
		
		//random numbers (0-99),limited to 20, and filtered  by number is > 50:
		numStream=Stream.generate(()->(int)(Math.random()*100)).limit(20).filter((i)->i>50);
		
		//numbers are created here and this closes the last stream: 
		System.out.println(numStream.count()); //.count RETURNS A LONG (so can't be tacked onto the end of above line)
		
		
		//=====================================MIN & MAX
		
		/*
		 * Min method signiature looks like the following:
		 * 
		 *  Optional<T>min(<? super T>comparator)
		 *  
		 *  Has to be optional as if dealing with an infinite stream, then there is no max or min. 
		 */
		
		numStream=Stream.of(234,56,11,2,6,99);
		
		//This produces an infinite amount of integers, so thee is no max or min: 
		//Stream.iterate(2, n->n+2).forEach(System.out::println);
		/*
		 * Min takes a comparator which is an interface that only has one abstract method inside it: <T>long compare(T t1, T t2)
		 * Below we take in 2 ints n1 & n2 
		 * and use the compareTo method of the Integer class that takes an Integer in this case and compares it with the Integer calling the method.
		 * The integer class implements the comparable interface, and compareTo is a method of the Comparable interface. 
		 */
		
		//==================comparator:
		//Comparator<Integer>compInt=(n1,n2)->n1.compareTo(n2);
		
		//---------
		//taking in a comparator (that takes in 2 objects and returns whichever is deemed to be the target value)
		Optional<Integer>mini=numStream.min((n1,n2)->n1.compareTo(n2));
		System.out.println("minimum number is: " + mini.get());
		
		//alternative shorthand version of above:
		numStream=Stream.of(234,56,11,2,6,99); //reset stream first!! 
		mini=numStream.min((n1,n2)->n1-n2);
		System.out.println("minimum number (alt shorter version) is: " + mini.get());
		
		//--------MAX:
		
		Optional<Integer>maxi=Stream.of(234,56,11,2,6,99).max((n1,n2)->n1.compareTo(n2));
		System.out.println("maxi is: " + maxi.get());
		
		//alternative shorthand version of above:
		maxi=Stream.of(234,56,11,2,6,99).max((n1,n2)->n1-n2);
		System.out.println("maxi (alt shorter version) is: " + maxi.get());
		
		
		//=============================================
		//Another example:
		
		//supplier object:
		Supplier<Animal>supAnimal=()->{
			int num = (int)(Math.random()*100);
			return new Animal(num, "Andy"); //generate an Animal with a random age between 1 and 100
		};
		
		
		System.out.println();
		List<Animal>zoo = new ArrayList<Animal>();
		//below produces 10 animals that are added to the list of animals called zoo
		Stream.generate(supAnimal).limit(5).forEach((a)->{
			zoo.add(a);
			System.out.println(a);
		});
		
		System.out.println("\nanimal with max age is: " + zoo.stream().max((a1,a2)->a1.age-a2.age).get());
		
		//Can't use compareTo with Animal as Animal hasnt implemented the Comparable Interface.
		System.out.println(zoo.stream().min((a1,a2)->a1.age-a2.age).get());
		
		
		
		//=============================================
		//IMPLEMENTING THE COMAPRE METHOD:
		
		Rat r1= new Rat(12,"Bob", 3.3);
		Rat r2= new Rat(5,"Frank", 33.3);
		Rat r3= new Rat(7,"Cuthbert", 3.33);
		Rat r4= new Rat(5,"SPG", 3.33);
		Rat r5= new Rat(5,"SPG", 333.33);
		
		List<Rat>ratList = new ArrayList<>(Arrays.asList(r1,r2,r3,r4,r5));
		
		System.out.println("minimun rat: " + ratList.stream().min((rat1,rat2)->rat1.compareTo(rat2)).get()); //.get() is returning the actual object as these are OPTIONALS +++++++++++
		System.out.println("maximun rat: " + ratList.stream().max((rat1,rat2)->rat1.compareTo(rat2)).get());
		
		
		//-----------
		
		Set<String>setStr=new HashSet<>();
		
		//Sets remove duplicates so only one apple is added to this set:
		setStr.addAll(Arrays.asList("orange","apple","banana","apple", "pineapple"));
		
		System.out.println(setStr);
		System.out.println(setStr.stream().min((s1,s2)->s1.compareTo(s2)).get()); //using stream to find minimum string
		
		
	}
	
	
	static void ex6() {
		
		//++++++++++++++++++++++++++++++FIND ANY +++++++++++++++++++++++++++++++++++++++
		
		System.out.println("\nex6()");
		
		/*
		 * Will display if there is any element in a stream. It doesnt take any variables. but it returns an option.
		 * It is a terminal operator. But it is not a reduction, a it doesnt not reduce a stream to a single value, and returns an option. 
		 */
		
		Stream<String>apes=Stream.of("monkey", "gorilla", "orangitang");
		
		apes.findAny().ifPresent((s)->System.out.println("ape is: " + s)); //Returns the first instance 
		//shorthand version:
		//apes.findAny().ifPresent(System.out::println);
		
		//----------
		
		apes=Stream.empty(); //empty stream
		apes.findAny().ifPresent(System.out::println); //prints nothing as stream is empty
		//------------
		
		//oe else will return a string no matter what. 
		apes=Stream.empty(); //empty stream
		
		System.out.println(apes.findAny().orElseGet(()->{
			System.out.println("no monkey");
			return "chimp"; //if there is no string in the apes stream than this will return a chimp
		}));
		
		//------------
		
		//redefine steam:
		apes=Stream.of("monkey", "gorilla", "orangitang");
		
		//this NOW returns "monkey"
		System.out.println(apes.findAny().orElseGet(()->{
			System.out.println("no monkey");
			return "chimp"; //if there is no string in the apes stream than this will return a chimp
		}));
		
		//----------------
		
		//redefine steam:
		apes=Stream.of("monkey", "gorilla", "orangitang");
		
		//this will check if the stream is empty or not:
		System.out.println(apes.findAny().isPresent()); //returns true
		
		//----------------
	
		Stream<Integer>infinateNums=Stream.generate(()->(int)(Math.random()*100));
		System.out.println(infinateNums.findAny().get());
		
		
		//++++++++++++++++++++++++++++++FIND FRST +++++++++++++++++++++++++++++++++++++++
		
		/*
		 * Returns an optional. Hasto be optional as this may be an empty string.
		 */
		
		ArrayList<Animal>listAnimal=new ArrayList<Animal>();
		Stream.generate(()->new Animal()).limit(5).forEach((a)->{
			System.out.println("animal " + a + "is added to the arraylist");
			listAnimal.add(a);
		});
		
		System.out.println(listAnimal);
		System.out.println(listAnimal.stream().findFirst().orElseGet(null));
		
		
	}
	
	
	static void ex7() {
		
		//++++++++++++++++++++++++++++++TERMINAL OPERATIONS - anyMatch(), allMatch(), noneMatch() +++++++++++++++++++++++++++++++++++++++
		
		System.out.println("\nex7()");
		
		System.out.println("TERMINAL OPERATIONS - anyMatch(), allMatch(), noneMatch()");
	
		//anyMatch()
		
		//If any item in a stream matches what this predicate is looking for, this will return true (i.e looking for ANY dog with the name of "spot")
		/*
		 * boolean anyMatch(Predicate<? super T> predicate)
		 *
		 */
		
		//allMatch()
		
		/*
		 * If ALL items in a stream match what this predicate is looking for, this will return true (i.e are ALL dogs in a stream called "spot")
		 */
		/*
		 * boolean allMatch(Predicate<? super T> predicate)
		 *
		 */
		
		//noneMatch()
		/*
		 * If NO items in a stream match what this predicate is looking for, this will return true (i.e are NO dogs in a stream called "spot")
		 */
		/*
		 * boolean allMatch(Predicate<? super T> predicate)
		 *
		 */
		
		
		//-------------examples:
		
		List<String>list=Arrays.asList("monkey", "2", "chimp");
		Stream<String>infinite=Stream.generate(()->"chimp");
		Stream<String>streams=Stream.of("monkey", "2", "chimp");
		
		Predicate<String>pred=x->Character.isLetter(x.charAt(0));
		
		//allMatch()
		//checks if ALL entries in the list contain characters. they dont, so this will return false ++++++++++++++++++++++
		System.out.println(list.stream().allMatch(pred)); //false
		
		
		//noneMatch()
		//checks if all strings in the list do NOT begin with a character. 2 do, so this will return false ++++++++++++++++
		System.out.println(streams.noneMatch(pred)); //false, and streams is now closed. 
		
		
		//anyMatch()
		//checks if ANY of the strings in the list begin with a character. 2 do, so this will return true ++++++++++++++++
		System.out.println(list.stream().anyMatch(pred)); //true
		
		//You CAN USE anyMatch with an infinite stream //+++++++++++++++++++++++++++++++
		System.out.println(infinite.anyMatch(pred));
		infinite=Stream.generate(()->"chimp");
		
		
		//You CANT answer allMatch as it would go on indefinitely so wont ever give answer:
		//System.out.println(infinite.allMatch(pred));
		
		
		//none match wont work
		System.out.println(infinite.noneMatch(pred)); //false

	}
	
	
	
	static void ex8() {
		
		//++++++++++++++++++++++++++++++To Array() +++++++++++++++++++++++++++++++++++++++
		
		System.out.println("\nex8()");
	
		Stream<String>names=Stream.of("bill", "bob", "cuthbert");
		
		//String[]nameArray=names.toArray();
		
	
	}
	
	
	static void ex9() {
		
		//++++++++++++++++++++++++++++++FOR EACH() +++++++++++++++++++++++++++++++++++++++
		
		System.out.println("\nex9()");
	
		
		/*
		 * forEach takes a consumer (a consumer takes an object and returns void)
		 */
		
		Stream<String>animalStream = Stream.of("monkey", "gorilla", "bonobo");
		
		List<String>animals=new ArrayList<String>();
		
		animalStream.forEach((s)->animals.add(s)); //for each 
		
		animalStream = Stream.of("monkey", "gorilla", "bonobo"); //reset stream
		
		animalStream.forEach(animals::add); //shortened version of for each 
		
		System.out.println("animals is: " + animals);
		
		//-------------
		
		animals.stream().forEach((s)->{
			System.out.println("animal is: " + s);
			System.out.println("animal lives in a " + s + " house");

			//this leads to a ConcurrentModificationExcpetion as you cant access a collection object by name directly inside a string:
			//animals.add(s);
		});
		
		
		/**
		 * FOREACH IS NOT A LOOP IN JAVA
		 */
		
		//++++++++++++++++++++++++++++++FOR EACH() ORDERED +++++++++++++++++++++++++++++++++++++++
		
		//This is for parallel streams
		
		//this creates a 2nd paralel stream, and runs it alongside the original:
		animals.parallelStream().forEach((s)->System.out.println("not in order " + s));
		
		//this creates a parallel stream, but runs them one after the other, in ordered format 
		animals.parallelStream().forEachOrdered((s)->System.out.println("in order " + s));
		
		/*
		 * You can call a forEach ordered on a nonparallel stream, but it operates exactly the sme as on a parallel stream.
		 */
		
	}
	
	
	
	static void ex10() {
		
		//++++++++++++++++++++++++++++++REDUCE +++++++++++++++++++++++++++++++++++++++
		
		System.out.println("\nex10");
		
		/*
		 * Three overloaded methods:
		 * 
		 *FIRST OVERLOADED REDUCE:
		 *
		 * this returns an object of type t, and takes 2 parameters:
		 * first is an object Type t, and a binary operator,
		 * and the binary operator takes 2 objects of the same type T and returns one object of type T. 
		 * <T> t reduce (T identity, BinaryOperator<T>accumulator)
		 * 
		 * Stream<Integer>intStream=Stream.generate().limit(10).reduce(0,(n1,n2)->n1+n2);
		 * 
		 * SECOND OVERLOADED REDUCE:
		 * 
		 * Optional<T> reduce(BinaryOperator<T>Accumulator)
		 * 
		 * This returns an optional object of type T and takes only ONE parameter, which is a binaryOperator,
		 * a binary operator takes in 2 objects of type t and returns one object of type t. 
		 * 
		 */
		
		Optional<Integer>optInt=Stream.iterate(1, n->n*10).limit(5).peek(System.out::println).reduce((n1, n2)->n1+n2);
		System.out.println(optInt.get());
	
	
	}
	
	
	
	
}
