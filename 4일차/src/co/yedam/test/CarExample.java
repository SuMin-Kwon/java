package co.yedam.test;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2. 객체 생성(인스턴스)
		Car myCar = new Car();
		System.out.println("제작회사:"+ myCar.company);
		System.out.println("속도는:"+ myCar.speed); 
		
		myCar.speed = 60; // 값을 변경 가능
		System.out.println("속도는:"+ myCar.speed);

		
		//생성자 생성
		Car youCar = new Car("르노","SM6","블루"); 
		System.out.println(youCar);
		
		Car miniCar = new Car("코나", 40);
		System.out.println(miniCar);
//		youCar.company = "르노";  
//		youCar.maxSpeed = 400;
//		youCar.color = "블루";
//		System.out.println("제작회사:"+ youCar.company);
//		System.out.println("속도는:"+ youCar.maxSpeed);
//		System.out.println("색깔:"+ youCar.color);
		// 일일이 하나씩 값을 따로 넣어주기 귀찮을때
		// 첨부터 생성자라고 만들어놓으면 값을 여기서 
		// 변환하기만 하면됨
		
		
		
	}

}
