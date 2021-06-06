package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Clock {

	public void alarm(int a, int b) {
		int r = (b - 45) ;
		if (r  < 0) {
			b = (60 + r);
			a --;
			if (a < 0) {
				a = 23;
			}
		}
		System.out.println(a +" "+ b);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String aa = br.readLine();
		String[] arr = aa.split(" ");
		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[1]);

		Clock clock = new Clock();
		clock.alarm(a, b);
	}

}
