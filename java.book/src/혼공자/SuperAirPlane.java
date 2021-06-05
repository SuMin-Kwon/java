package 혼공자;

public class SuperAirPlane extends Airplane {

	public final int normal = 1;
	public final int supers = 2;

	public int flyMode = normal;

	@Override
	public void fly() {
		if (flyMode == supers) {
			System.out.println("초음속 비행합니다");
		} else {
			super.fly();
		}
	}

}