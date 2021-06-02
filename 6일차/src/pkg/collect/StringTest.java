package pkg.collect;

public class StringTest {

	public static void main(String[] args) {

		String str = "hello everybody!!";
		char c = str.charAt(1);
		System.out.println("인덱스위치의 첫번째글자: " +str.charAt(0));
		System.out.println("인덱스위치의 두번째글자: " + c);
		
		System.out.println("글자 자름: " + str.substring(6,11));
		System.out.println("글자가 있는지: " + str.contains("body"));
		System.out.println("글자끝에 있는지: " + str.endsWith("!!"));
		System.out.println("글자시작에 있는지: " + str.startsWith("hel"));
		
		
		String num = "201030-1231234";
		String[] arr = num.split("-");
		System.out.println(arr[0]);
		System.out.println(arr[1].charAt(0));
		
		String path = "c:/temp/image/a.jpg";
		int pos = path.indexOf("/"); // "/"의 글자값이 어디 있는지 숫자로 받음
		int pos2 = path.lastIndexOf("/");
		int pos3 = path.lastIndexOf("/",pos2 +1); // pos2 + 1 끝에서 부터 찾은 숫자에서 한번더 찾음
		System.out.println(pos + " : " + pos2);
		
	
		// 마지막 .의 위치에서 +1 부터 전부다 끝까지 : lastIndexOf , substring 
		System.out.println("확장자: "+ path.substring(path.lastIndexOf(".")+1));
		
		System.out.println("파일명: "+ StringUtil.getFilename(path));
		
		System.out.println("경로: "+ StringUtil.getPath(path));
		
		
		
		String b = "문자열 문자";
		//String d = new String(b.getBytes(),"euc-kr");
		
		b = b.replace("문자", "숫자");
		System.out.println(b);
		
		
		
		
		
	}

}
