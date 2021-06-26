package 백준;

import java.util.Scanner;

public class AvgF {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Scanner scLine = new Scanner(System.in);
		
		int N = sc.nextInt();
		int [] result = new int[N];
		int sum = 0;
		double avg;
		
		
		for (int i = 1; i <= N; i++ ) {
			String a1 = scLine.nextLine();
			int jumsu = Integer.parseInt(a1.substring(0,1));
			String [] sums = a1.split(" ");
			for (int j=0; j <jumsu; j++) {
				sum = sum + Integer.parseInt(sums[j]);
			}
			avg = 0;
		}
		
		
	}

}
