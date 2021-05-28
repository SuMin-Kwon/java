package co.yedam.score2;

public class AppMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScoreArrApp2 score = new ScoreArrApp2();
		// score.print();

		for (int i = 0; i < score.arr.length; i++) {
			System.out.println(i + "학생" +"총 과목:"+score.getSbjCnt(i) +
					" 총점:"+score.stdTotal(i));
		}
	}

}
