package thirdEdition;

class A {
	public void methodA(B b) {
		// A�� B�� ���(����)
		b.methodB();
	}
}

class B {
	public void methodB() {
		System.out.println("methodB");
	}
}

public class InterfaceTest {
	public static void main(String[] args) {
		A a = new A();
		a.methodA(new B());
	}

}
