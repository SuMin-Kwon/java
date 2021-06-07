package 제어문;

import java.util.Scanner;

public class WhileTest2 {

	public static void main(String[] args) {

		int a = 0;
		Scanner sc = new Scanner(System.in);
		
		while ( a != 0) {
			a = sc.nextInt();
			System.out.println(a);
		}
		System.out.println("end");
		
		// 이럴때 do - while문을 사용함
		do {
			a = sc.nextInt();
			System.out.println(a);
		} while (a != 0);
	}

}
