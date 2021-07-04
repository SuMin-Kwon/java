package 백준;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class MonthDay {

	public static void main(String[] args) {
		
		// 기본날짜를 2007년 1월 1일 월요일로 맞추고
		// 거기서 부터 일수에 7을 나눔 그리고 나머지값으로 요일 구별
		// 월별을 if문으로 조건을 둠
		
		Scanner sc = new Scanner(System.in);
		
		String date = sc.next();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.KOREA);
		LocalDate gijundate = LocalDate.parse(date, formatter);
		
		// 요일계산
		
		//1. 기준날짜에서 입력한 날짜를 빼서 날짜로 요일을 계산?
		
		//2. 입력한 날짜를 7로 나누는데, 월, 일 ,년도 다 나눠서 계산해야하므로
		//   월의 마지막일의 조건을 달아줘야함
	}

}
