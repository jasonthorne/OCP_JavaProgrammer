package com.android;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			/*
			 * A traditional try has to have a catch OR a finally, it can have both.
			 * 
			 * You cant have a catch or a finally without a try.
			 */
			
			throw new Exception(); //checked exception
			
		}catch(Exception e) {
			System.out.println("exception " + e + "is generated");
		}
		finally {
			
		}
		
		
		/*
		 * You have to deal with a checked exception, if you dont your program will not compile.
		 */
		
		//throw new Exception();
		
		try {
			throwMeChecked(); //this COULD throw a checked exception, so MUST be inside a try/catch ++++++++++++++++++++++
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		
		throwMeRuntime();
		
		
		multi();

		
	}
	
	/*
	 * Anything that can produce a chexcked exception HAS TO BE put inside a try/catch block
	 */
	static void throwMeChecked() throws Exception{
		
	}
	
	/*
	 * this does NOT have to be in a ytry/catch as this is only a runtime exception.
	 * This method produces no exception at all, so when you call this method, your code will run fine. 
	 * All that the throws here does is IF a runtime exception is thrown in this method the method does not need a try/catch but will throw it out. 
	 * However if it does the calling would have to be put in a try/catch.
	 */
	static void throwMeRuntime()throws RuntimeException{
		System.out.println("throwMeRuntime() exception");
		
		//if we comment in this code the program will crash as the call to this method is not in a try catch block:
	
		/*
		List<Integer>nums=Arrays.asList(3,5,6);
		System.out.println(nums.get(5)); //this generates an index out of bounds exception (which is thrown back)
		*/
		
	}
	
	
	static void multi() {
		
		/*
		 * a file object is the address of a file, not the file itself.
		 */
		File myFile1 = new File("test1.txt");
		File myFile2 = new File("C:/someDir/test.txt");
		
		List<Integer>nums = Arrays.asList(34,56,8);
		
		try {
			//uncomment these to see their exceptions:
			//nums.get(5); //caught by the first catch block
			//Dog spot = (Dog) new Animal(); //caught by the 2nd catch block
			//LocalDate myDate = LocalDate.of(1970, 14, 29); //caught by 3rd catch block, that deals with ALL other runtime exceptions
			
			System.out.println("is file created: " + myFile1.createNewFile()); //this WILL create a file
			//System.out.println("is file created: " + myFile2.createNewFile()); //this WONT create a file as the path a non existent dir.
			
			//throw new SQLException();
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println(e.getClass().getSimpleName());//this catches the 1st exception
		}
		catch(ClassCastException e) { 
			System.out.println(e.getClass().getSimpleName());//this catches the 2nd exception
		}
		catch(RuntimeException e) {
			System.out.println(e.getClass().getSimpleName());//this catches all other runtime exceptions
		}
		
		//-------------below WILL NOT COMPLE unless there's some code in the try block that COULD generate an exception. 
		catch(IOException e) { //this will catch all IO exceptions
			System.out.println(e.getClass().getSimpleName());
		}
		
		catch(Exception e) { //this can catch ANY exception.
			System.out.println(e.getClass().getSimpleName());
			//SQL exception caught here
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
