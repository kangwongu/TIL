package thirdedition.exercise;

public class Exercise4_10 {
	public static void main(String[] args) {
		int num = 12345;
		int sum = 0;
		
		// 12345 -> 1,2,3,4,5�� ���� ���϶�
		// /10�� ������ 1�� �ڸ��� ���� �� ����
		
		while(num>0) {
			sum += num%10;
			num/=10;
		}
		
		System.out.println(sum);
	}
}
