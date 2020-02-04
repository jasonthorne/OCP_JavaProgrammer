package com.android;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
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
		
		//this is accessing only one properties file: 
		//Usually with a resource bundle, you can access a number of propertie files
		ResourceBundle rb = ResourceBundle.getBundle("com.android.myBundle"); 
		
		//key for this is: "hello", val is: "hello"
		System.out.println("1st statement: " + rb.getString("hello")); 
		
		//key for this is: "open". value is: "The zoo is open at 9"
		System.out.println("2nd statement: " + rb.getString("open"));
		
		//----------------------
		
		//get all keys:
		System.out.println(rb.keySet());
		
		//get all values for each key: +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//grabbing all the keysets, and for each of them, get thhe vals, and print them out.
		rb.keySet().stream().map(k->rb.getString(k)).forEach(System.out::println);
		
		//cleaner way of getting all keys:
		rb.keySet().parallelStream().forEach((k)->{
			System.out.println("key is: " + k);
			System.out.println("value is: " + rb.getString(k));
		});
		
		//======================CREATING RESOURCE BUNDLE WITH MULTIPLE PROPERTY FILES ++++++++++++++++++++++++++++++++
		
		Locale france = new Locale("fr", "FR");
		
		/*
		 * this bundle is based on all files in the com.bundle package that begin with zoo.
		 * after the underscore in the properites file. denotes what language we are dealing with.
		 * In this example we create a bundle of the fuiles in the com.bundle package
		 * that begin with the word zoo, and then we supply a locale, which will search the bundle for a file that uses that language.
		 */
		
		//IN FRENCH: 
		ResourceBundle rbMult = ResourceBundle.getBundle("com.bundle.Zoo", france);
		
		System.out.println("\nrbMult.keySet(): " + rbMult.keySet());
		
		System.out.println("zoo hello: " + rbMult.getString("hello"));
		System.out.println("zoo open: " + rbMult.getString("open"));
		
		
		//IN GERMAN:
		rbMult = ResourceBundle.getBundle("com.bundle.Zoo", germany);
		
		System.out.println("zoo hello: " + rbMult.getString("hello"));
		System.out.println("zoo open: " + rbMult.getString("open"));
		
		//-----------------
		//non existent key:
			
		//if yoyu attempt to access a non existanrt key, you will get a missing resource exception:
		//rbMult.getString("woohoo");	
		//--------------------
		
		//IN ENGLISH:
		rbMult = ResourceBundle.getBundle("com.bundle.Zoo", us);
		
		System.out.println("zoo hello: " + rbMult.getString("hello"));
		System.out.println("zoo open: " + rbMult.getString("open"));
		
		getLocalDetails(rbMult);
		
		
		//-----------------------
		ResourceBundle rbUs = ResourceBundle.getBundle("com.bundle.Zoo", us);
		
		//keys of us locale:
		
		Set<String>keys=rbMult.keySet();

		System.out.println("us locale keys: " + keys);
		
		//values of a us locale:
		Set<String>values=keys.stream().map(k ->rbUs.getString(k)).collect(Collectors.toSet());
		
		System.out.println("values: " + values);
		
		//=========================================
		
		/*
		 * If no locale is given, then it will use the default locale.
		 * HOWEVER you have to have a file for it to work. If you DONT HAVE a _en file in this bundle or this wont compile.
		 * there HAS TO BE a Zoo_en file inside the com.android package.
		 * 
		 */
		ResourceBundle rb4 = ResourceBundle.getBundle("com.bundle.zoo"); //	,new Locale("EN")); - this is instinctively created. 
		
		System.out.println("**********rb4: " + rb4.keySet());
			
	}
	
	//gets all the keys and values of a particular properties file
	static void getLocalDetails(ResourceBundle myRb) {
		System.out.println(myRb.keySet());
		myRb.keySet().stream().forEach((k)->{
			System.out.println(myRb.getString(k));
		});
	}
	
	
	
	static void ex3() {
		
		System.out.println("\nex3:");
		
		//================================================PROPERTIES OBJECT: 
		
		/*
		 * A properties class is a java inbuilt class which stores the values and keys of a properties file
		 * 
		 */
		
		Properties props = new Properties();
		
		//locale for germany:
		Locale germany = new Locale("de", "DE");
		
		ResourceBundle rb = ResourceBundle.getBundle("com.bundle.Zoo", germany);
		
		//for every key in resource file, put that key and its value into the properties object: ++++++++++++++++++
		rb.keySet().stream().forEach(k->props.put(k, rb.getString(k)));
		
		
		
		System.out.println("properties: " + props);
		
		System.out.println("props.keySet: " + props.keySet());
		
		System.out.println("props.get('open'): " + props.get("open"));
	
		//getting all the values of our properties file:
		props.keySet().stream().map(k->props.get(k)).forEach(System.out::println);
		
		//saving to a set:
		//Set<String>setKeys=props.keySet().stream().map(k->props.get(k)).collect(Collectors.toSet());
		
		
		//----------------------------------------
		
		//props has all the keys and values of the Germany file.
		
		System.out.println(props.keys().nextElement()); //first key in germany locale
		System.out.println(props.elements().nextElement()); //first value in germany locale
			
	}
	
	
	
	static void ex4() {
		
		System.out.println("\nex4:");
		
		//================================================JAVA CLASS RESOURCE BUNDLE
		
		Locale britain = new Locale("en", "GB");
		Locale germany = new Locale("de", "DE");
		Locale france = new Locale("fr", "FR");
		
		//Bundle is made from ALL classes in 'com.bundle' package that begin with Farm. This CAN contain both classes and property files. 
		ResourceBundle rb = ResourceBundle.getBundle("com.bundle.Farm", britain); //BRITAIN
		System.out.println(rb.getString("open"));
		System.out.println(rb.getString("hello"));
		
		rb = ResourceBundle.getBundle("com.bundle.Farm", germany); //GERMANY
		System.out.println(rb.getString("open"));
		System.out.println(rb.getString("hello"));
		
		/*
		 * The value for open is an Object, so we cant use getString() to get that object, we have to use getObject()
		 */
		rb = ResourceBundle.getBundle("com.bundle.Farm", france); //FRANCE
		System.out.println(rb.getObject("open")); //this has an Animal value
		System.out.println(rb.getString("hello")); //this has a string value 
		//System.out.println(rb.getString("yo")); //this has an ArrayList of Integers value
		
		
		//----------------no locale defined in bundle creation:
		
		/*
		 * If no locale is stated it will use the default value used on your machine.
		 */
		rb=ResourceBundle.getBundle("com.bundle.Farm");
		System.out.println(rb.getObject("open")); //this has an Animal value
		System.out.println(rb.getString("hello")); //this has a string value 
		
		
		//=========================================
		
		/*
		 * creating a bundle for offices:
		 */
		
		//OFFICE IN FRANCE:
		rb=ResourceBundle.getBundle("com.android.Office", france);
		System.out.println(rb.getString("hello")); 
		System.out.println(rb.getString("open"));
		
		/*
		 * This uses the default locale, which is the locale of this machine, which is the english language. 
		 * However their is no English locale in this bundle, only French. 
		 * So if you attempt to use any other locale other than English you will get a 'missing resource exception'.
		 */
		
		//rb=ResourceBundle.getBundle("com.android.Office"); //using the machines default of english, but there is no '_en' file
		
		//-----------------------
		
		
		rb=ResourceBundle.getBundle("com.android.Zoo", britain);
		System.out.println(rb.getObject("open"));
		
		rb=ResourceBundle.getBundle("com.android.Zoo", germany);
		System.out.println(rb.getObject("open"));
		
		/*
		 * If it cannot use the locale (here the Zoo_fr is not a public level class, its a default level class)
		 * java will attempt to use the default locale instead, which is english on this machine.
		 * 
		 * If you are using resourceBundle, that means you have to have a public class ending with the words "en", 
		 * here we have a file called Zoo_en.
		 */
		rb=ResourceBundle.getBundle("com.android.Zoo", france);
		System.out.println(rb.getObject("open"));
		
	}
	
	
	static void ex5() {
		
		System.out.println("\nex5:");
		
		Locale us = new Locale("en", "US");
		System.out.println("Tax in the United States");
		ResourceBundle rb=ResourceBundle.getBundle("com.money.Tax", us);
		System.out.println(rb.getObject("tax"));
		
		Locale ie = new Locale("en", "IE");
		System.out.println("Tax in Ireland");
		rb=ResourceBundle.getBundle("com.money.Tax", ie);
		System.out.println(rb.getObject("tax"));
		
		
		//----------------
		/*
		 * If you dont provide a locale, it will use the default locale which is english, ireland.
		 */
		rb=ResourceBundle.getBundle("com.money.Tax");
		System.out.println(rb.getObject("tax"));
		
		
	}
	
	
	
	static void ex6() {
		
		System.out.println("\nex6:");
		
		//================================================PROPERTIES FILE PRIORITY
		
		//This uses the english ireland locale, as thats the default locale
		//if you dont provide a locale it will always use the default locale
		
		/*
		 * This respurce bundle has a choice in that it can use either House_en.properties file OR house_en.java file.
		 * It's first preference will be the House_en.properties file.
		 */
		ResourceBundle rb = ResourceBundle.getBundle("com.android.house");
		
		rb.keySet().parallelStream().map(k->"key is: " + k + "value is: " + rb.getString(k)).forEach(System.out::println);
		
		/* 
		DONT RUN :P (in case it changes default local of eclipse, and causes problems)
		Locale.setDefault(newLocale)new Locale("hi");
		ResourceBundle rb5 = ResourceBundle.getBundle("Zoo", new Locale("en"));
		
		*/
		
	}

}

