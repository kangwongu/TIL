package thirdEdition.exercise;

import java.util.Arrays;

public class Exercise6_20 {
	public static void main(String[] args) {
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(original));
		
		int[] result = shuffle(original);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] shuffle(int[] arr) {
		// 유효성 검사
		if(arr==null || arr.length==0) {
			return arr;
		}
		
		// 배열을 섞기
		for(int i=0; i<arr.length; i++) {
			// 랜덤값을 받고 배열위치를 옮긴다
			int idx = (int)(Math.random()*arr.length);
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
		
		return arr;
	}
}


