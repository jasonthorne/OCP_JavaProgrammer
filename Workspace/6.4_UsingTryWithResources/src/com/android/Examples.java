package com.android;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Examples {
	
	
	static void ex1() {
		
		System.out.println("\nex1:");
		
		Path path1=Paths.get("src/test.txt");
		Path path2=Paths.get("src/test2.txt");
		
		System.out.println(path1.getParent()); //shows the folder in which the files are contained
		
		//=============================BUFFERED READER:

		BufferedReader in = null;
		
		
		try {
			
			/*
			 * this is now an object that can read from a file in the path "src/test.txt"
			 * No exception is generated so the catch will not run. 
			 * However this bufferedReader object is a live connection to an external file, which is a security risk.
			 * So you sohuld ALWAYS close a connection after you've finished reading to your file. 
			 */
			in=Files.newBufferedReader(path1);
			
		}catch(IOException e) {
			
			System.out.println("IOEception is generated: " + e);
			
		}finally {
			
			System.out.println("closing our BufferedReadrResource");
			/*
			 * You usually close resources in a finally block. 
			 * In.close is a file operation, so it needs to be put in a try/catch block.
			 */
			try{
				in.close();
			}catch(IOException e) {
				System.out.println(e);
			}
			
		}
		
	}
	
	
	static void ex2() {
		
		System.out.println("\nex2:");
		
		//========================================TRY WITH RESOURCES:
		
		Path path1=Paths.get("src/test.txt");
		Path path2=Paths.get("src/test2.txt");
		
		/*
		 * Try with resources has a ().
		 * In there we put the resources we want to be automatically closed.
		 * Below we put in a BufferedReader, which will read from a file src/test.txt
		 * ONLY objects who's classes implement AutoClosable can be in a try with resources
		 */
		
		//these resources MUST be on SEPERATE LINES +++++++++++++++++++++++++++++++
		try(BufferedReader in=Files.newBufferedReader(path1); //this is the object we use to read from test.txt
			BufferedWriter out = Files.newBufferedWriter(path2);) { //this is the obj we use to write to test2.txt
			
			System.out.println("try with resources runs. test2.txt runs");
			out.write(in.readLine());
			
		}catch(IOException e) {
			System.out.println("IOException");
		}
		
		System.out.println("BufferedReader is now closed");
		
	
	}
	
	
	static void ex4() {
		
		System.out.println("\nex4:");
		
		//========================================AUTOCLOSABLE
		
		/*
		 * Bird class below doesnt NOT implement autoclosable, so cannot be in a 'try with resources' 
		 */
		/*
		try(Bird myBird = new Bird()){
			
		}*/
		
		try(Pub myPub = new Pub()){
			myPub.takeIdiotsMoney();
			myPub.serveIdiots();
		}
		
		
		
	
	}

}
