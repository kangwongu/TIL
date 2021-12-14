import java.util.Calendar;

public class Ex10_3 {
	public static void main(String[] args) {
//		                          1�ð�   1��   1��
		// �ú��ʷ� ��ȯ�� �ʿ� ������ ��� �迭�� �Է��Ѵ�.
		final int[] TIME_UNIT = {3600, 60, 1};
		final String[] TIME_UNIT_NAME = {"�ð�", "��", "��"};
		
		// �ð� �ν��Ͻ� ����, time1, time2
		Calendar time1 = Calendar.getInstance();
		Calendar time2 = Calendar.getInstance();
		
		// �� �ð� �ν��Ͻ��� �ð��� ���Ѵ�
		time1.set(Calendar.HOUR_OF_DAY, 9);
		time1.set(Calendar.MINUTE, 30);
		time1.set(Calendar.SECOND, 30);
		
		time2.set(Calendar.HOUR_OF_DAY, 10);
		time2.set(Calendar.MINUTE, 30);
		time2.set(Calendar.SECOND, 30);
		
		// �� �ð� �ν��Ͻ��� �ð��� ����Ѵ�
		System.out.println(time1.get(Calendar.HOUR_OF_DAY)+"��"+time1.get(Calendar.MINUTE)+"��"+time1.get(Calendar.SECOND)+"��");
		System.out.println(time2.get(Calendar.HOUR_OF_DAY)+"��"+time2.get(Calendar.MINUTE)+"��"+time2.get(Calendar.SECOND)+"��");
		
		// �� �ð� �������̽��� �ð����̸� ����Ѵ�.
		// getTimeInMillisȰ��, 1000���� ��������� ��
		long difference = Math.abs(time2.getTimeInMillis() - time1.getTimeInMillis())/1000;
		
		// ����� �ð��� �ú��ʷ� ��ȯ�Ѵ�.
		String tmp="";
		for(int i=0; i<TIME_UNIT.length; i++) {
			tmp += difference/TIME_UNIT[i] + TIME_UNIT_NAME[i];
			difference %= TIME_UNIT[i];
		}
		System.out.println(tmp);
		// String������ ��Ƽ� ���
	
	}
}

