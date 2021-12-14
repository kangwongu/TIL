import java.text.DecimalFormat;

public class Ex10_6 {
	public static void main(String[] args) {
		// DecimalFormat인스턴스 생성 -> 변환할 수를 format메소드의 인자로 넣음 끝
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
			// DecimalFormat 인스턴스 생성 시, 생성자로 패턴을 넣어줌
			DecimalFormat df = new DecimalFormat(pattern[i]);
			// format메소드에 패턴을 적용할 값을 넣어줌
			System.out.printf("%19s : %s\n", pattern[i], df.format(number2));
		}
		
	}

}

