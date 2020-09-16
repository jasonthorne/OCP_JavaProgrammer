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
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;


/*
 * DOUBLE COLON OPERATOR
 * ::
 * can be used for a static method
 * a instance method
 * or a constructor
 */
public class Examples {
	
	static void ex1() {
		String myString="orange";
		Consumer<String>consumeStr=(s)->{
			System.out.println("s is "+s);
			System.out.println(s.length());
			System.out.println(s.charAt(0));
		};
		consumeStr.accept(myString);
		/*
		 * this takes in a string and then prints out the string
		 */
		consumeStr=(s)->System.out.println(s);
		consumeStr.accept("this is my string");
		/*
		 * instead of using the full lambda notation you can use the ::
		 * double colon operator. the right hand side sees that this is a 
		 * consumer object of type String so we can omit the 
		 * (S), as it knows it takes an object of type String from the left 
		 * hand side
		 * note how you DO NOT use brackets after "println"
		 */
		Consumer<String>consumerStr=System.out::println;
		consumerStr.accept("here is another String");
		/*
		 * supplier has a method 
		 * T get(){
		 * return object of type T
		 * }
		 * here we are implementing the get method that takes nothing and 
		 * returns a new Dog
		 */
		Supplier<Dog>supplyDog=()->new Dog();
		//this is exactly the same as the above
		Supplier<Dog>supplierDog=Dog::new;
		
		supplyDog=()->{
			System.out.println("supplyDog redefined");
			return new Dog();
		};
		supplyDog.get();
		supplierDog.get();
		Dog spot=new Dog();
		/*
		 * this will take nothing and return an Integer
		 */
		System.out.println("using double colon to call instance method");
		Supplier<Integer>supplyInt=()->spot.eat();
		supplyInt.get();
		Supplier<Integer>supplierInt=spot::eat;
		
	}
	


static void ex2() {
	/*
	 * Functional interface are interfaces that only have one abstract method
	 * (they can have many static and default methods)
	 * from functional interface we can create lambdas, we can also create our own
	 * functional interface (see behaviour for own functional interfaces
	 */
	/*
	 * Behaviour is a functional interface
	 *  * public interface Behaviour<T,U,V,R> {
				R happy(T t, U u, V v);
		so we can create a lambda that implements this interface
	 */
	Behaviour<String,Integer,List<Dog>,Double>behaveLamb;
	behaveLamb=(t,u,v)->{
		System.out.println("t is a "+t.getClass().getSimpleName());
		t.charAt(0);//has access to all methods of the String class
		System.out.println("u is a "+u.getClass().getSimpleName());
		u.intValue();//has access to all methods of Integer class
		System.out.println("v is a "+v.getClass().getSimpleName());
		System.out.println(v.get(0));//has access to all methods of the List interface
		return 12.5;
	};//end of lambda
	
	behaveLamb.happy("apple", 34, Arrays.asList(new Dog(),new Dog()));
}

static void ex3() {
	/*
	 * Java 8 introduced lambdas and functional interfaces. there are many built 
	 * in functional interfaces, some of 
	 * which we have already seen in the previous chapter when we were dealing with 
	 * Collections and Maps
	 * For exam purposes we only deal with certain functional interfaces, 
	 * and all of them use generic types, which
	 * uses the following syntax
	 * first generic will be T, second generic type will be U if distinct 
	 * (different) return type we use 
	 * R
	 * the following functional interfaces that are covered by this exam are the following:
	 * Supplier<T> no parameters return type T, method T get()//see Employee class
	 * Consumer<T> 1 parameter, return type void, method void accept(T t)//see Astronaut
	 * BiConsumer<T,U> 2 parameters, return type void, method void accept(T t, U u)//see accountant
	 * Predicate<T> 1 parameter, return type boolean, method boolean test(T t)//
	 * BiPredicate<T,U> 2 parameters T U,return type boolean, method boolean test(T t, U u)//see Carpenter
	 * Function<T,R> 1 parameter T, return type R, method R apply(T t)//see Doorman
	 * BiFunction<T,U,R> 2 parameters T U, return type R, method R apply(T t, U u)//see electrician
	 * UnaryOperator<T> 1 parameter T, return type T, method T apply(T t)//see fireman
	 * BinaryOperator<T> 2 parameters T T, return type T methog T apply(T t T t2)//see Gp
	 */
	System.out.println("Supplier Functional Interface");
	System.out.println("See employee class");
	/*
	 * this is the method we will be implementing
	 * public T get() {
		
		return object of type T;
		/*
		 * this is what the functional interface supplier looks like
		 */
		/* @FunctionalInterface public class Supplier<T>{
			 *  	public T get();
			 *  }*/
	Supplier sup=()->"this can retun any object as we have not defined a type";
	System.out.println(sup.get());
	/*
	 * here we are supplying a type so the it produces a STring reference to a 
	 * STring object
	 */
	Supplier<String>strSup=()->"string type returned from the Supplier";
	/*
	 * this supplier object produces a string reference to a string object so you have
	 * access to all the methods of the STring class
	 */
	System.out.println(strSup.get().toUpperCase());
	/*
	 * this is a supplier that creates a Animal with a random age between 0 and 100
	 */
	int num=(int)(Math.random()*100);
	Supplier<Animal>animalSup=()->new Animal(num,"andy");
	Animal andy=animalSup.get();
	System.out.println(andy);
	/*
	 * Suppliers main function is for creating objects and in particular used in
	 * conjunction with the Stream.generate to create unlimtied amounts of objects
	 */
	Supplier<LocalDate>supD1=()->LocalDate.now();
	supD1=LocalDate::now;
	//only at this point is the LocalDate object created
	System.out.println(supD1.get());
	
	Supplier<Animal>a1=()->new Animal();
	a1=Animal::new;
	//animal only created at this point
	a1.get();
	//both the same
	Supplier<List<Animal>>supList=()->new ArrayList<Animal>();
	supList=ArrayList::new;
	//arrayList only created at this point
	supList.get();
	List<String>names=Arrays.asList("noel","mary","pat","sean","sarah");
	Supplier<List<String>>supListStr=()->new ArrayList<String>();
	supListStr.get().addAll(names);
	
	takeSupplier(a1);//using Animal generic type
	takeSupplier(supList);//using List generic type
	takeSupplier(supD1);//using localDate generic type
	
	takeSupplier2(a1);//can take animal generic supplier
	//hamster is not created here
	Supplier<Hamster>hamSup=Hamster::new;
	//not created here, it is created in teh takeSupplier2 method
	takeSupplier(hamSup);
	Supplier<Cat>catSup=Cat::new;
	takeSupplier(catSup);
	/*
	 * this can take a supplier object with a Animal or a superclass of Animal
	 */
	takeSupplier3(a1);//can take animal supplier object
	/*
	 *can't take a supplier object created with a Hamster or Cat
	 *these two will not compile
	 */
	//takeSupplier3(hamSup);
	//takeSupplier3(catSup);
	
	Supplier<ArrayList<Cat>>catSupList=ArrayList<Cat>::new;
	//this is the same as the above line
	catSupList=()->new ArrayList<Cat>();
	ArrayList<Cat>catList=catSupList.get();
	//this produces 10 cats that are added to out catList
	Stream.generate(Cat::new).limit(10).forEach(catList::add);
	//this also produces 10 cats taht are added to our catlist
	Stream.generate(()->new Cat()).limit(10).forEach((myCat)->catList.add(myCat));
	System.out.println(catList.size());
	}//end of ex3

/*
 * these three methods takes supplier based objects
 */
	static<T>void takeSupplier(Supplier<T>s){
		System.out.println("takeSupplier method");
		s.get();
		System.out.println("this is a a "+s.get().getClass().getSimpleName());
	}
	/*
	 * this can take a supplier object of Animals or one of it's subclasses of Cats or 
	 * Hamsters
	 */
	static void takeSupplier2(Supplier<? extends Animal>s) {
		System.out.println("takeSupplier2 method called");
		//have access to methods of Animal class
		s.get().drink();
	}
	/*
	 * this can take a supplier with a super class of Animal type or Animal type, but
	 * NOT a Hamster or Cat
	 */
	static void takeSupplier3(Supplier<? super Animal>s) {
		System.out.println("takeSupplier3 method called");
		//have no access to methods of Animal class
		s.get().getClass().getSimpleName();
		
	}
	
	static void ex4() {
		System.out.println("ex4");
		System.out.println("Consumer functional interface");
		//see Astronaut for class implementation of the consumer interface
		/*
		 *  *  * @FunctionalInterface public interface Consumer<T>{
		 * 		void accept(T t);
		 * }
		 */
		/*
		 * can be used when a object needs to be "consumed" without returning any
		 * result (input,printing out an object)
		 */
		//takes an object of any type and prints it out, but returns NOTHING
		Consumer c1=x->System.out.println("simple consumer lambda "+x);
	//	c1=x->"hello there ";
		c1.accept(new Animal(3,"andy"));//x will bea Object reference to Animal
		c1.accept("hello there");//x will be a object refrence to a String
		//these two are the EXACT SAME, they both print out the string
		Consumer<String>conStr=(str)->System.out.println(str);
		conStr=System.out::println;
		conStr.accept("here is my String to print out");
		/*
		 * here we have a consumer that allows our Animal to call all the methods
		 * of the Animal
		 * so Consumer allows an object to do things (or call all its' methods)
		 */
		Consumer<Animal>conAnimal=(a1)->{
			System.out.println("conAnimal Consumer called");
			System.out.println(a1);
			a1.drink();
			a1.eat("meat");
		};
		//this will call teh drink and eat method for angela
		conAnimal.accept(new Animal(5,"angela"));
		//consumer creates objects here that cannot be accessed once run
		conAnimal.accept(new Animal((int)(Math.random()*100),"andy"));
		
		Animal andy=new Animal(23,"andy");
		/*
		 * t
		 */
		Consumer<String>conEatStr=s1->andy.eat(s1);
		Consumer<String>conEatStr2=andy::eat;
		conEatStr.accept("apple");
		conEatStr2.accept("beef");
		/*
		 * this consumer can only takes a stringBuilder object
		 * it then appends the word "new String" onto our stringBuilder object and
		 * prints out this newly amended stringbuilder object
		 */
		Consumer<StringBuilder>conStrBuilder=sb1->{
			sb1.append("new String");
			System.out.println(sb1);
		};
		StringBuilder mySb=new StringBuilder(" my Stringbuilder object");
		
		conStrBuilder.accept(mySb);
		conStrBuilder.accept(new StringBuilder("stringbuilder object2 "));
		
		Consumer<List<Integer>>conIntList=a1->System.out.println("arrayList created "+a1);
		System.out.println("our exam question");
		/*
		 * TakeConsumer takes a Consumer of type T, in this case we said the type is
		 * an arrayList of Integers, and a object of type T, which in this case will be
		 * a ArrayList of Integers
		 * inside the takeConsumer method we call the conIntList consumer lambda with the
		 * line t.accept(t2)
		 * we then create a new consumer object of type ArrayLIst of Integers and 
		 * print that out and return that consumer object. which then calls the 
		 * consumer object accept method inside the takeConsumer object, which is
		 * this line of code
		 * Consumer<T>myT=(al)->System.out.println(al);
		 */
		takeConsumer(conIntList,Arrays.asList(10,100,1000)).
		accept(Arrays.asList(23,45,67,345));
			
	}
	/*
	 * this method takes two parameters a consumer object of type T (which can be any
	 * type and the consumer object that is sent to the method is what determines 
	 * what T will be
	 * second variable is a variable of type T
	 * and this returns a consumer object that is using the same data type as the 
	 * consumer that was sent to this method
	 * i.e
	 * send this consumer object
	 * Consumer<String>conStr
	 * takeConsumer(conStr,"hello")
	 * 
	 */
	static <T> Consumer<T> takeConsumer(Consumer<T>t,T t2){
		t.accept(t2);
		Consumer<T>myT=(al)->System.out.println(al);
		return myT;
	}
	
	static void ex5() {
		System.out.println("***ex5");
		System.out.println("***BiConsumer");//see accountant class
		 /*returns void like the Consumer function interface but takes two objects, can be same type or different types
		  *  @FunctionalInterface public interface BiConsumer<T,U>
		 * 		void accept(T t,U u);
		 * }
		  */
		/*
		 * as more than on parameter have to put brackets around them
		 * biConsumer takes two objects and returns void
		 */
		BiConsumer b1=(bc1,bc2)->System.out.println("biConsumer called "+bc1+" bc2 "
				+ "objects is a "+bc2.getClass().getSimpleName());
		
		b1.accept(new ArrayList<Integer>(Arrays.asList(45,67,88,99)), 1000);
		
		BiConsumer<String,Integer>b2=(s1,i1)->System.out.println("string is "
		+s1+" number is "+i1);
		b2.accept("hello there", 999);
		/*
		 * this is a hashMap with a Integer key (which has to be unique)
		 * and a string value (does not have to unique)
		 */
		Map<Integer,String>myMap=new HashMap<Integer,String>();
		myMap.put(1, "harry");
		myMap.put(2, "mary");
		myMap.put(3, "shelly");
		System.out.println(myMap);
		/*
		 * this biConsumer takes a Integer and a string and then inputs this
		 * Integer as a key and the string as a value in the hashMap
		 */
		BiConsumer<Integer,String>biPutMap=(k,v)->myMap.put(k, v);
		BiConsumer<Integer,String>biPutMap2=myMap::put;
		biPutMap.accept(5, "laura");
		biPutMap2.accept(7, "colm");
		System.out.println(myMap);
		takeBiConsumer(biPutMap,"hello");
	}
	/*
	 * this takes a BiConsumer object of type T and R and a object of Type T
	 * in our case it takes a BiConsumer object of type Integer and String
	 * and a object of type Integer and returns a BiCosumer object with a type
	 * of String and String
	 */
	static<T,R> BiConsumer<R,R> takeBiConsumer(BiConsumer<T,R>b,R r){
		System.out.println("takeBiConsumer called");
		BiConsumer<R,R>myBi=(r1,r2)->System.out.println("r is "+r1+" r2 is "+r2);
		myBi.accept(r, r);
		return myBi;	
	}
	
	static void ex6() {
		System.out.println("ex6");
		System.out.println("predicate ");
		/*
		 * @FunctionalInterface public interface Predicate<T> {
				boolean test(T t);
			}
		returns boolean takes any object
		 */
		Predicate<Integer>p1=i->i>=18;
		System.out.println(p1.test(12));//false
		System.out.println(p1.test(19));//true
		System.out.println(p1.test(18));//true
		Predicate<Animal>animalPred=a1->{
			return a1.age>0;
		};
		Animal andy=new Animal(0,"andy");
		Animal angela=new Animal(-2,"angela");
		Animal aidan=new Animal(3,"aidan");
		System.out.println(animalPred.test(andy));
		System.out.println(animalPred.test(angela));
		System.out.println(animalPred.test(aidan));
	}
	
	static void ex7() {
		System.out.println("***ex7");
		System.out.println("BiPredicate");
		/*
		 * takes two objects of any type and returns a boolean, the two objects can be the same type
		 * or a different type
		 * * @FunctionalInterface public interface BiPredicate<T, U> {
				boolean test(T t, U u);
			}
		 * 
		 */
		/*
		 * here we create a predicate taht will check to see if someone is over 18 and a 
		 * valid human sex (male or female), if doing this in real life i would create a enum called
		 * "Sex" which would have the values "MALE" and "FEMALE"
		 */
		BiPredicate<Integer,String>biPred=(in,st)->{
			if(in<18) {
				System.out.println("under 18 years of age");
				return false;
			}
			if(!(st.equalsIgnoreCase("male")||st.equalsIgnoreCase("female")||st.equalsIgnoreCase("other"))) {
				System.out.println("incorrect gender entered");
				return false;	
			}
			return true;
		};//end of biPredicate
		
		System.out.println(biPred.test(18,"MALE"));
		System.out.println(biPred.test(19, "female"));
		System.out.println(biPred.test(34, "ma1e"));
		/*
		 * this takes two strings, and it checks to see if the first string begins with the second string
		 */
		BiPredicate<String,String>b1=(str,prefix)->str.startsWith(prefix);
		System.out.println(b1.test("chicken", "chick"));//true
		System.out.println(b1.test("chicken", "cd"));//false
		System.out.println(b1.test("chick", "chicken"));//true
		//this biPredicate does the same thing as the above BiPredicate
		BiPredicate<String,String>b2=String::startsWith;	
	}
	
	static void ex8() {
		System.out.println("*****ex8");
		System.out.println("function");
		/*
		 * @FunctionalInterface public interface Function<T, R> {
				R apply(T t);
			}
			*/
	 /*
	  * function takes an object and returns an object, they can be the same type or a different
	  * type
	  */
		Function myFunction=o1->o1+" hello";
		System.out.println(myFunction.apply("my String "));
		System.out.println(myFunction.apply(23));
		System.out.println(myFunction.apply(LocalDate.now()));
		System.out.println("function with same parameter and return type");
		/*
		 * return type of Integer, parameter of Integer
		 */
		Function<Integer,Integer>fSame=in->in*2;
		System.out.println(fSame.apply(12));
		/*
		 * this takes a String and returns an Integer
		 * takes the string and returns the length of the String
		 */
		Function<String,Integer>f1=x->x.length();
		Function<String,Integer>f2=String::length;
		System.out.println(f1.apply("hello"));//
		System.out.println(f2.apply("expeditionary"));//13
		//will return nullPointer exception as you can't call a method on a null object
		//System.out.println(f1.apply(null));	
		/*
		 * this is a function lambda that returns an Animal and takes an 
		 * Integer, the integer is used to create the Animal that is returned
		 */
		Function<Integer,Animal>animalFunction=(in)->{
			System.out.println("animalFunction lambda");
			return new Animal(in,"andy");
		};
		
		System.out.println(animalFunction.apply(12));
		/*
		 * this method takes a Function lambda, which in our case is a function lambda
		 * with type of Integer and Animal. this means that the second variable 
		 * type here HAS to be a Integer
		 * and the third vaariable tyep HAS TO be a Animal
		 */
		takeFunction(animalFunction,12,new Animal());
	}
	
	static<T,R> void takeFunction(Function<T,R>f1, T t, R r) {
		System.out.println("t is a "+t.getClass().getSimpleName());
		System.out.println("r is a "+r.getClass().getSimpleName());
		f1.apply(t);
	}
	
	static void ex9() {
		System.out.println("***ex9");
		System.out.println("BiFunction");
		 /*@FunctionalInterface public interface BiFunction<T, U, R> {
		R apply(T t, U u);
	}
 */
		/*
		 * BiFunction takes three types, has two parameters and one return type. they
		 * can all be the same type, or all different types, or combinations 
		 * both these lambdas take two strings and returns one string that is the
		 * two strings added together
		 */
		System.out.println("BiFunction will all the same types");
		BiFunction<String,String,String>b1=(string,toAdd)->string.concat(toAdd);
		BiFunction<String,String,String>b2=String::concat;
		System.out.println(b1.apply("hello", " nice to meet you"));
		System.out.println(b2.apply("hello", " how are you"));
		/*
		 * this takes in a Integer and a String and returns a Animal
		 * here it takes in an integer and String, and uses both to construct a new
		 * Animal with this integer and String
		 */
		BiFunction<Integer,String,Animal>createAnimal=(in,str)->new Animal(in,str);
		/*
		 * this will do the same as the above and it will call the constructor in
		 * the Animal class that takes a int and a string. IF WE HAVE NO constructor
		 * in the Animal class that takes a int and a string, then this code WILL NOT
		 * compile
		 */
		BiFunction<Integer,String,Animal>createAnimal2=Animal::new;
		
		System.out.println(createAnimal2.apply(12, "angela"));
		System.out.println("takeBiFunction");
		takeBiFunction(createAnimal2,12,"aidan",new Animal(2,"annie"));
	}
	
	static<T,V,R> R takeBiFunction(BiFunction<T,V,R>biF, T t, V v, R r) {
		r=biF.apply(t, v);
		System.out.println(r.getClass().getSimpleName()+" has been created");
		System.out.println(r);
		return r;
	}
	
	static void ex10() {
		System.out.println("*****ex10");
		System.out.println("Unary Operator");
		
		 /*
		  * /*
		 * @FunctionalInterface interface class UnaryOperator<T>
				extends Function<T, T> {
				T appy(T t) }
		  */
		/*
		 * this functional interface takes a object and returns a Object, both
		 * objects HAVE TO BE the same type
		 * takes in an Integer, returns an Integer
		 * takes in a Animal, returns a Animal
		 * this takes in a string
		 * returns the uppercase version of the string which is also a string
		 */
		UnaryOperator<String>u1=str->str.toUpperCase();
		UnaryOperator<String>u2=String::toUpperCase;
		System.out.println(u1.apply("noel"));
		System.out.println(u2.apply("flattery"));
		
		UnaryOperator<Animal>unAnimal=(al)->new Animal(4,"andy");
		/*
		 * this takes a Animal and modifies the Animal in the lambda body and
		 * returns the modified Animal
		 */
		UnaryOperator<Animal>unModifyAnimal=(al)->{
			al.age=al.age*2;
			al.name=al.name+" smith";
			/*
			 * this will create another Animal object with the same name and 
			 * age as al, but it is SEPERATE OBJECT
			 */
			Animal newAnimal=new Animal(al.age,al.name);
			//Animal newAnimal=new Animal();
		//	al=newAnimal;
			return newAnimal;	
		};	
		Animal myAnimal=new Animal(10,"angela");
		System.out.println(unModifyAnimal.apply(myAnimal));
		System.out.println(myAnimal);
		takeUnary(unModifyAnimal,myAnimal);
		System.out.println(myAnimal);
	}
	static<T> T takeUnary(UnaryOperator<T>myU, T t) {	
		return myU.apply(t);			
				
	}
	
	static void ex11() {
		System.out.println("ex11");
		System.out.println("BinaryOperator***");
		
		 /*
		  * @FunctionalInterface public interface BinaryOperator<T>
			extends BiFunction<T, T, T> { }
			T apply(T t,T t2)
		 */
		/*
		 * a binaryOpeartor takes two objects and returns an object, all OBJECTS ARE
		 * THE SAME TYPE
		 */
		BinaryOperator<String>b1=(string,toAdd)->string.concat(toAdd);
		BinaryOperator<String>b2=String::concat;
		
		System.out.println(b1.apply("hello", " nice to meet you"));
		System.out.println(b2.apply("hiya" , " you are great"));
		
		
		
	}
	
	

}

class Dog{
	
	Dog(){
		System.out.println("Dog created");
	}
	int eat() {
		System.out.println("dog eat method that returns an int");
		return 0;
	}
}


