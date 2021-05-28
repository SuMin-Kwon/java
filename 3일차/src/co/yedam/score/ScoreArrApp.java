package co.yedam.score;
/*
 * 1. 클래스 설계도(UML)
 * 2. 클래스 선언
 * 3. new 객체 생성
 * 4. /.메소드호출()/ 객체 이용
 */




public class ScoreArrApp {

	int[] arr = {95,87,67};
	
	void print() {
		for (int i=0; i <arr.length; i++) {
			System.out.printf("%d ",arr[i]);
		}
		System.out.println();
	}
	int total() {
		int result = 0;
		for (int i=0; i < arr.length; i++) {
			result = result + arr[i];
		}
		
		return result;
	}
	double avg() {
		double result = 0;
		result = total() / (double)arr.length;
		return result;
	}
	void printH() {
		System.out.printf("%s\n국어:%-6d\t영어:%-6d\t수학:%-6d","홍길동 성적",arr[0],arr[1],arr[2]);
	}
}
