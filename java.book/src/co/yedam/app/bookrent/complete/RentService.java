package co.yedam.app.bookrent.complete;

import java.util.Scanner;

public class RentService implements Service {

	Rent [] rent;
	int cnt;
	int maxCnt = 10;
	
	Scanner scanner = new Scanner(System.in);
	
	public RentService(){
		rent = new Rent[maxCnt];
	}
	// 대여등록
	@Override
	public void input() {
		if(cnt > maxCnt) {
			System.out.println("더 이상 대여할 수 없습니다.");
			return;
		}
		System.out.printf("이름>");
		String name = scanner.next();
		System.out.println("제목>");
		String title = scanner.next();
		System.out.println("대여날짜");
		String date = scanner.next();
		rent[cnt++] = new Rent(name,title,date ); 
		System.out.println("등록된 건수:" + cnt);
		
	}
	// 대여수정
	@Override
	public void update() {
		System.out.printf("수정할 번호>");
		int idx = scanner.nextInt();
		if(idx >= cnt-1) {
			System.out.println("없는 번호입니다.");
			return;
		}
		System.out.print("이름>");
		String name = scanner.next();
		rent[idx].setName(name);
		System.out.print("대여날짜>");
		String date = scanner.next();
		rent[idx].setDate(date);
		System.out.println("수정 되었습니다.");
		
	}
	// 대여취소
	@Override
	public void delete() {
		System.out.printf("취소할 번호>");
		int idx = scanner.nextInt();
		if(idx > cnt-1) {
			System.out.println("없는 번호입니다.");
			return;
		}
		for(int i=idx; i<cnt-1; i++) {
			rent[i] = rent[i+1];
		}
		cnt--;
		System.out.println("취소 되었습니다.");
		
	}
	// 전체조회
	@Override
	public void selectAll() {
		System.out.println(String.format("%-20s %-20s %-20s", "이름", "책제목","대여일"));
		System.out.println("================================================================");
		for(int i=0; i<cnt; i++) {
			System.out.println(String.format("%-20s %-20s %-20s", rent[i].getName(), rent[i].getTitle(),rent[i].getDate()));
		}
		System.out.println("================================================================");
		
	}
	// 단건조회
	@Override
	public void selectOne() {
		System.out.printf("조회할 번호>");
		int idx = scanner.nextInt();
		if(idx > cnt-1) {
			System.out.println("없는 번호입니다.");
			return;
		}
		System.out.println(String.format("이름:%s   책제목:%s   대여일:%s", rent[idx].getName(), rent[idx].getTitle(),rent[idx].getDate()));
		
	}
	
	
}
