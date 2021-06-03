package exam76;

public class Test {
	void readCard(int cardNo) throws Exception {
		System.out.println("Reading Card");
	}

	void checkCard(int cardNo) throws RuntimeException {
		System.out.println("Checking Card");
	}

	public static void main(String[] args) {
		Test ex = new Test();
		int cardNo = 12344;
		try {
			ex.readCard(cardNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ex.checkCard(cardNo);
	}
}