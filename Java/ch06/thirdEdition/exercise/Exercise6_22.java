package thirdEdition.exercise;

import java.util.Arrays;

public class Exercise6_22 {
	// 매개변수로 배열을 받고 그 배열에서 최대값을 구해 반환
	public static int max(int[] arr) {
		// 유효성 검사
		if(arr==null || arr.length==0)
			return -999999;
		
		// 배열의 첫번째 요소를 최대값으로 지정
		int max = arr[0];
		
		// 배열의 두번째 요소부터 순회하며 최대값을 구함
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


