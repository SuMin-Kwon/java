package co.yedam.member;

import java.util.Scanner;

public class MemberApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MemberService mem = new MemberService();
		
		mem.insert("권수민", "ever", "12345", 50);
		mem.insert("홍길동", "e111", "12345", 25);
		mem.insert("이나은", "ev22", "12345", 17);
		
		mem.printList();
		mem.printMember();
		
		
//		System.out.println(mem.login("권수민", "12345"));
//		System.out.println(mem.login("kim", "1234"));
		
//		int selectNo = 0;
//		MemberService arr = new MemberService();
//		boolean run = true;
//		Scanner scanner = new Scanner(System.in);
//		while (run) {
//			System.out.println("1. 등록 / 2. 전체조회 / 3.번호로 조회 / 4.로그인 / 5.id로 조회 / 6. 종료");
//			System.out.print("선택>");
//			selectNo = scanner.nextInt();
//			if (selectNo == 1) {
//				arr.insert();
//			}
//			else if (selectNo == 2) {
//				arr.printList();
//			}
//			else if (selectNo == 3) {
//				arr.numSerch();
//			}
//			else if (selectNo == 4) {
//				
//				
//			}
//			else if (selectNo == 5) {
//			}
//			else if (selectNo == 6) {
//				System.out.println("시스템종료");
//				run = false;	
//			}
//		}
		
	}

}
