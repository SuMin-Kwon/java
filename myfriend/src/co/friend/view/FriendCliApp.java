package co.friend.view;

import java.util.List;

import co.friend.access.FriendList;
import co.friend.model.Friend;
import co.friend.util.ScannerUtil;

public class FriendCliApp {
	
	FriendList friendList = new FriendList();
	public void  start() {
		
		int menunum;
		do {
			menuTitle();   // 메뉴출력
			menunum = ScannerUtil.readInt("입력"); // 메뉴 선택
			switch (menunum) {
			case 1 : insert(); 		break;
			case 2 : update(); 		break;
			case 3 : delete(); 		break;
			case 4 : selectAll(); 	break;
			case 5 : findNum(); 	break;
			case 6 : findTel(); 	break;
		
			}
		}while (menunum != 0);
	}
	
	// 전화번호검색
	private void findTel() {
		String tel = ScannerUtil.readStr("번호입력>");
		Friend friend = friendList.findTel(tel);
		System.out.println(friend);
	}


	public void menuTitle() {
		System.out.println("===== 친구 관리 ====");
		System.out.println("====1. 친구추가 ====");
		System.out.println("====2. 번호수정 ====");
		System.out.println("====3. 친구삭제 ====");
		System.out.println("====4. 전체조회 ====");
		System.out.println("===5. 이름으로조회===");
		System.out.println("===6. 전화번호검색===");
		System.out.println("=====0. 종료 ======");
		
	}
	// 이름 검색
	private void findNum() {
		String name = ScannerUtil.readStr();
		Friend friend = friendList.selectOne(name);
		System.out.println(friend);
	}
	// 전체조회
	private void selectAll() {
		List<Friend> list = friendList.selectAll();
		for (Friend friend : list) {
			System.out.println(friend);
		}
		
	}
	// 이름으로 검색해서 삭제
	private void delete() {
		String name = ScannerUtil.readStr("삭제할 이름입력>");
		friendList.delete(name);
		
	}
	
	private void update() {
		Friend friend = new Friend();
		friend.setName(ScannerUtil.readStr("이름>"));
		friend.setTel(ScannerUtil.readStr("바꿀 번호"));
		friendList.update(friend);
		
	}
	
	private void insert() {
		Friend friend = ScannerUtil.readFriend();
		friendList.insert(friend);
		
	}
}
