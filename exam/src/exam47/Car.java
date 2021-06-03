package exam47;

class Car extends Vehicle {
	int y;

	Car() {
		super(10); // line n2
	}

	Car(int y) {
		super(y);
		this.y = y;
	}

	public String toString() {
		return super.x + ":" + this.y;
	}
}