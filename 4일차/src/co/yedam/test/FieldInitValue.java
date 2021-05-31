package co.yedam.test;

import java.util.Arrays;

/*
 *  기본데이터형 8가지 타입은 기본값은 0으로 초기화됨
 *  참조변수 (String , [] 의 초기밧은 null
 */
public class FieldInitValue {
	
	
	byte b;
	short s;
	int i;
	long l;
	float f; 
	double d;
	boolean bool;
	char c;
	String str;
	int [] arr;
	@Override
	public String toString() {
		return "FieldInitValue [b=" + b + ", s=" + s + ", i=" + i + ", l=" + l + ", f=" + f + ", d=" + d + ", bool="
				+ bool + ", c=" + c + ", str=" + str + ", arr=" + Arrays.toString(arr) + "]";
	}
	FieldInitValue (){}
	
	
	FieldInitValue  (int ii, double dd)
	{
		i = ii;
		d = dd;
	}
	

}
