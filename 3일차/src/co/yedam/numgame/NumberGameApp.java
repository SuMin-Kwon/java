package co.yedam.numgame;
/*
 * 숫자 맞추기 게임 
 * 작성자: 권수민 /ㅇㅇㅇㅇㅇㅇㅇㅇ
 */
public class NumberGameApp {
	
	int com;
	int user;
	
	// 컴퓨처가 임의 수를 생성함
	void init() {
		com = (int)(Math.random()*10)+1;
		
	}
	
	
//	int user = ; // 사용자가 입력한 값을 저장할곳
	
	// 사용자가 수를 입력
	void input() {
		
		//scanner 이용해서 정수값 입력
		
		
	}
	
	// 높다 /낮다 비교 정답은 :true / 틀리면 false
	
	boolean confirm() {
		// com과 user을 비교해서 같으면 ture 리턴
		// 다르면 높다 낮다를 출력하고 false 리턴
		if (com == user) {
			true;
		else {
			if (com > user) {
				System.out.println("낮다");
				}
			else {
				System.out.println("높다");
				}
			} 
		}
		
		
	}
	
	void start() {
		init();		// 컴터 임의 수만듬
		while (true) {  // 맞을때까지 돌림
			input();
			if (confirm()) {
				break;
			}
		}
		
	}
	
	
}
