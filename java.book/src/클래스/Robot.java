package 클래스;


// 1. 클래스 선언
public class Robot {

	// 필드
	// private : 접근 제어자 , 클래스 내부에서 접근 가능, 
	// 			 외부에서는 접근 불가능
	private int arm; 
	private int leg;
	private String name;
	
	
	
	public Robot(int arm, int leg, String name) {
		super();
		this.arm = arm;
		this.leg = leg;
		this.name = name;
	}
	
	//setter : 필드값을 변경하는 목적
	public void setName(String name) {   
		this.name = name;
	}
	public void setLeg(int leg) {
		this.leg = leg;
	}
	public void setArm(int arm) {   // return은 없고 값을 받아 변경
		this.arm = arm;
	}
	
	
	//getter : 필드값을 조회하는 목적 ex) get+ 변수앞자리를 대문자로 수정
	public int getArm() {
		return this.arm;    // return 해줘야함!
	}
	public int getLeg() {
		return this.leg;
	}
	public String getName() { // 타입을 잘 봐줘야함
		return this.name;
	}
	
	// 생성자 오버로딩
	// 필드  초기화 : 생성자
	
	//public Robot() {}// - 기본 생성자 - 만들지 않으면 컴파일러가 기본으로 생성해 주는 생성자임
	public Robot (int arm , int leg) {
		this.arm = arm;  // this 자기 자신을 가르키는 참조 변수 : 필드에서 선언한 arm을 가르킴
		this.leg = leg;

	}
	
	// 일반 메서드  - public 이 없으면 같은 패키지 내에서만 접근가능
	public void print() { // public을 넣어줘야지 (다른패키지)외부에서 접근가능
		System.out.printf("arm : %d leg : %d", arm, leg);
	}

}
