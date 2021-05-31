package co.yedam.member;

public class Member {

	
	String id;
	String password;
	String name;
	int age;
	
	Member (){}
	public Member( String id, String password, String name,int age) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", age=" + age + "]";
	}
	
	
	

	
	
	
	
}
