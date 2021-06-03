package 클래스;

public class StringEqual {

	public static void main(String[] args) {

		String s1 = "hello";					// 상수   "hello"  "aaa"  "helloaaa"
		String s2 = "hello" + "aaa";			// new 아니면 전부 상수영역에 저장
		
		String s3 = new String("hello");		// 힙
		String s4 = new String("hello");
		
		System.out.println( s1 == s2 );			// true
		System.out.println( s3 == s4 );			// false
		System.out.println( s1 == s3 );			// false
		System.out.println( s1.equals(s3) );
		System.out.println( s3.equals(s4) );
		
		// 객체 참조변수 같은 경우에는 equals로 비교 안되고
		// 만약 비교하고 싶다면 equals 오버라이딩 해서 비교해줘야함
		
		// StringBuffer : 편집,수정할때 대체로 사용됨 
		StringBuffer sb = new StringBuffer("Hello world");
		sb.insert(5, "111");
		System.out.println(sb.toString());
		sb.replace(0, 5, "Hi");
		System.out.println(sb.toString());
		// sb를 toString 한 다음에 equals 해야함
		
		
		
	}

}
