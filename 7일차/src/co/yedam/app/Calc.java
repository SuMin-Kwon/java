package co.yedam.app;

public class Calc {
	
	public static int add(int a , int b) {
		return a + b;
	}
	public static int div(int a , int b) throws Exception {
		int c = a/b;
//		try {
//			c = a/b;
//		} catch (Exception e) {
//			c = a;
//		}
		
		return c;
	}
	
}
