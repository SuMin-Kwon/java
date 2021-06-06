package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumCompare {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] nums = br.readLine().split(" ");
		
		int N = Integer.parseInt(nums[0]);
		int A = Integer.parseInt(nums[1]);
		
		String [] nums2 = br.readLine().split(" ");
		for (String n :nums2) {
			int B = Integer.parseInt(n);
			if (B < A) {
				System.out.print(B + " ");
			}
		}
		
		
	
		
					
	}

}
