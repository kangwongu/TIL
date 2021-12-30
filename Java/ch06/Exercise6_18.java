import java.util.Arrays;

public class Exercise6_18 {
	public static boolean isNumber(String str) {
		// 유효성 검사
		if(str==null || str.equals(""))
			return false;
		
		// 문자열 검사
		for(int i=0; i<str.length(); i++) {
			// 문자열의 각 문자를 얻어옮
			char ch = str.charAt(i);
			
			// 각 문자가 숫자인지 체크, 숫자 아니면 false
			if(!('0' <= ch && ch <= '9'))
				return false;
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		String str = "123";
		System.out.println(str+"는 숫자입니까? "+isNumber(str));
		
		str = "1234o";
		System.out.println(str+"는 숫자입니까? "+isNumber(str));		
	
	}
}