package thirdEdition;

import java.util.Arrays;

public class ReferenceParamEx2 {
	public static void main(String[] args) {
		// ũ�� 5�� �迭 ����
		int[] x = {1,2,3,4,5};
		System.out.println(Arrays.toString(x));
		change(x);
		System.out.println("after:"+Arrays.toString(x));
		
		
	}
	
	// �迭�� �Ű������� �޾Ƽ� �迭 ��Ҹ� �����Ű�� �޼ҵ�
	static void change(int[] arr) {
		arr[1] = 500;
		System.out.println(Arrays.toString(arr));
	}
	
}
