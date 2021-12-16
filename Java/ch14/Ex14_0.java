
public class Ex14_0 {
	public static void main(String[] args) {
//		Object obj = new Object() {
//			int max(int a, int b) {
//				return a > b ? a : b;
//			}
//		};
		
		// Object는 max메소드가 없음
		//int value = obj.max(3,5);
		
		// 함수형 인터페이스의 필요성
		
//		MyFunction f = new MyFunction() {
//			public int max(int a, int b) {
//				return a > b ? a : b;
//			}
//		};
		
		// 람다식 정의
		Lambda l = (a, b) -> a+b;
		
		// 람다식 호출
		System.out.println(l.max(10, 20));
	
		Lambda2 l2 = (x, y) -> x+", "+y;
		System.out.println(l2.concat("안녕하세요", "여러분"));
	}

}

// 함수형 인터페이스
@FunctionalInterface
interface Lambda {
	int max(int a, int b);
}

interface Lambda2 {
	String concat(String a, String b);
}

