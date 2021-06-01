package co.micol.tv;

public class BeanFactory {

	public static Object getBean(String beanName) {
		
		// Object : 최상위 클래스(모든 클래스의 최상위)
		
		if (beanName.equals("Lg")) {
			return new LgTv();
		} else if (beanName.equals("Samsung")) {
			return new SamsungTv();
		}
		return null;
	}
	
}
