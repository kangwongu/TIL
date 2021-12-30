class A {
//	public void method(B b) {
//		b.method();
//	}
	public void method(I i) {	// �������̽� I�� ������ ��ü�鸸 �Ű������� ����
		i.method();
	}
	
}
// BŬ������ ����� ������ �и�
interface I {	// ������
	public void method();
}

class B implements I {	// �˸���
	@Override
	public void method() {
		System.out.println("BŬ������ �޼ҵ�");
	}
}

class C implements I {	// �˸���
	@Override
	public void method() {
		System.out.println("CŬ������ �޼ҵ�");
	}
}

public class InterfaceTest {
	public static void main(String[] args) {
		A a = new A();
		a.method(new B());	// A�� B�� ���(����)
//		a.method(new C());	// B��� C�� ����Ϸ��� 2,3���� �����ؾ���, ���Ѱ���
		// �������̽��� Ȱ��
		a.method(new C());	// C�� �������̽� I�� �����߱� ������ ����
	
	}

}

// 


