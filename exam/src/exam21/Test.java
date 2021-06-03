package exam21;

public class Test {

	public static void main(String[] args) {
		C2 obj1 = new C1();
		I obj2 = new C1();
		I s = obj2;
		C2 t = obj1;
		s.displayI();
		t.displayC2();
	}

}
