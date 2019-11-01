package com.android;

public class Main {
/**
 * we have only dealt with Arraylists up to this point but there are many other types of lists.
 *Most of the lists implement the COLLECTION interface and this top level interface has four sub interfaces which some of 
 * the lists implement. there are four main sub interfaces of the Collection interface
 * LIST
 * is a list of a ordered collection of objects that allows duplicated entries. Elements can be accessed by an int index.
 * the classes that implement this interface are
 * 			ArrayList
 * 			LinkedList
 * 			Vector
 * 			Stack
 * SET
 * a set is a collection that does not allow duplicate entries
 * the classes that implement this interface are
 * 		 	HashSet, 
 * 			LinkedHashSet
 * 			TreeSet
 * QUEUE
 * Queue is a collection that orders it's elements in a specific order for processing. A typical queue processes it's elements
 * in a first-in, first-out order, but other orderings are possible
 * some of the classes that implement this interface are (any class can implment multiple interface, which is why LinkedList is
 * here as well)
 * 			LinkedList, 
 * 			ArrayBlockingQueue 
 * 			PriorityQueue 
 * MAP
 * A map is a collection that maps keys to values, wiht no duplicate keys allowed. The elements in a map are key/value pairs
 * (this is similar to what happens in normalised database where every value has a unique primary key to identify that record)
 * so every object has a unique identifier, i.e Car and car registration, irish residents and PPS  numbers, both of these are
 * key/value pairs and the uniquie id, in say pps, can be used to uniquely identify a individual
 * Map is the only one, as far as i know,DOES NOT implement the Collection interface
 * @param args
 */
	public static void main(String[] args) {
	//	Examples.ex1();
	//	Examples.ex2();
	//	Examples.ex3();
	//	Examples.ex4();
	//	Examples.ex5();
	//	Examples.ex6();
	//	Examples.ex7();
	//	Examples.ex8();
		Examples.ex9();

	}

}
