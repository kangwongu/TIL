package thirdedition.exercise;

public class Exercise4_4 {
	
	public static void main(String[] args) {
		// 1 + (1+2) + (1+2+3) + ...
		int sum = 0;		// ���� ���� ����
		int totalSum = 0;	// ������ ���� ����
		
		// 1~10���� ������ �ݺ���
		for(int i=1; i<=10; i++) {
			sum += i;			// 1, 3, 6...
			totalSum += sum;	// 1, 4, 10...
		}
		
		System.out.println(sum);
		System.out.println(totalSum);
	}

}
