package co.yedam.score;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScoreArrApp score = new ScoreArrApp();  
		//System.out.print("성적: ");
		//score.print();
		score.printH();
		System.out.println();
		System.out.printf("%s\n%04d","총점",score.total());
		System.out.println();
		System.out.printf("평균: %-6.2f ",score.avg());
	}

}
