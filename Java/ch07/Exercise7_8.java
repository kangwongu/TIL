class Outer4 {
	int value = 10;
	
	// 인스턴스 내부 클래스
	class Inner {
		int value = 20;
		void method1() {
			int value = 30;
			
			System.out.println(value);
			System.out.println(this.value);
			System.out.println(Outer4.this.value);
		}
	}
}


public class Exercise7_8 {
	public static void main(String[] args) {
		// 외부클래스 인스턴스 생성 후 내부 클래스 사용가능
		Outer4 outer = new Outer4();
		Outer4.Inner inner = outer.new Inner();
		inner.method1();
	}

}
