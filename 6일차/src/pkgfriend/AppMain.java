package pkgfriend;

import pkg.Friend;

/*  FriendAccess 는 새로 직접 불러올수 없고
 *  밑에처럼 자식만 불러올 수 있슴
 */
public class AppMain {

	public static void main(String[] args) {
		
		Friend f = new CompanyFriend("학교","홍길동","1111","과장");
		f.print();
		// 다형성 (상속받고 오버로딩 전제조건)
		// 1. 부모타입의 참조변수가 자식객체를 참조가능 
		// 2. 메서드 실행하면 참조대상의 메서드가 호출되므로 결과가 다름
		Friend b = new SchoolFriend("학교","홍길동","1111","1월2일");
		b.print();
		
		
		// BeanFactory.getBean : 자동으로 상속받는거를 가져옴
		// FriendAccess.class -- > FriendAccess의 상속되는 클래스들만 불러오는 값
		// FriendAccess list = BeanFactory.getBean(FriendAccess.class);//new FriendList();
		
		
		// 밑에 코드로 하면 나중에 소스를 손봐야하지만
		// 위에 코드로 하면 굳이 수정할 필요없이 상속되는 클래스만 바꾸면됨
		// FriendAccess list = new FriendList();
		// list.selectAll();
		
		FriendManager manager = new FriendManager();
		for ( Friend fr : manager.friend) {  // 참조하는 대상 : FriendManager 
			if (fr instanceof CompanyFriend) // 타입을 비교해서 회사친구면 회사친구만 출력함ㄴ
 			fr.print();
		}
		
		
		
		
		
		
	}

}
