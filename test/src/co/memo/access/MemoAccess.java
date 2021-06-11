package co.memo.access;

import java.util.ArrayList;

import co.memo.model.Memo;

public interface MemoAccess {
	
	// 등록
	public void write(String date, String title, String content);
	
	// 수정
	public void update(String title, String content);

	// 삭제
	public void delete(String title);
	
	// 전체조회
	public ArrayList<Memo> FindAll();
	
	// 날짜조회
	public Memo FindByDate(String date);
	
	// 내용조회
	public ArrayList<Memo> FindByContent(String content);
}
