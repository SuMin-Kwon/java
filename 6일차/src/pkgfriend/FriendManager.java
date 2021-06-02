package pkgfriend;

import java.util.List;

import pkg.Friend;

/*
 *  한 파일 안에 class는 public 하나만 사용 가능함
 */
public class FriendManager implements FriendAccess {
	
	 Friend [] friend = new Friend[5]; // 리스트나 DB로 교체 가능하도록 사용

	 public FriendManager() {
		 // 부모타입의 객체를 자식에서 참조할 수 있슴
		 friend[0] = new CompanyFriend("예담회사","순이","010-2222-4444");
		 friend[1] = new SchoolFriend("중앙초등","돌이","010-2456-4444");
		 friend[2] = new SchoolFriend("중앙초등","길동","010-3456-4444");
		 friend[3] = new CompanyFriend("현대","김기자","010-5552-4444");
		 friend[4] = new CompanyFriend("현대","유신","010-7777-4444");
	 }
	 
	@Override
	public void insert(Friend friend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Friend friend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectAll() {
		System.out.println("FriendManager");

	}

	@Override
	public Friend selectOne(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	 
	 
	 
}
