package com.android;

public class Animal implements Behaviour{

	@Override
	public void sad() {
		System.out.println("Animal sad");
		
	}

	@Override
	public void mad() {
		System.out.println("Animal mad");
		
	}
	/*
	 * This method can taek a Animal, Dog or a human, as all classes implement the Behaviour interface
	 */
	static void takeAny(Behaviour behave) {
		behave.sad();
		behave.mad();
		
	}

}

class Human implements Behaviour{

	@Override
	public void sad() {
		System.out.println("human sad");
		
	}

	@Override
	public void mad() {
		System.out.println("human mad");
		
	}
	
	public String toString() {
		return "human toString method";
	}

	
}
/*
 * 
 */
class Dog extends Animal{
	void bark() {
		System.out.println("Dog barking ");
	}
}
