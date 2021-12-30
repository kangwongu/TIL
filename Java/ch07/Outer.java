public class Outer {
	private int outerIv = 0;
	static int outerCv = 0;
	
	// 인스턴스 클래스
	class InstanceInner {
		int iiv = outerIv;
		int iiv2 = outerCv;
	}
	
	// 스태틱 클래스 
	static class StaticInner {
//		int siv = outerIv;
		static int scv = outerCv;
	}
	
	void myMethod() {
		int lv = 0;
		final int LV = 0;
		
		// 지역클래스
		class LocalInner {
			int liv = outerIv;
			int liv2 = outerCv;
			int liv3 = lv;
			int liv4 = LV;
		}
	}
	
}