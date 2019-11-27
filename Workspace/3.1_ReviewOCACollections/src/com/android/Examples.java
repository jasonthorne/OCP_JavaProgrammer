package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Examples {
	
	static void ex1() {
		
		/*
		 * ALL collections can only house OBJECTS
		 * 
		 * ArrayList class implements the List interface:
		 */
		List<String>fruits=new ArrayList<>();
		
		System.out.println("add");
		//add single elements:
		fruits.add("apple");
		fruits.add("orange");
		System.out.println(fruits);
		//----------
		System.out.println("addAll");
		//add multiple elements:
		
		//adding fruits list to itself:
		fruits.addAll(fruits); //can ONLY take collection objects, which are: Lists, Qeues, Sets & Maps.
		System.out.println(fruits);
		
		//----------
		String[] names = {"bob", "bill", "frank"};
		
		//this takes an array and converts it into a list, and adds it to our list:
		fruits.addAll(Arrays.asList(names));
		System.out.println(fruits);
		
		//this is one way to add a number of string elements to our list at one time:
		fruits.addAll(Arrays.asList("bannana", "pineapple", "strawberry"));
		fruits.add("mango");
		System.out.println(fruits);
		
		//----------
		
		//create a new list:
		
		List<Animal>animalList=Arrays.asList(new Animal("cow"), new Animal("sheep"), new Animal("Pig"));
		System.out.println(animalList);
		
		//++++++++++++++++++++++++++++++++++++++++++++++++IMPORTANT STUFF BELOW :P ++++++++++++++++++++++++++++
		/*This is a list that was created with an array: 
		"Arrays.asList(new Animal("cow"), new Animal("sheep"), new Animal("Pig"));"
		which means that it's backbone is an array, and you cant add a new elemnent to an array (you cant change it's size)
		So add() will not work for this list.
		*/
		
		//animalList.add(new Animal("Chicken")); //this will throw UnsupportedOperationException
		
		//animalList.remove() allso doesnt work as this also attempts to change it's size. 
		
		//creating an array with NO INITIAL SIZE means you can CAN add new elements to the array. As it wasnt initialised with a size.
		List<Animal>zoo = new ArrayList<>();
		zoo.addAll(Arrays.asList(new Animal("cow"), new Animal("sheep"), new Animal("Pig")));
		zoo.add(new Animal("Swan"));
		
		
	}
	
	
	
	static void ex2() {
		
	
		//we CAN add  elements to this places list as it was defined separately.
		List<String>places = new ArrayList<String>();
		places.addAll(Arrays.asList("Galway", "Dublin", "Cork", "Limerick", "Belfast"));
		
		//we CANNOT add (or remove) to this towns list as it was implemented during definition
		List<String>towns=Arrays.asList("Roscommon", "Mayo", "Leitrim", "Wexford");
		
		places.addAll(towns);
		
		System.out.println("\n" + places);
		
		//remove JUST roscommon:
		places.remove("Roscommon");
		System.out.println(places);
		
		places.removeAll(towns);
		System.out.println(places);
		//------------------------------
		
		List<Integer>numbers = new ArrayList<Integer>();
		
		//produce 15 numbers between 1-100, and adding them to "numbers" list above.
		Stream.generate(()->(int)(Math.random()*100)).limit(15).forEach(a->numbers.add(a));
		System.out.println(numbers);
		
		//----------------
		//REMOVE IF
		/*Takes a predicate and tests for some condition and if that consdition is true for that number,
		 * then it removes the number from the list.
		 * Here we are testing to see if each number is greater than 50, and if it is, then it's removed from the list.
		 * 
		 */
		
		numbers.removeIf(a->a>50);
		System.out.println(numbers);
		
	}
	
	
	
	static void ex3() {
		//SEARCHING AND SORTING
		
		int[]numbers = {6,9,1,8};
		
		for(int n:numbers) { //print out in order they were inserted
			System.out.print(n);
		}
		
		///List<Integer>list=Arrays.asList(3,4,5,6);
		System.out.println();
		//Sorts the array in it's natural order (for numbers is ascending0
		Arrays.sort(numbers);
		
		for(int n:numbers) { //print out in order they were inserted
			System.out.print(n);
		}
		
		
		//BINARY SEARCH:
		
		/*
		 * This method of the arrays class searches for a particular number,
		 * and returns the position in array number of where the number is in the array
		 */
		System.out.println();
		System.out.println(Arrays.binarySearch(numbers, 6)); //position 1
		System.out.println(Arrays.binarySearch(numbers, 8)); //position 2
		
		//if this was in the list, then it would show up in index 5 so it shows up at pos 5
		System.out.println(Arrays.binarySearch(numbers, 234)); 
		
		
		//-------
		
		int[]numbers2 = {67,2,3};
		System.out.println(Arrays.binarySearch(numbers2, 2));
		
		/*
		 * sort & binarySearch works with all primitive numbers, chars but not booleans
		 * Sort and binarySearch ONLY works with classes of objects that implement the comaprable interface
		 * String class implements the Comparable interface.
		 * Symbols first,
		 * Then numbers,
		 * Then caps,
		 * then lowercase
		 * 
		 *
		 */
		
		String[]names = {"pat ", "mary ", "Zeb ", "peter "};
		Arrays.parallelSort(names);
		
		for(String n:names) { 
			System.out.print(n);
		}
		
		
		Animal[]zoo= {new Animal("Osterich"), new Animal("Lion")};
		
		/*The Animal class DOES NOT implement the Comparable interface, 
		 * so an array of Animals cannot be sorted using the Arrays.sort method
		 */
		
		//this creates a classCastExcpetion as the Animal class doesn't implement the Comparable interface.
		//Arrays.sort(zoo);
		
		List<Integer>integers=Arrays.asList(145,23,27,44,21);
		
		/*
		 * To use with ArrayLists we use Collections.sort()
		 * There is a sort() method for lists, sets and maps, but it takes something called a 
		 * Comparator, which we haven't covered yet. It's an alternative to the Comparable interface.
		 * 
		 * collections.sort() takes any list, set or map.
		 */
		Collections.sort(integers);
		System.out.println();
		System.out.println(integers);
		System.out.println();
		System.out.println(Collections.binarySearch(integers, 2));
		
		
	}
	
	
	static void ex4() {
		
		/*
		 * Only objects can be added to classes that implement the comparable interface (lists, sets, maps), 
		 * so when we attempt to add a primitive, the primitive is actually autoboxed to become a wrapper object.
		 */
		List<Integer>ints = new ArrayList<Integer>();
		
		//4 is autoboxed to become an Integer object
		ints.add(4);
		
		//lists allow duplicates:
		ints.addAll(Arrays.asList(16,8,99,12,4,3,2,4,5));
		System.out.println(ints);
		
		//this reoves the number at index pos 2 (8)
		ints.remove(2);
		System.out.println(ints);
		
		//if you want to remove a specific item, then you need to make a similar object and use that as comparison.+++++++++++
		ints.remove(new Integer(16));
		System.out.println(ints);
		
		//remove object 12:
		Integer myInt = 12;
		ints.remove(myInt);
		System.out.println(ints);
		
		//trying to remove 12 again (returns false):
		System.out.println(ints.remove(myInt));
		
		
		//---------------------
		
		Animal spot = new Animal("Spot");
		Animal tibbles = new Animal("Tibbles");
		Animal harry = new Animal("Harry");
		
		List<Animal>animalList = new ArrayList<Animal>();
		animalList.addAll(Arrays.asList(spot,tibbles,harry));
		
		animalList.add(spot);
		animalList.add(tibbles);
		animalList.add(harry);
		
		/*
		 * remove uses the equals() method to find a match:
		 */
		System.out.println(animalList.remove(spot));
		
		//second spot is still there:
		System.out.println(animalList);
		
		//this will remove the second animal harry:
		animalList.remove(2);
		System.out.println(animalList);
		
		Animal newAnimal = new Animal("spot");
		System.out.println(animalList.remove(newAnimal));
		
		System.out.println(newAnimal.equals(spot));
		
		
	}
	
	
	
	static void ex5() {
		
		/*
		 * Before java 5, all you had was arrayLists of objects and nothing else.
		 * This liat could contain ANY object, however you can't call any methods of the subclasses of object. You could only call methods of the Object.
		 * You wouldnt know by looking at the code what this list contains (Humans, Animals etc)
		 * The only way you'd know was if it was documented somewhere.
		 * 
		 */
		List names = new ArrayList();
		
		/*
		 * After java5, we have generics which helps enforce the asumption that your list contians  certian data type.
		 * Inthis case it changes the references of the list. 5 & 6 had to haave <String> on both sides of the list
		 * 
		 */
		List<String>names2 = new ArrayList<String>();
		
		/*
		 * After java 7 you could write the shortened version using the DIAMOND OPERATOR <> on the right hand side, 
		 * however this can cause certain circumstances. LOSS OF TYPE information, which will be covered wehn we do generics 
		 */
		List<String>names3 = new ArrayList<>();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
