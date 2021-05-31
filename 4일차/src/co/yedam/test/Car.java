package co.yedam.test;

/*
 * 자동차 정보
 * String []
 */

public class Car {

	
		//필드 (상태, 속성, 등)
		String company;
		String model;
		String color;
		int maxSpeed;
		int speed;
		
		
		// 생성자
		/*
		 * 객체 생성시에 호출되어 필드 초기화를 하는 특수용도의
		 * 메서드 입니다
		 * 생성자 이름은 클래스명과 동일!
		 * 리턴 타입 없음 ( 아예 적으면 안됨!)
		 * 생성자 여러개 중복 선언(= 오버로딩)은 가능하지만  
		 * 매개변수의 타입과 갯수는 달라야함.
		 */
		Car(String company ,String model,String color){
			this(company,model,color,0,0);
// 			this.company = company;
//			this.model = model;
//			this.color = color;
		}
		
		@Override
		public String toString() {
			return "Car [company=" + company + ", model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed
					+ ", speed=" + speed + "]";
		}
		Car () {
			this("현대","그랜저","검정",350,0);
			
		}
		
		// source > generate constructor > model , speed 초기화시킬수 있슴
		public Car(String model, int speed) {
			this("",model,"",0,speed); // 생성자안에서 다른 생성자 호출하는 방법
		}

		public Car(String company, String model, String color, int maxSpeed, int speed) {
			super();
			this.company = company;
			this.model = model;
			this.color = color;
			if (maxSpeed > 100) {
				this.maxSpeed = maxSpeed;
			}
			else {
				this.maxSpeed = 100;
			}
			
			if (speed > 50) {
				this.speed = speed;
			}
			else {
				this.speed = 50;
			}
		}

		
		

	

}
