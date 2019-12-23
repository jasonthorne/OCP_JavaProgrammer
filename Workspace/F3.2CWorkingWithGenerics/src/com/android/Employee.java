package com.android;
/*
 * we create our Employee with a type, e.g Animal, that means that type V will be
 * Animal anywhere inside the Employee
 */
public class Employee<V> {
	
	V myV;
	public Employee(V myV) {
		this.myV=myV;
	}
/*
 * this method can only take a bank with a type that is of type V or a sub class of 
 * V. e.g we have set the type V to be a Animal, that means this can only take a bank
 * that was created with a type of Animal,Dog,Poodle or Cat
 * Bank<Animal>myBank;
 * Bank<Dog>myBank;
 * Bank<Poodle>myBank;
 * Bank<Cat>myBank;
 * if we create a bank, with any other type, we cannot use the pay method with this
 * type of bank.
 */
	public void pay(Bank<? extends V>myBank) {
		System.out.println("pay method");
		System.out.println(myBank.myT.getClass().getSimpleName());
		
	}
	/*
	 * this method can only take a bank that was created with a type of V or a superclass
	 * of V. ie if type is set to Animal, we can only use a bank created with Animal or
	 * a Object
	 */
	public void work(Bank<? super V>myBank) {
		System.out.println("work method");
	//	System.out.println();
	}
	
	public<T> void deposit(T myT) {
		T t;
	}
}
class Bank<T>{
	
	T myT;
	public Bank(T myT){
		this.myT=myT;
	}
}
