package co.micol.fly;

/*
 * 인터페이스
 * 1. 다중상속
 * 2. public abstract 생략 모든메서드 추상메서드
 * 3. 개발표준
 *  인터페이스를 쓰는 목적은 만약 중간에 부속이
 *  변경해야할때를 대비하여서 개발 가이드를 제시
 */

public interface Flyer {

	
	
	public abstract void takeOff();

	void fly();

	void land();

}