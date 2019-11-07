package cat;

public abstract class Cat {
	/*
	 * we want the lion to clean itself, so we have 3 options for
	 * this.
	 * Option 1 not have a clean method in the abstract Cat class
	 * and have an independant clean method in the Lion class
	 * Option 2
	 * have an abstract method clean in the Cat class, which
	 * would mean we would HAVE to have a clean() method in the Lion
	 * Option 3
	 * have a concrete method in the Cat class 
	 * i.e
	 * void clean(){
	 * 		System.out.println("I am a Cat cleaning myself");
	 * }
	 */
	abstract void clean();

/*	void clean() {
		System.out.println("I am a member of the cat family cleaning");
	}*/
}

class Lion extends Cat{

	@Override
	void clean() {
		// TODO Auto-generated method stub
		
	}
	/*	void clean() {
			System.out.println("I am a clean lion");
		}*/
}
