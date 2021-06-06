package co.yedam.emp;

import java.util.Scanner;



public class EmployeeApp {
	

	Scanner scanner = new Scanner(System.in);
	Employee[] employee;  // 배열을 선언
	int cnt = 0;
	
//	void insert(int employeeId , String name, int departmentId, int salary, String email) {
//
//		employee[cnt] = new Employee(employeeId, name,departmentId ,salary,email); // class Employee를 배열에 담겠다는 내용임
//		cnt++;  // 추가 되어야지만 각각의 employee의 값을 하나씩 담을 수 있슴
//	}
	
	//사원수 입력
	void init() {
		System.out.println("사원수>");
		int num = scanner.nextInt();
		employee = new Employee[num];  // 맨 위에서 선언한 배열에다가 입력받은 수만큼 방을 만들겠다는 말임 
	}
	// 사원정보입력
	void input() {
		System.out.println("사번:");
		int employeeId = scanner.nextInt();
		System.out.println("이름:");
		String name = scanner.next();
		System.out.println("부서:");
		int departmentId = scanner.nextInt();
		System.out.println("급여:");
		int salary = scanner.nextInt();
		System.out.println("이메일:");
		String email = scanner.next();
		employee[cnt] = new Employee(employeeId,name,departmentId,salary,email);
		cnt++;
	}
	// 전체리스트 출력
	void print() {
		for (int i = 0; i < cnt; i++) {
			System.out.print(employee[i].employeeId+" " +employee[i].name+" " + employee[i].departmentName+" " +employee[i].salary+ "" +employee[i].email);
			System.out.println();

		}
	}
	
	
	void search() {
		System.out.print("검색할 사번>");
		int no = scanner.nextInt();
		String named;
		String emaild;
		String bo;
		int salary;
		for (int i=0; i<= cnt; i++) {
			if (no == (employee[i].employeeId)) {
				named = employee[i].name;
				emaild = employee[i].email;
				bo = employee[i].departmentName;
				salary = employee[i].salary;
				
			System.out.println(named+ "\t"+ bo + "\t"+ salary + "\t"+ emaild);	
			break;
			}
//		else {
//			if (i == cnt) {	
//			System.out.println("없습니다");	
//			}}	
		}
	}

	// 급여 합계
	int sum() {
		int result = 0;
		for (int i=0; i < cnt; i++) {
				result = result + employee[i].salary;	
			}
		return result;
	}
	
}
