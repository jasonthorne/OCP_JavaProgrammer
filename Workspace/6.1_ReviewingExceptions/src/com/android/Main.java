package com.android;

import java.io.File;
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
		File myFile2 = new File("test2.txt");
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
