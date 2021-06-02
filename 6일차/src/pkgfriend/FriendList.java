package pkgfriend;

import java.util.ArrayList;
import java.util.List;

import pkg.Friend;

public class FriendList implements FriendAccess {
		
	ArrayList<Friend> friends;

	public FriendList () {
		friends = new ArrayList<Friend>();
	}
	//등록
	@Override
	public void insert(Friend friend) {
		friends.add(friend);
	}
	//수정
	@Override
	public void update(Friend friend) {
		// TODO Auto-generated method stub
		
	}
	//삭제
	@Override
	public void delete(String name) {
		// TODO Auto-generated method stub
		
	}
	// 전체조회
	@Override
	public void selectAll() {
		System.out.println("FriendList");
	}
	// 검색
	@Override
	public Friend selectOne(String name) {
		for ( Friend f : friends) {
			if (f.getName().equals(name)) { // contains 등등
				return f;
			}
		}
		
		return null;
	}
	
	
}
