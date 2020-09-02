import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

public class Test {
	
	public interface Drawable {
		public abstract void draw ();
	}
	
	public class Canvas implements Drawable{ 
		public void draw () { }
	}
	
	public abstract class Board extends Canvas{ 
		
	} 
	
	public class Paper extends Canvas{
		protected void draw (int color) { }
	}
	
	public class Frame extends Canvas implements Drawable { 
		public void resize () { }
	}
	
	//----------
	
	
}


