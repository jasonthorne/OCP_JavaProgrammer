package com.android;

import java.sql.SQLException;
import java.time.format.DateTimeParseException;

public class Main {

	public static void main(String[] args) {
		
		
		try {
			Examples.ex1();
		} catch (DateTimeParseException | SQLException e) {
			e.printStackTrace();
		}

		try {
			Examples.ex2();
		} catch (DateTimeParseException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
