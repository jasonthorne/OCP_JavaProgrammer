package com.android;

public class Examples {
	
	static void ex1() {
		
		//=================================================USE EQUALS WHEN DETERMINING IF A STRING IS EQUAL
		
		System.out.println("\nex1:");
		
		String s1 = "bunny";
		String s2 = "bunny";
		String s3 =  new String("bunny");
		
		System.out.println(s1 == s2);
		System.out.println(s2 == s3);
		System.out.println(s2.equals(s3));
		
		
		//----------------
		
		
		//everything AFTER a String is a string;
		
		String s4 = "1" + 2 + 3; //this is sting 123
	
		String s5 = 1 + 2 + "3"; //this is sting 33
		
	}
	
	
	static void ex2() {
		
		//=================================================STRING METHODS:
		
		System.out.println("\nex2:");
		
		String s = "abcde";
		System.out.println(s.trim().length()); //5
		System.out.println(s.charAt(4)); //e (uses array numbering)
		
		System.out.println(s.indexOf("e")); //4
		
		System.out.println(s.indexOf("de")); //3
		
		System.out.println(s.substring(2,5)); //cd
		
		System.out.println(s.replace("a", "1")); //1bcde
		
		System.out.println(s.contains("DE")); //false
		
		System.out.println(s.startsWith("a")); //true
		
		/*
		 * Strings are immutable, so all methods of the string class do not change the string. 
		 */
		
		System.out.println(s); //still "abcde"
		
	}
	
	
	static void ex3() {
		
		//=================================================STRINGBUILDER:
		
		System.out.println("\nex3:");
		
		
		
		StringBuilder b = new StringBuilder();
		
		/*
		 * methods of the strinBuilder class DO change the stringBuilder object
		 */
		
		b.append(12345).append('_');
		
		System.out.println(b);
		System.out.println(b.length());
		System.out.println(b.indexOf("_"));
		System.out.println(b.charAt(2));
		
		
		System.out.println(b.reverse()); //this method changes the stringbuilder object
		
		System.out.println(b); //this is now: _54321
		
		//--------
		
		StringBuilder sb = new StringBuilder("abcde");
		
		sb.insert(1, '*').delete(3, 4); //inserts at pos 1, and deletes at pos 3 an UP TO but NOT INCLUDING 4.
		
		System.out.println(sb); //this is now: a*bde
		
		System.out.println(sb.substring(1,4)); //*bd
		
		System.out.println(b); //substring does NOT change the Stringbuilder
		
		
	}

}
