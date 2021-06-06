package pkg.friend.util;

import java.util.Scanner;

import pkg.Friend;

public class ScannerUtil {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static int readInt() {
		return 0;} // 숫자를 읽어냄
	public static String readStr() {
		return null;}  // 단어 하나하나를 읽어냄
	public static String readDate() {
		return null;} // 날짜를 읽어냄
	public static Friend readFriend() {
		return null;}  // 안에 들어있는 값들을 읽어서 리턴해서  
	
	String result = scanner.next(); // split 으로 한줄씩 읽어들여서 friend 객체에 넣어  // 초등, 홍길동 ,1111
	String[] arr = result.split(",");
	Friend friend = new Friend();
//	friend.setGubun(arr[0]);
//	friend.setGubun(arr[1]);
//	friend.setGubun(arr[2]);
}
