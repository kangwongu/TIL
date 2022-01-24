package thirdedition.exercise;

public class Exercise4_11 {
	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 1;
		int num3 = 0;
		System.out.print(num1+", "+num2);
		
		for(int i=0; i<8; i++) {
			// 1. num3의 값을 구한다.
			num3 = num1 + num2;
			System.out.print(", "+num3);
			// 2. num2 -> num1, num3 -> num2로 대입한다.
			num1 = num2;
			num2 = num3;
			
			// 3. 1,2번 반복
		}
	}
}
