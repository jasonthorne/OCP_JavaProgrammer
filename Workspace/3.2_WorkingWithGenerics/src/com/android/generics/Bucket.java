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
	private T myBehave;
	
	public Bucket(T myBehave){
		this.myBehave = myBehave;
		myBehave.happy();
		myBehave.sad();
		myBehave.mad();
	}
	
	

}
