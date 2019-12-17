package com.android;

/*
 * We have only dealt with arraylists up to this point. 
 * But there are other types of collections. 
 * Most of the lists implement the collection interface.
 * And this top level interface has 4 sub interfaces, which some of the list types implement. 
 * There are 4 main sub interfaces of the collection interface: 
 * 
 * + LIST: 
 * a list of ORDERED collection of objects that allows DUPLICATE entries. 
 * Elements can be accessed by an int index.
 * Some of the classes that implement this interface are:
 * ArrayLists, LinkedList, Vector ad the Stack. 
 * You can also create your own class that implements the List interface. 
 * 
 * + SET:
 * A set is a collection that does not allow duplicate entries.
 * Some of the classes that implement set are: 
 * HashSet, linkedHashSet and treeSet.
 * 
 * + QUEUE:
 * A Queue is a collection that orders it's elements in a specific order for processing. 
 * A typical queue processes it's elements in a FIFO order.  But other orderings are possible. 
 * Some of the classes that implement this interface are: LinkedList, ArrayBlockingQueue, ArrayDeque, priorityQueue
 * (any class can implement multiple interfaces which is why linkedList is here as well)
 * 
 * + MAP:
 * A Map is a collection that maps keys to values with no duplicate keys allowed, but multiple values allowed.
 * The elements in a Map are Key/value pairs.
 * This is similar to what happens in a normallised database where each value in a db has a unique primary key to identify the record. 
 * A map has 2 entries for every item in your collection: A key which is unique, and a value which the key uniquely identifies.
 * A map is the only one that does NOT implement the collection interface. 
 * HashMap is the type of map we'll be using. 
 */

public class Main {
	
	public static void main(String[] args) {
		
		
		//Examples.ex1();
		//Examples.ex2();
		//Examples.ex3();
		//Examples.ex4();
		//Examples.ex5();
		//Examples.ex6();
		//Examples.ex7();
		//Examples.ex8();
		//Examples.ex9();
		//Examples.ex10();
		//Examples.ex11();
		Examples.ex12();
		Examples.ex13();
		
	}

}
