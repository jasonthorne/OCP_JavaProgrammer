package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import com.android.animals.Animal;
import com.android.animals.Behaviour;
import com.android.animals.Cat;
import com.android.animals.Collie;
import com.android.animals.Dog;
import com.android.animals.Hippo;
import com.android.animals.Mouse;

public class Examples {
	
	/*
	 * You can create your own collection classes.
	 * See Cat class to see implementation of the Collection Interface. 
	 * See Hippo class to see implementation of the List Interface. 
	 * See Ostrich class to see implementation of the Set Interface. 
	 * See Falcon Class to see the implementation of the Queue Interface 
	 * See Rhino class to see implementation of the Map Interface. 
	 */
	
	static void ex1() {
		System.out.println("\nEx1:");
		
		/*
		 * Cat class didnt specify a generic in the class declaration.
		 * Cat class implements Collection. So methods in this class will take an Object. 
		 */
		Cat tibbles = new Cat();
		
		/*
		 * You cant create a Cat with a generic type as the generic type wasnt included in the class declaration. 
		 */
		
		//--------
		Hippo<String>harry = new Hippo<>();
		
		/*
		 * Hippo DID specify a generic, which is then passed to the collection interface. 
		 * And that becomes the type used in method s of the collection interface. 
		 * i.e add()
		 */
		harry.add("sup");
		harry.add("dawg");
		//harry.add(new Cat()); //computer say's no...
		
		//not specifying a generic means the generic will be an OBJECT, and we can add any object to this Hippo:
		Hippo hellen = new Hippo<>();
		hellen.add(new Cat()); //computer say's yes 
		hellen.add("all good here"); //adding a String
		
		//----------
		
		System.out.println("add() method");
		List<String>strList = new ArrayList<>(); //arraylist of strings
		//adding to list:
		strList.add("one");
		strList.add("apple");
		strList.add("sheep");
		
		//adding at a specific index pos:
		System.out.println(strList);
		strList.add(1,"orange"); //add an orange at pos 1 (between one and apple)
		System.out.println(strList);
		
		
		//===============================HASH SET INTRO ====================================================
		
		System.out.println("\nHASH SET INTRO");
		
		/*
		 * A HashSet DOESNT allow duplicates. HashSet implements the Set interface. THe Set interface doesnt allow duplicates. 
		 */
		
		Set<String>strSet = new HashSet<>();
		//.add returns true/false
		System.out.println(strSet.add("orange")); //returns true
		System.out.println(strSet.add("orange")); //returns false as adding duplicate string
		System.out.println(strSet.add("Orange")); //returns true as java is case sensitive
		System.out.println(strSet.add("apple")); //returns true
		System.out.println(strSet.add(null)); //does allow you to add null
		System.out.println(strSet.add(null)); //but again, doesn't allow duplicates
		Animal nullAnimal=null;
		//System.out.println(strSet.add(nullAnimal)); //wont accept this as it's not a string REFERENCE or null. It's the reference type that determines what can be accepted.
		String nullStr=null;
		System.out.println(strSet.add(nullStr)); //can be added (as a String ref), but will retur nfalse as null already exists in set.
		System.out.println(strSet);
	
		
		System.out.println("\nRemoving:");
		strSet.remove("orange"); //remove the first instance of (lowercase) orange from set //SAME FOR LISTS
		System.out.println(strSet);
		strList.remove(2); //remove from a particular pos
		System.out.println(strList);
		
		/*
		 * remove() returns a boolean. T if found and removed, F if not.
		 */
		System.out.println(strList.remove("monkey")); //false as no monkey
		
		/*
		 * If you try to remove from an INDEX POS that doesnt exist, you will get an IndexOutofBoundsException. strList only goes to pos 2 for example.
		 */
		//strList.remove(12); //IndexOutofBoundsException
		
		//------------------
		
		
		System.out.println("\nisEmpty() and Size()");
		
		System.out.println("size of strList is: " + strList.size());
		System.out.println("size of strSet is: " + strSet.size());
		
		System.out.println("is strList empty: " + strList.isEmpty()); //false
		System.out.println("is strSet empty: " + strSet.isEmpty()); //false
		
		List<Integer>myList = new ArrayList<>();
		System.out.println("is myList empty: " + myList.isEmpty()); //true
		
		
		//------------------
		
		
		System.out.println("\nClear");
		/*
		 * Deletes all elements in a collection
		 */
		
		List<Integer>numList=new ArrayList<>();
		numList.addAll(Arrays.asList(23,44,566,34,667,889,10000));
		System.out.println(numList);
		numList.clear();
		System.out.println(numList);
		
		//same for sets:
		System.out.println(strSet);
		strSet.clear();
		System.out.println(strSet);
		
		//Arrays.asList also works with sets:
		strSet.addAll(Arrays.asList("orange, banana", "apple", "pineapple"));
		System.out.println(strSet);
		
		
		//================================
		
		System.out.println();
		
		/*
		 * Below is using the equals() method of the Dog class. 
		 * If it returns true the Dog will be inserted into the list.
		 */
		
		Set<Dog>dogSet=new HashSet<>(); //create Dog set
		//create dogs:
		Dog dog1 = new Dog("spot", 1); 
		Dog dog2 = new Dog("spot", 1); 
		Dog dog3 = new Dog("rex", 2); 
		Dog dog4 = dog1; //create new ref to dog1. Meaning that as the id is the same, this wont be inserted.
		
		dogSet.addAll(Arrays.asList(dog1, dog2, dog3, dog4)); //add dogs to dogSet
		System.out.println(dogSet);
		
		
		//--------------------
		
		System.out.println("\nContains:");
		
		/*
		 * Returns a boolean. True if the collection contains a particular obj, false if not.
		 */
		System.out.println(dogSet.contains(dog1)); //true
		Dog lassie=new Dog("Lassie", 5);
		System.out.println(dogSet.contains(lassie)); //false
		System.out.println(strList.contains("one")); //false 
	}
	
	
	static void ex2() {
		System.out.println("\nEx2:");
		
		System.out.println("ArrayLists:");
		
		/*
		 * List implementation
		 * 
		 * List interface extends Collection, and Collection extends Iterable
		 * So We can have an Iterable reference to an ArrayList object.
		 * we can have a Collection interface to an ArrayList object.
		 * We can have a List reference to an ArrayList object.
		 * 
		 */
		
		/*
		Below object ONLY has access to the Iterable interface methods.
		//ForEach and iterator() are the main ones from this.
		*/
		Iterable<Integer>iterList = new ArrayList<>();
		
		
		/*
		 * Below obj has access to all of the Iterable interface methods and the Collection interface methods
		 * ie: add(), addAll(), clear(), contains(), stream()
		 */ 
		Collection<String>strCollection=new ArrayList<>();
		
		/*
		 * below obj has access to all of the methods of Iterable, Collection and List interface.
		 * i.e set(), get()
		 */
		List<Dog>dogList=new ArrayList<>();
		
		
		/*
		 * Below has access to all pof the methods of iterable, Collection, list and Serializable, clonable and randomAccess interfaces. 
		 */
		ArrayList<String>strArrList = new ArrayList<>();
		
		//------------------------------------
		
		/*
		 * This deterines that this is a list of Integers.
		 */
		List<Integer>numList=new ArrayList<>();
		//4 is autoboxed to become an integer and added to the list.
		numList.add(4);
		numList.add(Integer.getInteger("333"));
		//numList.add(Double.parseDouble("3.33")); //wont work as this is an INTEGER list 
		byte myByte=56;
		//numList.add(myByte); //wont compile as Integer list can only take Integer wrapper Objects.
		numList.add((int)myByte); //fine as byte is cast to int first.
		//numList.add((Integer)myByte); wont compile as there's no relationship between a byte primitive, and an Integer wrapper.
		
		//----------------------------
		
		/*
		 * Below list can take Animals and subclasses of Animals
		 */
		List<Animal>animalList = new ArrayList<>();
		
		//add animals or suclasses to list:
		animalList.add(new Animal());
		animalList.add(new Dog());
		animalList.add(new Collie());
		animalList.add(new Mouse());
		
		Animal dogAnimal = new Dog();
		
		//Animal ref to a Dog object
		animalList.add(dogAnimal);
		
		
		Behaviour behaveDog = new Dog();
		//animalList.add(behaveDog); //wont compile. Cant add a Behaviour reference as it's not an Animla reference.
		
		//a Behaviour list can take anything that implements the Behaviour interface
		List<Behaviour>behaveList = new ArrayList<>();
		behaveList.add(new Dog());
		behaveList.add(behaveDog);
		behaveList.add(()->System.out.println("lamda sad method"));
		
		//-----
		
		/*
		 * below list can only take a Dog ref or a subclass referenced object (of whixh there is only 1 - a Collie)
		 */
		List<Dog>kennel = new ArrayList<Dog>();
		kennel.add(new Dog());
		kennel.add(new Collie()); //a Collie IS-A Dog
		//this is an animal ref to a Dog object:
		dogAnimal=new Dog(); 
		//kennel.add(dogAnimal); //dogAnimal has a ANIMAL ref so cant be added
		
		kennel.add((Dog)dogAnimal); //casting dogAnimal from an Animal ref to a Dog ref
		
		//-------
		//This is a list that can take ANY OBJECT as there's no diamond operator on the LEFT hand side.
		//You can the n ONLY call methods of the object class on the items of this list.
		List myList=new ArrayList<Integer>();
		myList.add("hello");
		myList.add(23.5);
		myList.add(new Animal());
		
		//---------
		
		System.out.println("AddAll");
		
		/*
		 * add all takes an object that implements the Collection interface, 
		 * so all sets, Lists and Queues can be the parameter that is sent to this method.
		 * Kennel is a list, list implements the colection interface. 
		 */
		kennel.addAll(kennel);
		Set<Dog>setDog= new HashSet<>();
		setDog.addAll(Arrays.asList(new Dog(), new Dog(), new Dog()));
		
		kennel.addAll(setDog);

		
	}
	
	
	
	static void ex3() {
		System.out.println("\nEx3:");
		System.out.println("ITERATORS:");
	
		/*
		 * An iterator is an object that is used to go through a collection object.
		 */
		
		List<Dog>kennel=new ArrayList<>();
		kennel.addAll(Arrays.asList(new Dog("spot", 2), new Dog("rex", 3), new Dog("lassie", 5), new Dog("benji", 10)));
		
		for(Dog d:kennel)
			System.out.println(d);
		
		/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * ListIterator object for going through values in list. 
		 * You create a listIterator from an existing list.
		 * 1st rule: The type of the listIterator has to match the type of the list.
		 * You create the object by having the list call the ListIterator() method which creates a lisatIterator.
		 */
		ListIterator<Dog>dogIterator=kennel.listIterator(); 
		System.out.println(dogIterator); //printing the iterator just prints off it's ref
		
		//methods for the ListIterator:
		/*
		 * hasNext: returns a boolean value which indicates if there's another record in the list
		 */
		System.out.println();
		
		while(dogIterator.hasNext()) { //while there's another dog in list
			System.out.println("index of next Dog is: " + dogIterator.nextIndex());
			//dogIterator.next(); //go to next list 
			System.out.println(dogIterator.next()); //also returns the next object
			System.out.println(dogIterator.hasNext()); //returns boolean of whether there is another object in list
		}
		
		
	}
	
	static void ex4() {
		System.out.println("\nEx4:");
		System.out.println("ITERATORS CONTINUED:");
		
		
		//list of numbers:
		List<Integer>numbers=new ArrayList<>();
		//add these numbers to the list:
		numbers.addAll(Arrays.asList(23,44,566,34,667,889,10000));
		//create an iterator for collections of Integers:
		ListIterator<Integer>intIter=numbers.listIterator();
		System.out.println("numbers in forward order:");
		
		while(intIter.hasNext()) {
			System.out.println("number is: " + intIter.next());
		}
		
		//System.out.println(intIter.next()); //this gives a NoSuchElementException (which is a runtimeException) as were at the end of the list
		/*
		 * At this point, the iterator points to the LAST number on the list, which is index pos 7. And iterator number of 8. 
		 * The final number of the iterator will be the total amount of numbers in the list the itarator is based on, which is 8 numbers. 
		 */
		
		System.out.println("\nNumbers in reverse order:");
		while(intIter.hasPrevious()) {
			System.out.println("number is: " + intIter.previous());
		}
		
		//System.out.println(intIter.previous()); //this gives a NoSuchElementException (which is a runtimeException) as were at the start of the list
		intIter=numbers.listIterator();
		
		System.out.println("\nfirst five numbers:");
		while(intIter.nextIndex()<5) {
			System.out.println("number is: " + intIter.next());
			
			/*
			if(intIter.nextIndex()>1)
					System.out.println("number is: " + intIter.next());
			*/
		}
		
		
		
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
