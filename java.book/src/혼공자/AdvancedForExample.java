package 혼공자;

public class AdvancedForExample {

	public static void main(String[] args) {

		int [] score = {90, 85, 65, 75, 100};
		int sum =0;
		for (int i : score) {
			sum += i;
		}
		
		System.out.println("총 합: "+ sum);
		
		double avg = sum / score.length;
		System.out.println("평균: "+ avg);
		
		// 최대값
		int max = score[0];
		int min = score[0];
		for (int i : score) {
			if (i > max) {
				max = i; 
			}
		}

		for (int i : score) {
			if (i < min) {
				min = i;
			}
		}
			
		System.out.println("최대값:"+ max);
		System.out.println("최소값:"+ min);
	
	}

}
