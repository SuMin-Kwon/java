package co.yedam.member;

import java.util.Scanner;

import java.util.Scanner;

public class MemberService {

	Scanner scanner = new Scanner(System.in);
	Member[] members = new Member[10];
	int cnt = 0;

	// 회원가입
	void insert(String name, String id, String password, int age) {

		members[cnt] = new Member(id, password, name, age);
		cnt++;
	}

	void insert() {
		System.out.println("id를 입력하세요:");
		String id = scanner.next();
		System.out.println("이름을 입력하세요:");
		String name = scanner.next();
		System.out.println("pw를 입력하세요:");
		String password = scanner.next();
		System.out.println("나이를 입력하세요:");
		int age = scanner.nextInt();
		members[cnt] = new Member(id, password, name, age);
		cnt++;
	}

	// 회원리스트 조회
	void printList() {
		for (int i = 0; i < cnt; i++) {
			System.out.print(members[i].name+" " +members[i].id+" " + members[i].password+" " +members[i].age);
			System.out.println();

		}
	}

	// 3. 번호로 조회
	void printMember() {
		System.out.println("번호입력:");
		int num = scanner.nextInt();
		System.out.println("이름: "+members[num].name);
		System.out.println("ID: "+members[num].id);
		System.out.println("PW: "+members[num].password);
		System.out.println("나이: "+members[num].age);
	}

	// 3. 번호조회 {내가 대충 만든거}
	void numSerch() {
		System.out.println("번호입력:");
		int num = scanner.nextInt();
		System.out.println(members[num]);
	}

	// 로그인
	void login() {
		System.out.println("ID > ");
		String id = scanner.next();
		System.out.println("Password > ");
		String password = scanner.next();
		for (int i=0; i<= cnt; i++) {
			if (id.equals(members[i].id) && 
					password.equals(members[i].password)) {
				System.out.println("로그인 되었습니다.");
				break;
			}
		else {
			if (i == cnt) {
			System.out.println("등록되지 않은 ID와 PW입니다.");	
			}}	
		}
	}

	// 5. Id 조회
	void search() {
			System.out.println("Id입력> ");
			String id = scanner.next();
			for (int i=0; i <cnt; i++) {
				if (id.equals(members[i].id)) {
				System.out.println(members[i].name);
				System.out.println(members[i].id);
				System.out.println(members[i].password);
				System.out.println(members[i].age);
				}
			}
		}

	void logout() {
		System.out.println("bye!!!");
	}
}