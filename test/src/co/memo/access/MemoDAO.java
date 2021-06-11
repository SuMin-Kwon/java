package co.memo.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.memo.model.Memo;

// MemoAccess를 구현하는 클래스입니다.
// 기능을 작성하세요.
public class MemoDAO implements MemoAccess {

	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;

	// 메모등록
	@Override
	public void write(String date, String title, String content) {
		connect();
		try {
			psmt = conn.prepareStatement("INSERT into memo values(?,?,?)");
			psmt.setString(1, date);
			psmt.setString(2, title);
			psmt.setString(3, content);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	// 메모수정 (입력받은 제목으로 내용수정)
	@Override
	public void update(String title, String content) {
		connect();
		try {
			psmt = conn.prepareStatement("UPDATE memo set content = ? WHERE title = ?");
			psmt.setString(1, content);
			psmt.setString(2, title);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	
	// 메모삭제 ( 입력받은 제목으로 삭제)
	@Override
	public void delete(String title) {
		connect();
		try {
			psmt = conn.prepareStatement("DELETE FROM memo WHERE title = ?");
			psmt.setString(1, title);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	// 메모전체조회
	@Override
	public ArrayList<Memo> FindAll() {
		ArrayList<Memo> mList = new ArrayList<>();
		connect();
		try {
			psmt = conn.prepareStatement("select * from memo");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Memo memos = new Memo();
				memos.setDate(rs.getString("date"));
				memos.setTitle(rs.getString("title"));
				memos.setContent(rs.getString("content"));
				mList.add(memos);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return mList;

	}

	
	// 날짜로 조회
	@Override
	public Memo FindByDate(String date) {
		connect();
		Memo memo = null;
		try {
			psmt = conn.prepareStatement("SELECT *FROM memo WHERE date = ?");
			psmt.setString(1, date);
			rs = psmt.executeQuery();
			while(rs.next()) {
				memo = new Memo();
				memo.setDate(rs.getString("date"));
				memo.setTitle(rs.getString("title"));
				memo.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return memo;

	}
	
	// 메모내용조회
	@Override
	public ArrayList<Memo> FindByContent(String content) {
		
		ArrayList<Memo> mList = new ArrayList<>();
		connect();
		Memo memo = null;
		try {
			psmt = conn.prepareStatement("SELECT * from memo WHERE content = ?");
			psmt.setString(1, content);
			rs = psmt.executeQuery();
			while(rs.next()) {
				memo = new Memo();
				memo.setDate(rs.getString("date"));
				memo.setTitle(rs.getString("title"));
				memo.setContent(rs.getString("content"));
				mList.add(memo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return mList;

	}

	// 연결
	public static void connect() {

		String url = "jdbc:sqlite:C:/sqlite/db/sample.db";
		try {
			conn = DriverManager.getConnection(url);

		} catch (SQLException e) {
			System.out.println("연결실패....");
			e.printStackTrace();
		}

	}

	// 닫음
	public static void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
