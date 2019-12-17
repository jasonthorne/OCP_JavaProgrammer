package com.android.animals;

public class Rat extends Animal implements Comparable{
	
	public Rat(int age, String name) {
		super(age, name);
	}
	
	
	/*
	 * If this returns true and the hashcode is the same for both rats, then both rats will NOT be added.
	 */
	@Override
	public boolean equals(Object obj) {
		Rat other=(Rat)obj;
		return age==other.age;
	}
	
	
	/*
	 * If 2 rats the same age, they'll have the same HashCode number, so 2 rats of the same age WONT be added. +++++++++++++++++++++
	 */
	@Override
	public int hashCode() {
		int number=41;
		return age*number;
	}


	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
