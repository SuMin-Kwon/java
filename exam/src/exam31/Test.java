package exam31;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c1 = new Car("Auto");
		Car c2 = new Car("4W", 150, "Manaual");
		System.out.println(c1.type + " " + c1.maxSpeed + " " + c1.trans);
		System.out.println(c2.type + " " + c2.maxSpeed + " " + c2.trans);
	}

}
