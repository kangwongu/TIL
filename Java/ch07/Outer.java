public class Outer {
	private int outerIv = 0;
	static int outerCv = 0;
	
	// �ν��Ͻ� Ŭ����
	class InstanceInner {
		int iiv = outerIv;
		int iiv2 = outerCv;
	}
	
	// ����ƽ Ŭ���� 
	static class StaticInner {
//		int siv = outerIv;
		static int scv = outerCv;
	}
	
	void myMethod() {
		int lv = 0;
		final int LV = 0;
		
		// ����Ŭ����
		class LocalInner {
			int liv = outerIv;
			int liv2 = outerCv;
			int liv3 = lv;
			int liv4 = LV;
		}
	}
	
}