package co.yedam.score2;

public class ScoreArrApp2 {
	// 2차원 배열
	// 국어 영어 수학 ,4명의 학생
	int[][] arr = { { 100, 90, 100, 40 },
					{ 10, 20 },
					{ 50, 50, 50 }, 
					{ 30, 30, 30 } };

	void print() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
		}
	}

	// 입력한 번호의 한 한색의 총점을 계산

	int stdTotal(int no) {
		int result = 0;
		for (int i = 0; i < arr[no].length; i++) {
			result = result + arr[no][i];
		}
		return result;
	}
	
	// 해당 학생의 과목수
	int getSbjCnt(int no) {
		return arr[no].length;
		
	}
	

}
