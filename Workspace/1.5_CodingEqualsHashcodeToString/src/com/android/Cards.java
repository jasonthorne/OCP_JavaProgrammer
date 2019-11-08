package com.android;

public class Cards {
	
	private String rank; //king, queen...
	private String suit; //diamonds, club...
	
	Cards(){
		
	}
	
	//==================
	
	public Cards(String rank, String suit) { //this constructor FORCES the programmer to give a value to both rank and suit.
		
		
		/*
		 * Without A constructor with this check, you could create cards by going: Cards cards = new Cards(null, null);
		 * this forces the programmer to give a value to both rank and suit. 
		 * 
		 * OR we could put a check in the equals method to ensure if one of the strings are null it will return false. 
		 */
		
		
		if(rank == null|| suit == null)
				throw new IllegalArgumentException();
		this.rank=rank;
		this.suit=suit;
	}
	
	@Override
	public int hashCode() {
		
		/*
		 * 31 is a prime number, meaning only divisible by itself or 1. 
		 * Also, this number is final, so cannot be changed. 
		 */
		final int prime = 31;
		int result = 1; 
		
		/*
		 * result = 31*1 + 0(if rank is null) else rank.hashcode which calls the String implementation of the hashcode method.
		 * So for example we will say: 31*1+20=51
		 */
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Cards))
			return false;
		Cards other = (Cards) obj;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		if (suit == null) {
			if (other.suit != null)
				return false;
		} else if (!suit.equals(other.suit))
			return false;
		return true;
	}
	
	

}
