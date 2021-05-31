package co.yedam.score;

import java.util.Scanner;

public class ArrAppMainAPP {

	public static void main(String[] args) {
		
		int selectNo = 0;
		ArrAppMain arr = new ArrAppMain();
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		while (run) {
			System.out.println("1. 학생수 / 2. 점수입력 / 3.점수리스트 / 4.분석 / 5.종료");
			System.out.print("선택>");
			selectNo = scanner.nextInt();
			if (selectNo == 1) {
				arr.init();
			}
			else if (selectNo == 2) {
				arr.input();
			}
			else if (selectNo == 3) {
				arr.print();
			}
			else if (selectNo == 4) {
				arr.max();
				arr.avg();
			}
			else if (selectNo == 5) {
				System.out.println("시스템종료");
				run = false;
			}
		}
		
	}
	
}
