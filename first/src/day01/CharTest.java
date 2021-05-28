package day01;

public class CharTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//대소문자
		char c1 = 'A';   //   '\uac00   0xac00
		int c2 = c1 + 32;
		System.out.println( c2 + " " + (char)c2 );
		
		char c3 = '\uac00';
		char c4 = 0xac00;
		char c5 = '가';
		char c6 = 44032;
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
		
		//문자열
		String s = "\"안녕\"\n하\n세\t요요요\\";  // str는 "" , char ''
		System.out.println(s);
		

	}

}
