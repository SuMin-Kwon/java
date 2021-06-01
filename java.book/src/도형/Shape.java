package 도형;

public abstract class Shape {
	
	int w;
	double result;
	
	
	public Shape() {}


	public Shape(int w) {
		super();
		this.w = w;
	}
	
	public void print() {
		System.out.println("도형 면적"+ result);
	}
	public abstract void area();

	
	
}
