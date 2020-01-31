package com.android;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;

public class Examples {
	
	static void ex1() {
		
		System.out.println("\nex1:");
		
		//================================================LOCALES
		
		/*
		 * All localisation is based on Locales, which is basically the areas of the world you can reside,
		 * usually corresponds to a country, but not always. 
		 */
		Locale myLocale=Locale.getDefault();
		System.out.println(myLocale);
		
		/*
		 * my machine is using English and is residing in Ireland, so it will printout: en_IE
		 * 
		 * Language first, always in lowercase, has to be an underscore next and then followed by the short hand for the country
		 * Underscore and country code are optional
		 */
		
		System.out.println(Locale.GERMAN); //this is the language
		System.out.println(Locale.GERMANY); //this is german_germany, which will look like: de_DE
		
		Locale frenchie = new Locale("fr");
		System.out.println(frenchie); //just the language
		
		System.out.println(new Locale("hi, in")); //this is a Locale of the language of Hindi and the country of India.
		
		//-------------
		
		/*
		 * Its not that this is incvalid, its that if you use non standard locales, you can get non standard results.
		 */
		System.out.println(new Locale("fr", "IE")); //french language in Ireland
		
		
		//------------
		
		/*
		 * You can also use the builder pattern to create locales (locale has a builder method)
		 * whereas you can lowercase for country. Its not recommended, its convention to use uppercase for countries.
		 */
		
		Locale l1 = new Locale.Builder().setLanguage("en").setRegion("US").build();
		Locale l2 = new Locale.Builder().setRegion("UK").setLanguage("en").build();
		
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l1.getCountry());
		System.out.println(l2.getLanguage());
		
		//-------------getAvailableLocals:
		
		Locale[]locales=Locale.getAvailableLocales();
		
		List<Locale>locList=Arrays.asList(locales);
		System.out.println(locList.parallelStream().count());
		
		System.out.println(locList);
		
		//----------------
		
		System.out.println(locList.stream().map(l->l.getLanguage()).filter(s->s.contains("en")).count());
		
		List<String>test = locList.stream().map(l->l.getLanguage()).filter(s->s.contains("en")).collect(Collectors.toList());
		
		System.out.println(test);
		
		
		//-----------------------------------
		
		//all languages spoken in Ireland:
		locList.stream()
			.filter(l->l.getCountry()
			.equals("IE"))
			.forEach(System.out::println);
		
		System.out.println();
		
		//all countries speaking english:
		locList.stream()
		.filter(l->l.getLanguage()
		.equals("en"))
		.forEach(System.out::println);
		
		//-------------
		
		List<String>languages=locList.stream()
				.map(l->l.getLanguage()) //needed in order to change locale object into String ++++++++++++++
				.filter(s->s.length()>0) //filter by only locales that aren't blank
				.collect(Collectors.toList()); //add to list
		
		
		List<String>countries=locList.stream()
				.map(l->l.getCountry()) //needed in order to change locale object into String ++++++++++++++
				.filter(s->s.length()>0) //filter by only locales that aren't blank
				.collect(Collectors.toList());  //add to list
		
		System.out.println("languages: " + languages);
		System.out.println("countries: " + countries);
		
		System.out.println("amount of countries: " + countries.size());
		
		System.out.println("amount of distinct countries: " + countries.parallelStream().distinct().count());
		
		
		//-----------------------
		
		/*
		Map<String, Set<String>>countryLanguage = locList.stream()
				.collect(Collectors.groupingBy(l->l.getCountry()), Collectors.toSet());
		
		*/
		
		
	}
	
	
	
	static void ex2() {
		
		System.out.println("\nex2:");
		
		//================================================LOCALIZATION: 
		
		
		//------------------RESOURCE BUNDLES:
		/*
		 * resource bundles can be a java class or a packages file. 
		 */
		
		Locale us = new Locale("en", "US");
		Locale germany = new Locale("de", "DE");
		
		
		//To create a properties file in eclipse, click on new file, then go to the correct package, and save file by naming it MyBundle.properties
		//you HAVE to include the file extension. Then you create the resource bundle from the full file name: package + filename, but NOT file extension, 
		//and use this resource bundle to access each of the values through their keys.
		
		ResourceBundle rb = ResourceBundle.getBundle("com.android.myBundle"); 
		
		System.out.println("1st statement: " + rb.getString("hello")); 
		
		System.out.println("2nd statement: " + rb.getString("open"));
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

