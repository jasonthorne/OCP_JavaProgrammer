package com.android;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.android.animals.Animal;
import com.android.animals.Behaviour;
import com.android.animals.Cat;
import com.android.animals.Collie;
import com.android.animals.Dinosaur;
import com.android.animals.Dinosaur.Type;
import com.android.animals.Dog;
import com.android.animals.FieldMouse;
import com.android.animals.Hamster;
import com.android.animals.Hippo;
import com.android.animals.Mouse;
import com.android.animals.Rat;
import com.android.humans.Fireman;
import com.android.humans.Human;
import com.android.humans.Nurse;

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
		//animalList.add(new Mouse());
		
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
		}
		
		System.out.println("next number is: " + intIter.next());
		
		//---------------------
		
		//create dogs:
		Dog spot = new Dog("spot", 12); 
		Dog rex = new Dog("rex", 5); 
		Dog lasie = new Dog("lassie", 6); 
		List<Dog>kennel = new ArrayList<>();
		
		kennel.addAll(Arrays.asList(spot, rex, lasie, new Dog("Benji", 40)));
		
		System.out.println(kennel);
		
		ListIterator<Dog>dogIter=kennel.listIterator(); //create iterator for kennel
		
		
		/*
		 * EXAMPLE OF WRONG WAY TO PRINT VALUES:
		while(dogIter.hasNext()) {
			
			System.out.println("name of dog is: " + dogIter.next().name);
			System.out.println("age of dog is: " + dogIter.next().age);
		}
	
		dogIter=kennel.listIterator(); //reset iterator
		*/
		
		while(dogIter.hasNext()) {
			
			/*
			 * we create a temp dog var and assign that the value of the next Dog
			 */
			Dog temp=dogIter.next();
			System.out.println("name of dog is: " + temp.name + ". age of dog is: " + temp.age);
		}
		
		
		/*
		 * INFINATE LOOP EXAMPLE:
		 * 
		 * If you have a while lopp that relies on a hasNext and you are at the start of your list.
		 * If you dont have a next method, your loop will be infinite. Nexxt is the command that causes your loop to move forward by 1.
		 * Similarly, if you are at the end of your list and you odnt have a pre, your loop will also be infinte.
		 * 
		 * 
		dogIter=kennel.listIterator(); //reset iterator
		while(dogIter.hasNext()) {
			System.out.println("dog is: " + dogIter.next());
			System.out.println("dog is: " + dogIter.previous());
		}
		 */
		
		//----------------------------------
		intIter=numbers.listIterator();
		
		System.out.println();
		System.out.println(numbers);
		
		/*
		while(intIter.nextIndex()<5) {
			if(intIter.nextIndex()>1)
					System.out.println("number is: " + );
		}
		*/

	}
	
	
	
	static void ex5() {
		System.out.println("\nEx5:");
		System.out.println("ARRAY DEQUE:"); //++++++++++++++++++++++++++++++++++++++++++++++
		
		/*
		 * These can be used instead of stacks (FILO/LIFO)
		 * 
		 * implements Collection, Queue, Deque & iteratble interfaces:
		 * Collection base class
		 * Queue extends Collection
		 * Deque extends Queue
		 * 
		 */
		
		Collection<String>collectDeque=new ArrayDeque();
		
		Queue<Hippo>queueDeque = new ArrayDeque<>();
		
		Deque<Dog>arrayDeque = new ArrayDeque<>();
		
		ArrayDeque<Cat>catArrDeque=new ArrayDeque<>();
		
		//does NOT implement the list interface:
		//List<Integer>noDeque=new ArrayDeque<>(); will not compile
		
		Deque<String>stringDeque=new ArrayDeque<>();
		stringDeque.addAll(Arrays.asList("hello", "apple", "orange", "apple", "orange", "banana")); //duplicates ARE allowed
		
		stringDeque.add("tomato"); //adding to arrayDeque
		System.out.println(stringDeque);
		
		//You CANNOT add a NULL ++++++++++++++++++++++++++
		//stringDeque.add(null); //gives nullPointer exception
		//System.out.println(stringDeque);
		
		/*You CANT add elements at a particular location in the list
		 * i.e have a list of strings called fruits and want  to add a fruit at pos 3
		 * stringDeque.add(3, "pineapple")
		*/
		
		System.out.println(stringDeque);
		
		//--------------
		
		//PUSH
		System.out.println("Push");
		
		//push adds an element at the BEGINNING of a list: (doesnt return a boolean)
		stringDeque.push("turnip");
		System.out.println(stringDeque);
	
		//add adds it to the END of the deque (returns a boolean):
		stringDeque.add("kumquot");
		System.out.println(stringDeque);
		
		
		//-------------
		
		//OFFER
		//same as add. (Also Returns a boolean).  
		System.out.println("Offer");
		System.out.println(stringDeque.offer("carrot"));
		System.out.println(stringDeque);
		
		//-------------
		
		//POP
		//removes the FIRST element from the collection, and returns that element
		System.out.println("Pop");
		System.out.println(stringDeque.pop()); //pop the first element from the arrayDeque:
		System.out.println(stringDeque); //element has been popped from the collection
		
		//---
		
		//If you try to pop fro man empty deque, you will get a NoSuchElementException, which is a runtime exception. 
		ArrayDeque<String>emptyDeq=new ArrayDeque<>(); //empty deque
		//emptyDeq.pop(); //gives a NoSuchElementException if the deque is empty. 
		
		//-------------
		
		//POLL
		//Does the same as popping, and removes the first element, and returns that element. 
		//DIFFERENCE BETWEEEN POP: If used on an empty deque this returns Null instead of NoSuchElementException given by Pop. ++++++++++++++++
		System.out.println(stringDeque.poll()); //remove the first element from the arrayDeque:
		System.out.println(stringDeque); //element has been removed from the collection
	
		//POLL LAST:
		//remove the last element of the collection:
		System.out.println("PoleLast");
		System.out.println(stringDeque.pollLast()); //last element
		System.out.println(stringDeque); //last element now removed from collection.
		
		//-------------
		
		//REMOVE
		//removes the first item from the collection (like pole and pop)
		System.out.println("Remove");
		System.out.println(stringDeque.remove()); //first element
		System.out.println(stringDeque); //first element now removed
		
		//gives a nosuchElementException if the deque is empty (like pop) ++++++++++++++++++++++++++++++++++++++++++++++++
		//emptyDeq.remove();
		
		
		//-------------
		
		//PEEK
		//allows us to see the first element of the collection
		System.out.println(stringDeque.peek()); //see first element
		System.out.println(stringDeque.peekFirst()); //also see last element
		System.out.println(stringDeque.peekLast()); //see last element
		
		//---------------
		
		List<Integer>numbers=new ArrayList<>();
		numbers.addAll(Arrays.asList(20, 345,67,765,3,20, 33,99,6666));
		
		/*
		 * The constructors for all sets, queues and lists can take a list, set or queue.
		 */
		
		 //Here we create an ArrayDeque from an existing list called numbers:
		ArrayDeque<Integer>deqNumbers=new ArrayDeque<>(numbers); //creating a queue from a list +++++++++++++++++++++
		
		//creating a set of Integers from an existing list called numbers:
		Set<Integer>setNumbers=new HashSet<>(numbers); //here the duplicates are removed ++++++++++++++++++++++++++++++++++++++++
		
		//creating a list of Integers from an existing list called numbers:
		List<Integer>listNumbers=new ArrayList<>(numbers);
		
		
		//--------
		int sum=0;
		
		while(!(deqNumbers.isEmpty())) { //while deque isnt empty
			sum=sum+deqNumbers.poll(); //add number to the sum and then remove it from the arrayDeque deqNumbers
			
			System.out.println("Sum is: " + sum);
			System.out.println(deqNumbers);
		}
		
		//-----------
		
		ArrayDeque<Dog>kennel = new ArrayDeque<>();
		List<Dog>dogList=Arrays.asList(new Dog(), new Dog("spot", 3), new Dog("rex", 5), new Dog("lassie", 10));
		kennel.addAll(dogList);
		System.out.println(dogList);
		System.out.println(kennel);
		
		//kennel=new ArrayDeque<>(dogList); //another way to create a kennel deque with a dogList
		System.out.println(kennel.peekLast()); //peek at last dog
		
		System.out.println(kennel.equals(dogList));
		
		//-------
		//BELOW ARE " DIFFERENT LISTS, BUT CONTAIN THE SAME DOGS: +++++++++++++++++++++++++++++++++++++++++++
		ArrayDeque<Dog>kennel2=new ArrayDeque<>(dogList);
		System.out.println(kennel2.equals(dogList)); //not equal. 1 is a deque made from dogList, other is dogList.
		
		System.out.println(kennel2); //arrayDeque of Dogs
		System.out.println(dogList); //list of Dogs
		System.out.println(kennel2.peekLast().equals(dogList.get(3))); //both are referencing the same dog, but the dog references are in DIFFERENT LISTS
		
	}
	
	static void ex6() {
		System.out.println("\nEx6:");
		System.out.println("LINKED LIST:"); 
		
		/*
		 * Implements Collection,  Queue, Deque & List.
		 * 
		 * Collection base Interface
		 * Queue extends Collection
		 * Deque extends Queue
		 * Also implements List
		 * 
		 * LinkedList implements both queue/Deque and List interface.
		 * 
		 * ALL methods of list list and deque are then available to this class, so allows duplicates and null elements.
		 * And elements can be added anywhere in a linked list. 
		 */
		
		LinkedList<String>strLinked=new LinkedList<>();
		strLinked.add("apple");
		strLinked.add("banana");
		
		strLinked.offer("orange"); //added to end
		strLinked.push("pineapple"); //added to start
		strLinked.add(1, "mango"); //added at pos 1
		strLinked.set(2, "pineapple"); //set this pos to be "pineapple"
		
		System.out.println(strLinked);
		
		//get is from list interface:
		System.out.println(strLinked.get(1)); //mango
		
		//Can add null: Cant do this with a queue:
		strLinked.push(null);
		
		strLinked.remove(1); //from list. remove at pos 1
		strLinked.remove();
		
	}
	
	
	static void ex7() {
		System.out.println("\nEx7:");
		System.out.println("SET INTERFACE:"); 
		
		//SET INTERFACE DOES NOT ALLOW DUPLICATES and elements are returned in no particular order.
		/*
		 * Extends the collection interface
		 * THe classes we cover are:
		 * HASHSET
		 * LINKEDHASHSET
		 * TREESET
		 */
		
		//-----------------
		//HASHSET:
			
		/*
		 * implements Collection and Set interface.
		 * Collection super interface
		 * Set interface extends Collection
		 */
		
		//You can have a set reference to a HashSet object:
		//Set<String>strHash=new HashSet<>();
		
		HashSet<String>strHash=new HashSet<>();
	
		//HashSet doesn't add elements in any particular order:
		System.out.println(strHash.addAll(Arrays.asList("noel", "NOEL", "mary", "shelly", "mary"))); //the 2nd mary will NOT be added
		
		System.out.println(strHash);
		
		//noel will not be added, and this will return false.
		System.out.println(strHash.add("noel"));
		
		List<String>names=new ArrayList<String>();
		names=Arrays.asList("harry", "noel", "shelly", "laura", "Colm", "NOEL", "MARY", "shelly");
		
		//this will not add strings that already exist in strHash
		strHash.addAll(names);
		System.out.println(strHash);
		
		System.out.println("Adding null: " + strHash.add(null));
		
		//Like with other elements though, you cant add a second null:
		System.out.println("Adding 2nd null: " + strHash.add(null));
		
		//-------
		
		//integer hashset:
		HashSet<Integer>intHash=new HashSet<Integer>();
		
		intHash.addAll(Arrays.asList(234,5,33,678,124));
		
		System.out.println("intHash is: " + intHash);
		
		/*
		 * If you are adding many elements to a hashset, you will not know how many elements will be added to your set. 
		 * set (duplicates are not added), so size here is more important for this class than previous collection classes.
		 */
		
		int size=intHash.size(); //size before we add elements
		intHash.addAll(Arrays.asList(4,4,99,123,999,67,121,119,3));
		int dif=intHash.size()-size;
		System.out.println("ammount of items of numbers added to list is: " + dif);
		
		
	}
	
	
	static void ex8() {
		System.out.println("\nEx8:");
		System.out.println("Hash set of animals"); 
		
		/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * elements are NOT added to a hashSet if:
		 * + An element with the same equals method but different hashcodes.
		 * + The equals method is different but same hashcode.
		 * + The equals method and the hashcode HAVE TO check the SAME things (eg. age and name)
		*/
		
		/*
		 * HashSet uses hashCode() methods to determine if 2 objects are the same or equal. 
		 * HashSet does not allow us to add 2 objects that have the same hashCode. 
		 * Animal does not override the hashCode method. So it will use the hashCode method implmentartion from the object class. 
		 * The same objects have the same hashcode. However a copy of the object has a different hashcode if you are using the object class hashcode method. 
		 */
		HashSet<Animal>animalHash=new HashSet<>();
		
		/*
		 * These 2 Animals have the same age & name. But the equals() and hashCode method are not overriden.
		 * So it will use the hashcode method from the Object class. It will alos use the equals method from the Object class, and will return true if they are the same object. 
		 * The hashcode method produces the same hash(number) if both objects are the same object. 
		 */
		System.out.println("Animal added: " + animalHash.add(new Animal(1, "andy"))); //will be added
		System.out.println("Animal added: " + animalHash.add(new Animal(1, "andy"))); //will be added
		
		//----------additional references to the same object wont be added:
		Animal andy = new Animal();
		Animal angela = andy; //andy and angela are the same Animal. 
		
		System.out.println("Animal added: " + animalHash.add(andy)); //this will be added
		System.out.println("Animal added: " + animalHash.add(angela)); //this will NOT be added
		
		
		//====================RATS:
		
		Rat ronnie = new Rat(4, "ronnie");
		Rat rachel = new Rat(4, "rachel");
		
		System.out.println("2 rats, same age: " + ronnie.equals(rachel));
		//Both rats have the same hashcode, which is produced from age:
		System.out.println(ronnie.hashCode());
		System.out.println(rachel.hashCode());
		
		/*
		 * If 2 rats have the same hashCode and return true when used against each other with the equals() method, 
		 * then they will NOT BE added to the set. 
		 */
		//attempt to add rats to animalHash:
		System.out.println("ronnie the rat is added?: " + animalHash.add(ronnie)); //will be added
		System.out.println("rachel the rat is added?: " + animalHash.add(rachel)); //wont be added
		
		//----
		System.out.println();
		HashSet<Rat>ratSet = new HashSet<>();
		
		System.out.println("Rachel added to the ratSet: " + ratSet.add(rachel)); //will be added
		System.out.println("Ronnie added to the ratSet: " + ratSet.add(ronnie)); //wont be added
		
		/*
		 * If you override ONLY the equals() or only the hashcode then both of the above Rats will be added to the sets. 
		 * As if you dont override either equals or hashCode it will then use the non overriden method from the object class. 
		 * Which will return true or equals() if and only if the same object, and returns the same hashcode if and only if they are the same object. 
		 */
		
		//-----------------------
		/*
		 * equals() and hashCode() are both overridden in the Dog class. And equals returns true if they have the same name and age. 
		 * If they have the same age and name then they have the same hashcode().
		 * Only lassie or prince will be added, as both references are the same Dog.
		 */
		Dog lassie = new Dog();
		Dog prince = lassie; 
		
		HashSet<Dog>kennel = new HashSet<>(Arrays.asList(
				lassie, //1. added to set
				prince, //2.  NOT added to set, as prince is the same dog as lassie
				new Dog(), //3. Not added to set as same name and age as dog1
				new Dog("spot", 2), //4. added to set
				new Dog("rex", 4), //5. added to set
				new Dog("spot", 2), //6. NOT added to set
				new Dog() //7. NOT added to set
			));
		
		System.out.println("amount of dogs added to set is: " + kennel.size());
		
		
		//====================================
		//Dinosaurs:
		//public Dinosaur(int age, String name, double weight, double height, Type type) {
		Dinosaur tRex = new Dinosaur(23, "TRex", 607.8, 23.2,Type.CARNIVORE); 
		Dinosaur tRex2 = new Dinosaur(23, "TRex", 607.8, 23.2,Type.CARNIVORE); 
			
		Dinosaur tRex3 = tRex2;
		Dinosaur bronto = new Dinosaur(12, "Brontosaurus", 1200.2, 40.0,Type.HERBIVORE); 
		Dinosaur trici = new Dinosaur(12, "Triceritpos", 400.12, 40.2,Type.OMNIVORE); 
		
		
		/*
		 * Sets (and in particular hashSets) do not have any particular order. So the order may not be the way the orders were input. ++++++++++++++++++++++
		 */
		Set<Dinosaur>dinoSet = new HashSet<>();
		System.out.println("\nadding dinosaurs");
		System.out.println(dinoSet.add(tRex)); //added
		System.out.println(dinoSet.add(tRex2)); //not added
		System.out.println(dinoSet.add(tRex3)); //not added
		System.out.println(dinoSet.add(bronto)); //added
		System.out.println(dinoSet.add(trici)); //added
		System.out.println(dinoSet.add(trici)); //not added
		System.out.println(dinoSet.add(null)); //added
		System.out.println(dinoSet.add(null)); //not added
		
		//----------------
		//Hamsters
		
		/*
		 * Every hamster has a unique ID so every hamster with the same age, name and weight will be entered into the set. 
		 */
		
		Hamster hamster1 = new Hamster(2,"harry", 2.5);
		Hamster hamster2 = new Hamster(2,"harry", 2.5);
		Hamster hamster3 = hamster1;
		
		Set<Hamster>hamsterSet=new HashSet<>();
		System.out.println("\nadding hamsters");
		System.out.println(hamsterSet.add(hamster1));
		System.out.println(hamsterSet.add(hamster2));
		System.out.println(hamsterSet.add(hamster3));
		
	}
	
	static void ex9() {
		System.out.println("\nEx9:");
		System.out.println("Linked HashSet"); //arranged how they're imputted.
		
		/*
		 * Implements the Set and Collection Interface, and is a subclass of HashSet.
		 * Similar to hashSet in that you cannot enter duplicate entries, however the items are ORDERED IN WHATEVER WAY THEY WERE ENTERED. 
		 * So order is guaranteed in the way they were entered. 
		 * this DOES NOT IMPLEMENT the LIST INTERFACE. ++++++++++++++++++++++++++++++++++++++++MIGHT BE ON EXAM +++++++++++++++
		 */
		
		Set<Animal>animalLHS=new LinkedHashSet<>();
		
		//NO hashcode and equals in Animal, so it uses the default ones in Object, which just checks if they're the same objects.
		System.out.println(animalLHS.add(new Animal())); //true
		System.out.println(animalLHS.add(new Animal())); //true
		System.out.println(animalLHS.add(new Dog("spot", 2))); //true
		System.out.println(animalLHS.add(new Dog("spot", 2))); //false
		
		System.out.println(animalLHS);
		
		//-----------
		List<Dog>dogList=new ArrayList<Dog>();
		dogList.addAll(Arrays.asList(new Dog("spot", 2), new Dog("rex", 4), new Dog("lassie", 3), new Dog("benhji", 4)));
		
		Set<Dog>dogLHS=new LinkedHashSet<Dog>();
		dogLHS.addAll(dogList); //add list to linked hash set
		System.out.println(dogLHS); //print lhs
		
		
		//------------------------------
		//adding obj to set:
		Dog prince = new Dog("prince", 12);
		System.out.println(dogLHS.add(prince)); //adding to hashSet
		System.out.println(dogLHS);
		
		//removing from set:
		System.out.println(dogLHS.remove(prince));
		System.out.println(dogLHS);
		
		//===============================================
		//containsAll:
		
		//avaliable to all classes that implement Collection interface
		Dog spot = new Dog("spot", 2);
		Dog lassie = new Dog("lassie", 3);
		Dog benji = new Dog("benji", 4);
		Dog lady = new Dog("lady", 4);
		
		//create kennel list and add 4 dogs to it (in one order)
		List<Dog>kennelList=new ArrayList<>();
		kennelList.addAll(Arrays.asList(spot, lassie, benji, lady));
		
		//create set and add dogs
		Set<Dog>dogSet=new LinkedHashSet<Dog>();
		dogSet.addAll(Arrays.asList(new Dog(), new Dog("ruby", 5), new Dog("babe", 8)));
		
		//add first 4 dogs to set (in a different order to that inserted into kennel list)
		dogSet.add(spot);
		dogSet.add(benji);
		//dogSet.add(lady);
		//dogSet.add(lassie);
		
		System.out.println();
		System.out.println(dogSet);
		//checks to see if it contains the same elements as found in kennel list ++++++++++++++++++++++++++++++++++++++
		System.out.println("dogSet containsAll: " + dogSet.containsAll(kennelList)); 
		
		
		//----------------------------------------
		//removeAll:
		//remove ANY elements found in the list that are also in kennel list: ++++++++++++++++++++++++++++++++++++++++
		System.out.println("dogSet removeAll: " + dogSet.removeAll(kennelList)); 
		
		System.out.println(dogSet);
		
	}
	
	static void ex10() {
		System.out.println("\nEx10:");
		
		//TREE SET
		System.out.println("TREE SET"); 
		
		/*
		 * Implements the following interfaces:
		 * Collection<E>
		 * Set
		 * Navigable Set
		 * SortedSet
		 * Iterable
		 * Comparable
		 * 
		 * Navigable and sorted Set are both subinterfaces of set
		 * 
		 * prints out in ascending order by default. 
		 * So numbers print: 1 > 2 > 3.
		 * strings and chars: non-numeric >  numbers > uppercase > lowercase
		 * 
		 * Only objects that implement the Comparable interface can be added to a treeSet.
		 * All numeric wrappers and the string class implement the comparable interface.
		 * The only abstract method in the comparable interface is the method: compareTo().
		 * This method is used to determine order and the treeset uses this overloaded method to determine order. (covered in detail in the next section).
		 * 
		 */
		
		TreeSet<String>stringTs=new TreeSet<>();
		stringTs.addAll(Arrays.asList("zed", "12", "adam", "!he", "Betty", "aidan", "adam"));
		System.out.println("stringTs: " + stringTs);
		
		List<Integer>numbers=new ArrayList<>();
		numbers.addAll(Arrays.asList(56,2,34,56,12,9,12,3,1000,450,9,6,3,449,448,1));
		
		TreeSet<Integer>intTree=new TreeSet<>();
		intTree.addAll(numbers);
		System.out.println(intTree);
		
		/*
		 * Like all sets, duplicates are NOT allowed. 
		 * The order is set by only objects that implement comparable interface can be added to a TreeSet. 
		 */
		
		//=============================
		
		/*
		 * Mouse implements Comparable and only an object who's class implements comparable can be added to  treeSet. 
		 * The mouse class can organise by the name of the mouse (string) or the age of the mouse (Integer). 
		 */
		Mouse mikey = new Mouse("mickey", 10);
		Mouse jerry = new Mouse("jerry", 7);
		Mouse maggie = new Mouse("maggie", 2);
		Mouse mary = new Mouse("mary", 4);
		Mouse mouse1 = mary;
		
		TreeSet<Mouse>mouseTree=new TreeSet<Mouse>();
		mouseTree.addAll(Arrays.asList(mouse1, mary, maggie, jerry, mikey));
		System.out.println(mouseTree);
		
		//------
		//treeSet of Animals:
		
		/*
		 * This treeSet CANNOT take an Animal object, as Animal DOES NOT implement Comparable. However you can add any subclass that implements comparable. 
		 */
		TreeSet<Animal>animalTree=new TreeSet<>();
		
		//Below creates the runTime exception classCastException, as treeSets can ONLY take objects who's class implements Comparable. 
		//The Animal class DOES NOT implement Comparable: 
		//System.out.println(animalTree.add(new Animal())); //doesnt implement comparable, so throws up
		//System.out.println(animalTree.add(new Dog())); //doesnt implement comparable, so throws up
		
		//You CAN however add any class that implements the comparable interface, and ANY subclass of that class.
		System.out.println(animalTree.add(mikey));
		System.out.println(animalTree.add(new FieldMouse("freddie", 4)));
		
		/*
		 * NONE of Dog's subclasses currently implement comparable. However some subclass in the future MAY implement comparable
		 * and then objects of that subclass will be able to be added to this TreeSet.
		 * You can create a TreeSet of any type, even if that type doesnt implement the comparable interface.
		 */
		TreeSet<Dog>dogTree=new TreeSet<>();
		
		/*
		 * This can take ANY object who's class implements the comparable interface:
		 */
		TreeSet<Object>objTree=new TreeSet<>();
		
		/*adding the int beow makes this now a TreeSet of Object reference to a TreeSert of Integer Objects object. +++++++++++++
		 * Basically it now makes the treeSet integer only :D. It sets the treeSet.
		*/
		System.out.println(objTree.add(12));
		//System.out.println(objTree.add("hello world!")); //this now falls over as objTree can now ONLY take Integers.
	
		
		//==============================================================
		
		//ITERATOR WITH TREESET+++++++++++++++++++++++
		System.out.println("\nITERATOR WITH TREESET:");
		System.out.println(intTree);
		
		Iterator intIt=intTree.iterator();
		
		/*
		 * When you are working with Sets, you do not have a hasPrevious() or previous. 
		 */
		while(intIt.hasNext()) {
			System.out.println("number iterator is: " + intIt.next());
		}
		
		System.out.println("Descending order");
		
		//Descending iterator. THis will progress through the set in descending order:
		Iterator descIntIt=intTree.descendingIterator();
		
		while(descIntIt.hasNext()) {
			System.out.println("descending order number is: " + descIntIt.next());
		}
		
		//---------------------------
		
		//Creating an iterator with a generic type of Integer:
		Iterator<Integer>it=intTree.descendingIterator(); 
		
		while(it.hasNext()) {
			//int num=(Integer)it.next(); //store number in temp var (casting to int as iterator is obj) ++++++THIS ISNT NEEDED as iterator is given a type of Integer (otherwise would be0
			int num=it.next(); //no cast needed here as the iterator is given a generic type of Integer
			if(num%2>0) {
				it.remove();
			}
		}
		
		System.out.println("int Tree is now:");
		System.out.println(intTree);
		
		//-------------------------------
		
		
		it=intTree.iterator(); //reset iterator
		System.out.println(intTree.add(300)); //add another number to intTree
		System.out.println(intTree);
		
		/*
		while(it.hasNext()) {
			 //iterator now no longer works as the list has been changed after iterator creation. ++++++++++++++++++++
			//System.out.println("number is: " + it.next()); //runtime exception is: ConcurrentModificationException
		}
		*/
		
		//----------------------------
		/*
		 * ListIterator does NOT WORK on sets of any description
		 * ListIterator works on all lists and queues
		 * ITERATOR does work on sets. 
		 */
		Set<Integer>mySet=new HashSet<>();
		Iterator myIt = mySet.iterator();
		///ListIterator myListIt=mySet.ListIterator(); 
		
		
		/*
		 * Iterator does NOT HAVE previous or hasPrevious()
		 * Iterator also does NOT HAVE add()
		 */
		
		List<String>fruits=new ArrayList<>();
		
		fruits.addAll(Arrays.asList("banana", "apple", "cherry", "pineapple", "strawberry", "orange", "mango"));
		//Iterator fruitIt=fruits.iterator(); //creating an iterator for fruits.
		
		ListIterator<String>fruitListIt=fruits.listIterator(); //create a listIterator for fruits
		String fruit;
		
		while(fruitListIt.hasNext()) {
			fruit=fruitListIt.next();
			if(fruit.equals("cherry")) {
				fruitListIt.add("blueberry");
			}
		}
		
		System.out.println(fruits);
		
		fruitListIt=fruits.listIterator(); //redefine iterator
		while(fruitListIt.hasNext()) {
			System.out.println(fruitListIt.next());
			//this is the end of the list
		}
		
		System.out.println(fruits);
		
		fruits.add("turnip"); //add an extra elelement to fruits
		
		/*
		while(fruitListIt.hasPrevious()) {
			//this will cause a ConcurrentModificationException as the list of strings now has 9 strings in it. 
			///	System.out.println(fruitListIt.previous()); 
		}
		 */
		
		fruitListIt=fruits.listIterator();  //redefine iterator (isd now based on 9 strings)
		System.out.println(fruits);
		
		fruits.set(4, "apple"); //change pineapple to apple
		System.out.println(fruits);
		
		//Iterator still works AS IT HAS THE SAME NUMBER OF ELEMENTS +++++++++++++++++
		while(fruitListIt.hasNext()) { 
			System.out.println("fruit is: " + fruitListIt.next()); 
		}
		
		
		//=========================================================
		
		TreeSet<Integer>integers=new TreeSet<Integer>();
		
		while(integers.size()<10) {
			integers.add((int)(Math.random()*10));
		}
		
		System.out.println(integers);
		integers.clear(); //clear the set
		
		
		/*
		 * This tries to create a set of 11 numbers, 
		but we can only use the numbers 1-9 and as it is a set we cant have duplicates, 
		so this will be an infinate loop and will get stuck when it gets to 9.
		
		while(integers.size()<=10) {
			integers.add((int)(Math.random()*10));
		}
		*/
	}
	
	
	static void ex11() {
		System.out.println("\nEx11:");
		
		//MAPS
		System.out.println("MAPS"); 
		
		/*
		 * Map interface does NOT extend the collection interface. ++++++++++++++++++++++
		 * A map has a key and a value. IE Key: car reg 191g23456, Value: Porche 911
		 * 
		 * key pps: 4454545454
		 * value: John Doe
		 * 
		 * Keys have to unique. Duplicate keys are not allowed. Duplicate values are allowed.
		 * Keys are used to uniquely identify one of the items on your map.
		 * 
		 * We will be focusing on: HashMap, linkedHashMap, TreeMap.
		 * 
		 * TreeMap are sorted by the SortedMap interface.
		 * TreeMap, HashMap & LinkedHashMap ARE NOT SYNCHRONIZED. (NOT THREAD SAFE)
		 */
		
		//HASHMAP:
		
		System.out.println("consists of a key and a value (No primitives allowed), null is allowed");
		
		//HashMaps are not in any particular order 
		
		//Map is an interface:
		//Map<K,V> interface
		
		/*
		 * String is the name of the person (key), Double are the wages of the person (value)
		 */
		Map<String, Double>salary=new HashMap<>();
		
		
		//----------------------------
		//We insert values into a map by using the Put() method: 
		
		//Put()
		System.out.println("Put()");
		salary.put("me", 33.3); //"me" is the key, "33.3" is the value
		salary.put("you", 3.33);
		salary.put("us", 333.333);
		
		System.out.println(salary);
		
		
		/*
		 * put() returns the value of the key, if no value exists for "them", which it doesnt, 
		 * as this is a new key/value pair, so this will return null.
		 */
		System.out.println(salary.put("them", 3.3));
		
		
		/* +++++++++++++++++++++++++++++++CHANGING A VALUE:++++++++++++++
		 * 
		 * PUT: 
		 * 
		 * If you attempt to put in another value for shela, 
		 * it WILL be input BUT it will display the previous value for shela.
		 * Duplicate keys are NOT ALLOWED, so this WILL overwrite the existing value of 3.3 for "them"
		 */
		System.out.println(salary.put("them", 3.333));
		
		/*
		 * REPLACE:
		 * 
		 * does same thing as put:
		 */
		System.out.println("using replace: " + salary.replace("them", 1.1));
		System.out.println(salary);
		//++++++++++++++++++++++++++++++++++++++++++++++++
		
		//add new key/value pairs. Duplicate values ARE ALLOWED
		salary.put("Bob", 100.00);
		salary.put("Bill", 100.00);
		
		System.out.println(salary);
		
		//-----------getting items from a HashMap:
		
		/* HasahMaps are not in any particular order so:
		If you want to get a particular value, you use get in conjunction with the key. 
		So in this case, we use the name to get the wages. 
		*/
		
		System.out.println("Wages of Bob: " + salary.get("Bob"));
		System.out.println(salary.get(1)); //returns null
		System.out.println(salary.get("purple-monkey-dishwasher")); //returns null
		
		//you can have null as a key. but can only be there ONCE
		salary.put(null, 34500.0);
		
		salary.put(null, 3.0); //wont be added
		System.out.println(salary);
		
		
		//Can have multiple null values:
		salary.put("Ben", null); 
		salary.put("Douglas", null); 
		System.out.println(salary);
		
		
		//----------------------------------------------
		
		//PUT IF ABSENT:
		System.out.println("PUT IF ABSENT");
		
		//if this key DOESNT exist: put in the key and value. If this key DOES exist: dont change the existing key/val. +++++++++++++++++++++++++++++++++
		
		//add 2 key/values:
		salary.put("kevin", 150_000.0);
		salary.put("Mick", 75_000.0);
		
		System.out.println(salary.putIfAbsent("Mick", 100.00)); //WONT be put as key/val already exists.
		System.out.println(salary.putIfAbsent("Donald", 80.00)); //WILL be put as key/val doesnt already exist.
		
		System.out.println("salary after 'put with absent': " + salary);
	
	}
	
	
	static void ex12() {
		System.out.println("\nEx12:");
		
		//HASHMAP OF FIREMAN:
		Map<Integer, Fireman>firemen=new HashMap<>();
		
		//add 5 Fireman objs to firemen:
		for(int i=1;i<6;i++)
			firemen.put(i, new Fireman());
	
		
		System.out.println(firemen);
		System.out.println("We have " + firemen.size() + " firemen");
		
		System.out.println(firemen.get(2)); //2 is for key. 2 is NOT for position +++++++++++++++++++++++++++++++++++++++++++
		System.out.println(firemen.put(2, new Fireman("sam"))); //add a new fireman to the KEY of 2. 
		System.out.println(firemen.get(2).toString()); //call the toString method for the fireman with a key of 2.
		System.out.println(firemen);
		
		//---------------------
		
		/*
		 * A map with a Fireman key and a Double value:
		 */
		Map<Fireman, Double>payRoll=new HashMap<>();
		Fireman bruce = new Fireman("bruce");
		payRoll.put(new Fireman(), 34_000.0); //fireman object as key, double as value - GOES IN
		payRoll.put(bruce, 50_000.0); //add bruce as key - GOES IN
		payRoll.put(new Fireman("mary"), 75_000.0); //fireman object as key, double as value - GOES IN
		payRoll.put(bruce, 100_000.0); //add bruce AGAIN, but with different value - CHANGES VALUE
		payRoll.putIfAbsent(bruce, 250_000.0); //use a put with absent with bruce - DOESNT CHANGE VALUE (as bruce exists)
		
		Fireman fred=new Fireman("fred");
		System.out.println("put on fred: " + payRoll.put(fred, 200_000.00)); //display null as fred didnt prev exist. If it had, this would display his prev value.
		//this value is NOT put in as fred exists:
		System.out.println("put on fred: " + payRoll.putIfAbsent(fred, 400_000.00)); 
		
		System.out.println("payroll: " + payRoll);
		
		//---------
		//A key/value can be ANY object +++++
		Map<Human, ArrayList<Dog>>mapsList; //+++++++++++++++++++++++++++++++Human key, list of Dogs as value
		Map <Human, Set<Animal>>mapHumanAnimals;
		Map<Human,Set<? super Dog>>funkyMap;
		//------------
		
		
		/*What determines if a key is unique is the equals() and hashcode() methods. 
		 * In the Nurse class we have overriden the equals and hashcode methods. Such that if 2 nurses habe the same name, they will have the same hashcode.
		 * return true when equals is run against both of them
		 */
		
		//make some nurses:
		Nurse nurse1 = new Nurse("helen");
		Nurse nurse2 = new Nurse("mary");
		Nurse nurse3 = new Nurse("helen"); //nurse 3 is the same as nurse 1, so this merely modifies nurse 1's values.
		
		/*A hashmap with a nurse key, which means each nurse has to be unique, 
		and will be determined that it is unique by the equals and hashcode method in the Nurse class.
		It has a double value
		*/
		Map<Nurse, Double>nurses=new HashMap<>();
		nurses.put(nurse1, 25_000.00);
		nurses.put(nurse2, 56_000.00);
		/*add a DIFFERENT object, but with the SAME NAME as nurse1. Meaning it wont be added as the name is taken into account in the equals method.
		 * It WILL however CHANGE THE VALUE to 100_000.00 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 */ 
		
		/*also called "helen" so this is determined to be the same as nurse1 as the euqals and hashcode method only uses name 
		 * so 2 nurses called helen cannot be used as keys, so the second value of 100k is put in for the nurse called helen.
		 */
		nurses.put(nurse3, 100_000.00);  
		
		//nurses.putIfAbsent doesnt put in a value if a nurse named "helen" is already in the hashMap
		
		
		System.out.println(nurses);
		System.out.println(nurses.get(nurse1));
		System.out.println(nurses.get(nurse3));
		
		
		
		//==========================================================
		//object as keys:
		Dog dog1 = new Dog(); //this key will be inputed
		Dog dog2 = new Dog(); //this key will NOT be inputed, because it has the same name and age as the first dog (age and name of 0)
		Dog dog3 = new Dog("spot", 1); //this key WILL be inputed
		Dog dog4 = new Dog("spot", 1);
		
		Map<Dog,String>dogMap=new HashMap<Dog,String>();
		dogMap.put(dog1, "dog1"); //key & value are inputed
		dogMap.put(dog2, "dog2"); //not inputed, BUT the object's toString is changed (as this one's toString mentions "dog2")
		dogMap.put(dog3, "dog3"); //key & value are inputed
		dogMap.put(dog4, "dog4"); //not inputed, BUT the object's toString is changed (as this one's toString mentions "dog4")
		
		System.out.println(dogMap); //prints: {name is: null. age is: 0=dog2, name is: spot. age is: 1=dog4}
		
		//=============================+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//KEYSET - returns a set containing all the keys. VALUES - returns a collection of the Map values.
		
		
		Map<Integer, String>namesMap=new HashMap<>();
		namesMap.put(1, "ann");
		namesMap.put(2, "brid");
		namesMap.put(3, "mary");
		namesMap.put(4, "paddy");
		namesMap.put(5, "kathleen");
		
		for(int i=1;i<=namesMap.size();i++) {
			System.out.println("namesMap: " + namesMap.get(i));
		}
		
		System.out.println(namesMap);
		
		//------------
		
		namesMap.put(5000, "noel");
		namesMap.put(7, "ane");
		namesMap.put(123, "colm");
		namesMap.put(99, "shelly");
		namesMap.put(101, "laura");
		
		//This returns a SET containing all of the keys for namesMap. In this case it will be a set of Integers. 
		System.out.println("all of the keys: " + namesMap.keySet());
		
		/*
		 * this returns a Collection of the values for namesMap. In this case, it will be a collection of Strings.
		 */
		System.out.println("all of the values: " + namesMap.values());
		
		/*
		 * The order of the keys and values will match ++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * so you can spin through 1, and relate it to the other.
		 */
	
		for(Integer i:namesMap.keySet())
			System.out.println("key is: " + i);
		
		System.out.println();
		
		for(String j:namesMap.values())
			System.out.println("value is: " + j);
		
		//-------------------------------
		System.out.println();
		for(Integer k:namesMap.keySet()) { //[produces a set of keys
			System.out.println("value is: " + namesMap.get(k)); //get the value of the kth pos (k is the key)
			System.out.println("key is: " + k);
			System.out.println(k.hashCode());
		}
		
		//------------------------------
		
		Map<Fireman, Double>fireWages=new HashMap<>();
		
		//2 unique firemen:
		Fireman sam = new Fireman(); 
		Fireman fred2 = new Fireman();
		
		fireWages.put(sam, 50_000.00);
		fireWages.put(fred2, 50_000.00);
		
		
		//==========================================================================
		
		//Map.Entry +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		/*
		 * An interface with 3 methods: getKey(), getValue, setValue().
		 * 
		 * We use this structure for going through a hashmap and getting the key,
		 * and changing the value for a particular entry.
		 * 
		 * getKey() here will return whatever the data type we have said our key is (in this case an Integer)
		 * getValue() will return the value and the data type we have said our value is (in this case a String)
		 */
		Map.Entry<Integer, String>myEntry=new Map.Entry<Integer, String>(){

			@Override
			public Integer getKey() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getValue() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String setValue(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		/*
		 * Names map defined above:
		namesMap.put(5000, "noel");
		namesMap.put(7, "ane");
		namesMap.put(123, "colm");
		namesMap.put(99, "shelly");
		namesMap.put(101, "laura");
		*/
		
		//ENTRY SET() +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		//returns a Set made up of Map.Entry objects. (A set of Map.Entry<Integer, String> objects.
		System.out.println(namesMap.entrySet()); 
		
		//------------------------looping through entry set:
		
		//looping through enrtSet. (using one entry set to go over namesMap.entrySet()) +++++++++++++++++++++
		for(Map.Entry<Integer, String>entry: namesMap.entrySet()) { 
			System.out.println("key of entry is: " + entry.getKey()); //get the key of every entry in hashmap
			System.out.println("value of entry is: " + entry.getValue()); //get the value of every entry in the hashmap
			
			if(entry.getValue().equals("ann")) //if the value equals anne
				entry.setValue("kate"); //change its value to kate
			
			//you CANT remove an entry this way, as your in the loop that you're trying to alter:
			/*
			if(entry.getValue().equals("mary"))
				namesMap.remove(entry.getValue()); 
			*/
		}
		
		//show new results:
		System.out.println(namesMap.entrySet()); //show altered entrySet
		System.out.println(namesMap); //map is also altered
		
		//------------------------iterating through entry set: (ALLOWS FOR REMOVAL OF VALUES)
		
		//ListIterator doesnt work here. HAS to be an Iterator
		Iterator<Map.Entry<Integer, String>>myIterator=namesMap.entrySet().iterator(); //an Iterator for the namesMap set
		
		/*
		 * Using this iterator we will delete this key/value: pair 3=mary
		 */
		
		while(myIterator.hasNext()) { //while there is another value in the entry set.
			String str=myIterator.next().getValue(); //move to next element
			
			if (str.equals("mary")) //if entry 
				myIterator.remove(); //remove that entry (the KEY and VALUE is removed)
		}
		
		
		//------------------------PUT ALL
		
		/*
		 * You can add an existing HashMap to a hashMap by using putAll:
		 */
		Map<Integer, String>moreNames=new HashMap<>();
		moreNames.put(333, "bob");
		moreNames.put(1, "bill");
		moreNames.putAll(namesMap); //adds the contents of one hashmap to another. If a key already exists, the value will NOT be added. 
		
		System.out.println(namesMap);
		
		//=====================================================================================
		//STREAMS +++++++++++++++++++++IMPORTANT!! +++++++++++++++++
		
		moreNames.entrySet(); //flatten moreNames hashmap to a set
		
		/*flattening gives us access to Streams
		 * forEach is a consumer object (that returns nothing)
		 * that takes each item in the entrySet (e is each record in the set)
		 * call getKey on each set entry to get the entry set key.
		 * call getValue on each set entry to get the entry set value.
		 */
		moreNames.entrySet().stream().forEach(e->System.out.println(e.getKey()+ ":" + e.getValue()));
		
		
		//==================
		//USING FILTER WITH STREAMS:
		
		//a is the value of each entry in the set (hashmap entry's key and value).
		//filter removes the entries that dont match the search. 
		moreNames.entrySet().stream().filter(a->a.getKey()>10).forEach(a->System.out.println(a.getValue()));
		
		//==================
		//USING FILTER WITHOUT STREAMS:
		//here forEach takes in a BICONSUMER that is taking in the hashmap entries in their original key and value form. (breaks them back up basically :P)
		moreNames.forEach((k,v)->System.out.println("key is: " + k + "value is: " + v));
	}
	
	
	
	static void ex13() {
		System.out.println("\nEx13:");
		
		//LINKED HASH MAP - 
		/*
		 * Items are displayed in the order they were entered. 
		 * Linked means they are displayed in the order they were inserted.
		 * 
		 * LinkedHashMap are displayed in the order they were entered. 
		 */
		
		//some dogs:
		Dog spot = new Dog("spot", 2);
		Dog rex = new Dog("rex", 7);
		Dog benji = new Dog("benji", 5);
		Dog lassie = new Dog("lassie", 3);
		
		//map of integers and dogs. Key (integer) made from the dog's hashcode
		Map<Integer, Dog>dogLinked=new LinkedHashMap<>();
		dogLinked.put(spot.hashCode(), spot);
		dogLinked.put(rex.hashCode(), rex);
		dogLinked.put(benji.hashCode(), benji);
		System.out.println(dogLinked);
		
		//DONT DO (as it doesnt make sense :P)   +++++++++++++++++++
		dogLinked.put(benji.hashCode(), lassie); //Changing this entry, by adding a different dog as the value 
		
		System.out.println(dogLinked);
		
		
		dogLinked.put(benji.hashCode(), new Dog("prince", 25));
		
		System.out.println(dogLinked);
		
		
		//-----------
		
		Map<Integer, String>linkedAnimal=new LinkedHashMap<>();
		int counter=0;
		linkedAnimal.put(++counter, "pig");
		linkedAnimal.put(++counter, "sheep");
		linkedAnimal.put(++counter, "chicken");
		
		System.out.println(linkedAnimal.values()); //print all the values
		System.out.println(linkedAnimal.values()); //print all the keys
	}
	

	static void ex14() {
		System.out.println("\nEx14:");
		
		//TREE MAP ++++++++++++++++++++++++++++++++++++
		/*
		 * Tree maps are maps with all the same advantages of MAPS, 
		 * but the key HAS TO implement the comparable interface 
		 * (Integers, all numbers, Strings etc all implement the comparable interface)
		 * IE if you have a numeric type as a key, then your records will be stored in ascending order according to the key.
		 * this class implements:
		 * MAP<K,V>
		 * NavigableMap<K,V>
		 * SortedMap<K,V>
		 */
		
		Map<Integer, String>animalTm=new TreeMap<Integer, String>();
		//add integers:
		animalTm.put(5, "camel");
		animalTm.put(1, "horse");
		animalTm.put(3, "sheep");
		animalTm.put("cow".hashCode(), "cow"); //adding cow string's hashcode as key +++++++++++
		animalTm.put("chicken".hashCode(), "chicken");
		
		System.out.println(animalTm);
		
		//--------------------
		
		Map<Fireman, Integer>fireInt = new TreeMap<>();
		
		//Only classes that implement the comparable interface can be added as a key.
		//Below wont give a compile error, but will fallover on runtime.
		//fireInt.put(new Fireman(), 6);
		
		//-----------------
		
		Map<Animal, Integer>animalInt = new TreeMap<>();
		
		//animalInt.put(new Animal(), 3); //animal doesnt implement Comparable so this will crash
		
		//this CAN be added as a key, as Rat DOES implement the comparable interface:
		animalInt.put(new Rat(3, "Roland"), 3); 
		
		System.out.println(animalInt);
		
		//---------------------
		
		//reverse order:
		
		Map<Integer, String>reverseAnimal = new TreeMap<>(Collections.reverseOrder());
		reverseAnimal.putAll(animalTm);
		
		System.out.println(reverseAnimal);	
		
	}
	
	
	
	static void ex15() {
		System.out.println("\nEx15:");
		
		List<Integer>intList=new ArrayList<>();
		intList.addAll(Arrays.asList(23,45,67,45,89,99,100));
		
		//FOR EACH() ++++++++++++++++++
		
		/*
		 * for each works for all objects that implement the collection interface (List, Set, Queue) and maps
		 * and goes through each item in the list and performs some action without changing the original list
		 */
		
		/*
		 * a forEach for a list, Set or queue takes a consumer, takes an object and returns void.
		 */
		
		intList.forEach(a->System.out.println("Double the number: " + (a*2)));
	
		Map<Integer, String>nameMap = new HashMap<>();
		nameMap.put(3, "mary");
		nameMap.put(7, "kate");
		nameMap.put(15, "pat");
		/*
		 * a forEach for a Map takes a bi-consumer. A bi consumer takes 2 objects and returns void. 
		 * This forEach is called by a hashMap that is like the following:
		 * Map<Integer, String>nameMap 
		 * so k will be an Integer
		 * and v will be a String
		 */
		nameMap.forEach((k,v)->System.out.println("key is: " + k + "value is: " + v)); 
		
		//-------------------------------------------------------------------------------------------
		//REPLACE ALL ++++++++++++++++++
		
		/*
		 * replaces all of the values in a set, list or queue.
		 * It takes a unary operator (which takes an object of a type, and returns an object of the same type).
		 * Here it takes an int and returns an int. 
		 * This multiplies all our numbers by 3, so our list now has numbers that are the original numbers multiplied by 3. 
		 */
		
		//UNARY OPERATOR - takes an object of a type, and returns an object of the SAMRE type.
		System.out.println("before change:");
		System.out.println(intList);
		
		intList.replaceAll(a->a*3); //times all by 3.
		
		System.out.println("after change:");
		System.out.println(intList);
		
		
		intList.replaceAll(a->a/3); //divide all by 3.
		
		System.out.println("after change:");
		System.out.println(intList);
		
		
		//-------------------------------------------------------------------------------------------
		//REMOVE ALL ++++++++++++++++++
		intList.add(23);
		System.out.println("before removal: " + intList);
		/*
		 * removeALl seaches the list intList for all the numbers that are contained in newList (23,89,1000)
		 */
		
		List<Integer>newList=Arrays.asList(23,89,1000);
		intList.removeAll(newList); //removes from intList, whatever is common in newList. +++++++++++++++++++++++++++++
		//after removal:
		System.out.println("after removal: " + intList);
		
		
		//-------------------------------------------------------------------------------------------
		//REMOVE DUPLICATES ++++++++++++++++++
		
		intList.addAll(Arrays.asList(23,45,45,23,23));
		System.out.println(intList);
		
		Set<Integer>setInt=new HashSet<>(intList); //create a hashset from intList (REMOVES ALL DUPLICATES)
		
		//---------
		
		Set<Integer>treeInt=new HashSet<>(intList);
		System.out.println(treeInt); //list is now ordered.
		
		
		//-------------------------------------------------------------------------------------------
		//TO ARRAY ++++++++++++++++++
		
		int size = treeInt.size(); //REMEMBER treeInt is a HASHSET
		
		Integer[]intArray=treeInt.toArray(new Integer[size]);
		
		for(Integer i:intArray)
			System.out.println("array is: " + i);
		
		
		//=================================================================================
		
		//REMOVE FOR MAPS:
		
		Map<Integer, String>myMap=new HashMap<>();
		
		for(Integer i:treeInt)
			myMap.put(i, "str"+i);
		
		System.out.println(myMap);
		
		/*
		 * This removes the entry with the key of 67, and the value of "str67"
		 */
		myMap.remove(67);
		System.out.println(myMap);
		
		/*this type of remove below, will ONLY remove this entry if the key and value match the key AND value of the map. 
		 * The below example doesnt, as the key is 99 and the value is str99:
		*/
		myMap.remove(99,"banana");
		System.out.println(myMap); //9 is still there
		
		//--------------------
		
		//replace: 
		
		/*
		 * will only replace the value if the existing value is "banana"
		 * Its not so its not replaced.
		 * If the value isnt there, then NOTHING happens. It isnt put in instead.
		 */
		myMap.replace(99, "banana", "orange");
		System.out.println(myMap); //mot replaced
		
		myMap.replace(99, "str99", "banana");
		System.out.println(myMap); //IS replaced
		
		
		//-------------------------
		//replace all: 
		
		/*
		 * Changes ALL of the values. Here it changes each value to the following:
		 */
		
		myMap.replaceAll((k,v) ->{
			v=k+"str";
			return k + "str";
		});
		
		System.out.println(myMap);
		
	}
	
}
