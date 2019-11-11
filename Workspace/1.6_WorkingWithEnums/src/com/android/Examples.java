package com.android;

import java.util.Arrays;
import java.util.List;

public class Examples {

	
	static void ex1() {
		System.out.println("Declaring variables of type Season enum");
		
		Season mySeason1 = Season.SPRING; //ordinal (position) 0
		Season mySeason2 = Season.SUMMER; //ordinal 1
		Season mySeason3 = Season.AUTUMN; //ordinal 2
		Season mySeason4 = Season.WINTER; //ordinal 3
		
		/*
		 * Will print 'Spring'. Calls the toString method of the Season class, which just prints off the enum type name.
		 */
		System.out.println("mySeason1 is: " + mySeason1);
		
		//enum is made up of 2 parts: ORDINAL & NAME: ++++++++
		
		System.out.println("Ordinals"); //"Ordinals" is the index position of the enum type. ++++++++++++++++++++++++++++
		
		System.out.println("position of mySeason is: " + mySeason1.ordinal()); 
		
		//name: (uses the enum's toString method)
		System.out.println("names of enum: " + mySeason1.name());
		
		List<Season>seasons= Arrays.asList(Season.values());
		
		/*
		 * Season.value() produces an array of all all the season types in our Season enum. 
		 * We then assign this array to a list of type Season called seasons.
		 */
		
		//prints off: [SPRING, SUMMER, AUTUMN, WINTER]
		System.out.println(seasons);
		
		//print off ordinals:
		System.out.println(mySeason1.ordinal());
		System.out.println(mySeason2.ordinal());
		System.out.println(mySeason3.ordinal());
		System.out.println(mySeason4.ordinal());
		
		//=============================================================
		//print out all details of Season enum
		
		for(Season season: Season.values()) {
			System.out.println("name of season is: " + season.name());
			System.out.println("ordinal of season is: " + season.ordinal());
			
			/*
			 * This uses the toString mwethod of the enum class,
			 * which we could override, but arent here.
			 */
		}
		
		
		if(mySeason1.ordinal() ==0)
				System.out.println("This is spring & has number1 as it's ordinal");
		
		
		
	}
}
