
public class EX2_8 {

	public static void main(String[] args) {
		// 두 개의 int형 변수 선언
		int x = 15, y = 5;
		
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
		// 두 개의 값 교환
		// tmp라는 변수 활용
		int tmp = x;
		x = y;
		y = tmp;
		
		
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
	
	}

}
