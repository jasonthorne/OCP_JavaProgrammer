package cat.species;

import cat.BigCat; //allows access to the public & protected stuff from this imported class, as class is in another package. ++++++++++++++ 

public class Lynx extends BigCat{
	
	void access() {
		
		 //This method can access public members of the BigCat class:
		 
		System.out.println("name is: " + name);
		
		
		//This method can access protected membersof the BigCat class:
		System.out.println("'hasFur' is: " + hasFur);
		
		//Cannot access package level members in a different package:
		//System.out.println(hasPaws);
		
		//Cannot access private level members in a different package:
		//System.out.println(id);
		
	}

}
