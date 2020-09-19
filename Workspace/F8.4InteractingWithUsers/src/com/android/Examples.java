package com.android;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;

public class Examples {
	static void ex1() {
		System.out.println("old way of interacting with users on the command line prompt");
		System.out.println("enter your text ");
		/*
		 * System.in is user input on the console or command prompt
		 */
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		try {
			String userInput=reader.readLine();
			System.out.println("you entered the string "+userInput);
			/*
			 * this method will only produce strings or characters
			 * this will not produce numbers for instance
			 */
			System.out.println("enter a number");
			String strNum=reader.readLine();
			System.out.println("this is a string represtnation of a number "+strNum);
		//	System.out.println(strNum++);
			System.out.println("enter a second number");
			int num=Integer.parseInt(reader.readLine());
			System.out.println("now this is a number "+(++num));
					
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	/**
	 * the console class will not really work in eclipse, so you need to run these examples from the command
	 * line prompt
	 * copy the java files to another folder in a more conveninet location (i.e C:\JavaCode) in my case
	 * you will need to edit both files, and remove "package.com.android", as if you don't the compiler and 
	 * the java program will be looking for the following folder C:\JavaCode\com\android.
	 * before we run Javac and java we have to set the path file (basically telling our command line prompt where
	 * to the the Javac.exe program and the Java.exe program, in my case this is the in following folder
	 * C:\Program Files\Java\jdk1.8.0_231\bin
	 * you can set the permanent path name by the method described in the following web page
	 * https://javatutorial.net/set-java-home-windows-10
		or by opening your command line prompt as a administrator and CD (change directory) to the folder
		where your Main.java and Examples.java file are located and run the following command
		path=C:\Program Files\Java\jdk1.8.0_231\bin
		
	 * run the Javac command to create the class files (run this command first on the Examples file, as Main
	 * calls the Examples file and main will not compile until the Examples file is first compiled. you must run
	 * the javac command on all java files
	 * the syntax for this is "javac Examples.java" and "javac Main.java"
	 * you only have to run the Java program on the Main class file
	 * then run "java Main" and your program will run.
	 * if you get "javac not recognised", go to this following youtube video
	 * https://www.youtube.com/watch?v=bVjsFFkPgbo
	 * which will explain how to fix this error
	 * also when compiling these two files in a different folder, make sure to remove the 
	 * "package com.android"
	 * as if you don't the compiler will be looking for these two packages, or windows will interpret them
	 * as folder and will not compile
	 */
//	Console myConsole;
	static void ex2() {
		/*
		 * the console class can only be a singleton object, which means you can only have one created
		 */
		Console console=System.console();
		System.out.println("some text");
		if(console!=null) {
			System.out.println("enter some text");
			String userInput=console.readLine();
			console.writer().println("your entered the following text "+userInput);
		}
		else
			System.out.println("console is null");
			
	}

}
