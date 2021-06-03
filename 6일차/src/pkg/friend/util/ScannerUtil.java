package pkg.friend.util;

import java.util.Scanner;

public class ScannerUtil {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static int readInt() {} // 숫자를 읽어냄
	public static String readStr() {}  // 단어 하나하나를 읽어냄
	public static String readDate() {} // 날짜를 읽어냄
	public static Friend readFriend() {}  // 안에 들어있는 값들을 읽어서 리턴해서  
	
	String result = scanner.next(); // split 으로 한줄씩 읽어들여서 friend 객체에 넣어  // 초등, 홍길동 ,1111
//	String [] arr = result.split(" ");

	
	// 프렌드를 담아
}
