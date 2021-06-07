package 스레드;
/*
 *  Thread를 상속받아서
 *  소스 > 오버라이딩 > run 체크
 */
public class Print100 extends Thread {

	public Print100() {
		super.setName("100출력");
	}
	@Override
	public void run() {
		for (int i =1; i <= 100; i ++) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
