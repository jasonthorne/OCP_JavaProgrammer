package com.android;
/*
 * rules for accessing variables in lambdas
 * Lambdas can access fields of a class, as they always have a default value even
 * if none are give (i.e String has a default value of null, int has a default
 * value of 0,etc)
 * lambdas can access method parameters, as long as the method parameters values
 * do not change inside the method
 * lambdas can access local variables that have been given a value and are 
 * effectively final, however if you change the value of a local variable a lambda
 * can no longer access this variable
 */
public class Gorilla {
	/*
	 * any lambda will be able to access this variable
	 */
	String name="magilla";
	{
		name="george";
	}
	/*
	 * any lambda can access this variable, as age will be given the 
	 * default value of 0
	 */
	int age;
	double weight;
	enum Food{
		BANANAS,MANGO,BAMBOO,COCONUT
	}
	Food myFood;
	/*
	 * any lambda can also acess this variable
	 */
	static int statInt;
	/*
	 * this method takes a method parameter of true or false which 
	 * a lambda can access as long as you don't change the parameter
	 * a method parameter has to be final or EFFECTIVELY final to be 
	 * accessed inside a lamba
	 */
	void everyOneMove(boolean baby) {
		//baby=true;//comment out this to see we cannot then access in lambda
		/*
		 * play method  takes an object that implements the Movement interface
		 * this can be object of a class that implements the Movement interface
		 * a anoymous class that implements the interface
		 * or a LAMBDA
		 */
		System.out.println("accessing method parameters *****");
		play(
				()->{
					System.out.println("can access method parameters");
					/*
					 * if we changet the value of the variable "baby" anywhere
					 * inside this method, the lambda will no longer be able
					 * to access this method parameter
					 */
					System.out.println("baby is "+baby);
					//baby=true;
					return "baby is "+baby;
				}
				);//end of lambda
	//	baby=true;//comment out to see we cann then access in lambda
		System.out.println("accessing fields ***");
		/*
		 * a lambda in a method in a class, can access ALL fields of the object
		 * here can access name, age,statInt.
		 * also it does not matter if any of these variables are changed anywhere
		 *, the lambda will still be able to access them
		 */
		age=120;
		play(
				()->{
					System.out.println("access name "+name);
					System.out.println("access age "+age);
					System.out.println("access statInt "+statInt);
					age=45;
					System.out.println("age is now "+age);
					System.out.println("accessing weight "+weight);
					System.out.println(myFood);
					return "play lambda can access all fields of a object";
				}
				);//end of lambda
		name="georgina";
		int num=230;
		double number;
		boolean check=true;
		check=false;
		System.out.println("accessing local variables");
		/*
		 * a lambda can only access local variables that are final or 
		 * effectively
		 */
		play(
				()->{
					//num is effectively final, given value and value does not change
					System.out.println("acessing num "+num);
					/*
					 * local variables are NOT given a default value, so this 
					 * cannot accessed
					 */
				//	System.out.println(number);//cannot access
					/*
					 * we cannot access the local variable "check" as we initially
					 * give it a value of true and then change it to false, so this
					 * variable is NOT effectively final
					 */
				//	System.out.println(check);
					return "accessing local variables in a lambda";
				}
				);
		/*
		 * uncomment this line to see that num is now no longer effectively final
		 * so would not be able to access num in lamda
		 */
		//num=89;//
		
	}
	/*
	 * this method can take a object of a class that impelements the Movement interface
	 * OR a lambda that implements the Movement interface
	 * OR A anonymous class object that implements the Movement interface
	 */
	String play(Movement m) {
		return m.move();
	}
}
/*
 * a functional interface is an interface that has only ONE abstract method and 
 * you can create lambdas from this interface
 */
@FunctionalInterface
interface Movement{
	String move();
}
