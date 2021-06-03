package co.yedam.app.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

public class ScoreInputTest2 {

	public static void main(String[] args) {
		try {
			
			BufferedReader fr = new BufferedReader(new FileReader("d:/temp/data.txt"));
			PrintStream out = System.out; // 화면출력
			String a;
			while (true) {
				int b;
				a = fr.readLine(); // 성적 잘나서 빈공간에 넣어주기만 하면 됨
				String[] score = a.split(" "); // 값을 스플릿으로 나눠서 각각 배열에 담아서 그값을 parseint로 바꿔준다음 값을 더해서 출력해줌
								
				}
				
				//if ( a == null)	break;
			//out.println(a);
			//fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
//	try {
//		
//		FileReader fr = new FileReader("d:/temp/data.txt");
//		PrintStream out = System.out; // 화면출력
//		int a;
//		while (true) {
//			a = fr.read();
//			if ( a == -1) break;
//			out.print((char)a);
//		}
//		fr.close();
//
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//
//}
}
