package 연산자;
/*
 *  ^ : xor -> 서로 다르면 1  (암호화)
 *  & : and -> 마스크 (서브넷마스크 and연산을 생각하면 됨)
 *  | : or  -> 서로 다르면 0
 */
public class 비트연산 {

	public static void main(String[] args) {

		// 암호화,복호화 할때 주로 쓰임 (비트연산)
		int a = 04474;			// 8진수
		int key = 01111;
		System.out.println("원문:"+ a);
		
		int b = a ^ key;
		System.out.println("암호화:" +b);
		
		int c = b ^ key;
		System.out.println("복호화:"+c);
		
		int d = 0b10101111; //  2진수
		int e = 0b00000010; // d의 맨 끝값에 값을 알고자 할때 앞에는 다 0을 주고 마지막에 1을 줌
		System.out.println(d & e);
		System.out.println(Integer.toBinaryString(d & e)); 
		
		// 쉬프트 연산
		int f = 8;   // 8 = 1000
		System.out.println(f >> 1);   // 1000 ->  0100  = 나누기 2를 한것과 같음 , 그냥 계산보다 속도가 더 빠름 
		System.out.println(f >> 2);   // 나누기 2를 두번하는거임
		System.out.println(f << 1);   // x 2				
		
		
	}

}
