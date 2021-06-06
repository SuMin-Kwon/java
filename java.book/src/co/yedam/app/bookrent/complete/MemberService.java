package co.yedam.app.bookrent.complete;

import java.util.Scanner;

public class MemberService implements Service{
	
	Member[] member;
	int cnt;
	int maxCnt = 10;
	Scanner scanner = new Scanner(System.in);
	
	public MemberService() {
		member = new Member[maxCnt];
	}
	
	
	// 회원등록
	@Override
	public void input() {
		if(cnt > maxCnt) {
			System.out.println("더 이상 추가할 수 없습니다.");
			return;
		}
		System.out.printf("이름>");
		String name = scanner.next();
		System.out.print("휴대폰>");
		String phone = scanner.next();
		member[cnt] = new Member(name, phone); 
		cnt++;
		System.out.println("등록된 회원수:" + cnt);
		
	}
	
	// 회원수정
	@Override
	public void update() {
			System.out.printf("수정할 번호>");
			int idx = scanner.nextInt();
			if(idx >= cnt-1) {
				System.out.println("없는 번호입니다.");
				return;
			}
			System.out.print("휴대폰번호>");
			String phone = scanner.next();
			member[idx].setPhone(phone);
			System.out.println("수정되었습니다.");
		
	}
	
	// 회원삭제
	@Override
	public void delete() {
		System.out.printf("삭제할 번호>");
		int idx = scanner.nextInt();
		if(idx > cnt-1) {
			System.out.println("없는 번호입니다.");
			return;
		}
		for(int i=idx; i<cnt-1; i++) {
			member[i] = member[i+1];
		}
		cnt--;
		System.out.println("삭제되었습니다.");
		
	}
	
	//  회원전체조회
	@Override
	public void selectAll() {
		System.out.println(String.format("%-20s %-20s", "회원명", "번호"));
		System.out.println("================================================================");
		for(int i=0; i<cnt; i++) {
			System.out.println(String.format("%-20s %-20s", member[i].getName(), member[i].getPhone()));
		}
		System.out.println("================================================================");
	}
	
	// 회원한명조회
	@Override
	public void selectOne() {
		System.out.printf("조회할 번호>");
		int idx = scanner.nextInt();
		if(idx > cnt-1) {
			System.out.println("없는 번호입니다.");
			return;
		}
		System.out.println(String.format("회원명:%s   휴대폰:%s", member[idx].getName(), member[idx].getPhone()));
	}
	

}
