package co.yedam.score;

public class ArrAppMain {

	
		int[] arr= new int[10];
		
		void init() {
			for (int i=0; i < arr.length; i++) {
				arr[i] = (int)(Math.random()*100)+1;
			}
			
		}
		
		
		void print() {
			for (int i=0; i < arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			
		}
		
		
		void sum() {
			int result = 0;
			for (int i=0; i < arr.length; i++) {
					result = result +arr[i];	
				}
			System.out.println("합계: "+result);
		}
		
		void max() {
			int max =arr[0];
			for (int i=0; i < arr.length; i++) {
				if (max < arr[i] ) {
					max = arr[i];
					}
				}
			System.out.println("최대값은: "+ max);
		}
	
		
		public static void main(String[] args) {
			
			ArrAppMain arr = new ArrAppMain();
			arr.init();
			arr.print();
			arr.sum();
			arr.max();
			
		}
		
		
}

