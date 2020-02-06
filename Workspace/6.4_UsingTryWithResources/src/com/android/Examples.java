package com.android;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Examples {
	
	
	static void ex1() {
		
		System.out.println("\nex1:");
		
		Path path1=Paths.get("src/test.txt");
		Path path2=Paths.get("src/test2.txt");
		
		System.out.println(path1.getParent()); //shows the folder in which the files are contained
		
		//=============================BUFFERED READER:

		BufferedReader in = null;
		
		
		try {
			
			/*
			 * this is now an object that can read from a file in the path "src/test.txt"
			 * No exception is generated so the catch will not run. 
			 * However this bufferedReader object is a live connection to an external file, which is a security risk.
			 * So you sohuld ALWAYS close a connection after you've finished reading to your file. 
			 */
			in=Files.newBufferedReader(path1);
			
		}catch(IOException e) {
			
			System.out.println("IOEception is generated: " + e);
			
		}finally {
			
			System.out.println("closing our BufferedReadrResource");
			/*
			 * You usually close resources in a finally block. 
			 * In.close is a file operation, so it needs to be put in a try/catch block.
			 */
			try{
				in.close();
			}catch(IOException e) {
				System.out.println(e);
			}
			
		}
		
	}
	
	
	static void ex2() {
		
		System.out.println("\nex2:");
		
		//========================================TRY WITH RESOURCES:
		
		Path path1=Paths.get("src/test.txt");
		Path path2=Paths.get("src/test2.txt");
		
		/*
		 * Try with resources has a ().
		 * In there we put the resources we want to be automatically closed.
		 * Below we put in a BufferedReader, which will read from a file src/test.txt
		 * ONLY objects who's classes implement AutoClosable can be in a try with resources
		 */
		
		//these resources MUST be on SEPERATE LINES +++++++++++++++++++++++++++++++
		try(BufferedReader in=Files.newBufferedReader(path1); //this is the object we use to read from test.txt
			BufferedWriter out = Files.newBufferedWriter(path2);) { //this is the obj we use to write to test2.txt
			
			System.out.println("try with resources runs. test2.txt runs");
			out.write(in.readLine());
			
		}catch(IOException e) {
			System.out.println("IOException");
		}
		
		System.out.println("BufferedReader is now closed");
		
		
	
	}
	
	
	static void ex4() {
		
		System.out.println("\nex4:");
		
		//========================================AUTOCLOSABLE
		
		/*
		 * Bird class below doesnt NOT implement autoclosable, so cannot be in a 'try with resources' 
		 */
		/*
		try(Bird myBird = new Bird()){
			
		}*/
		
		try(Pub myPub = new Pub()){
			myPub.takeMoney();
			myPub.serveBeer();
		}
		
	
	}
	
	
	
	static void ex5() throws Exception {
		
		System.out.println("\nex5:");
		
		//========================================EXCEPTION
		
		/*
		 * In a try with resources, the catch and finally block are optional.
		 * Here the turkey shed implements autoclosable, and the close method has a "throws exception"
		 * in the close signiature. 
		 * Which means we either have to have a catch block in this exception
		 *  or have this method (ex5) throws exception.
		 *  the close() method is called automatically in a try with resources, and this method
		 *  throws exception.
		 */
		
		try(TurkeyShed myTurkey = new TurkeyShed()){
			System.out.println("open turkey shed");
		}
		
	
	}
	
	
	
	static void ex6(){
		
		System.out.println("\nex6:");
		
		try(Shop myShop = new Shop()){
			System.out.println("shop open");
		}
		
		/*
		 * the close() method in the shop class throws an IllegalStateException, which is a runtime exception.
		 * If no exception was generated in the close method then you wouldnt need the catch block below.
		 */
		catch(Exception e) {
			System.out.println(e);
			System.out.println("message is: " + e);
			e.printStackTrace(); //this prints the map of the exception
		}
		
		System.out.println("our code continues");
	
	}
	
	/*
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 
	 * If the object in the try with resources generates an exception, then it can  be dealt with in the catch block 
	 * (as in ex6)
	 * or the method dealing with it can throws it to another method (as in ex5) 
	 */
	
	
	
	static void ex7(){
		
		System.out.println("\nex7:");
		
		/*
		 * Shop implements AutoClosable and the close method of the Shop class throws a new IllegalStateException,
		 *  so the catch will deal with the IllegalStateException
		 */
		
		//======================================SUPRESSED EXCEPTIONS +++++++++++++++++++++++++
	
		try(Shop myShop = new Shop()){
			System.out.println("open the shop");
			//close() method of the shop class will be called automatically here
			//generates IllegalStateException
		}
		catch(Exception e) { //catches IllegalStateException
			System.out.println(e); //prints out exception "shop will not close"
		}
		
		
		//----------------not catching supressed exception:
		
		/*
		 * myShop.close() generates an IllegalStateException
		 * However inside the rtry block there is an ArrayindexOutOfBoundsException generated.
		 * Any exception henerated insode a try block will be considered a PRIMARY excpetion and will be the exception caught by the catch block. 
		 * The IllegalStateException is NOT caught or dealt with by the catch block.
		 */
		
		try(Shop myShop = new Shop()){
			System.out.println("open a second shop");
			int[]nums= {34,56};
			/*
			 * Below causes an exception which is what will be caught in the catch beneath it. 
			 * PREVENTING the IllegalStateException in the shop class from being caught ++++++++++++++++++++++++++++++++
			 */
			System.out.println(nums[3]); 
		}
		catch(Exception e) { //will only catch the ArrayIndexOutOfBOundsException
			System.out.println(e); 
			
			
			/*
			 * ++++++++++++++++++++++++++++++++++++++++++++++++++++
			 * getSupressed returns an array of throwables, which are all suppressed exceptions generated by the try with resources
			 * or any exceptions that were generated in the try braces
			 */
			System.out.println(e.getSuppressed().length); //GET INFO ON SUPRESSED EXCEPTION (length in this case) 
			
			System.out.println(e.getSuppressed()[0]); //shows the first exception stored in the array of throwables
			
			for(Throwable t:e.getSuppressed()) {
				System.out.println("exception is: " + t);
				System.out.println("message is: " + t.getMessage());
				e.printStackTrace();
			}
		}
		
		///---------------
		
		/*
		try(Cafe myCafe = new Cafe()){
			System.out.println("opening my cafe");
		}
		*/
	
	}
	
	
	
	static void ex8(){
		
		System.out.println("\nex8:");
		
		//====================================MULTIPLE REPRESSED EXCEPTIONS:
		
		try(Club myClub = new Club(); Bar myBar = new Bar();){ //Bar is closed FIRST, Club is closed SECOND +++++++++++++++++++++++
			
			System.out.println("inside try block");
			
			int[]nums= {34,56};
			System.out.println(nums[3]); //causes index out of bounds exception
			
			//close method for Bar THEN for Cub run here
		}
		catch(Exception e) {
			//this will ONLY see the arrayIndexOutOfBOunds exception that was generated in the try block.
			System.out.println("primary exception is: " + e);
			
			//e.getSupressed() is an array of throwable objects that are out 2 suppressed exceptions
			System.out.println("amount of supressed exceptions is: " + e.getSuppressed().length);
			
			for(Throwable t:e.getSuppressed()) {
				System.out.println("supressed exception is: " + t); //SHOW THE SUPRESSED EXCEPTIONS 
			}
			
			//showing exceptions with a stream:
			Arrays.asList(e.getSuppressed()).stream().forEach(System.out::println);
		}
	}
	
	
	
	
	
	
	
	

}
