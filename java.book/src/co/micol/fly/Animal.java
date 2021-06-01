package co.micol.fly;

public abstract class Animal {

	public Animal(){
		System.out.println("동물 생성자");
	}
	
	public void run() {
		System.out.println("달린다");
	}
	public abstract void eat(); 
	//	System.out.println("먹는다");

	public void sleep() {
		System.out.println("잔다"); 
	}
	
}
