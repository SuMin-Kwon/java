package pkg;

public class MemberInfo {
	//싱글톤
	static MemberInfo memberInfo = new MemberInfo(); 
	// MemberInfo를 static을 붙여서 new 객체를 static에 넣어줌
	
	static MemberInfo getInstance() {
		return memberInfo;
	}// memberInfo 자체가 스테틱으로 들어감
	 // getInstance 에서 생성memberInfo을 가져감

	private MemberInfo() {}
	// 생성자는 있지만 접근이 안됨
	// public 은 접근가능
	
	String[] names = new String [10];
	
	void print () {
		
		for (String name : names) {
			System.out.println(name);
		}
	}
 
}
