package co.yedam.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import co.friend.model.Friend;

public class CollectionEx3 {

	public static void main(String[] args) {

		Map<String, Friend> map = new HashMap<>();
		//		key : 라벨				value 값
		map.put("반장", new Friend("1반","홍길동","1111"));
		map.put("평범", new Friend("2반","홍평범","2222"));
		map.put("선생님", new Friend("1반","홍두깨","3333"));
		map.put("반장", new Friend("1반","박길동","1212")); // 중복된 값으로 들어오면 바뀐값으로 바뀜
		// 이미 Friend에서 중복되는 값은 걸러주는걸로 함
		
		//System.out.println(map.get("반장"));
		// 키에 중복되는값은 허용하지 않아서 첫번째 홍길동은 나오지 않음
		System.out.println(map.get("선생님"));
		System.out.println("────────────────────────────────────────<키값만 뽑아서 가져오는 방식>───────");
		
		
		// KEY값만 담음
		Set<String> keys = map.keySet();
		// key의 리턴타입을 마우스오버 해서 확인후 확인
		Iterator<String> iter = keys.iterator();		// key 값만 따로 가지고 와서 저장하고
		while(iter.hasNext()) {	
			String key = iter.next();
			Friend val = map.get(key);					// value를 가져옴
			System.out.println("key: "+ key + ", val: "+ val.toString());
		}
		
		
		System.out.println("───────────────────────────────────────────────────────< entry 방식 >──────");
		// Friend : key,  Integer : value
		Map<Friend, Integer> scores = new HashMap<>();
		scores.put(new Friend("1반","홍길동","1111"), 80);
		scores.put(new Friend("1반","정인영","2222"), 90);
		scores.put(new Friend("1반","김효진","3333"), 89);
		scores.put(new Friend("1반","윤지민","4444"), 91);
		scores.put(new Friend("1반","홍길동","1111"), 85);
		// 동일한 키값이 있슴
		
		Set<Entry<Friend,Integer>> ent = scores.entrySet(); 		// entry : 한건의 데이터 타입 , 마우스오버하면 타입이 entry타입임
		// Entry = map.entry
		Iterator<Entry<Friend,Integer>> eiter = ent.iterator();
		while(eiter.hasNext()) {
			Entry<Friend,Integer> e = eiter.next();
			System.out.println(e.getKey() + " : "+ e.getValue());
		}
		
		
		System.out.println("───────────────────────────────────────────────────────< 문제 >──────");
		
	}

}
