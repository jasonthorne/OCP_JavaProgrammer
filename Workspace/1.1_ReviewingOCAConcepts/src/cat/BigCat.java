package cat;

public class BigCat {
	
	//access modifiers:
	
	public String name = "tibbles"; //PUBLIC - available to all other classes. 
	
	protected boolean hasFur = true; //PROTECTED - available to classes in the saME package and child classes in other packages.
	
	boolean hasPaws = true; // DEFAULT - package level access. 
	
	private int id; //PRIVATE - available ONLY in the same class.

}
