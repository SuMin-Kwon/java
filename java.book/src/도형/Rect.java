package 도형;
/*
 * 인터페이스는 다중 상속 가능함
 */
public class Rect extends Shape implements Drawable, Movable {

	int h;
	

	public Rect(int w,int h) {
		this.w = w; // = supuer(w);
		this.h = h;
	}


	@Override
	public void area() {
		result = w * h;

	}


	@Override
	public void draw() {
		System.out.println("사각형 그리기 ");
	}


	@Override
	public void move() {
		System.out.println("사각형 move");		
	}
	
	
}
