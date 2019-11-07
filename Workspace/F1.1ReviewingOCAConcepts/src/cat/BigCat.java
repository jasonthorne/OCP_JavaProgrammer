package cat;

public class BigCat {
	//available to all other classes
	public String name="tibbles";
	//available to same package and derived classes
	protected boolean hasFur=true;
	//default, package level access available in same package
	boolean hasPaws=true;
	//available only in same class
	private int id;

}
