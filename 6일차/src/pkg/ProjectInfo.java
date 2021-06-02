package pkg;
/**
 * 
 * 
 * 
 * 
 */


public class ProjectInfo {
	public static final String name = "예담주식회사";
	// static : AppMain 에서 ProjectInfo.name 바로 불러올수 있슴(공유필드에서 하나의 값만 가지도록)
	// final : 변경 수정이 안됨 , final은 한번은 무조건 필드값을 저장해줘야함
	static String uploadpath = "c:/temp";
	
	
	int version = 1;   // 인스턴스필드
	// 인스턴스 필드는 AppMain 에서 new 객체 생성 후 메모리에 할당받아서
	// 불러올 수 있슴 <---> static이랑 다름
	
}
