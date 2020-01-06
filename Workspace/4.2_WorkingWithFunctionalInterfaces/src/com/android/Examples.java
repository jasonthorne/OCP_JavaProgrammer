package com.android;

/*
 * DOBLE COLON OPERATOR
 * 
 * ::
 * 
 * Can be used for a static method, and instance method or a constructor
 */

public class Examples {
	
	Manners<String>m1=(m)->"manners lambda m1"; //lambda from Manners interface
	
	//Manners

}


@FunctionalInterface
interface Manners<T>{
	T sad(T t);
}