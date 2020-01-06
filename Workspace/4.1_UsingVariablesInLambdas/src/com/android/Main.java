package com.android;


/*
 * RULES FOR ACCESSING LAMBDAS:
 * 
 * Lambdas can acess fields of a class, as they always have a default value even if none are given
 * (ie string has a default value of null, uin has default val of 0 etc).
 * Lambdas can access method parameters, as long as the method parameter's values dont change inside the method
 * Lambdas can access local variables that have been given a value and are effectively final. 
 * However if you change the value of a local variable, a lambda can no longer access this variable. 
 */




public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
