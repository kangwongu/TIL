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
			// 0���� ��������, ȭ�鿡 0���� ���
			System.out.println(0);
		}
	}

}
