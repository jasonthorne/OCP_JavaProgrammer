package com.android;
/*
 * interface Comparable<T>{
 * 		int compareTo(T arg0);
 * }
 */
//provide the generic we are comparing against, in this case a Duck
public class Duck implements Comparable<Duck>{
	private String name;
	private int weight;
	private int height;
	/*
	 * this is the only abstract method of the Comparable interface
	 */
	@Override
	public int compareTo(Duck d) {
		/*
		 * this uses the compareTo method of the String class, so here we are only using the 
		 * compareTo for names
		 * we could also use the compareTo() method for the two int variables
		 * which we will with the Rat class
		 */
		return name.compareTo(d.name);
	}
	
	
	public Duck(String name, int weight, int height) {
		super();
		this.name = name;
		this.weight = weight;
		this.height = height;
	}
	public String getName() {
		return name;
	}
	public int getWeight() {
		return weight;
	}
	public int getHeight() {
		return height;
	}
	
	@Override
	public String toString() {
		return "duck name is "+name+" duck weight is "+weight+" duck height is "+height;
	}


}
