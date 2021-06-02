package pkgfriend;

import pkg.Friend;

public class SchoolFriend extends Friend {
	
	String brith;
	
	public SchoolFriend() {}

	public SchoolFriend(String gubun, String name, String tel) {
		super(gubun, name, tel);
	}
	
	public SchoolFriend(String gubun, String name, String tel, String brith) {
		super(gubun, name, tel); //: 어차피 부모안에 초기화 되어있어서 굳이 안써도됨
		this.brith = brith;
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		//super.print();
		//System.out.println("brith:" + brith);
		System.out.printf("학교친구: %10s %10s  %10s %10s\n", gubun , name, tel, brith);
	}
	
	
	
	
}
