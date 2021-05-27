package co.yedam.app;

import java.util.Scanner;

/*
 * 작성일자 : 21-05-27
 * 형 변환 : 캐스트연산자(타입) // 스트링은 캐스트연산자로 타입변환 안됨
 * 정수형 : byte < short < int < long   
 * 실수형 :				float < double
 * 
 * 스트링  ---->  byte		Byte.parseByte(변수)    p.83참조
 * 				short		Short.parseShort(변수)
 * 				int			Interger.parseInt(변수)
 * 				long		Long.parseLong(변수)
 * 				float			,,		
 * 				double			,,
 * 				char			,,
 * 				boolean			,,
 * 		<----	
 * String.valueOf()
 */

public class CastTest {

	public static void main(String[] args) {
		// 자동형 변환
		int a = 10;
		long b = a;
		System.out.println();
		// 강제형 변환
		a = (int)b;  // 큰 값을 작은 타입에 넣어줄려고 앞에 (int)를 넣어줘야함 
		
		// char(문자) <-> int(코드) >문자를 코드로 바꾸면 문자를 숫자로 바꾸는게 아니라 문자의 코드로 보여줌
		char c = 'Z';
		System.out.println("Z의 코드는:"+(int)c); 
		int d = 97;
		System.out.println("97의 문자값은:"+(char)d);
		
		// 실수값(기본:double)   -> 정수(기본:int)
		double e = 10.5;
		long f = (long)e;   // e앞에 int를 넣어도 에러는 안뜨지만 왠만하면 맞춰서 바꿔주는게 좋음
		System.out.println("실수를 정수 전환 :"+ f);
		
		//수식내에서 자동으로 형 변환
		double g = 5 + 10.5; // int + double 하면 자동으로 큰 더블로 변환해서 계산해줌
		String h = "hi" + 7;  // 파이썬과 달리 자바는 문자와 숫자를 써도 자동으로 변환시켜줌
		// 자바는 큰 타입으로 자동으로 변환하여 연산하게 됨
		System.out.println("자동전환 :"+ g);
		System.out.println("자동전환 :"+ h);
		System.out.println("hi"+ 5 + 10);
		System.out.println("hi"+ (5 + 10)); //위에 문장이랑 다름 먼저 정수끼리 더해진다음 형변환됨
		System.out.println(5 + 10 +"hi");
		System.out.println();
		System.out.println(5/2); // 정수 나누기 정수 하면 정수로 나옴
		System.out.println(5/(double)2); //하나를 큰 타입으로 바꿔서 넣어주면 실수값이 나옴
		
		System.out.println();
		System.out.println();
		double i = 5 /(double)2; 
		System.out.println("5//(double)2는"+i);
		System.out.println("------------------------");
		// 스트링  - > int
		String s1 = "123";
		int j = Integer.parseInt(s1);
		System.out.println(j);
		
		// int   - > 스트링
		String s2 = String.valueOf(12.3);
		System.out.println(s2);
		System.out.println("------------------------");
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력하세요:");
		String greet = scanner.next();
		System.out.println(greet+greet);
		scanner.close();
	}

}
