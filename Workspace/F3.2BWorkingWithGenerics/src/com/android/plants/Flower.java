package com.android.plants;

import com.android.interfaces.Life;

public class Flower implements Life{

	@Override
	public void grow() {
		System.out.println("flower growing");
		
	}

}

class Rose extends Flower{
	@Override
	public void grow() {
		System.out.println("Rose growing");
		
	}
	
}
