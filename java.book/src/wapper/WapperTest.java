package wapper;

import java.util.ArrayList;
import java.util.List;

/*
 *  1. 기본 데이터형을 객체화
 *  2. 타입 변환
 */

public class WapperTest {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(10));
		list.add(new Integer("10"));	// 박싱
		list.add(100); 					// Integer 객체로 박싱
		
		Integer a = 100;
		int b = a.intValue(); // 언박싱
		b = a;  // (자동)오토 언박싱

		String s = Integer.toString(a);  // int -> String 으로 변환할때 toString임
	
	
	}

}
