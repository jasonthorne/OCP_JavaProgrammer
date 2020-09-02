import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

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
		
		/////Main.test();
		
		
	}//main

	private static int getData() {
		return -1;
	}
	
	/*
	public static class Product{ 
		
		int id; int price;
		public Product(int id, int price){ 
			this.id = id;
			this.price = price;
		}
		
		public String toString() { return id + ":" + price; }
	}
		
	static void test(){
	
		List<Product> products = Arrays.asList(new Product (1, 10), new Product (2, 30),
		new Product (2, 30));
		Product p = products.stream().reduce(new Product (4, 0), (p1,
		p2) -> {
			p1.price+=p2.price;
			return new Product (p1.id,p1.price);
			}); 
		
		products.add(p); ////////////////this is error. Cant add to an arrays.aslist!! 
		products.stream().parallel().reduce((p1, p2) -> p1.price > p2.price ? p1 : p2)
		.ifPresent(System.out::println);
	}
	*/



}
