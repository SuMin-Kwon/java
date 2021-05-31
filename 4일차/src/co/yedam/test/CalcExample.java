package co.yedam.test;

public class CalcExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calc calc = new Calc();
		calc.turnOn();
		calc.sum(2, 5);
		calc.sum(10.5, 10.7);
//		int r = calc.sum(10, 20);
		System.out.println();
	 	System.out.println(calc.sum3(1,2,3));
		System.out.println("총 합:"+calc.sum3(10,40,50,70));
		
		System.out.println("총 합:"+calc.sum3(10,40,50,70,100,30,80,900,50,70));
		
	}

}
