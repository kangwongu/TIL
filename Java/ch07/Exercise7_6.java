class Outer2 {
	// 인스턴스 내부 클래스
	class Inner {
		int iv = 100;
	}
}


public class Exercise7_6 {
	public static void main(String[] args) {
		// 외부 클래스 인스턴스 생성 후 내부 클래스 사용가능
		Outer2 out = new Outer2();
		Outer2.Inner in = out.new Inner();
		System.out.println(in.iv);

	}

}
