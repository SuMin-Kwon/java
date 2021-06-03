package exam09;

class Point {
	int x;
	int y;

	void assign(int x, int y) {
		x = this.x;
		this.y = y;
	}

	public String toString() {
		return "Point(" + x + ",	" + y + ")";
	}
}
