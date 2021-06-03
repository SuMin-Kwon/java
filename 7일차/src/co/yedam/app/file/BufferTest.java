package co.yedam.app.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

public class BufferTest {

	public static void main(String[] args) {
		try {
			
			BufferedReader fr = new BufferedReader(new FileReader("d:/temp/data.txt"));
			PrintStream out = System.out; // 화면출력
			String a;
			while (true) {
				a = fr.readLine();
				if ( a == null) break;
				out.println(a);
			}
			fr.close();

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
