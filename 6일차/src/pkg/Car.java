package pkg;

 public class Car {

	// private는 내부에서만 호출 가능함
	private String model;
	private int speed;
	private boolean stop;
	
	// 기본 생성자
	public Car() {}
	
	// setter : getter
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public boolean isStop() { //  boolean 은 get이 아니고 is가 나옴
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	
	// 값을 두개 받는 생성자
	public Car(String model, int speed) {
		
		this.model = model;
		if (speed < 50) {
			speed = 50;
		}
		this.speed = speed;
	}
	
	// 값을 한개만 받는 생성자 , 그리고 위에 생성자를 가져와서 만드는 방법
	public Car(String model) {
		this(model , 0);
		// 그래서 위에 생성자의 스피드의 초기값을 가지기 때문에
		// speed가 50미만이면 50이라고 들어감
	}
	
	
	
	
	
}
