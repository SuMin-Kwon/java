package co.green.model;

public class GreenMemo {

	String id;
	String m_date;
	String title;
	String content;
	
	public GreenMemo() {}

	public GreenMemo(String id, String m_date, String title, String content) {
		super();
		this.id = id;
		this.m_date = m_date;
		this.title = title;
		this.content = content;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getM_date() {
		return m_date;
	}

	public void setM_date(String m_date) {
		this.m_date = m_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

	@Override
	public String toString() {
		return "GreenMemo [id=" + id + ", m_date=" + m_date + ", title=" + title + ", content=" + content + "]";
	}

	public String memoPrint() {
		return "*  날짜 : " + m_date + ", 제목 : " + title + ", 내용 : " + content ;
	}
	
	
	
	
}
