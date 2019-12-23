package com.android.animals;

public class Rat extends Animal implements Comparable<Rat>{
	
	public Rat(int age,String name){
		super(age,name);
	}
	/*
	 * if this returns true and the hashcode is the same for both Rats, then both rats will NOT BE added
	 */
	@Override
	public boolean equals(Object obj) {
		Rat other=(Rat)obj;
		return age==other.age;
		
	}
	/*
	 * if two Rats have the same age, they will have the same HashCode number, so two Rats of the same 
	 * age will NOT be added to the set
	 */
	@Override
	public int hashCode() {
		int number=41;
		return age*number;
	}
	@Override
	public int compareTo(Rat arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
		
		

}
