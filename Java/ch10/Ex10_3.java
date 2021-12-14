import java.util.Calendar;

public class Ex10_3 {
	public static void main(String[] args) {
//		                          1시간   1분   1초
		// 시분초로 변환할 초와 단위를 상수 배열로 입력한다.
		final int[] TIME_UNIT = {3600, 60, 1};
		final String[] TIME_UNIT_NAME = {"시간", "분", "초"};
		
		// 시간 인스턴스 얻어옮, time1, time2
		Calendar time1 = Calendar.getInstance();
		Calendar time2 = Calendar.getInstance();
		
		// 각 시간 인스턴스의 시간을 정한다
		time1.set(Calendar.HOUR_OF_DAY, 9);
		time1.set(Calendar.MINUTE, 30);
		time1.set(Calendar.SECOND, 30);
		
		time2.set(Calendar.HOUR_OF_DAY, 10);
		time2.set(Calendar.MINUTE, 30);
		time2.set(Calendar.SECOND, 30);
		
		// 각 시간 인스턴스의 시간을 출력한다
		System.out.println(time1.get(Calendar.HOUR_OF_DAY)+"시"+time1.get(Calendar.MINUTE)+"분"+time1.get(Calendar.SECOND)+"초");
		System.out.println(time2.get(Calendar.HOUR_OF_DAY)+"시"+time2.get(Calendar.MINUTE)+"분"+time2.get(Calendar.SECOND)+"초");
		
		// 두 시간 인터페이스의 시간차이를 계산한다.
		// getTimeInMillis활용, 1000으로 나눠줘야함 꼭
		long difference = Math.abs(time2.getTimeInMillis() - time1.getTimeInMillis())/1000;
		
		// 계산한 시간을 시분초로 변환한다.
		String tmp="";
		for(int i=0; i<TIME_UNIT.length; i++) {
			tmp += difference/TIME_UNIT[i] + TIME_UNIT_NAME[i];
			difference %= TIME_UNIT[i];
		}
		System.out.println(tmp);
		// String변수에 담아서 출력
	
	}
}

