
public class Ex8_9 {
	// �޼ҵ忡 ���� �����ϱ�
	
	// ���� �޼ҵ�, method1 ȣ��
	public static void main(String[] args) throws Exception {
		method1();
	}
	// �޼ҵ� 1, method2 ȣ��
	static void method1() throws Exception {
		// method2���� ���ܰ� �߻��ϰ�, �޼ҵ忡 ���ܸ� �����߱� ������
		// ȣ���ϴ��ʿ��� ����ó���ؾ���
		method2();	// ���� �߻��ϴ� �޼ҵ�� ȣ���ϸ� ����ó�� �ؾ� ��
	}
	// �޼ҵ� 2, ���� �߻�
	static void method2() throws Exception {
		// checked���ܶ� ������ ����ó���ؾ���
		// ���⼱ �޼ҵ忡 ���� �������� ȣ���ϴ� ������ �ѱ�
		throw new Exception("���� �߻�!!!");
	}
}
