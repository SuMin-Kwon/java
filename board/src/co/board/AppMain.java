package co.board;

import java.util.Scanner;

import co.board.view.BoardApp;

public class AppMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String yn;
		BoardApp app = new BoardApp();
		while (true) {
			System.out.println("로그인 하시겠습니까?(y/n)");
			yn = scanner.next();
			if (yn.equals("y")) {
				if (app.rogin()) {
					app.start();
				} else {
					System.out.println("정보가 일치하지 않습니다.");
					continue;
				}
			} else {
				System.out.println("시스템종료");
				break;
			}
		}

	}

}
