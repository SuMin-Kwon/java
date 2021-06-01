package co.micol.tv;

public class LgTv implements RemoteControl{

	public LgTv () {
		System.out.println("LG TV - 객체 생성");
	}
	
	
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("LG TV - 전원 on");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("LG TV - 전원 off");
		
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("LG TV - 볼륨 Up");
		
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("LG TV - 볼륨 down");
		
	}

}
