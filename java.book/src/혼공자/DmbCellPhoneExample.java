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
		dmb.receiveVoice(" ....");
		dmb.sendVoice(" ....");
		dmb.receiveVoice(" ....?");
		dmb.sendVoice(" ...");
		dmb.receiveVoice(" ....");
		System.out.println("=================");
		
		dmb.hangUp();
		dmb.turnOnDmb();
		dmb.change(35);
		dmb.turnOffDmb();
		dmb.powerOff();
	}

}
