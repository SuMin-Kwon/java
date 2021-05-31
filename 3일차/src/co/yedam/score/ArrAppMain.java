package co.yedam.score;

import java.util.Scanner;

public class ArrAppMain {

	
		int[] arr;         //성적
		int studentNum;    // 학생수
		Scanner scanner = new Scanner(System.in);
		
		void init() {
			System.out.println("인원수>");
			studentNum = scanner.nextInt();
			arr = new int[studentNum];
		}
		
		void input() {
			// 배열에 초기값 지정
			for (int i=0; i < arr.length; i++) {
				System.out.printf("score [%d] >",i);
				
				arr[i] = scanner.nextInt();
			}
			
		}
		
		
		void print() {
			for (int i=0; i < arr.length; i++) {
				System.out.printf(" score [%d] ",i+1,arr[i]);
				System.out.println();
			}
			System.out.println();
			
		}
		
		
		
		int sum() {
			int result = 0;
			for (int i=0; i < arr.length; i++) {
					result = result +arr[i];	
				}
			return result;
		}
		
		void max() {
			int max =arr[0];
			for (int i=0; i < arr.length; i++) {
				if (max < arr[i] ) {
					max = arr[i];
					}
				}
			System.out.println("최대값은: "+ max);
		}
		void avg() {
			int result = 0;
			result = sum()/arr.length;
			System.out.println("평균: "+result);
		}
		

		
}

