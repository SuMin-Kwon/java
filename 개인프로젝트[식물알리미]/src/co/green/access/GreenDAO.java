package co.green.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.green.model.Green;

public class GreenDAO implements GreenAccess {

	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;

	public String myPlant(String id) {
		String plantName = "";
		connect();
		String sql = "SELECT u_plant from rogin WHERE u_id =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				plantName = rs.getString("u_plant");
			}
			if (rs.next() == false) {
				plantName = "없음";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return plantName;
		
	}
	
	
	@Override
	public void nameInsert(String plantName, String id) {
		connect();
		String sql = "UPDATE rogin set u_plant = ? WHERE u_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, plantName);
			psmt.setString(2, id);
			int r = psmt.executeUpdate();
			System.out.println("선택하신 식물 "+ r + "개 선택 완료되었습니다!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}

	
	// 새로운 식물등록
	@Override
	public void insert(String name, int a, int b, int c) {
		connect();
		String sql = "INSERT into green values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setInt(2, a);
			psmt.setInt(3, b);
			psmt.setInt(4, c);
			int r = psmt.executeUpdate();
			System.out.println("새로운 식물이 "+ r + "건 등록되었습니다!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}

	@Override
	public void delete() {

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
			while(rs.next()) {
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
		}finally {
			close();
		}
		return green;
	}

	// 회원가입
	public void roginInsert(String id, String pw, String name) {
		connect();
		String sql = "INSERT into rogin(u_id, u_pw, u_name) values(?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);
			int r = psmt.executeUpdate();
			System.out.println("회원가입 " + r + "건이 등록 되었습니다!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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



}
