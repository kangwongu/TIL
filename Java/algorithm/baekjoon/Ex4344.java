package baekjoon;

import java.util.Scanner;

public class Ex4344 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
		// �� ���� �׽�Ʈ �� ��?
		int testCase = scanner.nextInt();
		int[] scores;
		
		// testCase��ŭ �ݺ�
		for(int i=0; i<testCase; i++) {
			// �� ���� ������ �Է¹�����?
			scores = new int[scanner.nextInt()];
			
			double hab = 0;	// ��
			
			// ���� �Է�
			for(int j=0; j<scores.length; j++) {
				scores[j] = scanner.nextInt();
				hab += scores[j];
			}
			
			double average = hab/scores.length;	// ���
			double count = 0;					// ����� �Ѵ� �л��� ��
			
			// ����� �Ѵ� �л��� üũ
			for(int k=0; k<scores.length; k++) {
				if(scores[k] > average) 
					count++;
			}
			
			// ����� �Ѵ� �ο����� ���� ����
			System.out.printf("%.3f%%\n", (count/scores.length)*100);
		
		}
		
	}
}
