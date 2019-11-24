package com.android;

//IMMUTABLE CLASS: 
public final class Animal {
	
	private final String name;
	private final int age;
	
	/*
	 * When you have final in a class, the final var DOES NOT have any default value, and has to be explicitly given a value. 
	 * If there is any circumstance that could lead to a final not having a value, the code WILL NOT compile. 
	 * which is why the below constructor is not allowed. 
	 */
	
	/*
	Animal(){
		 //This constructor has to give values to name and age to compile, As nsame and age are final.
	}
	*/
	
	
	
	Animal(String name, int age){
		this.name=name;
		this.age=age;
	}
	
	//string is an immutable class itself, so its fine to return a string.
	public String getName() {
		return name;
	}
	
	//primitives are returned by value, so this is fine to return as well.
	public int getAge() {
		return age;
	}

	
	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + "]";
	}
	
	

	
	
}
