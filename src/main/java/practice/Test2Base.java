package practice;

public class Test2Base {
	
	
	public static void main(String[] args) throws NullPointerException {
		
		Test1 t = new Test1();
		
		System.out.println(t.x+" "+t.y);
		System.out.println(t.a);
		System.out.println(t.b);
		
		try {
			throw new NullPointerException();
		}
		
		catch(ArithmeticException j) {
			
		}
		catch(Exception e) {
			
		}
		
		
		
	}
	
}
