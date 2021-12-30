package thirdEdition.exercise;

import java.util.Arrays;

public class Exercise6_22 {
	// �Ű������� �迭�� �ް� �� �迭���� �ִ밪�� ���� ��ȯ
	public static int max(int[] arr) {
		// ��ȿ�� �˻�
		if(arr==null || arr.length==0)
			return -999999;
		
		// �迭�� ù��° ��Ҹ� �ִ밪���� ����
		int max = arr[0];
		
		// �迭�� �ι�° ��Һ��� ��ȸ�ϸ� �ִ밪�� ����
		for(int i=1; i<arr.length; i++) {
			if(arr[i] > max)
				max = arr[i];
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] data = {3,2,9,4,7};
		System.out.println(Arrays.toString(data));
		System.out.println(max(data));
		System.out.println(max(null));
		
	}
}


