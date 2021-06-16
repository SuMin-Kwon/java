package co.green.model;

public class Board {
	
	int b_id;
	String b_title;
	String b_content;
	String b_writer;
	int b_parentid;
	
	
	public int getB_parentid() {
		return b_parentid;
	}



	public void setB_parentid(int b_parentid) {
		this.b_parentid = b_parentid;
	}


	public Board() {}
	
	
	
	public Board(int b_id, String b_title, String b_content, String b_writer, int b_parentid) {
		super();
		this.b_id = b_id;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_writer = b_writer;
		this.b_parentid = b_parentid;
	}



	public Board(String b_title, String b_content, String b_writer) {
		super();
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_writer = b_writer;
	}



	// 글 리스트 조회
	public Board(int b_id, String b_title, String b_writer) {
		super();
		this.b_id = b_id;
		this.b_title = b_title;
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
		return "글번호: " + b_id + ",  글제목< " + b_title + " >  내용: " + b_writer ;
	}
	public String showFind() {
		return "< " + b_title + " > 내용: " + b_content + " ,작성자:" + b_writer ;
	}

	@Override
	public String toString() {
		return "[ 글번호: " + b_id + "   글제목< " + b_title + " >  내용: " + b_content + "   작성자: " + b_writer
				+ "]";
	}


	
	
	
	

}
