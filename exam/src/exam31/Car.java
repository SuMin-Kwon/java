package exam31;

class Car extends Vehicle {
	String trans;

	Car(String trans) { // line n1
		this.trans = trans;
	}

	Car(String type, int maxSpeed, String trans) {
		super(type, maxSpeed);
		this.trans = trans;
	}
}
