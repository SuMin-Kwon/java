package exam01;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student("James", 25));
		students.add(new Student("James", 27));
		students.add(new Student("James", 25));
		students.add(new Student("James", 25));
		students.remove(new Student("James", 25));  // remove 안됨. 인덱스 번호로 넣어야지 삭제됨 
		for (Student stud : students) {
			System.out.println(stud);
		}
	}
}