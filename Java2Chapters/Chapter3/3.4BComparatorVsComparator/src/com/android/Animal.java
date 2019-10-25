package com.android;

public class Animal implements Comparable<Animal>{
	
	public int id;
	Animal(int id){
		this.id=id;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + "]";
	}

	@Override
	public int compareTo(Animal a) {
		if(this==a)
			return 0;
		/*
		 * if same return 0
		 * i.e 4-4=0.
		 * if calling object is greater than object sent to method, return number greater than 0
		 * i.e 4-3=1, put calling object last
		 * if calling object is smaller than sent, return number less than 0
		 * i.e 3-4=-1, put calling object first
		 */
		//this will sort in ascending order
		if(a.getClass().getSimpleName().equals("Animal"))
			return id-a.id;
		//if mammal will sort in descending order, if we mix and match we get mad results
		return a.id-id;
	}

}

class Mammal extends Animal{

	Mammal(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
}
