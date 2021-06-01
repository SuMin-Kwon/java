package 도형;

public class AppMain2 {

	/*
	 * 부모타입으로 넘기고 밑에 방식으로 변환해줌
	 * 
	 */
	
	public static void main(String[] args) {
									// 부모타입이 자식 객체 참조 가능
		Shape s = new Rect(4,5);    // 원래 Rect는 Rect가 와야하고 Circle은 Circle이 와야함
		execute(s);					// 그렇치만 굳이 힘들게 여러게 만들지 않기 위해 부모타입으로 넘김
		
		s = new Circle(4);
		execute(s);
		
	}
	// instanceof : 객체 타입을 boolean으로 확인할때 사용함
	public static void execute (Shape s) { // 값을 넘길때 부모타입으로 넘기면 굳이 자식껄로 여러개 만들필요 x
		if (s instanceof Drawable) {      // 다형성 : 참조대상의 메서드 호출
			((Drawable)s).draw();
		}
		if (s instanceof Movable) {
			((Movable)s).move();
		}
		s.area();  // area는 추상메서드임 기능은 없고 s = Rect , Circle 등 참조하는 객체에 따라서 실행결과가 다름
	
	}
	

}
