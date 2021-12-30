import java.util.Arrays;

public class Exercise6_18 {
	public static boolean isNumber(String str) {
		// ��ȿ�� �˻�
		if(str==null || str.equals(""))
			return false;
		
		// ���ڿ� �˻�
		for(int i=0; i<str.length(); i++) {
			// ���ڿ��� �� ���ڸ� ����
			char ch = str.charAt(i);
			
			// �� ���ڰ� �������� üũ, ���� �ƴϸ� false
			if(!('0' <= ch && ch <= '9'))
				return false;
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		String str = "123";
		System.out.println(str+"�� �����Դϱ�? "+isNumber(str));
		
		str = "1234o";
		System.out.println(str+"�� �����Դϱ�? "+isNumber(str));		
	
	}
}