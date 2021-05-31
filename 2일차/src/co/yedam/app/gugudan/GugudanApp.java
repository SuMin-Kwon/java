package co.yedam.app.gugudan;

public class GugudanApp {
	
	
	// 입력받은 단만 출력
	public void printDan(int dan) {
		for (int i=1; i < 10; i++) {
			System.out.print(dan + "x"+ i +"=" + dan*i + "\t");
		}
		System.out.println();
	}
	public void printAll() {
		for (int e=1; e < 10; e++) {
			for (int j=1; j < 10; j++) {
				System.out.println(e+"x"+ j + "="+ e*j);
			}	
		}
	}
	
	public void printAllReverse() {
		for (int e=9; e > 0; e--) {
			for (int j=9; j > 0; j--) {
				System.out.println(e+"x"+ j + "="+e*j);
			}
		}
		
	}
	public void printRange(int s, int e) {
		for (int j=s; j <= e; j++) {
			for (int i=1; i < 10; i++) {
				System.out.println(j+"x"+ i + "="+ j*i);
			}
			
		}
	}	
		
	
}
	
