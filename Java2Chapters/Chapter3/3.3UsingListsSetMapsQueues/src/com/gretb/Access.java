package com.gretb;
//import just this static
//import static com.android.TestStat.myInt;
//import all statics of the TestStat class
//import static com.android.TestStat.*;
//can't import just statics of a package
//import static com.android.*;
//can access statics and non statics but can ONLY access statics in a static way (className.staticMember)
import com.android.*;
//by using a static import we can acess the statics of this class directly (do not need to have className.staticMember)
import static com.android.TestStat.*;

import com.android.TestStat;;

public class Access {

	static {
		System.out.println(TestStat.myInt);
		
	}
	
	void accessStuff() {
	//	System.out.println(myInt);
		System.out.println(myInt);
	}
}
