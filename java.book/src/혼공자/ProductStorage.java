package 혼공자;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductStorage {
	// list 컬렉션 생성
	private List<Product> list = new ArrayList<>();
	// 키보드 입력 생성
	private Scanner sc = new Scanner(System.in);
	// pno 제공 카운터
	private int counter;

	// 메뉴 출력
	public void showMenu() {
		while(true) {
			System.out.println("-------------------------");
			System.out.println("1. 등록 | 2. 목록 | 3. 종료 ");
			System.out.println("-------------------------");
			
			System.out.print("선택: ");
			String select = sc.nextLine();  // 번호 읽기
			switch(select) {
				case "1" : registerProduct(); break;	 // 제품 등록
				case "2" : showProducts(); break;		 // 등록된 모든 제품 정보 보기
				case "3" : return;						 // 프로그램 종료
				}
			}
		}
	

	public void registerProduct () {
		try {
			//pno 세팅
			Product product = new Product();
			product.setPno(++counter);
			
			System.out.print("상품명: ");
			product.setName(sc.nextLine());			// 이름을 읽고 세팅
			
			System.out.print("가격: ");
			product.setPrice(Integer.parseInt(sc.nextLine()));
			
			System.out.print("재고: ");
			product.setStock(Integer.parseInt(sc.nextLine()));
			
			list.add(product);
		} catch (Exception e) {
			System.out.println("등록 에러: "+ e.getMessage());
		}
	}
	
	// 모든 제품 읽기
	private void showProducts() {
		for (Product p : list) {
			System.out.println(p.getPno() + "\t" + p.getName() + "\t" +
							   p.getPrice() + "\t" + p.getStock());
		}
		
	}
}
