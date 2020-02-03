package com.android;

import java.util.ListResourceBundle;

public class Zoo_de extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		return new String[][] {
			{"hello", "Hallo mein Frund"},
			{"open", "Der Zoo is open"},
		};
	}

}
