package co.board.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import co.board.model.Board;

// DB 연결파일
public class BoardDAO implements BoardAccess{

	Scanner scanner = new Scanner(System.in);
	
	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;
	
	// 로그인
	public boolean rogin(String id, String pw) {
		boolean t = false;
		connect();
		String sql = "SELECT *FROM rogin WHERE id = ? AND pw = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,id);
			psmt.setString(2,pw);
			rs = psmt.executeQuery();
			if (rs.next()) {
				t = true;
			} else {
				t = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return t;
	}
	
	
	// 수정
	public void update(Board board) {
		connect();
		String sql = "UPDATE board set b_content = ? WHERE  b_id  = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,board.getB_content());
			psmt.setInt(2,board.getB_id());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}

	
	// 삭제
	public void delete(int id) {
		connect();
		String sql = "DELETE FROM board WHERE b_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { 
			close();
		}	
	}

	
	// 전체조회
	public ArrayList<Board> listAll() {
		
		ArrayList<Board> boardList = new ArrayList<>();
		connect();
		String sql = "SELECT b_id,b_title,b_writer FROM board";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setB_id(rs.getInt("b_id"));
				board.setB_title(rs.getString("b_title"));
				board.setB_writer(rs.getString("b_writer"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return boardList;
	}

	// 한건조회
	public Board findDate(int id) {
		connect();
		String sql = "select * from board where b_id = ?"; 
		Board b = null;
		try {
			psmt = conn.prepareStatement(sql); 
			psmt.setInt(1, id); 
			rs = psmt.executeQuery();
			if (rs.next()) {
				b = new Board(); 
				b.setB_id(rs.getInt("b_id"));
				b.setB_title(rs.getString("b_title"));
				b.setB_content(rs.getString("b_content"));
				b.setB_writer(rs.getString("b_writer"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 실행 했건 안했건 무조건 실행 해주는것
			close();
		}
		return b;
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




	@Override
	public void insert(Board board) {
		connect();
		try {
			psmt = conn.prepareStatement("INSERT into board(b_title, b_content, b_writer) values(?,?,?)");
			psmt.setString(1, board.getB_title());
			psmt.setString(2, board.getB_content());
			psmt.setString(3, board.getB_writer());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}



}
