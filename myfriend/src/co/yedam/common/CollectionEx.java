package co.yedam.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/*				List는 인터페이스라서 new로 불러올수 없슴
 * collection -> List (interface) -> ArrayList , Vector, LinkedList
 * 									그래서 실제 구현 클래스를 통해서 불러올 수 있슴	
 *	 		  -> Set (interface )
 *
 *	SetCollection : 중복된 요소들은 걸러내기 위해서 사용함
 *	Collection : 리스트안에 많은 요소들을 담기 위해서 사용
 *
 */

import java.util.List;
import java.util.Set;

public class CollectionEx {

	public static void main(String[] args) {
		List<String> list = null;
		list = new ArrayList<String>();
		list.add("Hong");
		list.add("Hong");
		list.add("Choi");
		list.add("Park");
		list.remove(0);
		
		for (int i =0; i< list.size(); i++) {
			System.out.println(list.get(i));
		}
		// ****** hashcode랑 equals가 같은 같이면 동일한 값을 걸러냄 ****
		// set : 리스트같은건데 중복된 값을 허용하지 않음, 인덱스 요소가 아님
		Set<String> set = new HashSet<String>();
		set.add("hong");
		set.add("hong");
		set.add("Choi");
		set.add("Park");
									// ↘  next랑 비슷함
		Iterator<String> iter = set.iterator(); 	// iterator : Set 반복자(첫번째 요소 끄집어내고 두번째 요소 끄집어내고 가져올 요소가 없으면 더이상 안가져옴)
		while(iter.hasNext()) {						// hasNext() :  요소가 있는지 물음
			String value = iter.next(); 			// next() : 요소가 있으면 가지고옴
			System.out.println(value);
		}
	}

}
