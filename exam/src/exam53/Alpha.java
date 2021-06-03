package exam53;

class Alpha {
	int ns;
	static int s;

	Alpha(int ns) {
		if (s < ns) {
			s = ns;
			this.ns = ns;
		}
	}

	void doprint() {
		System.out.println("ns= " + ns + " s = " + s);
	}
}
