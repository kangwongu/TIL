package thirdEdition.exercise;

public class Exercise6_23 {
	// ���ڿ��� �������� �˻�, ���ڸ� true, �ƴϸ� false
	public static boolean isNumber(String str) {
		// ��ȿ�� �˻�
		if(str==null || str.equals(""))
			return false;
		
		// ���ڿ��� ��ȸ�ϸ鼭 �˻�
		for(int i=0; i<str.length(); i++) {
			// ���ڿ��� ó�����ڰ� ���� �������� �˻�
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


