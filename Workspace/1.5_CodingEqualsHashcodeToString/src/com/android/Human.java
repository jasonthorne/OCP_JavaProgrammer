package com.android;

import java.time.LocalDate;

public class Human {
	
	int id;
	String name; 
	
	Human(int age, String name){
		this.id = id;
		this.name = name;
	}
	
	Human(){
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Human))
			return false;
		Human other = (Human) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	

}


class Employee extends Human{
	
	double weight;
	LocalDate dob;
	
	enum Occupation{
		DOCTOR, NURSE, SURGEON, CONSULTANT, ORDERLY
	}
	
	Occupation occupation; //enum obj
	
	Employee(int id, String name, double weight, Occupation occupation){
		super(id, name);
		this.weight = weight;
		dob = LocalDate.now().minusYears(30);
		this.occupation = occupation;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode(); 	//this produces a hashcode from the id and name
		
		result = prime*result + ((dob==null)?0:dob.hashCode());
		result = prime*result+ ((occupation==null)?0:occupation.hashCode());
		
		long temp;
		temp = Double.doubleToLongBits(weight); //convert a double to long
		result=prime*result+(int)(temp^(temp >>> 32));
		
		return result;
	}
	
	/*
	 * Equals method for employee class:
	 */
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) //if the same obj
			return true;
		if(getClass()!=obj.getClass()) //if NOT the same class
			return false; 
		Employee other = (Employee)obj;
		
		/*
		if(this.hashCode()!= other.hashCode()) //this checks that ALL vars are the same (as the same hashcodes are produced)
			return false;
		return true;
		*/
		
		return this.hashCode() == other.hashCode();
	}
	
	

}






