package thirdedition.exercise;

public class Exercise4_9 {
	
	public static void main(String[] args) {
		String str = "12345";
		int sum = 0;
		
		// 1+2+3+4+5
		for(int i=0; i<str.length(); i++) {
			// 1. charAt()을 사용해 한 문자씩 가져온다.
			char s = str.charAt(i);
			// 2. 그 값을 int값으로 변환해 합한다.
			sum += s - '0';
		}
		
		System.out.println(sum);
	}

}
