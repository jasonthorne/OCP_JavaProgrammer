package com.android;

import java.io.File;

public class Examples {

	static void ex1() {
		
		//======================Displaying our separator (which can be different for different machines)
		
		System.out.println(java.io.File.separator);
		
		//This is a file object. This is NOT the actual file, but the location of the file. 
		//This can also be the location of a directory
		File myFile;
		
		/*
		 * forward slash "/" is system independent. 
		 * This is something called an absolute path, which is the exact address of the folder or file.
		 */
		myFile = new File("C:/JavaTest/home");
		
		//check if file exists:
		System.out.println(myFile.exists());
		
		myFile = new File("C:/Test"); //add created folder address to file obj
		System.out.println(myFile.exists());
		
		myFile = new File("C:/Test/One.txt"); //add created file address to file obj
		System.out.println(myFile.exists());
		
		//The above are ABSOLUTE filepaths (the FULL address path) ++++++++++++++
		//however we can also use RELETIVE file paths: 
		
		System.out.println(System.getProperty("user.dir"));
		
		//if we were using absolute paths, this is what we'd need to create a file called test in our user directory
		//myFile = new File("C:/Users/rm20139/Desktop/OCP_JavaProgrammer/Workspace/8.1_UnderstandingFilesAndDirectories/Test.txt");
		
		/*
		 * If you donr provide a path, this is then a relative path. which means relative to your user Directory. 
		 */
		myFile = new File("Test.txt");
		System.out.println(myFile.exists());
		
		
		File dummy = new File("dummy.txt");
		System.out.println(dummy.exists());
		
	}
}
