package co.friend.util;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import co.friend.model.Friend;
import co.memo.model.Memo;

public class ScannerUtil {

	static Scanner scanner = new Scanner(System.in);

	public static int readInt(String prompt) {
		System.out.println(prompt + ">");
		return readInt(); // 밑에 있는 readInt() 불러와서 리턴
	}
	
	public static int readInt() {
		int result = 0;
		while (true) {
			try {
				String temp = scanner.next();
				result = Integer.parseInt(temp);
				break;
			} catch (Exception e) {
				System.out.println("숫자 형식이 아닙니다");
			}
		}
		return result;
	}

	// 한줄 입력
	public static String readStr(String prompt) {
		System.out.println(prompt);
		System.out.println(">");
		return readStr();
	}

	public static String readStr() {
		String result = "";
		try {
			result = scanner.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	// 날짜입력
	public static String readDate() {
		String result = "";
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		do {
			try {
				result = scanner.next();
				df.parse(result.trim()); // trim 공백제거
				break;
			} catch (Exception e) {
				System.out.println("(yyyyMMdd) 날짜 형식이 아닙니다.");
			}
		} while (true);
		return result;

	}

	// Friend 입력
	public static Friend readFriend() {
		System.out.print("구분,이름,전화번호>");
		String result = scanner.next();
		String[] arr = result.split(",");
		Friend friend = new Friend(arr[0],arr[1],arr[2]);
//		friend.setGubun(arr[0]);
//		friend.setName(arr[1]);
//		friend.setTel(arr[2]);
		return friend;
	}
	// 메모입력
	public static Memo readMemo() {
		System.out.print("날짜");
		String date = scanner.next();
		System.out.print("내용");
		String content = readMultiLine();
		Memo memo = new Memo(date,content);
		
//		friend.setGubun(arr[0]);
//		friend.setName(arr[1]);
//		friend.setTel(arr[2]);
		return memo;
	}
	
	public static String readMultiLine() {
		StringBuffer result = new StringBuffer();
		try {
			String a = "";
			while(true) {
				a= scanner.next();
				if (a == null || a.trim().equals(".end")) {
					break;
				}
				result.append(a).append(" ");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}
	
	

}
