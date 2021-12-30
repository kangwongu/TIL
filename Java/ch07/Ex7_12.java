public class Ex7_12 {
	// 내부 인스턴스 클래스
	class InstanceInner {
		int iv = 100;
		//static int cv = 100;
		final static int CONST = 100;
	}
	
	// 내부 스태틱 클래스
	static class StaticInner {
		int iv = 200;
		static int cv = 200;
	}
	
	void myMethod() {
		// 내부 지역 클래스
		class LocalInner {
			int iv = 300;
//			static int cv = 300;
			final static int CONST = 300;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(InstanceInner.CONST);
		System.out.println(StaticInner.cv);
	}
}
