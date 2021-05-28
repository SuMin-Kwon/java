package co.yedam.score;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// new 메모리 공간 할당이라는 뜻임
		// 인덱스는 0~9
		int[] arr= new int[10]; // int값 10개를 담겠다고 선언
		
		// 10개의 난수를 랜덤으로 뽑아서 배열방에 담아줌
		for (int i=0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*100)+1;
		}
		// 10개의 난수를 출력해봄
		for (int i=0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		// 합계
		int result = 0;
		for (int i=0; i < arr.length; i++) {
				result = result +arr[i];	
			}
		System.out.println("합계: "+result);
		
		
		int max =arr[0];
		for (int i=0; i < arr.length; i++) {
			if (max < arr[i] ) {
				max = arr[i];
				}
			}
		System.out.println("최대값은: "+ max);
		
		
		//최대값
		
		
		
		
		
		
	}

}
