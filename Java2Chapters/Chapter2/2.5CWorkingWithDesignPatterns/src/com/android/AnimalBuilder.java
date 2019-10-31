package com.android;

import java.util.ArrayList;
import java.util.List;

public class AnimalBuilder {
	/*
	 * this uses the immutable Animal class
	 * Notice how all the set methods return an instance of the builder object "this"
	 * this means that all of these methods can then call each other
	 * you can CHAIN the methods and each set method can also call the Build method
	 * "this" means the AnimalBuilder object that is calling this method, so each of these methods can then in turn call any method
	 * of the AnimalBuilder class
	 */
	private String name;
	private int age;
	private List<String>favouriteFoods;
	
	public AnimalBuilder setAge(int age) {
		this.age=age;
		return this;//returns a AnimalBuilder object
	}
	
	public AnimalBuilder setName(String name) {
		this.name=name;
		return this;
	}
	
	public AnimalBuilder setFavouriteFoods(List<String>favouriteFoods) {
		this.favouriteFoods=favouriteFoods;
		return this;
	}
	
	public Animal build() {
		/*
		 * this build() method can be used to give fields a default values if no values are given to a particular field
		 * but if your object will only use atributes that will be given with the setters of the AnimalBuilder class then you
		 * do not need to do this
		 */
		if(name==null)
			name="";
		if(favouriteFoods==null)
			favouriteFoods=new ArrayList<String>();
		return new Animal(name,age,favouriteFoods);
	}
	
	

}
