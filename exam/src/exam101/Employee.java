package exam101;

class Employee {
	private String name;
	private int age;
	private int salary;
	
	public Employee() {}

	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Employee(String name, int age, int salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	// getter and setter methods for attributes go here
	public void printDetails() {
		System.out.println(name + " " + age + " : " + salary);
	}
}
