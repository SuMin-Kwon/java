package co.green.access;

import java.time.LocalDate;
import java.util.ArrayList;

import co.green.model.Green;
import co.green.model.GreenLogin;

public interface GreenAccess {

	public void insert(String name,int a, int b, int c);
	
	public void delete();
	
	public ArrayList<Green>listAll();

	// 로그인
	public boolean rogin(String id, String pw);

	// 회원가입
	public void roginInsert(String id, String pw, String Nname, String jumin, String phone);

	// 식물 선택
	public void nameInsert(String plantName, String id);
	
	// 키우는 식물 추가
	public String myPlant(String id);

	// 날짜 초기화
	public void insertDate(String a, int selectNum);

	// 물 주는 날짜 가져오기
	public String wDate(String nname);
	// 물 주는 날짜 초기화
	public void insertDate(String a, String plantName);

	// 가지치기 날짜 가져오기
	public String pDate(String plantName);
	// 가지치기 날짜 초기화
	public void insertPdate(String nowDay, String plantName);

	// 영양제 날짜 가져오기
	public String fDate(String plantName);
	// 영양제 날짜 초기화
	public void insertFdate(String nowDay, String plantName);

	// 마이페이지 목록
	public GreenLogin myPage(String id);

	
}
