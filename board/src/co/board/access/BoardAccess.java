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

			public boolean rogin(String id, String pw);

			public void reply(String title, String content, String writer, int parentid);

			public ArrayList<Board> replyShow(int id);

			public boolean roginTrueKey(int id2, String id);

			
	
}
