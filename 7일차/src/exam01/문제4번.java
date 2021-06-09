package exam01;

public class 문제4번 {

	public static void main(String[] args) {

		String[] arr = { "010102-2", "991012-1", "960304-1", "881012-2", "040403-1" };

		int W = 0;
		int M = 0;
		int a1 = 0;
		int a2 = 0;
		int a3 = 0;
		int a4 = 0;
		int result;

		String[] s;
		for (int i = 0; i < arr.length; i++) {
			s = arr[i].split("-");
			if (s[1].equals("2")) {
				W++;
			} else {
				M++;
			}
		}
		System.out.println("남 " + M + "여 " + W);

		for (int i = 0; i < arr.length; i++) {
			result = Integer.parseInt(arr[i].substring(0, 2));
			if (result < 21) {
				result = (21 - result) +1;
				if (result < 20) {
					a1 += 1;
				} else if (result < 30) {
					a2 += 1;
				} else if (result < 40) {
					a3 += 1;
				} else if (result < 50) {
					a4 += 1;
				}
			} else {
				result = (2021 - (1900+ result) +1);
				if (result < 20) {
					a1 += 1;
				} else if (result < 30) {
					a2 += 1;
				} else if (result < 40) {
					a3 += 1;
				} else if (result < 50) {
					a4 += 1;
				}
			}
		}System.out.println("10대 "+ a1);
		System.out.println("20대 "+ a2);
		System.out.println("30대 "+ a3);
		System.out.println("40대 "+ a4);
	}

}
