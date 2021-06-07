package 스레드;

public class 동기화 {

	public static void main(String[] args) {

		
		// 공유객체 : user1과 user2가 둘다 같이 calculator를 사용함 
		// 같은 객체를 공유해서 사용하면 동기화는 줄을 세어서 
		// 차례대로 사용하게 됨 = "동기식"이라고 함
		// 그래서 user1이 100을 넣고 2초를 기다리는 동안
		// user2가 50을 넣었기 때문에
		// 결과값은 둘다 50으로 나옴
		// ex) 통장에 천만원을 폰뱅킹, 콜뱅킹 동시에 할떄 아무리 동시에 실행해도
		//		차례대로 실행되는것과 같은 원리라고 예를 드심
	
		Calculator calculator = new Calculator();
		
		User1 user1 = new User1();
		user1.setCalculator(calculator); // 100  2초대기
		
		User2 user2 = new User2();
		user2.setCalculator(calculator); // 50  2초대기
		
		// 두개 실행시간 2초임
		// 메소드에 synchronized 넣으면 실행시간이 총 4초가 됨
		user1.start();
		user2.start();
	}

}
