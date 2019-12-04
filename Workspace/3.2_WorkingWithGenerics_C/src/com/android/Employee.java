package com.android;

/*
 * We create our Employee with a type (eg Animal that means type V will be Animal).
 * 
 */

public class Employee<V> { //an Employee created with a specific type
	
	V myV;
	
	//constructor
	public Employee(V myV) {
		this.myV = myV;
	}
	
	 //whatever type you create an Employee with, the Bank being passed to this method can only be created with a type that is or extends that Employee type ++++++++++++++++++++
	public void pay(Bank<? extends V>myBank) {
		System.out.println("pay method");
		System.out.println(myBank.myT.getClass().getSimpleName());
	}
	
	//whatever type you create an Employee with,the Bank being passed to this method can only be created with a type that is or is a parent of that Employee type ++++++++++++++++++++
	public void work(Bank<? super V>myBank) {
		System.out.println("work method");
		System.out.println(myBank.myT.getClass().getSimpleName());
	}

}


class Bank<T>{
	
	T myT;
	
	//constructor
	public Bank(T myT){
		this.myT = myT;
	}
}