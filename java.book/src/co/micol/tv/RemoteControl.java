package co.micol.tv;


/*
 * 개발 표준 = 인터페이스
 * 추상 메서드
 */
public interface RemoteControl {

	public void powerOn(); // 바디는 없고 그냥 이름만 있는 추상메서드
	public void powerOff();
	public void volumeUp();
	public void volumeDown();
	
	
}
