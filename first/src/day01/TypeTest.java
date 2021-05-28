package day01;
/*
 * 데이터형 연습
 * 변수의 타입을 정해주기 위해서 값뒤에 표시를 해줘야함
 * 정수 int와 double이 기본값이라서 뒤에 표시 안해줘도 됨
 * 
 * 				   200  2223L  10.3F  10. 5
 * 
 * 				   기본			    	기본
 *   1		2		4	  8		4		8
 * byte > short > int > long					정수 
 * 							> float > double	실수
 * 		  char									문자
 * boolean										논리
 * 
 * 0.000001  > 0.1*10의 -5승
 * */



public class TypeTest {

	public static void main(String[] args) {
	//	System.out.println(Integer.MAX_VALUE);
	//	System.out.println(Long.MAX_VALUE);
		long a = 2200000000L;  
		// int b = 220000000;
		float f = 0.123456789f;  //유효자리수 7자리까지만 표시가능하고 나머지는 올림수
		System.out.println(f);
		double d = 0.12345678912345678910;   //유효자리수 16~17자리까지만 표시가능
		System.out.println(d);
		
		// 진수표현
		int b = 0111;   // (0xa > 10 ,0xb > 15 )이진수값, 0으로 시작하면 8진수
		System.out.println("8진수 111 =" + b);
		
		int b8 = 015 + 04;
		System.out.println("8진수 015 + 04 =" + 
							Integer.toOctalString(b8));
		
		int b16 = 0xff;     // 0x로 시작하면 16진수
		System.out.println(b16);
		
		int b2 =0b1111;     // 0b로 시작하면 2진수
		System.out.println(b2);
		//char
		System.out.println("--------------------------");
		char c1 = '가';
		System.out.println((int)c1);    // 10진수
		System.out.println(Integer.toHexString(c1)); //16진수
		char c2 = '\uac01'; 
		int c3 = 44033;
		System.out.println(c2);
		System.out.println((char)c3);
		
	}

}
