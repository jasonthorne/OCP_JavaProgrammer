package com.android;

public class Primate {
	

}

class Howler extends Primate{
	boolean hasTail;
	private Tail myTail;
	
	/*
	 * Only Howlers and subclasses of Howlers will have a HAS-A relationship with myTail attribute.
	 */
	Howler(boolean hasTail){
		if(hasTail)
			myTail=new Tail();
	}
}


class Tail{
	
}


/*
 * the myTail attribute of a hiorse class is a HAS-A relationship. As aLL horses and subclasses of horse will have a tail. 
 */
class Horse{
	private Tail myTail;
	
	Horse(){
		myTail = new Tail();
	}
	
	
	
	void checkTail() {
		System.out.println();
		if(myTail==null)
				System.out.println("no tail");
			else
				System.out.println("tail");
	}
}


/*
All subclasses of Horse also has a HAS-A relationship with the Tail class.
*/
class Shetland extends Horse{
	
}


//Every bird has feathers, so every bird will have an array of feathers.
class Feather{
	
}


/*
 * A bird HAS feathers. In this case an array of thousands of feathers. Again this is a HAS-A relationship.
 */
class Bird{
	private Feather[] feathers; //array of feathers
	
	//Bird class constructor
	Bird(){
		//this sets the ammount of feathers. It's between 1 and 100,000
		
		int numFeathers = (int) Math.random()*100;
		System.out.println("THis bird has " + numFeathers + " feathers");
		feathers=new Feather[numFeathers]; //creates an array of the amount of feathers we have got from the above calculation (a num between 0 and 100,000)
	}
}











