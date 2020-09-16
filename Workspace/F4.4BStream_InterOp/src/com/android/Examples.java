package com.android;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * common intermediate operations
 * these DO NOT run the code, the code does not run until it hits an 
 * TERMINAL operation.
 * the list is as follows
 * filter(),
 * map(),
 * flatMap(),
 * distinct(),
 * sorted()
 * peek(),
 * limit(),
 * skip()
 */
public class Examples {
	
	static void ex1() {
		System.out.println("***filter");
		/*
		 * returns a stream with elements that match a given expression
		 * takes an arguments a Predicate
		 * Stream<T> filter(Predicate<? super T>predicate)
		 */
		List<String>apeList=new ArrayList<String>();
		/*
		 * will only return those strings that begin with the letter "m" and 
		 * then using a forEact add them to an existing arrayList apeList (
		 * the consumer lambda can only access apeList if it is final 
		 * or effectively final
		 */
		Stream<String>apes=Stream.of("monkey","gorilla","bonobo","marmot");
		apes.filter(s->s.startsWith("m")).
			forEach((s)->{
				System.out.println(s);
				/*
				 * if apeList is not final or effectively final this will
				 * generate a error
				 */
				apeList.add(s);
			});
		System.out.println("apeList is "+apeList);
		/*
		 * if we uncomment this line then apeList is no longer effectively final, so
		 * we will NOT be able to access it inside the forEach consumer lambda
		 */
		//apeList=new ArrayList<>();
		apes=Stream.of("monkey","gorilla","bonobo","marmot");
		/*
		 * this filters our list and creates a new arraylist from this
		 * which we CAN change and assign a different value too outside of the Stream
		 */
		List<String>newList=apes.filter(s->s.startsWith("m")).
				collect(Collectors.toCollection(ArrayList::new));
		System.out.println(newList);
		newList.add("macaque");
		newList=new ArrayList<>();
	//	int num=(int)(Math.random()*100);
		/*
		 * this is creating random dates between 1 and 100 days from todays date
		 */
		TreeSet<LocalDate>dateStream=Stream.generate(()->LocalDate.now().plusDays(random())).
				//limits to 10, code  not run yet
							limit(10).
							//just prints out the dates, code not run yet
							peek(System.out::println)
							/*
							 * filters to only dates no more than 20 days in the future
							 * code not run yet
							 */
							.filter(d->d.isBefore(LocalDate.now().plusDays(20))).
							/*
							 * a terminal operation that runs the code and saves the 
							 * dates no more than 20 days in the future to a new 
							 * TreeSet
							 */
							collect(Collectors.toCollection(TreeSet::new));
		System.out.println("dateStream is "+dateStream);
	}
	
	static int random() {
		return (int)(Math.random()*100);
	}
	
	static void ex2() {
		System.out.println("Distinct");
		/*
		 * is an intermediate operations and returns a stream without duplicate values, it uses the 
		 * equals method to determine what values are equal
		 */
		Stream<String>disStr=Stream.of("duck","duck","duck","goose");
		//this creates an arrayList of distinct strings
		List<String>listStr=disStr.distinct().collect(Collectors.toCollection(ArrayList::new));
		disStr=Stream.of("duck","duck","duck","goose");
		TreeSet<String>setStr=disStr.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(listStr);
		System.out.println(setStr);
		/*
		 * we have overriden the equals method of the Cat class, so those cats with the same age and weight
		 * will be same to be the same
		 */
		Cat cat1=new Cat(1,2);
		Cat cat2=new Cat(3,4);
		Cat cat3=new Cat(3,4);
		Cat cat4=cat1;
		/*
		 * only two cats are produced as both cat2 and cat3 have the same age and weight, and cat4 is the
		 * same cat as cat1
		 */
		Stream.of(cat1,cat2,cat3,cat4).
		distinct().
		forEach(System.out::println);//prints out only two cats
		/*
		 * this will produce a 100 random numbers, between 0 and 100(but not include 100), we have have said
		 * they will be distinct, so this means you will get all the possible numbers.
		 * we then save them to a treeSet, which will organise them in ascending numeric order
		 * 0,1,2
		 */
		TreeSet<Integer>intSet=Stream.generate(()->(int)(Math.random()*100)).
								distinct().
								limit(100).
								collect(Collectors.toCollection(TreeSet::new));
		System.out.println(intSet);
		/*
		 * this generates 6 numbers from a pool of numbers 1 to 47 inclusive
		 */
		List<Integer>lotto=Stream.generate(()->(int)(Math.random()*100)).
				//ensures no number greater than 48 or less than 1 is produced
									filter(i->i<48 & i>0).
									//ensures all unique
									distinct().
									//limits it to 6
									limit(6).
									collect(Collectors.toList());
		System.out.println("the lotto numbers are "+lotto);
		
				
		System.out.println("this should print out");
	}
	
	static void ex3() {
		System.out.println("***skip");
		/*
		 * intermediate operation that returns a stream and takes an int and simply skips that amount
		 * of items
		 * you have a stream of 10 items
		 * and you go
		 * myStream.skip(5)
		 * this will skip the first 5 objects
		 */
		//creates an infinite stream that begins at 2 and increments by 2, will print out all even numbers
		Stream<Integer>intStream=Stream.iterate(2, n->n+2);
		//this will skip the first four ints (2,4,6,8) and print out the next four in the series (10,12,14,16)
		intStream.skip(4).limit(4).forEach(System.out::println);
		intStream=Stream.iterate(2, n->n+2);
		/*
		 * here this limits our infinite stream to the first four Integers of 2,4,6,8, however we next skip
		 * those same four Integers, which means we now have a empty stream
		 */
		intStream.limit(4).skip(4).forEach(System.out::println);
		System.out.println("limit and skipping");
		intStream=Stream.iterate(2, n->n+2);
		intStream.
		skip(15).//skip first 15 numbers
		limit(10).//takes the next 10 numbers
		filter(i->i%10==0).limit(10).//uses only the numbers that are divisible by 10
		forEach(System.out::println);//will print only two numbers 40 and 50
		System.out.println("limit and skip 10 numbers");

		intStream=Stream.iterate(2, n->n+2);
		intStream.
		skip(15).//skip first 15 numbers, goes up to 30
		filter(i->i%10==0)//only numbers divisible by 10 are allowed, so this producdes 40, 50,60, etc
		.limit(10).//limit to 10 numbers, which will be 40,50,60,70,80,90,100,110,120,130
		forEach(System.out::println);//
		
	}
	
	static void ex4() {
		System.out.println("***map");
		/*
		 * Map translates a stream of a certain type into a stream of another type
		 * <R> Stream<R> map(Function<T,R>mapper)
		 * i.e we are taking in a stream of Strings and returning a stream of Integers
		 * R would be a Integer, T would be a String
		 */
		List<String>apes=new ArrayList<>();
		apes.addAll(Arrays.asList("monkey","gorilla","bonobo","marmot"));
		List<Integer>apeInt=apes.stream().
				/*
				 * this takes in a string, which will be "monkey", "gorilla", "bonobo" and "marmot"
				 * and returns the length of each string, which is a Integer. so this Map method
				 * takes in a stream of Strings and returns a Stream of Integers
				 */
						map(x->x.length()).
						collect(Collectors.toList());
		System.out.println(apeInt);
		
		apeInt=apes.stream().
				/*
				 * this takes in a stream of strings and returns a stream of Integers, which will be 
				 * the hashcode method of each string in the stream
				 */
				map(x->x.hashCode()).
				collect(Collectors.toList());
		System.out.println("print out the Ape");
		apes.stream().map(x->x.concat(" the Ape")).forEach(System.out::println);
		
		Dog dog1=new Dog(2,12);
		Dog dog2=new Dog(3,10);
		Dog dog3=new Dog(1,5);
		Dog dog4=new Dog(1,5);
		
		Stream<Dog>dogStream=Stream.of(dog1,dog2,dog3);
		/*
		 * this takes a stream of Dogs and produces a stream of Cats, the method of the Dog class makeCat
		 * returns a Cat with the same age and name as the Dog
		 * after the map method, you now have a stream of Cats, so every method after map() is operating
		 * on a stream of Cats
		 */
		List<Cat>catList=dogStream.map(d->d.makeCat())//up to this point you are dealing with a stream of Dogs
				/*
				 * after this point you are dealing with a stream of Cats
				 */
				.distinct().
				collect(Collectors.toList());
		System.out.println(catList);
		/*
		 * Map allows you to convert a stream of one object type to be ANY other object type
		 * it can also take in stream of objects and return the a stream objects of the same type
		 */
		/*
		 * takes stream of INtegers and returns a stream of doubles
		 */
		Stream.generate(()->(int)(Math.random()*1000)+1).//between 1 and 1000 inclusive
							map(x->x.doubleValue()).//this is a stream of infinite doubles between 1 and 1000.0
							distinct().
							limit(5).
							forEach(System.out::println);
		/*
		 * takes a stream of Doubles and returns a STream of Integers
		 */
		Stream.generate(()->(Math.random()*1000)+1).//between 1 and 1000 inclusive
		map(x->x.intValue()).
		distinct().
		limit(5).
		forEach(System.out::println);	
	}
	
	static void ex5() {
		System.out.println("flatmap");
		/*
		 * flattening in computer usually means changing from complex to basic, Flatmap is usually used
		 * to take a number of Collection objects or Streams and flatten them to one collection object or
		 * one stream
		 * three lists of Integers flattened to become one list of Integers
		 * three TreeSets of Strings flattened to become Treeset of Strings
		 * three Streams of LocalDates to become one Stream of LocalDates
		 */
		List<String>zero=Arrays.asList();
		List<String>one=Arrays.asList("bonobo","chimp","organ utang");
		List<String>two=Arrays.asList("Mammy Gorilla","baby Gorilla","boomer","king kong");
		
		System.out.println(zero+" "+one+" "+two);
		two.stream().forEach(System.out::println);
		/*
		 * this produces a 
		 */
		List<List<String>>myList=
				/*
				 * this produces NOT a stream of Strings, but a stream of LISTS of Strings
				 * so any operation on this stream after this point, is operating on a stream of 
				 * Lists
				 */
				Stream.of(zero,one,two).
				collect(Collectors.toList());
		/*
		 * what flatMap does is puts all the strings into one stream of  Strings, it flattens out the
		 * lists of Strings
		 */
		System.out.println("our flatMap****");
		Stream.of(zero,one,two).
		/*
		 * zero,one and two are List of Strings, so l is each one of these lists
		 * each one of these lists will return a stream of strings, all these streams of Strings are then
		 * concatenated into one stream of Strings
		 */
		flatMap(l->l.stream()).//this is now a stream of Strings of all the strings in all our lists
		peek((s)->System.out.println("ape is "+s)).
		filter(s->s.startsWith("b")).//count();
		forEach(System.out::println);
		/*
		 * this produces a list of Strings that are our three lists of Strings flattened out to become one Stream
		 * from which we create a list of STrings that contains all of our apes.
		 */
		List<String>apeList=Stream.of(zero,one,two).
							flatMap(l->l.stream()).
							collect(Collectors.toList());
		System.out.println(apeList);
		
		Stream<Integer>s1=Stream.of(2);
		Stream<Integer>s2=Stream.iterate(1, n->n+2).limit(5);//this will produce the numbers 1,3,5,7,9
		Stream<Integer>s3=Stream.generate(()->(int)(Math.random()*100)+1).limit(4);//will produce 4 random numbers between 1 and 100 inclusive
		
		System.out.println(s1+""+s2+""+s3);
		/*
		 * this takes three streams of Strings that are flattened out to become one stream of Strings, which we then print out
		 */
		Stream.of(s1,s2,s3).flatMap(s->s).forEach(System.out::println);
		
		List<Integer>intList=Stream.iterate(1, n->n+2).limit(5).collect(Collectors.toList());
		/*
		 * you can use flatMap with different data types, here we have a List of Integers and list of STrings, 
		 * which we flatten and this produces a stream of Objects
		 */
		System.out.println("of differing types");
		//this is a stream of Objects
		Stream.of(intList,apeList).//stream of Lists of Objects
		peek(l->System.out.println(l.getClass())).
		flatMap(l->l.stream()).//this is a stream of Objects
		peek((l)->System.out.println(l.getClass())).
		forEach(System.out::println);
		
		
	}
	
	static void ex6() {
		System.out.println("***sorted");
		/*
		 * this returns the stream with the elements sorted
		 * only streams that contain objects that have implmeneted the Comparable interface can use this method 
		 * OR have a comparator defined for objects of the class
		 * there are two overloaded sorted methods
		 * Stream<T> sorted(), only classes that implement the Comparable interface can use this overloaded sorted method
		 * Stream<T> sorted(Comparator<? super T> comparator)
		 */
		System.out.println("built in classes that use sorted ");
		Stream<String>animals=Stream.of("dog","anteater","bear","cat");
		/*
		 * this will sort the strings in they're natural order, non numeric first, then numeric, then uppercase, then 
		 * lower case alphabetical
		 */
		animals.sorted().forEach(System.out::println);
		System.out.println("in reverse order");
		animals=Stream.of("dog","anteater","bear","cat");
		/*
		 * this is the second overloaded sorted method that takes a comparator, a comparator is a seperate object of Type
		 * comparator, which we use to sort a list of objects, that  usually do not themselves implement the comparable interface.
		 * however here String class does implement the comparable, but we are using a seperate comparator to sort the 
		 * strings in reverse order.
		 */
		animals.sorted(Comparator.reverseOrder()).
		forEach(System.out::println);
		
		System.out.println("our Employees");
		Employee emp1=new Employee(44,"eddie");
		Employee emp2=new Employee(34,"edel");
		Employee emp3=new Employee(23,"etna");
		Stream<Employee>empStream=Stream.of(emp1,emp2,emp3);
		/*
		 * if a stream is made up ofr objects that do NOT implement the comparable interface or DO NOT have a comparator then
		 * you cannot use the stream sorted() method.
		 * this generates the runtimeException ClassCastException
		 */
	//	empStream.sorted().forEach(System.out::println);
		
		System.out.println("our CAts");
		Cat tibbles=new Cat(1,2);
		Cat harry=new Cat(1,1);
		Cat mary=new Cat(2,2);
		Cat kate=new Cat(2,1);
		/*
		 * this will generate a classCast eXCeption as Cat does not implmenet comparable and we don't yet have a 
		 * comparator for Cat
		 */
	/*	Stream.of(tibbles,harry,mary,kate)
		.sorted().
		forEach(System.out::println);;*/
		
		Comparator<Cat>catComparator=new Comparator<Cat>() {

			@Override
			public int compare(Cat c1, Cat c2) {
				/*
				 * this will be a minus number if first get is greater that second cat
				 * will be a plus number if second cat is greater than first cat
				 * and 0 if both cats are the same
				 */
				int result;
				//if they are NOT the same, according to the equals method of the Cat clas
				if(!c1.equals(c2)) {
					result=c1.age-c2.age;
					if(result!=0)
						return result;
					return c1.weight-c2.weight;
				}
				return 0;
			}	
		};
		System.out.println("using the Cat comparator");
		
		Stream.of(tibbles,harry,mary,kate,mary).
		sorted(catComparator).
		forEach(System.out::println);
		//this will remove duplicates
		System.out.println("removing duplicates");
		Stream.of(tibbles,harry,mary,kate,mary).
		sorted(catComparator).distinct().
		forEach(System.out::println);
		/*
		 * sets will also remove duplicates and as we  used the catComparator, this is going to be exactly the same
		 * as a TreeSet of Cats
		 */
		Set<Cat>catSet=Stream.of(tibbles,harry,mary,kate,mary).
				sorted(catComparator).collect(Collectors.toSet());
		System.out.println("unique set of cat "+catSet);
		
		System.out.println("Dogs");
		Dog spot=new Dog(1,2);
		Dog rex=new Dog(1,1);
		Dog prince=new Dog(2,2);
		Dog benji=new Dog(2,1);
		/*
		 * the Dog class implements the comparable interface, so we can use the no arguements sorted() method
		 */
		Stream.of(spot,rex,prince,benji).
		sorted().
		forEach(System.out::println);
	}
	
	static void ex7() {
		System.out.println("peek");
		/*
		 * peek allows us to look at the stream and is not a terminal operation like forEach()
		 * Stream<T> peek(Consumer<? super T> action)
		 * a peek() does NOT close your stream, it returns a stream, so you can call other stream operations on the stream
		 */
		Stream<String>stream=Stream.of("orange","apple","carrot","cabbage");
		//forEach is a terminal operation, it returns void, so you can't call any other stream operaions on this stream
		stream.forEach(System.out::println);
		
		//see end of file for Animal and Cow class
		Stream<Cow>cowStream=Stream.of(new Cow(),new Cow(),new Cow());
		//peek is a intermediate operaion and needs a terminal operation to run
		cowStream.peek((Cow a)->{
			System.out.println("this can take a super class of Cow");
			a.run();
			a.milk();
		}).count();//peek will not run without a terminal operaiton, such as count()
		
		Stream<Animal>animalStream=Stream.of(new Animal(),new Cow(),new Animal(),new Cow());
		animalStream.peek(
				(a)->
					{
						System.out.println(a);
						a.run();
				//		a.milk();
						}
					)
		.count();
		System.out.println("does nothing");
		/*
		 * there is not terminal operation in this stream, so the code will never run
		 * also peek produces a new stream that is NOT assigned to anything so this statement is liable for garbage collection
		 * as soon as it is created
		 */
		Stream.of("orange","apple","carrot","cabbage").//creates a stream
		filter(s->s.startsWith("c")).//intermediate operation, closes previous stream, creates new stream
		peek(System.out::println);//intermediate operation, closes previous stream, creates new stream
		System.out.println("this code runs");
		long count=	Stream.of("orange","apple","carrot","cabbage").//creates a stream
					filter(s->s.startsWith("c")).//intermediate operation, closes previous stream, creates new stream
					peek(System.out::println).//intermediate operation, closes previous stream, creates new stream
					count();//this a terminal operation, causes the code to run returns a long and closes the stream
		
		System.out.println("amount of strings is "+count);
		
		Stream<Integer>numList=Stream.generate(()->(int)(Math.random()*100)).
								distinct().
								limit(50);
		/*
		 * this will only produce 10 numbers as the first peak has the potential to produce 50 numbers, but we then limit
		 * to 20, and the next peek has the potential to produce 20 numbers, but we then limit to 10. So the code only runs
		 * when we get to the terminal operation count() and at this point, our stream is limited to producing 10 numbers
		 */
		count=numList.peek((n)->System.out.println("number is "+n)).//potential to print out 50 numbers
					limit(20).//limit it to 20 numbers
					peek((n)->System.out.println("second batch of numbeers is "+n)).//potential to print out 20 numbers
					limit(10).//limit to 10 numbers 
					count();//will print out 10
		
		System.out.println("amount of numbers is "+count);
		/*
		 * peek is really only supposed to be used when debugging code, it should not really be changinng the code
		 */
		System.out.println("bad peek code");
	/*	Stream.generate(()->(int)(Math.random()*100)).
		limit(5).
		peek((n)->{
			System.out.println("n is "+n);
		}).*/
		/*
		 * this is considered BAD peek code, as peek is only for checking your values, NOT changing them
		 */
	/*	peek(
				(n)->{
					n=n*2;
					System.out.println("double n is "+n);
		//	return;
		}).forEach(System.out::println);*/
		
		Employee emp1=new Employee(2,"eddie");
		Employee emp2=new Employee(3,"edel");
		Employee emp3=new Employee(4,"etna");
		Employee emp4=new Employee(6,"edgar");
		/*
		 * this is a stream of existing employees with all different ages
		 */
		Stream<Employee>empList=Stream.of(emp1,emp2,emp3,emp4);
		/*
		 * here the peek changes all the ages of all the existing employees to 20
		 */
		empList.peek(e->{
		e.setAge(20);	
		}).forEach(System.out::println);
		
		System.out.println("this is also bad peek code as we are doubling the age of the Employees generated in a peek");
		System.out.println(emp1);
		System.out.println("generating employees and printing them out");
		Stream.generate(()->{
			int num=(int)(Math.random()*100);
			return new Employee(num,"ed");
		}).limit(5).
		peek(System.out::println).
		peek((e)->{
			e.setAge(e.getAge()*2);
			System.out.println("new age is "+e.getAge());
		}).
		forEach((e)->{
			System.out.println("final age is "+e.getAge());
		});
		
		
		
		
	}
	
	
	

}

class Animal{
	void run() {
		
	}
}

class Cow extends Animal{
	void milk() {
		
	}
}
