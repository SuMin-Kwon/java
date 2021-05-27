package co.yedam.app.gugudan;

public class AppMain {

	public static void main(String[] args) {
		GugudanApp gugudan = new GugudanApp();
		gugudan.printDan(3);
		System.out.println();
		gugudan.printAll();
		System.out.println();
		gugudan.printAllReverse();
		System.out.println();
		gugudan.printRange(3,5);
	}

}
