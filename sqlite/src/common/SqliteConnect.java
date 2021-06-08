package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class SqliteConnect {

	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;

	// 1. 조회, 2. 입력, 3. 수정, 4.삭제, 5. 전체리스트(각각 기능을 분리) => 메소드로 기능분리

	// 전체리스트
	public static ArrayList<Person> getPersonList() { // getPersonList 메서드의 타입은 ArrayList<Person> 임

		ArrayList<Person> personList = new ArrayList<>(); // 아무것도 담기지않은 list를 만듬
		connect(); // Connection 객체 연결
		String sql = "select * from person"; // 데이터베이스에 넣어주기 위해서 변수로 만듬
		try {
			psmt = conn.prepareStatement(sql); // prepareStatement 쿼리를 실행하고 결과를 받아오는 객체임
			rs = psmt.executeQuery(); // 쿼리 실행결과를 가져와서 rs에 저장
			while (rs.next()) {
				// System.out.println(rs.getInt("id")+ ","+ rs.getString("name"));
				Person person = new Person(); // 데이터 베이스에서 가져온 값을 person에 담을려고 선언함
				person.setId(rs.getInt("id")); // 가져온 값은 person의 id에 들어가게 수정해줌
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				person.setPhone(rs.getString("phone"));
				personList.add(person); // personList에 위에 값들은 추가해줌
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 실행 했건 안했건 무조건 실행 해주는것
			close();
		}
		return personList;
	}

	// 한건 조회
	public static Person getPerson(int id) {
		connect();
		String sql = "select * from person where id = ?"; // 데이터베이스의 쿼리문
		Person p = null;
		try {
			psmt = conn.prepareStatement(sql); // prepareStatement 객체 생성 (실행해서 실행값을 던지고 결과를 다시 가져옴
			psmt.setInt(1, id); // 1은 첫번째 파라미터를 가르켜 id를 ?에 집어넣어서 sql을 실행시켜라는 뜻임
			rs = psmt.executeQuery();
			if (rs.next()) {
				p = new Person(); // instance 를 생성하고 변수 p에 대입
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setPhone(rs.getString("phone"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 실행 했건 안했건 무조건 실행 해주는것
			close();
		}
		return p;

	}
	// 이름조회기능
	public static ArrayList<Person> namePerson(String name) {
		ArrayList<Person> personList = new ArrayList<>();
		connect();
		String sql = "SELECT * FROM Person WHERE name = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,name);
			rs = psmt.executeQuery();
			while (rs.next()) {					
					Person p = new Person();;
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setAge(rs.getInt("age"));
					p.setPhone(rs.getString("phone"));
					personList.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personList;
	}	

	// 입력기능
	public static void insertPerson(int id, String name, int age, String phone) {
		connect();
		String sql = "INSERT into Person values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.setString(2, name);
			psmt.setInt(3, age);
			psmt.setString(4, phone);
			int r = psmt.executeUpdate(); // executeUpdate : insert, update, delete 할때 사용함
			// insert하는 건수를 int r에 담음 (총 1건 입력)
			System.out.println(r + "건 입력되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		}finally { // 실행 했건 안했건 무조건 실행 해주는것
			close();
		}

	}
	
	// 삭제기능
	public static void deletePerson(int id) {
		connect();
		String sql = "DELETE FROM Person WHERE id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { // 실행 했건 안했건 무조건 실행 해주는것
			close();
		}		
	}
	// 수정기능
//	public static void updatePerson(int id, String name, int age, String phone) {
	public static void updatePerson(Person p) {
		connect();
		String sql = "UPDATE Person set name= ?, age = ?, phone = ? WHERE id= ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,p.getName());
			psmt.setInt(2,p.getAge());
			psmt.setString(3,p.getPhone());
			psmt.setInt(4,p.getId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, name);
//			psmt.setInt(2, age);
//			psmt.setString(3, phone);
//			psmt.setInt(4, id);
//			int r = psmt.executeUpdate();
//			System.out.println(r + "건 수정되었습니다.");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally { 
//			close();
//		}
	} 
	
	//연결
	public static void connect() {

		String url = "jdbc:sqlite:C:/sqlite/db/sample.db";
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("연결성공!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	// 닫음
	public static void close() {		// 1번만 실행하고 닫아주지 않아서 오류남, 그래서 닫아주는 메서드를 만듬
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
//		connect();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("1.전체리스트  2.입력  3.수정  4.삭제  5.한건조회  6.이름조회  9.종료");
			int menu = scanner.nextInt();
			if (menu == 1) {
				
				// 전체리스트 기능 구현
				System.out.println("***********************조회결과***********************");
				 ArrayList<Person>list = getPersonList();
					for (Person person : list) {
						System.out.println(person);
					}
			
			}else if(menu == 2) {
				//입력
				System.out.println("아이디를 입력하세요> ");
				int id = scanner.nextInt();
				scanner.nextLine();	
				System.out.println("이름를 입력하세요> ");
				String name = scanner.nextLine();
				System.out.println("나이를 입력하세요> ");
				int age = scanner.nextInt();
				scanner.nextLine();
				System.out.println("번호를 입력하세요> ");
				String phone = scanner.nextLine();
				
				insertPerson(id,name,age,phone);
				
			}
			else if(menu == 3) {
				System.out.println("조회할 아이디를 입력하세요> ");
				int searchid = scanner.nextInt(); scanner.nextLine();
				Person p = getPerson(searchid);
				if (p == null) {		// 아이디가 존재하지 않으면
					System.out.println("존재하지 않는 아이디");
					continue; // while 다시 처음으로 돌아감
				}
				System.out.println("수정할 이름> ");
				String uname = scanner.nextLine();
				System.out.println("수정할 나이> ");
				String uage = scanner.nextLine();
				System.out.println("수정할 번호> ");
				String uphone = scanner.nextLine();
	//			int uid = scanner.nextInt();
	//			scanner.nextLine();	
	//			System.out.println("수정할 이름> ");
	//			String uname = scanner.nextLine();
	//			System.out.println("수정할 나이> ");
	//			int uage = scanner.nextInt();
	//			scanner.nextLine();
	//			System.out.println("수정할 번호> ");
	//			String uphone = scanner.nextLine();
	//			updatePerson(uid,uname,uage,uphone);
				// 변경한 값이 똑같으면 변경 안시키는것
				if(!uname.equals("")) {
					p.setName(uname);
				}
				if(!uage.equals("")) {
					p.setAge(Integer.parseInt(uage));
				}
				if(!uphone.equals("")) {
					p.setPhone(uphone);
				}
				updatePerson(p);
				
			}
			else if(menu == 4) {
				System.out.print("삭제할 아이디를 입력하세요>");
				int searchId = scanner.nextInt();
				deletePerson(searchId);
			}
			else if(menu == 5) {
				//한건 조회
				System.out.print("조회 아이디를 입력하세요>");
				int deleteId = scanner.nextInt();
				Person p = getPerson(deleteId);
				if(p ==null) { // 위에서 객체 생성을 바로 하게 되면 조건값은 p.getId() == 0 이면
					System.out.println("조회된 값이 없습니다.");
				}
				else {System.out.println(p);}
				
			}
			else if(menu == 6) {
				System.out.println("조회할 이름를 입력하세요> ");
				String searchName = scanner.next();
				ArrayList<Person>list = namePerson(searchName);
				for (Person person : list) {
					System.out.println(person);
				}
				
			}
			else if(menu == 9) {
				break;
			}
		}
		
		
		// 입력받아서 insert
//		System.out.println("아이디를 입력하세요> ");
//		int id = scanner.nextInt();
//		scanner.nextLine();				// nextint 뒤에 커서가 바로 다음줄로 갈수 있도록 넣어줌
//		System.out.println("이름를 입력하세요> ");
//		String name = scanner.nextLine();
//		System.out.println("나이를 입력하세요> ");
//		int age = scanner.nextInt();
//		scanner.nextLine();
//		System.out.println("번호를 입력하세요> ");
//		String phone = scanner.nextLine();
//		
//		insertPerson(id,name,age,phone);
//		
//		System.out.println("***********************조회결과***********************");
//		 ArrayList<Person>list = getPersonList();
//		for (Person person : list) {
//			System.out.println(person);
//		}
		
		
		
		// 입력받은 아이디 조회
//		System.out.print("조회 아이디를 입력하세요>");
//		int searchId = scanner.nextInt();
//		Person p = getPerson(searchId);
//		if(p ==null) { // 위에서 객체 생성을 바로 하게 되면 조건값은 p.getId() == 0 이면
//			System.out.println("조회된 값이 없습니다.");
//		}
//		else {System.out.println(p);}
		
		// 전체리스트 조회
		// getPersonList 값은 리스트에 담았기 때문에 똑같은 리스트 타입으로 값을 받음
		// 받는 값이랑 리턴 값이랑 타입이 같아야함
//		 ArrayList<Person>list = getPersonList();
//		for (Person person : list) {
//			System.out.println(person);
//		}
		
		scanner.close();
		System.out.println("정상적인 종료");
	} // end of main()

} // end of class
