package pkg;

public class AppMain {
	
	
		static void print() { // static 사용하면 바로 호출되서 static끼리도 바로 메서드호출가능함
		System.out.println("========");
		printName();
	}
	
	
		static void printName() {
		System.out.println("홍길동");
	};
	

	public static void main(String[] args) {
		// *********************Count**********************
		Count count1 = new Count();
		Count.cnt1++;   // static 이여서 접근할때도 클래스이름으로 바로 불러오는게 오류가 안생김
		//count1.cnt2++;   * cnt2앞에 private가 붙어서 접근안되서 일단 주석해놓음
		
		//System.out.println(Count.cnt1 + ":" + count1.cnt2);
		
		Count count2 = new Count();
		Count.cnt1++;
		//count2.cnt2++;
		
		Count count3 = new Count();
		Count.cnt1++;
		//count3.cnt2++;  
		
		
		//System.out.println(Count.cnt1 + ":" + count2.cnt2);
		//System.out.println(Count.cnt1 + ":" + count3.cnt2);
		
//		
//		// *******************project******************
//		System.out.println(ProjectInfo.name);
//		ProjectInfo.uploadpath = "변경"; // 변경가능
//		
//		
//		// 인스턴스 필드는 new 객체 생성해야지 접근가능
//		ProjectInfo info = new ProjectInfo();
//		System.out.println(info.version);
//		
//		// *******************DateUtil****************
//		
//		System.out.println(DateUtil.curDate());
//		
	}

}
