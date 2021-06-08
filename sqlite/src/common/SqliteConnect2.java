
public class SqliteConnect2 {
	
	
	package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

		
		PreparedStatement psmt;
		ResultSet rs;
		Connection conn;
		
		// 1. 조회, 2. 입력, 3. 수정, 4.삭제, 5. 전체리스트(각각 기능을 분리) => 메소드로 기능분리
		


		public static void connect() {

			Connection conn = null;
			String url = "jdbc:sqlite:C:/sqlite/db/sample.db";
			try {
				conn = DriverManager.getConnection(url);
				System.out.println("연결성공!!!");
				// PreparedStatement db에서 자바로 실행을 가져오는 메서드
				PreparedStatement psmt = conn.prepareStatement("select * from person");
				ResultSet rs = psmt.executeQuery(); // executeQuery 실행,

				// 가져올 데이터만큼 while을 돔 --> 데이터가 없으면 false
				while (rs.next()) { // next : 가져오는 값이 있으면 true로 하고 rs에 첫번째 값을 가지고옴 그리고 다음 가져올 값이 있는지 확인함
					System.out.printf("id: %3d,  name: %3s,  age: %2d,  phone: %10s", rs.getInt("id"), rs.getString("name"),
							rs.getInt("age"), rs.getString("phone")); // person이라는 값을 지정하는 칼럼들을 가져옴
					System.out.println(); // 줄바꿈
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

		}

		public static void main(String[] args) {
			connect();
		}

	}


