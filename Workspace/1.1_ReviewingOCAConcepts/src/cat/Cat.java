package cat;

public abstract class Cat { //public class HAS to have the same name as the file name
	
	
	/*
	 * we want the lion to clean itself, so we have 3 options for this:
	 * 
	 * Option 1: Not have a clean method in the abstract cat class, and have an independent clean method in the Lion class. 
	 * 
	 * Option 2: Have an abstract method Clean() in Cat class, which would mean we would have to have a clean method in the Lion class.
	 * 
	 * Option 3: Have a concrete method in the Cat class. IE: void clean(){ sysout("I am a Cat cleaning"); 
	 * 
	 */
	
	
	abstract void clean();
	
	/*
	void clean() {
		System.out.println("Cat cleaning");
	}
	*/
	
}


class Lion extends Cat{

	@Override
	void clean() {
		System.out.println("Lion cleaning");
	}
	
}


