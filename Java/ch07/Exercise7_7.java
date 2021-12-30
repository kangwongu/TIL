class Outer3 {
	// 스태틱 내부 클래스
	static class Inner {
		int iv = 100;
	}
}


public class Exercise7_7 {
	public static void main(String[] args) {
		// 외부 클래스 인스턴스 생성없이 바로 사용가능
		Outer3.Inner in = new Outer3.Inner();
		System.out.println(in.iv);
	}

}
