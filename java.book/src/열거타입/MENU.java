package 열거타입;

/*
 *  ()enum 값을 받으려면 생성자를 만들어줘야함
 */
public enum MENU {

	등록(1), 수정(2), 삭제(3), 조회(4), 종료(0);

	private int value;

	// 생성자
	private MENU(int value) {
		this.value = value;
	}

	private int getValue() {
		return value;
	}

	public static void print() {
		MENU[] arr = MENU.values();
		for (MENU m : arr) {
			System.out.print(m.value + ":" + m + "  ");
		}
	}

	public static MENU getMenu(int v) {
		MENU[] arr = MENU.values();
		for (MENU m : arr) {
			if (m.getValue() == v) {
				return m;
			}
		} return null;
	}
}
