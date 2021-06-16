package co.green.model;

public class GreenGrow {
	
	String u_id;
	String u_plant;
	String g_date;
	String g_Pdate;
	String g_Fdate;
	String growDate;
	
	public GreenGrow () {}

	public GreenGrow(String u_id, String u_plant, String g_date, String g_Pdate, String g_Fdate, String growDate) {
		super();
		this.u_id = u_id;
		this.u_plant = u_plant;
		this.g_date = g_date;
		this.g_Pdate = g_Pdate;
		this.g_Fdate = g_Fdate;
		this.growDate = growDate;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_plant() {
		return u_plant;
	}

	public void setU_plant(String u_plant) {
		this.u_plant = u_plant;
	}

	public String getG_date() {
		return g_date;
	}

	public void setG_date(String g_date) {
		this.g_date = g_date;
	}

	public String getG_Pdate() {
		return g_Pdate;
	}

	public void setG_Pdate(String g_Pdate) {
		this.g_Pdate = g_Pdate;
	}

	public String getG_Fdate() {
		return g_Fdate;
	}

	public void setG_Fdate(String g_Fdate) {
		this.g_Fdate = g_Fdate;
	}

	public String getGrowDate() {
		return growDate;
	}

	public void setGrowDate(String growDate) {
		this.growDate = growDate;
	}

	@Override
	public String toString() {
		return "GreenGrow [u_id=" + u_id + ", u_plant=" + u_plant + ", g_date=" + g_date + ", g_Pdate=" + g_Pdate
				+ ", g_Fdate=" + g_Fdate + ", growDate=" + growDate + "]";
	}
	
	

}
