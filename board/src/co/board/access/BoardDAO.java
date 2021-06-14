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
	

	// 아이디랑 작성자값 비교
	@Override
	public boolean roginTrueKey(int id, String u_id) {
		connect();
		String sql = "select * from board where b_id=? and b_writer = ?"; 
		boolean bb = false;
		try {
			psmt = conn.prepareStatement(sql); 
			psmt.setInt(1, id);
			psmt.setString(2, u_id);
			rs = psmt.executeQuery();
			if  (rs.next()) {
				bb = true;	
			} else {
				bb = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 실행 했건 안했건 무조건 실행 해주는것
			close();
		}
		
		return bb;
	}


	// 댓글추가
	@Override
	public void reply(String title, String content, String writer, int parentid) {
		connect();
		try {
			psmt = conn.prepareStatement("INSERT into board(b_title, b_content, b_writer,b_parentid) values(?,?,?,?)");
			psmt.setString(1,title);
			psmt.setString(2,content);
			psmt.setString(3,writer);
			psmt.setInt(4,parentid);
			int r = psmt.executeUpdate();
			System.out.println(r + " 댓글 추가되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	// 댓글보여주기능
	public ArrayList<Board> replyShow(int id) {
		ArrayList<Board> boardList = new ArrayList<>();
		connect();
		String sql = "select * from board where b_parentid = ?"; 
		Board b = null;
		try {
			psmt = conn.prepareStatement(sql); 
			psmt.setInt(1, id); 
			rs = psmt.executeQuery();
			while (rs.next()) {
				b = new Board(); 
				b.setB_title(rs.getString("b_title"));
				b.setB_content(rs.getString("b_content"));
				b.setB_writer(rs.getString("b_writer"));
				boardList.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 실행 했건 안했건 무조건 실행 해주는것
			close();
		}
		return boardList;
		
	}
	

	// 한건 상세조회
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
	
	// 로그인 비교
	public boolean rogin(String id, String pw) {
		boolean t = false;
		connect();
		String sql = "SELECT *FROM member WHERE u_id = ? AND u_pass = ? ";
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

	
	//게시글 삭제
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
	// 댓글
	public void replyDelete(int id) {
		connect();
		String sql = "DELETE FROM board WHERE b_parentid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			int r = psmt.executeUpdate();
			System.out.println("댓글"+r + "건 삭제되었습니다.");
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
		String sql = "SELECT * FROM board where b_parentid is null";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()==true ) {
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
	
	public void insertRogin(String id , String pw) {
		connect();
		try {
			psmt = conn.prepareStatement("INSERT into member values(?,?)");
			psmt.setString(1, id);
			psmt.setString(2, pw);
			int r = psmt.executeUpdate();
			System.out.println("회원가입을 축하드립니다!("+r+"건 등록)");
		} catch (SQLException e) {
			System.out.println("회원가입 실패..");
			e.printStackTrace();
		}finally {
			close();
		}
	}





}
