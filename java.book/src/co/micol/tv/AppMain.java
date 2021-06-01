package co.micol.tv;

public class AppMain {
		/*
		 *  명령행 인수 run 삼각형 에서 configuration > arguments > 삼성 또는 lg 영어로 치면됨
		 *  
		 */
	
	public static void main(String[] args) {

		//SamsungTv tv = new SamsungTv();
		//LgTv tv = new LgTv();
		
		
		// 다형성 - (여러가지 형태로 실행됨)
		//		    참조하는 대상의 메서드가 호출
		//			코드는 같아도 참조 대상에 따라서 실행결과가 다름
		//1. 부모타입의 참조변수가 자식객체를 참조할 수 있다.
		//   부모타입 = 인터페이스 , 자식타입 = 삼성tv
		//RemoteControl tv = new SamsungTv();
		//RemoteControl tv = (RemoteControl)BeanFactory.getBean("Samsung");
		RemoteControl tv = (RemoteControl)BeanFactory.getBean(args[0]);
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		
	}

}
