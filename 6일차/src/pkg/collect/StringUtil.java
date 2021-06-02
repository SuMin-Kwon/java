package pkg.collect;

public class StringUtil {

	//파일명 추출
	public static String getFilename(String path) {
		String s = null;
		if (path == null) return null; // path에 널값인지 아닌지 확인후 리턴해줌
		s = path.substring(path.lastIndexOf("/")+1);
		return s;
	}
	//확장자
	public static String getExtention(String path) {
		String s = null;
		if (path == null) return null;
		s = path.substring(path.lastIndexOf(".")+1);
		return s;
	}
	// 경로 c:/temp/image
	public static String getPath(String path) {
		String s = null;
		if (path == null) return null;
		s = path.substring(0,path.lastIndexOf("/")-1);
		return s;
	}
	
	
	
}
