
public class Ex8_6 {
	public static void main(String[] args) {
		// ���� �߻���Ű��
		
		try {
			// 1. ����Ŭ���� ��ü�����
			RuntimeException e = new RuntimeException("���� �߻�!");
			
			// 2. throw�� ���� �߻���Ű��
			throw e;
			
//			throw new Exception("���� �߻�!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(1);
	
	}

}
