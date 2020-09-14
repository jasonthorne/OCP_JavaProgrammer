import java.io.BufferedReader;
import java.io.Closeable;
import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.StandardSocketOptions;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Properties;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import sun.awt.AWTAccessor.SystemColorAccessor;


public class Main {
	
	public static void main(String[] args) throws Exception {//FileNotFoundException, IOException {
		
		/*
		  4 ABSTRACT classes that are the parents of all other classes:
		 
		 first 2 deal with BYTE streams:
		 + InputStream
		 + OutputStream
		  
		 other two deal with CHARACTER streams:
		 + Reader
		 + Writer
		 
		 So, classes that have "stream" in their name deal with streams of BYTES
		 and classes that have "reader" or "writer" in their name, read or write streams of CHARACTERS.
		 
		 */
		
		/**==================== FileInputStream (reads bytes) ================*/
		//reads bytes from a file. It inherits from InputStream.
		
		/*
		It can be created either with a File object or a String path:
		
		FileInputStream(File file);
		FileInputStream(String path);
		*/
		
		//Here's how you use it:
		
		try (InputStream in = new FileInputStream("file1.txt")) {
		    int b;
		    // -1 indicates the end of the file 
		    while((b = in.read()) != -1) {
		        // Do something with the byte read
		    	//System.out.println("byte: " + b);
		    }
		} catch(IOException e) { System.out.println(e); }
			
		
		//There's also a read() method that reads bytes into an array of bytes:

		try (InputStream in = new FileInputStream("file1.txt")) {
			byte[] data = new byte[1024];
			int numberOfBytesRead;
			while((numberOfBytesRead = in.read(data)) != -1) {
			    // Do something with the array data
				System.out.println(new String(data, "UTF-8")); //convert bytes to string using UTF-8 encoding
			}
		} catch(IOException e) { System.out.println(e); }
	
	
		/**==================== FileOutputStream (writes bytes)================*/
		//FileOutputStream writes bytes to a file. It inherits from OutputStream.
		
		
		/*
		It can be created either with a File object or a String path 
		and an optional boolean that indicates whether you want to overwrite or append to the file if it exists 
		(it's overwritten by default):

		FileOutputStream(File file)
		FileOutputStream(File file, boolean append)
		FileOutputStream(String path)
		FileOutputStream(String path, boolean append)
		*/
		
		//Here's how you use it:
		try (OutputStream out = new FileOutputStream("file2.txt")) {
		    int b;
		    // Made up method to get some data
		    while((b = getData()) != -1) {
		        // Writes b to the file output stream
		        out.write(b);
		        out.flush();
		    }
		} catch(IOException e) { System.out.println(e); }
		
		/*
		When you write to an OutputStream, the data may get cached internally in memory and written to disk at a later time. 
		If you want to make sure that all data is written to disk without having to close the OutputStream, 
		you can call the flush() method every once in a while.

		FileOutputStream also contains overloaded versions of write() that allow you to write data contained in a byte array.*/
	
		
		/**==================== FileReader (reads characters)================*/
		
		/*
		 FileReader reads characters from a text file. It inherits from Reader.
		 It can be created either with a File object or a String path:

		FileReader(File file)
		FileReader(String path)
		 */
		
		try (Reader r = new FileReader("file1.txt")) {
		    int c;
		    // -1 indicates the end of the file
		    while((c = r.read()) != -1) { 
		        char character = (char)c;
		        System.out.print(character);
		    }
		    System.out.println();
		} catch(IOException e) { /** ... */ }
		
		
		//There's also a read() method that reads characters into an array of chars:
		
		try (Reader r = new FileReader("file1.txt")) {
			char[] data = new char[1024];
			int numberOfCharsRead;	//r.read(data);
			while((numberOfCharsRead = r.read(data)) != -1) {
				// Do something with the array data
				System.out.println(data);
			}
		} catch(IOException e) { /** ... */ }
		
	    /*FileReader assumes that you want to decode the characters in the file 
		using the default character encoding of the machine your program is running on.*/
		
		
		/**==================== FileWriter (writes characters)================*/
		
		
		
		
		
		
		
		
		
		/**==================== ObjectOutputStream ================*/
		
		try( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serializedTestObj.dat"))) {
			TestObj testObj = new TestObj("TestObj text");
		    oos.writeObject(testObj);
		} catch(IOException e) { e.printStackTrace();}
		
		/**==================== ObjectInputStream ================*/
			
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serializedTestObj.dat"))) {
			TestObj testObj = null;
		    Object obj = ois.readObject();
		    if(obj instanceof TestObj) {
		    	testObj = (TestObj)obj;
		    	System.out.println(testObj);
		    }
		} catch(IOException ioe) { /** ... */ }
		catch(ClassNotFoundException cnfe) { //for obj cast. 
		   /** ... */
		}
		
		/*Two important notes: 
		 * When deserializing an object, the constructor, and any initialization block are not executed, 
		 * Second, null objects are not serialized/deserialized.
		 */
		
		/**==================== PrintWriter ================*/
		
		
		try(PrintWriter pw = new PrintWriter("printWriterFile.txt")) {
		    pw.write("Hi"); // Writing a String
		    pw.write(100); // Writing a character

		    // write the string representation of the argument
		    // it has versions for all primitives, char[], String, and Object
		    pw.print(true);
		    pw.print(10);

		    // same as print() but it also writes a line break as defined by
		    // System.getProperty("line.separator") after the value
		    pw.println(); // Just writes a new line
		    pw.println("A new line...");

		    // format() and printf() are the same methods
		    // They write a formatted string using a format string,
		    // its arguments and an optional Locale
		    pw.format("%s %d", "Formatted string ", 1);
		    pw.printf("%s %d", "Formatted string ", 2);
		    pw.format(Locale.GERMAN, "%.2f", 3.1416);
		    pw.printf(Locale.GERMAN, "%.3f", 3.1416);
		} catch(FileNotFoundException e) { 
		    // if the file cannot be opened or created
			e.printStackTrace();
		} 
		
		//=============
		
		
	}//=============MAIN
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	private static int getData() { 	return -1; }
}

//-------------------------------

//------------------------------------

class TestObj implements java.io.Serializable {
	String name;
	TestObj(String name){ this.name=name; }
	@Override
	public String toString() { return name; }
}





















