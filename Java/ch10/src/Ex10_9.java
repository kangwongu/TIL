import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex10_9 {
	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
		DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			// 문자열 -> 날짜
			Date d = df.parse("2019년 1월 7일");
			System.out.println(df2.format(d));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}

