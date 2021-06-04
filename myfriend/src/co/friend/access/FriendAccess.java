package co.friend.access;

import java.util.ArrayList;

import co.friend.model.Friend;


public interface FriendAccess {

	public static final String model = "ddd";
	
	// 등록
	public abstract void insert(Friend friend);
	
	// 수정
	public void update(Friend friend);
	
	// 삭제
	public void delete(String name);
	
	// 전체조회
	public ArrayList<Friend> selectAll();
	
	// 단건조회
	public Friend selectOne(String name);
	
	// 전화번호조회
	public Friend findTel(String tel);
		
	
}
