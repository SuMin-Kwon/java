package 클래스;

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
	@Override
	public boolean equals(Object obj) {
		
		Member mm = ((Member)obj);
		//return m.id == this.id && m.name == this.name; 
		return mm.id.equals(this.id) && mm.name.equals(this.name);
	}
	
	
	

	
	
	
	
}
