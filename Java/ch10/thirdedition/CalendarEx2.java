package thirdedition;

import java.util.Calendar;

public class CalendarEx2 {
	public static void main(String[] args) {
		final String[] DAY_OF_WEEK = {"", "일", "월", "화", "수", "목", "금", "토"};
		
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
	
		cal1.set(2015, 7, 15);	// 2015-08-15
		
		// 요일 출력해보기
		System.out.println(toString(cal1)+", "+
				DAY_OF_WEEK[cal1.get(Calendar.DAY_OF_WEEK)]+"요일");
		
		System.out.println(toString(cal2)+", "+
				DAY_OF_WEEK[cal2.get(Calendar.DAY_OF_WEEK)]+"요일");
		
		// 날짜 간 차이얻기
		long difference = 
				(cal2.getTimeInMillis() - cal1.getTimeInMillis())/1000;
		System.out.println("cal2는 cal1원으로 부터"+difference+"초 지났다");
		System.out.println("일로 계산하면 "+difference/(24*60*60)+"일 경과");
		
	}
	
	public static String toString(Calendar cal) {
		return cal.get(Calendar.YEAR)+"년 "+(cal.get(Calendar.MONTH)+1)
				+"월 "+cal.get(Calendar.DATE)+"일 ";
	}

}
