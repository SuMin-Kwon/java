package alone.test;



public class AloneTest {

	public static void main(String[] args) {
		
		int charCode = 'A';
		
		if ((charCode >= 65) && (charCode <= 90)){
			System.out.println("대문자군요");
			System.out.println(charCode);
		}
		if (!(charCode < 48)&& !(charCode >57)) {
			System.out.println("0~9숫자군요");
			System.out.println(charCode);
		}
		if ((charCode >=97)&& (charCode <= 122)) {
			System.out.println("소문자군요");
			System.out.println(charCode);
			
		}
		
		
	}

}
