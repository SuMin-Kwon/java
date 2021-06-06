package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 나머지 값 비교 : 10430
public class Remainder {

	int a;
	int b;
	int c;
	int s1, s2, s3, s4;
	public int s1(int a, int b, int c) {
		s1 = (a+b)%c;
		return s1;
	}
	public int s2(int a, int b, int c) {
		s2 = ((a%c)+(b%c))%c;
		return s2;
	}
	public int s3(int a, int b, int c) {
		s3 = (a*b)%c;
		return s3;
	}
	public int s4(int a, int b, int c) {
		s4 = ((a%c)*(b%c))%c;
		return s4;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String aa = br.readLine();
		String [] arr = aa.split(" ");
		
		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[1]);
		int c = Integer.parseInt(arr[2]);
		
		Remainder re = new Remainder();
		System.out.println(re.s1(a,b,c));
		System.out.println(re.s2(a,b,c));
		System.out.println(re.s3(a,b,c));
		System.out.println(re.s4(a,b,c));
		
	}

}
