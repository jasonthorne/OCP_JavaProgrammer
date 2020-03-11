package com.android;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

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
		
		
		//myFile = new File("C:/Users/rm20139/Desktop/OCP_JavaProgrammer/Workspace/8.1_UnderstandingFilesAndDirectories/com.android/Test.txt");
		
		
		//==============
		
		//this is reletive to our working directory: 
		myFile = new File("src/com/android/test2.txt");
		System.out.println(myFile.exists());
		
		myFile = new File("src/com/android/test2.txt");
		System.out.println(myFile.exists());
		
		//==================
		
		/*
		 * You can use a combination of absolute and relative paths to create a file object.
		 */
		
		//absolute path:
		File parent = new File("C:/Users/rm20139/Desktop/OCP_JavaProgrammer/Workspace/8.1_UnderstandingFilesAndDirectories");
		
		//relative path:
		File child = new File("src/com/android/test2.txt");
		
		/*
		 * There is a constructor in the file class that takes a file object (which is a parent) and a String which is a relative path.
		 * Or we can have a constructor which takes a string (which is a parent) and a file object which will be the relative file path. 
		 * There is NO constructor that takes 2 file objects. 
		 */
		
		File newPath = new File(parent, "src/com/android/test2.txt"); 
		//file location is a combination odf a file object and a string which is a relative path
		System.out.println(newPath.exists());
		
		System.out.println(newPath.getParent());

	}
	
	
	static void ex2() {
		
		//======================Various methods of the File class:
		
		
		//Exists:
		
		//returns a boolean. True if the file or directory exists at this location. False if not.
		
		File myFile = new File("Test.txt");
		System.out.println(myFile.exists());
		
		File myDir = new File("C:/Program Files");
		System.out.println(myFile.exists());
		
		
		//------------
		//GetName()
		
		/*
		 * Returns name of the file or directory denoted by this path.
		 */
		
		System.out.println(myFile.getName());
		
		System.out.println(myDir.getName());
		
		
		//--------------
		//getPath();
		
		/*
		 * Gets the apth of the file or directory
		 */
		
		System.out.println(myFile.getAbsolutePath());
		System.out.println(myDir.getAbsolutePath());
		
		
		//--------------
		
		//isFile()
		
		//returns a boolean. True if isFile, false if not (or doesn't exist)
		
		System.out.println(myFile.isFile());
		System.out.println(myDir.isFile());
		
		File dummy = new File("dummy.txt");
		
		System.out.println(dummy.isFile()); //false as file doesn't exist ++++++
		
		//--------------
		
		//isDirectory()
		
		//returns a boolean. True if isDirectory, false if not (or doesn't exist)
		
		System.out.println(myFile.isDirectory());
		System.out.println(myDir.isDirectory());
		
		
		//--------------
		
		//length()
		
		//returns size of file.
		
		System.out.println(myFile.length());
		System.out.println(myDir.length());
		
		//------------
		
		//lastModified()
		
		//returns the number of milliseconds since the first of (1/1/1970) (current epoch) the file or directory was last modified,
		//so the one modified most recently will be the one with the bigger number.
		
		System.out.println(myFile.lastModified());
		System.out.println(myDir.lastModified());
		
		
		//-------------
		
		//delete()
		
		//if its a directory the directory MUST be EMPTY in order to delete. 
		
		/*
		 * We will use delete in combination with mkdir
		 */
		
		File myDir2 = new File("C:/Users/rm20139/Documents/myJavaTest");
		
		//C:\Users\rm20139\Documents ++++++++++++++++++++++++++++++++++++++++path to system Documents 
		
		if(myDir2.exists()) {
			System.out.println("The directory already exists, so this command will delete the existing dir");
			
			/*
			 * IF your existing directory contains a file, the existing directory will NOT be deleted.
			 * (After creating directory, put a file in this directory, and you will see that it will not be deleted)
			 */
			myDir2.delete(); //if dir is deleted this returns true, else returns false.
		}
		
		myDir2.mkdir(); //this creates the directory. Returns a boolean.
		System.out.println(myDir2.exists()); //check if directory exists
		
		
		//----------
		
		//mkDir()
		
		myFile = new File("C:/Users/rm20139/Documents/myJavaTest/file1.txt");
		System.out.println(myFile.exists()); //check if file1 exists
		
		System.out.println(myFile.delete()); //delete file1
		
		
		//---------
		
		//mkDirs()
		
		//C:/Users/rm20139/Documents/great/entirely/mighty/filey.txt
		
		//this creates a full directory structure:
		
		File totalDir = new File("C:/Users/rm20139/Documents/great/entirely/mighty/filey");
		
		System.out.println(totalDir.mkdirs());
		
		
		//-----------------
		
		//make a file:
		
		File myFile4 = new File(totalDir, "myFile.txt");
		
		/*
		 * This is a command we use to create a new file. In this case a new text file called myFile.txt
		 * When you are doing anything with a file - creting a file, writing to a file, reading, deleting. you have to put it in a try/catch block. 
		 * The reason being that you may not have access to this file, as the file is outside of the control of java. 
		 */
		
		try {
			System.out.println(myFile4.createNewFile());
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
		
		System.out.println(myFile4.exists()); //check if myFile4 exists
		
		
		//-----------------
		
		//getParent()
		
		File parentFile = new File("C:/Users/rm20139/Documents/great/entirely/mighty/filey");
		System.out.println(parentFile.exists()); //check if parentFile exists
		
		//System.out.println(parentFile.getParent()); 
		
		
		//-----------------
		
		//list files
		
		//This generates an array of File objects, which are all the file objects contained within a particualr directory. 
		
		System.out.println("listFiles()");
		//for(File subFile: totalDir.listFiles());
		
		System.out.println(Arrays.asList(totalDir.listFiles())); //this will print off the full addresses for all files and folders
		
		for(File subFile: totalDir.listFiles()) {
			if(subFile.isFile()) //if file object is an actual file, print them all off
				System.out.println(subFile.getName());
		}
		
		//listing directories:
		
		for(File subFile: totalDir.listFiles()) {
			if(subFile.isDirectory()) //if file object is an actual file, print them all off
				System.out.println(subFile.getName());
		}
		
	}
}
