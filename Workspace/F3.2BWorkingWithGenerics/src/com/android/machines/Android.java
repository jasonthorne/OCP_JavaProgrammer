package com.android.machines;

import com.android.animals.Animal;
import com.android.animals.Elephant;
import com.android.interfaces.Behaviour;
import com.android.interfaces.Manners;

/*
 * this is a class that has two generic types
 * T will be a Animal or one of its subclasses of Elephant, Zebra, Cow
 * V will be either a Whale or a Lemur
 */
public class Android<T extends Animal, V extends Behaviour> {
	
	public Android() {
		
	}
	
	public T walk(V myV) {
		System.out.println("walk method called");
		myV.happy();
		myV.sad();
		myV.mad();
		return (T) new Animal();
	}
	/*
	 * this generic type ONLY applies to this method
	 * this can take ANY OBJECT, this is effectively an object reference
	 */
	public<S> void talk(S myS){
		System.out.println("android talking");
		System.out.println("myS is a "+myS.getClass().getSimpleName());
	}
	/*
	 * java can't tell the difference between this method and the above method, as both
	 * can take ANY OBJECT
	 */
//	public void talk(Object myObj) {
	//	return null;
//	}
	/*
	 * can use generic types of a class within an instance method
	 */
	public void method1(T myT,V myV) {
		
	}
	/*
	 * can't use generic types of a class with a static method as you can call 
	 * statics without creating a member of the class and generic types are only 
	 * assigned when you create an object of the class
	 */
/*	static void method2(T myT) {//will NOT COMPILE FOR ABOVE REASONS
		
	}*/
	
	public static<S extends Animal,V extends Behaviour,U extends Manners>void method2
	(S myS,V myV,U myU){
		System.out.println("myS is "+myS.getClass().getSimpleName());
		myS.eat();
		myS.sleep();
		myS.stampede();
		/*
		 * can't do thsi as myS could be a sub class of Animal and you can't have a 
		 * sub class reference to a super class object
		 */
		//myS=new Animal();//will not compile
		
		myS=(S)new Animal();
		System.out.println("after casting");
		myS.eat();
		myS.sleep();
		System.out.println(myS.getClass().getSimpleName());
		myS=(S)new Elephant();
		
	}

}
