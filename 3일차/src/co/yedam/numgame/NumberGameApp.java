package co.yedam.numgame;

import java.util.Scanner;

/*
 * 숫자 맞추기 게임 
 * 작성자: 권수민 /ㅇㅇㅇㅇㅇㅇㅇㅇ
 */
public class NumberGameApp {

	Scanner scanner = new Scanner(System.in);
	int com;
	int user; // 사용자가 입력한 값을 저장할곳

	// 컴퓨처가 임의 수를 생성함
	void init() {
		com = (int) (Math.random() * 9) + 1;

	}

	// 사용자가 수를 입력
	void input() {

		// scanner 이용해서 정수값 입력
		System.out.println("===========(0 ~ 9)");
		System.out.print("숫자 입력: ");
		user = scanner.nextInt();
		return;

	}

	// 높다 /낮다 비교 정답은 :true / 틀리면 false

	boolean con() {
		// 컴과 user을 비교해서 같으면 트루 리턴
		// 다르면 높다 낮다를 출력하고 false 리턴

		if (com == user) {
			System.out.println("IT스럽군요! 정답;D");
			return true;
		} else {
			if (com > user) {
				System.out.println("너무 낮아요 ·_·");
			} else {
				System.out.println("너무 높아요 -~-");
			}
			return false;
		}

	}
	
	boolean confirmStart() {
		System.out.println("게임을 시작할까요?(y/n)");
		char re = scanner.next().charAt(0);
		if ((re == 'y') || (re == 'Y')) {
			return true;
		}
		else {
			System.out.println("종료");
			return false;
		}
	}
	
	
	void start() {
		while(true){// 리스타트 넣어주기 (while 바깥에 한번더 while 넣으면됨)
			if (confirmStart()) {	
			init(); // 컴터 임의 수만듬s
			while (true) { // 맞을때까지 돌림
					input();
					if (con()) {
						break;
					}
				
				}
			}
			else {
				break;
			}
		}
	}

}
