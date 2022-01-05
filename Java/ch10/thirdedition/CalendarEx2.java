package thirdedition;

import java.util.Calendar;

public class CalendarEx2 {
	public static void main(String[] args) {
		final String[] DAY_OF_WEEK = {"", "��", "��", "ȭ", "��", "��", "��", "��"};
		
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
	
		cal1.set(2015, 7, 15);	// 2015-08-15
		
		// ���� ����غ���
		System.out.println(toString(cal1)+", "+
				DAY_OF_WEEK[cal1.get(Calendar.DAY_OF_WEEK)]+"����");
		
		System.out.println(toString(cal2)+", "+
				DAY_OF_WEEK[cal2.get(Calendar.DAY_OF_WEEK)]+"����");
		
		// ��¥ �� ���̾��
		long difference = 
				(cal2.getTimeInMillis() - cal1.getTimeInMillis())/1000;
		System.out.println("cal2�� cal1������ ����"+difference+"�� ������");
		System.out.println("�Ϸ� ����ϸ� "+difference/(24*60*60)+"�� ���");
		
	}
	
	public static String toString(Calendar cal) {
		return cal.get(Calendar.YEAR)+"�� "+(cal.get(Calendar.MONTH)+1)
				+"�� "+cal.get(Calendar.DATE)+"�� ";
	}

}
