package com.android;


/*
 * This is our own checked exception class.
 * which means when we create an object from this class, we have to put that in a try/catch block.
 * This exception class will have 3 constructors, which will mean that this exception can provide 3 different functions.
 */

public class CannotSwimException extends Exception{
	
	//no arg constructor:
	public CannotSwimException() {
		super(); //calling constructor in the exception class thst takes no args
		System.out.println("CannotSwimException constructor that takes no args");
	}
	
	//a constructor that takes an exception as an arg:
	public CannotSwimException(Exception e) {
		super(e); //calling constructor in exceptionclass that takes an exception
		System.out.println("CannotSwimException constructor that takes an exception as an arg");
	}
	
	
	//a constructor that takes a string as an arg:
	public CannotSwimException(String message) {
		super(message); //calling constructor in exceptionclass that takes a string
		System.out.println("CannotSwimException constructor that takes a string as an arg");
	}
	

}

/*
 * This is creating our own runtime exception:
*/
class DangerInTheWater extends RuntimeException{
	
}

/*
 * This is a subclass of our checked exception "CannotSwimException", so this is also a checkException
 */
class DrowningException extends Exception{
	
}

/*
 * This is a subclass of our runtimeException "DangerInTheWater", so this is also a runtimeException.
 */
class SharkInTheWater extends DangerInTheWater{
	
}


class Animal {
	void swim() throws CannotSwimException{
		System.out.println("this type of animal can swim "); 
	}
	
	
	
}

class Person extends Animal{
	
	/*
	 * This method has to be in a try/catch, or whatevr'd calling this has to "throws CannotSwimException"
	 */
	void swim() throws CannotSwimException{
		System.out.println("help, I cant swim");
		throw new CannotSwimException();
	}
	

}







