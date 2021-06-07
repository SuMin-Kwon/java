package co.friend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Scanner;
import java.util.StringTokenizer;

// 백준 10818
public class MinMax {


	public static void main(String[] args) throws NumberFormatException, IOException {
		// 문제 풀이 1번
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		String[] SpStr = str.split(" ");
		
		int max = Integer.parseInt(SpStr[0]);
		int min = Integer.parseInt(SpStr[1]);
		
		for (int i =0; i < N; i++) {
			int num = Integer.parseInt(SpStr[i]);
			if (num > max) {
				max = num;
			}
			else if( num < min) {
				min = num;
			}
		}
		System.out.println(max + " " + min);

		
		
		
		// 		< 문제풀이 2번 >
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());//		
//		int arr[] = new int[N];
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int max = -1000000;
//		int min = 1000000;
//		for(int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//			if(arr[i] > max) max = arr[i];
//			if(arr[i] < min) min = arr[i];
//		}
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		bw.write(min + " " + max);
//		bw.flush();
//		bw.close();
		
		
				// 문제풀이 3번
				
//		Scanner scanner = new Scanner(System.in);
//				
//			System.out.print("숫자갯수 입력:");
//			int n = scanner.nextInt();		
//
//			int nums[] = new int[n];
//			
//			for (int i=0; i<n; i++) {
//				nums[i] = scanner.nextInt();
//			}
//			
//			int max = nums[0];
//			int min = nums[0];
//			for (int e : nums) {
//				if ( e > max) {
//					max = e;
//				}
//			}
//			for (int e : nums) {
//				if (e < min) {
//					min = e;
//				}
//			}
//			System.out.println(max + " " + min);
//				
//		
		
		
	}




}
