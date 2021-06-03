package co.yedam.app.file;

import java.io.FileReader;
import java.io.FileWriter;

public class TextFileCopy {

	public static void main(String[] args) {
		// 파일 경로 위치가 잘못될 수있어서 예외처리하라고 경고가 뜸
		// 
		try {
			FileReader fr = new FileReader("d:/temp/data.txt");
			FileWriter fw = new FileWriter("d:/temp/data1.txt");
			int c;
			while (true) {
				c = fr.read();
				if (c == -1) {
					break;
				}
				fw.write(c);
			}
			fr.close();
			fw.close();
		} catch (Exception e) { // FileNotFoundException 에서 앞부분 지우면 에러안뜸

			e.printStackTrace();
		}
		
//      배열일때		
//		try {
//			FileReader fr = new FileReader("d:/temp/data.txt");
//			FileWriter fw = new FileWriter("d:/temp/data2.txt");
//			char []c = new char[100];
//			while (true) {
//				int cnt = fr.read(c);
//				if (cnt == -1) {
//					break;
//				}
//				fw.write(c);
//			}
//			fr.close();
//			fw.close();
//		} catch (Exception e) { // FileNotFoundException 에서 앞부분 지우면 에러안뜸
//
//			e.printStackTrace();
//		}

	}

}
