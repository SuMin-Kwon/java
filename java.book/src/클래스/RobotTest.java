package 클래스;

public class RobotTest {
	//기본타입
	public static void change(int a) {
		a += 10;
	}
	//참조 변수
	public static void change(Robot robot) {
		robot.setArm(5);
	}
	
	public static void main(String[] args) {
		
		//2. 객체생성
		// r = 참조변수(스텍) , new Robot(2,4) <-- r의 참조변수 (힙)
		//Robot r = new Robot(2,4);
		int a = 1;
		change(a);
		System.out.println(a);
		//System.out.println(r.getArm());
		
//		r.arm = 2;  // 접근제어 예시
//		r.leg = 4;
//		System.out.println(r.getArm());
//		System.out.println(r.getLeg());
		// 직접적으로 읽진 못하지만 get을 이용해서 조회가능
		
		//3. 객체사용(메서드 호출)
		Robot r2 = new Robot(2,2);
		r2.print();
		
		
		
	}

}
