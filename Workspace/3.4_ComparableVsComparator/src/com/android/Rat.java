package com.android;

public class Rat implements Comparable<Rat>{ //add the TYPE that the compareTO method will use (Rat in this case)
	
	/*
	 * If you are going to implement the comparable interface and have a compareTo method, 
	 * you should always override the equals() and the hashcode method. 
	 */
	
	/*
	 * If we wanted to have all rats to be unique, I would put in some unique identifier, 
	 * such as an ID. which would be different for every rat.
	 */
	
	String name;
	
	/*
	 * We are using wrappers instead of primitives so we can use the compareTo methods of the Integer and Double class. 
	 * You could also use primitives here, but when using comapreTo we would have to use them in conjunction with wrappers. 
	 */
	Integer age;
	Double weight;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Rat))
			return false;
		Rat other = (Rat) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
	
	//COMPARE TO METHOD ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//A rat will be calling this mwthod, and sending another rat to it:
	//Arranged by name, then age, then weight. 
	@Override
	public int compareTo(Rat r) {
		//If same Rat or all have same name, age and weight, will return 0:
		//clones, which are different rats but with the same values will not be added.
		if(this.equals(r)) //calling the equals method of the Rat class (above) Returns true if same rat, or if 2 rats have the same name, age and weight.
			return 0;
		//IF NOT THE SAME RAT (by name age and weight as defined above):
		
		//if the name of the first rat is not the same as the second rat. 
		//We can use the string compareTo method to see the order of the strings and use this to order by the name of the Rat. 
		if(!(name.equals(r.name))) //if different names
			return name.compareTo(r.name); //difference inorder by name
		
		if(!(age.equals(r.age))) //if different ages
			return age.compareTo(r.age);  //difference inorder by age
		
		//return the comparrison of weight as thats the last possible difference between them.
		return weight.compareTo(r.weight);
	}
	
	

}


