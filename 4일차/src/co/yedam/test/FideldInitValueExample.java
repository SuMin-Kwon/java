package co.yedam.test;

public class FideldInitValueExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FieldInitValue fivv = new FieldInitValue();
		System.out.println(fivv.toString());
		
		
		FieldInitValue fiv = new FieldInitValue(10,10.5);
		System.out.println(fiv.i);
		System.out.println(fiv.d);
	}

}
