package 배열;
/*
 *   배열 : 크기고정
 *   순차적으로 데이터를 저장하고 읽는 용도
 *   추가 /삭제가 번거로움
 */

public class 배열초기화 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1차원 배열 
		// 1. 배열 선언 - 순차적
		int []a;  /// = int a[];  객채 -> new 힙 메모리 할당 해야지 사용 가능
		a = new int [10]; // 사용가능한 범위를 정해줌
		// 배열값을 초기화 (아무값도 주지 않으면 0으로 설정되어있슴)
		
		
		a[0] = 10; // 인덱스 0~ 9 까지의 값을 넣을수 있슴
		a[1] = 20;  
		a[2] = 100;  
		a[3] = 50; // 보통 배열은 for문이랑 같이 쓰임
		
	
		//배열 출력
		for (int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		} 
		// 삭제(삭제하고 싶은 인덱스 다음부터 앞으로 이동)
		for (int i =2; i <a.length; i++) {
			a[i-1] = a[i];
		}
		
		for (int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}  // 2번방이 삭제된것을 알수 있슴
		
	
		// 배열 선언과 초기화를 한꺼번에
		int [] b = {78,70,50}; // =  new int[3]{78,70,50}   > [3]은 생략가능함
		System.out.println("크기는"+ b.length);
	
	
	}
	
	
	

}
