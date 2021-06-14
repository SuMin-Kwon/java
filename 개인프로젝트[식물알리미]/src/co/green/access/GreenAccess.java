package co.green.access;

import java.util.ArrayList;

import co.green.model.Green;

public interface GreenAccess {

	public void insert(String name,int a, int b, int c);
	
	public void delete();
	
	public ArrayList<Green>listAll();

	// 로그인
	public boolean rogin(String id, String pw);

	// 회원가입
	public void roginInsert(String id, String pw, String nname);

	// 식물 선택
	public void nameInsert(String plantName, String id);

	public String myPlant(String id);
	
}
