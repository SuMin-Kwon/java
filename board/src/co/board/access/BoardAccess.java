package co.board.access;

import java.util.ArrayList;

import co.board.model.Board;

public interface BoardAccess {

			// 등록
			public void insert(Board board);
			
			// 수정
			public void update(Board board);
			
			// 삭제
			public void delete(int id);
			
			// 전체조회
			public ArrayList<Board> listAll();
			
			// 단건조회
			public Board findDate(int id);

			// 로그인 확인
			public boolean rogin(String id, String pw);

			// 댓글추가
			public void reply(String title, String content, String writer, int parentid);

			// 댓글 리스트로 보여주기
			public ArrayList<Board> replyShow(int id);
			
			// 수정, 삭제 권한
			public boolean roginTrueKey(int id2, String id);

			//리플 삭제
			public void replyDelete(int id);

			// 로그인 회원가입
			public void insertRogin(String e1, String e2);

			
	
}
