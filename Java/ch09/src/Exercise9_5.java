public class Exercise9_5 {
	
	static String delChar(String src, String delCh) {
		// src�� delCh�� ���Ե� ���ڵ��� ����
		// delCh�� ���ŵ� ���ڵ��� ������ ����
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<src.length(); i++) {
			// src�� i��° ���ڰ� delCh�� �ش��ϴ°� �ִ��� üũ
			char ch = src.charAt(i);
			if(delCh.indexOf(ch)==-1)
				// delCh�� ��ġ�ϴ� ���ڰ� �����Ƿ� sb�� ����
				sb.append(ch);
		}
		
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		System.out.println("(1!2@3#4$5)"+" -> "+delChar("(1!2@3#4$5)", "!@#$%^&*()"));
		System.out.println("(1 2 3 4\t5)"+" -> "+delChar("(1 2 3 4\t5)", " \t"));
	}
}
