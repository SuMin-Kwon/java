package exam117;

public class C extends A {
	public static void main(String[] args) {
		A b1 = new A();
		A b2 = new C();
		b1 = (A) b2; // line n1
		A b3 = (B) b2; // line n2  //오류
		b1.test();
		b3.test();
	}
}