package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.android.animals.Animal;
import com.android.animals.Cow;
import com.android.animals.Cow.*;
import com.android.animals.Elephant;
import com.android.animals.Lemur;
import com.android.animals.Whale;
import com.android.animals.Zebra;
import com.android.generics.Box;
import com.android.generics.Bucket;
import com.android.generics.Container;
import com.android.generics.Crate;
import com.android.generics.Kettle;
import com.android.generics.Pan;
import com.android.interfaces.Behaviour;
import com.android.interfaces.Life;
import com.android.plants.Flower;

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
		
		//behaviour reference to a whale object. 
		//Meaning it ONLY has access to the methods defined in the Behaviour interface:
		Behaviour behaveWhale = new Whale(); 
		
		//my comment:
		//creating a bucket obj with a whale class. So bucket becomes of type 'whale'
		//the 'new whale' being passed in is for the constructor of the Bucket class. Which has to be of Type T (as defined in angle brackets).
		
		/*
		 * noels comment:
		 * 
		 * This creates a bucket and sets the generic type in the bucket class T to be a whale.
		 * So T myBehave is now a Whale myBehave; reference. 
		 * So anywhere inside the bucket class you have T, it now means whale.
		 * remember <T extends Behaviour>, which means we can only use objects of a class that extend the Behaviour interface. 
		 */
		Bucket<Whale>bucketWhale = new Bucket<Whale>(new Whale()); 
		bucketWhale.fill(new Whale(), 3); //calling the Bucket classes fill method
		
		//------------
		
		System.out.println();
		Bucket<Lemur>lemurBucket = new Bucket<Lemur>(new Lemur());
		lemurBucket.fill(new Lemur(), 2);
		
		//=======================================
		
		/*
		 * Anonymous class implementation of the Behaviour interface ++++++++++++++++++++++++++++++++++++++
		 */
		Behaviour anonBehave = new Behaviour() {
			
			//this anonymous class can have everything a normal class an EXCEPT a constructor:
			
			//This object CANT call this method outside of these curly braces. As it has a BEHAVIOUR reference, so only have access to the methods first defined there.
			void dummy() {
				System.out.println("dummy method called");
			}

			/*
			 *These 3 overridden method from the Behaviour interface only exist for this object called anonBehave.
			 */
			
			@Override
			public void sad() {
				System.out.println("anonymous class implementation of sad method in behaviour");
			}

			@Override
			public void happy() {
				System.out.println("anonymous class implementation of happy method in behaviour");
			}

			@Override
			public void mad() {
				System.out.println("anonymous class implementation of mad method in behaviour");
			}
			
		}; //end of anonBehave
		
		
		//calling the methods:
		anonBehave.happy();
		anonBehave.mad();
		anonBehave.sad();
		//anonBehave.dummy(); //cant access this method as anonBehave has a behaviour reference.
		
		
		/*
		 * This sets our generic to be any object that implements the behaviour interface.
		 * Whale implements Behaviour
		 * Lemur implements Behaviour
		 * anonBehave implements Behaviour
		 */
		
		System.out.println("Bucket with an interface type generic");
		
		//the below reference can be reassigned to ANYTHING that implements Behaviour, when Beahaviour is defined as its type. (WAAAY more dynamic) ++++++++++++++++++++
		Bucket<Behaviour>bucketBehave = new Bucket<>(new Whale()); 
		bucketBehave = new Bucket<>(new Lemur());  //changing reference to a Lemur object
		bucketBehave = new Bucket<>(anonBehave); //changing reference to an anonoBehave object
		
	}
	
	
	static void ex5() {
		
		System.out.println("\nex5:");
		
		//lambda implementation of the "Life" functional interface 
		Life anotherLife = ()->System.out.println("grow method of anotherLife lambda"); //this is the void grow method being assigned to the 'Life' variable (as a sysout)
		
		/*this sets the generic T myLife to be any object that implements the functional interface life,
		which can be a Flower, an anonymous class or a lambda
		*/
		System.out.println("\nprinting Pan object with grow method from lambda:");
		Pan<Life>lifePan=new Pan<Life>(anotherLife); //this Pan object is created with a Life lambda (created above ).
		
		System.out.println("\nprinting Pan object with grow method from a Flower object:");
		lifePan = new Pan<Life>(new Flower()); //Pan object is now pointing to a class that implements Life
		
		System.out.println("\nprinting Pan object with grow method from an anonymous class Life implementation:");
		Life anonLife = new Life() {

			@Override
			public void grow() {
				System.out.println("anonymus class life implementation");
			}
		};//end of anonymous class
		
		lifePan= new Pan<>(anonLife); //pan object is now pointing to an anonymous class that implements Life
		
		/*
		 * Type T myLife inside the Pan class can only be a Flower, so you can only send a flower to the constructor,
		 * whereas if we say Pan<Life>
		 * we can send any objject that implements the Life interface. Which can be: 
		 * + any class that implements the life interface.
		 * + any lambda that impolements the life interface
		 * + any anonymous class that implements the Life interface. 
		 */
		
		//previous method with type declared as Flower instead of Life interface: this can ONLT take a FLower. Not a lambda, or anonymous inner class for example.
		Pan<Flower>flowerPan = new Pan<Flower>(new Flower()); //sending the type T to the pan's constructor when creating the pan object.
		
		//will not take a lambda:
		//flowerPan=new Pan<>(myLife);
		
		//will not take an anonymous inner class:
		//flowerPan=new Pan<>(anonLife);
		
	}
	
	
	static void ex6() {
		
		System.out.println("\nex6:");
		
		//container class defining types, and passing them to it's constructor:
		Container<Integer, String, Animal>myContainer = new Container<Integer, String, Animal>(49, "Yo", new Animal());
		
		//container class WITHOUT defining types and passing them to it's constructor (Meaning they're of default type 'Object'):
		Container container2 = new Container(49, "yo", new Animal());
		
		//with the diamond operator missing on the right you can pass anything into the constructor! ++++++++++++++++++++++
		Container<Integer, String, Animal>myContainer3 = new Container(3.33, new Animal(), "Yo"); //not an int, String and Animal
		
		//Doesnt compile as there IS a diamond operator on the right hand side (with the constructor args conflicting with the diamond operator types on the left):
		//Container<Integer, String, Animal> container4 = new Container<>(3.33, new Animal(), "Yo"); //not an int, String and Animal
		
		Container container5 = new Container(49, "yo", new Animal());
	

	}
	
	
	
	static void ex7() {
		
		System.out.println("\nex7:");
		
		//type T is an Integer, V is a Cow, E is a Zebra.
		
		/*
		 * 1st arg of constructor can be Animal or sub of Animal, so it can be an Animal, Elephant, Zebra or Cow
		 * 2nd arg can be any object that implements the Behaviour interface, so it can be:
		 * A class that implements Behaviour - Whale or Lemur
		 * 3rd arg van be of ANY type
		 */
		
		Kettle<Zebra,Whale,Integer>myKettle1 = new Kettle<Zebra,Whale,Integer>(new Zebra(), new Whale(), 23);
		Kettle<Animal,Behaviour,Integer>myKettle2 = new Kettle<Animal,Behaviour,Integer>(new Animal(), new Lemur(), 45);
		
		//-----------------
		//ananymous class implementation of the behaviour interface:
		Behaviour myBehave=new Behaviour() {

			@Override
			public void sad() {System.out.println("myBehave sad");}

			@Override
			public void happy() {System.out.println("myBehave happy");}

			@Override
			public void mad() {System.out.println("myBehave mad");}
			
		};//end of myBehave anonyous class
		
		//A class that extends or is an Animal, takes an anonymous class implementation of the Behaviour interface, and an Integer: 
		Kettle<Animal, Behaviour, Integer>myKettle3 = new Kettle <Animal,Behaviour,Integer>(new Elephant(), myBehave, 333);
		
		
		
	}
	

}
