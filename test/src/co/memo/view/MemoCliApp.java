package co.memo.view;

/*
 *  scanner 사용할떄 next, nextLine 함께 사용하니깐 오류가 많이 발생함
 *  두가지를 같이 사용할 때는 next, Line은 따로 스캐너를 뉴객체로 생성해서
 *  사용하는게 좋음.
 */


import java.util.ArrayList;
import java.util.Scanner;

import co.memo.access.MemoAccess;
import co.memo.access.MemoDAO;
import co.memo.model.Memo;

public class MemoCliApp {

	MemoAccess dao = new MemoDAO(); // 데이터베이스 입출력 처리하세요.
	Scanner scanner = new Scanner(System.in);
	Scanner sc = new Scanner(System.in);

	public void start() {
		int menuNum;

		do {
			menuTitle();
			System.out.print("입력 > ");
			menuNum = scanner.nextInt();
			switch (menuNum) {
			case 1:
				insert();
				break;
			case 2:
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				selectAll();
				break;
			case 5:
				findByName();
				break;
			case 6:
				findByTel();
				break;
			}
		} while (menuNum != 0);
		System.out.println("프로그램 종료.");
	}

	private void insert() {
		System.out.println("날짜 (ex)2021-00-00 ");
		String date = sc.nextLine();
		System.out.println("<메모제목>");
		String title = sc.nextLine();
		System.out.println("내용: " );
		String content = sc.nextLine();
		dao.write(date, title, content);
		
	}

	private void update() {
		System.out.println("조회할 메모 제목 : ");
		String title = sc.nextLine();
		System.out.println("수정내용 : ");
		String content = sc.nextLine();
		dao.update(title,content);

	}

	private void delete() {
		System.out.println("삭제할 메모 제목 : ");
		String title = sc.nextLine();
		dao.delete(title);
	}

	private void selectAll() {
		ArrayList<Memo> list = dao.FindAll();
		for (Memo memos : list) {
			memos.print();
		}
	}

	private void findByName() {
		System.out.println("조회할 날짜 (ex)2021-00-00 ");
		String date = sc.nextLine();
		Memo m = dao.FindByDate(date);
		System.out.println("< "+ m.getTitle()+ " >");
		System.out.println("내용 : "+ m.getContent());
		System.out.println();
	}
	
	// 포함내용 찾기
	private void findByTel() {
		System.out.println("검색할 내용");
		String content = sc.nextLine();
		ArrayList<Memo> list = dao.FindAll();
		for (Memo memos :list) {
			if(memos.getContent().contains(content)) {
				memos.print();
			};
		}
//		
//		ArrayList<Memo> memo = dao.FindByContent(content);
//		for (Memo m : memo ) {
//			m.print();
//		}
		

	}

	private void menuTitle() {
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓MEMO〓");
		System.out.println("             ① 메모 추가             ");
		System.out.println("             ② 메모 수정             ");
		System.out.println("             ③ 메모 삭제             ");
		System.out.println("             ④ 전체 조회             ");
		System.out.println("             ⑤ 날짜 검색             ");
		System.out.println("             ⑥ 내용 검색             ");
		System.out.println("             ⓞ 종   료             ");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");

	}

	
}
