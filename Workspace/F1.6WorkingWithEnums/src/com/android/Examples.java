package com.android;

import java.util.Arrays;
import java.util.List;

public class Examples {

	static void ex1() {
		
		System.out.println("declaring variables of type Season enum");
		Season mySeason=Season.SPRING;
		Season mySeason2=Season.SUMMER;
		Season mySeason3=Season.AUTUMN;
		Season mySeason4=Season.WINTER;
		/*
		 * will print Spring, calls the toSTring method of the enum class
		 * which jsut prints off the enum type name
		 */
		System.out.println("mySeason is "+mySeason);
		System.out.println("ordinals");
		/*
		 * ordinal is the index position of the enum type
		 * this is the first season, which is spring, so this will be
		 * 0
		 * ordinal() is just a numbering system
		 */
		System.out.println("postion of mySeason is "+mySeason.ordinal());
		System.out.println("name()");
		//this is the name of the enum, 
		//the enum's toString method, prints out the name()
		System.out.println("name of enum "+mySeason.name());
		
		List<Integer>numbers=Arrays.asList(23,45,67,88,99);
		/*
		 * Season.values() produces an array of all the Season types
		 * in our Season enum. we then assign this array to a list
		 * of type Season called Seasons
		 */
		List<Season>seasons=Arrays.asList(Season.values());
		//prints off the list containing all our Seasons
		//prints off [SPRING, SUMMER, AUTUMN, WINTER]
		System.out.println(seasons);
		
		System.out.println("print off ordinals");
		System.out.println(mySeason2.ordinal());//index postion 1
		System.out.println(mySeason3.ordinal());//index position 2
		System.out.println(mySeason4.ordinal());//index position 3
		System.out.println("print out all details of Season enum");
		
		for(Season season:Season.values()) {
			System.out.println("name of season is "+season.name());
			System.out.println("ordinal of season is "+season.ordinal());
			/*
			 * this uses the toString method of the enum class (
			 * which we can override, but here we choose not too), which
			 * just prints out the name of the enum
			 */
			System.out.println("season toString "+season);
		}
	
		if(mySeason2.ordinal()==0) {
			System.out.println("this is spring and has number 0 as it's ordinal");
		}
		else
			System.out.println("this is not spring");
		/*
		 * You can create an enum variable from a string, but they
		 * HAVE to match the enun type and has to be the same case
		 */
		Season s1=Season.valueOf("SUMMER");//will compile
		/*
		 * this generates a IllegalArgumentExcpetion as this is the
		 * wrong case
		 */
		//s1=Season.valueOf("summer");
	}
	
	static void ex2() {
		System.out.println("create first Season2 object");
		/*
		 * the Season2 class contains a constructor that takes no
		 * arguements. if our enum types do NOT HAVE braces after then
		 * i.e
		 * SUMMER(), that means that this enum type is calling the
		 * blank no arguement constructor of the enum Season2 class
		 */
		Season2 mySeason=Season2.SUMMER;
		System.out.println("create second Season2 obejct");
		Season2 mySeason2=Season2.WINTER;
		System.out.println("creating days of the week");
		//this creates 7 enum days types, so calls two different constructors
		Days monday=Days.MON;
		System.out.println("create another days");
		Days sunday=Days.SUN;
		/*
		 * this is calling the signIn method that we have created in the 
		 * enum days
		 */
		monday.signIn();
		sunday.signIn();
		Days wednesday=Days.WED;
		wednesday.signIn();
		
		System.out.println("creating months");
		Months january=Months.JAN;
		//calls the enum months class printMe()
		january.printMe();
		Months february=Months.FEB;
		february.printMe();
		
		Months december=Months.DEC;
		//this calls the overriden printMe() method in the December class
		december.printMe();
		
		AnimalTypes myMammal=AnimalTypes.MAMMAL;
		AnimalTypes myReptile=AnimalTypes.REPTILE;
		AnimalTypes myAvian=AnimalTypes.AVIAN;
		System.out.println("using an interface");
		myMammal.walk();//has own walk method
		myMammal.run();//uses main enum run method
		myReptile.walk();//uses main enum walk method
		myReptile.run();//uses own run method
		myAvian.walk();//uses main enun walk method
		myAvian.run();//uses main enum run method
		
	}
	
	static void ex3() {
		SolarSystem solarSystem=new SolarSystem();
		System.out.println("****printing out details of solarSyste");
		System.out.println(solarSystem);
	}
	
	static void ex4() {
		/*
		 * can use enums in switch statements
		 * 
		 */
		Months myMonth=Months.JAN;
		switch(myMonth) {
		/*
		 * this will cause compilation errors
		 */
		//case myMonth.JAN:
			case JAN:
				System.out.println("it's january");
				myMonth.printMe();
				myMonth.absMethod();
				myMonth.sunShining();
				break;
			case JUN:
				System.out.println("its june");
				break;
			case OCT:
				System.out.println("Its October");
				myMonth.printMe();
				break;
			case DEC:
				System.out.println("YAHOO it's christmas");
				break;
				default:
					System.out.println("its some other month");
		}
	}

}
