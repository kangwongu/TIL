package baekjoon;

import java.util.Scanner;

public class Ex2562 {
	public static void main(String[] args) {
		// �Է�
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[9];
		int max = 0;	// �ִ밪
		int idx = 0;	// ��ġ
		
		// �迭 ���̸�ŭ ������ �Է¹޾� �迭 ��ҿ� ����
		for(int i=0; i<arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		
		// �ִ� �ּҰ� ���ϱ�
		max = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
				idx = i;
			}
		}
		System.out.println(max);
		System.out.println(idx+1);
	}
}
