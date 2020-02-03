package com.bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListResourceBundle;

import com.bundle.Animal.Type;

public class Farm_fr extends ListResourceBundle{
	
	/**
	 * 
	 * This is creating your own properties file
	 *
	 */

	/*
	 * This is our own properties class. Your won properties class has to extend the ListResourceBundle abstract class. 
	 * Also, each of these property classes HAVE TO be a public class, which means they have to be in their own class with the same name.
	 * The advantage of these over properties files or the inbuilt java properties class is that both key & value can be ANY DATA TYPE. 
	 * Also they dont have to match. IE KEY is a string, value is a Dog.
	 */

	@Override
	protected Object[][] getContents() {
		
		Object[][]objArray = {
				{"hello", "bienvenue dans notre ferme"},
				{"open", new Animal(12, Type.DOG)},
				{"yo", new ArrayList<Integer>(Arrays.asList(3,5,6))}
		};
		
		return objArray;
	}

}


