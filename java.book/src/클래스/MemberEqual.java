package 클래스;

public class MemberEqual {

	public static void main(String[] args) {

		Member m1 = new Member("park","1111","박기자", 20);
		Member m2 = new Member(new String("park"),"2222","박기자", 40);
		
		System.out.println(m1 == m2);
		System.out.println(m1.equals(m2));
		
	}

}
