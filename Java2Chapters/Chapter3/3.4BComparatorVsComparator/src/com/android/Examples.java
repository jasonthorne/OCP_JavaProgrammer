package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Examples {
	
	static void ex1() {
		/*
		 * Duck implements the Comparable interface
		 */
		List<Seagull>flock=new ArrayList<>();
		flock.add(new Seagull("daffy"));
		flock.add(new Seagull("donald"));
		flock.add(new Seagull("andy"));
		flock.add(new Seagull("Zed"));
		flock.add(new Seagull("111"));
		flock.add(new Seagull("zed"));
		flock.add(new Seagull("Donald"));
		flock.add(new Seagull("222"));
		//come before letters but after numbers
		flock.add(new Seagull("222a"));
		flock.add(new Seagull("222hello"));
		//treated as text until it comes to the 222
		flock.add(new Seagull("hello222"));
		System.out.println("before Sort they are in the order printed");
		System.out.println(flock);
		Collections.sort(flock);
		/*
		 * numbers first, then capitals, then lowercase letters for the String compareTo() method
		 */
		System.out.println(flock);
		/*
		 * compareTo() returns an int
		 * when two objects the same it returns 0
		 */
		Duck duck1=new Duck("daffy",2);
		Duck duck2=new Duck("daffy",2);
		System.out.println(duck1.compareTo(duck2));//retruns 0
		duck1=new Duck("daffy",3);
		duck2=new Duck("daffy",2);
		/*
		 * compareTo() returns 1 when the calling object is bigger/or before the object sent to the method
		 * compareTo() first checks ages of the ducks, duck1 is older then duck2, duck1 is the duck calling the method
		 * and duck2 is the duck been sent to the method so this will return 1
		 */
		System.out.println(duck1.compareTo(duck2));//returns 1
		/*
		 * compareTo() returns -1 when the calling object is smaller or after the object sent to the method.
		 * duck2 is younger than duck2, duck2 is the duck calling the method and duck1 is the duck been sent to the 
		 * method so this will return -1
		 */
		System.out.println(duck2.compareTo(duck1));//retruns -1
		Eider eider1=new Eider("eddie",4);
		Eider eider2=new Eider("edel",5);
		System.out.println(duck1.compareTo(new Eider("eddie",4)));
		
		
		//come back to this code
	/*	TreeSet<Duck>duckSet=new TreeSet<Duck>();
		duckSet.addAll(Arrays.asList(eider1,duck1,eider2,duck2));
		System.out.println(duckSet);*/
			
	}
	
	static void ex2() {
		Animal andy=new Animal(2);
		Animal angela=new Animal(1);
		Animal animal1=new Animal(7);
		Animal animal2=new Animal(5);
		
		List<Animal>anList=new ArrayList<>();
		anList.add(andy);
		anList.add(angela);
		anList.add(animal1);
		anList.add(animal2);
		System.out.println("animal unsorted");
		System.out.println(anList);
		//sorted in ascending order
		Collections.sort(anList);
		System.out.println("animals sorted");
		System.out.println(anList);
		
		Mammal human=new Mammal(2);
		Mammal dolphin=new Mammal(1);
		Mammal whale=new Mammal(7);
		Mammal ape=new Mammal(5);
		
		List<Mammal>maList=new ArrayList<>();
		maList.add(ape);
		maList.add(whale);
		maList.add(dolphin);
		maList.add(human);
		System.out.println("mammals unsorted");
		System.out.println(maList);
		//sorting in descending order
		Collections.sort(maList);
		System.out.println("mammals sorted in descending");
		System.out.println(maList);
		
		List<Animal>mixed=new ArrayList<>();
		mixed.addAll(maList);
		//inserts list of Animals at index position 1
		mixed.addAll(1, anList);
		System.out.println(mixed);
		Collections.sort(mixed);
		//will print out all animals in correct order but not mammals as we are mixing and matching
		System.out.println(mixed);
		
		Duck duck1=new Duck("daffy",3);
		Duck duck2=new Duck("daffy",2);
		Duck eider1=new Eider("eddie",4);
		Duck eider2=new Eider("edel",5);
		System.out.println(duck1.compareTo(eider1));
		
		List<Duck>duckList=new ArrayList<Duck>();
		duckList.addAll(Arrays.asList(duck1,eider1,duck2,eider2));
		System.out.println(duckList);
		Collections.sort(duckList);
		System.out.println(duckList);
	}

}
