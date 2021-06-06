package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputStream {

	public static void main(String[] args) throws IOException {

		// 한꺼번에 출력하는 방법 - ArrayList안에 저장한다음 출력함
		// 대신 글자를 입력 나가려면 Ctrl + z 해야지만 다음 출력결과를 알수 있슴...
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 리스트값의 타입을 <>안에 정해줌
		String aa = "";
		
		List<String> str = new ArrayList<>();
		while ((aa = br.readLine()) != null) {
			str.add(aa);
		}
		for (String s : str) {
			System.out.println(s);
		}
//		문제풀이 1번	
//		try {
//			while (true) {
//				String a = br.readLine();
//				if (a == null)
//					break;
//				out.println(a);
//			}
//			br.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		문제풀이 2번
//		String str = "";
//		while ((str = br.readLine()) != null){
//			System.out.println(str);
//		}
		
		
		
		
	}

}
