import java.util.Scanner;

public class Ex4_14 {

	public static void main(String[] args) {
		
		// ���ڿ��� �Է¹ް� ���ڷ� ��ȯ (���ڸ� �Է¹���)
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		int num = Integer.parseInt(input);
		
		int sum=0; 
	
		// �Է¹��� ���ڸ� ��� 10�� �������鼭 ������ ������ ���Ѵ�
		while(num!=0) {
			sum += num%10;
			System.out.printf("sum:%d, num=%d\n", sum, num);
			num /= 10;
		}
		
		System.out.println(sum);
	}
}