package com.android;

public interface Life {
	void grow();

}

class Flower implements Life{

	@Override
	public void grow() {
		System.out.println("flower growing");
		
	}
	
}
