package co.yedam.star;

public class AppMain {
	public static void main(String[] args) {
		StarApp star = new StarApp();
		//star.draw(5);
		//star.drawInvert(5);
		//star.drawEq(7);
		
		
		star.drawTitle("나무",100);
		star.drawEq2(4);
		star.drawEq(2,6);
		star.drawEq(4,8);
		star.drawRect(4);
	}
}
