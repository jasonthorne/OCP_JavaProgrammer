package cat;

public class BigCat extends Cat{
	//available to all other classes
	public String  name="Cat";
	//available to same package and derived classes
	protected boolean hasFur=true;
	//available only in the same package
	boolean hasPaws=true;
	//Available only in same class
	private int id;

}
