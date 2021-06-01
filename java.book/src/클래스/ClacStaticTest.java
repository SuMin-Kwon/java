package 클래스;

public class ClacStaticTest {

	public static void main(String[] args) {

		// 정적 멤버는 클래스 이름으로 직접 접근이 가능
		// new 객체생성 없이도 바로 불러올수 있슴
		//ClacStatic.pi = 3.141592;
		System.out.println(ClacStatic.PI);
		System.out.println(ClacStatic.add(10,20));
		//add도 객체를 생성하지 않고도 바로 호출할수 있슴
		//Integer.MAX_VALUE =100;
		// 위에 max는 final이기때문에 변경이 안됨
		
		
		ClacStatic c1 = new ClacStatic();
		ClacStatic c2 = new ClacStatic();
		//c2.pi =3;
		
		System.out.println(c1);
		System.out.println(c2);
		
		
		
		
	}

}
