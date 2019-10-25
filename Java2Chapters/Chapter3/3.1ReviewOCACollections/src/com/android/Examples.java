package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

public class Examples {
	
	static void ex1() {
		/*
		 * the ArrayList class implements the List Interface
		 */
		List<String>fruits=new ArrayList<>();
		/*
		 * can add individuals strings to the arrayList
		 */
		fruits.add("Apple");
		fruits.add("orange");
		/*
		 * or can add full arrays by using the static method asList() of the Arrays class
		 */
		fruits.addAll(Arrays.asList("mango","banana","pineapple"));
		System.out.println(fruits);
		fruits.add("blueberry");
		System.out.println(fruits);
		//adds the list to itself
		fruits.addAll(fruits);
		System.out.println(fruits);
			
		String[]animals= {"dog","cat","cow","sheep"};;	
			/*
		 * this will convert the array of strings "animals"  to a list and assign it to the list animalList, this will only 
		 * work for a List interface referenced object,	will NOT work for instance for an arraylist referenced object
		 */
		List<String>animalList=Arrays.asList(animals);//will compile
		//ArrayList<String>animalArrList=Arrays.asList(animals);//will not compile
		System.out.println(animalList);
		/*
		 * this will create a brand new list with only "Gorilla" and "monkey" in it
		 */
		animalList=Arrays.asList("Gorilla","Monkey");
		System.out.println(animalList);
		/*
		 * if you create a List by just adding an array to it, you will NOT supported access to the methods of the List
		 * interface, so you will not be able to use add() or addAll, remove() etc. the code will compile but you will get an
		 * "UnsupportedOperationException"
		 */
	//	animalList.add("Zebra");
	}
	
	static void ex2() {
		System.out.println("***SERACHING AND SORTING");
		System.out.println("not sorted");
		int numbers[]= {6,9,1,8};	
		for(int n:numbers)//print in order they are entered in array
			System.out.println(n);
		
		System.out.println("SORTED");
		/*
		 * this sorts the array in ascending order and changes the original array
		 */
		Arrays.sort(numbers);
		for(int n:numbers)
			System.out.println(n);//prints out 1,6,8,9
		
		System.out.println("using BinarySearch");
		/*
		 * this method of the Arrays class searches for a particular number and returns the position, in arrayNumbering, of where
		 * our number is in the array
		 */
		System.out.println(Arrays.binarySearch(numbers, 1));//will return 0
		System.out.println(Arrays.binarySearch(numbers, 6));//will return 1
		System.out.println(Arrays.binarySearch(numbers, 8));//will return 2
		System.out.println(Arrays.binarySearch(numbers, 9));//will return 3
		/*
		 * if it can't find a number it will return the negative version of the index postion the number
		 * would have appeared in minus 1, so this would have appeared at postion 1, becomes -1, and
		 * -1-1 is -2, its not the minus of the index position, but the minus of the POSITION (i.e 
		 * first is 1, if not found -1, second is 2, if not found -2
		 */
		/*
		 * if 3 existed in this list it would be at index position 1, which would be the second postion so this is given the
		 * value -2
		 */
		System.out.println(Arrays.binarySearch(numbers, 3));//-2
		/*
		 * if 10 existed in this list it would be at index position 4, which would be the fifth position so this is given the 
		 * value of -5
		 */
		System.out.println(Arrays.binarySearch(numbers, 10));//-5
		/*
		 * ArrayLists work the same way as arrays
		 */
		List<Integer> list = Arrays.asList(9,7,5,3);
		Collections.sort(list); // [3, 5, 7, 9]
		System.out.println(Collections.binarySearch(list, 3)); // 0
		System.out.println(Collections.binarySearch(list, 9)); // 3
		System.out.println(Collections.binarySearch(list, 2)); // -1
		System.out.println(list);
		
		
	}
	
	static void ex3() {
		System.out.println("WRAPPER CLASSES");
		List<Integer>ints=new ArrayList<>();
		/*
		 * only objects can be added to an list, so these are all boxed up to become INTEGER wrapper objects
		 */
		ints.add(4);
		ints.addAll(Arrays.asList(16,8,99,12,4,2,3,4,5));
		System.out.println(ints);
		//this will remove at index position 2, so 99 will be removed
		ints.remove(2);
	
		System.out.println(ints);
		//this will remove the wrapper containing the number 16
		ints.remove(new Integer(16));
		System.out.println(ints);
		
		
		List<Integer>numbers=new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(new Integer(3));
		numbers.add(new Integer(5));
		System.out.println(numbers);
		//removes the number at position 1, which is the number 3, will return the number that is removed
		System.out.println(numbers.remove(1));
		//removes the wrapper number 5
		System.out.println(numbers.remove(new Integer(5)));
		
		Animal spot=new Animal("spot");
		Animal tibbles=new Animal("tibbles");
		Animal harry=new Animal("harry");
		/*
		 * if you create a List by going
		 * List<Animal>animalList=Arrays.asList(spot,tibbles,harry); then you will not be able to use any methods of the 
		 * list interface
		 * here however we create a Arraylist object FIRST and then add objects to it using the Arrays.asList() method you 
		 * will have access to the methods of the List interface
		 */
		List<Animal>animalList=new ArrayList<>();
		animalList.addAll(Arrays.asList(spot,tibbles,harry));
		animalList.add(spot);
		animalList.add(tibbles);
		animalList.add(harry);
		/*
		 * sorting and removing uses the EQUALS() method to find a match, we will be overriding this is examples in other
		 * sections in this chapter
		 */
		System.out.println(animalList);
		//this will remove the FIRST SPOT
		animalList.remove(spot);
		System.out.println("after removing first instance of spot");
		System.out.println(animalList);
		animalList.remove(1);
		System.out.println("removing second animal");
		System.out.println(animalList);	
	}
	
	static void ex4() {
		/*
		 * before java 5 all you had was
		 * this list can contain ANY OBJECT, so you have no way of knowing what this list contains
		 * unless you physically document it somewhere
		 */
		List names=new ArrayList();
		/*
		 * after java 5 we had generics, which helps enforce the assumption that your list contains
		 * a certain data type (in this case strings)
		 */
		List<String>names2=new ArrayList<String>();
		/*
		 * after java 7 you could write the shortened version using the DIAMOND OPERATOR
		 * <>
		 * on the right hand side, however this can be cause you to lost TYPE information, which will be covered when we come
		 * generics in the next section
		 */
		List<String>names3=new ArrayList<>();
		
	}

}
