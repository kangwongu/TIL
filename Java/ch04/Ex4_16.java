import java.util.Scanner;

public class Ex4_16 {

	public static void main(String[] args) {
		// ����
		// ���� ���� ����, ī��Ʈ�� ����
		int sum = 0, i = 0;
		
		// ���ѷ��� ���� i�� 1�� ����
		// sum += i, sum�� 100�̻� �Ǹ� break
		while(true) {
			if(sum > 100) {
				break;
			}
			sum += ++i;
			System.out.printf("i = %d, sum = %d\n", i, sum);
		}
		System.out.println();
		System.out.println("i = " + i);
		System.out.println("sum = " + sum);
	}
}