package co.yedam.app;

import java.util.Scanner;


public class MemberInfo {
	String name;		//이름
	String id;			//주민
	String tel;			//번호
	double kg;		//몸무게
	double cm;		//키
	
	Scanner scanner = new Scanner(System.in);
	double result = 0;
	String s = "";
	
	void heightWeightInput( ) {
			
		System.out.print("4. 몸무게(kg) : ");
		kg = scanner.nextDouble();
		System.out.print("5. 키(cm) : ");
		cm = scanner.nextDouble();
	}
	
	String bmi() {

		result = kg/((cm/100) * (cm/100));
		
		if (result < 18.5) {
			s = "저체중";
		}
		else if (result < 23) {
			s = "정상";
		}		
		else if (result < 25) {
			s = "과체중";
		} 
		else  {
			s = "고도비만";
		}
		
		return s ;
	}
		
	void input() {
			int a = 10;	
			// 코드 작성
			System.out.print("1. 이름 : ");
			name = scanner.next();
			System.out.print("2. 주민번호는 앞 6자리 : ");
			id = scanner.next();
			System.out.print("3. 전화번호 : ");
			tel = scanner.next();
			// 생략된거나 다른없음 return 
		
	}   
	
	void print() {
		System.out.println();
		System.out.println(name);
		System.out.println(id);
		System.out.println(tel);
	}

}
