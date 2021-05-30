package alone.test;

import java.util.Scanner;

public class AloneTset3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
//		System.out.print("점수입력: ");
//		int jumsu = scanner.nextInt();
//		scanner.close();
//		
//		if (jumsu > 80) {
//			System.out.println(jumsu + "점은 \"상\"입니다.");
//		}
//		else if (jumsu > 70) {
//			System.out.printf("%d점은 %s입니다",jumsu,"중");
//			System.out.println();
//		}
//		else {
//			System.out.printf("%d점은 %s입니다",jumsu,"하");
//			System.out.println();
//		}
		
		
		
		System.out.print("실수 입력: ");
		double a = scanner.nextDouble();
		System.out.print("실수 입력2: ");
		double b = scanner.nextDouble();
		
		if ((a == 0.0) |(a == 0)) {
			System.out.println("결과값 : 무한대"); }
		else {	
			double result = a / b;
			System.out.println("결과값: "+result);
			
		}
		
	}

}
