package co.micol.fly;

public class Human extends Animal {

	public Human () {}
	
	public void thick() {
		System.out.println("생각한다");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("고기,채소");
	}
	
}
