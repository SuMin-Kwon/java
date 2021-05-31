package co.yedam.exam;

public class ExamScoreApp {
	
	public static void main(String[] args) {
		
		ExamScore exam = new ExamScore("1234",90,50,30);
		System.out.print(exam.isPass()?"합격":"불합격");
		
	}

}
