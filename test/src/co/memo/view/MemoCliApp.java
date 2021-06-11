package co.memo.view;

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
		String date = scanner.next(); scanner.nextLine();
		System.out.println("<메모제목>");
		String title = scanner.nextLine();
		System.out.println("내용: " );
		String content = scanner.nextLine();
		dao.write(date, title, content);
		
	}

	private void update() {
		System.out.println("조회할 메모 제목 : ");
		String title = scanner.next(); scanner.nextLine();
		System.out.println("수정내용 : ");
		String content = scanner.nextLine();
		dao.update(title,content);

	}

	private void delete() {
		System.out.println("삭제할 메모 제목 : ");
		String title = scanner.next(); scanner.nextLine();
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
		String date = scanner.next();
		Memo m = dao.FindByDate(date);
		System.out.println("< "+ m.getTitle()+ " >");
		System.out.println("내용 : "+ m.getContent());
		System.out.println("──────────────────────────");
	}

	private void findByTel() {
		System.out.println("검색할 내용");
		String content = sc.nextLine();
		scanner.nextLine();
		ArrayList<Memo> memo = dao.FindByContent(content);
		for (Memo m : memo ) {
			m.print();
		}
		

	}

	private void menuTitle() {
		System.out.println("== 메모 관리 ==");
		System.out.println("=1. 메모 추가");
		System.out.println("=2. 메모 수정");
		System.out.println("=3. 메모 삭제");
		System.out.println("=4. 전체 조회");
		System.out.println("=5. 날짜로 조회");
		System.out.println("=6. 내용으로 조회");
		System.out.println("=0. 종료");
		System.out.println("===============");

	}

	
}
