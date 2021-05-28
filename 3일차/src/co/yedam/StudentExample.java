package co.yedam;

public class StudentExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//     2. 객체 생성 == 인스턴스
//		int a = 10;
		StudentApp app = new StudentApp();
		Student student = app.creatStudent();
		student.print();
		
	}

}
