package cat;

public abstract class Cat {
	/*
	 * this class has go 3 options with regard to the clean() method in the Lion class
	 * option 1
	 * not have a clean method in this class, then the lion class will have it's own independent clean() method
	 * option 2
	 * have an abstract method clean
	 * abstract void clean();
	 * which would mean we would HAVE to have a clean() method in the Lion class
	 * option 3
	 *have a concrete method
	 *clean(){
	 *	System.out.println("I am a clean cat");
	 *}
	 *that we can choose to override in the Lion class or not
	 */
	

}

class Lion extends Cat{
	
	void clean() {
		System.out.println("I am a clean lion");
	}
	
}
