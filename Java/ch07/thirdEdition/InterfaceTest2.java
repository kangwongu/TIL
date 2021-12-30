package thirdEdition;

class A2 {
	// �Ű������� �������̽� -> �������̽��� ������ Ŭ������ �Ű������� ok
	void autoPlay(I i) {
		i.play();
	}
}

class B2 implements I {
	@Override
	public void play() {
		System.out.println("B play");
	}
	
}

class C2 implements I {
	@Override
	public void play() {
		System.out.println("C play");
	}
	
}

class D {
	
}

interface I {
	public abstract void play();
}

public class InterfaceTest2 {
	public static void main(String[] args) {
		// ��ü ����
		A2 a = new A2();
		// B2, C2�� �������̽��� �����߱� ������ �Ű������� OK
		a.autoPlay(new B2());
		a.autoPlay(new C2());
//		a.autoPlay(new D());
	}

}
