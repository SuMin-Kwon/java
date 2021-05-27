package co.yedam.app;

public class MemberInfoMain {
	public static void main(String[] args) {
		MemberInfo member = new MemberInfo();
		member.input();
		member.heightWeightInput();
		member.bmi();
		member.print();
		System.out.println("당신의 bmi 지수는 "+member.result+" : "+ member.bmi());
	}

}
