package com.android;

import java.util.ListResourceBundle;

public class Zoo_en extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{"hello", "Hello there, welcome to the zoo"},
			{"open", "the zoo is open"}
		};
	}
	
}


//NOT PUBLIC:
class Zoo_fr extends ListResourceBundle{
	
	@Override
	protected Object[][] getContents() {
		return new String[][] {
			{"hello", "Bonjour et bienvenue au bureau"},
			{"open", "le bureau est ouvert"},
		};
	}
	
}