package co.friend.access;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import co.friend.model.Friend;

// 친구 여러명의 정보를 저장하는 곳
public class FriendList implements FriendAccess {

	ArrayList<Friend> friends;


	// open
	String path = "d:/temp/friend.txt";

	public void open() {
		try {
			Scanner scanner = new Scanner(new File(path));
			while (true) {
				if (! scanner.hasNext())
					break;
				String str = scanner.next();
				String[] arr = str.split(",");
				friends.add(new Friend(arr[0], arr[1], arr[2]));
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//저장
	public void save() {
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(path));
			for (Friend f : friends) {
				fw.write(String.format("%s,%s,%s\n", f.getGubun(),
													f.getName(),
													f.getTel()));
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public FriendList() {
		friends = new ArrayList<Friend>();
		open();
	}

	// 등록
	@Override
	public void insert(Friend friend) {
		friends.add(friend);
		save();
	}

	// 수정 set
	@Override
	public void update(Friend friend) {
		for (Friend f : friends) {
			if (f.getName().equals(friend.getName())) {
				f.setTel(friend.getTel());
				save();
			}
		}
	}

	// 삭제 검색해서 삭제

	@Override
	public void delete(String name) {
		for (Friend f : friends) {
			if (f.getName().equals(name)) {
				friends.remove(f);
				save();
				break;
			}
		}
	}

	// 전체조회
	@Override
	public ArrayList<Friend> selectAll() {
		return friends;
	}

	// 검색
	@Override
	public Friend selectOne(String name) {
		for (Friend f : friends) {
			if (f.getName().equals(name)) { // 이름을 비교할때
				return f;
			}
		}
		return null;
	}
	
	//전화번호 검색
	public Friend findTel(String tel) {
		for (Friend f : friends) {
			if (f.getTel().contains(tel)) { // contains 포함된거를 찾음
				return f;
			}
		}
		return null;
	}

}
