package 혼공자;

public class SuperAirPlaneAppMain {

	public static void main(String[] args) {

		SuperAirPlane superAir = new SuperAirPlane();
		superAir.takeOff();
		superAir.fly();
		superAir.land();
		
		System.out.println();
		
		superAir.flyMode = superAir.supers;
		superAir.fly();
		System.out.println();
		superAir.flyMode = superAir.normal;
		superAir.fly();
		
	}

}
