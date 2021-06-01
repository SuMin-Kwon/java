package 배열;

import java.awt.Point;

public class 객체배열 {

	public static void main(String[] args) {
		//변수 선언
		Score []a;
		a = new Score[10];
		a[0] = new Score("홍길동", 100, 90, 80);
		a[1] = new Score("권수민", 100, 95, 85);
		a[2] = new Score("박기자", 65 , 45, 55);
		
		for (int i =0; i < a.length; i++) {
			if (a[i] != null) {    				// 2번방이후에는 비어있는 null값이므로 에러 안뜨게 하기 위해
			System.out.println(a[i].name);		// 조건문을 걸어줌 ,  null 아닌 값이 들어있는 것만 출력
			}
		}
		
		// 선언과 동시에 초기화
		Score[] b = {
				new Score("홍길동", 100, 90, 80),
				new Score("권수민", 100, 95, 85),
				new Score("박기자", 65 , 45, 55)
		};
		// * 일반 for문
//		for (int i =0; i < b.length; i++) {
		//System.out.println(b[i].name + " : "+ b[i].total);
		
		
		// in 배열 변수 ( : >> 반복하는 연산자를 가르킴)  * 확장 for문
		for (Score score : b ) {
			System.out.println(score.name + " : "+ score.total);
			}
		// 이미 선언과 동시에 배열에 3개의 객체만 들어갔으므로 굳이 if 넣을 필요 없슴
		
		
		
		//객체 배열
		Point[] c = {
				new Point(10, 10),
				new Point(10, 30),
				new Point(30, 30),
				new Point(30, 10)
			}; 
		
		for (Point point : c) {
			System.out.println(point.x + " " + point.y);  // 그냥 x +y 하면 int라서 더하기됨. 중간에 문자값을 넣어주기!
		}
	
	
	
	
	
	}
	
	
	
	
	
}
