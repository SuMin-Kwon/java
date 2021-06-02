package pkg.inheritence;

public class MainApp {

	public static void main(String[] args) {

		A a = new D(); // 자동형 변환
//		a = new B();
//		a = new D(); // 이거를 막아버리면 자식관계를 못찾음
//		
//		B b = new D();
//		X x = new D(); // D는 부모면 다 올수 있어서 다 형변환 가능함
//		Y y = new D();
		// 상속관계에 있는 모든 관계들은 맞다고 나오고 타입변환 가능
		
		int temp = ((D)a).sb; // 실제로는 참조되어있지만 A만 볼수 있고 D는 못보게 되기 때문에
		          // 이런식으로 강제 형 변환을 넣어주면 D의 필드까지 볼수 있슴
		
		A o = new A();
		//temp = ((D)o).sb;   실행오류 A에는 sa밖에 없기 때문에 sb를 가져올수 없슴 : 런타임 오류 
		
		
		System.out.println(a instanceof A);
		System.out.println(a instanceof B);
		System.out.println(a instanceof D);
		System.out.println("============");
		System.out.println(a instanceof X);
		System.out.println(a instanceof Y);
		
		// B b = new B();
		// b = new D();
		// b = new C(); 얘는 부모가 아니라 형제라서 타입변환 안됨
		
		
	}

}
