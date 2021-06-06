package 혼공자;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashtableExample {

	public static void main(String[] args) {
		
		// key 와 value 값으로 구성된 Map.Entry 객체 구조
		Map<String, String> map = new Hashtable<String, String>();

		// 아이디와 비번 저장
		map.put("Spring", "345");
		map.put("Summer", "678");
		map.put("fall", "91011");
		map.put("Winter", "1212");

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("아이디와 비번을 입력해주세요> ");
			System.out.print("아이디: ");
			String id = sc.nextLine();
			System.out.print("비번: ");
			String pw = sc.nextLine();

			if (map.containsKey(id)) {
				System.out.println("로그인 되었습니다.");
				break;
			} else {
				System.out.println("입력한 아이디가 존재하지 않습니다.");
			}

		}

	}

}
