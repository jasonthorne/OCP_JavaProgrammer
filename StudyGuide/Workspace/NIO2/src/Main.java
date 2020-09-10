import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		
		//===============================================================================
		/**creating paths:*/
		
		/**first use of Paths.get()*/
		
		// With an absolute path in windows
		Path pathWin = Paths.get("c:\\temp\\file.txt");
		// With an absolute path in unix
		Path pathUnix = Paths.get("/temp/file.txt");
		// With a relative path
		Path pathRelative = Paths.get("file.txt");
		//Using the varargs parameter
		// (the separator is inserted automatically)
		Path pathByParts = Paths.get("c:", "temp", "file.txt");
		
		/**second use of Paths.get() */
		//With the second version, you have to use a java.net.URI instance. Since we're working with files, the URI schema must be file://:
		//Notice the three slashes. file:/// represents an absolute path (the file:// schema plus another slash for the root directory). 
		
		try {
		    Path fileURI1 = Paths.get(new URI("file:///c:/temp/file.txt"));
		} catch (URISyntaxException e) {
		    //This checked exception is thrown by the URI constructor
		}
		
		/*If you don't want to catch URISyntaxException, you can use the static method URI.create(String). 
		 * It wraps the URISyntaxException exception in an IllegalArgumentException (a subclass of RuntimeException):
		 */
		
		Path fileURI2 = Paths.get(URI.create("file:///file.txt"));
		System.out.println(fileURI2.toAbsolutePath());
		
		//================================================================================
		/** Getting path info */
		System.out.println("\nGetting path info:");
			
		Path path = Paths.get("C:\\temp\\dir1\\file.txt"); //0 based: temp=0,dir1=1,file.txt=2
		// Or Path path = Paths.get("/temp/dir1/file.txt");
		System.out.println("toString(): " + path.toString());
		System.out.println("getFileName(): " + path.getFileName());
		System.out.println("getNameCount(): " +path.getNameCount());
		// Indexes start from zero 
		System.out.println("getName(0): " + path.getName(0));
		System.out.println("getName(1): " + path.getName(1));
		System.out.println("getName(2): " + path.getName(2));
		// subpath(beginIndex, endIndex) from beginIndex to endIndex-1
		System.out.println("subpath(0,2): " + path.subpath(0,2));
		System.out.println("getParent(): " + path.getParent());
		System.out.println("getRoot(): " + path.getRoot());

	}

}
