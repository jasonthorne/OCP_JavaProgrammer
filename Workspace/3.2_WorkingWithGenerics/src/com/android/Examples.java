package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.android.animals.Animal;
import com.android.animals.Cow;
import com.android.animals.Cow.*;
import com.android.animals.Elephant;
import com.android.animals.Whale;
import com.android.animals.Zebra;
import com.android.generics.Box;
import com.android.generics.Bucket;
import com.android.generics.Crate;

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
		
		System.out.println("\nex1:");
		
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
	
	
	static void ex2() {
		
		System.out.println("\nex2:");
		
		
		//Crate<Elephant>elephantCrate = new Crate<>(new Elephant());
		//elephantCrate.returnMe();
		
		Elephant nellie = new Elephant();
		Crate<Elephant>crateElephant = new Crate<Elephant>(nellie); //this creates a Crate obj and sets its generic type to be of type Elephant.
		
		
		//---------Explanation for someone else:
		/*
		Animal myAnimal1 = new Animal(33);
		Animal myAnimal2=new Animal(myAnimal1);
		*/
		//-------
		
		Crate<String>crateString = new Crate<>("Yo"); //creates a Crate obj of type String.
		
		//If you dont supply Crate with s type, it will assume that type T is an Object.
		Crate crateObj = new Crate<>(new Object());
		
		crateElephant.returnMe(new Elephant());
		
		List<Integer>numbers=Arrays.asList(12,67,88,99);
		Crate<List>crateList = new Crate<List>(numbers);
		crateList.returnMe(numbers);
		
		//-------------------------
		
	}
	
	static void ex3() {
		
		System.out.println("\nex3:");
		
		System.out.println("Using extends with generics");
		
		Cow myCow = new CowBuilder().setAge(3).setHeight(3.3).setWeight(3.33).build();
		
		System.out.println("Creating Box objects");
		
		//myAnimal inside box will be an Animal (an Animal reference to an Animal object)
		Box<Animal> boxAnimal = new Box<>(new Animal());
		
		//myAnimal inside box will be a Zebra (Animal reference to a Zebra object)
		Box<Zebra>boxZebra = new Box<>(new Zebra());
		
		Box<Cow>boxCow = new Box<>(myCow);
		
		Box<Cow>boxCow2 = new Box<>(new CowBuilder().setHeight(3.3).setAge(3).setWeight(33.3).build());
	
	}
	
	
	static void ex4() {
		
		System.out.println("\nex4:");
		
		Bucket<Whale>bucketWhale = new Bucket<Whale>(new Whale());
	}

}
