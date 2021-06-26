package 백준;

import java.util.Scanner;

public class SumCount {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		
		int nums = n1 * n2 * n3;
		String nn = String.valueOf(nums); // 문자로 변환
		int b; // 숫자로 변환해서 담을 값;
		int [] numsInt = new int[10]; // 0~9 숫자 count 값를 배열로 만듬
		
		for(int i = 1; i <= nn.length(); i++) {
			b = Integer.parseInt(nn.substring(i-1,i));
			switch(b) {
			case 0: numsInt[0]++; break;
			case 1: numsInt[1]++; break;
			case 2: numsInt[2]++; break;
			case 3: numsInt[3]++; break;
			case 4: numsInt[4]++; break;
			case 5: numsInt[5]++; break;
			case 6: numsInt[6]++; break;
			case 7: numsInt[7]++; break;
			case 8: numsInt[8]++; break;
			case 9: numsInt[9]++; break;
			}
		}
		for (int i =0; i< 10; i++) {
			System.out.println(numsInt[i]);
		}
		
//		숫자 하나씩 변수 지정해서 할떄	
//		int s0 =0;
//		int s1 =0;
//		int s2 =0;
//		int s3 =0;
//		int s4 =0;
//		int s5 =0;
//		int s6 =0;
//		int s7 =0;
//		int s8 =0;
//		int s9 =0;
//		
//		
//		
//		for(int i = 1; i <= nn.length(); i++) {
//			b = Integer.parseInt(nn.substring(i-1,i));
//			switch(b) {
//			case 0: s0++; break;
//			case 1: s1++; break;
//			case 2: s2++; break;
//			case 3: s3++; break;
//			case 4: s4++; break;
//			case 5: s5++; break;
//			case 6: s6++; break;
//			case 7: s7++; break;
//			case 8: s8++; break;
//			case 9: s9++; break;
//			}
//		}
//		System.out.println(s0);
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s3);
//		System.out.println(s4);
//		System.out.println(s5);
//		System.out.println(s6);
//		System.out.println(s7);
//		System.out.println(s8);
//		System.out.println(s9);
	}

}
