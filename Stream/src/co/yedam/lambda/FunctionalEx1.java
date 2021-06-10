package co.yedam.lambda;

// 함수적으로 표현가능한 인터페이스를 functionInterface
interface Run {
	void run();
}
class RunCls implements Run{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("달린다");
	}
	
}

public class FunctionalEx1 {

	public static void main(String[] args) {
		
		RunCls cls = new RunCls();
		cls.run();
		// 함수표현식을 람다식으로(↙밑에 코드와 비교)  = consumer타입의 functionInterface
		Run r = () -> System.out.println("빨리 달린다");
		r.run();
		
		// 익명객체를 구현한 것
//		Run r = new Run() {
//
//			@Override
//			public void run() {
//				System.out.println("빨리 달린다");
//			}
//			
//		};
//		r.run();
	}

}
