package com.android;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Serialization is the process of converting an object to a stored data format(in other words
 * converting an object to a file)
 * A object that you want to serialize, its class has to implement the Serializable interface.
 * if we do not make the objects class serializable this will throw a NotSerializableException, if
 * we do NOT WANT the object to be serializable, we mark the object as TRANSIENT
 * static object are skipped by the serializable process, as statics do not belong to any individual
 * object but to a class
 * 
 * 
 * @author noelf
 *
 */
public class Examples {
	
	static void ex1() {
		/*
		 * the Human class implements serializable, which means we can save any Human as a file
		 */
		Human myHuman=new Human(45,"harry",23.4);
		//System.out.println(myHuman);
		/*
		 * we will save our created human as the file "output.data"
		 */
		File myFile=new File("output.data");
	//	File myFile2=new File("input.data");
		
		try {
			System.out.println("create files");
			if(!myFile.exists())
				myFile.createNewFile();
		/*	if(!myFile2.exists())
				myFile2.createNewFile();*/
			//this is for reading individual bytes of the object
			System.out.println("Serialization ");
			FileOutputStream fileOut=new FileOutputStream(myFile);//produces bytes
			ObjectOutputStream out=new ObjectOutputStream(fileOut);//produces objects
			/*
			 * this is what saves the object to the file "output.data", only objects whose class
			 * implement the serializable interface can as a argument of writeObject()
			 * this creates the serializable
			 * output.data is the Human object myHuman
			 * this creates a copy of myHuman, so it's NOT the same human when you deserialize it
			 */
			out.writeObject(myHuman);
			fileOut.close();
			out.close();
			System.out.println("print me");
			/*
			myHuman.age=100;
			myHuman.name="harriet";
			myHuman.weight=1000;*/
			System.out.println("Deserialization");
			//this reads the bytes from an exising serialized file
			FileInputStream fileIn=new FileInputStream("output.data");//low level
			//this organises the bytes into the object
			ObjectInputStream in=new ObjectInputStream(fileIn);//higher level
			/*
			 * harry and myHuman are different objects
			 * readObject() always returns an object, this is a Object reference to a Human object
			 * this is creating a new Human object that will be a copy for myHuman, EXCEPT it has a null
			 * for a Dog, as spot the dog has being marked as being transient so will be ignored by the
			 * serialization process
			 */
			Human harry=(Human)in.readObject();
		//	Human harriet=(Human)in.readObject();
			/*
			 * harry and myHuman, even if they have all the same variables, are DIFFERENT objects
			 * becuase we you deserialize you are creating a new Human object from the serialized file
			 * "output.data" 
			 */
			System.out.println(harry.equals(myHuman));//the serialized object
			System.out.println(myHuman);
			System.out.println(harry);
		//	Arrays.asList(23,56,89).stream()
	/*		List<Human>humans=Stream.generate(()->{
				try {
					Human sally=(Human)in.readObject();
					return sally;
				}
				catch(Exception e) {
					System.out.println(e);
					return  null;
				}
				
				}).limit(50).
					collect(Collectors.toList());
			System.out.println("there are "+humans.size()+"  humans in the list");
			
			*/
			
		}
		catch(Exception e) {
			
		}
	}

}
