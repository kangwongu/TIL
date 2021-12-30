package thirdEdition;

class A {
	public void methodA(B b) {
		// A가 B를 사용(의존)
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
