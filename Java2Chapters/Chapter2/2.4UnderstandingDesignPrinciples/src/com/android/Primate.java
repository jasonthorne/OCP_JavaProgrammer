package com.android;

public class Primate {
	private Tail myTail;
	boolean hasTail;
	
	Primate(boolean hasTail){
		if(hasTail)
			myTail=new Tail();
	}

}
/*
 * Chimps do NOT have talis, so this fails the "HAS-A" reltionship, so the underlying data model is incorrect.
 * so what we do this is to have a boolean called "hasTail", if true assign a tail to the object of the class
 * however this model is still not a true "HAS A "relationship
 * 
 */
class Chimp extends Primate{
	
	Chimp(boolean hasTail){
		super(hasTail);
	}
	
}

class Tail{
	
}
/*
 * this is a proper HAS-A all horses and subclasses of Horse will have a tail
 */
class Horse{
	private Tail myTail;
	
	Horse(){
		myTail=new Tail();
		checkTail();
	}
	
	void checkTail(){
		System.out.println(this.getClass().getSimpleName());
		if(myTail==null)
			System.out.println("no tail");
		else
			System.out.println("has a tail");
	}
}

class Shetland extends Horse{
	
}
/*
 * a bird has feathers, in this case an array of many thousands of feathers, this is a HAS-A relationship
 */
class Bird{
	protected Feathers[]feathers;
	
	Bird(){
		int numFeathers=(int)(Math.random()*100_000);
		System.out.println("this bird has "+numFeathers+" feathers");
		/*
		 * creates an array of feathers between 0 and 100,00
		 */
		feathers=new Feathers[numFeathers];
	}
}

class Feathers{
	
}
