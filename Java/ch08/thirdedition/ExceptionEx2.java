package thirdedition;

public class ExceptionEx2 {
	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		
		for(int i=0; i<10; i++) {
			result = number / (int)(Math.random()*10);
			System.out.println(result);
		}
		// 0으로 나눌 경우 예외가 발생하고 프로그램이 비정상적 종료
	}

}
