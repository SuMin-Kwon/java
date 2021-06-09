package co.friend.model;
// 친구의 한명의 정보를 저장하는 곳
public class Friend { 
	
		protected String gubun; // 구분앞에 final이 붙으면 밑에 생성자에서 초기화해줘야함
		protected String name;
		protected String tel;
		
		public Friend (){
			gubun = ""; // 파이널을 선언해주면 값을 항상 초기화 해줘야하는데 생성자에서 가능
		}		
		public Friend(String gubun, String name, String tel) {
			super();
			this.gubun = gubun;
			this.name = name;
			this.tel = tel;
		}	
		
		public void print() {
			System.out.printf("친구: %10s %10s %10s\n", gubun , name, tel);
		}
		@Override
		public String toString() {
			return "Friend [ gubun: " + gubun + ", name: " + name + ", tel: " + tel + " ]";
		}
			
		// setter : getter	
		public String getGubun() {
			return gubun;
		}
		public void setGubun(String gubun) {
			this.gubun = gubun;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		
		// object의 hashcode 오버라이딩
		@Override
		public int hashCode() {
			return  this.getGubun().hashCode() +
					this.getName().hashCode() +
					this.getTel().hashCode();
		}

		// object의 equals 오버라이딩 
		@Override
		public boolean equals(Object obj) {
			Friend f = (Friend)obj; // obj 최상위라서 모든 형변환이 가능
			return this.getGubun().equals(f.getGubun()) 
				&& this.getName().equals(f.getName()) 
				&& this.getTel().equals(f.getTel());
		}

		
}
