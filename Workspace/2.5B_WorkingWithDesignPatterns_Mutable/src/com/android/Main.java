package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 *Creating Immutable Objects
 *Create objects that can be shared across multiple classes, but do NOT want their values modified.
 *You can just copy the object and send it to a method, howver this creates a large overhead as you have duplicates of objects everytime a method is called. 
 *Also its not thread safe.
 *THere are 5 rules to creating an immutable class:
 *
 *+ Use a constructor to set all properties of the object.
 *+ Mark all of the instance vars private and final
 *+ Dont define any setter methods
 *+ Dont allow any referenced mutable poject to be modifed or accessed directly. 
 *+ prevent methods from being overriden.
 *
 */

public class Main {

	public static void main(String[] args) {
		
		Employee eddie = new Employee(12.5, 12345); 
		/*
		 * a list based on an array CANNOT have objects added to it after creation. (example below)
		 * Arrays.asList("Banana", "orange", "apple", "pineapple"));
		 */
		List<String>fruits = new ArrayList<>();
		fruits.add("apple");
		fruits.add("pineapple");
		fruits.add("melon");
		fruits.add("strawberry");
		Animal andy = new Animal("andy", 45, eddie, fruits);
		
		Employee newEmployee = andy.getEmp1();
		newEmployee.pps=777777777;
		newEmployee.weight=1234.333;
		System.out.println(andy);

	}

}
