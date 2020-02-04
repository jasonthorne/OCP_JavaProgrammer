package com.android;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Examples {
	
	static void ex1() {
		
		System.out.println("\nex1:");
		
		//====================================MULTICATCH:
		
		try{
			
			LocalDate date = LocalDate.parse("sdsdds");
			
			//the below code wont run as above code will generate an exception and be caught ++++++++++++++++++++++++++++++++++++
			Path path=Paths.get("c:/sdsds.txt"); //this is just an address
			String txt = new String(Files.readAllBytes(path)); //this is trying to read the non existant file
			
		}catch(DateTimeParseException e) {
			System.out.println(e);
			System.out.println("1st catch block");
		
		}
		catch(IOException e) {
			System.out.println(e);
			System.out.println("2nd catch block");
			
		}
		
	}
	
	
	static void ex2() {
		
		System.out.println("\nex2:");
	
		//====================================MULTICATCH CONTINUED:
		
		try {
			
			Path path=Paths.get("c:/sdsds.txt"); //this is just an address
			String txt = new String(Files.readAllBytes(path)); //this is trying to read the non existant file
			
			LocalDate date = LocalDate.parse("sdsdds");
			
		}catch(DateTimeParseException | IOException | ArrayIndexOutOfBoundsException e) {
			
			System.out.println(e);
			
			String eClass = e.getClass().getSimpleName();//turn exception to string
			
			switch(eClass) {
			case "NoSuchFileException":
				System.out.println("there is no file of this name");
				break;
			case "DateTimeParseException":
				System.out.println("invalid date entered");
				break;
			default:
				System.out.println("dunno what the exception is!!");
				
			}
			
		}
		
		
	}

}
