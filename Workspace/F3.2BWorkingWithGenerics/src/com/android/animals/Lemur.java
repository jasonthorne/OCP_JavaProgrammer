package com.android.animals;
import com.android.interfaces.Behaviour;
public class Lemur implements Behaviour{

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
