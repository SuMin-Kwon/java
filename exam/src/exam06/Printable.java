package exam06;

public interface Printable {

	public void setMargin();

	public void setOrientation();
}

abstract class Paper implements Printable { // Line 7
	public void setMargin() {
	}
	// Line 9
}

abstract class NewsPaper extends Paper { // Line 12
	public void setMargin() {
	}
	// Line 14
}
