package pkg.other;

import pkg.Car;
import pkg.Count;
import pkg.DateUtil;
// 다른 패키지를 임폴드 해야지 접근 가능
// curDate 접근 하려면 public 해야지 접근가능
import pkg.ProjectInfo;


public class AppMain {

	public static void main(String[] args) {
		
		
		Car car = new Car(); // Car()이 생성자임
		// 기본으로 컴파일러가 기본생성자를 만들어줌
		
		car.setModel("현대"); // 이렇게 변경하지말고
		car.setSpeed(100);
		
		Car car2 = new Car("삼성", 60); // 생성자를 만들어서 해줌
		Car car3 = new Car("현대");
		System.out.println();
		
	
		
		

		System.out.println(DateUtil.curDate());
		System.out.println(ProjectInfo.name);
		// 다른패키지에서 접근하려면 필드값도 public이 들어가야함
		
		
		Count count1= new Count();
		Count.cnt1++;
		count1.setCnt2(count1.getCnt2() + 1);
		// private 하면 값을 수정하거나 읽을수가 없어서 
		// getter : 읽기 ,조회 / setter : 수정 
		// 을 이용해서 접근가능
		
	}

}
