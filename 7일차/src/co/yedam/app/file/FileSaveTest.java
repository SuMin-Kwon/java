package co.yedam.app.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;


// 키보드로 입력 후 파일로 저장함 --> 콘솔창에서 입력후 Ctrl + z (끝내고 나가는 단축키)
public class FileSaveTest {

	public static void main(String[] args) {
		try {
		// byte(1바이트) : stream (바이너리파일), char(2~3) : reader (텍스트파일)
		BufferedReader isr = new BufferedReader( new InputStreamReader(System.in));
			// 키보드로 읽음
			// buffer로 묶어주면 한글자가 아닌 한줄씩 읽어줌
		BufferedWriter br = new BufferedWriter( new FileWriter("d:/temp/f.dat"));
			
		// 파일로 저장하겠슴
		while(true) {
			String c = isr.readLine(); //int c = isr.read() 한글자씩 읽어냄
			if (c == null) break;
			br.write(c);
			br.write("\n");
		}
		br.close();
		//System.out.println(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
	

}
