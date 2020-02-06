package com.android;

public class TurkeyShed  implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("Turkey shed closing");
		
	}

}


