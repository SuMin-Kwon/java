package co.yedam.app;


public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalcGame game = new CalcGame();
		
		game.input();
		
		System.out.println(game.add());
		System.out.println(game.share());
		System.out.println(game.div());
		System.out.println(game.rest());
	}

}
