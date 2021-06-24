package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import java.util.Scanner;

public class Jayeunsu {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int count = 1; // n 숫자값 1번은 무조건 들어가니깐
		
		for(int i = 1; i< (n/2) +1; i++) {
			int sum = i;
			for (int j= i+1; i <(n/2) + 2; j++) {
				if (sum ==n) {
					count = count + 1;
					break;
				}
				if (sum > n) {
					break;
				}
				sum = sum + j;
			}
		}
		System.out.println(count);
		
	//	Scanner scanner = new Scanner(System.in);
	//	
	//	
	//	int result;
	//	int count = 0;
	//	int nums = scanner.nextInt(); // 숫자 입력받음
	//	int [] number = new int[nums]; // 배열 생성
	//	
	//	for (int i =0; i < nums; i++ ) { // 배열의 자연수 생성
	//		number[i] = i+1;
	//	}
	//	
	//	while(true) {
	//			int nansu = 0;
	//			result = number[nansu];
	//			if( result == nums ) {
	//				count = count + 1;
	//			}else if (result < nums) {
	//				nansu++;
	//				continue;
	//			}else {
	//				break;
	//			}
	//		}
	}
}
