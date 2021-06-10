package co.board.view;

import java.util.ArrayList;
import java.util.Scanner;

import co.board.access.BoardAccess;
import co.board.access.BoardDAO;
import co.board.model.Board;

public class BoardApp {

	BoardAccess dao = new BoardDAO();

	Scanner scanner = new Scanner(System.in);

	public boolean rogin() {
		System.out.println(" 로그인 정보를 입력해주세요 ");
		System.out.println(" 아이디: ");
		String id = scanner.next();
		System.out.println(" 비밀번호: ");
		String pw = scanner.next();
		boolean t = dao.rogin(id,pw);
		return t;
	}
	
	
	// 프로그램 시작
	public void start() {

		int menunum;
		do {
			menuTitle(); // 메뉴출력
			System.out.println("입력"); // 메뉴 선택
			menunum = scanner.nextInt(); 
			switch (menunum) { // 실행
			case 1:
				listAll();
				break;
			case 2:
				insert();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:
				findDate();
				break;
			}
		} while (menunum != 0);
	}

	private void findDate() {
		System.out.print("조회할 글번호: ");
		int id = scanner.nextInt(); scanner.nextLine();
		System.out.println(dao.findDate(id));
	}

	private void listAll() {
		ArrayList<Board> list = dao.listAll();
		for (Board board : list) {
			System.out.println(board.showInfo());
		}

	}

	private void delete() {
		System.out.print("삭제할 글번호: ");
		int id = scanner.nextInt(); scanner.nextLine();
		dao.delete(id);

	}

	public String readMultiLine() {
		StringBuffer result = new StringBuffer();
		try {
			String a = "";
			while(true) {
				a = scanner.next();
				if (a == null || a.trim().equals("...")) {
					break;
				}
				result.append(a).append(" ");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}
	
	
	private void update() {
		Board board = new Board();
		System.out.print("변경할 Id: ");
		board.setB_id(scanner.nextInt());
		System.out.print("수정할 내용: ");
		String c = readMultiLine();
		board.setB_content(c);
		dao.update(board);

	}

	private void insert() {
		System.out.print("제목: ");
		String b_title = scanner.next(); scanner.nextLine();
		System.out.print("내용:");
		String b_content = scanner.next(); scanner.nextLine();
		System.out.print("작성자:");
		String b_writer = scanner.next();scanner.nextLine();
		Board board = new Board(b_title, b_content, b_writer);
		dao.insert(board);
	}

	public void menuTitle() {
		System.out.println("┌───────────   1. 전체리스트	──────────┐");
		System.out.println("│              2. 글 등 록         	  │");
		System.out.println("│              3. 글 수 정    		  │");
		System.out.println("│              4. 글 삭 제         	  │");
		System.out.println("│              5. 한건조회   	          │");
		System.out.println("└───────────   0. 종   료        ──────────┘");

	}

}
