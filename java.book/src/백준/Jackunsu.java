package 백준;

import java.util.Scanner;

public class Jackunsu {

	public static void main(String[] args) {

		Scanner scLine = new Scanner(System.in);
		
		String N = scLine.nextLine();
		String [] num = N.split(" ");
		
		String N2 = scLine.nextLine();
		String [] nums = N2.split(" ");
		
		
		for (int i =0; i < Integer.parseInt(num[0]); i++) {
			if(Integer.parseInt(num[1]) > Integer.parseInt(nums[i])){
				System.out.print(nums[i] + " ");
			}	
		}
		
	}

}
