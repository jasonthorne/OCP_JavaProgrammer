package com.android;

import java.util.ArrayList;
import java.util.List;

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
	/*
	 *once given an initial value these values cannot be changed
	 */
	private final String name;
	private final int age;
	/*
	 * this list is final, however a final list can change each of the items on the list. So whereas the list is
	 * immutable, the variables on the list are NOT. So the items on this list CAN BE changed
	 */
	private final List<String>favouriteFoods;
	
	
	Animal(String name,int age,List<String>favouriteFoods){
		this.name=name;
		this.age=age;
		this.favouriteFoods=favouriteFoods;
	}
	/*
	 * String class is immutable itself so you can return this without it being modified
	 */
	public String getName() {
		return name;
	}
	/*
	 * primitives are not passed by reference but by value, so you can return this without the original value
	 * being modified
	 */
	public int getAge() {
		return age;	
	}
	/*
	 * if we allow this, it means that Animal is no longer an immutable object as we change the individual Strings
	 * on the list.
	 * so in order to make our object final and immutable, you should never return references to mutable objects
	 */
/*	public List<String>getFavouriteFoods(){
		return favouriteFoods;
	}*/
	/*
	 * so what we do is return a copy of the VALUES OF THE LIST, this will return only the values and NOT the
	 * references of each item in the list
	 */
	public List<String>getFavouriteFoods(){
		List<String>newList=new ArrayList<String>(favouriteFoods);
		return newList;
	}
	/*
	 * this is a deep copy which means that newList and favouriteFoods are the SAME list, so if we change newList
	 * then favouriteFoods is also changed
	 */
	public List<String>getFavouriteFoods2(){
		List<String>newList=favouriteFoods;
		return newList;
	}
	
	/*
	 * this will return a individual String at a specified position, and is used in conjuction with 
	 * getFavouriteFoodsCount()
	 */
	private String getFavouriteFoods(int index) {
		return favouriteFoods.get(index);
	}
	/*
	 * this will get the amount of foods in out list and are used
	 */
	private int getFavouriteFoodsCount() {
		return favouriteFoods.size();
	}
	
	public String toString() {
		String str="age is "+getAge()+" animal is a "+getName()+" favourite foods are "+getFavouriteFoods();
		return str;
				
	}
	
	
	/*
	 * you can make a mehtod final if you wish
	 */
	final void myMethod() {
		
	}

}
