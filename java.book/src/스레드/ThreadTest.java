package 스레드;

/*
 *  Thread 상속
 */
public class ThreadTest {

	public static void main(String[] args) {

		Print100 print100 = new Print100();
		print100.setPriority(Thread.MIN_PRIORITY); // 스레드 실행의 우선순위를 설정
		System.out.println(print100.getName());
		print100.start();

//		Print1000 print1000 = new Print1000();
//		print1000.setPriority(Thread.MAX_PRIORITY);
//		print1000.start();

		// 3개가 동시에 실행, 순서를 제어 x
		// runnalbe 이용함
		// 1000
		Thread thread1 = new Thread(new Print1000());
		thread1.start();
		// 10000
		Thread thread2 = new Thread(new Print10000());
		thread2.start();

		// for문 2000 --> 익명객체로 표현
		Thread thread3 = new Thread(new Runnable() {
			public void run() {
				for (int i = 2000; i <= 2100; i++) {
					System.out.println(i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread3.start();

		// 람다식 : 반드시 구현 클래스를 만들어야함.
		// 구현 메서드가 1개일때 람다식 사용!
		// () -> {} ;   *() 매개변수 * {} 안에 for문(바디)을 넣어줌
		// 익명객체를 --> 람다식으로 표현
		Thread thread4 = new Thread(() -> {
			for (int i = 2000; i <= 2100; i++) {
				System.out.println(i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread4.start();


	}

}
