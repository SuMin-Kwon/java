package co.yedam.app;
/*
 * 연산자 테스트
 * 논리 : and(&&) or (||)
 * a++   --->  a = a + 1
 * ++a 차이가 있슴  
 * 조건 ? true : false    ---> if 조건 : 
 * 								...
 * 							  else :
 * 								...
 */
public class OperatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		//증가 연산자
		int x = 1;
		int y = 1;
		//int result1 = ++x + 10;  // + 연산전에 증가하고
		//int result2 = y++ + 10;  // + 연산하고 나서 y만 증가함
		int result3 = ++x + y++;
	//	System.out.println(String.format("x= %d 결과= %d",x, result1));
	//	System.out.println("y= "+ y + " 결과= "+ result2);
		System.out.println("++x + y++ 결과= "+ result3);
		
		//논리연산
		System.out.println(x > 0 && y >0);
		System.out.println(x == 0 && y ==0);
		System.out.println(!(x == 0 && y ==0));
		System.out.println(! (x == 0) || !(y == 0));
		
		x = 3;
		
		//삼항연산
		System.out.println(x > 0 && y >0 ? "둘다 양수": "둘다 음수");
		System.out.println(x%2 == 0 ? "짝수": "홀수");
		System.out.println(!(x > y) ? "x가 크다": "x가 작다");
	}

}
