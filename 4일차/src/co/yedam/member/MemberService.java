package co.yedam.member;

import java.util.Scanner;

import java.util.Scanner;
public class MemberService {
	
	Scanner scanner = new Scanner(System.in);
	Member[] members = new Member[10];
	int cnt = 0;
	
//	
//	boolean login (String id, String pw) {
//		if (id.equals("hong")& pw.equals("12345")){
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
//	
//	void logout(String id) {
//		System.out.println(id+"님 " + "로그아웃 되었습니다."); 
//	}
//	
//}

	// 회원가입
		void insert(String name, String id, String password, int age) {
			
			members[cnt] = new Member(id,password,name,age);
			cnt++;
		}
		
		void insert() {
			System.out.println("id를 입력하세요:");
			String id = scanner.next();
			System.out.println("pw를 입력하세요:");
			String password = scanner.next();
			System.out.println("이름을 입력하세요:");
			String name = scanner.next();
			System.out.println("나이를 입력하세요:");
			int age = scanner.nextInt();
			members[cnt] = new Member(id,password,name,age);
			cnt++;
		}
		
		//회원리스트
		void printList() {
			for (int i=0; i < cnt; i++  ) {
			System.out.println(members[i]);
				
			}
		}
		
		void printMember(int i) {
			System.out.println(members[i].name);
			System.out.println(members[i].id);
			System.out.println(members[i].password);
			System.out.println(members[i].age);
		}

		void numSerch() {
			System.out.println("번호입력:");
			int num = scanner.nextInt();
			System.out.println(members[num]);
		}
		
		void idSerch() {
			System.out.println("Id입력:");
			String idd = scanner.next();
			if (idd.equals(members[]) {
				
			}
			
		} 
		
		boolean login (String id, String password) {
			System.out.println("Id:");
			String idd = scanner.next();
			System.out.println("PW:");
			String Pww = scanner.next();
			boolean result = false;
			for (int i =0; i <cnt; i++) {
				
				if (id.equals(members[i].id) && password.equals(members[i].password)){
					result = true ;
					break;
				}
			}
			return result;
		}
		
		void logout(String id) {
			System.out.println(id+"님 " + "로그아웃 되었습니다."); 
		}
}