
public class Duck implements Comparable<Duck> {
	
	String name;
	
	Duck(String name){
		this.name = name;
	}

	@Override
	public int compareTo(Duck d) {
		/*
		 * This is using the compareTo method of the string class to organise the ducks by name alphabetically
		 */
		return name.compareTo(d.name);
	}

	

}
