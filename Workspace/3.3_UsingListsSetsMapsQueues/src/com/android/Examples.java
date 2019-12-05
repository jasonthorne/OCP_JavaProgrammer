package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.android.animals.Animal;
import com.android.animals.Cat;
import com.android.animals.Dog;
import com.android.animals.Hippo;

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
		
		
		
		ArrayList<String>strArrList = new ArrayList<>();
		///strArrList.
		
	}

}
