
public class Exercise4_4 {

	public static void main(String[] args) {
		// Ȧ�� +, ¦��-
		// ���� 100�̻�
		int sum = 0;
		int s = 1;
		int num = 0;
		
		
		for(int i=1; sum<100; i++, s=-s) {
			num = i * s; // ���� ���� ����(��ȣ)
			sum += num;
		}
		
		System.out.printf("num : %d, sum : %d", num, sum);
		

	}

}
