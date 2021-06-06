package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Compare {

	
	public void com (int a, int b) {
		if (a == b) {
			System.out.println("==");
		}else if (a > b) {
			System.out.println(">");
		}else {
			System.out.println("<");
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String aa = br.readLine();
		String [] arr = aa.split(" ");
		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[1]);
		
		Compare compare = new Compare();
		compare.com(a, b);
		
	}

}
