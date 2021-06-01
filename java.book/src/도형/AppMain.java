package 도형;

public class AppMain {

	public static void main(String[] args) {

		/*
		 *  Rect[] s = new Rect[10]; 하면 
		 *  Rect 밖에 안되지만
		 *  Shape[] s = new Rect[10]; 하면
		 *  중간에 두번 선언할 필요가 없음
 		 */
		
//		

		Drawable[] s = new Drawable[3]; // 인터페이스도 사용가능
		s[0] = new Rect(4,5);  	
		// 자식타입 부모타입으로 자동형 변환
		// 왜냐면 자식이 부모꺼까지 상속받기 때문에 메모리가 더 큼
		// 그래서 변환가능
		// 그렇치만 부모타입을 자식으로 형변환할때는
		// 강제형 변환 해줘야함
		s[1] = new Circle(5);
		s[2] = new Tri(4,5);
		
		for (Drawable temp : s ) {
			temp.draw();
//			if (temp instanceof Rect) {
//			    ((Rect)temp).area(); // 이런식으로 강제 변환해줘야함
//			    ((Rect)temp).print();
			// 부모타입을 자식타입으로 강제형변환
//			} else if (temp instanceof Circle) {
//				((Circle)temp).area();
//			} else if (temp instanceof Tri) {
//				((Tri)temp).area();
//			}
			
			//↗ 위에 문장과 동일함
			if (temp instanceof Shape) {
				((Shape)temp).area();
				((Shape)temp).print();
			}
			
			
			if (temp instanceof Movable) {
				((Movable)temp).move();
			}		
			
		}
		
		
	}

}
