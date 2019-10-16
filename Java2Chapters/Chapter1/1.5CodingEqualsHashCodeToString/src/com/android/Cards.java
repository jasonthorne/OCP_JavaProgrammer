package com.android;

public class Cards {
	private String rank;
	private String suit;
	/*
	 * with this constructor you could create a Cards object by the following
	 * Cars newCards=new Cards(null,null)
	 * we could put a check in the equals method to ensure that if one of the strings are null it will
	 * always return false, alternatively we could put a check in the constructor that if we create a Cards object
	 * with a null string like above, then it will throw an illegalargument exception and will force the coder
	 * to change the code, so this is more a check for the coder than for the finished code
	 */
	public Cards(String rank,String suit) {
		if(rank==null||suit==null)
			throw new IllegalArgumentException();
		this.rank=rank;
		this.suit=suit;
	}
	/*
	 * hashCode is a method of the object class that returns a number that will be used to identify a object,
	 * it returns a number here based on the two string variables of rank and suit. Again this hashCode can 
	 * be modified in any number of ways to generate this number. Generating hashes is a whole area of computer 
	 * science that concerns such fields as encryption.
	 * towards the end of the course we will show an example of advanced hashing where we show a method for 
	 * storing usernames and a HASH of the password, so the password is NEVER stored in a database, but a number
	 * that has been produced by a more complex version of what we see below
	 */
	@Override
	public int hashCode() {
		System.out.println("calling cards hashCode");
		/*
		 * 31 is a prime number, meaning it is only divisible by itself or one, this number cannot be changed
		 */
		final int prime=31;
		int result=1;
		/*
		 * result=31+1+(if rank is null then 0 else rank.hashCode which calls the String implementation of the
		 * hashCode
		 */
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}
	
	/*
	 * we have taken care of the null issue with the constructor
	 */
	
	@Override
	public boolean equals(Object obj) {
		/*
		 * if not instance of cards return false
		 */
		if(!(obj instanceof Cards))
			return false;
		/*
		 * if it is a instance of cards class but it is a Object reference so this changes this object to be
		 * a Cards reference
		 */
		Cards myCards=(Cards)obj;
		/*
		 * if the same object return true
		 */
		if(this==myCards)
			return true;
		/*
		 * this uses the hashCode from the String class to determine if both objects have equal values
		 * 
		 */
		//return rank.equals(myCards.rank)&&suit.equals(myCards.suit);
		//or alternative we can use the hashCode method of this class 
		return this.hashCode()==obj.hashCode();
		//return true;
	}

}
