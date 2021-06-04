package co.yedam.app.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) throws FileNotFoundException {
		// 파일을 읽어오기
		// scanner도 읽어올 수 있지만 성능이 좀 떨어짐
		Scanner scanner = new Scanner(new FileInputStream("d:/temp/f.dat")); // system.in 키보로부터 입력을 받음
		while (true) {
			try {
			String a = scanner.next();
			System.out.println(a);
			}catch (Exception e) {
				break;
			}
		}
	}
	// String str = "1 hi";
	// String b = scanner.next();

}
