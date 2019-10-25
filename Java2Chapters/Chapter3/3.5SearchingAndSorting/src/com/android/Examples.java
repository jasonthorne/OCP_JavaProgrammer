package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Examples {
	
	static void ex1() {
		/*
		 * List does not Implement Comparable or does not yet have a comparator so you CANNOT yet use the 
		 * sort method
		 */
		List<Rabbit>rabbits=new ArrayList<Rabbit>();
		rabbits.add(new Rabbit(5));
		rabbits.add(new Rabbit(2));
		rabbits.add(new Rabbit(1));
		rabbits.add(new Rabbit(3));
		//will not compile
		//Collections.sort(rabbits);
		JackDaw jack1=new JackDaw(2);
		JackDaw jack2=new JackDaw(10);
		Crow crow1=new Crow(11);
		Crow crow2=new Crow(3);
		//see compareTo() method
		List<Crow>crows=new ArrayList<Crow>();
		crows.addAll(Arrays.asList(jack2,jack1,crow1,crow2));
		System.out.println(crows);
		//this will sort as Crow implelments Comparable
		Collections.sort(crows);
		System.out.println(crows);
		
		/*
		 * we define a comparator for rabbits which will sort by id ascending
		 */
		Comparator<Rabbit>rComparator=(r1,r2)->r1.getId()-r2.getId();
		/*
		 * comparator for rabbits which will sort by id descending
		 */
		Comparator<Rabbit>rComparator2=(r1,r2)->r2.getId()-r1.getId();
		/*
		 * Comparator uses the compareTo() of the Integer class
		 */
		Comparator<Rabbit>rComparator3=(r1,r2)->{
			Integer rId1=r1.getId();
			Integer rId2=r2.getId();
			return rId1.compareTo(rId2);
		};
		rabbits.clear();
		rabbits=returnRabbits();
		Collections.sort(rabbits,rComparator);
		System.out.println("rabbits in ascending order");
		System.out.println(rabbits);
		rabbits.clear();
		rabbits=returnRabbits();
		Collections.sort(rabbits,rComparator2);
		System.out.println("rabbits in descending order");
		System.out.println(rabbits);
		rabbits.clear();
		rabbits=returnRabbits();
		Collections.sort(rabbits,rComparator3);
		System.out.println("rabbits in ascenind order using Integer compareTo");
		System.out.println(rabbits);
		rabbits.clear();
		rabbits=returnRabbits();
		/*
		 * this returns a comparator that is the reverse of the order of the original rComparator, you can assign 
		 * this to the existing comparator or assign it to a new 
		 */
		System.out.println("***reversed");
		Collections.sort(rabbits,rComparator.reversed());
		System.out.println(rabbits);
		
		rabbits.clear();
		rabbits=returnRabbits();
		System.out.println("***reversedOrder");
		/*
		 * this will reverse the "natural order", and this only works with lists that have a "natural order" 
		 * i.e Strings and number, uppercase before lowercase, numbers before strings. So will NOT work with any
		 * user defined deined objects as they have no natural order
		 */
		
		List<String>strList=new ArrayList<>();
		Comparator<String>revStrComparator=Comparator.reverseOrder();
		/*
		 * non alpha numeric symbols first
		 * then numbers
		 * then upper case Letters
		 * then lower case
		 */
		strList.add(Integer.toString(45));
		strList.add(Integer.toString(2));
		strList.add("Beatrix");
		strList.add("andy");
		strList.add("!!");
		System.out.println(strList);
		Collections.sort(strList);
		System.out.println(strList);
		System.out.println("binarySerach()***");
		//will find the string and where it's index position
		System.out.println(Collections.binarySearch(strList, "andy"));//return 4
		//reverse the order so any is now at index position -1
		System.out.println(Collections.binarySearch(strList, "andy",revStrComparator));//gives us -1
		//System.out.println(Collections.binarySearch(strList, "andy"));//gives us 4
		System.out.println(strList);
		Collections.sort(strList,revStrComparator);
		System.out.println(strList);
		//if you use reverseOrder to order you list, you then have to put in the comparator that reversed the order
		//in order for binarySearch to work
		System.out.println(Collections.binarySearch(strList, "andy",revStrComparator));//will give us 0
		System.out.println(strList);
		System.out.println(Collections.binarySearch(strList, "andy"));//will give us -6, unable to find number
		Comparator<String>strComparator=(s1,s2)->{
			return s2.compareTo(s1); 
		};
		Collections.sort(strList);
		Collections.sort(strList,strComparator);
		System.out.println("sorted by reverse order with own comparator");
		System.out.println(strList);
		System.out.println(Collections.binarySearch(strList, "!!",strComparator));
		System.out.println(strList.contains("andy"));
		
		crow1=new Crow(4);
		crow2=new Crow(7);
		Crow crow3=new Crow(1);
		Crow crow4=new Crow(3);
		/*
		 * can add to this set as Crow does implment Comparable
		 * TreeSet needs the object class in the list to implement compareTo
		 * in order to work, as remember TreeSet displays objects in 
		 * ascending order, if you objects do not know how to organised
		 * themselves in a list, then they CANNOT be in a TreeSet
		 */
		TreeSet<Crow>crowSet=new TreeSet<>();
		crowSet.addAll(Arrays.asList(crow1,crow2,crow3,crow4));
		System.out.println(crowSet);
		//binarySearch does not work for TreeSet
		//Collections.binarySearch(crowSet, crow2);
		
		TreeSet<Rabbit>rabbitSet=new TreeSet<>();
		/*
		 * Rabbit does NOT implement Comparable so a rabbit cannot be added to this TreeSet, but if a sub class
		 * of rabbit implemented Comparable then you could add that object, this will generate ClassCastException
		 * as Rabbit cannot be cast to java.lang.Comparable
		 */
		//rabbitSet.add(new Rabbit(19));
		Set<Animal>animalSet=new TreeSet<>();
		/*
		 * cannot add a Animal as Animal does NOT implement the Comparable interface, will
		 * get a ClassCastException
		 */
		//animalSet.add(new Animal(3,"andy"));
		/*
		 * you can add a Cow as Cow extends Animal and implements the Comparable interface
		 * arranges by name first then age
		 */
		animalSet.add(new Cow(3,"bessie"));
		animalSet.add(new Cow(2,"bessie"));
		animalSet.add(new Cow(2,"calvin"));
		System.out.println(animalSet);
		/*
		 * we can tell a TreeSet to use a particular comparator when adding elements to a list
		 */
		Set<Rabbit>rSet=new TreeSet<>(rComparator);
		//we can then add rabbits to this TreeSet
		rSet.add(new Rabbit(3));
		rSet.add(new Rabbit(5));
		rSet.add(new Rabbit(1));
		System.out.println(rSet);
		//in reverse order
		Set<Rabbit>rSet2=new TreeSet<>(rComparator2);
		//we can then add rabbits to this TreeSet
		rSet2.add(new Rabbit(3));
		rSet2.add(new Rabbit(5));
		rSet2.add(new Rabbit(1));
		System.out.println(rSet2);
		/*
		 * or can use a anonymous nested inner class implementation
		 */
		Set<Rabbit>rSet3=new TreeSet<>(
				new Comparator<Rabbit>() {
					@Override
					public int compare(Rabbit r1, Rabbit r2) {
						// TODO Auto-generated method stub
						return r2.getId()-r1.getId();
					}		
				}
				);
		rSet3.add(new Rabbit(3));
		rSet3.add(new Rabbit(5));
		rSet3.add(new Rabbit(1));
		System.out.println(rSet3);
		
	}
	
	static List<Rabbit>returnRabbits(){
		List<Rabbit>rabbits=new ArrayList<Rabbit>();
		rabbits.add(new Rabbit(5));
		rabbits.add(new Rabbit(2));
		rabbits.add(new Rabbit(1));
		rabbits.add(new Rabbit(3));
		return rabbits;
	}
	
	static void ex3() {
		Duck duck1=new Duck("daffy",10);
		Duck duck2=new Duck("daffy",5);
		Eider eider1=new Eider("eddie",2);
		Eider eider2=new Eider("eddie",7);
		List<Duck>ducks=new ArrayList<>();
		ducks.addAll(Arrays.asList(eider1,duck1,eider2,duck2));
		System.out.println(ducks);
		Collections.sort(ducks);
		System.out.println(ducks);
		
		//TreeSet<Duck>duckSet=new TreeSet<Duck>();
		//duckSet.addAll(Arrays.asList(duck1,duck2,eider1,eider2));
		//duckSet.addAll(Arrays.asList(eider1,duck1,eider2,duck2));
		//System.out.println("duckSet");
		//System.out.println(duckSet);
	}

}
