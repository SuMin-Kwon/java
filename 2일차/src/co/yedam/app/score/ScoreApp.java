package co.yedam.app.score;

import java.util.Scanner;

/*
 * 성적 처리 프로그램
 * 국어, 영어, 수학 입력
 * 총점, 평균, 등급 계산 
 */

public class ScoreApp {

		Scanner scanner = new Scanner(System.in);
		int kor;
		int eng;
		int mat;
		int sum;
		float avg;
		char grade;
		
		// 성적입력
		void Input( ) {
			
			System.out.print("국어: ");
			kor = scanner.nextInt();
			System.out.print("영어: ");
			eng = scanner.nextInt();
			System.out.print("수학: ");
			mat = scanner.nextInt();
			return;
		}
		
		//합계계산
		int getSum() {
			sum = kor + eng + mat;
			return sum;
			
		}
		
		float getAvg() {
			avg = sum / 3;
			return avg;
		}
		boolean isPass() {
			if (avg > 60) {
				return true;
			}
			else {
				return false;
			}
		}
		
		char getGrade() {
			switch ((int) avg / 10) { // 80 이상 상 , 60 이상 중, 미만은 하
			case 10:
				
			case 9:
				
			case 8:
				grade = '상';   break;
			case 7:
				
			case 6:
				grade = '중';   break;
			default:
				grade = '하';   break;
			}
			return grade;
		}
		
	}
	
