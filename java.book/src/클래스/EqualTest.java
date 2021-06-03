package 클래스;

public class EqualTest {
	
	public static void main(String [] args) {
		Robot r1 = new Robot(2,4);
		Robot r2 = new Robot(2,4);
		
		// r1과 r2는 스텍 영역에 만들어지고 
		// 힙에 2,4가진 서로다른 객체가 두개 생김
		System.out.println( r1 == r2 );
		System.out.println( r1.equals(r2) );
		System.out.println(r1);
		
		System.out.println();
		String a = new String("hello");
		String b = new String("hello");
		System.out.println( a == b );
		System.out.println( a.equals(b) );
		
		//그냥 a == b랑 비교하면 false 이지만
		// a.equals로 비교하면 문자값을 비교하기 떄문에 true
	}

}
