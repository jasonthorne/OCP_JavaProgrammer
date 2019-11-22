package com.android;


public class AnimalBuilder {
	
	/*
	 * This uses the immutable Animal class to create an Animal object.
	 * When we are using a builder class to create an object of an immutable class, we first dont create an object of the Animal class.
	 * As if we gave ourt animal object's variables a value (age and name for example) then we couldnt change values as both age and name are FINAL.
	 * 
	 * what we dso instead is declare private versions of all of the variables the Animal class will use to create an object of itself.
	 * Animal has tow variables: name and age.
	 * So what were going to do is create an anima lfrom these 2 variables:
	 */
	
	private String name;
	private int age;
	
	//setter for age
	public AnimalBuilder setAge(int age) {
		this.age=age;
		return this;
	}
	
	//setter for name
	public AnimalBuilder setName(String name) {
		this.name=name;
		return this;
	}
	
	public Animal build() {
		
		/*
		 * This prevents nullPointerException, because if name is null, 
		 * we cant call any methods of the string class with this object it will crash our program.
		 */
		if(name==null)
			name="";
		if(age<0)
			age=0;
		return new Animal(name,age);
	}
	


}
