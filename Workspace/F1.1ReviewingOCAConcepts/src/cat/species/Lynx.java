package cat.species;

import cat.BigCat;
/*
 * we can only access public and protected members of the 
 * BigCat class
 */
public class Lynx extends BigCat{
	
	void access() {
		/*
		 * can access public members of the BigCat class
		 */
		System.out.println("name is "+name);
		/*
		 * can access protected members
		 */
		System.out.println("hasFur is "+hasFur);
		/*
		 * cannot access package level access members in a different
		 * package
		 */
	//	System.out.println(hasPaws);
		/*
		 * id is a private variable, cannot access private members
		 * outside of this class
		 */
		//System.out.println(id);
		
		
		
		
	}
}
