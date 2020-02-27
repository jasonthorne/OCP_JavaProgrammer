
public class Animal{ // implements Comparable {
	
	String type;
	static int counter;
	
	Animal(String type){
		this.type = type;
		counter++;
	}

	@Override
	public String toString() {
		return "Animal [type=" + type + ". counter=" + counter + "]";
	}


	/*
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	*/
	
	


}
