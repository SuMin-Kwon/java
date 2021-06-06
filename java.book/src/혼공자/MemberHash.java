package 혼공자;

public class MemberHash {

	public String name;
	public int age;

	public MemberHash(String name, int age) {
		this.name = name;
		this.age = age;
	}
	 
	// name과 age 값이 같으면 true를 리턴
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MemberHash) {
			MemberHash mh = (MemberHash) obj;
			return mh.name.equals(name) && (mh.age == age) ;
		} else {
			return false;
		}
		
	}

	// name , age 값이 같으면 동일한 hashCode 리턴
	@Override
	public int hashCode() {
		return name.hashCode() + age ;
	}
	
	

}
