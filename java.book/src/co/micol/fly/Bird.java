package co.micol.fly;

public class Bird extends Animal {

	public Bird () {}

	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("새는 움직인다");
	}



	@Override
	public void eat() {
		System.out.println("새는 먹는다");
		
	}



	public void takeOff() {
		System.out.println("새 이륙");
		
	}
	public void layEggs() {
		System.out.println("새 알을 낳다");
		
	}
	
	public void fly() {
		System.out.println("새 난다");
		
	}
	public void land() {
		System.out.println("새 착륙");
		
	}
	
}
