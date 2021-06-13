package co.board.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.board.access.BoardAccess;
import co.board.access.BoardDAO;
import co.board.model.Board;

public class BoardApp {

	BoardAccess dao = new BoardDAO();

	Scanner scanner = new Scanner(System.in); // next
	Scanner sc = new Scanner(System.in); // nextLine

	static String u_id;
	static String u_pw;
	boolean e;

	// 상위로그인
	public void top() {
		int yn;
		while (true) {
			System.out.println("──────── BOARD ────────");
			System.out.println("1) 로그인     2) 회원가입 ");
			System.out.println("───────────────────────");
			yn = scanner.nextInt();
			if (yn == 1) {
				if (rogin()) {
					start();
				}else {
					System.out.println("일치하는 아이디가 없습니다.");
					continue;
				}
			}
			else if (yn == 2) {
					System.out.println("******간편한 회원가입******");
					System.out.println("아이디 입력:");
					String e1 = scanner.next();
					System.out.println("비밀번호 입력:");
					String e2 = scanner.next();
					dao.insertRogin(e1, e2);
					continue;
			} else {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
		}
	}

	// 로그인 정보 비교
	public boolean rogin() {
		System.out.println(" 로그인 정보를 입력해주세요 ");
		System.out.println(" 아이디: ");
		u_id = scanner.next();
		System.out.println(" 비밀번호: ");
		u_pw = scanner.next();
		boolean t = dao.rogin(u_id, u_pw);
		return t;
	}

	// 프로그램 시작
	public void start() {

		int menunum;
		while (true) {
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
			case 6:
				reply();
				break;
			case 0:
				System.exit(1);
			}
		}
	}

	// 한건 상세보여주기
	private void findDate() {
		System.out.print("조회할 글번호: ");
		int id = scanner.nextInt();
		System.out.println(dao.findDate(id).showFind());
		// 댓글보여주는거
		List<Board> list = dao.replyShow(id);
		for (Board board : list) {
			System.out.println("  ＞＞ " + board.getB_content());
		}
	}

	// 전체리스트 조회
	private void listAll() {
		ArrayList<Board> list = dao.listAll();
		for (Board board : list) {
			System.out.println(board.showInfo());
		}

	}

	// 게시글 삭제
	private void delete() {
		System.out.print("삭제할 글번호: ");
		int id = scanner.nextInt();
		boolean e = dao.roginTrueKey(id, u_id);
		if (e) {
			dao.delete(id);
			dao.replyDelete(id); // 댓글 삭제
		} else {
			System.out.println("권한이 없습니다");
			start();
		}

	}

	// 길게 작성
	public String readMultiLine() {
		StringBuffer result = new StringBuffer();
		try {
			String a = "";
			while (true) {
				a = scanner.next();
				if (a == null || a.trim().equals("...")) {
					break;
				}
				result.append(a).append(" ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	// 글 수정
	private void update() {
		Board board = new Board();
		System.out.print("변경할 글번호: ");
		int id = scanner.nextInt();
		boolean e = dao.roginTrueKey(id, u_id);
		if (e) {
			board.setB_id(id);
			System.out.print("수정할 내용: ");
			String c = readMultiLine();
			board.setB_content(c);
			dao.update(board);
		} else {
			System.out.println("권한이 없습니다");
			start();
		}

	}

	// 글 등록
	private void insert() {
		System.out.print("제목: ");
		String b_title = sc.nextLine();
		System.out.print("내용:");
		String b_content = readMultiLine();
		Board board = new Board(b_title, b_content, u_id);
		dao.insert(board);
	}

	// 댓글
	public void reply() {
		System.out.print("댓글 추가할 글번호:");
		int parentid = scanner.nextInt();
		scanner.nextLine();
		System.out.println(dao.findDate(parentid).showFind());
		ArrayList<Board> list = dao.replyShow(parentid);
		for (Board board : list) {
			System.out.println("＞ " + board.getB_content());
		}
		System.out.println("1) 댓글추가   2) 이전으로 돌아가기");
		int num = scanner.nextInt();
		scanner.nextLine();
		if (num == 1) {
			System.out.print("댓글제목:");
			String title = sc.nextLine();
			System.out.print("댓글:");
			String content = sc.nextLine();
			dao.reply(title, content, u_id, parentid);
		} else {
			start();
		}
	}

	public void menuTitle() {
		System.out.println("┌───────────   1. 전체리스트	──────────┐");
		System.out.println("│              2. 글 등 록         	  │");
		System.out.println("│              3. 글 수 정    		  │");
		System.out.println("│              4. 글 삭 제         	  │");
		System.out.println("│              5. 한건조회   	          │");
		System.out.println("│              6. 댓글추가   	          │");
		System.out.println("└───────────   0. 종   료        ──────────┘");

	}

}
