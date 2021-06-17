package co.green.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import co.green.access.GreenAccess;
import co.green.access.GreenDAO;
import co.green.model.Board;
import co.green.model.Green;
import co.green.model.GreenGrow;
import co.green.model.GreenLogin;
import co.green.model.GreenMemo;

public class GreenCliApp {

	// login
	String id;
	String pw;
	String Nname;
	String jumin;
	String phone;
	int nums;

	String plantName = null; // 식물이름
	LocalDate date; // 날짜

	// 물주기, 가지치기, 영양제
	int plantWater = 0;
	int plantPruning = 0;
	int plantFood = 0;

	LocalDate waterDay;
	LocalDate pruningDay;
	LocalDate plantFoodDay;

	GreenAccess dao = new GreenDAO();
	Scanner scanner = new Scanner(System.in); // int, next
	Scanner sc = new Scanner(System.in); // nextLine

	// 현재날짜
	LocalDate localDate = LocalDate.now();

	// 현재날짜 스트링
	String nowDay = String.format("%1$tY-%1$tm-%1$td", localDate);

	// 키우기 시작한 날짜
	String growdate;

	// 상위 스타트
	public void topStart() {
		do {
			System.out.println("                        ┏━━━━━━━━━━━━━━━━━━━┓                     ");
			System.out.println("            START       ┃   ♣ GREEN APP ♣   ┃       THE END       ");
			System.out.println("                        ┗━━━━━━━━━━━━━━━━━━━┛                     ");
			loginNums();

		} while (nums != 0);
	}

	// 로그인 뷰
	public void loginNums() {
		String result = null;
		System.out.println("───────────────────────────────────────────────────────────────────────");
		System.out.println("     ♣  1) 로그인  2) 회원가입  3) 아이디 찾기  4) 비밀번호 찾기  0) 종료  ♣ ");
		System.out.println("───────────────────────────────────────────────────────────────────────");
		nums = readInt("입력");
		if (nums == 1) {
			login();
		} else if (nums == 2) {
			member();
		} else if (nums == 3) {
			System.out.println("━━━━━━━━━━━━━━━━  아이디 찾기  ━━━━━━━━━━━━━━━━");
			jumin = readStr(" 생년월일 , ex) 19990101");
			phone = readStr(" 휴대폰번호 , ex) 01012345678");
			ArrayList<GreenLogin> gl = ((GreenDAO) dao).LoginList();
			for (GreenLogin green : gl) {
				if (green.getU_jumin().equals(jumin) && green.getU_phone().equals(phone)) {
					result = green.getU_id();
				}
			}
			if (result != null) {
				System.out.println("찾으시는 아이디 : " + result);
			} else {
				System.out.println("일치하는 아이디가 없습니다.");
			}
			loginNums();
		} else if (nums == 4) {
			System.out.println("━━━━━━━━━━━━━━  비밀번호 찾기  ━━━━━━━━━━━━━━");
			id = readStr(" ID ");
			jumin = readStr(" 생년월일 , ex) 19990101");
			phone = readStr(" 휴대폰번호 , ex) 01012345678");
			ArrayList<GreenLogin> gl = ((GreenDAO) dao).LoginList();
			for (GreenLogin green : gl) {
				if (green.getU_id().equals(id) && green.getU_jumin().equals(jumin)
						&& green.getU_phone().equals(phone)) {
					result = green.getU_pw();
				}
			}
			if (result != null) {
				System.out.println("찾으시는 비밀번호 : " + result);
			} else {
				System.out.println("일치하는 비밀번호가 없습니다.");
			}
			loginNums();
		} else {
			System.exit(1);
		}
	}

	// 회원가입
	public void member() {
		System.out.println("━━━━━━━━━━━━━━  회원가입  ━━━━━━━━━━━━━━");
		id = readStr("[ 사용할 ID ]");
		ArrayList<GreenLogin> gl = ((GreenDAO) dao).LoginList();
		for (GreenLogin green : gl) {
			if (green.getU_id().equals(id)) {
				System.out.println("이미 존재하는 아이디입니다.");
				member();
			}
		}
		pw = readStr("[ 사용할 PW ]");
		System.out.println("[ 사용할 닉네임 ]");
		Nname = sc.nextLine();
		jumin = readStr("[ 생년월일 ] ex) 19990101");
		phone = readStr("[ 휴대폰번호 ] ex) 01012345678");
		dao.roginInsert(id, pw, Nname, jumin, phone);
		loginNums();
	}

	// 로그인
	public void login() {
		if (nums == 1) {
			id = readStr(" ID ");
			pw = readStr(" PW ");
			boolean R = dao.rogin(id, pw);
			if (R) {
				start();
			}
		} else {
			loginNums();
		}

	}

	// 메인메뉴 선택
	public void start() {
		while (true) {
			myPlant();
			menu();
			nums = readInt("입력");
			switch (nums) {
			case 1:
				myPage();
				break;
			case 2:
				plantMemo();
				break;
			case 3:
				selectPlant();
				break;
			case 4:
				plantBoard();
				break;
			case 5:
				plantBoard();
				break;
			case 0:
				System.out.println("시스템 종료");
				System.exit(-1);
			}
		}
	}

	// 메인메뉴
	public void menu() {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("   1) My Page    2) 성장기록    3) 키울 식물 선택    4) 식물정보    0) 종료");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

	}

	// 마이페이지
	private void myPage() {
		// 비밀번호 변경, 닉네임 변경, 키우는 식물 변경
		GreenLogin gl = dao.myPage(id);
		System.out.println("┌───────────  개인정보  ───────────┐");
		System.out.println();
		System.out.println("    아이디 > " + gl.getU_id());
		String pwpw = gl.getU_pw().substring(0, 2);
		String pwpw2 = gl.getU_pw().substring(2);
		System.out.print("    비밀번호 > " + pwpw);
		for (int i = 0; i < pwpw2.length(); i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println("    전화번호 > " + gl.getU_phone());
		System.out.println("    닉네임 > " + gl.getU_Nname());
		System.out.print("    키우는 식물 > ");
		ArrayList<GreenGrow> name = dao.myPlant(id);
		for (GreenGrow gg : name) {
			plantName = gg.getU_plant();
			System.out.print(plantName + " ");
		}
		if (plantName == null) {
			System.out.println("없음");

		}
		System.out.println();
		System.out.println("└────────────────────────────────┘");
		System.out.println();
		System.out.println("──────────────────────────────────────────────────────────────────────────────────");
		System.out.println("   1) 비밀번호 수정   2) 닉네임 수정   3) 키울 식물 추가   4) 키우는 식물 삭제   5) 이전으로");
		System.out.println("──────────────────────────────────────────────────────────────────────────────────");
		nums = readInt("입력");
		if (nums == 1) {
			String b_pw = readStr(" PW 다시 입력해주세요 ");
			if (b_pw.equals(pw)) {
				b_pw = readStr("변경할 비밀번호");
				dao.chagePw(b_pw, id);
				pw = b_pw;
				myPage();
			} else {
				System.out.println("비밀번호가 일치하지 않습니다!");
				myPage();
			}

		} else if (nums == 2) {
			String b_name = readStr("변경할 닉네임");
			dao.chageNname(b_name, id);
			myPage();
		} else if (nums == 3) {
			selectPlant();
			myPage();

		} else if (nums == 4) {
			System.out.println("※※※※※※※※※※※※※※※※※※※※");
			System.out.println(" 삭제할 식물 이름");
			String yn = sc.nextLine();
			dao.plantDelete(id, yn);
			plantName = null;
			myPage();
		} else if (nums == 5) {
			start();
		}

	}

	// 랜덤 문자열 뽑기
	public String getRandTestString() {

		String RandomNames[] = { "오늘도 식물키우기 도전!", "안녕하세요?", "기분 좋은 하루네요", "시작은 누구나 어렵습니다! 힘내세요~", "오늘은 얼마나 자랐나요?",
				"키우는 재미를 느껴보세요!", "작은정원을 만들어보세요~", "해야할 일은 항상 꼼꼼히 체크!" };

		Random oRandom = new Random();
		int randNum = oRandom.nextInt(RandomNames.length);
		return RandomNames[randNum];
	}

	// 로그인시 메인 화면 출력
	private void myPlant() {
		System.out.println();
		// 현재날짜
		System.out.println(" < " + localDate + " > ");

		// 로그인 정보에서 닉네임 가져오기
		ArrayList<GreenLogin> gl = ((GreenDAO) dao).LoginList();
		for (GreenLogin green : gl) {
			if (green.getU_id().equals(id)) {
				Nname = green.getU_Nname();
			}
		}
		// 닉네임 + 랜덤문구
		System.out.println(Nname + "님, " + getRandTestString());
		// 현재키우는 식물
		System.out.println();
		System.out.println("현재 키우는 식물: ");
		ArrayList<GreenGrow> name = dao.myPlant(id);
		for (GreenGrow gg : name) {
			plantName = gg.getU_plant();
			System.out.print(" [ " + plantName + " ] ");
			if (!(plantName == null)) {
				growDate();
				System.out.println();
			}
		}
		if (plantName == null) {
			System.out.print("  →  없음 ");
		}
		System.out.println();
		// 오늘 해야할일 : 물주기, 가지치기, 영양제체크 뜨도록
		System.out.print("오늘의 할일 : ");
		ArrayList<GreenGrow> name1 = dao.myPlant(id);
		for (GreenGrow gg : name1) {
			plantName = gg.getU_plant();
			if (!(plantName == null)) {
				waterDay();
				pruningDay();
				foodDay();
			}
		}
//		 조건 : 물,가지치기,영양제날이 모두 아닐때는 할일이 없음!
		if (plantName == null) {
			System.out.println("없음");
		} else if (!(waterDay.isEqual(localDate)) && !(pruningDay.isEqual(localDate))
				&& !(plantFoodDay.isEqual(localDate))) {
			System.out.println("없음");
		}
		System.out.println();
	}

	// 키운 날짜 체크
	public void growDate() {

		ArrayList<GreenGrow> gg = dao.GrowList();
		for (GreenGrow green : gg) {
			if (green.getU_id().equals(id) && green.getU_plant().equals(plantName)) {
				growdate = green.getGrowDate();
			}
		}
		Calendar bDate = Calendar.getInstance();
		Calendar nDate = Calendar.getInstance();

		int year = Integer.parseInt(growdate.substring(0, 4));
		int month = (Integer.parseInt(growdate.substring(5, 7))) - 1;
		int day = Integer.parseInt(growdate.substring(8));

		long days = 0;
		bDate.set(year, month, day);
		days = (nDate.getTimeInMillis() - bDate.getTimeInMillis()) / (24 * 60 * 60 * 1000);
		System.out.print("  ♣ 식물 키우기 " + (days + 1) + "일째");
	}

	// 물 주는 날!
	public void waterDay() {
		// 날짜 받아오기(선택한 날)
		String a = dao.wDate(id);
		// 스트링을 DATE로 변환
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.KOREA);
		date = LocalDate.parse(a, formatter);

		ArrayList<Green> list = dao.listAll();
		for (Green green : list) {
			if (green.getPlantName().equals(plantName)) {
				plantWater = green.getPlantWater();
			}
		}
		waterDay = date.plusDays(plantWater);
		if (waterDay.isEqual(localDate)) {
			System.out.print("[" + plantName + " 물 주는 날 ] ");
		} else if (waterDay.isBefore(localDate)) {
			dao.insertDate(nowDay, id);
		}
	}

	// 가지치기 하는 날!
	public void pruningDay() {
		// 날짜 받아오기(선택한 날)
		String a = dao.pDate(id);
		// 스트링을 DATE로 변환
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.KOREA);
		date = LocalDate.parse(a, formatter);

		ArrayList<Green> list = dao.listAll();
		for (Green green : list) {
			if (green.getPlantName().equals(plantName)) {
				plantPruning = green.getPlantPruning();
			}
		}
		pruningDay = date.plusDays(plantPruning);

		if (pruningDay.isEqual(localDate)) {
			System.out.print("[" + plantName + " 가지치는 날 ] ");
		} else if (pruningDay.isBefore(localDate)) {
			dao.insertPdate(nowDay, id);
		}
	}

	// 영양제 주는 날!
	public void foodDay() {
		// 날짜 받아오기(선택한 날)
		String a = dao.fDate(id);
		// 스트링을 DATE로 변환
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.KOREA);
		date = LocalDate.parse(a, formatter);

		ArrayList<Green> list = dao.listAll();
		for (Green green : list) {
			if (green.getPlantName().equals(plantName)) {
				plantFood = green.getPlantFood();
			}
		}
		plantFoodDay = date.plusDays(plantFood);

		if (plantFoodDay.isEqual(localDate)) {
			System.out.print("[" + plantName + " 영양제 주는 날 ] ");
		} else if (plantFoodDay.isBefore(localDate)) {
			dao.insertFdate(nowDay, id);
		}
	}

	// 식물 기록, 성장 메모
	private void plantMemo() {
		System.out.println("─────────────────────────────────────────");
		System.out.println(" 1) 오늘의 기록   2) 간단 메모   3) 이전으로 ");
		System.out.println("─────────────────────────────────────────");
		nums = readInt("입력");
		if (nums == 1) {
			System.out.println("1) 물주기(√)   2) 가치치기(√)   3) 영양제 체크(√)");
			nums = readInt("입력");
			// 물주기
			if (nums == 1) {
				System.out.println("물주기 성공!");
				dao.insertDate(nowDay, id);
			}
			// 가지치기
			else if (nums == 2) {
				System.out.println("가지치기 성공!");
				dao.insertPdate(nowDay, id);
			}
			// 영양제 체크
			else if (nums == 3) {
				System.out.println("영양제주기 성공!");
				dao.insertFdate(nowDay, id);
			}
		}
		// + 성장 메모
		else if (nums == 2) {
			memo();
		} else if (nums == 3) {
			start();
		}
	}

	// 성장메모
	public void memo() {
		while (true) {
			System.out.println("──────────────────────────────────────────────────────────────────");
			System.out.println("  1) 메모등록   2) 메모삭제   3) 메모전체조회   4) 메모검색   5) 메인메뉴로 ");
			System.out.println("──────────────────────────────────────────────────────────────────");
			nums = readInt("입력");
			switch (nums) {
			case 1:
				inserMemo();
				break;
			case 2:
				deleteMemo();
				break;
			case 3:
				memoList();
				break;
			case 4:
				findMemo();
				break;
			case 5:
				start();
				break;
			}
		}
	}

	// 메모찾기
	private void findMemo() {
		String find = readStr("찾을 단어");
		ArrayList<GreenMemo> gmList = dao.memoList(id);
		for (GreenMemo gm : gmList) {
			if (gm.getContent().contains(find)) {
				System.out.println(gm.memoPrint());
			} else if (gm.getTitle().contains(find)) {
				System.out.println(gm.memoPrint());
			}
		}
	}

	// 메모전체조회
	private void memoList() {
		ArrayList<GreenMemo> gmList = dao.memoList(id);
		for (GreenMemo gm : gmList) {
			System.out.println(gm.memoPrint());
		}
	}

	// 메모삭제
	private void deleteMemo() {
		System.out.println("※※※※※※※※※※※※※※※※※※※※※※※");
		String date = readStr("삭제할 메모 날짜 (ex)2021-01-01");
		System.out.println("삭제할 메모 제목");
		String title = sc.nextLine();
		dao.deleteMemo(id, date, title);
	}

	// 메모등록
	private void inserMemo() {
		System.out.println("제목");
		String title = sc.nextLine();
		System.out.println("내용");
		String content = sc.nextLine();
		dao.inserMemo(id, nowDay, title, content);
	}

	// 키울 식물 선택
	private void selectPlant() {
		ArrayList<Green> list = dao.listAll();
		System.out.println("━━━━━━━━━【  키울 식물 목록 】━━━━━━━━━");
		for (Green green : list) {
			System.out.println(green.getG_id() + ") " + green.getPlantName());
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		int selectNum = readInt("입력");
		for (Green green : list) {
			if (green.getG_id() == selectNum) {
//				dao.nameInsert(green.getPlantName(), id);
				dao.changeDate(nowDay, id, green.getPlantName());

			}
		}

	}

	// 식물등록
	private void insertPlant() {
		System.out.println("━━━━━━━━━【  새로운 식물 등록!  】━━━━━━━━━");
		System.out.println("등록할 식물 이름 >");
		String plantName = sc.nextLine();
		int plantWater = readInt("식물의 물 주기(day)");
		int plantPruning = readInt("식물의 가지치기 주기(day)");
		int plantFood = readInt("식물의 영양제 주기(day)");
		dao.insert(plantName, plantWater, plantPruning, plantFood);

	}

	// 식물도감
	private void plantInfo() {
		ArrayList<Green> list = dao.listAll();
		for (Green gr : list) {
			gr.print();
		}
	}

	// 식물 정보 게시판
	private void plantBoard() {
		while (true) {
			System.out.println("─────────────────────────────────────────────────────────────");
			System.out.println("  1) 식물도감   2) 새로운 식물 등록   3) 정보 공유   4) 메인메뉴로 ");
			System.out.println("─────────────────────────────────────────────────────────────");
			nums = readInt("입력");
			switch (nums) {
			case 1:
				plantInfo();
				break;
			case 2:
				insertPlant();
				break;
			case 3:
				infoBoard();
				break;
			case 4:
				start();
				break;
			}
		}
	}

	// 게시판 메뉴
	private void infoBoard() {
		while (true) {
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("  1) 정보 게시판   2) 게시글 등록   3) 게시글 삭제   4) 메인메뉴로");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			nums = readInt("입력");
			switch (nums) {
			case 1:
				allBoard();
				break;
			case 2:
				boardInsert();
				break;
			case 3:
				boardDelete();
				break;
			case 4:
				start();
				break;
			}
		}
	}

	// 정보게시판 전체리스트
	private void allBoard() {
		// 전체보기
		ArrayList<Board> list = dao.allBoard();
		for (Board board : list) {
			System.out.println(board.showInfo());
		}
		while (true) {
			System.out.println("───────────────────────────────────────────────────");
			System.out.println("  1) 상세보기   2) 단어검색   3) 이전으로   4) 메인메뉴 ");
			System.out.println("───────────────────────────────────────────────────");
			nums = readInt("입력");
			if (nums == 1) {
				nums = readInt("상세보기 글 번호");
				System.out.println(dao.findDate(nums).showFind());
				List<Board> list1 = dao.replyShow(nums);
				for (Board board : list1) {
					System.out.println("   ▶  " + board.getB_content());
				}
				System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
				System.out.println("  1) 댓글 추가   2) 이전으로");
				System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
				int replyN = readInt(" > ");
				if (replyN == 1) {
					reply();
				} else if (replyN == 2) {
					allBoard();
				}

			} else if (nums == 2) {
				findBoard();
			} else if (nums == 3) {
				infoBoard();
			} else if (nums == 4) {
				start();
			} else {
				System.out.println("잘못 입력하셨습니다!");
			}
		}

	}

	// 댓글추가
	private void reply() {
		System.out.print("댓글제목 :");
		String title = sc.nextLine();
		System.out.print("댓글 :");
		String content = sc.nextLine();
		dao.reply(title, content, id, nums);
	}

	// 단어검색
	private void findBoard() {
		String find = readStr("찾을 단어");
		ArrayList<Board> list = dao.allBoard();
		for (Board board : list) {
			if (board.getB_content().contains(find)) {
				System.out.println(board.showFind());
			} else if (board.getB_title().contains(find)) {
				System.out.println(board.showFind());
			}
		}
	}

	// 게시글등록
	private void boardInsert() {
		System.out.println("제목: ");
		String b_title = sc.nextLine();
		System.out.println("내용 (이용방법) 글 작성완료 후 한칸 띄우고 .end 작성 후 ENTER! ");
		String b_content = readMultiLine();
		dao.insert(b_title, b_content, id);
	}

	// 게시글 삭제
	private void boardDelete() {
		System.out.println("※※※※※※※※※※※※");
		int b_id = readInt(" 삭제할 글번호 입력");
		boolean e = dao.roginTrueKey(b_id, id);
		if (e) {
			dao.delete(b_id);
			dao.replyDelete(b_id); // 댓글 삭제
		} else {
			System.out.println("권한이 없습니다");
		}
	}

	// INT 입력
	public int readInt(String prompt) {
		System.out.println(prompt + ">");
		return readInt();
	}

	public int readInt() {
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

	// Str 입력
	public String readStr(String prompt) {
		System.out.println(prompt + ">");
		return readStr();
	}

	public String readStr() {
		String result = "";
		try {
			result = scanner.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	// 길게 작성
	public String readMultiLine() {
		StringBuffer result = new StringBuffer();
		try {
			String a = "";
			while (true) {
				a = scanner.next();
				if (a == null || a.trim().equals(".end")) {
					break;
				}
				result.append(a).append(" ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}
}
