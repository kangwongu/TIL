import java.text.DecimalFormat;
import java.text.ParseException;

public class Ex10_7 {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#,###.##");
		DecimalFormat df2 = new DecimalFormat("\u00A4 #,###");
		
		try {
			// ��ȣ�� ���ڰ� ���Ե� ���ڿ� -> ����
			Number num = df.parse("1,234,567.89");	// df�� �������� ���� �ؼ��� Number �ν��Ͻ��� ����
			System.out.print("1,234,567,89" + " -> ");
			
			int d = num.intValue();	// int������ ��ȯ
			System.out.print(d + " -> ");
			
			System.out.println(df2.format(num));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}

