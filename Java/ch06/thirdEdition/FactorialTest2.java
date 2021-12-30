package thirdEdition;

public class FactorialTest2 {
	public static void main(String[] args) {
		// 1~21까지 팩토리얼 구하기
		int n = 21;
		long result=0;
		for(int i=1; i<=n; i++) {
			result = factorial(i);
			
			// 팩토리얼 메소드의 유효성 검사에 걸러지면
			if(result==-1) {
				System.out.println("유효하지 않은 값"+result);
				break;
			}
			
			System.out.printf("%2d!=%20d\n", i, result);
			
		}
	}
	
	// 팩토리얼 메소드
	static int factorial(int n) {
		// 유효성 검사
		if(n<=0 || n>20) return -1;
		int result = 0;
		
		if(n<=1) return 1;
			result = n * factorial(n-1);
		
		return result;
	}

}
