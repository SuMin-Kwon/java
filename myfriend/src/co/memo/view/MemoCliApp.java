package co.memo.view;

import java.util.List;
import java.util.Scanner;

import co.friend.util.ScannerUtil;
import co.memo.access.MemoAccess;
import co.memo.access.MemoDAO;
import co.memo.model.Memo;

public class MemoCliApp {

	Scanner scanner = new Scanner(System.in);
//	MemoList memolist = new MemoList();
	MemoAccess memolist = new MemoDAO();
	public void start() {

		int menunum;
		do {
			menuTitle(); // 메뉴출력
			menunum = ScannerUtil.readInt("입력"); // 메뉴 선택
			switch (menunum) {
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
				listAll();
				break;
			case 5:
				findDate();
				break;
			case 6:
				findContent();
				break;

			}
		} while (menunum != 0);
	}
	
	private void insert() {
		Memo memo = ScannerUtil.readMemo();
		memolist.insert(memo);
	}

	private void update() {
		Memo memo = new Memo();
		memo.setDate(ScannerUtil.readStr("날짜 ex)2021-06-01 "));
		System.out.println("수정할 메모 입력:");
		memo.setContent(ScannerUtil.readMultiLine());
		memolist.update(memo);
	}

	private void delete() {
		String date = ScannerUtil.readStr("날짜");
		memolist.delete(date);
		
	}

	private void listAll() {
		List<Memo> list = memolist.listAll();
		for (Memo memo : list) {
			//System.out.println(memo.getDate() + " : " + memo.getContent());
			System.out.println(memo);
		}
		
	}

	private void findDate() {
		String date = ScannerUtil.readStr("날짜검색 (ex)2021-06-01");
		Memo memo = memolist.findDate(date);
		System.out.println(memo);
		
	}

	private void findContent() {
		String content = ScannerUtil.readStr("내용검색");
		Memo memo = memolist.findContent(content);
		System.out.println(memo);
		
	}

	private void menuTitle() {
		System.out.println("======= 메모장 =====");
		System.out.println("====1. 메모등록 ====");
		System.out.println("====2. 메모수정 ====");
		System.out.println("====3. 메모삭제 ====");
		System.out.println("===4. 메모전체조회===");
		System.out.println("====5. 날짜검색 ====");
		System.out.println("====6. 내용검색 ====");
		System.out.println("=====0. 종료 ======");

	}

}
