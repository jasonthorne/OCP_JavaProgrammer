package com.android.animals;

public class Rat extends Animal {
	
	public Rat(int age, String name) {
		super(age, name);
	}
	
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
		return age*14;
	}

}
