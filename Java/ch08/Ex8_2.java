
public class Ex8_2 {
	public static void main(String[] args) {
		// ���ڸ� 0���� ������ �߻��ϴ� ���ܸ� �߻���Ŵ
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(0/0);	// ���� �߻�! catch������ �̵�
			System.out.println(3);		// �� ������ ������� ����, 
		} catch(Exception e) {
			System.out.println(4);
			System.out.println(5);
		}
		System.out.println(6);
		
	}

}
