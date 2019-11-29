package com.android.generics;

import com.android.interfaces.Behaviour;

/*
 * This class takes a generic type, whose class implements the behavior interface.
 * NOTICE its not implements it's EXTENDS. 
 * Whether a class is using a generic type that is a subclass that either extends a class or implements an interface
 * we use the same keyword "extends"
 */
public class Bucket<T extends Behaviour> { 
	
	/*
	 * This variable of type T will only have access to the methods in the Behaviour interface
	 * which are happy(), mad() and sad().
	 * This can be a whale or a lemur
	 * 
	 */
	private T myBehave; //this is going to be a whale 
	
	public Bucket(T myBehave){
		this.myBehave = myBehave;
		myBehave.happy();
		myBehave.sad();
		myBehave.mad();
	}
	
	//T will be whatever you set T to be. (remember that T has be something that extends Behavour)
	public void fill(T myT, int num) {
		
		//this will print out whatever type T is set to when we create this object:
		System.out.println("Bucket fill method created with: " +  myT.getClass().getSimpleName()); 
		
	}
	

}
