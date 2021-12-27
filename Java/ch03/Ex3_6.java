
public class Ex3_6 {

	public static void main(String[] args) {
		int a = 20, b = 10;
		
		System.out.printf("%d + %d = %d\n", a, b, a+b);
		System.out.printf("%d - %d = %d\n", a, b, a-b);
		System.out.printf("%d * %d = %d\n", a, b, a*b);
		System.out.printf("%d / %d = %d\n", a, b, a/b);
		// 실수까지 표현하기 위해선 형변환이 필요
		System.out.printf("%d / %f = %f\n", a, (float)b, a/(float)b);	
	}

}
