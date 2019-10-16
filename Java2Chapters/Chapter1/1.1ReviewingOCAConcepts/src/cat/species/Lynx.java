package cat.species;

import cat.BigCat;
/*
 * we now only have access to the public and protected members of the BigCat class
 */
public class Lynx extends BigCat{
	
	
	void access() {
		/*
		 * can access public members
		 */
		System.out.println("name is "+name);
		/*
		 * can access protected members
		 */
		System.out.println("has this cat fur "+hasFur);
	}

}
