package com.android;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * CREATING IMMUTABLE OBJECTS
 * create objects that can be shared across multiple classes but do not want 
 * their values modified. 
 * You can just copy the object and send it to a method, however this creates
 * a large overhead as you have duplicates of objects every time a method is
 * called. Also it's not thread safe.
 * five rules to creating an immutable class
 * use a constructor to set all properties of the object
 * mark all of the instance variables private and final
 * don't define any setter methods
 * don't allow refereced mutlable object to be modified or accessed directly
 * prevent methods from being overriden
 * 
 * @author noelf
 *
 */
public class Main {
	public static void main(String[]args) {
		Employee eddie=new Employee(12.5,12345);

		/*
		 * a list based on an array, cannot have objects added to it
		 * so if i go Arrays.asList("banana","orange",
				"apple","pineapple")
				you create list you cannot add too
		 */
		List<String>fruits=new ArrayList<>();
		fruits.add("apple");
		fruits.add("orange");
		fruits.add("banana");
		fruits.add("pineapple");
		Animal andy=new Animal("andy", 45, eddie, fruits
				);
		Employee newEmployee=andy.getEmp1();
		System.out.println(andy);
		newEmployee.pps=7777777;
		newEmployee.weight=123456.89;
		System.out.println(andy);
		/*
		 * this sends back orignal employee, which we we can then modify
		 */
		//Employee anotherEmp=andy.getEmpWrong();
		System.out.println(andy);
	//	anotherEmp.weight=11111.11;
	//	anotherEmp.pps=99999999;
		//the emp1.weight and pps are now changed
		System.out.println(andy);
		
		List<String>newList=andy.getFavouriteFoods();
		newList.add("beef");
		System.out.println(andy);
		/*
		 * this sends back the original list, which we can then modify
		 */
	//	List<String>wrongList
		//System.out.println(wrongList);
	//	wrongList.add("word");
		/*
		 * the word "word" is now added to the list
		 */
		System.out.println(andy);
		
		
		
	}

}
