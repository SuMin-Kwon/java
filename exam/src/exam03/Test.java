package exam03;

public class Test {
	public static void change(Message m) {
		m = new Message();
		m.msg = "Happy	Holidays!";
	}

	public static void main(String[] args) {
		Message obj = new Message();
		obj.print();
		change(obj);    // change 메소드를 쓸려면 앞에 클래스.을 같이 불러줘야함
		obj.print();   
	}
}