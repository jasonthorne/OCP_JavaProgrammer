package com.android;

import java.util.List;

public class Animal implements Cloneable{
	
	/*
	 * CREATING IMMUTABLE OBJECTS
	 * 
	 * create objects that can be shared across multiple classes byt do not want their values modiefied.
	 * Copies of objects create large overheads
	 * 
	 * 1. use a constructor to set ALL of the properties of the object
	 * 2. Mark all of the instance variables to be private and final
	 * 3. Dont define any setter methods
	 * 4. dont allow referenced mutable objects to be modified or accessed directly
	 * 5 prevent methods from being overridden
	 * 
	 * When you mark a class as final, you cant extend the class, whcih means you cant override the methods of the class. 
	 * 
	 * A final class does NOT prevent you from changing the variables of the class. 
	 */
	
	private final String name; //string is immutable
	private final int age; //age is an aint and int is sent by value
	
	/*
	 * We cant change who the emp1 is. It will always be the object first asigned to it.
	 * However we can change the weight and id of it. 
	 */
	private final Employee emp1; //employee is a mutable class
	
	/*
	 * This list is final. however a final list can 
	 */
	private final List<String>favouriteFoods;
	
	Animal(String name, int age, Employee emp1, List<String>favouriteFoods){
		this.name = name;
		this.age = age;
		this.emp1 = emp1;
		this.favouriteFoods = favouriteFoods;
		//this.favouriteFoods.add("new food"); //list is final, but you can still add things to it (doh!). So making a list final, doesn't make it immutable
	}
	
	//==================GETTERS:
	
	//the string class is immutable so you can return this without it being modified.
	public String getName() {
		return name;
	}
	
	
	//primitives are not passed by reference, so you can return this without it being modified.
	public int getAge() {
		return age;
	}
	
	//primitives are not passed by reference, so you can return this without it being modified.
	public Employee getEmp1() {
		
		System.out.println("weight: " + emp1.weight);
		System.out.println("pps: " + emp1.pps);
		
		Employee newEmployee=new Employee(emp1.weight, emp1.pps);
		return newEmployee; //return a copy of the object. THereby NOT effecting the original 
		
		/*
		Employee emp2 = (Employee) emp1.cloneMe(emp1);
		return emp2;
		*/
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + ", emp1=" + emp1 + ", favouriteFoods=" + favouriteFoods + "]";
	}

	
	
	

}
