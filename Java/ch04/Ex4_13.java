import java.util.Scanner;

public class Ex4_13 {

	public static void main(String[] args) {
		
		// ����
		int i=0;
		int sum=0;
		// ���� 100�� �ѱ� �� ���� ����
		while(sum<=100) {
			System.out.println(i +", " + sum);
			sum += ++i;
		}
	
	}
}