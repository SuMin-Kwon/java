package exam32;

public class App {
	static int count; // static 메서드를 사용할려면 필드에도 static 선언?

	public static void displayMsg() {
		count++; // line n1
		System.out.println("Welcome " + "Visit Count: " + count); // line n2
	}

	public static void main(String[] args) {
		App.displayMsg(); // line n3
		App.displayMsg(); // line n4
	}
}