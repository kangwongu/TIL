import java.text.DecimalFormat;
import java.text.ParseException;

public class Ex10_7 {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#,###.##");
		DecimalFormat df2 = new DecimalFormat("\u00A4 #,###");
		
		try {
			// 기호와 문자가 포함된 문자열 -> 숫자
			Number num = df.parse("1,234,567.89");	// df의 포맷으로 값을 해석해 Number 인스턴스에 저장
			System.out.print("1,234,567,89" + " -> ");
			
			int d = num.intValue();	// int형으로 변환
			System.out.print(d + " -> ");
			
			System.out.println(df2.format(num));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}

