package thirdEdition.exercise;

public class Exercise6_23 {
	// 문자열이 숫자인지 검사, 숫자면 true, 아니면 false
	public static boolean isNumber(String str) {
		// 유효성 검사
		if(str==null || str.equals(""))
			return false;
		
		// 문자열을 순회하면서 검사
		for(int i=0; i<str.length(); i++) {
			// 문자열의 처음문자값 부터 숫자인지 검사
			char ch = str.charAt(i);
			if(!('0' <= ch && ch <= '9')) {
				return false;
			} 
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str = "123";
		System.out.println(isNumber(str));
		
		str = "12345op";
		System.out.println(isNumber(str));
	}
}


