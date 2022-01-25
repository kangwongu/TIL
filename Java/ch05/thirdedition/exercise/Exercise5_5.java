package thirdedition.exercise;

import java.util.Arrays;

public class Exercise5_5 {

	public static void main(String[] args) {
		int[] ballArr = {1,2,3,4,5,6,7,8,9};
		int[] ball3 = new int[3];
		
		// �迭 ballArr�� �������� ���´�
		for(int i=0; i<ballArr.length; i++) {
			// 1. �������� �޴´� (�迭�� �ڸ���)
			int idx = (int)(Math.random()*9);
			// 2. �ڸ� �ٲ� �� ���Ƿ� ��Ƴ��� ���� ����
			int temp = 0;
			// 3. �ڸ� �ٲ۴�.
			temp = ballArr[i];
			ballArr[i] = ballArr[idx];
			ballArr[idx] = temp;
		}
		
		// ballArr�迭 ���� 3�ڸ��� ball3�� ����
		ball3 = Arrays.copyOfRange(ballArr, 0, 3);
		
		System.out.println(Arrays.toString(ballArr));
		System.out.println(Arrays.toString(ball3));
	}

}
