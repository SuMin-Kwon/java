package co.green.access;

import java.util.ArrayList;

import co.green.model.Board;
import co.green.model.Green;
import co.green.model.GreenLogin;
import co.green.model.GreenMemo;

public interface GreenAccess {

	public void insert(String name,int a, int b, int c);
	
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
	void changeDate(String a, String id);

	// 물 주는 날짜 가져오기
	public String wDate(String id);
	// 물 주는 날짜 초기화
	public void insertDate(String a, String id);

	// 가지치기 날짜 가져오기
	public String pDate(String id);
	// 가지치기 날짜 초기화
	public void insertPdate(String nowDay, String id);

	// 영양제 날짜 가져오기
	public String fDate(String id);
	// 영양제 날짜 초기화
	public void insertFdate(String nowDay, String id);

	// 마이페이지 목록
	public GreenLogin myPage(String id);

	// 비밀번호 변경
	public void chagePw(String b_pw, String id);
	// 닉네임 변경
	public void chageNname(String b_name, String id);
	
	
	// 메모등록
	public void inserMemo(String id, String date, String title, String content);
	// 메모 전체조회
	public ArrayList<GreenMemo> memoList(String id);
	// 메모 삭제
	public void deleteMemo(String id, String date, String title);

	// 게시판 등록
	public void insert(String b_title, String b_content, String id);
	
	// 게시판 권한
	boolean roginTrueKey(int id, String u_id);
	// 게시글 삭제
	public void delete(int id);
	// 댓글
	public void replyDelete(int b_id);
	// 게시글 리스트
	public ArrayList<Board> allBoard();


	
}
