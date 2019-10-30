package com.android;

import java.util.Arrays;
import java.util.List;
/*
 * constructors of a Enum can only be PRIVATE or DEFAULT
 */
public class Examples {
	
	static void ex1() {
		Season mySeason=Season.SPRING;
		Season mySeason2=Season.SUMMER;
		Season mySeason3=Season.AUTUMN;
		Season mySeason4=Season.WINTER;
		System.out.println("print details");
		/*
		 * will print spring, calls the toString method of the Sesaon class which just prints off the enum
		 * type name
		 */
		System.out.println(mySeason);
		//position of the enum in the enum types
		System.out.println(mySeason.ordinal());//will print 0
		System.out.println(mySeason.name());//will print the name
		//this will display all of the enum types in our seasons enum
		//.values() returns an array of all the enum types, which we then assign a list
		List<Season>seasons=Arrays.asList(Season.values());
		//print out the list which will display SPRINT,SUMMER,AUTUMN,WINTER
		System.out.println(seasons);
		/*
		 * our seasons in this class are
		 * SPRING,SUMMER,AUTUMN,WINTER
		 * so if we use array numbering we could say that
		 * SPRING = 0
		 * SUMMER = 1
		 * AUTUMN = 2
		 * WINTER = 3
		 * each of the seasons are assigned a number and we can access these numbers by calling the ORDINAL
		 * method of the enum class
		 */
		System.out.println("print ordinals");
		System.out.println(mySeason.ordinal());//will print 0
		System.out.println(mySeason2.ordinal());//will print 1
		System.out.println(mySeason3.ordinal());//will print 2
		Season mySeason5=Season.SPRING;
		/*
		 * it is premissable to use "==" instead of "equals()" as a enum is a static so there is only
		 * one of them per class
		 */
		System.out.println(mySeason==mySeason5);//will be true, same static final 
		System.out.println(mySeason.equals(mySeason5));//will also be true
		
		System.out.println(mySeason4.ordinal());//will print 3
		System.out.println("print all from enum");
		for(Season season:Season.values()) {
			System.out.println(season.name());//this returns the name of the num (NOT THE TOSTRING() METHOD)
			/*
			 * this returns the toString method of the Season enum, which will by default, will be the name of
			 * the enum type, we can override this method, which we will do in the SolarSystem class
			 */
			System.out.println("season is "+season);
			System.out.println("season number is "+season.ordinal());
		}
		
		/*
		 * we can use the ordinal just like we would any other number
		 */
		if(mySeason.ordinal()==0) {
			System.out.println("this is spring and has number 1 as it's ordinal");
		}
		else
			System.out.println("this is not spring");
		/*
		 * you can create an enum variable from a string, but they have to match the enum types
		 */
		Season s1=Season.valueOf("SUMMER");//this will compile and run
		/*
		 * this will generate an IllegalArgumetnException as it's the wrong case
		 */
	//	s1=Season.valueOf("summer");
		
	}
	
	static void ex2() {
		/*
		 * Season2 has a constructor that takes a String, so when we create a Season2 object the constructor for 
		 * all the enum values are called. 
		 * so in this case we  have four values in our Season2 enum so the constructor is called four times
		 */
		Season2 mySeason=Season2.WINTER;
		/*
		 * constructor is not called again no matter how enums are created, constructor is only called the first
		 * time an enum is created
		 */
		Season2 mySeason2=Season2.SUMMER;
		/*
		 * you can call a method of a enum like you would any other method
		 */
		System.out.println("print expected visitors");
		//this is summer, not overriden in the summer enum type
		mySeason2.printExpectedVisitors();
		//this is Autumn, this is overriden in the Autumn enum type
		Season2.AUTUMN.printExpectedVisitors();
		//each enum type has to override this abstract method
		Season2.AUTUMN.abMethod();
		/*
		 * this method is not overriden in any of the enum type
		 */
		mySeason.sunShining();
		/*
		 * variables of the enum can be accessed if they are public or if in the same package and marked as package
		 * level access or protected
		 */
		System.out.println(mySeason.num);
		//can access variable through enum type name
		System.out.println(Season2.SUMMER.num);
		//cannot access private variables outside of the enum
		//System.out.println(Season2.WINTER.avgTemp);
		
	}
	
	static void ex3() {
		/*
		 * can use enums in switch statements
		 * we do not have to go mySeason.SUMMER in the switch statement as the compiler knows it can only
		 * be one of four seasons, in fact if we went mySeason.SUMMER you would get a compilation error in the
		 * switch statement
		 */
		Season mySeason=Season.SUMMER;
		switch(mySeason) {
		//COMPILATION ERROR
		//case mySeason.SUMMER:
		case SUMMER:
			System.out.println("summer so go sunbathin");
			break;
		case AUTUMN:
			System.out.println("Autumn so put on warmed clothes");
			break;
		case WINTER:
			System.out.println("Winter is here wrap up ");
			break;
		case SPRING:
			System.out.println("Spring is here so put on ligher clothes");
			default:
				System.out.println("dunno what season it is");
		}
	}
	
	static void ex4() {
		SolarSystem solarSystem=new SolarSystem();
		System.out.println(solarSystem);
	}

}
