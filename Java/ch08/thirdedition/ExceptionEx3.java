package thirdedition;

public class ExceptionEx3 {
	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		
		try {
			for(int i=0; i<10; i++) {
				result = number / (int)(Math.random()*10);
				System.out.println(result);
			}
		} catch (ArithmeticException e) {
			// 0으로 나눠지면, 화면에 0으로 출력
			System.out.println(0);
		}
	}

}
