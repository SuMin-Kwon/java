package co.yedam.common;

import java.util.List;
import java.util.OptionalDouble;
import com.yedam.Person;
import com.yedam.PersonDAO;

public class StreamExample {

	public static void main(String[] args) {

		// 1. 스트림  2.중간처리&최종처리  3.결과
		
		List<Person> list = null;
		PersonDAO dao = new PersonDAO();
		list = dao.getPersonList();
		OptionalDouble avg = list.stream()								// 스트림 생성
			.filter( (t) -> t.getAge() % 2 == 0 )		// 나이가 짝수인 사람만 가지고 옴
		//  .forEach( (v) -> System.out.println(v) );
			.filter(  (t) -> t.getId() > 20 )
			.mapToInt((p) -> p.getAge() )
//			.mapToInt(new ToIntFunction<Person>() {		
//				@Override
//				public int applyAsInt(Person p) {  // 매핑 a -> b
//					return p.getAge(); 	
//				}})
			.average();			// 나이 평균
		// 최종적으로 
		if(avg.isPresent()) {
			System.out.println("평균나이는 : "+avg.getAsDouble());			
		} else {
			System.out.println("만족하는 요소가 없습니다.");
		}
		
		
		
		
	}

}
