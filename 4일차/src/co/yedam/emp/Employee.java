package co.yedam.emp;

/*
 * 사원정보
 */


public class Employee {
	
	int employeeId;		// 사번
	String name;		// 이름
	int departmentId;	// 부서번호
	String departmentName; // 10:인사  20:개발  30:영업(기본값)
	int salary;			// 급여
	String email;		// 이메일
	



	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", departmentId=" + departmentId
				+ ", departmentName=" + departmentName + ", salary=" + salary + ", email=" + email + "]";
	}

	Employee () {
		this(0,"",0,0,"");
	}

	public Employee(int employeeId, String name, int departmentId, int salary, String email) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		if(departmentId == 0) {
			departmentId = 30;  // 비어있거나 0이면 영업으로 기본값
		}
		this.departmentId = departmentId;
		
		if (departmentId == 10) {
			this.departmentName = "인사";
		}
		else if (departmentId == 20) {
			this.departmentName = "개발";
		}
		else {
			this.departmentName = "영업";
		}
		this.salary = salary;
		this.email = email;
	}

	public Employee(int employeeId, String name) {
		this(employeeId,name,0,0,""); // 다른생성자 불러올때는 항상 맨위에 먼저 불러와야함
	}
	public Employee(int employeeId, String name, String email) {
		this(employeeId,name,0,0,email);
	}
	public Employee(int employeeId, String name, int salary) {
		this(employeeId,name,0,salary,"");
	}


}
