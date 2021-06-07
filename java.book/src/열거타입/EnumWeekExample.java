package 열거타입;

/*
 *  enum도 하나의 객체 타입이라고 생각하면 됨
 */
import java.util.Scanner;

public class EnumWeekExample {

	public static void main(String[] args) {

		// 1. 요일명을 저장하는 변수가 필요함
		// String week = "SUA"; --> 직접 변수를 주면 오타가 생길 확률이 있슴

		// 2. 배열
		// String [] week = { "MON","TUE","WED","THU","FRI", "SAT","SUN" };
		// String today = week[0]; // 배열로 쓰면 값을 알려면 일일이 찾아봐야함

		// 3. enum
//		Week today = Week.SUN; // enum 이름 쓰고 . 누르면 안에 들어있는 상수값을 가져올수 있슴
		Scanner sc = new Scanner(System.in);
		MENU menu = null;
		// int menu; //do - while 문 바깥에서 menu를 설정해야지만 while에도 menu가 들어감 (do 안에서 menu
		// 변수주면 지역변수가 되어서 while 에서는 사라짐)
		do {

			MENU.print();
			int menuno = sc.nextInt();
			menu = MENU.getMenu(menuno);
			switch (menu) {
			case 등록:
				System.out.println("등록");
				break;
			case 수정:
				System.out.println("수정");
				break;
			case 삭제:
				System.out.println("삭제");
				break;
			case 조회:
				System.out.println("조회");
				break;
			}
		} while (menu != MENU.종료);
		System.out.println("end");
	}

}
