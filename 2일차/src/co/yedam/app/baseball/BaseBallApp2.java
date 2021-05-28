package co.yedam.app.baseball;

import java.util.Random;
import java.util.Scanner;

/*
 * 임의의 수 3개
 * 사용자 수를 입력
 * 스트라익, 볼, 카운터
 */




public class BaseBallApp {

   int s;
   int b;
   int u1, u2, u3;
   int c;
   int c1, c2, c3;
   
   void makeRnd() {
      Random rnd = new Random();
      c1 = (int)(Math.random()*9)+1;
      c2 = (int)(Math.random()*9)+1;
      c3 = (int)(Math.random()*9)+1;
   
   }
      
      //c1 = 난수;
   
   void input() {
      //u1 = ;
      Scanner scanner = new Scanner(System.in);
      System.out.print("입력1");
      String u1 = scanner.next();
      System.out.print("입력2");
      String u2 = scanner.next();
      System.out.print("입력3");
      String u3 = scanner.next();
      scanner.close();
   }
   
   int count() {
         if (c1 == u1 && c2 == u2 && c3 == u3) {
            s++;}         
         else if (c1 == u1) { 
                 s++;   }
         else if (c1 == u3 || c1 == u2 ) {
                 b++; }
         else if (c2 == u2) {
                 s++;}
         else if (c2 == u3 || c2 == u1) {
                 b++; }
         else if (c3 == u3) {
                 s++; }
         else if (c3 == u2 || c3 == u1) {
                 b++;}         
            }
         }
   
   void start() {
      makeRnd();
      while(s < 3) {
         s =0; b=0;
      
         input();
         count();
         
      }
   }

}