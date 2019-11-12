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
			 * This uses the toString method of the enum class,
			 * which we could override, but arent here.
			 */
		}
		
		
		if(mySeason1.ordinal()==0) {
				System.out.println("\nThis is spring & has number 0 as it's ordinal");
		}
		else System.out.println("Not spring");
		
		/*
		 * You can create n enum variable from a string, but they HAVE to match the enum type and has to be the same case. 
		 */
		Season s1 = Season.valueOf("SUMMER");
		
		s1=Season.valueOf("SUMMER");
		
	}
	
	static void ex2() {
		System.out.println("create first season2 obj:");
		
		/*
		 * The season2 class contains a constructor that contains no args.
		 * If our enum types do not have braces after them i.e SUMMER(), 
		 * that means that this enum types is calling the blank no argument constructor of the enum season2 class.
		 */
		
		Season2 mySeason = Season2.SUMMER;
		System.out.println("create second season2 obj:");
		Season2 mySeason2 = Season2.WINTER;
		
		Days monday = Days.MON;
		
		System.out.println("create another days");
		Days sunday = Days.SUN;
		
		/*
		 * This is calling the signIn method that we created in the 
		 */
		monday.signIn();
		
		sunday.signIn();
		
		
		Days wednesday = Days.WED;
		wednesday.signIn();
		
		
		//==================================
		
		System.out.println("\n==========================================================\nCreating Months:");
		
		Months janurary = Months.JAN; //this calls the enum month's printMe method
		
		Months december = Months.DEC; //this calls the overriden december printMe method
		
		december.printMe();
		System.out.println();
		
		//========
		
		AnimalTypes myMammal = AnimalTypes.MAMMAL;
		AnimalTypes myReptile = AnimalTypes.REPTILE;
		AnimalTypes myAvion = AnimalTypes.AVIAN;
		
		
		myMammal.walk(); //has own walk method
		myMammal.run(); //uses main enum run method
		
		myReptile.walk(); //uses main enum walk method
		myReptile.run(); //has own run method
		
		myAvion.walk(); //uses main enum walk method
		myAvion.run(); //uses main enum run method
	}
	
	
}
