package 상속;

public class DmbCellPhone extends CellPhone {
	
	int channel;
	
	public DmbCellPhone() {
		//super("","");  생략가능
		System.out.println("DmbCellPhone 기본생성자");
	}
	
	public DmbCellPhone(String model,String color,int channel) {
		super(model,color); // 무조건 하나의 부모상속을 가져옴, 생략되어 있슴
//		this.model = model;   부모에서 이미 초기화 하여서 굳이 할 필요 없슴 
//		this.color = color;
		this.channel = channel;
		System.out.println("DmbCellPhone 생성자");
	}
	
	void trunOnDmb() {
		System.out.println("채널 " + channel + "번 DMB 방송수신 시작");
	}
	void trunOffDmb() {
		System.out.println("DMB 방송수신을 멈춥니다.");
	}
	
	void changeChannel(int channel) {
		System.out.println("채널 변경합니다");
		
	}
	// 소스 -> override -> powerOn 선택 != 오버로딩(중복정의)
	// 메소스 재정의
	// 상속받은 메서드를 수정하는 것
	@Override
	void powerOn() {
		// super.powerOn();
		System.out.println("Dmb 전원 on");
	}
	
	
}
