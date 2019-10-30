package com.android;

import java.time.LocalDate;

public class Human {
	int age;
	String name;
	
	Human(int age,String name){
		this.age=age;
		this.name=name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Human other = (Human) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	Human(){
		
	}

}

class Employee extends Human{
	double weight;
	LocalDate dob;
	enum Occupation{
		Doctor,Nurse,Surgeon,Orderly
	}
	Occupation occupation;
	Employee(int age,String name,double weight,Occupation occupation){
		super(age,name);
		this.weight=weight;
		dob=LocalDate.now().minusYears(30);
		this.occupation=occupation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		//calls the hashCode of the Human class which depends on the age and name
		int result = super.hashCode();
		//LocalDate has a hashCode method, and dob is a localDAte
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		//enums produce a different hashCode for each of the members of the enum
		result = prime * result + ((occupation == null) ? 0 : occupation.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		/*
		 * see bitwise method in examples class
		 */
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		/*
		 * this will check the if same object and check the age and name
		 * so if not the same age and name they can't be equal
		 */
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} 
		/*
		 * this can be used to replace all the commented out code below
		 */
		if(this.hashCode()!=other.hashCode())
			return false;
		/*else if (!dob.equals(other.dob))
			return false;
		if (occupation != other.occupation)
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;*/
		return true;
	}
	
	
}
