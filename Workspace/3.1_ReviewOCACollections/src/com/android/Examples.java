package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

}
