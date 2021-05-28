package day01;

public class Hi {
	// main 함수(=메서드)가 프로그램을 시작하는 제일 처음 시작점
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((int) (Math.random() * 100));
		System.out.println((int) (Math.random() * 100));
	}
}
// 랜덤으로 수를 뽑음 소수 > *100 > 정수로 변환
// 한 문장을 끝날때 마다 세미콜론(;)을 찍어줘야함
// 변수에 값을 담을때 어떤 값을 담을지 타입을 설정해줘야함
// 사용할때 각 각의 맞는 바이트를 선택해서 넣어주는게 좋음 크다고 좋은게 아님
/*  python 			자바
					byte  : 127							1
 					short : 32000                       2
 					long								8
 	int(정수)		int a;  유효자릿수 21억까지 표현가능		4바이트	
 	float(실수)		float : 유효자릿수 6자리     			4바이트
 					double: 15자리 (배 정도 - 정밀도 배임)	8바이트
 	str(문자)''		char(한글자)
 		  	""		Stgring(문자열)
 bool(Treu/False)   boolean
*/