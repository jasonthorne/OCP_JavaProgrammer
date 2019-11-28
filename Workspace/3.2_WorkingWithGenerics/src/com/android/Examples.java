package com.android;

import java.util.ArrayList;
import java.util.List;

public class Examples {
	
	private interface Grow{ //this "inner private interface", can only be accessed inside this class. ++++++++
		void sprout();
		void pollinate();
	}
	
	private enum Fruit implements Grow{
		COCONUT(), MANGO(),RASPBERRY(){
			/*
			 * anonomous inner class CANT have it's own consructor
			 * but it CAN have its own initialiser
			 */
			{
				System.out.println("Raspberry initialiser");
			}
			
			//raspberry has ITS OWN overridden sprout and pollinate methods:
			@Override
			public void sprout() {
				System.out.println("Raspberry sprouting");
			}
			
			@Override
			public void pollinate() {
				System.out.println("Raspberry pollinating");
			}
			
		}; //end of raspberry inner class.
		
		/*
		 * constructor that each one of the fruit types call. As soon as we create ONE enum value, 
		 * ALL of the types are created at this point. 
		 * This constructor will only run 3 times.
		 */
		Fruit(){
			System.out.println(this.toString().toLowerCase() + " Fruit created");
		}

		 //Coconut and mango will use these sprout and pollinate methods:
		@Override
		public void sprout() {
			System.out.println("fruit sprouting");
		}

		@Override
		public void pollinate() {
			System.out.println("fruit pollinating");
		}
		
		///--------------
		
		//an enum can have an inner class: +++++++++++++++++++Only the enum objects can use this
		private class Strawberry{
			
		}
		
		/*
		 * Grow is an interface with 2 abstract methods in it, so you can't create a lambda for it. 
		 * Below we have anonymous class implementation of the Grow interface.
		 */
		Grow myGrow = new Grow() {

			@Override
			public void sprout() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void pollinate() {
				// TODO Auto-generated method stub
				
			}
			
		};

	}//end of enum
	
	
	//==================================================================================
	
	
	static void ex1() {
		
		/*
		 * When we do below, we supply a TYPE to the list interface, and that type is String.
		 * So we can only now add Strings to this list. If we attempt to add anything else, it will not compile.
		 */
		List<String>names = new ArrayList<String>();
		String fruit="bannana";
		names.add(fruit);
		names.add("apple");
		names.add(new String("Orange"));
		//cant add an enum type (as it's not a string):
		/*
		 * Every class has a toString() method, so whereas you can only add a string to a list of strings
		 * any class has a toString method though so you can call its toString and add that:
		 */
		names.add(Fruit.COCONUT.toString().toLowerCase());
		
		System.out.println(names);
		
		//---------------------
		
		/*
		 * Number is a super class of aLL of the wrapper number classes.
		 * The generic of the List interface is set up to take a type or subclass of the supplied type.
		 * in this case it can take a Number wrapper type or a subclass of number (INTEGER, DOUBLE, FLOAT etc..)
		 */
		
		List<Number>numbers=new ArrayList<Number>();
		numbers.add(1); //can add an int. 1 here is autoboxed to become an INTEGER wrapper. integer is a subclass of number.
		numbers.add(3.3); //can add a double
		
		/*
		 * You CANT add an INTEGER wrapper to a list of DOUBLE wrapper objects.
		 */
		
		List<Double>doubles = new ArrayList<Double>();
		//doubles.add(1);
		
		
		
	}
	

}
