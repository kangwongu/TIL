import java.text.DecimalFormat;

public class Ex10_6 {
	public static void main(String[] args) {
		// DecimalFormat�ν��Ͻ� ���� -> ��ȯ�� ���� format�޼ҵ��� ���ڷ� ���� ��
		double number = 1234567.89;
		int number2 = 1234567;
		String[] pattern = {
				"0",
				"#",
				"0.0",
				"#.#",
				"00000000.0000",
				"########.####",
				"#.#-",
				"-#.#",
				"###,###",
				"#E0",
				"0E0",
				"##E0",
				"###E0",
				"#.#%",
				"\u00A4 #,###"
				
		};
		
		for(int i=0; i<pattern.length; i++) {
			// DecimalFormat �ν��Ͻ� ���� ��, �����ڷ� ������ �־���
			DecimalFormat df = new DecimalFormat(pattern[i]);
			// format�޼ҵ忡 ������ ������ ���� �־���
			System.out.printf("%19s : %s\n", pattern[i], df.format(number2));
		}
		
	}

}

