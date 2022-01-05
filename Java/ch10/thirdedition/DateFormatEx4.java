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
		
		System.out.print("��¥�� " + pattern + " ���·� �Է��� �ּ���>>");
		
		// �Է�
		while(scanner.hasNextLine()) {
			try {
				inDate = df.parse(scanner.nextLine());
				break;
			} catch (ParseException e) {
				System.out.print("��¥�� " + pattern + " ���·� �ٽ� �Է��� �ּ���>>");
			}
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(inDate);
		Calendar today = Calendar.getInstance();
		long difference = 
				(today.getTimeInMillis() - cal.getTimeInMillis())/(60*60*1000);
		System.out.println("�Է��� ��¥�� ���� ��¥�� ���̴� " + difference +"�ð� �����Դϴ�.");
	}
}
