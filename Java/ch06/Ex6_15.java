
public class Ex6_15 {
	// Ŭ���� �ʱ�ȭ ��
	static {
		System.out.println("static { }");
	}
	// �ν��Ͻ� �ʱ�ȭ ��
	{
		System.out.println("{ }");
	}
	// ������
	public Ex6_15() {
		System.out.println("������");
	}
	
	
	public static void main(String[] args) {
		System.out.println("Ex6_14 bt = new Ex6_14()");
		Ex6_15 bt = new Ex6_15();
		
		System.out.println("Ex6_14 bt2 = new Ex6_14()");
		Ex6_15 bt2 = new Ex6_15();
		
	}
}

