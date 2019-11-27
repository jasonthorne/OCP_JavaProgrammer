package com.android;

import java.util.ArrayList;
import java.util.Arrays;
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
		
	}
	
	
	

}
