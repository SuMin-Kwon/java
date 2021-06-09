package co.yedam.common;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import co.friend.access.FriendDAO;

public class CollectionEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FriendDAO dao = new FriendDAO();

		Map<String, String> map = dao.getNameTel();
		Set<String> keys = map.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			String val = map.get(key);
			System.out.println("name: "+ key + ", tel: "+ val.toString());
		}

	}

}
