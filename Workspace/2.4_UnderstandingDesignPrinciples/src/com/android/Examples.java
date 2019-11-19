package com.android;

public class Examples {
	
	static void ex1() {
		
		
		try {
			//valid args will print out what we want
			Human harry = new Human("Harry", 5);
			System.out.println("Our human is created.");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		try {
			//invalid string
			Human helen = new Human(null, 24);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			//invalid string
			Human harriet = new Human(" ", 24);
			System.out.println("human with spaces created");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			//invalid string
			Human bob = new Human("", 24);
			System.out.println("human with no length string created");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			//invalid age
			Human bill = new Human("ben", -1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			//invalid sting and age. only gets to invalid sting message 
			Human bob = new Human("", -1);
		}catch(Exception e) {
			System.out.println(e.getMessage()); //second error message isnt shown
		}
		
		
	}

}
