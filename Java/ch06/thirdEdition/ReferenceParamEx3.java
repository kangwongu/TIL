package thirdEdition;

import java.util.Arrays;

public class ReferenceParamEx3 {
	public static void main(String[] args) {
		// �迭 ����
		int[] x = {20, 30, 10, 50, 40};
		
		// �迭 ���
		printArr(x);
		// �迭 ����
		sortArr(x);
		// �迭 ���
		printArr(x);
		// �迭 ��
		System.out.println(sumArr(x));
	}
	
	// �޼ҵ�� ����ȭ
	// �迭�� ����ϴ� �޼ҵ�
	static void printArr(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	
	// �迭�� �����ϴ� �޼ҵ�
	static void sortArr(int[] arr) {
		Arrays.sort(arr);
	}
	
	// �迭�� ������ ���ϰ� ���� ��ȯ�ϴ� �޼ҵ�
	static int sumArr(int[] arr) {
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
}
