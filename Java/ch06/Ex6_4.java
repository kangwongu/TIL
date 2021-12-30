
public class Ex6_4 {
	public static void main(String[] args) {
		// MyMath클래스 인스턴스 생성
		MyMath mm = new MyMath();
		
		// 참조변수(리모콘)으로 인스턴스 제어
		System.out.println(mm.add(5L, 3L));
		System.out.println(mm.subtract(5L, 3L));
		System.out.println(mm.multiply(5L, 3L));
		System.out.println(mm.divide(5L, 3L));	// long을 인자로 호출했지만 자동형변환
	}
}

class MyMath {
	// 기능
	// 반환타입 long, 매개변수 2개 long타입으로 받음
	long add(long a, long b) { return a+b; }
	long subtract(long a, long b) { return a-b; }
	long multiply(long a, long b) { return a*b; }
	double divide(double a, double b) { return a/b; }
}
