package com.android;

public interface Behaviour {
	
	void sad();
	void happy();
	void mad();

}

class Whale implements Behaviour{
	
	int age;
	String name;

	@Override
	public void sad() {
		System.out.println("whale sad");
		
	}

	@Override
	public void happy() {
		System.out.println("whale happy");
		
	}

	@Override
	public void mad() {
		System.out.println("whale mad");
		
	}
	
}

class Lemur implements Behaviour{
	int age;
	String name;
	@Override
	public void sad() {
		System.out.println("lemur sad");
		
	}
	@Override
	public void happy() {
		System.out.println("lemur happy");
		
	}
	@Override
	public void mad() {
		System.out.println("lemur mad");
		
	}
	
	
}
