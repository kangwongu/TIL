class A {
//	public void method(B b) {
//		b.method();
//	}
	public void method(I i) {	// 인터페이스 I를 구현한 객체들만 매개변수로 받음
		i.method();
	}
	
}
// B클래스의 선언과 구현을 분리
interface I {	// 껍데기
	public void method();
}

class B implements I {	// 알멩이
	@Override
	public void method() {
		System.out.println("B클래스의 메소드");
	}
}

class C implements I {	// 알멩이
	@Override
	public void method() {
		System.out.println("C클래스의 메소드");
	}
}

public class InterfaceTest {
	public static void main(String[] args) {
		A a = new A();
		a.method(new B());	// A가 B를 사용(의존)
//		a.method(new C());	// B대신 C를 사용하려면 2,3행을 변경해야함, 강한결합
		// 인터페이스를 활용
		a.method(new C());	// C에 인터페이스 I를 구현했기 때문에 가능
	
	}

}

// 


