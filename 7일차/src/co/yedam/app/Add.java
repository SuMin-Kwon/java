package co.yedam.app;

public class Add {

	public static void main(String[] args) {

		String deta1 = null;
		String deta2 = null;
		try {
			deta1 = args[0];
			deta2 = args[1];
//		} catch (Exception e) {
//			System.out.println("숫자를 2개 입력!");
//			return;  // --> 하는 이유는 return이 없으면 위에 에러시와 밑에 에러시 둘다 나옴 그래서 첫번째에 걸릴때
//		}	         //     다시 돌아가도록 return을 걸어줌
//		try {

			int value1 = Integer.parseInt(deta1);
			int value2 = Integer.parseInt(deta2);
			System.out.println(value1 / value2);
			
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("2개 입력");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		

	}

}
