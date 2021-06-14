package co.green.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import co.green.access.GreenAccess;
import co.green.access.GreenDAO;
import co.green.model.Green;
import co.green.model.GreenLogin;

public class GreenCliApp {

	String id;
	String pw;
	String Nname;
	String jumin;
	String phone;
	int nums;

	GreenAccess dao = new GreenDAO();
	Scanner scanner = new Scanner(System.in); // int, next
	Scanner sc = new Scanner(System.in); // nextLine

	LocalDate localDate = LocalDate.now();

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

	// 상위 스타트
	public void topStart() {

		do {
			System.out.println("< GREEN APP >");
			loginNums();

		} while (nums != 0);
	}

	// 로그인 뷰
	public void loginNums() {
		String result = null;
		System.out.println("1) 로그인  2) 회원가입  3) 아이디 찾기  4) 비밀번호 찾기  0) 종료");
		nums = readInt("입력");
		if(nums == 1 ) {
			login();
		} else if(nums == 2) {
			member();
		} else if(nums == 3) {
			System.out.println("------------아이디 찾기--------------");
			jumin = readStr("[ 주민번호 ] ex) 19990101");
			phone = readStr("[ 휴대폰번호 ] ex) 01012345678");
			ArrayList<GreenLogin> gl = ((GreenDAO) dao).LoginList();
			for (GreenLogin green : gl) {
				if (green.getU_jumin().equals(jumin) &&
					green.getU_phone().equals(phone))
				{
					result = green.getU_id();}
				}
			if (result != null) {
				System.out.println("찾으시는 아이디 : "+ result);
			}else {
				System.out.println("일치하는 아이디가 없습니다.");
			}
			loginNums();
		} else if(nums == 4) {
			System.out.println("------------비밀번호 찾기--------------");
			id = readStr("[ ID ]");
			jumin = readStr("[ 주민번호 ] ex) 19990101");
			phone = readStr("[ 휴대폰번호 ] ex) 01012345678");
			ArrayList<GreenLogin> gl = ((GreenDAO) dao).LoginList();
			for (GreenLogin green : gl) {
				if (green.getU_id().equals(id) && 
					green.getU_jumin().equals(jumin) &&
					green.getU_phone().equals(phone))
				{
					result = green.getU_pw();
				}
			}
			if (result != null) {
				System.out.println("찾으시는 비밀번호 : "+ result);
			}else {
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
		jumin = readStr("[ 주민번호 ] ex) 19990101");
		phone = readStr("[ 휴대폰번호 ] ex) 01012345678");
		dao.roginInsert(id, pw, Nname,jumin,phone);
		loginNums();
	}
	
	// 로그인
	public void login() {
		if (nums == 1) {
			id = readStr("[ ID ]");
			pw = readStr("[ PW ]");
			boolean R = dao.rogin(id, pw);
			if (R) {
				start();
			}
		} else {
			loginNums();
		}

	}

	// 메인메뉴
	public void menu() {
		System.out.println("------------------------------------------------------------------");
		System.out.println("1) My Page  2) 성장기록  3) 키울 식물선택  4) 식물보감  5) 정보 게시판  0) 종료");
		System.out.println("------------------------------------------------------------------");
	}

	// 메인메뉴 선택
	public void start() {
		while (true) {
			myPlant();
			menu();
			nums = readInt("입력");
			switch (nums) {
			case 1: myPage(); 	 	break;
			case 2: plantMemo();	break;
			case 3: selectPlant();  break;
			case 4: insertPlant();  break;
			case 5: plantBoard(); 	break;	
			case 0:
				System.out.println("시스템 종료");
				System.exit(-1);
			}
		}
	}

	// 마이페이지
	private void myPage() {
		// 비밀번호 변경, 닉네임 변경, 키우는 식물 변경
	}

	// 로그인시 메인 화면 출력
	private void myPlant() {
		System.out.println("< " + localDate + " > ");
		ArrayList<GreenLogin> gl = ((GreenDAO) dao).LoginList();
		for (GreenLogin green : gl) {
			if(green.getU_id().equals(id)) {
				Nname = green.getU_Nname();
			}
		}
		System.out.println(Nname + "님, 오늘도 식물키우기 도전! "); // 닉네님,랜덤문구
		System.out.println("키우기 식물: " + dao.myPlant(id));
		System.out.println();
		// 오늘 해야할일 : 물주기, 가지치기, 병충해관리 뜨도록

	}
	
	// 식물 기록, 성장 메모
	private void plantMemo() {
		//   + 기록 등록  >  물주기 , 가지치기, 병충해
		// 	 + 성장 메모 
	}

	// 키울 식물 선택
	private void selectPlant() {
		ArrayList<Green> list = dao.listAll();
		System.out.println("------식물 목록------");
		for (Green green : list) {
			System.out.println(green.getG_id() + ") " + green.getPlantName());
		}   System.out.println("---------------------");
		int selectNum = readInt("입력");
		for (Green green : list) {
			if (green.getG_id() == selectNum) {
				dao.nameInsert(green.getPlantName(), id);
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
		// 1) 정보 게시판  2) 정보 검색  3) 식물키움정보
		// 단어 검색시 정보검색
		
	}
}
