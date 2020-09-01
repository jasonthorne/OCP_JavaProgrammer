import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) {
		
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
		
		/**==================== FileInputStream ================*/
		//reads bytes from a file. It inherits from InputStream.
		
		/*
		It can be created either with a File object or a String path:
		
		FileInputStream(File file);
		FileInputStream(String path);
		*/
		
		//Here's how you use it:
		try (InputStream in = new FileInputStream("testFile1.txt")) {
		    int b;
		    // -1 indicates the end of the file 
		    while((b = in.read()) != -1) {
		        // Do something with the byte read
		    	//System.out.println("byte: " + b);
		    }
		} catch(IOException e) { System.out.println(e); }
		
		
		//There's also a read() method that reads bytes into an array of bytes:

		try (InputStream in = new FileInputStream("testFile1.txt")) {
			byte[] data = new byte[1024];
			int numberOfBytesRead;
			while((numberOfBytesRead = in.read(data)) != -1) {
			    // Do something with the array data
				System.out.println(new String(data, "UTF-8")); //convert bytes to string using UTF-8 encoding
			}
		} catch(IOException e) { System.out.println(e); }
	
	
	
	
	}
	
	

}
