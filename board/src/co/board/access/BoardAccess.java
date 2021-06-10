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

			
	
}
