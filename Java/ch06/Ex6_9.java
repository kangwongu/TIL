
public class Ex6_9 {
	public static void main(String[] args) {
		System.out.println(MyMath2.add(5L, 3L));
		System.out.println(MyMath2.subtract(5L, 3L));
		System.out.println(MyMath2.multiply(5L, 3L));
		System.out.println(MyMath2.divide(5L, 3L)); // 인수가 long형이지만 double로 형변환
		System.out.println(MyMath2.min(5L, 3L));
	
		MyMath2 mm = new MyMath2();
		
		mm.a = 5L;
		mm.b = 3L;
		
		System.out.println(mm.add());
		System.out.println(mm.subtract());
		System.out.println(mm.multiply());
		System.out.println(mm.divide());
	}
}

class MyMath2 {
	long a, b;
	
	long add() { return a+b; }
	long subtract() { return a-b; }
	long multiply() { return a*b; }
	double divide() { return a/b; }
	
	
	static long add(long a, long b) {return a + b;}
	static long subtract(long a, long b) { return a-b; }
	static long multiply(long a, long b) { return a*b; }
	static double divide(double a, double b) { return a/b; }
	static long min(long a, long b) { return a > b ? b : a; }
}
