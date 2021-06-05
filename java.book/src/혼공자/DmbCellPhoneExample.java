package 혼공자;

public class DmbCellPhoneExample {

	public static void main(String[] args) {

		DmbCellPhpne dmb = new DmbCellPhpne();
		dmb = new DmbCellPhpne("자바폰","Black", 21);
		
		System.out.println("모델: "+ dmb.model);
		System.out.println("컬러: "+ dmb.color);
		System.out.println("채널: "+ dmb.channel);
		System.out.println();
		dmb.powerOn();
		dmb.bell();
		
		System.out.println("=================");
		dmb.receiveVoice(" 지금 머해?");
		dmb.sendVoice(" 집임 Tv봄");
		dmb.receiveVoice(" 밖인데, 나올래?");
		dmb.sendVoice(" 노노");
		dmb.receiveVoice(" ㅠㅠ, ㅇㅋ");
		System.out.println("=================");
		
		dmb.hangUp();
		dmb.turnOnDmb();
		dmb.change(35);
		dmb.turnOffDmb();
		dmb.powerOff();
	}

}
