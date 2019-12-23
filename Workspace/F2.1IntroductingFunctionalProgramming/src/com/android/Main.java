package com.android;

import java.util.function.Predicate;

public class Main {
	public static void main(String[]args) {
		//Examples.ex1();
		Examples.ex2();
	/*	
		Predicate pred=s->true;
		pred=(Object s)->{
			String mys=(String)s;
			if(mys.length()>10)
				return true;
			return false;
		};
		
		System.out.println(pred.test("hello"));;*/
	}

}
