package 백준;

import java.util.Scanner;

public class Jayeunsu {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		int nums = scanner.nextInt(); // 숫자 입력받음
		int [] number = new int[nums]; // 배열 생성
		
		for (int i =0; i < nums; i++ ) { // 배열의 자연수 생성
			number[i] = i+1;
		}
		
		
		
		scanner.close();
	}	
}
