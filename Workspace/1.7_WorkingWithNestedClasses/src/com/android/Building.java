package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

class Employee{
	
	//vars:
	int age = 24;
	String name = "samwise";
	private double weight = 2.34;
	
	//constructors:
	Employee(){
		System.out.println("Employee created with no args constructor");
	}
	
	Employee(int age, String name){
		this.age = age;
		this.name = name;
		System.out.println("employee created with constructor in string");
	}
	
	//methods:
	void earnMoney() {
		System.out.println(name + " Employee earing money");
	}
	
	void doWork() {
		System.out.println("Employee working");
	}
	
	double getWeight() {
		return weight;
	}
	
}


//building is a top level class:
public class Building {
	
	Employee eddie;
	int size=400;
	
	Building(){
		int localInt = 6;
		System.out.println("Building constructor called");
		
		/*
		 * An anonymous inner class is a way to redefine a class where we can override methods or even declare new methods and variables
		 */
		
		eddie = new Employee() {
			
			/*
			 * This is an anonymous class implementation eddie the employee object.
			 * Which allows us to tailor the object to be specific to Eddie.
			 */
			
			/*You cant have a constructor inside an anonymous inner class
			However you can have initialisers*/
			{
				System.out.println("You cant have a constructor inside an anonymous inner class. However you can have initialisers");
			}
			
			/*
			 * variables and methods first created inside an anonymous inner class are only avaliable inside the anonymous inner class.
			 */
			int newVar = 90; //only available inside the curly brackets
			
			/*
			 * You can override methods in an anonomous inner class.
			 * Here we are overriding the earnMoney method from the employee class.
			 */
			@Override
			void earnMoney() {
				
				System.out.println("This is eddie's own earnMoney() method");
				System.out.println("new var is: " + newVar);
				payTax();
				doWork();
			}
			
			void payTax() {
				System.out.println("eddie paying tax");
				
				/*
				 * we can access all varaibels of the outer class.
				 * The outer class is Building, so e can access Size & Eddie
				 */
				System.out.println("Size of building is: " + size);
				
				/*
				 * We can access local variables as long as they are effectively final or final.
				 * localInt below is a local var of the constructor, and if changed before use here, then is NO LONGER effectively final, so cant be used.
				 */
				System.out.println("localInt is: " + localInt);
				
				
				/*
				 * we can access all variables of the Employee class.
				 */
				
				System.out.println("name of employee is: " + name);
				System.out.println("age of employee is: " + age);
				
				/*
				 * The anonymous inner class doesnt have access to the private double weight, 
				 * as you can ONLY access this variable inside the Employee class, not the anonymous inner class.
				 * So you can access the weight through the employee class, not directly, as shown below:
				 */
				System.out.println("weight of employee is: " + getWeight());
				/////////System.out.println("weight of employee is: " + weight);
			}
			
			
		};//end of anonymous inner class
		
		//System.out.println(eddie.newVar); //no longer exists so cant be referenced.
		//eddie.payTax();  //no longer exists so can't be referenced.
		eddie.earnMoney(); //referenced outside of the anonymous inner class, so still exists.
		eddie.doWork(); //from the Employee class and not overridden.
		
	}//end of Building constructor
	
	private void live(Employee emp) {
		/*
		 * Whatever type of employee eobj is sent to this method, will call the earnMoney() method.
		 * All employee objects, regardless of whether they are anonymous inner classes, will have a an earnMoney() method. 
		 * We will create another method called callAnon that will send different employee object types to it. 
		 */
		emp.earnMoney();
		
		
	}
	
	//this method is sending different types of employee to the live method.
	void callAnon() {
		System.out.println("Building class callAnon method");
		System.out.println("Sending eddie to live method");
		live(eddie); //eddie anonymous class implementation
		
		System.out.println("Sending an employee obj with NO args constructor to live method");
		live(new Employee()); //Employee class implementation
		System.out.println("Sending an employee obj WITH args constructor to live method");
		live(new Employee(34, "mary")); //Employee class
		System.out.println("Sending an employee with it's own anon inner class to live method");
		live(new Employee(45, "Yvonne") {
			
			//Only available to anonymous inner class
			void leave() {
				System.out.println(name+ " is leaving");
			}
			
			@Override
			void earnMoney(){
				System.out.println("this employee " + name + "is earning money");
				doWork();
				leave();
			}
			
		}); //end of live method
		
		
		//This is the same as sending an Employee with no args constructor:
		live(new Employee() {
			
		});
		
	}//end of callAnon
	
	//----------------
	/*You CANT create an instance of an abstract class, and you normally cant use the new keyword with an abstract class. 
	There is however one exception:*/
	
	abstract class Bungalow{
		abstract int heatMe();
		abstract void lightMe();
	}
	
	class SemiDetached extends Bungalow{

		@Override
		int heatMe() {
			System.out.println("SemiDetached heatMe");
			return 0;
		}

		@Override
		void lightMe() {
			System.out.println("SemiDetached lightMe");
			
		}
		
	}
	
	SemiDetached mySemi = new SemiDetached();
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	/*
	 * The only place where you can use the keyword new with an abstract class is with an anonymous class obj
	 * that implements the abstract methods contained within the abstract class method.
	 */
	
	//This is a property of the variable class. 
	Bungalow myBungalow = new Bungalow() {
		
		/*
		 * If you are using anonymous class implementation of an abstract class, 
		 * then you have to override the abstract methods contained within that abstract class.
		 * Here the abstract class bungalow contains the abstract methods: heatMe & lightMe,
		 * so we have to override both of these methods. 
		 */

		@Override
		int heatMe() {
			liveIn();
			lightMe();
			return 0;
		}

		@Override
		void lightMe() {
			// TODO Auto-generated method stub
			
		}
		
		void liveIn() {
			System.out.println("liveIn method");
		}
	};
	
	
	/*
	 * This method uses the different sorts of Bungalow you can have:
	 * + An anonymous class implementation of the abstract Bungalow class
	 * + A concrete sub class implementation of the super abstract bungalow
	 */
	
	void callBungalow() {
		System.out.println("CallBungalow method: ");
		myBungalow.heatMe(); //call the overridden heatMe method
		mySemi.heatMe();
	}
	
	
	//++++++++++++++++++++++COULD BE IN EXAM: ++++++++++++++++++++++++++++++++++++++++++++
	/*
	//inner class that extends its outer(parent) class
	class Apartment extends Building{
		
	}
	Apartment myApartment = new Apartment(); 
	*/
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	/*
	 * inner interfaces, but for our purposes, behave the same way as a top level interface:
	 * You cant create an interface obj, because an interface is a purel abstract class. 
	 * So you cant usually use the new keyword with an interface. 
	 * However you CAN with an anonymous class implementation of an interface. 
	 */
	
	//NOT a FUNCTIONAL INTERFACE
	interface Behaviour{
		void aggressive();
		void passive();
	}
	
	/*
	 * below can be a reference to an object whos class implements this interface
	 * or it can be an anonomous inner class implementation (same syntax as abstract classes).
	 */
	Behaviour myBehave = new Behaviour() {

		//this has to override these abstract methods: 
		@Override
		public void aggressive() {
		System.out.println("myBehave aggressive");
		}

		@Override
		public void passive() {
			System.out.println("myBehave passive");
			delirious(); //calling the local method
		}
		
		//this is its own method
		public void delirious() {
			System.out.println("myBehave delirious");
		}
		
	};
	
	void callBehaviour() {
		myBehave.aggressive();
		myBehave.passive();
		//myBehave DOESNT have access to its classe's 'delirious' method here, +++++++++++++++++++++++++++++IMPORTANT!!!  
		//as the REFERENCE refers to the interface NOT the anonymous class. 
	}
	
	//-------------------------------------------------------
	
	//A functional interface is an interface with only 1 abstract method inside it:
	
	@FunctionalInterface //this is an annotation, and you will get an error if you have more than 1 abstract method inside it.
	interface Mood{
		void happy();
	}
	
	//OPTION 1 - to implement the mood interface is to have a class implement the interface
	class Zebra implements Mood{
		
		@Override
		public void happy() {
			System.out.println("Zebra happy");
			
		}

	}//end of zebra
	
	
	//OPTION 2 - anonmous class implementation of the mood interface
	Mood moodAnon = new Mood() {
		@Override
		public void happy() {
			System.out.println("anonymous implementation of the Mood interface");
		}
	};
	
	//OPTION 3 - With a functional interface we can use LAMBDA notation:
	/*
	 * We re trying to implement the only abstract method from this functional interface which is: void happy();
	 */
	
	Mood moodLamb1 =()->{
		System.out.println("using long form lambda notation for happy method");
	};
	
	//shortform lambda (NO curly brackets needed if only one line) 
	Mood moodLamb2 =()->System.out.println("using long form lambda notation for happy method");
	
	void callMood(){
		moodLamb1.happy();
		moodLamb2.happy();
	}
	
	
	//++++++++++++++++++++++++++++++++++++++++++PREDICATES+++++++++++++++++++++++++++++++
	
	/*
	 * There is a built in functional interface in java called "Predicate"
	 * which has 1 abstract method called "test":
	 * public boolean test(Object t)
	 */
	
	/*
	 * Here there is an issue in that we have not supplied a type, 
	 * so this means this will be an arraylist of objects. 
	 * So that means we wont be able to access any of the methods of these objects that does not already exist in the object list.
	 * I.E a dog has a walk() method, but we wont be able to access the walk() method as this will be like this:
	 * Object spot = new dog(), no access to Dog methods.
	 */
	
	List myList = new ArrayList<>(); //list of objects
	
	//here we supply a type (has to be Aan object) of Integer. Only have to supply on left hand side. Most times you do not have to supply on the right hand side.
	List<Integer>intList = new ArrayList<Integer>();
	
	//a can only be an object, because we haven't supplied it with a type. Therefore it only has access to methods of the object class
	Predicate myPred = a->true; //short hand 
	
	Predicate myPred2 = (a)->{ //long hand
		return true;
	};
	
	Predicate<Integer> myPred3 = (a)->{ //long hand Lambda
		if(a>18)
			return true;
		return false;
	};
	
	/*
	 * anonymous inner class implementation of the predicate interface method boolean test(Object t)
	 */
	Predicate<Integer>predInt=new Predicate() {
		
		/*
		 * Even thpough we supplied it with a type, anonymous class implementation doesnt recognise this object as an Integer
		 * so we have to cast it.
		 */

		@Override
		public boolean test(Object t) {
			
			Integer num = (Integer)t; //cast to Integer needed, as it only accepts Object
			if(num>18)
					return true;
			return false;
		}
		
	};
	
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++FUCTIONAL INTERFACES ++++++++++++++++++++++++++++++++++++++++
	
	//Predicate: takes an object, and returns a boolean
	Predicate<Integer>pred=a->a>18?true:false;
	
	//BiPredicate: Takes 2 objects (can be of different types) and compares some property of both of them.
	BiPredicate<Integer,String>biPred=(a,b)->true;
	
	//CONSUMER:
	/*
	 * This has an accept method that takes an object and returns void (nothing).
	 * Here this takes in a number and prints a double of it.
	 */
	Consumer<Integer>consume=(a)->System.out.println(a*2); //printing, not returning.
	
	void callFunction() {
		Arrays.asList(23,56,89).forEach(consume); //takes in numbers as a list, then spins through each and calls consume on them.
	}
	
	/*
	 * BiConsumer has an accept method that takes two objects (can be the same type or different) and returns void.
	 */
	BiConsumer<Integer,String>biConsume =(a,b)->System.out.println(a+b); //not a return but a PRINTOUT
	
	/*
	 * Function: Has an apply method which takes an object and returns an object (both can be the same or different)
	 */
	Function<Integer, String>function=(a)->"sup dawg!"; //a is an integer, return is a string (order of types matters) ++++++++++++++++++
	
	/*
	 * BiFunction: Has an apply method which takes an object and returns an object (both can be the same or different)
	 */
	BiFunction<Integer,String, Double>bifunction=(a, b)->3.3; //a is an integer, b is string, return is a double (order of types matters) ++++++++++++++++++
	
	/*
	 * Supplier:
	 * Has 1 method 'get' which takes in nothing, and returns an object. Here it returns an integer.
	 */
	Supplier<Integer>supplier=()->2;
	
	/*
	 * Unary Opperator:
	 * Takes an object and returns an object. Both must be of the same type.
	 */
	UnaryOperator<Integer>unary = a->a*2; //return and input HAVE TO BE of the same type
	
	/*
	 * Binary Opperator:
	 * Has one method "get" Takes 2 objects and returns an object. Both must be of the same type.
	 */
	BinaryOperator<Integer>binary = (a,b)->a*b; 
	

}//end of building class
