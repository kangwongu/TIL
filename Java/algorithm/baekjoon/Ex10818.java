package baekjoon;

import java.util.Scanner;

public class Ex10818 {
	public static void main(String[] args) {
		// �Է�
		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();
		int max = 0;
		int min = 0;
		
		// ���̸�ŭ�� �迭 ����
		int[] arr = new int[length];
		// �迭 ���̸�ŭ ������ �Է¹޾� �迭 ��ҿ� ����
		for(int i=0; i<arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		
		// �ִ� �ּҰ� ���ϱ�
		max = arr[0];
		min = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > max)
				max = arr[i];
			else if(arr[i] < min)
				min = arr[i];
		}
		
		System.out.println(min+" "+max);
	}
}
