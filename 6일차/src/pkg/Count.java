package pkg;

public class Count {
	
	public static int cnt1;   // static 모든 객체들이 참조하는 공유필드임
	private int cnt2;
	public void setCnt2(int cnt2) {
		if (cnt2 < 0) {
			cnt2 = 0;
		}
		this.cnt2 = cnt2;
	}
	
	public int getCnt2() {
		return cnt2;
	}
	
	
}
