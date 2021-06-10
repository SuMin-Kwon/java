package co.yedam.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.yedam.Person;
import com.yedam.PersonDAO;

public class IteratorExample {

	public static void main(String[] args) {

		// 컬렉션 스타일은 반복자를 사용가능함
		// 그렇치만 리스트는 인덱스 요소로 가져오는 것이 가능하기 때문에 인덱스로 많이 가져옴
		// list 선언하면서 바로 추가함
		List<String> list = Arrays.asList("Hong","Park","Choi");
		Iterator<String> iter = list.iterator();		// 반복된 요소를 지정하고 사용하기 위해서 반복자라고 선언을 해줌
		while(iter.hasNext()){
			String val = iter.next();
			System.out.println(val.toUpperCase().length());		//toUpperCase : 대문자
		}
		
		
		// stream 사용시
		System.out.println("<Stream>");
		Stream<String> stream = list.stream();	
		stream.forEach(new Consumer<String>() { // consumer의 accept 추상메서드를 선언해야함

			@Override
			public void accept(String t) {			// list 안에 들어있던 요소들을 출력
				System.out.println(t);
			}	
			
		});			// forEach : 어떤 스트림에 대해서 기능을 각각 처리하겠다
		
		// sample 요소를 db에서 갖고 오도록 함
		PersonDAO dao =new PersonDAO();
		ArrayList<Person> person =dao.getPersonList();
		Stream<Person> pStream = person.stream();
		long cnt = pStream
			.filter(  (t) -> t.getAge() > 20  )		// ↙ 밑의 코드를 람다식으로 표현
			
//			.filter(new Predicate<Person>() {
//			@Override
//			public boolean test(Person t) {
//				return t.getAge() > 20; 		// 리턴값이 참인 요소만 통과
//			}
			.filter(   (t) -> t.getName().startsWith("이")   )	// 이름이 "이"로 시작하는 사람
//			.forEach(  (t) ->System.out.println(t.toString()  )   ); // 람다식
			.count();
		System.out.println("최종처리 건수: "+ cnt);
			
		
	}

}
