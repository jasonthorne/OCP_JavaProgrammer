package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.omg.Messaging.SyncScopeHelper;
/*DOUBLE COLON OPERATOR
 * ::
 * CAN BE USED 
 * a static method,
an instance method, or
a constructor.
 */
public class Examples {
	/*
	 * some methods of Collection and the Map interface and take lambda implmentations of functional interfaces. there
	 * are a number of in bulit functional interfaces in java, which will be covered in more detail in the next 
	 * chapter. here we only cover them insofar as how we would use them in conjuction with Collections or Map
	 * which is what we will be covering here.
	 */
	static void ex1() {
	
		
		/*
		 * comparator is a functional interface that has a abstract int compare(Object o,Object i)
		 * so we can also use anonymous class implementation of the Comparator interface
		 */
		Comparator<Duck>comparatorDuck=new Comparator<Duck>() {

			@Override
			public int compare(Duck arg0, Duck arg1) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};
		/*
		 * Comparabe is a functional interface that has a abstract int compareTo(Object o,object i)
		 * so here as well we can use anonymous class implementation of the Comparable interface
		 */
		Comparable<Duck>comparableDuck=new Comparable<Duck>(){

			@Override
			public int compareTo(Duck arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};
			/*
			 * the more usual way we define a Comparator is with a lambda, as Comparator is a functional interface
			 * we can use a Lambda to implement the interface
		 * DuckHelper.compareByWeight returns either minus, positive or 0, so this can be assigned to a 
		 * Comparator for Ducks
		 * rather than have all the code for sorting ducks in this lambda, we have the code to sort the ducks
		 * in DuckHelper.compareByWeight and DuckHelper.compareByName
		 */
		//lambda implementation of the compareTo() method of the Comparator function interface
		Comparator<Duck>byWeight=(d1,d2)->DuckHelper.compareByWeight(d1, d2);
		Set<Duck>dSet=new TreeSet<Duck>(byWeight);
		Duck duck1=new Duck(2,"daffy");
		Duck duck2=new Duck(3,"donald");
		Duck duck3=new Duck(1,"deirdre");
		dSet.addAll(Arrays.asList(duck1,duck2,duck3));
		System.out.println("by weight");
		System.out.println(dSet);
		/*
		 * another type of syntax can be used when you have a functional interface
		 * DuckHelper::compareByName is a method that takes two ducks, compares the names 
		 * and returns an int which is a valid implementation of the compare() method of the Comparator interface
		 * the :: operator tells java to automatically pass the parameters into compareByName
		 */
		Comparator<Duck>byName=DuckHelper::compareByName;
		dSet=new TreeSet<Duck>(byName);
		dSet.addAll(Arrays.asList(duck1,duck2,duck3));
		System.out.println("by name");
		System.out.println(dSet);
		/*
		 * you can also use these comparators with Lists, just as before
		 */
		List<Duck>duckList=new ArrayList<Duck>();
		duckList.addAll(Arrays.asList(duck1,duck2,duck3));
		System.out.println(duckList);
		Collections.sort(duckList,byName);
		System.out.println(duckList);	
	}
	
	static void ex2() {
		System.out.println("***Consumer functional interface");
		/*
		 * Consumer is a function interface that a single parameter of any type and returns void, the method is 
		 * Accept. this can be any operation performed on a object that does not return anything
		 * here type is duck so d1 is a Duck. Here we have a lambda implementing the Consumer class void accept(Object o)
		 * method with generic type Duck
		 * see manners interface which has same structure as Consumer interface
		 */
		Consumer<Duck>conDuck=(d1)->{
			System.out.println(d1);
			d1.fly();
			return;
		};
		//shortened lambda format with Integer
		Consumer<Integer>conInt=i->System.out.println("conInt called, number is "+i);
		//anonymous inner class implementation of the Consumer interface
		Consumer<Duck>conAnon=new Consumer<Duck>() {
			@Override
			public void accept(Duck d1) {
				System.out.println(d1+" accept in anonymous inner class");			
			}	
		};
		
		conDuck.accept(new Duck(1,"daffy"));
		conInt.accept(23);
		conAnon.accept(new Duck(3,"donald"));
		/*
		 * here the type is said to be a List of Integers
		 * List<Integer> and the lambda is a implementation of the accept method of the Consumer functional 
		 * interface
		 * this takes a List Object of Integer and call the Collectoin.sort metho on the list and does not
		 * return anything, so this is implemenation of the Consumer Interface method accept()
		 */
		Consumer<List<Integer>>conList=l->Collections.sort(l);
		
		List<Integer>numbers=new ArrayList<Integer>();
		numbers.addAll(Arrays.asList(34,78,999,1,23,45,120,400,2));
		System.out.println("numbers before sort");
		System.out.println(numbers);
		conList.accept(numbers);
		System.out.println("numbers after sort");
		System.out.println(numbers);
		//this simply reverses the above order
		//same as Consumer<List<Integer>ConList2=l->Collections.reverse(l);
		Consumer<List<Integer>>conList2=Collections::reverse;
		conList2.accept(numbers);
		System.out.println(numbers);
		//shuffles the numbers
		Collections.shuffle(numbers);
		System.out.println(numbers);
		
		Comparator<Integer>revStrComparator=Comparator.reverseOrder();
		//will arrange numbers in reverse order
		Consumer<List<Integer>>numbersRev=l->Collections.sort(l,revStrComparator);
		numbersRev.accept(numbers);
		System.out.println(numbers);
		
		Dog spot=new Dog(1,"spot");
		Consumer<Integer>conDog1=(i)->spot.eat(i);
		//the below is the exact same as above
		//we do not need to tell java that the eat method takes an int
			Consumer<Integer>conDog=spot::eat;
			conDog.accept(123);
	}
	
	static void ex3() {
		System.out.println("***ex3");
		System.out.println("***Supplier functional interface");
		System.out.println("get() method");
		System.out.println("takes no arguements and returns any type");
		/*
		
public interface Supplier<T>{

	public T get();
	see Behaviour interface for same interface as Supplier
		 */
		Supplier<String>mySup=()->{
			return "grand";
		};		
		/*
		 * anonymous class implementation of Supplier interface
		 */
		Supplier<Integer>myIntSup=new Supplier<Integer>() {
			@Override
			public Integer get() {
				// TODO Auto-generated method stub
				return 12;
			}		
		};
		//simpliest implemenation
		Supplier<Integer>iSup=()->4;
		mySup.get();//calls lambda
		myIntSup.get();//calls anonymous class implemnation
		iSup.get();//calls simpliest lambda
		/*
		 * supplier functional interface can be used to easily create complex objects
		 */
		Supplier<List<Integer>>supList=()->{
			List<Integer>numbers=new ArrayList<Integer>();
			//create a list of 10 random numbers between 1 and 100, there can be duplicates
			for(int i=0;i<10;i++) {
				int num=(int) (Math.random()*100);
				numbers.add(num);
			}
		//	numbers.addAll(Arrays.asList(45,67,99,12,34,1,3));
			return numbers;
		};
		//so create an arraylist of numbers we then simply go
		List<Integer>numbers=supList.get();
		System.out.println("numbers are "+numbers);
		/*
		 * this creates a treeset of 10 random numbers between 1 and 100 and each number is unique so 
		 * no dupclicates will be produced
		 */
		Supplier<TreeSet<Integer>>supSet=()->{
			TreeSet<Integer>uniqueNums=new TreeSet<Integer>();
			while(uniqueNums.size()<10) {
				int num=(int)(Math.random()*100);
				uniqueNums.add(num);
			}
				
			return uniqueNums;
		};
		Set<Integer>uniques=supSet.get();
		System.out.println("unique numbers are "+uniques);
		//as procreate is NOT a static method you can't go
	//	Supplier<Duck>supDuck=Duck::procreate;
		Duck daffy=new Duck(4,"daffy");
		Supplier<Duck>supDuck=()->new Duck(0,null).procreate();
		Supplier<Duck>supDuck2=DuckHelper::consumerDuck;
		//WE CAN CALL THE procreate method through the daffy duck object
		Supplier<Duck>supDuck3=daffy::procreate;
		
		System.out.println("***predicate function interface");
		System.out.println("predicate returns a boolean and takes a Object");
		Predicate<Duck>myPred=new Predicate<Duck>() {

			@Override
			public boolean test(Duck arg0) {
				// TODO Auto-generated method stub
				return false;
			}		
		};
		//need to work on this one a bit
		Predicate<String>predIsEmpty=(s)->s.isEmpty();
		/*
		 * can re write it in the following way, what we are effectively saying is that the method is contained 
		 * within the String class, we can do this as java knows that the type sent to the method is going to
		 * be a string (in supplier functional interface, we can't do this as 
		 * ISEMPTY IS NOT A STATIC METHOD, SO HOW DOES THIS WORK???????
		 * will cover this in next section
		 */
		Predicate<String>predIsEmpty2=String::isEmpty;
		String myStr="hello";
		//does not compile
		//Predicate<String>predIsEmpty3=myStr::isEmpty;	
	}
	
	static void ex4() {
		/*
		 * in java 8 we hav a new method called removeIf, which looks like the folowing:
		 * boolean removeIf(Predicate<? super E> filter)
		 * predicate takes any object and returns boolean, this predicate returns a boolean but it takes a predicate
		 * that can be a particular class or super class of that object, but NOT A sub class (? achieves this)
		 * i.e object is a Dog, you can sent a Dog or Animal to this predicate but NOT a Poodle
		 */
	
		List<String>list=new ArrayList<>();
		list.add("Magician");
		list.add("Assistatnt");
		list.add("Astronaut");
		list.add("Accountant");
		System.out.println(list);
		/*
		 * this will remove all strings that begin with "As"
		 * this cannot be rewritten with method references
		 */
		list.removeIf(s->s.startsWith("As"));
		System.out.println(list);
		
		Set<Dog>DogTSet=new HashSet<Dog>();
		DogTSet.addAll(Arrays.asList(new Dog(1,"spot"),new Dog(2,"spot"),new Dog(3,"lassie"),new Dog(4,"benji")));
		
		
		System.out.println(DogTSet);
		/*
		 * this will remove all dogs with the name of spot
		 */
	/*	DogTSet.removeIf((Dog d)->{
			if(d.name.equals("spot"))
				return true;
			return false;
		});*/
		//System.out.println(DogTSet);
		/*
		 * this is the same as the above but in shortened form
		 */
		
		DogTSet.removeIf(d->d.name.equals("spot"));
		System.out.println(DogTSet);
		//we will use this dog to search for the same Dog in our set of dogs and remove that dog
		Dog lassie=new Dog(3,"lassie");
		//this will remove lassie from the set of Dogs
		Predicate<Dog>removeDog=lassie::equals;
		DogTSet.removeIf(removeDog);
		System.out.println(DogTSet);	
	}
	
	static void ex5() {
		System.out.println("***ex5");
		System.out.println("updating all elements replaceAll()");
		/*
		 * this allows us to update all elements in a list and it's method signature is 
		 * void replaceAll(UnaryOperator<E> o)
		 * Unary operator is taking one parameter and returns a value of the same type, as an example this doubles 
		 * all numbers in a list of ints
		 */
		//lambda to generate a list of 10 unique random numbers between 1 and 100
		Supplier<TreeSet<Integer>>supSet=()->{
			TreeSet<Integer>uniqueNums=new TreeSet<Integer>();
			while(uniqueNums.size()<10) {
				int num=(int)(Math.random()*100);
				uniqueNums.add(num);
			}		
			return uniqueNums;
		};
		
		Set<Integer>numSet=supSet.get();
		System.out.println(numSet);
		//creates a list from our TreeSet, as replaceAll is only avaiable for Lists
		List<Integer>numList=new ArrayList<Integer>(numSet);
		System.out.println(numList);
		//takes in integer returns the integer multiplied by 2
		numList.replaceAll(x->x*2);
		System.out.println("numlist doubled "+numList);
		//this creates a List of unique integers ordered in ascending order
		numList=new ArrayList<Integer>(supSet.get());
		System.out.println(numList);
		/*
		 * can do much more complex calculations
		 */
		numList.replaceAll((x)->{
			int sum=0;
			for(int i=0;i<10;i++) {
				sum+=x;
			}
			return x+sum;
		});
		System.out.println(numList);
		
		//this converts all text to uppercase
				List<String>strList=Arrays.asList("noel","pat","mary","laura");
				System.out.println(strList);
				strList.replaceAll(s->s.toUpperCase());
				System.out.println(strList);
				//can also use this syntax
				strList.replaceAll(String::toLowerCase);
				System.out.println(strList);	
		//		strList::replaceAll;
	}
	
	static void ex6() {
		System.out.println("***ex6");
		System.out.println("Looping through a collection forEach()");
		/*
		 * forEach method is a method for List and the method structure is as follows
		 * void forEach(Consumer<? super Object>) 
		 * this method takes any object and return voide
		 */
		List<String>names=new ArrayList<String>();
		names.addAll(Arrays.asList("pat","mary","tom","shelly","colm","laura"));
		names.forEach(c->System.out.println("hello there "+c));
		
		List<Dog>kennel=new ArrayList<Dog>();
		kennel.addAll(Arrays.asList(new Dog(1,"spot"),new Dog(4,"rex"),new Dog(2,"benji"),new Dog(3,"prince")));
		kennel.forEach((d)->{
			System.out.println("hello there "+d);
			d.eat(23);
		});
		//this will take the dogs in teh list and insert them into the TreeSet, and will then be arranged by age
		Set<Dog>dogSet=new TreeSet<Dog>(kennel);
		System.out.println(dogSet);
		dogSet.forEach(System.out::println);
		
	}
	
	static void ex7() {
		/*
		 * for HashMaps we have some different methods
		 * 
		 */
		System.out.println("****ex7");
		System.out.println("putIfAbsent");
		Map<Integer,String>people=new HashMap<>();
		//will display then in value numerical ascending order
		people.put(1, "kate");
		people.put(3, "colm");
		people.put(2, "paddy");
		people.put(4, "shelly");
		System.out.println(people);
		/*
		 * when we use put() with a hashmap and insert a key value pair, and the key already exists in the map it will
		 * replace the value already there
		 * so at the second position in our hashMap we have replaced "paddy" with "tom"
		 */
		people.put(2, "Tom");
		System.out.println(people);
		/*
		 * if the key 2 does not exist, or it is a key with a null value, the key value 2-mary will be entered, 
		 * however the key 2 DOES EXIST and has a value, so this will not be entered, 
		 * putIfAbsent only puts in if the key is not there or you have a key with a null value, 
		 * whereas put will always put in a value regardless of whether the key already exists in the Map
		 * also if the value is Null in key value pair .ie
		 * 1-null

		 */
		people.putIfAbsent(2, "mary");
		
		people.put(1, "kate");
		people.put(2, null);
		people.put(3, "colm");
		people.put(4, null);
		System.out.println("people with null");
		System.out.println(people);
		for(Integer i:people.keySet()) {
			/*
			 * if a value is set to a non null value then it will not be replace
			 * both 2 and 4 are null so they will be replaced with the value "newPerson"
			 */
			people.putIfAbsent(i,"newPerson");
		}
		System.out.println(people);	
		
	}
	
	static void ex8() {
		System.out.println("***Ex8");
		System.out.println("**merge");
		System.out.println("merge uses the Bifunction function interface");
		System.out.println("merge is a way to ensure that only objects that meet certain criteria can be inserted "
				+ "into a hashMap");
		System.out.println("Bifunction");
		/*
		 * Function interface BiFunction that takes two objects and returns an object, all of these objects can be
		 * the same or different types. in this lambda, this takes two Strings and returns a String.
		 * If the length of the first String is greater than the length of the second string then return the first 
		 * string else return the second string
		 * this will return either of the strings no matter what, and if the returned strings matches what we
		 * wish to insert then it will be entered as a value
		 */
		BiFunction<String,String,String>mapper=(v1,v2)->{
			//using a ternary operator instead of a if else
			return v1.length()>v2.length()?v1:v2;	
		};
		/*
		 * this merge method uses the above BiFunction lambda which compares a new value in a key value pair with 
		 * the old value, and if the new value is a longer piece of text it will be inserted, if not, it will
		 * not be inserted
		 */
		Map<String, String>favourites=new HashMap<>();
		favourites.put("sam","skyride");
		favourites.put("tony", "rollerCoaster");
		favourites.put("patsy","bigDipper");
		favourites.put("shelly", null);
		System.out.println("before mappers ");
		System.out.println(favourites);
		//"merryGoRound" is a longer string than "skyride", so this will be added
		favourites.merge("sam", "merryGoRound", mapper);
		//"horsie" is NOT a longer string that "rollerCoaster" so this will NOT be added
		favourites.merge("tony", "horsie", mapper);
		favourites.merge("patsy","BumpingCars",mapper);//added, bumpringCar longer string value
		favourites.merge("shelly", "racingCars", mapper);//added mapper not called as shelly had null value
		//if key value pair not exist it will be added
		favourites.merge("pat","hurdyGurdy",mapper);
		System.out.println("after mappers");
		System.out.println(favourites);
		
		favourites.put("sam", null);
		favourites.put("tony", null);
		//now our hash map has two null values
		System.out.println(favourites);
		/*
		 * if BiFunction returns null then the key if found in the list is removed
		 * will insert new key value and delete old key value pairs
		 * if the mapper returns null then it will delete key value pair from
		 * the map
		 * will insert only if value is null for this key
		 * if the value we are trying to replace is null, this will be inserted
		 * if the product of this(which is null) matches what we are trying to replace, then it will be inserted
		 */
		mapper=(v1,v2)->null;//returns null and if value in key value pair is null we are trying to replace, this will be replaced
		//the key sam has a null key so the value "bike" will be added
		favourites.merge("sam", "bike", mapper);
		//the key "shelly" already has a value "racingCars" so will NOT be inserted
		favourites.merge("shelly", "goingDaftEntirely", mapper);
		//if brand new key will be inserted
		favourites.merge("mick", "flyingCars", mapper);
		System.out.println(favourites);
		/*
		 * more about BiFunction in next chapter
		 */
		BiFunction</*First arg in method*/String,
		/*second arg in method*/Integer,
		/*returning value*/
		 Double>testBi=new BiFunction<String,Integer,Double>(){
			@Override
			public Double apply(String arg0, Integer arg1) {
				// TODO Auto-generated method stub
				return null;
			}	
		};
		/*
		 * will have to work on this one a bit
		 */
		BiFunction<Dog,Dog,Dog>dogMapper=(d1,d2)->{
			if(d1.equals(d2))
				return d1;
			//Dog will only be added if it's younger
			//-means first smaller than second
			//+ means second smaller than first
			//0 means they are the same
			/*
			 * this is not a comprehensive mapper, it will only basically work if all your dogs have different
			 * ages
			 */
			if(d1.compareTo(d2)<0)
				return d1;
			return d2;
		};
		
		HashMap<Integer,Dog>mapDog=new HashMap<Integer,Dog>();
		mapDog.put(3, new Dog(3,"spot"));
		mapDog.put(2, new Dog(4,"rex"));
		//both of these dogs are older than the Dogs they are attempting to replace, so will NOT be added
		mapDog.merge(3, new Dog(6,"prince"), dogMapper);//will not be be added
		mapDog.merge(2,new Dog(7,"lady"),dogMapper);//will not be added
		System.out.println(mapDog);
		//both of these dogs are younger than the dogs they are attempting to replace, so WILL BE added
		mapDog.merge(3, new Dog(1,"spot"), dogMapper);//will be added can be same name
		mapDog.merge(2,new Dog(2,"tramp"),dogMapper);//can be added, can be different name
		System.out.println(mapDog);
			
	}
	
	static void ex9() {
		System.out.println("****computeIfPresent");
		/*computeIfPresent has two overloaded functions
		 * computeIfPresent(key, function)
		computeIfPresent(key, BiFunction)
		 * 
		 * computeIfPresent calls the BiFunction if the requested key is found
		 */
		Map<String,Integer>counts=new HashMap<>();
		counts.put("jenny", 10);
		counts.put("tony", 100);
		System.out.println(counts);
	
		/*
		 * takes in a String and an Integer and returns an Integer
		 */
		BiFunction<String,Integer,Integer>mapper2=(k,v)->v*2;
		counts.computeIfPresent("jenny", mapper2);//will return 20
		counts.computeIfPresent("tony", mapper2);//will return 100
		counts.computeIfPresent("kate",mapper2);//will return null
		//only jenny and tony in hashMap
		System.out.println(counts);
		
		int counter=0;
		Map<String,Integer>guests=new HashMap<>();
		guests.put("jack", ++counter);
		guests.put("Sarah", ++counter);
		guests.put("michael",null);
		guests.put(null, 4);
		/*
		 * Function is a functional interface that has a Apply method
		 * that takes an object and returns an object
		 */
		Function<String,Integer>mapper3=(k)->100;
		System.out.println(guests);
		/*
		 * jack already present, so not added
		 */
		guests.computeIfAbsent("jack", mapper3);
		/*
		 * michael key exists but has value of null
		 * so michael with value of 100 is inserted
		 */
		guests.computeIfAbsent("michael", mapper3);
		/*
		 * key does not exist so the key "Aidan" and value
		 * 100 is inserted
		 */
		guests.computeIfAbsent("Aidan", mapper3);
		System.out.println(guests);
		
		
	}

}
