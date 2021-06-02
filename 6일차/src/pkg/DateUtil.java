package pkg;

/*
 * 정적 메서드 안에서는 정적필드만 접근할 수 있다
 * 접근제어자 : private >     default >      projected >     public 
 *  			클래스 내부  같은패키지  다른패키지-상속
 * 
 */


public class DateUtil {

	// String date = "2021-06-02";  date값을 리턴 못함
	// date를 쓸려면 static을 붙여줘야함
	// 아니면 curDate 안에서 new 객체를 만들어줘야함
	// DateUtil dateUtil = new DateUtil();
	// 
	// static String date = "2021-06-02";
	public static String curDate() {
		return "2021-06-02";
	}
	
}
