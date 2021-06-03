package exam13;

class Student {
	String name;
	int age;

	void Student() {
		Student("James", 25);
	}

	void Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
}