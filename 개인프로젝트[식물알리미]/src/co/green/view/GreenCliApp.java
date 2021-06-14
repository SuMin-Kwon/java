package co.green.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import co.green.access.GreenAccess;
import co.green.access.GreenDAO;
import co.green.model.Green;

public class GreenCliApp {

	String id;
	String pw;
	String Nname;
	int nums;

	GreenAccess dao = new GreenDAO();
	Scanner scanner = new Scanner(System.in); 		// int, next
	Scanner sc = new Scanner(System.in);			// nextLine
	
	LocalDate localDate = LocalDate.now();
	
	
	// 상위 스타트
	public void topStart() {

		do {
			loginView();
			System.out.println("입력 > ");
			nums = scanner.nextInt();
			login();

		} while (nums != 0);
	}

	// 로그인 뷰
	public void loginView() {
		System.out.println();
		System.out.println("< GREEN APP >");
		System.out.println("1) 로그인   2) 회원가입   0) 종료");
	}

	// 로그인
	public void login() {		
		if (nums == 1) {
			System.out.println("id :");
			id = scanner.next();
			System.out.println("pw :");
			pw = scanner.next();
			boolean R = dao.rogin(id, pw);
			if (R) {
				start();
			} else {
				login();
			}
		} else if (nums == 2) {
			System.out.println("--------회원가입---------");
			System.out.println("사용할 ID:");
			id = scanner.next();
			System.out.println("사용할 PW:");
			pw = scanner.next();
			System.out.println("사용할 닉네임:");
			Nname = scanner.next();
			dao.roginInsert(id,pw,Nname);
		} else {
			System.exit(1);
		}

	}
	
	// 메인메뉴
	public void menu() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("1) MY PLANT  2) 성장메모  3) 식물선택  4) 식물 등록  0) 종료");
		System.out.println("--------------------------------------------------------------");
	}

	// 메인메뉴 선택
	public void start() {
		while (true) {
			menu();
			System.out.println("입력> ");
			nums = scanner.nextInt();
			switch(nums) {
			case 1 : myPlant();			break;
			case 2 : PlantMemo();		break;
			case 3 : selectPlant();		break;
			case 4 : insertPlant();		break;
			case 0 : 		
				System.out.println("시스템 종료");
				System.exit(-1);
			}
		}
	}

	private void myPlant() {
		System.out.println("< " + localDate + " > ");
		System.out.println("키우기 식물: " + dao.myPlant(id) );
		// 오늘 해야할일 : 물주기, 가지치기, 병충해관리 뜨도록
		
	}

	private void PlantMemo() {
		// TODO Auto-generated method stub
		
	}

	private void selectPlant() {
		ArrayList<Green> list = dao.listAll();
		System.out.println("------식물 목록------");
		for (Green green : list) {
			System.out.println(green.getG_id() + ") " + green.getPlantName());
		}System.out.println("---------------------");
		System.out.println("입력 > ");
		int selectNum = scanner.nextInt();
		for (Green green : list) {
			if (green.getG_id() == selectNum) {
				dao.nameInsert(green.getPlantName(),id);
			}
		}

		
		
	}

	private void insertPlant() {
		System.out.println("< 새로운 식물 등록! >");
		System.out.println("등록할 식물 이름: ");
		String plantName = sc.nextLine();
		System.out.println("식물의 물 주기(day): ");
		int plantWater = scanner.nextInt();
		System.out.println("식물의 가지치기 주기(day): ");
		int plantPruning = scanner.nextInt();
		System.out.println("식물의 병충해 주기(day): ");
		int plantFood = scanner.nextInt();
		dao.insert(plantName,plantWater,plantPruning,plantFood);
				
	}


	
	

}
