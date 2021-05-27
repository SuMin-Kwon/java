package co.yedam.app.score;


public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScoreApp score = new ScoreApp();
		
		score.Input();
		
		System.out.println(
				"총합계"+ score.getSum() + ":" + 
				" 평균" + score.getAvg() + ":" +
				" 등급: " + score.getGrade());
		System.out.println(
				"합격여부: " + (score.isPass()? "합격" : "불합격"));
				
	}

}
