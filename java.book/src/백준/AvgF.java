package 백준;

import java.util.Scanner;

public class AvgF {
	// 백준문제
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Scanner scLine = new Scanner(System.in);
		
		int N = sc.nextInt();
		int sum = 0;
		int avg;
		int count=0;
		double beyul;
		
		for (int i = 1; i <= N; i++ ) {
			sum = 0;
			count = 0;
			avg = 0;
			String a1 = scLine.nextLine();
			int jumsu = Integer.parseInt(a1.substring(0,1));
			String [] sums = a1.split(" ");
			
			for (int j=1; j <= jumsu; j++) {
				sum = sum + Integer.parseInt(sums[j]);
			}
			avg = sum / jumsu;
			for (int e=1; e <= jumsu; e++ ) {
				if(avg < Integer.parseInt(sums[e])) {
					count++;
				}
			}
			beyul = (count*100)/(double)jumsu;	// 강제 형변환
			System.out.println(beyul);
			System.out.println(String.format("%.3f", beyul));
		}
		

		
	}

}
