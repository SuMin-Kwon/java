package co.yedam.app;


/*
 *  try - catch 적재적소에 걸어주고 너무 많이 걸어줘도 안됨!
 *  try - catch 를 사용해서 어떤 에러가 어디에서 발생하는지 확인가능하고 
 *  그부분 다음을 그대로 실행가능
 */
import java.util.Scanner;

public class TryTest1 {

	public static void main(String[] args) {

		try {

			// NullPointerException 에러
			String s = null; // <-- ""이거랑은 다름, ""는 아무것도 없는 빈 문자열을 말함
			System.out.println(s.charAt(0));
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		try {
//		//ArrayIndexOutOfBoundsException 에러
		int[] arr = new int[5];
		System.out.println(arr[5]);

		} catch (Exception e) {
			e.printStackTrace();

		}
		int a = 0;
		while (true) {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.printf("입력 : ");
				a = scanner.nextInt();
				if (a < 5)
					break;
			} catch (Exception e) {
				System.out.println(e.getMessage());

			}
		}
		System.out.println("a: " + a);
		System.out.println("The End");
	}

}
