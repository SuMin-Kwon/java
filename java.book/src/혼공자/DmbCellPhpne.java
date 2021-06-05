package 혼공자;

public class DmbCellPhpne extends CellPhone {
	
	int channel;
	// 기본 생성자
	DmbCellPhpne (){}
	// 생성자
	DmbCellPhpne(String model,String color,int channel) {
		this.model = model;
		this.color = color;
		this.channel = channel;
	}
	
	void turnOnDmb() {
		System.out.println("채널" + channel + "번을 수신 시작합니다.");
	}
	void change(int channel) {
		this.channel = channel;
		System.out.println("채널"+ channel + "번으로 변경합니다.");
	}
	void turnOffDmb() {
		System.out.println("수신을 종료합니다.");
	}
	

}
