package com.android;
/*	/**
 * CREATING IMMUTABLE OBJECTS
 * create objects that can be shared across multiple classes but do not want they're values modified
 * you can copy the object and send it to a method, however this creates a large overhaed that you have
 * duplicates of objects every time a method is called. Also this is not thread safe
 * five rules
 * 1...use a constructor to set all properties of the object
 * 2...mark all of the instance variables private and final
 * 3...don't define any setter methods
 * 4...don't allow referenced mutable object to be modified or accessed directly
 * 5...prevent method from being overriden
 * 
 
* Creating Immutable objects
* this class is Final so you cannot extend the class so this also means that none of the methods can be 
* overriden (marking a class as final though does not mean you cannot change variables, the variables HAVE to
* be marked as final as well if you wish to achieve this)
*/
public final class Animal {
	
	private final String name;
	private final int age;
	
	Animal(String name,int age){
		this.name=name;
		this.age=age;
	}
	/*
	 * when you have a final in your class, the final variable DOES NOT have 
	 * any default and has to be explicitly give a a value. if there is any
	 * circumstance that could lead to a final not having a value, the code
	 * WILL NOT compile. which is why this constructor is not allowed, as if
	 * it was, you could create an Animal without giving a value to the 
	 * final String name or
	 * final int age
	 * comment in below constructor to see error
	 */
/*	
	Animal(){
		/*
		 * this constructor HAS TO GIVE values to name and age to 
		 * compile
		 */
//	}*/
	//String is immutable class so it's fine to return the String
	public String getName() {
		return name;
	}
	//primitives are returned by value, so this is fine to return
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + "]";
	}
	
	

}
