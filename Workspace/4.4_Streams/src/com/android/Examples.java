package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
		
		

	}

	
	
}
