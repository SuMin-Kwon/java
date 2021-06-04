package co.yedam.app.file;

import java.io.File;
import java.io.IOException;

public class FileTset {

	public static void filecreate() throws IOException {
		// 파일 생성
		File file = new File("d:/temp/diary.txt");
		boolean result = file.createNewFile();  // 위에 파일이 새로운 파일이 만들어졌는지 결과를 true,false로 나타냄
		System.out.println(result);

	}

	public static void main(String[] args) throws IOException {
		// filecreate();
		// makefolder();
		// fileInfo();
		folderlist(); // 폴더목록

	}

	private static void folderlist() {
		File file = new File("d:/temp"); // temp폴더
		if (file.isDirectory()) {		// 디렉토리인지?  
			File[] list = file.listFiles();  // 파일들의 경로부터 파일상세내용들을 배열에 저장 / or 파일이름만 가져오는것 가능함 (list)
			for (File li : list) {  // for문을 돌려서 배열안에 파일안에서 png파일만 출력
				if(StringUtil.getExtention(li.getName()).equals("png")) { // 확장자만 찾아오는 메서드 불러옴
				System.out.println(li.getName());  //png 파일의 이름들만 출력
				FileUtil.copy(li.getAbsolutePath(),"d:/temp/images/"+ li.getName()); // png파일들을 다시 폴더에 복사함
				 // getAbosulutePath() --> li에 담긴 파일들의 경로위치를 가져와서 "d:/temp/images/" 파일안에 복사하는데 이름은 li의 이름 그대로 복사하겠다는 내용 
				}
			}
		}

	}

	private static void fileInfo() {
		File file = new File("d:/temp/img.png");
		System.out.println("파일크기 " + file.length()); // 파일크기
		System.out.println("파일이름 " + file.getName()); // 파일이름

	}

	private static void makefolder() {

		File file = new File("d:/temp/images");
		file.mkdir(); // 디렉토리 폴더를 생성

	}

}
