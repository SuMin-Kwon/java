package co.memo.access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import co.friend.util.DAO;
import co.memo.model.Memo;

public class MemoDAO extends DAO implements MemoAccess{

	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	@Override
	public void insert(Memo memo) {
		try {
			psmt = conn.prepareStatement("INSERT into memo values(?,?)");
			psmt.setString(1, memo.getDate());
			psmt.setString(2, memo.getContent());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Memo memo) {
		try {
			psmt = conn.prepareStatement("UPDATE memo set content = ? WHERE date = ?");
			psmt.setString(1, memo.getContent());
			psmt.setString(2, memo.getDate());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String date) {
		
	}

	@Override
	public ArrayList<Memo> listAll() {
		ArrayList<Memo> mList = new ArrayList<>();
		try {
			psmt = conn.prepareStatement("select * from memo");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Memo memos = new Memo();
				memos.setDate(rs.getString("date"));
				memos.setContent(rs.getString("content"));
				mList.add(memos);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mList;
	}

	@Override
	public Memo findDate(String date) {
		return null;
	}

	@Override
	public Memo findContent(String content) {
		return null;
	}

}
