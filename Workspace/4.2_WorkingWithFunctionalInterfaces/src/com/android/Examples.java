package com.android;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/*
 * DOBLE COLON OPERATOR
 * 
 * ::
 * 
 * Can be used for a static method, and instance method or a constructor
 */

public class Examples {
	
	Manners<String>m1=(m)->"manners lambda m1"; //lambda from Manners interface
	
	//Manners
	
	
	static void ex1() {
		Consumer<String>consumeStr=(s)->System.out.println("s is: " + s); //(s) arg is a string, as defined by the generic bracket
		consumeStr.accept("This is my string"); //consumeStr accepts variable of type t (defined as string)
		
		
		//DOUBLE COLON EXAMPLE WITH CONSUMER +++++++++++++++++++++++++++++++++++
		
		/*
		 * Instead of using the full lambda notation you can use the :: double colon operator
		 * The right hand side sees that this is a consumer object of type string. 
		 So we can omit the (s) as it knows it takes an object of type String from the left hand side.
		 Note how you DO NOT use brackets after "println".
		 */
		Consumer<String>consumerStr = System.out::println;
		consumerStr.accept("Here is another string");
		
		//------------------------
		//DOUBLE COLON EXAMPLE WITH SUPPLIER +++++++++++++++++++++++++++++++++++
		
		/*
		 * Supplier has a method:
		 * T get(){
		 * return object of type T
		 * }
		 * 
		 * Here we are implementing the get method that takes nothing and returns a new Dog
		 */
		Supplier<Dog>supplyDog =()->new Dog();
		//this is exactly the same as the above
		supplyDog = Dog::new;
		
		supplyDog.get(); //create a dog with the consumer
		
		//--------------------------------------
		
		/*
		 * This will take nothing and return an integer:
		 */
		Supplier<Integer>supplyInt=()->new Dog().eat(); //dog method returns an int.
		supplyInt.get();
		
		Supplier<Integer>supplierInt=new Dog()::eat; //double colon operator example ++++++++++++++++++++++++++
	}
	
	
	

	static void ex2() {
		
		System.out.println("\nex2()");
		
		/*
		 * Functional interfaces sre interfaces that only have one abstract method (they can have static or defaults too)
		 * From functional interfaces we crearte lambdas. We can also create our own unctional inrterface. 
		 */
		
		/*
		 * Behaviour is a functional interface:
		 * 
		 * public interface Behaviour<T,U,V,R> {

			R happy(T t, U u, V v);
		 */
		
		//takes (T t, U u, V v) and returns R
		//Behaviour<T,U,V,R>
		Behaviour<String, Integer, List<Dog>,Double>behaveLamb;
		
		behaveLamb=(t,u,v)->{
			System.out.println("t is a: " + t.getClass().getSimpleName());
			t.charAt(0); //has all methods of the String class
			System.out.println("u is a: " + u.getClass().getSimpleName());
			u.intValue(); //has all methods of the Integer class
			System.out.println("v is a: " + v.getClass().getSimpleName());
			v.get(0); //has access to all methods of the List interface
			return 12.5;
		};
		
		behaveLamb.happy("apple", 33, Arrays.asList(new Dog(), new Dog()));
	}

	
	static void ex3() {
		//++++++++++++++++++++++++++++++++++++++++++++++++PRE DEFINED INTERFACES++++++++++++++++++++++++++++++++++++++++
		System.out.println("\nex3()");
		
		System.out.println("PRE DEFINED INTERFACES");
		
		
		//BIG COMMENT HERE (TO GET FROM MASTER COPY) ++++++++++++++++++++++++++++++++
		
		//------------------------------
		
		//SUPPLIER FUNCTIONAL INTERFACE:
		System.out.println("SUPPLIER FUNCTIONAL INTERFACE (see Employee class)");
		
		/*
		 * this is the method we will be implementing:
		 * 
		 * public T get() {
		
			return null;
		 }
		 */
		Supplier sup=()->"this can return any object as we have not defined a type";
		System.out.println(sup.get()); //call the supplier lambda
		
		//---------
		
		/*
		 * here we are supplying a type, so it produces a String reference to a String object
		 */
		Supplier<String> Stringsup=()->"string type returned from the Supplier";
		
		//This supplier object produces a string reference to a string object so you have access to all the methods of the String class.
		System.out.println(Stringsup.get().toUpperCase());
		
		//----------
		/*
		 * this is a supplier that creates an Animal with a random age between 0 & 100.
		 */
		
		int num=(int)(Math.random()*100); //+++++++++++++++++++++++++++++++++++LOOK AT THIS FOR PILOT MAKING (skill assignment during construction!)
		Supplier<Animal>animalSup=()->new Animal(num, "andy");
		
		Animal andy = animalSup.get();
		System.out.println(andy);
		
		/*
		 * Supplier's main function is for creating objects, 
		 * and in particular used in conjunction with Stream.generate, to create unlimited amount of objects
		 */
		
		//----------------------
		Supplier<LocalDate>supD1=()->LocalDate.now(); //creates a date which is todays date
		supD1=LocalDate::now;
		
		//---------------
		Supplier<Animal>animal1=()->new Animal();
		Supplier<Animal>animal2=Animal::new;
		animal1.get();
		animal2.get();
		
		//------------------------
		
		//Supplier<List<Animal>>supList1=()->new ArrayList<Animal>(); //lambda way
		//Supplier<List<Animal>>supList2::new; //double colon way
		
		List<String>names=Arrays.asList("bill", "ben", "bob");
		Supplier<List<String>>supListStr=()->new ArrayList<String>();
		supListStr.get().addAll(names);
		
		
		//===================================METHODS THAT TAKE SUPPLIER OBJECTS:
		
		//1st takeSupplier below:
		takeSupplier(animal1); //passing animal supplier to takeSupplier method below (Animal generic type)
		takeSupplier(supListStr); //(List generic type)
		takeSupplier(supD1); //(LocalDate generic type)
		
		//2nd takeSupplier below:
		takeSupplier2(animal1); //takes a Supplier of Animal generic type (or subclass)
		Supplier<Hamster>hamSup=Hamster::new;
		takeSupplier2(hamSup); //takes a subclass Supplier of Animal
		Supplier<Hamster>catSup=Hamster::new;
		takeSupplier2(catSup); //takes a subclass Supplier of Animal
		
		//3rd takeSupplier below:
		takeSupplier2(animal1); //takes a Supplier of Animal generic type (or subclass)
		
		
		//-----------------------------------
		
		Supplier<ArrayList<Cat>>catSupList=ArrayList<Cat>::new; //this supplier object is going to create an arraylist of cats 
		ArrayList<Cat>catList=catSupList.get(); //create arrayList of Cats
		
		
		Stream.generate(Cat::new).limit(10).forEach(catList::add); //generate 10 new cats and for each of them, add them to list +++++++++++++++++
		
		System.out.println(catList.size());
		
	}//end of ex3
	
	
	/*
	 * These 3 methods take supplier based objects
	 */
	
	//This can take a supplier object of ANY type, but they come in as OBJECT references to their own type 
	static<T>void takeSupplier(Supplier<T>s){ //supplier object param is called "s" <T> on method determines the type of this param
		System.out.println("take supplier method");
		s.get(); //s is passed in as an OBJECT reference to it's own type ++++++++++++++++++++++++++++
		System.out.println("This is a: " + s.get().getClass().getSimpleName());
	}
	
	//This can take a supplier object of Animals or a subclass of Animal. But they come in as ANIMAL references to their own types.
	static void takeSupplier2(Supplier<? extends Animal>s){ //can take an Animal or a class that extends Animal +++++++++++
		System.out.println("take supplier2 method");
	}
	
	//This can take a supplier object of Animals or a superclass of Animal. But they come in as ANIMAL references to their own types.
	static void takeSupplier3(Supplier<? super Animal>s){ //can take an Animal or a class that is super to Animal +++++++++++
		System.out.println("take supplier3 method");
	}
	
	
	
	static void ex4() {
		//++++++++++++++++++++++++++++++++++++++++++++++++CONSUMER FUNCTIONAL INTERFACES++++++++++++++++++++++++++++++++++++++++
		System.out.println("\nex4()");
		
		System.out.println("CONSUMER FUNCTIONAL INTERFACES - See Astronought for class implementation");
		
		/*
		 * Can be used when an object needs to be "consumed" without returning any result (ie a sysout)
		 */
		
		//simplest form of consumer. 
		//This takes an object OF ANY TYPE, and doesn't return anything. 
		Consumer c1=(x)->System.out.println("simple consumer lambda: " + x);
		c1.accept(new Animal(3, "andy")); //x will be an object reference to an Animal
		c1.accept("yo dawg"); //x will be an object reference to a String
		
		
		//these 2 are tje exact same. They both print out a string
		Consumer<String>conStr=(str)->System.out.println(str); //lambda version
		Consumer<String>conStr2=System.out::println; //double colon version
		
		conStr.accept("Here is my string to printout"); //using consumer defined above
		
		//---------------------------------
		
		//consumer object that takes an Animal:
		Consumer<Animal>conAnimal=(andy)->{ //consumes object, then does stuff to said object
			System.out.println("conAnimal consumer called");
			System.out.println(andy);
			andy.drink();
			andy.eat("meat");
			//andy=new Animal();
		};
		
		conAnimal.accept(new Animal(5, "angela")); //passing new animal to consumer.
		
		//consumer creates objects here that cannot be accessed once run (as they vanish once run)
		conAnimal.accept(new Animal((int)(Math.random()*100), "andy"));
		
		
		
		//======================================
		
		Animal andy = new Animal(23, "andy");
		
		//conusmer takes a string (s1) which is passed into andy.eat()
		Consumer<String>conEatStr=(s1)->andy.eat(s1);
		Consumer<String>conEatStr2=andy::eat; //double colon shorthand version of above++++++++++++
		
		conEatStr.accept("apple"); //call Consumer, which calls andy.eat, passing in "apple"
		conEatStr.accept("beef"); //call Consumer, which calls andy.eat, passing in "apple"
		
		
		//----------------
		
		Consumer<StringBuilder>conStrBuilder=(sb)->{
			sb.append("dawg");
		};
		
		StringBuilder mySb = new StringBuilder("Yo ");
		
		
		
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++EXAM QUESTION A:+++++++++++++++++++++++++++
		
		Consumer<List<Integer>>conIntList=(a1)->System.out.println("arraylist created: " + a1); //create consumer obj
		
		//call consumer method below, passing in consumer obj and list
		//calling it's accept on it, which prints arraylist passed
		//create a new consumer (myT) and making it simple print whats passed to it
		//The myT that's returned then has it's .accept() called, which prints the list being passed to it.
		takeConsumer(conIntList, Arrays.asList(10,100,1000)).accept(Arrays.asList(23,45,67,345));
	}
	
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++EXAM QUESTION METHOD A:+++++++++++++++++++++++++++
	
	//returns a consumer obj of type T, and takes a consumer obj of type T, and an object of type T.
	//The consumer obj that's sent to the method will determine what T will be.
	static <T>Consumer <T>takeConsumer(Consumer<T>t, T t2){
		t.accept(t2);
		Consumer<T>myT=(a1)->System.out.println(a1);
		return myT;
	}
			
			
	static void ex5() {
		//++++++++++++++++++++++++++++++++++++++++++++++++BI CONSUMER++++++++++++++++++++++++++++++++++++++++
		System.out.println("\nex5()");
		
		System.out.println("BI CONSUMER - See accountant class");
		
		//bi consumer without a generic type:
		BiConsumer b1 = (bc1, bc2)->System.out.println("biConsumer called: " + bc1+ "bcr obj is: " + bc2.getClass().getSimpleName());
		
		b1.accept(new ArrayList<Integer>(Arrays.asList(23,44,55,66)), 1000);
		
		//-------------------------------
		
		BiConsumer<String, Integer>b2=(s1, i1)->System.out.println("string is: " + s1 + " number is: " + i1);
		b2.accept("yo dawg", 333);
		
		//========================================Bi consumer with MAP
		
		//hashmap with a key (0which has to be unique, and a string value -
		Map<Integer, String>myMap=new HashMap<Integer, String>();
		
		myMap.put(1, "harry");
		myMap.put(2, "mary");
		myMap.put(3, "shelly");
		System.out.println(myMap);
		
		//this biConsumer takes an int and string then inputs the int as a key and the string as a value in the hashmap:
		BiConsumer<Integer, String>biPutMap=(k, v)->myMap.put(k, v); //lambda version
		
		BiConsumer<Integer, String>biPutMap2=myMap::put; //double colon version
		
		biPutMap.accept(5, "donald");
		biPutMap2.accept(10, "douglas");
		
		System.out.println(myMap);
		
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++EXAM QUESTION B:+++++++++++++++++++++++++++
		takeBiConsumer(biPutMap, 333);
	
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++EXAM QUESTION METHOD B:+++++++++++++++++++++++++++
	
	static<T,R>BiConsumer<R,R>takeBiConsumer(BiConsumer<T,R>b, T t){ //return value can be of T OR R ++++++++++++++++++++++++++
		BiConsumer<R,R>myBi=(r,r2)->System.out.println("r is: " + r + "r2 is: " + r2);
		///myBi.accept(t, b); //wong!! :P
		return myBi;
	}
	
	
	
	static void ex6() {
		//++++++++++++++++++++++++++++++++++++++++++++++++PREDICATE++++++++++++++++++++++++++++++++++++++++
		System.out.println("\nex6()");
		
		System.out.println("PREDICATE");
		
		//returns boolean, takes any object. 
		
		Predicate<Integer>p1=(i)->i>18; //return true if i is 18 or greater
		
		//call predicate:
		System.out.println(p1.test(12)); 
		System.out.println(p1.test(18));
		System.out.println(p1.test(3));
		System.out.println(p1.test(20));
		
		//---------------------------------
		
		Predicate<Animal>animalPred=a1->{
			return a1.age>0;
		};
		
		Animal andy = new Animal(0, "andy");
		Animal angela = new Animal(-2, "angela");
		Animal aidan = new Animal(3, "aiden");
		System.out.println("\n"+animalPred.test(andy));
		System.out.println(animalPred.test(angela));
		System.out.println(animalPred.test(aidan));
		
	}
	
	
	static void ex7() {
		//++++++++++++++++++++++++++++++++++++++++++++++++BI-PREDICATE++++++++++++++++++++++++++++++++++++++++
		System.out.println("\nex7()");
		
		System.out.println("BI-PREDICATE");
		
		/*
		 * Takes 2 objects of any type and returns a boolean.
		 * The objects can be of the same type, or different types. 
		 */
		
		
		//Here we create a predicate that will check to see if someone is over 18 and a valid human sex. Male or Female:
		BiPredicate<Integer, String>biPred=(in, st)->{
			if(in<18) {
				System.out.println("under 18 years of age");
				return false;
			}
			if(!(st.equalsIgnoreCase("male")|| st.equalsIgnoreCase("female"))) {
				System.out.println("incorrect gender entered");
				return false;
			}
			return true;
		};
		
		System.out.println("biPred: " + biPred.test(18, "male"));
		System.out.println("biPred: " + biPred.test(36, "FEMALE"));
		
		//-----------------------
		//this takes 2 strings & checks to see if the first string begins with the second string +++++++++++++++++++++MIGHT USE THIS DURING TEMP MAP MODEL FILL
		BiPredicate<String, String>b1=(str,prefix)->str.startsWith(prefix);
		System.out.println(".startsWith: " + b1.test("chicken", "chick"));
		System.out.println(".startsWith: " + b1.test("chicken", "hen"));
		
		//----------------------//double colon version of above:
		BiPredicate<String, String>b2=String::startsWith;
	
	}
	
	
	
	static void ex8() {
		//++++++++++++++++++++++++++++++++++++++++++++++++FUNCTION++++++++++++++++++++++++++++++++++++++++
		System.out.println("\nex8()");
		
		System.out.println("FUNCTION");
		
		/*
		 * function takes an object and returns an object. They can be the same type or a different type. 
		 */
		
		//takes any object and returns an object reference to it as a string 
		Function myFunction=o1 -> o1 +" hello";
		
		System.out.println(myFunction.apply("myString"));
		System.out.println(myFunction.apply(333));
		System.out.println(myFunction.apply(LocalDate.now()));
		
		
		//-------------------
		//return type of Integer and parameter of Integer
		Function<Integer, Integer>fSame=in->in*2; //takes in a number and multiples it by 2
		System.out.println(fSame.apply(12));
		
		//-------------
		//takes in a String and an Integer and returns the length of the string
		Function<String,Integer>f1=x->x.length();
		Function<String,Integer>f2=String::length; //double colon version
		
		System.out.println(f1.apply("sup"));
		System.out.println(f1.apply("Supercalifragilisticexpialidocious"));
		
		
		//-------------
		
		/*
		 * A function lambda that returns an Animal and takes an Integer.
		 * The integer is used to vcreate the animal that's returned. 
		 */
		Function<Integer, Animal>animalFunction=(in)->{
			System.out.println("Animal function lambda");
			return new Animal(in, "andy");
		};
		
		animalFunction.apply(12);
		
		
		//-----------------------------
		//call static below:
		
		
		/*
		 * this method take a function lambda which in our case is a function lambda with type of Integer and Animal. 
		 * This means that the second variable type here HAS to be an Integer, and the 3rd variable type has to be an Animal.
		 */
		takeFunction(animalFunction, 12, new Animal());
		
	}
	
	static<T,R> void takeFunction(Function<T,R>f1, T t, R r) {
		System.out.println("t is a: " + t.getClass().getSimpleName());
		System.out.println("r is a: " + r.getClass().getSimpleName());
		f1.apply(t);
	}
	
	
	static void ex9() {
		//++++++++++++++++++++++++++++++++++++++++++++++++BI-FUNCTION++++++++++++++++++++++++++++++++++++++++
		System.out.println("\nex9()");
		
		System.out.println("BI-FUNCTION");
		
		/*
		 * Takes 3 types, has 2 params and one return type.
		 * They can all be the same type or all different types, or combinations.
		 */
		
		System.out.println("BiFunction with all the same types");
		//takes 2 strings and returns a string. 
		BiFunction<String, String, String>b1 = (string, toAdd)->string.concat(toAdd); //takes 2 strings and concatenates them together
		BiFunction<String, String, String>b2 = String::concat; //double colon version +++++++++++++
		
		//calling above biFunctions:
		System.out.println(b1.apply("hello", " nice to meet you"));
		System.out.println(b1.apply("sup", " dawg!"));
		
		
		//-----------------------------------------
		/*
		 * This takes in an integer and a string and returns an animal.
		 * Here it takes in an integer and string and uses both to construct a new Animal with this integer and string. 
		 */
		BiFunction<Integer, String, Animal>createAnimal1=(in, str)-> new Animal(in, str);
		
		//short form verison:
		BiFunction<Integer, String, Animal>createAnimal2=Animal::new; //calls the constructor in the Animal class that takes an int and a String ++++++++++++++
		
		System.out.println(createAnimal2.apply(12, "angela"));
		
		//-------------
		//call takeBiFunction() below:
		takeBiFunction(createAnimal2, 12, "bob", new Animal(2, null));
		
	
	}
	
	//R is return type. Gets sent T & V.
	static<T,V,R> R takeBiFunction(BiFunction<T,V,R>bif, T t, V v, R r) {
		r=bif.apply(t, v);
		System.out.println(r.getClass().getSimpleName() + " has been created");
		System.out.println(r);
		return r;
	}
	
	

	static void ex10() {
		//++++++++++++++++++++++++++++++++++++++++++++++++UNARY OPERATOR++++++++++++++++++++++++++++++++++++++++
		System.out.println("\nex10()");
		
		System.out.println("UNARY OPERATOR");
		
		//This takes an Object and returns an Object of the SAME TYPE
		//Takes in an Animal, returns an Animal
		
		//this takes in a string and returns the uppercase version of that string. 
		UnaryOperator<String>u1 = str->str.toUpperCase(); //only ONE type needed declaring here, as both arg and return val must be of the same type. ++++++++++
		UnaryOperator<String>u2 = String::toUpperCase; //double colon version
		
		System.out.println(u1.apply("bob"));
		System.out.println(u1.apply("cuthbert"));
		
		
		//-----------------------------
		
		UnaryOperator<Animal>unAnimal=(a1)->new Animal(4, "bill"); //takes in an Animal and returns an Animal
		UnaryOperator<Animal>unModifyAnimal=(a1)->{
			a1.age=a1.age*2; //double the age of the animal
			a1.name = a1.name + " smith"; //change name of animal
			return a1;
		};
		
		//call method above:
		Animal myAnimal=new Animal(10, "frank"); //create animal
		System.out.println(unModifyAnimal.apply(myAnimal)); //call unary operator lambda obj. changing age and name
		
		//------------------------
		
		//call method below:
		takeUnary(unModifyAnimal, myAnimal);
		
	}
	
	//unary operator method +++++++
	static<T> T takeUnary(UnaryOperator<T>myU, T t) {
		return myU.apply(t);
	}
	
	
	
	
	
	
}


class Dog{
	
	Dog() {
		System.out.println("Dog created");
	}
	
	int eat() {
		System.out.println("Dog eat method that returns an int");
		return 0;
	}
}

















@FunctionalInterface
interface Manners<T>{
	T sad(T t);
}