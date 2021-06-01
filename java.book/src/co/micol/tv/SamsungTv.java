package co.micol.tv;

public class SamsungTv implements RemoteControl {

	public SamsungTv () {
		System.out.println("삼성TV - 객체 생성");
	}
	
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("삼성TV - 전원 on");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("삼성TV - 전원 off");
		
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("삼성TV - 볼륨 up");
		
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("삼성TV - 볼룸 down");
		
	}

}
