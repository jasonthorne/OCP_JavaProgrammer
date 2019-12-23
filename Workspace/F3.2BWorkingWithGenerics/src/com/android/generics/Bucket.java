package com.android.generics;

import com.android.interfaces.Behaviour;
/*
 * this class takes a Generic data type, whose class implements the Behaviour interface.
 * notice its NOT implements its EXTENDS. Whether a class is using a generic type that is
 * a extends a class or implements an interface, we use the same keyword EXTENDS
 */
public class Bucket <T extends Behaviour>{
	/*
	 * variable of type T will only have access to the methods in the Behaviour interface,
	 * which are happy(),mad(),sad()
	 * so this can be a While or a lemur
	 */
	private T myBehave;
	
	public Bucket(T myBehave){
		this.myBehave=myBehave;
		myBehave.happy();
		myBehave.sad();
		myBehave.mad();
	}
	/*
	 * here myT will be whatever you set T to be
	 */
	public void fill(T myT,int num) {
		System.out.println("bucket fill method ");
		System.out.println("bucket created with a ");
		//this will print out whatever type we have T set as when we create a object
		System.out.println(myT.getClass().getSimpleName());
	}

}
