
public class Ex9_3 {
	public static void main(String[] args) {
		// equals()�޼ҵ� �������̵� -> hashCode()�޼ҵ嵵 �������̵�
		
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		String str3 = "abc";
		String str4 = "abc";
		
		
		// StringŬ������ ������ �Ǿ�����
		System.out.println(str1==str2);
		System.out.println(str3==str4);
		System.out.println(str1.equals(str2));
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
	}

}

