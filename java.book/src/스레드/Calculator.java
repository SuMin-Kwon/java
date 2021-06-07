package 스레드;

public class Calculator {

	private int memory;

	public int getMemory() {
		return memory;
	}
	// synchronized 넣으면 각각 다르게 나옴 (실행시간이 총 4초가 됨)
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+":"+ this.memory);
		// 현재 메모리값을 출력
	}
}


// -- user1,2 클래스 , 출력은 동기화
