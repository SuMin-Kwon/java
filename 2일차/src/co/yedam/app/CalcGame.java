package co.yedam.app;

import java.util.Scanner;

/*
 * 계산기 게임
 * 사칙연산, 진수 변환, 문자값 검사
 */
public class CalcGame {
	double a;
	double b;
	
	void input(){
		//입력
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력1");
		String s1 = scanner.next();
		System.out.print("입력2");
		String s2 = scanner.next();
		a = Double.parseDouble(s1);  
		// string -> double
		b = Double.parseDouble(s2); 
		scanner.close();
	}
	//정수값 두 수의 합을 계산하는 메서드(함수) 
	double add() {
		return a+b;
	}
//  파이썬 문법	
//	def add(a,b)    
//		return a+b
	
//	정수값 두 수의 몫을 계산하는 메서드(함수) 5/2 2	
	int share() {
		return (int)a/(int)b;
	}
//	정수값 두 수의 나눗셈을 계산하는 메서드(함수) 5/2 2.5	
	double div() {
		return a/b; // 둘 중에 하나만 더블로 주면 더블로 변환됨
	}
//	정수값 두 수의 나머지를 연산하는 메서드(함수)	 5%2 1
	int rest() {
		return (int)a%(int)b;
	}

}
