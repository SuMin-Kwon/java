package co.friend.access;
// FriendAccess.java , FriendList.java

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import co.friend.model.Friend;
import co.friend.util.DAO;

public class FriendDAO extends DAO implements FriendAccess {
// access의 추상메서드는 반드시 상속받는 클래스에서 추상메서드를 구현을 해줘야함

	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	// name, tel 담아주는 컬렉션 
	public Map<String, String> getNameTel() {
		Map<String, String> map = new HashMap<>();
		try {
			psmt = conn.prepareStatement("SELECT name, tel from friend");
			rs = psmt.executeQuery();
			while (rs.next()) {
				map.put(rs.getString("name"), rs.getString("tel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	// 등록
	@Override
	public void insert(Friend friend) {
		try {
			psmt = conn.prepareStatement("INSERT into friend values(?,?,?)");
			psmt.setString(1, friend.getGubun());
			psmt.setString(2, friend.getName());
			psmt.setString(3, friend.getTel());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 수정
	// 동일한 이름은 없다는 전제
	@Override
	public void update(Friend friend) {
		try {
			psmt = conn.prepareStatement("UPDATE friend set tel = ? WHERE name = ?");
			psmt.setString(1, friend.getTel());
			psmt.setString(2, friend.getName());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 삭제
	@Override
	public void delete(String name) {
		try {
			psmt = conn.prepareStatement("DELETE FROM friend WHERE name = ?");
			psmt.setString(1, name);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 전체리스트 조회
	@Override
	public ArrayList<Friend> selectAll() {
		ArrayList<Friend> fList = new ArrayList<>();
		try {
			psmt = conn.prepareStatement("select * from Friend");
			rs = psmt.executeQuery(); // 실행한 결과값이 rs에 담김
			while (rs.next()) {
				Friend friend = new Friend();
				friend.setGubun(rs.getString("gubun"));
				friend.setName(rs.getString("name"));
				friend.setTel(rs.getString("tel"));
				fList.add(friend); // 데이터의 건수만큼 fList에 담김
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fList;
	}

	// 한건 조회
	@Override
	public Friend selectOne(String name) {
		Friend friend = null;
		try {
			psmt = conn.prepareStatement("SELECT * FROM friend WHERE name = ?");
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			if (rs.next()) {
				friend = new Friend();
				friend.setGubun(rs.getString("gubun"));
				friend.setName(rs.getString("name"));
				friend.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return friend;
	}

	// 번호조회
	@Override
	public Friend findTel(String tel) {
		Friend friend = null;
		try {
			psmt = conn.prepareStatement("SELECT * FROM friend WHERE tel = ?");
			psmt.setString(1, tel);
			rs = psmt.executeQuery();
			if (rs.next()) {
				friend = new Friend();
				friend.setGubun(rs.getString("gubun"));
				friend.setName(rs.getString("name"));
				friend.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (friend == null) {
			System.out.println("없음");
		}
		return friend;
	}

}
