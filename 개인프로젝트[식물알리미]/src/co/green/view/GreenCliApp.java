package co.green.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import co.green.access.GreenAccess;
import co.green.access.GreenDAO;
import co.green.model.Green;
import co.green.model.GreenLogin;

public class GreenCliApp {

	// login
	String id;
	String pw;
	String Nname;
	String jumin;
	String phone;
	int nums;

	String plantName; // 식물이름
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
			id = readStr( " ID ");
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
		System.out.println("--------회원가입---------");
		id = readStr("[ 사용할 ID ]");
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
				insertPlant();
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
		System.out.println("   1) My Page    2) 성장기록    3) 키울 식물선택    4) 식물정보    0) 종료");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

	}

	// 마이페이지
	private void myPage() {
		// 비밀번호 변경, 닉네임 변경, 키우는 식물 변경
		GreenLogin gl = dao.myPage(id);
		System.out.println("┌───────  개인정보  ───────┐");
		System.out.println();
		System.out.println("  아이디 > " + gl.getU_id());
		String pwpw = gl.getU_pw().substring(0,2);
		String pwpw2 = gl.getU_pw().substring(2);
		System.out.print("  비밀번호 > " + pwpw);
		for (int i=0; i < pwpw2.length(); i++ ) {
			System.out.print("*");
		}System.out.println();
		System.out.println("  전화번호 > " + gl.getU_phone());
		System.out.println("  닉네임 > " + gl.getU_Nname());
		System.out.println("  키우는 식물 > " + gl.getU_plant());
		System.out.println();
		System.out.println("└────────────────────────┘");
		System.out.println();
		System.out.println("1) 비밀번호 수정   2) 닉네임 수정   3) 식물 수정   4) 이전으로");
		nums = readInt("입력");
		if (nums == 1) {
			
		}else if (nums == 2) {
			
		}else if (nums == 3) {
			
		}else if (nums == 4) {
			start();
		}
		
	}

	// 로그인시 메인 화면 출력
	private void myPlant() {
		System.out.println();
		// 현재날짜
		System.out.println("< " + localDate + " > ");

		// 로그인 정보에서 닉네임 가져오기
		ArrayList<GreenLogin> gl = ((GreenDAO) dao).LoginList();
		for (GreenLogin green : gl) {
			if (green.getU_id().equals(id)) {
				Nname = green.getU_Nname();
			}
		}
		// 닉네임
		System.out.println(Nname + "님, 오늘도 식물키우기 도전! ");

		// 현재키우는 식물
		plantName = dao.myPlant(id);
		System.out.println("현재 키우는 식물: " + plantName);
		
		// 오늘 해야할일 : 물주기, 가지치기, 영양제체크 뜨도록
		System.out.print("오늘의 할일 : ");
		if (!plantName.equals("없음")) {
			waterDay();
			pruningDay();
			foodDay();
			// 조건 : 물,가지치기,영양제날이 모두 아닐때는 할일이 없음!
			if(!(waterDay.isEqual(localDate)) && 
			   !(pruningDay.isEqual(localDate)) && 
			   !(plantFoodDay.isEqual(localDate))) {
				System.out.print("없음");
			}	
		}
		System.out.println();
	}

	// 물 주는 날!
	public void waterDay() {
		// 날짜 받아오기(선택한 날)
		String a = dao.wDate(plantName);
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
			System.out.print(" [ 물 주는 날 ] ");
		} else if(waterDay.isBefore(localDate)) {
			dao.insertDate(nowDay, plantName);
		} 
	}
	
	// 가지치기 하는 날!
	public void pruningDay() {
		// 날짜 받아오기(선택한 날)
		String a = dao.pDate(plantName);
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
			System.out.print(" [ 가지치는 날 ] ");
		} else if(pruningDay.isBefore(localDate)) {
			dao.insertPdate(nowDay, plantName);
		}
	}
	
	// 영양제 주는 날!
	public void foodDay() {
			// 날짜 받아오기(선택한 날)
			String a = dao.fDate(plantName);
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
				System.out.print(" [ 영양제 주는 날 ] ");
			} else if(plantFoodDay.isBefore(localDate)) {
				dao.insertFdate(nowDay, plantName);
			}
		}

	// 식물 기록, 성장 메모
	private void plantMemo() {
		System.out.println("1)오늘의 기록   2) 성장 메모");
		nums = readInt("입력");
		if (nums == 1) {
			System.out.println("1) 물주기(√)   2) 가치치기(√)   3) 영양제 체크(√)");
			nums = readInt("입력");
			// 물주기
			if (nums == 1) {
				System.out.println("물주기 성공!");
				dao.insertDate(nowDay, plantName);
			}
			// 가지치기
			else if (nums == 2) {
				System.out.println("가지치기 성공!");
				dao.insertPdate(nowDay, plantName);
			}
			// 영양제 체크
			else if (nums == 3) {
				System.out.println("영양제주기 성공!");
				dao.insertFdate(nowDay, plantName);
			}
		}
		// + 성장 메모
		else if (nums == 2) {

		}
	}

	// 키울 식물 선택
	private void selectPlant() {
		ArrayList<Green> list = dao.listAll();
		System.out.println("------식물 목록------");
		for (Green green : list) {
			System.out.println(green.getG_id() + ") " + green.getPlantName());
		}
		System.out.println("---------------------");
		int selectNum = readInt("입력");
		for (Green green : list) {
			if (green.getG_id() == selectNum) {
				dao.nameInsert(green.getPlantName(), id);
				dao.insertDate(nowDay, selectNum);

			}
		}

	}

	// 식물등록
	private void insertPlant() {
		System.out.println("< 새로운 식물 등록! >");
		System.out.println("등록할 식물 이름: ");
		String plantName = sc.nextLine();
		int plantWater = readInt("식물의 물 주기(day):");
		int plantPruning = readInt("식물의 가지치기 주기(day):");
		int plantFood = readInt("식물의 병충해 주기(day):");
		dao.insert(plantName, plantWater, plantPruning, plantFood);

	}

	// 식물 정보 게시판
	private void plantBoard() {
		// 1) 정보 게시판 2) 정보 검색 3) 식물키움정보
		// 단어 검색시 정보검색

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

}
