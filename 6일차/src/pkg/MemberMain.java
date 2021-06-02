package pkg;

public class MemberMain {

	public static void main(String[] args) {
// 		private 접근을 막아버림
		
//		MemberInfo member1 = new MemberInfo();
//		member1.names[0] = "홍길동";
//		
//		MemberInfo member2 = new MemberInfo();
//		member2.names[1] = "권수민";
//		
//		MemberInfo member3 = new MemberInfo();
//		member3.names[2] = "박기자";
//
//		member1.print();
//		member2.print();
//		member3.print();
		
		
		// new가 아닌 getInstance로 호출함, 생성이 아님 
		MemberInfo member1 = MemberInfo.getInstance();
		member1.names[0] = "홍길동";
		MemberInfo member2 = MemberInfo.getInstance();
		member2.names[1] = "홍길스";
		MemberInfo member3 = MemberInfo.getInstance();
		member3.names[2] = "홍길다";
		
		member1.print();
		member2.print();
		member3.print();
	}

}
