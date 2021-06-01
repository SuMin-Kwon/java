package 클래스;

public class ClacStatic {
	
//	static int result;
//	
//		return result;
//	}
	// final : (상수)변경불가
	// 변수는 다 대문자로 해줌
	// static : 모든 객체가 공유하는 필드
	final static double PI = 3.14;

	@Override
	public String toString() {
		return "ClacStatic [pi=" + PI + "]";
	}
	
	public static int add(int inNum1, int inNum2) {
		return  inNum1 + inNum2 ;
		}

}
