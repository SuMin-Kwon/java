package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO {
	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;

	// 전체리스트
	public ArrayList<Employee> getEmloyeeList() {

		ArrayList<Employee> emloyeeList = new ArrayList<>();
		connect();
		String sql = "SELECT EmployeeId,FirstName,LastName,BirthDate,Title FROM employees";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Employee emplyee = new Employee();
				emplyee.setEmployeeId(rs.getInt("EmployeeId"));
				emplyee.setFirstName(rs.getString("FirstName"));
				emplyee.setLastName(rs.getString("LastName"));
				emplyee.setBirthDate(rs.getString("BirthDate"));
				emplyee.setTitle(rs.getString("Title"));
				emloyeeList.add(emplyee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return emloyeeList;
	}

	// 연결
	public void connect() {

		String url = "jdbc:sqlite:C:/sqlite/db/chinook.db";
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("연결성공!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 리소스를 반환하는 부분
	public void close() {
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
