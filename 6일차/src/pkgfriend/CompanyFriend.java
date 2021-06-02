package pkgfriend;

import pkg.Friend;

public class CompanyFriend extends Friend {

	String duty;
	public CompanyFriend () {}
	
	
	@Override   // 부모랑 리턴값이 똑같아야함 
	public void print() {
		// TODO Auto-generated method stub
		//super.print();
		//System.out.println("duty:" + duty);
		System.out.printf("회사친구: %10s %10s  %10s %10s\n", gubun , name, tel, duty);
		
	}


	public CompanyFriend(String gubun, String name, String tel) {
		super(gubun, name, tel);
	}


	public CompanyFriend(String gubun, String name, String tel, String duty) {
		super(gubun, name, tel);
		this.duty = duty;
	}
	
	
	
	
}
