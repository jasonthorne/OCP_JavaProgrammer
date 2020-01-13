package com.android;

public class Main {
	
	/**
	 * 
	 *STREAMS
	 *
	 *These are NOT file input or output streams. Which are something completely different and are covered in chapter 8.
	 *
	 *A stream is NOT a data structure. I.e not an arrayList etc. 
	 *Instead it takes input from COLLECTIONS, ARRAYS or I/O CHANNELS, or we can generate data using iterate and generate.
	 *
	 *Streams dont usually change the original data structure (but they can).
	 * If its based on a list it will usually not change the original data, but it can.
	 * 
	 * Streams are made up of three basic parts:
	 * + Creation 
	 * + Intermediate Operation: These are operations that are carried out on the stream. Such as filter(), and limit().
	 * They are lazily executed. Which means the actions are not carried out until a TERMINAL OPERATION.
	 * + Terminal operation: A method that calls all of the intermediate operations of a stream. 
	 * It also closes the stream, and returns a result of the stream. 
	 * Example of a terminal method is: forEach().
	 */

	public static void main(String[] args) {
		
		//Examples.ex1();
		//Examples.ex2();
		//Examples.ex3();
		//Examples.ex4();
		Examples.ex5();

	}

}
