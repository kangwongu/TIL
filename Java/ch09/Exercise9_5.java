public class Exercise9_5 {
	
	static String delChar(String src, String delCh) {
		// src에 delCh가 포함된 문자들을 제거
		// delCh가 제거된 문자들을 저장할 변수
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<src.length(); i++) {
			// src의 i번째 문자가 delCh에 해당하는게 있는지 체크
			char ch = src.charAt(i);
			if(delCh.indexOf(ch)==-1)
				// delCh에 일치하는 문자가 없으므로 sb에 담음
				sb.append(ch);
		}
		
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		System.out.println("(1!2@3#4$5)"+" -> "+delChar("(1!2@3#4$5)", "!@#$%^&*()"));
		System.out.println("(1 2 3 4\t5)"+" -> "+delChar("(1 2 3 4\t5)", " \t"));
	}
}
