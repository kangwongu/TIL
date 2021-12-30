package thirdEdition;

class A3 {
	void methodA() {
		I2 i = InstanceManager.getInstance();
		i.methodB();
		System.out.println(i);
	}
}

class B3 implements I2 {
	public void methodB() {
		System.out.println("methodB in Bclass");
	}
	
	public String toString() { return "class B"; }
	
}

class C3 implements I2 {
	public void methodB() {
		System.out.println("methodC in Cclass");
	}
	
	public String toString() { return "class C"; }
	
}

class InstanceManager {
	// 반환타입이 인터페이스 -> 인터페이스를 구현한 클래스를 반환
	public static I2 getInstance() {
		return new C3();
	}
}


interface I2 {
	public abstract void methodB();
}

public class InterfaceTest3 {
	public static void main(String[] args) {
		A3 a = new A3();
		a.methodA();
	}

}
