package pkg.collect;

import java.util.ArrayList;
import java.util.LinkedList;

import pkg.Friend;
import pkgfriend.CompanyFriend;
import pkgfriend.SchoolFriend;

public class ListTest {

	public static void main(String[] args) {

		
		// <>안에는 리스트안에 넣을 값의 타입들을 정해줌 
		// Object 는 모든 종류타입을 담을 수 있슴
		// Friend 도 넣을 수 있슴
		LinkedList<Friend> list = new LinkedList<Friend>();
		list.add(new Friend("현대","홍,","1111"));
		list.add(0, new CompanyFriend("삼성","김,","2222"));
		list.add(new SchoolFriend("삼성","김,","2222") );
		list.add(new SchoolFriend("삼성","윤","3333"));
		//System.out.println(list);
		for (Friend fr : list) {
			System.out.println(fr.getName());
		}
		System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
		
		list.remove(0); // 삭제
		for (Friend fr : list) {
			System.out.println(fr.getName());
		}
		Friend fr = list.get(0);
		System.out.println("첫번쨰 이름은 "+ fr.getName());

		// 마지막이름 : size()
		System.out.println("첫번쨰 이름은 "+ list.get(list.size()-1).getName());
		
		// 수정
		list.set(1, new Friend("중학교","최","5555"));
		for (Friend f : list) {
			System.out.println(f.getName());
		}
	}

}
