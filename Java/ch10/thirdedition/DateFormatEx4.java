package thirdedition;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateFormatEx4 {
	public static void main(String[] args) {
		String pattern = "yyyy-MM-dd";
		DateFormat df = new SimpleDateFormat(pattern);
		Scanner scanner = new Scanner(System.in);
		
		Date inDate = null;
		
		System.out.print("날짜를 " + pattern + " 형태로 입력해 주세요>>");
		
		// 입력
		while(scanner.hasNextLine()) {
			try {
				inDate = df.parse(scanner.nextLine());
				break;
			} catch (ParseException e) {
				System.out.print("날짜를 " + pattern + " 형태로 다시 입력해 주세요>>");
			}
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(inDate);
		Calendar today = Calendar.getInstance();
		long difference = 
				(today.getTimeInMillis() - cal.getTimeInMillis())/(60*60*1000);
		System.out.println("입력한 날짜와 현재 날짜의 차이는 " + difference +"시간 차이입니다.");
	}
}
