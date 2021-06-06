package 혼공자;

import java.util.HashSet;
import java.util.Set;

public class MemberHashSet {

	public static void main(String[] args) {

		Set<MemberHash> set = new HashSet<MemberHash>();
		
		// 각각의 객체를 생성하지만 내부데이터는 동일해서 객체 1개만 저장함
		set.add(new MemberHash("홍길동", 30));
		set.add(new MemberHash("홍길동", 30));
		
		System.out.println("총 객체수 : " + set.size());
		
	}

}
