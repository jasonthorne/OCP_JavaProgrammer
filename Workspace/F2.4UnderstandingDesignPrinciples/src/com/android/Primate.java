package com.android;

public class Primate {

}

class Howler extends Primate
{
	/*
	 * only howlers and subclasses of Howlers will have a tail, so Howlers and 
	 * sub classes of Howlers will have a HAS-A relationship with the myTail
	 * atribute
	 */
	boolean hasTail;
	private Tail myTail;
	
	Howler(boolean hasTail){
		if(hasTail)
			myTail=new Tail();
	}
}

class Tail{
	
}
/*
 * the myTail atribute of the Horse class is a HAS-A relationship as all
 * horses and subclasses of Horse will have a tail
 */
class Horse{
	private Tail myTail;
	//blank constructor
	Horse(){
		myTail=new Tail();
	}
	
	void checkTail() {
		System.out.println();
		if(myTail==null)
			System.out.println("no tail");
		else
			System.out.println("has a tail");
	}
}
/*
 * all sub classes of Horse also has a HAS-A relationship with the Tail class
 */
class Shetland extends Horse{
	
}
/*
 * every bird has feathers, so every bird will have an array of feathers
 */
class Feather{
	
}
/*
 * a bird HAS feathers, in this case an array of thousands of feathers, again this
 * is a HAS-A relationship
 */
class Bird{
	//this is our array of feathers, which holds all the feathers of the bird
	private Feather[]feathers;
	
	//Bird class constructor
	Bird(){
		//this sets the amount of feathers, its between 1 and 100,000
		int numFeathers=(int)Math.random()*100_000;
		System.out.println("this bird has "+numFeathers+" feathers");
		//this creates an array of the amount of feathers we have got from
		//the above calculation (a number between 0 and 100,000 feathers
		feathers=new Feather[numFeathers];
	}
	
}
