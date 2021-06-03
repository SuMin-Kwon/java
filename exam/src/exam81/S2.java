package exam81;

class S2 extends S1 {
	public void display(int x, int y) {
		this.display(x);
		display(y);
		super.display(y);
	}

	public void display(int x) {
		System.out.println("Child " + x);
	}
}