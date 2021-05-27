package co.yedam.app.score;

public class ForTest {

	public static void main(String[] args) {
		int i =10;
		while ( i > 0 ) {
			System.out.println(i+"번째 "+"헬로우");
			i=i-2;
		}
		System.out.println("-------------------");
		int e = 10;
		for (; e > 0; ) {
			for (int j =1; j <=9; j++) {
				System.out.println(e+j+"\t");
			}
			System.out.println();
		}
	}

}
