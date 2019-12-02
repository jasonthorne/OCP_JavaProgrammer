package com.android.generics;


/*
 * A class can have ad many generics as we want. Here this las has 3 generics: T, U, V
 */
public class Container <T,U,V>{
	
	T myT;
	U myU;
	V myV;
	
	//constructor that takes three variables:
	public Container(T myT, U myU, V myV) {
		super();
		this.myT = myT;
		this.myU = myU;
		this.myV = myV;
		System.out.println("constructor that takes 3 variables");
		System.out.println("myT is a: " + myT.getClass().getSimpleName() + " " + myT); //print what they are, and their results (them)
		System.out.println("myU is a: " + myU.getClass().getSimpleName() + " " + myU);
		System.out.println("myV is a: " + myV.getClass().getSimpleName() + " " + myV);
	}
	
	//constructor that takes no variables
	public Container(){
		System.out.println("constructor that takes NO variables");
		
	}
	
}



