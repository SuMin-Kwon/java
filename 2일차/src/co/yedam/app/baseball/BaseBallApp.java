package co.yedam.app.baseball;

import java.util.Scanner;

/*
 * 임의의 수 3개
 * 사용자 수를 입력
 * 스트라익, 볼, 카운터
 */
public class BaseBallApp {

	
	Scanner scanner = new Scanner(System.in);
	int s;
	int b;
	int u1, u2, u3;
	int c;
	int c1, c2, c3;
	
	void makeRnd() {
		c1 = (int)(Math.random()*9)+1;
	    c2 = (int)(Math.random()*9)+1;
	    c3 = (int)(Math.random()*9)+1;
	    
        }
		
	
	void input() {
		System.out.println("===========(0 ~ 9)");
		System.out.print("숫자 1: ");
		u1 = scanner.nextInt();
		System.out.print("숫자 2: ");
		u2 = scanner.nextInt();
		System.out.print("숫자 3: ");
		u3 = scanner.nextInt();
		return;
	}
	
	void count() {
		// s , b 카운터       
        if (c1 == u1) { 
            	s++;  
        }
        else if (c1 == u3 || c1 == u2 ) {
                 b++;
                 }
        if (c2 == u2) {
                 s++;}
        else if (c2 == u3 || c2 == u1) {
                 b++; }
        if (c3 == u3) {
                 s++; }
        else if (c3 == u2 || c3 == u1) {
                 b++;}
		
	}
	
	void start() {
		makeRnd();
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		while (true){
			s = 0; b= 0;
			input();
			count();
			if (s == 3) {
				System.out.println("정답!");
				break;
			}
			
			if (s == 0) {
				if (b == 1) {
					System.out.println("볼 1");
				}
				else if (b == 2) {
					System.out.println("볼 2");
				}
				else if (b == 3) {
					System.out.println("볼 3");
				
				}
			}
		
			if (s == 1) {
				System.out.println("스트라이크1");
				if (b == 1) {
					System.out.println("볼 1");
				}
				else if (b == 2) {
					System.out.println("볼 2");
				}
				else if (b == 3) {
					System.out.println("볼 3");
				}
			}
			else if (s == 2) {
				System.out.println("스트라이크2");
				if (b == 1) {
					System.out.println("볼 1");
				}
				else if (b == 2) {
					System.out.println("볼 2");
				}
				else if (b == 3) {
					System.out.println("볼 3");
				}
			}
					
			
			
			
		}
	}

}
