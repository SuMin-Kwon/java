package exam05;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(2));
		list.add(new Integer(1));
		list.add(new Integer(0));
		list.remove(list.indexOf(0));
		System.out.println(list);
	}
}