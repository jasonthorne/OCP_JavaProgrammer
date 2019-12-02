package com.android.animals;

import com.android.interfaces.Behaviour;

public class Whale implements Behaviour{

	@Override
	public void sad() {
		System.out.println("Whale sad");
		
	}

	@Override
	public void happy() {
		System.out.println("Whale happy");
		
	}

	@Override
	public void mad() {
		System.out.println("Whale mad");
		
	}
	
	

}
