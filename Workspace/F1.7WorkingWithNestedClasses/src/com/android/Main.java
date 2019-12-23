package com.android;
/*
 * a nested innner class is a class within a class of which there are
 * four types
 * A member inner class, defined at the same level as instance variables
 * and is NOT static
 * A local inner that, this is a class that is defined inside a method
 * A anonymous inner class which is a inner class that does not have
 * a name
 * A static inner class that is defined at the same level as a static 
 * variable
 * Animal class for member inner class
 * Human class for Local inner class
 * Building class for Anonymous inner class
 * Doctor for static inner classes
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("inner classes ");
	//	Examples.ex1();
	//	Examples.ex2();
		//Examples.ex3();
		Examples.ex4();
/*		int num=90;
	
		Tree myTree=new Tree() {
			@Override
			void grow() {
				System.out.println("num is "+num);
				System.out.println("Overriden grow menthod in anonymoust class");
				reproduce();
				germinate();
			}
		};
		
		myTree.grow();
		*/
		
	}

}
