package com.android;

public class Crow implements Comparable<Crow>{
	int id;
	
	Crow(int id){
		this.id=id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Crow other = (Crow) obj;
		if (id != other.id)
			return false;
		return true;
	}
//-placed at start
	//+placed at end of list
	@Override
	public int compareTo(Crow c) {
		if(this==c)
			return 0;
		if(this.equals(c))
			return 0;
		//subclasses of Crow will be placed at the start of the list
	//	if(getClass()!=c.getClass())
	//		return -1;
		return id-c.id;

	}
	
	public String toString() {
		return "crow id is "+id;
	}
	

}

class JackDaw extends Crow{

	JackDaw(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
}
