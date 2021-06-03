package exam219;

public class Person {
	String name;
	int age = 25;

	Person(String name) { // line n1
		setName(name);
	}

	private void setName(String name2) {
		// TODO Auto-generated method stub
		
	}

	public Person(String name, int age) { // line n2
		Person(name);
		setAge(age);
	}

	private void Person(String name2) {
		// TODO Auto-generated method stub
		
	}

	private void setAge(int age2) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		Person p1 = new Person("Jesse");
		Person p2 = new Person("Walter", 52);
		System.out.println(p1.show());
		System.out.println(p2.show());
	}

	private char[] show() {
		// TODO Auto-generated method stub
		return null;
	}
}

// setter and getter method go here
	