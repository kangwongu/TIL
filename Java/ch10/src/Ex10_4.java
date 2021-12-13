import java.util.Calendar;

public class Ex10_4 {
	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		date.set(2019, 0, 7);
		
		System.out.println(toString(date));
		System.out.println("= 1일 후 =");
		date.add(Calendar.DATE, 25);	// 다른 필드에 영향을 미침
		System.out.println(toString(date));
		
		System.out.println("= 2달 전 =");
		date.add(Calendar.MONTH, -2);
		System.out.println(toString(date));
		
		System.out.println("= 31일 후 =");
		date.roll(Calendar.DATE, 31);	// 다른 필드에 영향을 미치지 않음
		System.out.println(toString(date));
	
		System.out.println("= 31일 후 =");
		date.add(Calendar.DATE, 31);
		System.out.println(toString(date));
	}
	

	// 날짜 출력
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR)+"년 "+(date.get(Calendar.MONTH)+1)
				+"월 "+date.get(Calendar.DATE)+"일 ";
	}
}

