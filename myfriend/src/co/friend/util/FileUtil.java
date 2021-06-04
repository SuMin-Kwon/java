package co.friend.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileUtil {

	public static void copy(String src, String des) {

		// 파일 복사
		try {
			FileInputStream fis = new FileInputStream(src);
			FileOutputStream fos = new FileOutputStream(des);
			byte[]b = new byte[100];  // 한개씩 쪼개지 않고 100개씩 쪼개서 가져오기 때문에 빠름
			while (true) {
				int cnt = fis.read(b);
				if (cnt == -1)
					break;
				fos.write(b);
			}
			fis.close();
			fos.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
