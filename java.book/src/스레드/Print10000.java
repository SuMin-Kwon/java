package 스레드;
/*
 * 추상을 상속받으면
 * 오버라이트 해야함
 */

public class Print10000 implements Runnable {

	@Override
	public void run() {
		for (int i =10000; i <=  10100; i++) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
