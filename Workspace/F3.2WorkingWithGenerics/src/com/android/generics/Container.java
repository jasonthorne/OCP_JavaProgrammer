package com.android.generics;
/*
 * a class can have as many generics as you want, here this class has three
 * generics T, U, V
 */
public class Container <T,U,V>{
	
	T myT;
	U myU;
	V myV;
	//constructor that takes three variables
	public Container(T myT,U myU,V myV){
		this.myT=myT;
		this.myU=myU;
		this.myV=myV;
		System.out.println("constructor that takes three variables");
		System.out.println("myT is a "+myT.getClass().getSimpleName()+myT);
		System.out.println("myU is a "+myU.getClass().getSimpleName()+myU);
		System.out.println("myV is a "+myV.getClass().getSimpleName()+myV);
	}
	//constructor that takes no variables
	public Container(){
		System.out.println("constructor that takes no variables");
	//	System.out.println(myT.getClass().getSimpleName());
	}

}
