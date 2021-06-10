package co.board.model;

public class Board {
	
	int b_id;
	String b_title;
	String b_content;
	String b_writer;
	String id;
	String pw;
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPw() {
		return pw;
	}



	public void setPw(String pw) {
		this.pw = pw;
	}



	public Board() {}
	
	
	
	// 글 리스트 조회
	public Board(int b_id, String b_title, String b_writer) {
		super();
		this.b_id = b_id;
		this.b_title = b_title;
		this.b_writer = b_writer;
	}

	// 글 작성
	public Board(String b_title, String b_content, String b_writer) {
		super();
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_writer = b_writer;
	}



	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public String getB_writer() {
		return b_writer;
	}

	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}

	public String showInfo() {
		return "글번호: " + b_id + ",  글제목< " + b_title + " >  ,작성자:" + b_writer ;
	}

	@Override
	public String toString() {
		return "[ 글번호: " + b_id + "   글제목< " + b_title + " >  내용: " + b_content + "   작성자: " + b_writer
				+ "]";
	}

	
	
	
	

}
