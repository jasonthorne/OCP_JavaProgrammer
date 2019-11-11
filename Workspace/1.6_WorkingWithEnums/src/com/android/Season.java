package com.android;

/*
 * Enums are your own data types.
 * So here we are going to create a data type that has only 4 values. (SPRING, SUMMER, AUTUMN, WINTER)
 */

public enum Season {
	
	
	//Every enum value is implicitly static final & public. ++++++++++++++++
	SPRING, SUMMER, AUTUMN, WINTER
	
	/*
	Enums dont allow inheritence. I.E Enums CANT extend or be extended.++++++++++++++
	*/
	
	

}

/* DOESNT WORK 
enum noEnum extends Season{
	
}
*/