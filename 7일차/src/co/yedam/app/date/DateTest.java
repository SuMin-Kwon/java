package co.yedam.app.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {

		Date date = new Date();
		
		System.out.println(System.currentTimeMillis());

		Calendar calender = Calendar.getInstance();
		
		int year = calender.get(Calendar.YEAR);
		int month = calender.get(Calendar.MONTH);
		int day = calender.get(Calendar.DAY_OF_MONTH);
		int day_year = calender.get(Calendar.YEAR);
		int hour = calender.get(Calendar.HOUR);
		int minute = calender.get(Calendar.MINUTE);
		int second = calender.get(Calendar.SECOND);
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(day_year);
		System.out.println(hour);
		System.out.println(minute);
		System.out.println(second);

		// 살아온 일수 계산
		
		Calendar birth = Calendar.getInstance();
		birth.set(1993, 0, 26);
		long dur = calender.getTimeInMillis() - birth.getTimeInMillis();
		dur = dur/1000/60/60/24;
		System.out.println("태어난 일수: " + dur);
		
		// 기념일 계산
		Calendar dday = Calendar.getInstance();
		dday.set(2021, 5, 17); //  2021 - 06 -17
		long durr = dday.getTimeInMillis() - calender.getTimeInMillis();
		durr = durr/1000/60/60/24;
		System.out.println("D-day : " + durr);
		
		LocalDate currentDate = LocalDate.now();  // 현재날짜
		System.out.println(currentDate.getYear() + " / " +
				currentDate.getMonthValue() + " / " + 
				currentDate.getDayOfMonth()	);

		System.out.println(currentDate.plusDays(100)); //현재날짜에서 100일후
		
		//DAte - 날짜, localTime - 시간
	
		
		// Date -> String
		SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 d일 E요일");
		System.out.println(df.format(calender.getTime()));
		
		// String -> Date
		
		
		
		
		
		
		
		
	}	

}
