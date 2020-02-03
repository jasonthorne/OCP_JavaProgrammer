package com.bundle;

import java.util.ListResourceBundle;

/**
 * 
 * This is creating your own properties file
 *
 */

/*
 * This is our own properties class. Your won propertie class has to etend the ListResourceBundle abstract classs. 
 * Also, each of these propery classes HAVE TO be a public class, which means they have to be in their own class with the same name.
 * The advantage of these over properties files or the inbuilt java properties class is that both key & value can be ANY DATA TYPE. 
 * Also they dont have to match. IE KEY is a string, value is a Dog.
 */

public class Farm_en extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		
		String[][]twoDarray = {
				{"hello", "hello & welcome to our farm"},
				{"open", "farm is now open for business"}
		};
		
		return twoDarray;
	}

}

