package com.android;
/*
 * an interface can also use generics, whatever implements provides types for T and V, if no types are given to T and V, they
 * will be give the OBJECT data type
 */
public interface Manners<T,V> {
	void thankYou(T t);
	void sorry(T t,V v);

}


/*
 * when generic types are used in the methods of the interface, you have to provide a type when you are implementing the
 * interface
 */
class Ape implements Manners<Elephant,String>{

	@Override
	public void thankYou(Elephant t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sorry(Elephant t, String v) {
		// TODO Auto-generated method stub
		
	}		
}
/*
 * the monkey class will be created with a generic type V and the interface will be implemented using a Animal
 */
class Monkey<V>implements Manners<Animal,V>{

	@Override
	public void thankYou(Animal t) {
		System.out.println("Monkey thankYour method");
		System.out.println("type t is "+t.getClass().getSimpleName());
		
	}

	@Override
	public void sorry(Animal t, V v) {
		System.out.println("Monkye sorry method ");
		System.out.println("type v is "+v.getClass().getSimpleName());
		
	}
	
}
/*
 * if we do not provide data types for T and V, they will default to object
 */
class Gorilla implements Manners{

	

	@Override
	public void thankYou(Object t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sorry(Object t, Object v) {
		// TODO Auto-generated method stub
		
	}
	
}
