package thirdEdition;

class A2 {
	// 매개변수가 인터페이스 -> 인터페이스가 구현된 클래스만 매개변수로 ok
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
		// 객체 생성
		A2 a = new A2();
		// B2, C2는 인터페이스를 구현했기 때문에 매개변수로 OK
		a.autoPlay(new B2());
		a.autoPlay(new C2());
//		a.autoPlay(new D());
	}

}
