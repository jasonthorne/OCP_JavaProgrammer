package com.android;

import java.sql.SQLException;
import java.time.format.DateTimeParseException;

public class Examples {
	
	static void ex1() throws SQLException, DateTimeParseException{ //exception is thrown from catch to where this was called +++++++++
		
		System.out.println("\nex1:");
		
		//===================RETHROWING EXCEPTIONS:
		
		try {
			
			System.out.println("pre catchMulti call");
			catchMulti(); //this COULD throw an SQL exception so the catch is okay with accepting this 
			System.out.println("post catchMulti call");
			
		}catch(SQLException | DateTimeParseException e) {
			System.out.println(e);
			throw e; //exception is caught here, then thrown somewhere else 
			
		}
		
		System.out.println("program continues");
		
	}
	
	//this method can deal with only SQLException & DateTimeParseException or theior sublass exceptions
	static void catchMulti() throws SQLException, DateTimeParseException{
		System.out.println("calling multicatch");
		
		throw new SQLException();
	}
	
	
	
	
	
	
	static void ex2() throws SQLException, DateTimeParseException{ //exception is thrown from catch to where this was called +++++++++
		
		System.out.println("\nex2:");
		
		//===================RETHROWING EXCEPTIONS:
		
		try {
			
			System.out.println("pre catchMulti call");
			catchMulti(); //this COULD throw an SQL exception so the catch is okay with accepting this 
			System.out.println("post catchMulti call");
			
		}catch(Exception e) { //This can deal with ANY type of exception. 
			System.out.println(e);
			throw e; //exception is caught here, then thrown somewhere else 
			
		}
		
		System.out.println("program continues");
	}
	

}
