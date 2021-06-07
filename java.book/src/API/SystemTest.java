package API;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class SystemTest {

	public static void main(String[] args) throws URISyntaxException, FileNotFoundException {

		// 파일명을 rename 할때 사용, 실행시간 체크할떄 (시작시간과 끝나는 시간 파악해서 실행시간 체크가능함)
		System.out.println(System.currentTimeMillis());

		// 종료 0이면 비정상 실행, 0이 아닌 값은 정상적 실행임
		// System.exit(1);

		//시스템의 환경변수를 불러옴 (시스템의 모든 정보를 읽어올수 있음)
		Map<String, String> map = System.getenv();
		System.out.println(map.get("JAVA_HOME")); // java 홈만 가져옴
		System.out.println();
		Iterator<String> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + ":"+ map.get(key));
		}
		//System.gc  - 가비지 컬렉터 : 자바에서 제공하는 특징! 메모리 제거기능
		
		System.out.println();
		//reflect
		Field[] field = Bkook.class.getDeclaredFields();
		for (Field f : field) {
			System.out.println(f.getName()+ ":"+f.getType());
		}
		URI uri = Bkook.class.getResource("/resource/menu.txt").toURI(); // 상대경로
		Scanner sc = new Scanner (new File(uri));
		System.out.println(sc.next()); // 문장 전체 읽어올려면 FOR문 돌려야함
	}

}
