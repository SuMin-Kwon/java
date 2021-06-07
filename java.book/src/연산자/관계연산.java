package 연산자;
/*
 * y는 증가 됐지만 x는 증가 안됨 
 * (이유 : &&연산은 둘다 true 여야지 처리를 하기 때문에 y만 처리하고 x는 처리 안함)
 * 
 */

public class 관계연산 {

	public static void main(String[] args) {

		int x = 10;
		int y = 10;
		// 첫번째 관계식이 false -> 두번째 관계식은 계산 안함.
		if ( y++ > 10 && x++ > 10) { // y++은 ++이 뒤에 있기 때문에 10보다 큰지 확인 후에 ++이 됨
			System.out.println("A");
		} else {
			System.out.println("B");
			
		}
		System.out.println(x);
		System.out.println(y);
		
		// || 도 틀린 조건식이라서 y만 ++ 함
		if ( y++ > 10 || x++ > 10) { 
			System.out.println("A");
		} else {
			System.out.println("B");
			
		}
		System.out.println(x);
		System.out.println(y);
		
		// |는 이항 연산이라서 관계식 두개는 모두 계산함
		// || 이랑 | 는 완전히 다른 값이 나오므로 주의!
		if ( y++ > 10 | x++ > 10) { 
			System.out.println("A");
		} else {
			System.out.println("B");
			
		}
		System.out.println(x);
		System.out.println(y);
	
	}

}
