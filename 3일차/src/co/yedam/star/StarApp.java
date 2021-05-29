package co.yedam.star;

public class StarApp {

	// 삼각형 출력 "*" * 3
	void draw(int cnt) {
		for (int i = 1; i <= cnt; i++) {
			System.out.println(pad('*', i));
		}
	}

	// (* , 10) --> "*********"
	String pad(char s, int c) {
		String result = "";
		for (int i = 1; i <= c; i++) {
			result += s;
		}
		return result;
	}
	
	
	void drawTitle(String a ,int cnt) {

		for (int i = cnt-1 ; i < cnt; i++) {
			System.out.println(pad('=', cnt/2));
			System.out.println(a);
			System.out.println(pad('=', cnt/2));

		}
	}

	void drawEq(int cnt, int ent) {
		for (int i = cnt; i < ent; i++) {
				System.out.print(pad(' ',((ent*2)-i)-(cnt*2)));
				System.out.println(pad('*', (i * 2) - 1));
			
			
		}
	}
	
	void drawEq2(int cnt) {
		for (int i = 0 ; i < cnt; i++) {
				System.out.print(pad(' ', (cnt*2)-i));
				System.out.println(pad('*', (i * 2) - 1));
			
			
		}
	}
	// 역삼각형
	void drawInvert(int cnt) {
		for (int i = 1; i <= cnt; i++) {
			System.out.println(pad('*', cnt + 1 - i));
		}
	}

	// 이등변삼각형
	void dia(int cnt) {
		for (int i = 1; i <= cnt; i++) {
			System.out.print(pad(' ', (cnt - i)));
			System.out.println(pad('*', (i * 2) - 1));
		}
		for (int i = 1; i <= cnt; i++) {
			System.out.print(pad(' ', i));
			System.out.println(pad('*', (((cnt - i) * 2) - 1)));
		}
	}


	void drawRect(int cnt) {

		for (int i = 1; i < cnt; i++) {
			System.out.print(pad(' ', (cnt / 2)+cnt));
			System.out.println(pad('*', cnt - 1));

		}

	}

//	void draw() {
//		for (int i=1; i < 9; i++) {
	// for (int j=1; j <= i; j++) {
	// System.out.print("*");
	// }
	// System.out.println();
	// }

}