package 혼공자;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) throws IOException {
		//????
		InputStream is = new FileInputStream("c:/Temp/test1.txt");

		while (true) {
			int data = is.read();
			if (data == -1) break;
			System.out.println(data);
		}
		is.close();

	}

}
