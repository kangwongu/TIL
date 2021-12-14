import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex10_9 {
	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyy�� MM�� dd��");
		DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			// ���ڿ� -> ��¥
			Date d = df.parse("2019�� 1�� 7��");
			System.out.println(df2.format(d));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}

