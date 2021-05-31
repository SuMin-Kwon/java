package co.yedam.emp;

import java.util.Scanner;



public class EmployeeApp {
	

	Scanner scanner = new Scanner(System.in);
	Employee[] employee = new Employee[10];
	int cnt = 0;
	
	void insert(int employeeId , String name, int departmentId, int salary, String email) {

		employee[cnt] = new Employee(employeeId, name,departmentId ,salary,email);
		cnt++;
	}
	
	//사원수 입력
	void init() {
		System.out.println("사원수>");
		int num = scanner.nextInt();
		employee = new Employee[num];
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
		for (int i=0; i<= cnt; i++) {
			if (no == (employee[i].employeeId)) {
				named = employee[i].name;
			System.out.println("이름은 "+ named);	
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
