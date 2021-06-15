package co.green.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.green.model.Board;
import co.green.model.Green;
import co.green.model.GreenLogin;
import co.green.model.GreenMemo;

public class GreenDAO implements GreenAccess {

	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;

	// 닉네임 출력
	public String myPlant(String id) {
		String plantName = "없음";
		connect();
		String sql = "SELECT u_plant from rogin WHERE u_id =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				plantName = rs.getString("u_plant");
			}
			if (plantName == null) {
				plantName = "없음";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return plantName;

	}

	// 키울 식물 추가
	@Override
	public void nameInsert(String plantName, String id) {
		connect();
		String sql = "UPDATE rogin set u_plant = ? WHERE u_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, plantName);
			psmt.setString(2, id);
			int r = psmt.executeUpdate();
			System.out.println("선택하신 식물 " + r + "개 선택 완료되었습니다!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	// 새로운 식물등록
	@Override
	public void insert(String name, int a, int b, int c) {
		connect();
		String sql = "INSERT into green (g_name,g_water,g_pruning,g_food) values(?,?,?,?);";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setInt(2, a);
			psmt.setInt(3, b);
			psmt.setInt(4, c);
			int r = psmt.executeUpdate();
			System.out.println("새로운 식물이 " + r + "건 등록되었습니다!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	// 게시글 삭제
	@Override
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
		} finally {
			close();
		}
	}

	// 식물 리스트
	@Override
	public ArrayList<Green> listAll() {
		ArrayList<Green> green = new ArrayList<>();
		Green gr = null;
		connect();
		String sql = "select * from green ";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				gr = new Green();
				gr.setG_id(rs.getInt("g_id"));
				gr.setPlantName(rs.getString("g_name"));
				gr.setPlantWater(rs.getInt("g_water"));
				gr.setPlantPruning(rs.getInt("g_pruning"));
				gr.setPlantFood(rs.getInt("g_food"));
				green.add(gr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return green;
	}

	// 마이 페이지 목록
	public GreenLogin myPage(String id) {
		GreenLogin gl = null;
		connect();
		String sql = "SELECT *FROM rogin WHERE u_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				gl = new GreenLogin();
				gl.setU_id(rs.getString("u_id"));
				gl.setU_pw(rs.getString("u_pw"));
				gl.setU_phone(rs.getString("u_phone"));
				gl.setU_Nname(rs.getString("u_Nname"));
				gl.setU_plant(rs.getString("u_plant"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return gl;
	}

	// 회원가입
	public void roginInsert(String id, String pw, String name, String jumin, String phone) {
		connect();
		String sql = "INSERT into rogin(u_id, u_pw, u_Nname, u_jumin, u_phone) values(?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);
			psmt.setString(4, jumin);
			psmt.setString(5, phone);
			int r = psmt.executeUpdate();
			System.out.println("회원가입 " + r + "건이 등록 되었습니다!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	// 로그인
	public boolean rogin(String id, String pw) {
		connect();
		boolean R = false;
		String sql = "SELECT *FROM rogin WHERE u_id = ? AND u_pw = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if (rs.next()) {
				R = true;
			} else {
				System.out.println("일치하는 ID, PW 존재하지 않습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return R;
	}

	// 로그인 정보
	public ArrayList<GreenLogin> LoginList() {
		ArrayList<GreenLogin> gl = new ArrayList<>();
		GreenLogin grl = null;
		connect();
		String sql = "select * from rogin ";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				grl = new GreenLogin();
				grl.setU_id(rs.getString("u_id"));
				grl.setU_pw(rs.getString("u_pw"));
				grl.setU_Nname(rs.getString("u_Nname"));
				grl.setU_jumin(rs.getString("u_jumin"));
				grl.setU_phone(rs.getString("u_phone"));
				gl.add(grl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return gl;
	}

	// 비밀번호 변경
	@Override
	public void chagePw(String b_pw, String id) {
		connect();
		String sql = "UPDATE rogin set u_pw= ? WHERE u_id =? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, b_pw);
			psmt.setString(2, id);
			int r = psmt.executeUpdate();
			System.out.println("비밀번호가 " + r + "건 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	// 닉네임 변경
	@Override
	public void chageNname(String b_name, String id) {
		connect();
		String sql = "UPDATE rogin set u_Nname= ? WHERE u_id =? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, b_name);
			psmt.setString(2, id);
			int r = psmt.executeUpdate();
			System.out.println("닉네임이 " + r + "건 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	// 연결
	public static void connect() {

		String url = "jdbc:sqlite:C:/sqlite/db/green.db";
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("DB 연결실패...");
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

	// 식물 선택시 현재날짜로 초기화
	@Override
	public void changeDate(String a, String id) {
		connect();
		String sql = "UPDATE rogin set g_date = ?,g_Pdate  = ?, g_Fdate = ?, growDate= ? WHERE u_id= ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, a);
			psmt.setString(2, a);
			psmt.setString(3, a);
			psmt.setString(4, a);
			psmt.setString(5, id);
			int r = psmt.executeUpdate();
			System.out.println("오늘부터 키우기 " + r + "일!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	// 물 주는 날짜 업데이트
	public void insertDate(String a, String id) {
		connect();
		String sql = "UPDATE rogin set g_date = ? WHERE u_id= ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, a);
			psmt.setString(2, id);
			int r = psmt.executeUpdate();
			System.out.println("물주기 " + r + "건 등록되었습니다!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	// 물 주는 날짜 가져오기
	public String wDate(String id) {
		String wDate = "";
		connect();
		String sql = "SELECT g_date from rogin WHERE u_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				wDate = rs.getString("g_date");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return wDate;

	}

	// 가지치기 날짜 가져오기
	public String pDate(String id) {
		String pDate = "";
		connect();
		String sql = "SELECT g_Pdate from rogin WHERE u_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				pDate = rs.getString("g_Pdate");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return pDate;
	}

	// 가지치기 날짜 업데이트
	@Override
	public void insertPdate(String nowDay, String id) {
		connect();
		String sql = "UPDATE rogin set g_Pdate = ? WHERE u_id= ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, nowDay);
			psmt.setString(2, id);
			int r = psmt.executeUpdate();
			System.out.println("가지치기 " + r + "건 등록되었습니다!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	// 영양제 날짜 가져오기
	public String fDate(String id) {
		String fDate = "";
		connect();
		String sql = "SELECT g_Fdate from rogin WHERE u_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				fDate = rs.getString("g_Fdate");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return fDate;
	}

	// 영양제 날짜 업데이트
	@Override
	public void insertFdate(String nowDay, String id) {
		connect();
		String sql = "UPDATE rogin set g_Fdate = ? WHERE u_id= ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, nowDay);
			psmt.setString(2, id);
			int r = psmt.executeUpdate();
			System.out.println("영양제 " + r + "건 등록되었습니다!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	// 간단메모등록
	@Override
	public void inserMemo(String id, String nowDay, String title, String content) {
		connect();
		String sql = "INSERT into memo values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, nowDay);
			psmt.setString(3, title);
			psmt.setString(4, content);
			int r = psmt.executeUpdate();
			System.out.println("메모 " + r + "건이 등록되었습니다!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	// 메모 전체조회
	public ArrayList<GreenMemo> memoList(String id) {
		ArrayList<GreenMemo> gmList = new ArrayList<>();
		GreenMemo gm = null;
		connect();
		String sql = "select * FROM memo WHERE id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				gm = new GreenMemo();
				gm.setM_date(rs.getString("m_date"));
				gm.setTitle(rs.getString("title"));
				gm.setContent(rs.getString("content"));
				gmList.add(gm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return gmList;
	}

	// 메모 삭제
	@Override
	public void deleteMemo(String id, String m_date, String title) {
		connect();
		String sql = "DELETE FROM memo WHERE id = ? and m_date = ? and title = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, m_date);
			psmt.setString(3, title);
			int r = psmt.executeUpdate();
			System.out.println("메모 " + r + "건이 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	// 게시판 등록
	@Override
	public void insert(String b_title, String b_content, String id) {
		connect();
		try {
			psmt = conn.prepareStatement("INSERT into board(b_title, b_content, b_writer) values(?,?,?)");
			psmt.setString(1, b_title);
			psmt.setString(2, b_content);
			psmt.setString(3, id);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

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
			if (rs.next()) {
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

	// 댓글
	public void replyDelete(int id) {
		connect();
		String sql = "DELETE FROM board WHERE b_parentid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			int r = psmt.executeUpdate();
			System.out.println("댓글" + r + "건 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	// 게시글 전체리스트
	@Override
	public ArrayList<Board> allBoard() {
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

}
