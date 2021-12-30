package thirdEdition;

import java.util.Arrays;

public class ReferenceParamEx3 {
	public static void main(String[] args) {
		// 배열 생성
		int[] x = {20, 30, 10, 50, 40};
		
		// 배열 출력
		printArr(x);
		// 배열 정렬
		sortArr(x);
		// 배열 출력
		printArr(x);
		// 배열 합
		System.out.println(sumArr(x));
	}
	
	// 메소드로 구조화
	// 배열을 출력하는 메소드
	static void printArr(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	
	// 배열을 정렬하는 메소드
	static void sortArr(int[] arr) {
		Arrays.sort(arr);
	}
	
	// 배열의 총합을 구하고 합을 반환하는 메소드
	static int sumArr(int[] arr) {
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
}
