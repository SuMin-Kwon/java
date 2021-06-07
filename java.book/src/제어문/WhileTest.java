package 제어문;

public class WhileTest {

	public static void main(String[] args) {

		// 1 ~ 10 합계 for문
		int sum = 0;
		for (int i =1; i <= 10; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		
		// 위의 식을 while 문
		int i = 1;
		sum = 0;
		// i 증가를 안해주면 계산 무한 루프
		while (i <= 10) {
			sum += i;
			i++;
		}
		System.out.println(sum);
		
		// do - while 문 : 무조건 한번은 실행하고 조건을 비교함
		sum = 0;
		i = 1;
		do {
			sum =+ i;
			i++;
		} while(i <=10);
		System.out.println(sum);
	}

}
